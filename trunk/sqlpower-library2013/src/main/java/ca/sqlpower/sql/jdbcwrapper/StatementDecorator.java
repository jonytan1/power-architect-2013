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
package ca.sqlpower.sql.jdbcwrapper;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.sql.Statement;

public abstract class StatementDecorator implements Statement {

	public boolean isClosed() throws SQLException {
		throw new UnsupportedOperationException("Currently it is only possible to wrap JDBC 3.");
	}

	public boolean isPoolable() throws SQLException {
		throw new UnsupportedOperationException("Currently it is only possible to wrap JDBC 3.");
	}

	public void setPoolable(boolean poolable) throws SQLException {
		throw new UnsupportedOperationException("Currently it is only possible to wrap JDBC 3.");
	}

	public boolean isWrapperFor(Class<?> iface) throws SQLException {
		throw new UnsupportedOperationException("Currently it is only possible to wrap JDBC 3.");
	}

	public <T> T unwrap(Class<T> iface) throws SQLException {
		throw new UnsupportedOperationException("Currently it is only possible to wrap JDBC 3.");
	}

	/**
	 * The statement to which all Statement operations are delegated.
	 */
	private Statement stmt;
	
	/**
	 * The ConnectionDecorator associated with this statement.
	 */
	private ConnectionDecorator con;
	
	protected StatementDecorator(ConnectionDecorator connection, Statement statement) {
		this.con = connection;
		this.stmt = statement;
		
		con.incrementOpenStatements();
	}

	/**
	 * @param rs The result set returned by the underlying statement. This value
	 * can be null if the statement that was executed returned a row count, from an
	 * inset or update, that had no result set.
	 */
	protected abstract ResultSet makeResultSetDecorator(ResultSet rs);
	
	// ================= The Statement Interface is implemented below this line ============

	public void addBatch(String sql) throws SQLException {
		stmt.addBatch(sql);
	}

	public void cancel() throws SQLException {
		stmt.cancel();
	}

	public void clearBatch() throws SQLException {
		stmt.clearBatch();
	}

	public void clearWarnings() throws SQLException {
		stmt.clearWarnings();
	}

	public void close() throws SQLException {
		con.decrementOpenStatements();
		stmt.close();
	}

	public boolean execute(String sql, int autoGeneratedKeys) throws SQLException {
		return stmt.execute(sql, autoGeneratedKeys);
	}

	public boolean execute(String sql, int[] columnIndexes) throws SQLException {
		return stmt.execute(sql, columnIndexes);
	}

	public boolean execute(String sql, String[] columnNames) throws SQLException {
		return stmt.execute(sql, columnNames);
	}

	public boolean execute(String sql) throws SQLException {
		return stmt.execute(sql);
	}

	public int[] executeBatch() throws SQLException {
		return stmt.executeBatch();
	}

	public ResultSet executeQuery(String sql) throws SQLException {
		return makeResultSetDecorator(stmt.executeQuery(sql));
	}

	public int executeUpdate(String sql, int autoGeneratedKeys) throws SQLException {
		return stmt.executeUpdate(sql, autoGeneratedKeys);
	}

	public int executeUpdate(String sql, int[] columnIndexes) throws SQLException {
		return stmt.executeUpdate(sql, columnIndexes);
	}

	public int executeUpdate(String sql, String[] columnNames) throws SQLException {
		return stmt.executeUpdate(sql, columnNames);
	}

	public int executeUpdate(String sql) throws SQLException {
		return stmt.executeUpdate(sql);
	}

	public Connection getConnection() throws SQLException {
		return con;
	}

	public int getFetchDirection() throws SQLException {
		return stmt.getFetchDirection();
	}

	public int getFetchSize() throws SQLException {
		return stmt.getFetchSize();
	}

	public ResultSet getGeneratedKeys() throws SQLException {
		return makeResultSetDecorator(stmt.getGeneratedKeys());
	}

	public int getMaxFieldSize() throws SQLException {
		return stmt.getMaxFieldSize();
	}

	public int getMaxRows() throws SQLException {
		return stmt.getMaxRows();
	}

	public boolean getMoreResults() throws SQLException {
		return stmt.getMoreResults();
	}

	public boolean getMoreResults(int current) throws SQLException {
		return stmt.getMoreResults(current);
	}

	public int getQueryTimeout() throws SQLException {
		return stmt.getQueryTimeout();
	}

	public ResultSet getResultSet() throws SQLException {
		return makeResultSetDecorator(stmt.getResultSet());
	}

	public int getResultSetConcurrency() throws SQLException {
		return stmt.getResultSetConcurrency();
	}

	public int getResultSetHoldability() throws SQLException {
		return stmt.getResultSetHoldability();
	}

	public int getResultSetType() throws SQLException {
		return stmt.getResultSetType();
	}

	public int getUpdateCount() throws SQLException {
		return stmt.getUpdateCount();
	}

	public SQLWarning getWarnings() throws SQLException {
		return stmt.getWarnings();
	}

	public void setCursorName(String name) throws SQLException {
		stmt.setCursorName(name);
	}

	public void setEscapeProcessing(boolean enable) throws SQLException {
		stmt.setEscapeProcessing(enable);
	}

	public void setFetchDirection(int direction) throws SQLException {
		stmt.setFetchDirection(direction);
	}

	public void setFetchSize(int rows) throws SQLException {
		stmt.setFetchSize(rows);
	}

	public void setMaxFieldSize(int max) throws SQLException {
		stmt.setMaxFieldSize(max);
	}

	public void setMaxRows(int max) throws SQLException {
		stmt.setMaxRows(max);
	}

	public void setQueryTimeout(int seconds) throws SQLException {
		stmt.setQueryTimeout(seconds);
	}
}
