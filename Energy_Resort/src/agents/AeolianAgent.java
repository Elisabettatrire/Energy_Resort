package agents;

import behaviours.ReceiveMessages;
//import behaviours.ReceiveMessagesAeolian;


public class AeolianAgent extends BaseAgent{
	
	protected void setup(){
		
		registerDfAgent(this.getHap(), "AeolianAgent");
		this.addBehaviour(new ReceiveMessages(this, 10000));
		//this.addBehaviour(new ReceiveMessagesAeolian(this));
	}
}
