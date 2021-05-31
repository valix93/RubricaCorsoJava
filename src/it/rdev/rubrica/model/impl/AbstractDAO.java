package it.rdev.rubrica.model.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import it.rdev.rubrica.model.DAO;

public abstract class AbstractDAO implements DAO {
	
	protected ResultSet executeQuery(String query) throws SQLException {
		return DataSource.getInstance().getConnection().createStatement().executeQuery(query);
	}
	
	protected ResultSet executeQuery(String query, Object ... params) throws SQLException {
		Connection conn = DataSource.getInstance().getConnection();
		PreparedStatement ps = conn.prepareStatement(query);
		for(int i = 1; i < params.length; i++) {
			ps.setObject(i, params[i]);
		}
		return ps.executeQuery();
	}

}
