package agents;


import behaviours.BatteryBehaviour;
import behaviours.ReceiveMessages;
import data.BatteryData;

public class BatteryAgent extends BaseAgent{

	BatteryData battery;
	
	
	public BatteryData getBattery() {
		return battery;
	}
	public void setBattery(BatteryData battery) {
		this.battery = battery;
	}

	
	protected void setup() {
		
		battery = new BatteryData();
		
		battery.setBatteryPrice(0.8);
		battery.setBudget(60);
		battery.setCapacity(50);
		
		registerDfAgent(this.getHap(), "BatteryAgent");
		this.addBehaviour(new BatteryBehaviour(this, battery));
		//this.addBehaviour(new ReceiveMessages(this, 10000));
		
	}
}
