package org.jcommons.db;

public interface IDBConnector<T> {
	public boolean save(T t);
	
	public boolean delete(T t);
	
	public boolean update(T t);
}
