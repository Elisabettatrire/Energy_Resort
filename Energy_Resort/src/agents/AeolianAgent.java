package agents;
import behaviours.AeolianBehaviour;
import behaviours.ReceiveMessages;

public class AeolianAgent extends BaseAgent{
	
	protected void setup(){
		
		registerDfAgent(this.getHap(), "AeolianAgent");
		//this.addBehaviour(new AeolianBehaviour(this));
	}


}
