package data;
import java.util.Hashtable;

public class BatteryData {
	
    private int capacity;
	private int budget;
    private int batteryPrice;
    private Hashtable<String,Integer> bEnergyPrices;
    
    public BatteryData(int capacity, int budget, int batteryPrice, Hashtable<String, Integer> bEnergyPrices) {
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

	public int getBatteryPrice() {
		return batteryPrice;
	}

	public void setBatteryPrice(int batteryPrice) {
		this.batteryPrice = batteryPrice;
	}

	public Hashtable<String, Integer> getbEnergyPrices() {
		return bEnergyPrices;
	}

	public void setbEnergyPrices(Hashtable<String, Integer> bEnergyPrices) {
		this.bEnergyPrices = bEnergyPrices;
	}
}

