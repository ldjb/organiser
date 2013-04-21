package personalOrganiser;

/**
 * Defines the details of an Appointment object. Used to create time specific events.
 * @author Alexander
 * @version 1.0
 */
public class Appointment {
	public static final int CHARACTER_LIMIT = 64;
	public static final String ILLEGAL_CHARACTERS = "#~@{})(";
	private String title, location, description;
	private String[] startTime = new String[2], endTime = new String[2], startDate = new String[3], endDate = new String[3];
	
	public Appointment() {
	
	}
	
	public Appointment(String title)
			throws PersonalOrganiserError.EmptyStringException, PersonalOrganiserError.CharacterLimitException {
		this.setTitle(title);
	}
	
	public void setTitle(String title)
			throws PersonalOrganiserError.EmptyStringException, PersonalOrganiserError.CharacterLimitException {
		this.isValidString(title);
		this.title = title;
	}
	
	public String getTitle() {
		return this.title;
	}
	
	public void setLocation(String location)
			throws PersonalOrganiserError.CharacterLimitException {
		try {
			this.isValidString(location);
		} catch (PersonalOrganiserError.EmptyStringException e) {
			// Ignore
		}
		this.location = location;
	}
	
	public String getLocation() {
		return this.location;
	}
	
	public void setStartTime(String hour, String minute)
			throws PersonalOrganiserError.EmptyStringException, PersonalOrganiserError.IncorrectTimeException {
		this.isValidTime(hour, minute);
		if (hour.length() == 1) {
			hour = "0" + hour;
		}
		if (minute.length() == 1) {
			minute = "0" + minute;
		}
		this.startTime[0] = hour;
		this.startTime[1] = minute;
	}
	
	public String getStartTime() {
		return this.startTime[0] + ":" + this.startTime[1];
	}
	
	public void setEndTime(String hour, String minute)
			throws PersonalOrganiserError.EmptyStringException, PersonalOrganiserError.IncorrectTimeException, PersonalOrganiserError.BeforeStartException {
		this.isValidTime(hour, minute);
		if (hour.length() == 1) {
			hour = "0" + hour;
		}
		if (minute.length() == 1) {
			minute = "0" + minute;
		}
		if (this.startTime[0] == null || this.startTime[1] == null) {
			this.endTime[0] = hour;
			this.endTime[1] = minute;
			this.startTime = this.endTime;
		} else if (!this.isBiggerThanOrEqualTo(hour + minute, this.startTime[0] + this.startTime[1])) {
			throw new PersonalOrganiserError().new BeforeStartException();
		} else {
			this.endTime[0] = hour;
			this.endTime[1] = minute;
		}
	}
	
	public String getEndTime() {
		return this.endTime[0] + ":" + this.endTime[1];
	}
	
	public void setStartDate(String day, String month, String year)
			throws PersonalOrganiserError.EmptyStringException, PersonalOrganiserError.IncorrectDateException, PersonalOrganiserError.PastDateException {
		
	}
	
	public String getStartDate() {
		return this.startDate[0] + "/" + this.startDate[1] + "/" + this.startDate[2];
	}
	
	public void setEndDate(String day, String month, String year)
			throws PersonalOrganiserError.EmptyStringException, PersonalOrganiserError.IncorrectDateException, PersonalOrganiserError.PastDateException, PersonalOrganiserError.BeforeStartException {
	
	}
	
	public String getEndDate() {
		return this.endDate[0] + "/" + this.endDate[1] + "/" + this.endDate[2];
	}
	
	public void setDescription(String description)
			throws PersonalOrganiserError.CharacterLimitException {
		if (description.length() > CHARACTER_LIMIT) {
			throw new PersonalOrganiserError().new CharacterLimitException();
		} else {
			this.description = description;
		}
	}
	
	public String getDescription() {
		return this.description;
	}
	
	public void isValidDate(String day, String month, String year)
			throws PersonalOrganiserError.EmptyStringException, PersonalOrganiserError.IncorrectDateException {
		
	}
	
	public boolean isBiggerThanOrEqualTo(String stringSubject, String stringComparedTo) {
		if (stringSubject.length() < stringComparedTo.length()) {
			return false;
		} else if (stringSubject.length() > stringComparedTo.length()) {
			return true;
		}
		for (int index = 0; index < stringSubject.length(); index++) {
			if (Character.getNumericValue(stringSubject.charAt(index)) < Character.getNumericValue(stringComparedTo.charAt(index))) {
				return false;
			}
		}
		return true;
	}
	
	public boolean containsCharacters(String string, String characters) {
		for (int index = 0; index < string.length(); index++) {
			if (characters.contains("" + string.charAt(index))) {
				return true;
			}
		}
		return false;
	}
	
	public boolean containsOnlyNumbers(String string) {
		for (int index = 0; index < string.length(); index++) {
			if (!Character.isDigit(string.charAt(index))) {
				return false;
			}
		}
		return true;
	}
	
	public void isValidTime(String hour, String minute)
			throws PersonalOrganiserError.EmptyStringException, PersonalOrganiserError.IncorrectTimeException {
		String time;
		if (hour != null && minute != null) {
			time = hour + minute;
		} else {
			throw new PersonalOrganiserError().new EmptyStringException();
		}
		if (time.length() == 0 || time.equals("")) {
			throw new PersonalOrganiserError().new EmptyStringException();
		} else if (time.length() > CHARACTER_LIMIT || hour.length() > 2 || minute.length() > 2) {
			throw new PersonalOrganiserError().new IncorrectTimeException();
		} else if (!this.containsOnlyNumbers(time)) {
			throw new PersonalOrganiserError().new IncorrectTimeException();
		} else if (hour.length() == 2 && (Character.getNumericValue(hour.charAt(0)) > 2 || 
				(Character.getNumericValue(hour.charAt(0)) == 2 && Character.getNumericValue(hour.charAt(1)) > 3))) {
			throw new PersonalOrganiserError().new IncorrectTimeException();
		} else if (minute.length() == 2 && Character.getNumericValue(minute.charAt(0)) > 5) {
			throw new PersonalOrganiserError().new IncorrectTimeException();
		}
	}
	
	public void isValidString(String string)
			throws PersonalOrganiserError.EmptyStringException, PersonalOrganiserError.CharacterLimitException {
		if (string.length() == 0 || string.equals("")) {
			throw new PersonalOrganiserError().new EmptyStringException();
		} else if (string.length() > CHARACTER_LIMIT) {
			throw new PersonalOrganiserError().new CharacterLimitException();
		}
	}
}