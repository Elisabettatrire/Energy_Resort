package agents;


import behaviours.DsoBehaviour;

@SuppressWarnings("serial")
public class DsoAgent extends BaseAgent{
	protected void setup(){
		
		registerDfAgent(this.getHap(), "DsoAgent");
		
		//this.addBehaviour(new DsoBehaviour(data));
		//this.addBehaviour(new ReceiveMessages(this));
	}
	

}
