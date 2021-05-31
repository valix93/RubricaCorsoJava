package it.rdev.rubrica.model.impl.rdbms;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import it.rdev.rubrica.model.Contact;
import it.rdev.rubrica.model.ContactDAO;

public class ContactDAOImpl extends AbstractDAO<Contact> implements ContactDAO {
	
	private final String TABLE_NAME = "contacts";

	public List<Contact> getAll() {
		List<Contact> contacts = new ArrayList<>();
		try {
			ResultSet rs = this.executeQuery("SELECT id, name, surname FROM " + TABLE_NAME);
			while(rs.next()) {
				contacts.add(
						new Contact()
						.setId(rs.getInt("id"))
						.setName(rs.getString("name"))
						.setSurname(rs.getString("surname")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return contacts;
	}

	@Override
	public boolean persist(Contact o) throws SQLException {
		return false;
	}

	@Override
	public boolean delete(Contact t) throws SQLException {
		return false;
	}

	@Override
	public boolean update(Contact t) throws SQLException {
		return false;
	}

}
