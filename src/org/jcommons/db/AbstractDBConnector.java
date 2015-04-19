package org.jcommons.db;

import java.sql.Connection;

public abstract class AbstractDBConnector implements IDBConnector{
	
	private String url;
	private String username;
	private String password;
	private String ip;
	private String port;
	private String dbName;
	private String dbDriver;
	
	private Connection connection;
	
	
	public AbstractDBConnector(String ip,String port,String dbName,String username,String password,String dbDriver){
		this.url = ip+":"+port+"/"+dbName;
		this.username = username;
		this.password = password;
		this.dbDriver = dbDriver;
	}
	
	public AbstractDBConnector(String url,String username,String password,String dbDriver){
		this.url = url;
		this.username = username;
		this.password = password;
		this.dbDriver = dbDriver;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public String getPort() {
		return port;
	}
	public void setPort(String port) {
		this.port = port;
	}
	public String getDbName() {
		return dbName;
	}
	public void setDbName(String dbName) {
		this.dbName = dbName;
	}
}
