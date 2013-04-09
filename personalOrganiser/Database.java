package personalOrganiser;

import java.util.ArrayList;

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