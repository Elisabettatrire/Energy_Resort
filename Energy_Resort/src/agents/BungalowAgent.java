package agents;

import behaviours.ReceiveMessages;
import behaviours.BungalowBehaviour;

public class BungalowAgent extends BaseAgent{
	
	protected void setup(){
		registerDfAgent(this.getHap(), "BungalowAgent");
		this.addBehaviour(new ReceiveMessages(this));
		this.addBehaviour(new BungalowBehaviour(this));
	}
}
