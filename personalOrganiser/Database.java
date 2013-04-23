package personalOrganiser;

import java.util.ArrayList;

/**
 * Stores lists of all current {@link Appointment}, {@link Contact} and {@link TodoList} objects.
 * @author Alexander
 * @version 1.1
 */
public class Database {

	private ArrayList<Appointment> appointments;
	private ArrayList<Contact> contacts;
	private ArrayList<TodoList> todoLists;
	
	public Database() {
		this.appointments = new ArrayList<Appointment>();
		this.contacts = new ArrayList<Contact>();
		this.todoLists = new ArrayList<TodoList>();
	}
	
	public void addAppointment(Appointment appointment) {
		this.appointments.add(appointment);
	}
	
	public void addAppointment(String title) {
		try {
			this.appointments.add(new Appointment(title));
		} catch (Exception e) {
			System.err.println("Encountered An Error:");
			e.printStackTrace();
		}
	}
	
	public boolean removeAppointment(Appointment appointment) {
		return this.appointments.remove(appointment);
	}
	
	public int getAppointmentsSize() {
		return this.appointments.size();
	}
	
	public Appointment getAppointment(int index) {
		return this.appointments.get(index);
	}
	
	public String getAllAppointments() {
		String temp = "";
		for (int index = 0; index < this.appointments.size(); index++) {
			temp = temp + "\n\n" + this.appointments.get(index);
		}
		return temp.substring(2);
	}
	
	public void addContact(Contact contact) {
		this.contacts.add(contact);
	}
	
	public void addContact(String firstName, String lastName) {
		this.contacts.add(new Contact(firstName, lastName));
	}
	
	public boolean removeContact(Contact contact) {
		return this.contacts.remove(contact);
	}
	
	public int getContactsSize() {
		return this.contacts.size();
	}
	
	public Contact getContact(int index) {
		return this.contacts.get(index);
	}
	
	public String getAllContacts() {
		String temp = "";
		for (int index = 0; index < this.contacts.size(); index++) {
			temp = temp + "\n\n" + this.contacts.get(index);
		}
		return temp.substring(2);
	}
	
	public void addTodoList() {
		this.todoLists.add(new TodoList());
	}
	
	public void addTodoList(TodoList todoList) {
		this.todoLists.add(todoList);
	}
	
	public boolean removeTodoList(TodoList todoList) {
		return this.todoLists.remove(todoList);
	}
	
	public int getTodoListsSize() {
		return this.todoLists.size();
	}
	
	public TodoList getTodoList(int index) {
		return this.todoLists.get(index);
	}
	
	public String getAllTodoLists() {
		String temp = "";
		for (int index = 0; index < this.todoLists.size(); index++) {
			temp = temp + "\n\n" + this.todoLists.get(index);
		}
		return temp.substring(2);
	}
}