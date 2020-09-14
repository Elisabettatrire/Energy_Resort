package agents;
import behaviours.AeolianBehaviour;
//import behaviours.ReceiveMessagesAeolian;


public class AeolianAgent extends BaseAgent{
	
	protected void setup(){
		
		registerDfAgent(this.getHap(), "AeolianAgent");
		this.addBehaviour(new AeolianBehaviour(this));
		//this.addBehaviour(new ReceiveMessagesAeolian(this));
	}


}
