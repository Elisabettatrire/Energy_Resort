package data;

import java.util.ArrayList;
import java.util.List;


@SuppressWarnings("serial")
public class BungalowData {
	//private int idBungalow;
	private int budget;
	private int enReq; //sarebbe bisogni
	private int dayHour=10;
	//private String weekDay="lunedì";
	private int weekDay=1;
	
	
public BungalowData(int budget, int enReq, int dayHour, int weekDay) {
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
	public int getWeekDay() {
		return weekDay;
	}
	public void setWeekDay(int weekDay) {
		this.weekDay = weekDay;
	}

}