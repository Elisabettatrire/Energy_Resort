package data;

import java.util.ArrayList;
import java.util.List;


@SuppressWarnings("serial")
public class BungalowData {
	//private int idBungalow;
	private int budget;
	private int enReq; //sarebbe bisogni
	private int dayHour;
	private String weekDay;
	
	
public BungalowData(int budget, int enReq, int dayHour, String weekDay) {
	this.budget = budget;
	this.enReq = enReq;
	this.dayHour = dayHour;
	this.weekDay = weekDay;
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
	public String getWeekDay() {
		return weekDay;
	}
	public void setWeekDay(String weekDay) {
		this.weekDay = weekDay;
	}

}
