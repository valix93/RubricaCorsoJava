package it.rdev.rubrica;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import it.rdev.rubrica.controller.RubricaController;
import it.rdev.rubrica.model.Contact;
import it.rdev.rubrica.ui.AppFrame;

public class RubricaApp {
	static RubricaController rb = new RubricaController();

	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] strings) {
		//menu();
		Set<String> emails = new HashSet<String>();
		Set<String> phones = new HashSet<String>();
		String nome = "Anna";
		String cognome="Nanni";
		String email = nome+cognome+"@gmail.com";
		emails.add(email);
		phones.add("3333333333");
		creaNuovoContattoRandom(nome, cognome, emails, phones);
		emails.removeAll(emails);
		phones.removeAll(phones);
		nome = "Bruno";
		cognome = "Barbieri";
		email = nome+cognome+"@gmail.com";
		emails.add(email);
		phones.add("320320320320");
		creaNuovoContattoRandom(nome, cognome, emails, phones);
		new AppFrame().setVisible(true);

	}
	
	public static void menu(){
		int scelta = -1;
		do {
			System.out.println("********* Menù *********");
			System.out.println("1. inserisci contatto");
			System.out.println("Digita 0 per uscire");
			System.out.print("Scegli una voce del menù: ");
			scelta = scanner.nextInt();
			if (scelta == 1) creaNuovoContatto();
			else if (scelta!=0) System.out.println("Scelta non valida");
		} while (scelta!=0);
	}

	private static void creaNuovoContatto() {
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
	}
	
	public static void creaNuovoContattoRandom(String nome, String cognome, Set<String> emails, Set<String> phones) {
		Contact contatto = new Contact();
		contatto.setName(nome);
		contatto.setSurname(cognome);
		contatto.setEmails(emails);
		contatto.setPhoneNumbers(phones);
		rb.addContact(contatto);
	}
	
}
