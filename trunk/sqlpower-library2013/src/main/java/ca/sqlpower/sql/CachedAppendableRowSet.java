package ca.sqlpower.sql;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

public class CachedAppendableRowSet extends CachedRowSet {
	private static final Logger logger = Logger.getLogger(CachedAppendableRowSet.class);
	private boolean makeUppercase = true;
	
	public void append(ResultSet rs) throws SQLException {
		append(rs,null);
	}
	
	/**
	 * Unsupport extraColNames.
	 * @param rs
	 * @param filter
	 * @throws SQLException
	 */
	public void append(ResultSet rs, RowFilter filter) throws SQLException {
		if (rsmd == null ) {
			throw new SQLException("populate first please.");
		}
    	int rsColCount = rsmd.getColumnCount();
    	int colCount = rsColCount;

		int rowNum = super.size();

		if (rs.getType() != ResultSet.TYPE_FORWARD_ONLY) {
			rs.beforeFirst();
		}
		
		while (rs.next()) {
		    if (logger.isDebugEnabled()) logger.debug("Populating Row "+rowNum);
			Object[] row = new Object[colCount];
			for (int i = 0; i < rsColCount; i++) {
				Object o = rs.getObject(i+1);
				if (o == null) {
				    if (logger.isDebugEnabled()) logger.debug("   Col "+i+": null");
				} else {
				    if (logger.isDebugEnabled()) logger.debug("   Col "+i+": "+o+" ("+o.getClass()+")");
				}				
				row[i] = o;
			}
            
            if (filter == null || filter.acceptsRow(row)) {
            	synchronized (data) {
            		data.add(row);
            		rowNum++;					
				}
            } else {
                logger.debug("Skipped this row (rejected by filter)");
            }
		}
	}
	
	@Override
	public void setMakeUppercase(boolean makeUppercase) {
		this.makeUppercase = makeUppercase;
		super.setMakeUppercase(this.makeUppercase);
	}
}
