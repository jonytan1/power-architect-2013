/*
 * This file is part of SQL Power Library.
 *
 * SQL Power Library is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 3 of the License, or
 * (at your option) any later version.
 *
 * SQL Power Library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>. 
 */

package ca.sqlpower.sqlobject.dbmeta;

import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.ListMultimap;

import ca.sqlpower.sql.SQL;
import ca.sqlpower.sqlobject.DuplicateColumnException;
import ca.sqlpower.sqlobject.SQLColumn;
import ca.sqlpower.sqlobject.SQLObjectException;
import ca.sqlpower.sqlobject.SQLTable;

/**
 * Read table/column info from databases of Microsoft SQL Server,
 * include table logical name and column logical name
 * 
 * @author jianjun.tan
 *
 */
public class MSSQLServerDatabaseMeta implements DatabaseMeta {
    private static Logger logger = Logger.getLogger(MSSQLServerDatabaseMeta.class);

    public MSSQLServerDatabaseMeta(){}
    
    @Override
    public List<SQLTable> fetchTablesWithRemark(DatabaseMetaData dbmd,
            String catalogName, String schemaName)
            throws SQLObjectException, SQLException {
        ResultSet rs = null;
        
        ResultSet rsLogicalName = null;
        PreparedStatement psLogicalName = null;
        String catalogNamePre = ( ( catalogName != null && catalogName.length() > 0 ) ? catalogName + "." : "" );
        
        try {
            rs = dbmd.getTables(catalogName,
                    schemaName,
                    "%",
                    new String[] {"TABLE", "VIEW"});
            psLogicalName = dbmd.getConnection().prepareStatement(
                    "select CONVERT(varchar,value) from " + catalogNamePre + "sys.extended_properties a, " + catalogNamePre + "sys.tables b" 
                      + " where a.major_id = b.object_id"
                      + " and a.minor_id = 0"
                      + " and b.name=?");

            List<SQLTable> tables = new ArrayList<SQLTable>();
            while (rs.next()) {
            	// Don't load the sys tables.
            	if ( "sys".equalsIgnoreCase(rs.getString(2)) ) continue;
                String newTableName = rs.getString(3);

                SQLTable  newTable = new SQLTable(null,
                        newTableName,
                        rs.getString(5),
                        rs.getString(4),
                        false);

                psLogicalName.clearParameters();
                psLogicalName.setString(1, newTableName);
                rsLogicalName = psLogicalName.executeQuery();
                if ( rsLogicalName.next() ) {
                    newTable.setRemarks(rsLogicalName.getString(1));
                }
                rsLogicalName.close();
                
                tables.add(newTable);
            }
            return tables;
        } finally {
            if (rs != null) rs.close();
            if ( rsLogicalName != null ) rsLogicalName.close();
            if (psLogicalName != null) psLogicalName.close();
        }
    }

    @Override
    public ListMultimap<String, SQLColumn> fetchColumnsWithRemark(
            String catalog, String schema, String table, DatabaseMetaData dbmd)
            throws SQLException, DuplicateColumnException, SQLObjectException {
        ResultSet rs = null;
        
        ResultSet rsLogicalName = null;
        PreparedStatement psLogicalName = null;
        String catalogNamePre = ( ( catalog != null && catalog.length() > 0 ) ? catalog + "." : "" );

        final ListMultimap<String, SQLColumn> multimap = ArrayListMultimap.create();
         try {
            logger.debug("SQLColumn.addColumnsToTables: catalog="+catalog+"; schema="+schema);

            psLogicalName = dbmd.getConnection().prepareStatement(
                      "select CONVERT(varchar,value) from " + catalogNamePre + "sys.extended_properties a, " + catalogNamePre
                      + "sys.tables b, " + catalogNamePre + "sys.columns c" 
                      + " where a.major_id = c.object_id"
                      + " and a.minor_id = c.column_id"
                      + " and c.object_id = b.object_id"
                      + " and b.name=? and c.name = ?");
            
            rs = dbmd.getColumns(catalog, schema, table, "%");
            
            int autoIncCol = SQL.findColumnIndex(rs, "is_autoincrement");
            logger.debug("Auto-increment info column: " + autoIncCol);

            while (rs.next()) {
                logger.debug("addColumnsToTable SQLColumn constructor invocation.");
                
                String tableName = rs.getString(3);
                String colName = rs.getString(4);

                // work around oracle 8i bug: when table names are long and similar,
                // getColumns() sometimes returns columns from multiple tables!
                // XXX: should be moved to the JDBC Wrapper for Oracle
                if (tableName != null) {
                    if (table != null && !tableName.equalsIgnoreCase(table)) {
                        logger.warn("Got column "+colName+" from "+tableName
                                    +" in metadata for "+table+"; not adding this column.");
                        continue;
                    }
                } else {
                    logger.warn("Table name not specified in metadata.  Continuing anyway...");
                    continue;
                }
                
                boolean autoIncrement;
                if (autoIncCol > 0) {
                    autoIncrement = "yes".equalsIgnoreCase(rs.getString(autoIncCol));
                } else {
                    autoIncrement = false;
                }
                String nativeTypeName = rs.getString(6);

                if(nativeTypeName.indexOf('(') >= 0) {
                    nativeTypeName = nativeTypeName.substring(0, nativeTypeName.indexOf('('));
                }
                
                SQLColumn col = new SQLColumn(null,
                                              colName,  // col name
                                              rs.getInt(5), // data type (from java.sql.Types)
                                              nativeTypeName, // native type name
                                              rs.getInt(7), // column size (precision)
                                              rs.getInt(9), // decimal size (scale)
                                              rs.getInt(11), // nullable
                                              rs.getString(12) == null ? "" : rs.getString(12), // remarks
                                              rs.getString(13), // default value
                                              autoIncrement // isAutoIncrement
                                              );
                logger.debug("Precision for the column " + rs.getString(4) + " is " + rs.getInt(7));

                psLogicalName.clearParameters();
                psLogicalName.setString(1, tableName);
                psLogicalName.setString(2, colName);
                rsLogicalName = psLogicalName.executeQuery();
                if ( rsLogicalName.next() ) {
                    col.setRemarks(rsLogicalName.getString(1));
                }
                rsLogicalName.close();


                logger.debug("Adding column "+col.getName());
                
                multimap.put(tableName, col);

            }
            
            return multimap;
        } finally {
            try {
                if (rs != null) rs.close();
                if ( rsLogicalName != null ) rsLogicalName.close();
                if (psLogicalName != null) psLogicalName.close();
            } catch (SQLException ex) {
                logger.error("Couldn't close result set", ex);
            }
        }

    }

}
