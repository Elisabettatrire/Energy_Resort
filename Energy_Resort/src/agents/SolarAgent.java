package agents;
import behaviours.ReceiveMessages;

public class SolarAgent extends BaseAgent{
	
	protected void setup(){
		registerDfAgent(this.getHap(), "SolarAgent");
		
	}

}
