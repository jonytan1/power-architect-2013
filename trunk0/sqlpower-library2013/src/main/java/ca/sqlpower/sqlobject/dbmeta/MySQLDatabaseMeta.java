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

import ca.sqlpower.sqlobject.SQLObjectException;
import ca.sqlpower.sqlobject.SQLTable;

/**
 * Read table/column info from databases of Microsoft SQL Server,
 * include table logical name
 * 
 * @author jianjun.tan
 *
 */
public class MySQLDatabaseMeta extends NormalDatabaseMeta  {

	public MySQLDatabaseMeta(){}
	
	@Override
	public List<SQLTable> fetchTablesWithLogicalName(DatabaseMetaData dbmd,
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
            psLogicalName = dbmd.getConnection().prepareStatement(
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
                	newTable.setLogicalName(rsLogicalName.getString(18));
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

}
