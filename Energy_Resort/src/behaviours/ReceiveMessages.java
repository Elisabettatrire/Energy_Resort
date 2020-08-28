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
public class ReceiveMessages extends CyclicBehaviour{
	
	public ReceiveMessages(Agent a){
		super(a);
	}
	
	public void action()
	{
		ACLMessage msg = this.myAgent.receive(MessageTemplate.MatchPerformative(ACLMessage.INFORM));
		
		if (msg != null)
		{
			System.out.println(this.myAgent.getLocalName() + ": ho ricevuto un msg da " + 
					msg.getSender().getLocalName()
				);
			System.out.println(this.myAgent.getLocalName() + ": il contenuto e'");
			System.out.println(this.myAgent.getLocalName() + ": " + msg.getContent());
		}
		else
		{
			this.block();
		}
	}
	
	

}
