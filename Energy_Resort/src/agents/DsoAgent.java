package agents;

import behaviours.ReceiveMessages;

@SuppressWarnings("serial")
public class DsoAgent extends BaseAgent{
	protected void setup(){
		
		registerDfAgent(this.getHap(), "DsoAgent");
		
		this.addBehaviour(new ReceiveMessages(this, 10000));
	}
	

}
