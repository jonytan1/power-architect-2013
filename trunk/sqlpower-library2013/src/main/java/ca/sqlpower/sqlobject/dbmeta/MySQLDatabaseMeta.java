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

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ca.sqlpower.sql.CachedRowSet;
import ca.sqlpower.sqlobject.SQLObjectException;
import ca.sqlpower.sqlobject.SQLTable;

/**
 * Read table/column info from databases of Microsoft SQL Server,
 * include table logical name
 * 
 * @author jianjun.tan
 *
 */
public class MySQLDatabaseMeta extends GenericDatabaseMeta  {

    public MySQLDatabaseMeta(){}
    
    @Override
    public List<SQLTable> fetchTablesWithRemark(DatabaseMetaData dbmd,
            String catalogName, String schemaName)
            throws SQLObjectException, SQLException {
        ResultSet rs = null;
        
        ResultSet rsLogicalName = null;
        PreparedStatement psLogicalName = null;
        
        try {
            rs = dbmd.getTables(catalogName,
                    schemaName,
                    "%",
                    new String[] {"TABLE", "VIEW"});
            Connection con = dbmd.getConnection();
            if ( catalogName != null && !catalogName.equalsIgnoreCase(con.getCatalog())){
            	con.setCatalog(catalogName);
            }
            psLogicalName = con.prepareStatement(
                    "SHOW TABLE STATUS LIKE ?");

            List<SQLTable> tables = new ArrayList<SQLTable>();
            while (rs.next()) {
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
                    newTable.setRemarks(rsLogicalName.getString(18));
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
	public ResultSet fetchExportedKeysAcrossSchemas(DatabaseMetaData dbmd,
			String catalog, String schema, String table) throws SQLException {
		ResultSet rs = null;
		Statement stmt = null;
		CachedRowSet result = new CachedRowSet();
		try {
			Connection con = dbmd.getConnection();
			stmt = con.createStatement();
			StringBuilder sql = new StringBuilder();
			sql.append("select c.REFERENCED_TABLE_SCHEMA PKTABLE_CAT, null PKTABLE_SCHEM, c.REFERENCED_TABLE_NAME PKTABLE_NAME, ");
			sql.append("c.REFERENCED_COLUMN_NAME PKCOLUMN_NAME, c.TABLE_SCHEMA FKTABLE_CAT, null FKTABLE_SCHEM, ");
			sql.append("c.TABLE_NAME FKTABLE_NAME, c.COLUMN_NAME FKCOLUMN_NAME, ");
			sql.append("1 KEY_SEQ, CASE b.UPDATE_RULE WHEN 'CASCADE' THEN 0 WHEN 'SET NULL' THEN 2 WHEN 'RESTRICT' THEN 1 ELSE 3 END UPDATE_RULE, ");
			sql.append("CASE b.DELETE_RULE WHEN 'CASCADE' THEN 0 WHEN 'SET NULL' THEN 2 WHEN 'RESTRICT' THEN 1 ELSE 3 END DELETE_RULE, ");
			sql.append("c.CONSTRAINT_NAME FK_NAME , null PK_NAME, 7 DEFERRABILITY ");
			sql.append("from information_schema.TABLE_CONSTRAINTS a, information_schema.REFERENTIAL_CONSTRAINTS b, information_schema.KEY_COLUMN_USAGE c ");
			sql.append("where a.CONSTRAINT_schema=b.CONSTRAINT_schema ");
			sql.append("and a.CONSTRAINT_NAME=b.CONSTRAINT_NAME ");
			sql.append("and a.CONSTRAINT_TYPE='FOREIGN KEY' ");
			sql.append("and c.REFERENCED_TABLE_SCHEMA <> c.TABLE_SCHEMA ");
			sql.append("and b.UNIQUE_CONSTRAINT_SCHEMA='" + catalog + "' ");
			sql.append("and b.REFERENCED_TABLE_NAME='" + table + "' ");
			sql.append("and b.CONSTRAINT_schema = c.CONSTRAINT_schema ");
			sql.append("and b.CONSTRAINT_NAME = c.CONSTRAINT_NAME ");
			sql.append("order by c.CONSTRAINT_schema, c.CONSTRAINT_NAME, c.TABLE_NAME; ");	
			result.populate(stmt.executeQuery(sql.toString()));
		} finally {
            if (rs != null) {
            	rs.close();
            }
            if (stmt != null) {
            	stmt.close();
            }
        }
		return result;
	}
}
