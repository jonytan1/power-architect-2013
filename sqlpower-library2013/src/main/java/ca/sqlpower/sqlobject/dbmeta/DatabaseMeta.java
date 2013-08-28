/*
 *
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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.google.common.collect.ListMultimap;

import ca.sqlpower.sqlobject.DuplicateColumnException;
import ca.sqlpower.sqlobject.SQLColumn;
import ca.sqlpower.sqlobject.SQLObjectException;
import ca.sqlpower.sqlobject.SQLTable;

/**
 * Interface of the table/column info reader for databases of Microsoft SQL Server,
 * include table logical name and column logical name
 * 
 * defalut is {@link GenericDatabaseMeta}
 * 
 * @author jianjun.tan
 *
 */

public interface DatabaseMeta {

    /*
     * Fetch table info from database, include logical name.
     */
    public List<SQLTable> fetchTablesWithRemark(
            DatabaseMetaData dbmd, String catalogName, String schemaName)
                    throws SQLObjectException, SQLException;
    
    /*
     * Fetch columns info of a table from database, include logical name.
     */
    public ListMultimap<String, SQLColumn> fetchColumnsWithRemark(
            String catalog,
            String schema,
            String table,
            DatabaseMetaData dbmd) 
                    throws SQLException, DuplicateColumnException, SQLObjectException;
    
    /**
     * fetch exportedKeys which across schemas.
     * Some DB don't support to fetch these exportedKeys by {@link DatabaseMetaData.getExportedKeys},
     * for example MySQL.
     * @param dbmd
     * @param catalog
     * @param schema
     * @param table
     * @return
     */
    public ResultSet fetchExportedKeysAcrossSchemas(DatabaseMetaData dbmd,
    		String catalog, String schema, String table) throws SQLException;
    
}
