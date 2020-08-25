package data;

public class AeolianData {
	
	private double windPrice;
	private double windKw;
	private int windForecast; //le previsioni del vento
	private int dayHour;
	private int weekDay;
	
	public AeolianData(double windPrice, double windKw, int windForecast, int dayHour, int weekDay) {

		this.windPrice = windPrice;
		this.windKw = windKw;
		this.windForecast = windForecast;
		this.dayHour= dayHour;
		this.weekDay= weekDay;
	}
	
	public AeolianData() {
		
	}
	
	public double getWindPrice() {
		return windPrice;
	}

	public void setWindPrice(double windPrice) {
		this.windPrice = windPrice;
	}

	public double getWindKw() {
		return windKw;
	}

	public void setWindKw(double windKw) {
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


	
	

}
