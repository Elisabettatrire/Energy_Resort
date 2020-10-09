package data;

import java.io.Serializable;

public class SolarData implements Serializable{
	
	private double solarPrice;
	private int solarKw;
	private int solarForecast; //le previsioni del sole
	private int dayHour;
	private int weekDay;
	private int counterSolarKw;	

	public SolarData(double solarPrice, int solarKw, int solarForecast, int dayHour, int weekDay, int counterSolarKw) {

		this.solarPrice = solarPrice;
		this.solarKw = solarKw;
		this.solarForecast = solarForecast;
		this.dayHour= dayHour;
		this.weekDay= weekDay;
		this.counterSolarKw = counterSolarKw;
	}
	
	public SolarData() {
		
	}
	
	public double getSolarPrice() {
		return solarPrice;
	}

	public void setSolarPrice(double solarPrice) {
		this.solarPrice = solarPrice;
	}

	public int getSolarKw() {
		return solarKw;
	}

	public void setSolarKw(int solarKw) {
		this.solarKw = solarKw;
	}

	public int getSolarForecast() {
		return solarForecast;
	}

	public void setSolarForecast(int solarForecast) {
		this.solarForecast = solarForecast;
	}

	public int getDayHour() {
		return dayHour;
	}

	public void setDayHour(int dayHour) {
		this.dayHour = dayHour;
	}

	public int getWeekDay() {
		return weekDay;
	}

	public void setWeekDay(int weekDay) {
		this.weekDay = weekDay;
	}
	public int getCounterSolarKw() {
		return counterSolarKw;
	}

	public void setCounterSolarKw(int counterSolarKw) {
		this.counterSolarKw = counterSolarKw;
	}
}
