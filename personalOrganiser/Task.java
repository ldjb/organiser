package personalOrganiser;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import personalOrganiser.PersonalOrganiserError.CharacterLimitException;
import personalOrganiser.PersonalOrganiserError.EmptyStringException;
import personalOrganiser.PersonalOrganiserError.IncorrectDateException;
import personalOrganiser.PersonalOrganiserError.PastDateException;

/**
 * Defines the details of a Task object. Used to create non-time specific jobs.
 * @author Jack C
 * @version 1.0
 */
public class Task {
	
	public static final int CHARACTER_LIMIT = 64;
	public static final String ILLEGAL_CHARACTERS = "#~@{})(";
	private String description, category, title;
	private String[] deadlineTime = new String[2], deadlineDate = new String[3];
	private boolean complete;

	public Task(String title) 
			throws EmptyStringException, CharacterLimitException
	{
		this.setTitle(title);
	}
	
	public Task(String title, String description, String category)
	{
		this.title = title;
		this.description = description;
		this.category = category;
	}
	
	public String getTitle()
	{
		return this.title;
	}
	
	public void setTitle(String title) 
			throws PersonalOrganiserError.EmptyStringException, PersonalOrganiserError.CharacterLimitException
	{
		this.isValidString(title);
		this.title = title;
	}
	
	public String getDescription()
	{
		return this.description;
	}
	
	public void setDescription(String description) 
			throws CharacterLimitException
	{
		try {
			this.isValidString(description);
		} catch (PersonalOrganiserError.EmptyStringException e) {
			// Ignore
		}
		this.description = description;
	}
	
	public String getCategory()
	{
		return this.category;
	}
	
	public void setCategory(String category) 
			throws CharacterLimitException
	{
		try {
			this.isValidString(category);
		} catch (PersonalOrganiserError.EmptyStringException e) {
			// Ignore
		}
		this.category = category;
	}
	
	public void setDeadlineTime(String hour, String minute)
			throws PersonalOrganiserError.EmptyStringException, PersonalOrganiserError.IncorrectTimeException
	{
		this.isValidTime(hour, minute);
		if (hour.length() == 1) {
			hour = "0" + hour;
		}
		if (minute.length() == 1) {
			minute = "0" + minute;
		}
		this.deadlineTime[0] = hour;
		this.deadlineTime[1] = minute;
	}
	
	public String getDeadlineTime()
	{
		return this.deadlineTime[0] + ":" + this.deadlineTime[1];
	}
	
	public void setDeadlineDate(String day, String month, String year)
			throws PersonalOrganiserError.IncorrectDateException, PersonalOrganiserError.PastDateException
	{
		try {
			this.isValidDate(day, month, year);
		} catch (EmptyStringException e) {
			return;
		}
		this.deadlineDate[0] = day;
		this.deadlineDate[1] = month;
		this.deadlineDate[2] = year;
	}
	
	public String getDeadlineDate() 
	{
		return this.deadlineDate[0] + "/" + this.deadlineDate[1] + "/" + this.deadlineDate[2];
	}
	
	public void setComplete(boolean complete)
	{
		this.complete = complete;
	}
	
	public boolean getComplete()
	{
		return this.complete;
	}
	
	public void isValidString(String string)
			throws PersonalOrganiserError.EmptyStringException, PersonalOrganiserError.CharacterLimitException {
		if (string.length() == 0 || string.equals("")) {
			throw new PersonalOrganiserError().new EmptyStringException();
		} else if (string.length() > CHARACTER_LIMIT) {
			throw new PersonalOrganiserError().new CharacterLimitException();
		}
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
	
	public boolean containsOnlyNumbers(String string) {
		for (int index = 0; index < string.length(); index++) {
			if (!Character.isDigit(string.charAt(index))) {
				return false;
			}
		}
		return true;
	}
	
	public boolean isValidDate(String day, String month, String year)
		throws IncorrectDateException, EmptyStringException, PastDateException
	{
		// Ensures all strings contain some information
		if(year == null || month == null || day == null)
		{
			throw new PersonalOrganiserError().new EmptyStringException();
		}
		// Checks if the date is possible using a SimpleDateFormat object
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setLenient(false);
		String combinedDate = day + "/" + month + "/" + year;
		Date givenDateSdf;
		try {
			givenDateSdf = sdf.parse(combinedDate);
		} catch (ParseException e) {
			throw new PersonalOrganiserError().new IncorrectDateException();
		}
		// Checks if the date is today or after using a Calendar object
    	Calendar today = Calendar.getInstance();
    	Calendar givenDateCal = Calendar.getInstance();
    	today.getTime();
    	givenDateCal.setTime(givenDateSdf);
    	if (givenDateCal.before(today))
    	{
			throw new PersonalOrganiserError().new PastDateException();
    	}
    	// Returns true if both tests pass
    	return true;
	}
	
	public String toString() {
		return "Title: " + this.title + "\nDescription: " + this.description + "\nDeadline : " + this.getDeadlineDate() + "\nCategory: " + this.category;
	}
}

