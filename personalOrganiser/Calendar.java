package personalOrganiser;

import java.util.ArrayList;

public class Calendar {

	// constructor
	public Calendar() {
	}

	public ArrayList<Event> getEvents() {
		return this.events;
	}

	public void setEvents(ArrayList<Event> events) {
		this.events = events;
	}

	// variable declaration
	private ArrayList<Event> events;

}
