package data;
import java.util.Hashtable;

import jade.util.leap.Serializable;

public class BatteryData implements Serializable{
	
    private int capacity;
	private int budget;
    private double batteryPrice;
    private Hashtable<String,Double> bEnergyPrices; //prezzi di solare, eolico e dso
    
    public BatteryData(int capacity, int budget, double batteryPrice, Hashtable<String, Double> bEnergyPrices) {
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

	public Hashtable<String, Double> getbEnergyPrices() {
		return bEnergyPrices;
	}

	public void setbEnergyPrices(Hashtable<String, Double> bEnergyPrices) {
		this.bEnergyPrices = bEnergyPrices;
	}
}

