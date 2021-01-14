package org.dhbw.mosbach.ai.keepyourday.objects;

import java.util.ArrayList;

// Objekt für die Rückgabe der DayInfo
public class DayInfo {

	private String user;
	private String date;
	private int happiness;
	private ArrayList<NewsInfo> news;
	private WeatherInfo weather;

	private boolean success = true;

	public DayInfo() {
		this.user = null;
		this.date = null;
		this.happiness = 0;
		this.news = null;
		this.weather = null;
	}

	public DayInfo(String user, String date, int happiness) {
		super();
		this.date = date;
		this.happiness = happiness;
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

	public boolean getSuccess() {
		return this.success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public ArrayList<NewsInfo> getNews() {
		return news;
	}

	public void setNews(ArrayList<NewsInfo> news) {
		this.news = news;
	}

	public WeatherInfo getWeather() {
		return weather;
	}

	public void setWeather(WeatherInfo weather) {
		this.weather = weather;
	}

}
