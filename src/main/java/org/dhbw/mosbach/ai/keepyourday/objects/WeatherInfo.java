package org.dhbw.mosbach.ai.keepyourday.objects;

// WeatherInfo Objekt mir minTemp und maxTemp
public class WeatherInfo {

	private double maxTemp;
	private double minTemp;

	public WeatherInfo(double maxTemp, double minTemp) {
		super();
		this.maxTemp = maxTemp;
		this.minTemp = minTemp;
	}

	public double getMaxTemp() {
		return maxTemp;
	}

	public void setMaxTemp(double maxTemp) {
		this.maxTemp = maxTemp;
	}

	public double getMinTemp() {
		return minTemp;
	}

	public void setMinTemp(double minTemp) {
		this.minTemp = minTemp;
	}

}
