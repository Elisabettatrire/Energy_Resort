package agents;

import behaviours.ReceiveMessages;
import behaviours.BungalowBehaviour;


public class BungalowAgent extends BaseAgent{
	
	public static final String CONV_ID = "bungalow";
	
	protected void setup(){
		registerDfAgent(this.getHap(), "BungalowAgent");
		this.addBehaviour(new BungalowBehaviour(this));
		this.addBehaviour(new ReceiveMessages(this, 10000));
		
	
	}
}
