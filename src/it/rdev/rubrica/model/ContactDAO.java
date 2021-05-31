package it.rdev.rubrica.model;

import java.util.List;

public interface ContactDAO extends DAO {

	public List<Contact> getAll();
	
}
