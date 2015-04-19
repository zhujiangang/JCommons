package org.jcommons.db;

public class SimpleDBConnector extends AbstractDBConnector{

	public SimpleDBConnector(String url, String username, String password,String dbDriver) {
		super(url, username, password, dbDriver);
		// TODO Auto-generated constructor stub
	}
	
	public SimpleDBConnector(String ip,String port,String dbName,String username,String password,String dbDriver){
		super(ip, port, dbName, username, password, dbDriver);
	}
	
	@Override
	public boolean save(Object t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Object t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Object t) {
		// TODO Auto-generated method stub
		return false;
	}
}
