/*
 * Copyright (c) 2008, SQL Power Group Inc.
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
import java.sql.SQLException;
import java.util.List;

import com.google.common.collect.ListMultimap;

import ca.sqlpower.sqlobject.DuplicateColumnException;
import ca.sqlpower.sqlobject.SQLColumn;
import ca.sqlpower.sqlobject.SQLObjectException;
import ca.sqlpower.sqlobject.SQLTable;

public interface IDatabaseMeta {

	/*
	 * Fetch table info from database, include logical name.
	 */
	public List<SQLTable> fetchTablesWithLogicalName(DatabaseMetaData dbmd, String catalogName, String schemaName)
		    throws SQLObjectException, SQLException;
	
	/*
	 * Fetch columns info of a table from database, include logical name.
	 */
	public ListMultimap<String, SQLColumn> fetchColumnsWithLogicalName(
            String catalog,
            String schema,
            String table,
            DatabaseMetaData dbmd) 
            		throws SQLException, DuplicateColumnException, SQLObjectException;
	
}
