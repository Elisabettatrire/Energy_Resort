package agents;
import behaviours.SolarBehaviour;


public class SolarAgent extends BaseAgent{
	
	protected void setup(){
		registerDfAgent(this.getHap(), "SolarAgent");
		this.addBehaviour(new SolarBehaviour(this));
		
	}

}
