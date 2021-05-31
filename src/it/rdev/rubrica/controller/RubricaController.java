package it.rdev.rubrica.controller;

import java.util.List;

import it.rdev.rubrica.model.Contact;
import it.rdev.rubrica.model.ContactDAO;
import it.rdev.rubrica.model.impl.ContactDAOImpl;

public class RubricaController {
	
	private ContactDAO dao;
	
	public RubricaController() {
		dao = new ContactDAOImpl();
	}

	public List<Contact> getContactList() {
		return dao.getAll();
	}
}
