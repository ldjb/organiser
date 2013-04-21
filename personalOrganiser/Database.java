package personalOrganiser;

import java.util.ArrayList;

/**
 * Stores lists of all current {@link Appointment}, {@link Contact} and {@link TodoList} objects.
 * @author Alexander
 * @version 1.0
 */
public class Database {

	private ArrayList<Contact> contacts;
	
	public Database() {
		this.contacts = new ArrayList<Contact>();
	}
	
	public void addContact(Contact contact) {
		this.contacts.add(contact);
	}
	
	public void addContact(String firstName, String lastName) {
		this.contacts.add(new Contact(firstName, lastName));
	}
	
	public String getAllContacts() {
		String temp = "";
		for (int index = 0; index < this.contacts.size(); index++) {
			temp = temp + "\n\n" + this.contacts.get(index);
		}
		return temp.substring(2);
	}
}