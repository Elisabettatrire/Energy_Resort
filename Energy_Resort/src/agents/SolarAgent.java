package agents;
import behaviours.SolarBehaviour;
import behaviours.ReceiveMessagesBungalow;

public class SolarAgent extends BaseAgent{
	
	protected void setup(){
		registerDfAgent(this.getHap(), "SolarAgent");
		this.addBehaviour(new SolarBehaviour(this, 20000));
		
	}

}
