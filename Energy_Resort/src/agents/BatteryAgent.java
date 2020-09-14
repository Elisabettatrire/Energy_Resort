package agents;

import behaviours.BatteryBehaviour;

public class BatteryAgent extends BaseAgent{

	protected void setup() {
		registerDfAgent(this.getHap(), "BatteryAgent");
		this.addBehaviour(new BatteryBehaviour(this, 5000));
	}
}
