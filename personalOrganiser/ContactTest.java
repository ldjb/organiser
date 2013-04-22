package personalOrganiser;

import org.junit.*;

/**
 * Test cases for {@link Contact}
 * @author Alexander
 * @version 1.0
 */
public class ContactTest {
	
	public Contact c;
	
	@Before
	public void setup() {
		c = new Contact("Bob", "Newbie");
	}
	
	@Test(expected=PersonalOrganiserError.EmptyStringException.class)
	public void test_emptyContactForename()
			throws PersonalOrganiserError.EmptyStringException, PersonalOrganiserError.CharacterLimitException, PersonalOrganiserError.IncorrectNameException {
		c.setFirstName("");
	}
	
	@Test(expected=PersonalOrganiserError.CharacterLimitException.class)
	public void test_overflowContactForename()
			throws PersonalOrganiserError.EmptyStringException, PersonalOrganiserError.CharacterLimitException, PersonalOrganiserError.IncorrectNameException {
		c.setFirstName("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
	}
	
	@Test(expected=PersonalOrganiserError.IncorrectNameException.class)
	public void test_illegalContactForename()
			throws PersonalOrganiserError.EmptyStringException, PersonalOrganiserError.CharacterLimitException, PersonalOrganiserError.IncorrectNameException {
		c.setFirstName("#~@{})(");
	}
	
	@Test
	public void test_correctContactForename()
			throws PersonalOrganiserError.EmptyStringException, PersonalOrganiserError.CharacterLimitException, PersonalOrganiserError.IncorrectNameException {
		c.setFirstName("Bob");
	}
	
	@Test(expected=PersonalOrganiserError.EmptyStringException.class)
	public void test_emptyContactSurname()
			throws PersonalOrganiserError.EmptyStringException, PersonalOrganiserError.CharacterLimitException, PersonalOrganiserError.IncorrectNameException {
		c.setLastName("");
	}
	
	@Test(expected=PersonalOrganiserError.CharacterLimitException.class)
	public void test_overflowContactSurname()
			throws PersonalOrganiserError.EmptyStringException, PersonalOrganiserError.CharacterLimitException, PersonalOrganiserError.IncorrectNameException {
		c.setLastName("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
	}
	
	@Test(expected=PersonalOrganiserError.IncorrectNameException.class)
	public void test_illegalContactSurname()
			throws PersonalOrganiserError.EmptyStringException, PersonalOrganiserError.CharacterLimitException, PersonalOrganiserError.IncorrectNameException {
		c.setLastName("#~@{})(");
	}
	
	@Test
	public void test_correctContactSurname()
			throws PersonalOrganiserError.EmptyStringException, PersonalOrganiserError.CharacterLimitException, PersonalOrganiserError.IncorrectNameException {
		c.setLastName("Jackson");
	}
	
	@Test
	public void test_emptyContactPhoneNumber()
			throws PersonalOrganiserError.CharacterLimitException, PersonalOrganiserError.InvalidNumberException {
		c.addPhoneNumber("");
	}
	
	@Test(expected=PersonalOrganiserError.CharacterLimitException.class)
	public void test_overflowContactPhoneNumber()
			throws PersonalOrganiserError.CharacterLimitException, PersonalOrganiserError.InvalidNumberException {
		c.addPhoneNumber("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
	}
	
	@Test(expected=PersonalOrganiserError.InvalidNumberException.class)
	public void test_illegalContactPhoneNumber()
			throws PersonalOrganiserError.CharacterLimitException, PersonalOrganiserError.InvalidNumberException {
		c.addPhoneNumber("#~@{})(");
	}
	
	@Test
	public void test_correctContactPhoneNumber()
			throws PersonalOrganiserError.CharacterLimitException, PersonalOrganiserError.InvalidNumberException {
		c.addPhoneNumber("01322492516");
	}
	
	@Test
	public void test_emptyContactPhoneNumberType()
			throws PersonalOrganiserError.CharacterLimitException, PersonalOrganiserError.InvalidNumberException {
		c.addPhoneNumber("01322492516", "");
	}
	
	@Test(expected=PersonalOrganiserError.CharacterLimitException.class)
	public void test_overflowContactPhoneNumberType()
			throws PersonalOrganiserError.CharacterLimitException, PersonalOrganiserError.InvalidNumberException {
		c.addPhoneNumber("01322492516", "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
	}
	
	@Test
	public void test_correctContactPhoneNumberType()
			throws PersonalOrganiserError.CharacterLimitException, PersonalOrganiserError.InvalidNumberException {
		c.addPhoneNumber("01322492516", "Home");
	}
	
	@Test
	public void test_emptyContactEmailAddress()
			throws PersonalOrganiserError.CharacterLimitException, PersonalOrganiserError.InvalidEmailException {
		c.setEmailAddress("");
	}
	
	@Test(expected=PersonalOrganiserError.CharacterLimitException.class)
	public void test_overflowContactEmailAddress()
			throws PersonalOrganiserError.CharacterLimitException, PersonalOrganiserError.InvalidEmailException {
		c.setEmailAddress("bob@AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
	}
	
	@Test(expected=PersonalOrganiserError.InvalidEmailException.class)
	public void test_illegalContactEmailAddress()
			throws PersonalOrganiserError.CharacterLimitException, PersonalOrganiserError.InvalidEmailException {
		c.setEmailAddress("bob.example.com");
	}
	
	@Test
	public void test_correctContactEmailAddress()
			throws PersonalOrganiserError.CharacterLimitException, PersonalOrganiserError.InvalidEmailException {
		c.setEmailAddress("bob@example.com");
	}
	
	@Test
	public void test_emptyContactHomeAddress()
			throws PersonalOrganiserError.CharacterLimitException {
		c.setHomeAddress("");
	}
	
	@Test(expected=PersonalOrganiserError.CharacterLimitException.class)
	public void test_overflowContactHomeAddress()
			throws PersonalOrganiserError.CharacterLimitException {
		c.setHomeAddress("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
	}
	
	@Test
	public void test_correctContactHomeAddress()
			throws PersonalOrganiserError.CharacterLimitException {
		c.setHomeAddress("39 High Street, Bath, BA2 6GN");
	}
	
	@Test
	public void test_emptyContactOptionalDescription()
			throws PersonalOrganiserError.CharacterLimitException {
		c.setExtraInfo("");
	}
	
	@Test(expected=PersonalOrganiserError.CharacterLimitException.class)
	public void test_overflowContactOptionalDescription()
			throws PersonalOrganiserError.CharacterLimitException {
		c.setExtraInfo("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
	}
	
	@Test
	public void test_correctContactOptionalDescription()
			throws PersonalOrganiserError.CharacterLimitException {
		c.setExtraInfo("Bob likes chocolate");
	}
}