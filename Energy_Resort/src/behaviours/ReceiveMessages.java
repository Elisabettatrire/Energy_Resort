package behaviours;
import jade.core.Agent;
import agents.*;
import jade.core.Agent;
import jade.core.behaviours.TickerBehaviour;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;
import jade.lang.acl.UnreadableException;

@SuppressWarnings("serial")
public class ReceiveMessages extends TickerBehaviour{
	
	public ReceiveMessages(Agent a){
		super(a, 1000);
	}
	
	@Override
	protected void onTick() {
		// TODO Auto-generated method stub
		
	}
	
	

}
