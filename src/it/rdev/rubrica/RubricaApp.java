package it.rdev.rubrica;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import it.rdev.rubrica.config.ConfigKeys;
import it.rdev.rubrica.config.Configuration;
import it.rdev.rubrica.controller.RubricaController;
import it.rdev.rubrica.model.Contact;
import it.rdev.rubrica.ui.AppFrame;

public class RubricaApp {
	static RubricaController rb = new RubricaController();

	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] strings) {
		String persistenceType =Configuration.getInstance().getValue(ConfigKeys.PERSISTENCE_TYPE);
		Set<String> emails = new HashSet<String>();
		Set<String> phones = new HashSet<String>();
		String nome = "Anna";
		String cognome="Nanni";
		String email = nome+cognome+"@gmail.com";
		emails.add(email);
		phones.add("3333333333");
		creaNuovoContatto(costruisciContatto(nome, cognome, emails, phones));
		
		emails.removeAll(emails);
		phones.removeAll(phones);
		nome = "Bruno";
		cognome = "Barbieri";
		email = nome+cognome+"@gmail.com";
		emails.add(email);
		phones.add("320320320320");
		creaNuovoContatto(costruisciContatto(nome, cognome, emails, phones));
		cancellaContatto(costruisciContatto(nome, cognome, emails, phones));
		if (persistenceType.equals("RDBMS")) {
			new AppFrame().setVisible(true);
		}
	}
	
	public static Contact costruisciContatto(String nome, String cognome, Set<String> emails, Set<String> phones){
		Contact contatto = new Contact();
		contatto.setName(nome);
		contatto.setSurname(cognome);
		contatto.setEmails(emails);
		contatto.setPhoneNumbers(phones);
		return contatto;
	}

	public static void creaNuovoContatto (Contact contatto){
		rb.addContact(contatto);
	}
	
	public static void cancellaContatto(Contact contatto) {
		rb.removeContactByEmails(contatto);
	}
	

	/*private static void creaNuovoContattoScanner() {
		System.out.println("Inserisci un nuovo contatto");
		Contact contatto = new Contact();
		Set<String> emails = new HashSet<String>();
		Set<String> phones = new HashSet<String>();
		System.out.print("Nome: ");
		String nome = scanner.next();
		System.out.print("Cognome: ");
		String cognome = scanner.next();
		System.out.print("Numero di telefono: ");
		String numero = scanner.next();
		phones.add(numero);
		System.out.print("Email: ");
		String email = scanner.next();
		emails.add(email);
		contatto.setName(nome);
		contatto.setSurname(cognome);
		contatto.setPhoneNumbers(phones);
		contatto.setEmails(emails);
		rb.addContact(contatto);
	}*/
	
}
