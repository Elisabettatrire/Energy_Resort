package agents;

import behaviours.ReceiveMessages;

public class BungalowAgent extends BaseAgent{
	protected void setup(){
		registerDfAgent(this.getHap(), "BungalowAgent");
		this.addBehaviour(new ReceiveMessages(this));
	}
}
