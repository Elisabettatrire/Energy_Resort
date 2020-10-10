package data;
import java.util.Hashtable;

import jade.util.leap.Serializable;

public class BatteryData implements Serializable{
	
    private int capacity;
	private double budget;
    private double batteryPrice;
    private double minPrice;
	private int counterCapacity;
    
	public BatteryData(int capacity, double budget, double batteryPrice, double minPrice, int counterCapacity) {
    	this.budget = budget;
    	this.capacity = capacity;
    	this.batteryPrice = batteryPrice;
    	this.minPrice = minPrice;
    	this.counterCapacity = counterCapacity;
    }
    
    public BatteryData() {
    	
    }
    
    public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public double getBudget() {
		return budget;
	}

	public void setBudget(double budget) {
		this.budget = budget;
	}

	public double getBatteryPrice() {
		return batteryPrice;
	}

	public void setBatteryPrice(double batteryPrice) {
		this.batteryPrice = batteryPrice;
	}
   public double getMinPrice() {
		return minPrice;
	}

	public void setMinPrice(double minPrice) {
		this.minPrice = minPrice;
	}
	public int getCounterCapacity() {
		return counterCapacity;
	}

	public void setCounterCapacity(int counterCapacity) {
		this.counterCapacity = counterCapacity;
	}
}

