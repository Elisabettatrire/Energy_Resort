package data;

import java.util.Hashtable;

import jade.util.leap.Serializable;

@SuppressWarnings("serial")
public class BungalowData implements Serializable{
	private int id;
	private int budget;
	private int enReq; //sarebbe bisogni
	private int dayHour;
	private int weekDay;
	private double minPrice;
	

public BungalowData(int id, int budget, int enReq, int dayHour, int weekDay, double minPrice) {
	this.id = id;
	this.budget = budget;
	this.enReq = enReq;
	this.dayHour = dayHour;
	this.weekDay = weekDay;
	this.minPrice = minPrice;
}

public BungalowData(int budget, int enReq) {
	this.budget = budget;
	this.enReq = enReq;
}
public BungalowData() {
	
}
    public int getId() {
	return id;
    }
    public void setId(int id) {
	this.id = id;
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
	public double getMinPrice() {
		return minPrice;
	}
	public void setMinPrice(double minPrice) {
		this.minPrice = minPrice;
	}
}
