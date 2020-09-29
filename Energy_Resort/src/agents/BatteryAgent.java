package agents;


import behaviours.ReceiveMessages;
import data.BatteryData;

public class BatteryAgent extends BaseAgent{

	BatteryData battery;
	
	protected void setup() {
		battery = new BatteryData();
		registerDfAgent(this.getHap(), "BatteryAgent");
		this.addBehaviour(new ReceiveMessages(this, 10000));
	}
}
