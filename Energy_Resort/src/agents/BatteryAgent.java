package agents;


import behaviours.ReceiveMessages;

public class BatteryAgent extends BaseAgent{

	protected void setup() {
		registerDfAgent(this.getHap(), "BatteryAgent");
		this.addBehaviour(new ReceiveMessages(this, 10000));
	}
}
