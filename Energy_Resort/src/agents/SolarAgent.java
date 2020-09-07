package agents;
import behaviours.ReceiveMessagesBungalow;

public class SolarAgent extends BaseAgent{
	
	protected void setup(){
		registerDfAgent(this.getHap(), "SolarAgent");
		
	}

}
