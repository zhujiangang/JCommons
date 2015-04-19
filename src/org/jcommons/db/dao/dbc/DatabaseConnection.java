package org.jcommons.db.dao.dbc;

import java.sql.Connection;

public interface DatabaseConnection {
	public Connection getConnection();
	public void close() throws Exception;
}
