package it.rdev.rubrica.ui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import it.rdev.rubrica.config.ConfigKeys;
import it.rdev.rubrica.config.Configuration;
import it.rdev.rubrica.controller.RubricaController;

public class AppFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5905890665169528519L;
	
	private RubricaController controller;

	public AppFrame() {
		controller = new RubricaController();
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(600,400);
		this.setTitle(Configuration.getInstance().getValue(ConfigKeys.APP_NAME));
		
		this.setJMenuBar(createMenuBar());
		
		this.getContentPane().setLayout(new BorderLayout());
		ContactList panel = new ContactList(controller.getContactList());
		this.getContentPane().add(
				panel
				, BorderLayout.CENTER);
	}
	
	private JMenuBar createMenuBar() {
		JMenuBar mb = new JMenuBar();
		
		JMenu contacts = new JMenu("Contatti");
		
		JMenuItem newContact = new JMenuItem("Nuovo");
		contacts.add(newContact);
		
		JMenuItem list = new JMenuItem("List contatti");
		contacts.add(list);
		
		JMenuItem exit = new JMenuItem("Esci");
		exit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(DO_NOTHING_ON_CLOSE);
			}
		});
		contacts.add(exit);
		
		mb.add(contacts);
		return mb;
	}
}
