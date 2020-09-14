package agents;

import behaviours.ReceiveMessagesBungalow;
import behaviours.BungalowBehaviour;
import behaviours.SendMessagesBungalow;

public class BungalowAgent extends BaseAgent{
	
	public static final String CONV_ID = "bungalow";
	
	protected void setup(){
		registerDfAgent(this.getHap(), "BungalowAgent");
		this.addBehaviour(new ReceiveMessagesBungalow(this));
		this.addBehaviour(new BungalowBehaviour(this, 10000));
		this.addBehaviour(new SendMessagesBungalow(this, 15000));
	}
}
