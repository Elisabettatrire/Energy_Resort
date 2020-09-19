package data;
import java.util.Hashtable;

import jade.util.leap.Serializable;

public class BatteryData implements Serializable{
	
    private int capacity = 50;
	private int budget;
    private double batteryPrice=0.8;
    private Hashtable<String,Integer> bEnergyPrices;
    
    public BatteryData(int capacity, int budget, double batteryPrice, Hashtable<String, Integer> bEnergyPrices) {
    	this.budget = budget;
    	this.capacity = capacity;
    	this.batteryPrice = batteryPrice;
    	this.bEnergyPrices = bEnergyPrices;
    }
    
    public BatteryData() {
    	
    }
    
    public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public int getBudget() {
		return budget;
	}

	public void setBudget(int budget) {
		this.budget = budget;
	}

	public double getBatteryPrice() {
		return batteryPrice;
	}

	public void setBatteryPrice(double batteryPrice) {
		this.batteryPrice = batteryPrice;
	}

	public Hashtable<String, Integer> getbEnergyPrices() {
		return bEnergyPrices;
	}

	public void setbEnergyPrices(Hashtable<String, Integer> bEnergyPrices) {
		this.bEnergyPrices = bEnergyPrices;
	}
}

