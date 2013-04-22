package personalOrganiser;

import java.util.ArrayList;

/**
 * Defines the details of a Contact object. Used to create phone contacts.
 * @author Alexander
 * @version 1.0
 */
public class Contact {

	public static final int CHARACTER_LIMIT = 64;
	public static final String ILLEGAL_CHARACTERS = "#~@{})(";
	private String firstName, lastName, emailAddress, homeAddress, extraInfo;
	private ArrayList<String[]> phoneNumbers = new ArrayList<String[]>();
	
	public Contact(String firstName, String lastName, String email, String address, String info) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailAddress = email;
		this.homeAddress = address;
		this.extraInfo = info;
	}
	
	public Contact(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	public String getFirstName() {
		return this.firstName;
	}
	
	public void setFirstName(String firstName) throws PersonalOrganiserError.EmptyStringException, PersonalOrganiserError.CharacterLimitException, PersonalOrganiserError.IncorrectNameException {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return this.lastName;
	}
	
	public void setLastName(String lastName) throws PersonalOrganiserError.EmptyStringException, PersonalOrganiserError.CharacterLimitException, PersonalOrganiserError.IncorrectNameException {
		this.lastName = lastName;
	}
	
	public String getEmailAddress() {
		return this.emailAddress;
	}
	
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	
	public String getHomeAddress() {
		return this.homeAddress;
	}
	
	public void setHomeAddress(String homeAddress) {
		this.homeAddress = homeAddress;
	}
	
	public String getExtraInfo() {
		return this.extraInfo;
	}
	
	public void setExtraInfo(String extraInfo) {
		this.extraInfo = extraInfo;
	}
	
	public String getPhoneNumber(String key) {
		for (int index = 0; index < this.phoneNumbers.size(); index++) {
			if (this.phoneNumbers.get(index)[0].equals(key)) {
				return this.phoneNumbers.get(index)[1];
			}
		}
		return null;
	}
	
	public void addPhoneNumber(String phoneNumber, String key)
				throws PersonalOrganiserError.CharacterLimitException, PersonalOrganiserError.InvalidNumberException {
		if (key == null || key.equals("")) {
			this.addPhoneNumber(phoneNumber);
		} else if (key.length() > CHARACTER_LIMIT) {
			throw new PersonalOrganiserError().new CharacterLimitException();
		} else {
			if (phoneNumber != null && phoneNumber.length() != 0) {
				if (phoneNumber.length() > CHARACTER_LIMIT) {
					throw new PersonalOrganiserError().new CharacterLimitException();
				} else if (!this.isANumber(phoneNumber)) {
					throw new PersonalOrganiserError().new InvalidNumberException();
				} else {
					this.phoneNumbers.add(new String[]{key, phoneNumber});
				}
			}
		}
	}
	
	public void addPhoneNumber(String phoneNumber) throws PersonalOrganiserError.CharacterLimitException, PersonalOrganiserError.InvalidNumberException {
		if (phoneNumber != null && phoneNumber.length() != 0) {
			if (phoneNumber.length() > CHARACTER_LIMIT) {
				throw new PersonalOrganiserError().new CharacterLimitException();
			} else if (!this.isANumber(phoneNumber)) {
				throw new PersonalOrganiserError().new InvalidNumberException();
			} else {
				this.phoneNumbers.add(new String[]{"Phone " + (this.phoneNumbers.size() + 1), phoneNumber});
			}
		}
	}
	
	public boolean isANumber(String string) {
		for (int index = 0; index < string.length(); index++) {
			if (!Character.isDigit(string.charAt(index))) {
				return false;
			}
		}
		return true;
	}
	
	public String toString() {
		return ("Name: " + this.firstName + " " + this.lastName + "\nEmail: " + this.emailAddress +
				"\nAddress: " + this.homeAddress + "\nInfo: " + this.extraInfo);
	}
}