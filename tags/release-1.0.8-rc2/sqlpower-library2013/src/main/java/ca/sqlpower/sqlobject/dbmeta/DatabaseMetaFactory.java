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

/**
 * The DatabaseMetaFactory is the factory to create the
 * object of class which implement interface {@link IDatabaseMeta}.
 * We can get the tables info and columns info from this object.
 * Example for getting tables info:
 * <code>
 *     	IDatabaseMeta dm = DatabaseMetaFactory.creator(dbmd.getDatabaseProductName());
 *     	return dm.fetchTablesWithLogicalName(dbmd, catalogName, schemaName);
 * </code>
 * Example for getting columns info:
 * <code>
 *     	IDatabaseMeta dm = DatabaseMetaFactory.creator(dbmd.getDatabaseProductName());
 *     return dm.fetchColumnsWithLogicalName(catalog, schema, table, dbmd);
 * </code>
 * 
 * And, we should input some thing into the resource file 
 * ca.sqlpower.sqlobject.dbmeta.messages.properties.
 * The format is:
 * 		#SQLDatabase.dbmeta.{dbproductname}={class name which implement interface ca.sqlpower.sqlobject.dbmeta.IDatabaseMeta }
 * For example:
 * 		SQLDatabase.dbmeta.MySQL=ca.sqlpower.sqlobject.dbmeta.MySQLDatabaseMeta
 * 
 * {dbproductname} is equal to dbmd.getDatabaseProductName() (and trim all the space character in the string)
 * 
 * @author jianjun.tan
 * 
 */
import java.util.MissingResourceException;

import org.apache.log4j.Logger;

import ca.sqlpower.sqlobject.SQLTable;

public class DatabaseMetaFactory {

	private static Logger logger = Logger.getLogger(DatabaseMetaFactory.class);
	
	public static IDatabaseMeta creator( String databaseProductName ){
		String key = null;
		if ( databaseProductName != null ) key = "SQLDatabase.dbmeta." + databaseProductName.replace(" ", "");
		
		if ( logger.isDebugEnabled() ) logger.debug("Create DatabaseMeta for database product : \"" + databaseProductName + "\"");
		
		try {
			if ( key != null ){
				Class<?> c = Class.forName(Messages.getString(key));
				return (IDatabaseMeta)c.newInstance();
			}
		} catch (MissingResourceException e) {
		} catch (Exception e) {
			if ( logger.isDebugEnabled() ) logger.debug("Please add the DatabaseMeta info into the messages.properties for database product : \"" + key + "\"" );
			logger.error("Fail to create IDatabaseMeta class for \"" + key + "\":" + e.toString() );
		}
		
		return new NormalDatabaseMeta() ;
	}
}
