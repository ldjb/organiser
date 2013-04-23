package personalOrganiser;

import org.junit.*;

/**
 * Test cases for {@link Contact}
 * @author Alexander
 * @version 1.1
 */
public class ContactTest {
	
	public Contact c;
	
	@Before
	public void setup() {
		c = new Contact("Bob", "Newbie");
	}
	
	//Test 10.2.1ai
	@Test(expected=PersonalOrganiserError.EmptyStringException.class)
	public void test_emptyContactForename()
			throws PersonalOrganiserError.EmptyStringException, PersonalOrganiserError.CharacterLimitException, PersonalOrganiserError.IncorrectNameException {
		c.setFirstName("");
	}
	
	//Test 10.2.1aii
	@Test(expected=PersonalOrganiserError.CharacterLimitException.class)
	public void test_overflowContactForename()
			throws PersonalOrganiserError.EmptyStringException, PersonalOrganiserError.CharacterLimitException, PersonalOrganiserError.IncorrectNameException {
		c.setFirstName("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
	}
	
	//Test 10.2.1aiii
	@Test(expected=PersonalOrganiserError.IncorrectNameException.class)
	public void test_illegalContactForename()
			throws PersonalOrganiserError.EmptyStringException, PersonalOrganiserError.CharacterLimitException, PersonalOrganiserError.IncorrectNameException {
		c.setFirstName("#~@{})(");
	}
	
	//Test 10.2.1aiv
	@Test
	public void test_correctContactForename()
			throws PersonalOrganiserError.EmptyStringException, PersonalOrganiserError.CharacterLimitException, PersonalOrganiserError.IncorrectNameException {
		c.setFirstName("Bob");
	}
	
	//Test 10.2.1bi
	@Test(expected=PersonalOrganiserError.EmptyStringException.class)
	public void test_emptyContactSurname()
			throws PersonalOrganiserError.EmptyStringException, PersonalOrganiserError.CharacterLimitException, PersonalOrganiserError.IncorrectNameException {
		c.setLastName("");
	}
	
	//Test 10.2.1bii
	@Test(expected=PersonalOrganiserError.CharacterLimitException.class)
	public void test_overflowContactSurname()
			throws PersonalOrganiserError.EmptyStringException, PersonalOrganiserError.CharacterLimitException, PersonalOrganiserError.IncorrectNameException {
		c.setLastName("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
	}
	
	//Test 10.2.1biii
	@Test(expected=PersonalOrganiserError.IncorrectNameException.class)
	public void test_illegalContactSurname()
			throws PersonalOrganiserError.EmptyStringException, PersonalOrganiserError.CharacterLimitException, PersonalOrganiserError.IncorrectNameException {
		c.setLastName("#~@{})(");
	}
	
	//Test 10.2.1biv
	@Test
	public void test_correctContactSurname()
			throws PersonalOrganiserError.EmptyStringException, PersonalOrganiserError.CharacterLimitException, PersonalOrganiserError.IncorrectNameException {
		c.setLastName("Jackson");
	}
	
	//Test 10.2.1ci
	@Test
	public void test_emptyContactPhoneNumber()
			throws PersonalOrganiserError.CharacterLimitException, PersonalOrganiserError.InvalidNumberException {
		c.addPhoneNumber("");
	}
	
	//Test 10.2.1cii
	@Test(expected=PersonalOrganiserError.CharacterLimitException.class)
	public void test_overflowContactPhoneNumber()
			throws PersonalOrganiserError.CharacterLimitException, PersonalOrganiserError.InvalidNumberException {
		c.addPhoneNumber("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
	}
	
	//Test 10.2.1ciii
	@Test(expected=PersonalOrganiserError.InvalidNumberException.class)
	public void test_illegalContactPhoneNumber()
			throws PersonalOrganiserError.CharacterLimitException, PersonalOrganiserError.InvalidNumberException {
		c.addPhoneNumber("#~@{})(");
	}
	
	//Test 10.2.1civ
	@Test
	public void test_correctContactPhoneNumber()
			throws PersonalOrganiserError.CharacterLimitException, PersonalOrganiserError.InvalidNumberException {
		c.addPhoneNumber("01322492516");
	}
	
	//Test 10.2.1di
	@Test
	public void test_emptyContactPhoneNumberType()
			throws PersonalOrganiserError.CharacterLimitException, PersonalOrganiserError.InvalidNumberException {
		c.addPhoneNumber("01322492516", "");
	}
	
	//Test 10.2.1dii
	@Test(expected=PersonalOrganiserError.CharacterLimitException.class)
	public void test_overflowContactPhoneNumberType()
			throws PersonalOrganiserError.CharacterLimitException, PersonalOrganiserError.InvalidNumberException {
		c.addPhoneNumber("01322492516", "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
	}
	
	//Test 10.2.1diii
	@Test
	public void test_correctContactPhoneNumberType()
			throws PersonalOrganiserError.CharacterLimitException, PersonalOrganiserError.InvalidNumberException {
		c.addPhoneNumber("01322492516", "Home");
	}
	
	//Test 10.2.1ei
	@Test
	public void test_emptyContactEmailAddress()
			throws PersonalOrganiserError.CharacterLimitException, PersonalOrganiserError.InvalidEmailException {
		c.setEmailAddress("");
	}
	
	//Test 10.2.1eii
	@Test(expected=PersonalOrganiserError.CharacterLimitException.class)
	public void test_overflowContactEmailAddress()
			throws PersonalOrganiserError.CharacterLimitException, PersonalOrganiserError.InvalidEmailException {
		c.setEmailAddress("bob@AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
	}
	
	//Test 10.2.1eiii
	@Test(expected=PersonalOrganiserError.InvalidEmailException.class)
	public void test_illegalContactEmailAddress()
			throws PersonalOrganiserError.CharacterLimitException, PersonalOrganiserError.InvalidEmailException {
		c.setEmailAddress("bob.example.com");
	}
	
	//Test 10.2.1eiv
	@Test
	public void test_correctContactEmailAddress()
			throws PersonalOrganiserError.CharacterLimitException, PersonalOrganiserError.InvalidEmailException {
		c.setEmailAddress("bob@example.com");
	}
	
	//Test 10.2.1fi
	@Test
	public void test_emptyContactHomeAddress()
			throws PersonalOrganiserError.CharacterLimitException {
		c.setHomeAddress("");
	}
	
	//Test 10.2.1fii
	@Test(expected=PersonalOrganiserError.CharacterLimitException.class)
	public void test_overflowContactHomeAddress()
			throws PersonalOrganiserError.CharacterLimitException {
		c.setHomeAddress("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
	}
	
	//Test 10.2.1fiii
	@Test
	public void test_correctContactHomeAddress()
			throws PersonalOrganiserError.CharacterLimitException {
		c.setHomeAddress("39 High Street, Bath, BA2 6GN");
	}
	
	//Test 10.2.1gi
	@Test
	public void test_emptyContactOptionalDescription()
			throws PersonalOrganiserError.CharacterLimitException {
		c.setExtraInfo("");
	}
	
	//Test 10.2.1gii
	@Test(expected=PersonalOrganiserError.CharacterLimitException.class)
	public void test_overflowContactOptionalDescription()
			throws PersonalOrganiserError.CharacterLimitException {
		c.setExtraInfo("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
	}
	
	//Test 10.2.1giii
	@Test
	public void test_correctContactOptionalDescription()
			throws PersonalOrganiserError.CharacterLimitException {
		c.setExtraInfo("Bob likes chocolate");
	}
}