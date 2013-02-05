package ca.sqlpower.sql;

import java.sql.Types;

/**
 * This class helps with SQL syntax when creating and altering columns
 * in PostgreSQL.
 *
 * @author Jonathan Fuerth
 * @version $Id: PostgreSQLTypeConverter.java 222 2003-03-03 18:07:11Z fuerth $
 */
public class PostgreSQLTypeConverter extends SqlTypeConverter {

	/**
	 * Overrides the superclass's convertType method where required by
	 * PostgreSQL syntax.
	 */
	public String convertType(int sqlType, int precision, int scale) {
		switch (sqlType) {

		case Types.SMALLINT:
			return "SMALLINT";

		case Types.INTEGER:
			return "INTEGER";

		case Types.FLOAT:
			return "REAL";

		case Types.DOUBLE:
		case Types.REAL:
			return "DOUBLE PRECISION";

		case Types.NUMERIC:
			return "NUMERIC("+precision+","+scale+")";

		default:
			return super.convertType(sqlType, precision, scale);
		}
	}
}
