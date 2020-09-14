package behaviours;
import jade.core.Agent;
import agents.*;
import jade.core.Agent;
import jade.core.behaviours.TickerBehaviour;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;
import jade.lang.acl.UnreadableException;
import jade.core.behaviours.CyclicBehaviour;
import agents.BungalowAgent;


@SuppressWarnings("serial")
public class ReceiveMessagesBungalow extends CyclicBehaviour{
	
	public ReceiveMessagesBungalow(Agent a){
		super(a);
	}
	
	public void action()
	{
		ACLMessage msg = this.myAgent.receive(MessageTemplate.MatchPerformative(ACLMessage.INFORM));
		
		if (msg != null)
		{
			System.out.println(this.myAgent.getLocalName() + ": " + 
					msg.getSender().getLocalName() + " dice: " + msg.getContent());
		}
		else
		{
			this.block();
		}
	}
	
	

}
