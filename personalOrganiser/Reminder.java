package personalOrganiser;

import java.util.Date;

public class Reminder {

	// constructor
	public Reminder() {
	}

	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getTime() {
		return this.time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public Sound getTone() {
		return this.tone;
	}

	public void setTone(Sound tone) {
		this.tone = tone;
	}

	// variable declaration
	private Date date;
	private String time;
	private Sound tone;

}
