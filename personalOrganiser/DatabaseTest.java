package personalOrganiser;

import org.junit.*;

import static org.junit.Assert.*;

/**
 * Test cases for the {@link Database}
 * @author Alexander
 * @version 1.0
 */
public class DatabaseTest {
	
	public Database db;
	
	@Before
	public void setup() {
		db = new Database();
		db.addAppointment("Appointment 1");
		db.addContact("Contact", "1");
		db.addTodoList();
	}
	
	//Test 10.1.1
	@Test
	public void test_createAppointment()
			throws PersonalOrganiserError.EmptyStringException, PersonalOrganiserError.CharacterLimitException {
		Appointment test = new Appointment("Test Appointment");
		assertTrue(test != null);
	}
	
	//Test 10.1.2
	@Test
	public void test_viewAppointment()
			throws PersonalOrganiserError.EmptyStringException, PersonalOrganiserError.CharacterLimitException {
		String test = new Appointment("Test").toString();
		assertTrue(test != null);
	}
	
	//Test 10.1.2ai
	@Test
	public void test_viewPastAppointment()
			throws PersonalOrganiserError.EmptyStringException, PersonalOrganiserError.CharacterLimitException {
		//TODO
	}
	
	//Test 10.1.2aii
	@Test
	public void test_viewPresentAppointment()
			throws PersonalOrganiserError.EmptyStringException, PersonalOrganiserError.CharacterLimitException {
		//TODO
	}
	
	//Test 10.1.2aiii
	@Test
	public void test_viewFutureAppointment()
			throws PersonalOrganiserError.EmptyStringException, PersonalOrganiserError.CharacterLimitException {
		//TODO
	}
	
	//Test 10.1.2.1
	@Test
	public void test_viewListOfAppointments()
			throws PersonalOrganiserError.EmptyStringException, PersonalOrganiserError.CharacterLimitException {
		//TODO
	}
	
	//Test 10.1.2.1
	@Test
	public void test_viewListOf0Appointments()
			throws PersonalOrganiserError.EmptyStringException, PersonalOrganiserError.CharacterLimitException {
		//TODO
	}
	
	//Test 10.1.2.1ai
	@Test
	public void test_viewListOf1Appointment()
			throws PersonalOrganiserError.EmptyStringException, PersonalOrganiserError.CharacterLimitException {
		//TODO
	}
	
	//Test 10.1.2.1aii
	@Test
	public void test_viewListOf5Appointments()
			throws PersonalOrganiserError.EmptyStringException, PersonalOrganiserError.CharacterLimitException {
		//TODO
	}
	
	//Test 10.1.2.1aiii
	@Test
	public void test_viewListOf50Appointments()
			throws PersonalOrganiserError.EmptyStringException, PersonalOrganiserError.CharacterLimitException {
		//TODO
	}
	
	//Test 10.1.3i
	@Test
	public void test_editAppointment() {
		
	}
	
	//Test 10.1.3ii
	@Test
	public void test_removeAppointment() {
	
	}
	
	//Test 10.1.4
	@Test
	public void test_fieldsCheckAppointment() {
	
	}
	
	/*//Test 10.1.5
	@Test
	public void test_alertAppointment() {
	
	}*/
	
	//Test 10.1.6
	@Test
	public void test_linkContactsToAppointment() {
	
	}
	
	//Test 10.2.1
	@Test
	public void test_createContact() {
	
	}
	
	//Test 10.2.2
	@Test
	public void test_viewContact() {
	
	}
	
	//Test 10.2.2.1
	@Test
	public void test_listOfContacts() {
	
	}
	
	//Test 10.2.3i
	@Test
	public void test_editContact() {
	
	}
	
	//Test 10.2.3ii
	@Test
	public void test_removeContact() {
		db.addContact("Bob", "Newbie");
		Contact test = db.getContact(0);
		db.removeContact(test);
		assertTrue(db.getContactsSize() == 0);
	}
	
	//Test 10.2.4
	@Test
	public void test_fieldsCheckContact() {
	
	}
	
	/*//Test 10.2.5
	@Test
	public void test_alertContact() {
	
	}*/
	
	//Test 10.4.1
	@Test
	public void test_createTodoList() {
		TodoList test;
		test = new TodoList();
		assertTrue(test != null);
	}
}