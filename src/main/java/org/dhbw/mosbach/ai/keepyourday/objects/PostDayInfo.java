package org.dhbw.mosbach.ai.keepyourday.objects;

// Objekt für das Setzen der DayInfo
public class PostDayInfo {

	private String user;
	private String date;
	private int happiness;

	public PostDayInfo() {
		this.user = null;
		this.date = null;
		this.happiness = 0;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getHappiness() {
		return happiness;
	}

	public void setHappiness(int happiness) {
		this.happiness = happiness;
	}

}
