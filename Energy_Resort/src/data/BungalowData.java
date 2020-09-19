package data;

import java.util.Hashtable;

@SuppressWarnings("serial")
public class BungalowData {
	//private int idBungalow;
	private int budget;
	private int enReq; //sarebbe bisogni
	private int dayHour;
	//private String weekDay="lunedì";
	private int weekDay;
	private Hashtable<String, Double> energyPrices;
	

public BungalowData(int budget, int enReq, int dayHour, int weekDay, Hashtable<String, Double> energyPrices) {
	this.budget = budget;
	this.enReq = enReq;
	this.dayHour = dayHour;
	this.weekDay = weekDay;
	this.energyPrices = energyPrices;
}

public BungalowData(int budget, int enReq) {
	this.budget = budget;
	this.enReq = enReq;
}
public BungalowData() {
	
}

	public int getBudget() {
		return budget;
	}
	public void setBudget(int budget) {
		this.budget = budget;
	}
	public int getEnReq() {
		return enReq;
	}
	public void setEnReq(int enReq) {
		this.enReq = enReq;
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
	public Hashtable<String, Double> getEnergyPrices() {
		return energyPrices;
	}

	public void setEnergyPrices(Hashtable<String, Double> energyPrices) {
		this.energyPrices = energyPrices;
	}

}
