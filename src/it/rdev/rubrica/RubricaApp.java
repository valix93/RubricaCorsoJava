package it.rdev.rubrica;

import java.util.HashSet;
import java.util.Set;

import it.rdev.rubrica.controller.RubricaController;
import it.rdev.rubrica.model.Contact;
import it.rdev.rubrica.ui.AppFrame;

public class RubricaApp {

	public static void main(String[] strings) {
		new AppFrame().setVisible(true);
		Set<String> phone_numbersO1 = new HashSet<String>();
		phone_numbersO1.add("3344334433");
		Set<String> phone_numbersO2 = new HashSet<String>();
		phone_numbersO2.add("3333333333");

		Set<String> emailsO1 = new HashSet<String>();
		Set<String> emailsO2 = new HashSet<String>();

		emailsO1.add("giuseppe.garibaldi@email.it");
		emailsO2.add("pippo.franco@email.it");

		Contact o1 = new Contact()
					.setName("Giuseppe")
					.setSurname("Garibaldi")
					.setPhoneNumbers(phone_numbersO1)
					.setEmails(emailsO1);
		
		Contact o2 = new Contact()
				.setName("Pippo")
				.setSurname("Franco")
				.setPhoneNumbers(phone_numbersO2)
				.setEmails(emailsO2);

		// TODO contatti da scanner
		RubricaController rb = new RubricaController();
		
		rb.addContact(o1);
		rb.addContact(o2);
	}
	
}
