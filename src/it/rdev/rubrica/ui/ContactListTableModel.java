package it.rdev.rubrica.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

import it.rdev.rubrica.controller.RubricaController;
import it.rdev.rubrica.model.Contact;

public class ContactListTableModel extends AbstractTableModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1237760272664671498L;

	private static final String[] COLUMN_NAMES = new String[] {"Id", "Name", "Surname", "Detail", "Delete"};
    private static final Class<?>[] COLUMN_TYPES = new Class<?>[] {Integer.class, String.class, String.class, JButton.class,  JButton.class};
    
    private List<Contact> contacts;
    private RubricaController controller;
    
    public ContactListTableModel(List<Contact> contacts, RubricaController controller) {
    	this.contacts = contacts;
    	this.controller = controller;
    }
    
	@Override
	public int getRowCount() {
		return this.contacts.size();
	}
	
	@Override
	public String getColumnName(int columnIndex) {
        return COLUMN_NAMES[columnIndex];
    }

	@Override
	public int getColumnCount() {
		return COLUMN_NAMES.length;
	}
	
	@Override
	public Class<?> getColumnClass(int columnIndex) {
        return COLUMN_TYPES[columnIndex];
    }

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		switch (columnIndex) {
        case 0: return contacts.get(rowIndex).getId();
        case 1: return contacts.get(rowIndex).getName();
        case 2: return contacts.get(rowIndex).getSurname();
        case 4: final JButton btnRemove = new JButton(COLUMN_NAMES[columnIndex]);
        		btnRemove.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent arg0) {
                    	if( controller.removeContact(contacts.get(rowIndex)) ) {
                    		contacts.remove(contacts.get(rowIndex));
                    		fireTableDataChanged();
                    	}
                    }
                });
                return btnRemove;
        case 3: final JButton btnDetail = new JButton(COLUMN_NAMES[columnIndex]);
		        btnDetail.addActionListener(new ActionListener() {
		            public void actionPerformed(ActionEvent arg0) {
		                JOptionPane.showMessageDialog(JOptionPane.getFrameForComponent(btnDetail), 
		                        "Richiesta eliminazione contatto con ID <"+contacts.get(rowIndex).getId()+">");
		            }
		        });
		        return btnDetail;
        default: return "Error";
    }
	}

}
