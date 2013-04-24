package personalOrganiser;

import java.util.ArrayList;
import java.util.Date;

public class Event {

	// constructor
	public Event() {
	}

	public String getEventName() {
		return this.eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	public String getEventLocation() {
		return this.eventLocation;
	}

	public void setEventLocation(String eventLocation) {
		this.eventLocation = eventLocation;
	}

	public String getEventStartTime() {
		return this.eventStartTime;
	}

	public void setEventStartTime(String eventStartTime) {
		this.eventStartTime = eventStartTime;
	}

	public Date getEventStartDate() {
		return this.eventStartDate;
	}

	public void setEventStartDate(Date eventStartDate) {
		this.eventStartDate = eventStartDate;
	}

	public String getEventEndTime() {
		return this.eventEndTime;
	}

	public void setEventEndTime(String eventEndTime) {
		this.eventEndTime = eventEndTime;
	}

	public Date getEventEndDate() {
		return this.eventEndDate;
	}

	public void setEventEndDate(Date eventEndDate) {
		this.eventEndDate = eventEndDate;
	}

	public String getEventDescription() {
		return this.eventDescription;
	}

	public void setEventDescription(String eventDescription) {
		this.eventDescription = eventDescription;
	}

	public ArrayList<Contact> getEventAttendees() {
		return this.eventAttendees;
	}

	public void setEventAttendees(ArrayList<Contact>) {
		this.eventAttendees = eventAttendees;
	}

	public Reminder getEventAlert() {
		return this.eventAlert;
	}

	public void setEventAlert(Reminder eventAlert) {
		this.eventAlert = eventAlert;
	}

	// variable declaration
	private String eventName;
	private String eventLocation;
	private String eventStartTime;
	private Date eventStartDate;
	private String eventEndTime;
	private Date eventEndDate;
	private String eventDescription;
	private ArrayList<Contact> eventAttendees;
	private Reminder eventAlert;

}
