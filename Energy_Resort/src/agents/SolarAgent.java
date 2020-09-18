package agents;
import behaviours.ReceiveMessages;
import behaviours.SolarBehaviour;


public class SolarAgent extends BaseAgent{
	
	protected void setup(){
		registerDfAgent(this.getHap(), "SolarAgent");
		this.addBehaviour(new ReceiveMessages(this, 10000));
		
	}

}
