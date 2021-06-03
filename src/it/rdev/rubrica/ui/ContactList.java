package it.rdev.rubrica.ui;

import java.awt.BorderLayout;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

import it.rdev.rubrica.controller.RubricaController;
import it.rdev.rubrica.model.Contact;

public class ContactList extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6256963374023127146L;

	public ContactList(List<Contact> contacts, RubricaController controller) {
		super(new BorderLayout());
		JTable table = new JTable(new ContactListTableModel(contacts, controller));
		JScrollPane scrollPane = new JScrollPane(table);
        table.setFillsViewportHeight(true);
        
        TableCellRenderer buttonRenderer = new JTableButtonRenderer();
        table.getColumn("Delete").setCellRenderer(buttonRenderer);
        table.getColumn("Detail").setCellRenderer(buttonRenderer);
        
        table.addMouseListener(new JTableButtonMouseListener(table));
        
        add(scrollPane, BorderLayout.CENTER);
	}

}
