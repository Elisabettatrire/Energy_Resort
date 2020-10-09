package data;

import java.io.Serializable;

@SuppressWarnings("serial")
public class AeolianData implements Serializable{
	
	private double windPrice;
	private int windKw;
	private int windForecast; //le previsioni del vento
	private int dayHour;
	private int weekDay;
	private int counterWindKw;
	
	
	public AeolianData(double windPrice, int windKw, int windForecast, int dayHour, int weekDay, int counterWindKw) {

		this.windPrice = windPrice;
		this.windKw = windKw;
		this.windForecast = windForecast;
		this.dayHour= dayHour;
		this.weekDay= weekDay;
		this.counterWindKw = counterWindKw;
	}
	
	public AeolianData() {
		
	}
	
	public double getWindPrice() {
		return windPrice;
	}

	public void setWindPrice(double windPrice) {
		this.windPrice = windPrice;
	}

	public int getWindKw() {
		return windKw;
	}

	public void setWindKw(int windKw) {
		this.windKw = windKw;
	}

	public int getWindForecast() {
		return windForecast;
	}

	public void setWindForecast(int windForecast) {
		this.windForecast = windForecast;
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

	public int getCounterWindKw() {
		return counterWindKw;
	}

	public void setCounterWindKw(int counterWindKw) {
		this.counterWindKw = counterWindKw;
	}
}
