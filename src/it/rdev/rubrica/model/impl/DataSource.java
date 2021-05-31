package it.rdev.rubrica.model.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import it.rdev.rubrica.config.ConfigKeys;
import it.rdev.rubrica.config.Configuration;

public class DataSource {

	private static DataSource ds;
	
	public static DataSource getInstance() {
		if(ds == null) {
			ds = new DataSource();
		}
		return ds;
	}
	
	private Connection conn;
	
	private DataSource() {
		try {
			Class.forName( Configuration.getInstance().getValue(
						ConfigKeys.DB_CLASS
					) );
			
			conn = DriverManager.getConnection(  
					Configuration.getInstance().getValue(ConfigKeys.DB_HOST) + ":" +
					Configuration.getInstance().getValue(ConfigKeys.DB_PORT) + "/" +
					Configuration.getInstance().getValue(ConfigKeys.DB_NAME),
					Configuration.getInstance().getValue(ConfigKeys.DB_USER),
					Configuration.getInstance().getValue(ConfigKeys.DB_PASS)
					);  
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} 
	}
	
	public Connection getConnection() {
		return conn;
	}
	
	@Override
	protected void finalize() {
		if( conn != null ) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
