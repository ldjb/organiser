package personalOrganiser;

public class Contact {

	private String firstName, lastName, emailAddress, homeAddress, extraInfo;
	private Integer homePhone, workPhone, extraPhone;
	
	public Contact(String firstName, String lastName, String email, String address, String info, Integer homeNumber, Integer workNumber, Integer extraNumber) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailAddress = email;
		this.homeAddress = address;
		this.extraInfo = info;
		this.homePhone = homeNumber;
		this.workPhone = workNumber;
		this.extraPhone = extraNumber;
	}
	
	public Contact(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	public String getFirstName() {
		return this.firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return this.lastName;
	}
	
	public void setLastName(String lastName) {
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
	
	public String getHomePhone() {
		return "" + this.homePhone;
	}
	
	public void setHomePhone(Integer homePhone) {
		this.homePhone = homePhone;
	}
	
	public String getWorkPhone() {
		return "" + this.workPhone;
	}
	
	public void setWorkPhone(Integer workPhone) {
		this.workPhone = workPhone;
	}
	
	public String getExtraPhone() {
		return "" + this.extraPhone;
	}
	
	public void setExtraPhone(Integer extraPhone) {
		this.extraPhone = extraPhone;
	}
	
	public String toString() {
		return ("Name: " + this.firstName + " " + this.lastName + "\nEmail: " + this.emailAddress +
				"\nHome Phone: " + this.homePhone + "\nWork Phone: " + this.workPhone + "\nOther Phone: " + this.extraPhone +
				"\nAddress: " + this.homeAddress + "\nInfo: " + this.extraInfo);
	}
}