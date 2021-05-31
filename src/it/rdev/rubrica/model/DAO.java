package it.rdev.rubrica.model;

import java.sql.SQLException;

public interface DAO<T> {
	
	boolean persist(T t) throws SQLException;
	
	boolean delete(T t) throws SQLException;
	
	boolean update(T t) throws SQLException;
	
}
