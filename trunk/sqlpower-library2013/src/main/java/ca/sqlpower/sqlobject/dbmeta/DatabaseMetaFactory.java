package ca.sqlpower.sqlobject.dbmeta;

import org.apache.log4j.Logger;

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
		} catch (Exception e) {
			if ( logger.isDebugEnabled() ) logger.debug("Please add the DatabaseMeta info into the messages.properties for database product : \"" + key + "\"" );
			logger.error("Fail to create IDatabaseMeta class for \"" + key + "\":" + e.toString() );
		}
		
		return new NormalDatabaseMeta() ;
	}
}
