package org.jcommons.db.dao.dbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class MySQLDatabaseConnection implements DatabaseConnection{
	private static final String DBDRIVER = "org.gjt.mm.mysql.Driver";
	private static final String DBURL = "jdbc:mysql://localhost:3306/test";
	private static final String DBUSER = "root";
	private static final String DBPASSWORD = "admin";
	
	private Connection conn = null;
	
	public MySQLDatabaseConnection() throws Exception{
		try {
			Class.forName(DBDRIVER);
			this.conn = DriverManager.getConnection(DBURL, DBUSER, DBPASSWORD);
		} catch (Exception e) {
			// TODO: handle exception
			throw e;
		}
	}
	
	public Connection getConnection(){
		return this.conn;
	}
	
	public void close() throws Exception{
		if(this.conn!=null){
			try {
				this.conn.close();
			} catch (Exception e) {
				// TODO: handle exception
				throw e;
			}
		}
	}
}
