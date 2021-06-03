package it.rdev.rubrica.model.impl.rdbms;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import it.rdev.rubrica.config.ConfigKeys;
import it.rdev.rubrica.config.Configuration;

/**
 * 
 * DataSource per l'implementazione del DAO che sfrutta un sistema di persistenza relazionale RDBMS.
 * Si tratta di un singleton con visibilità di package, in quando non ha senso il riutilizzo in
 * un'implementazione che non prevede l'utilizzo di un RDBMS
 * 
 * @author Danilo Di Nuzzo
 *
 */
class DataSource {

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
