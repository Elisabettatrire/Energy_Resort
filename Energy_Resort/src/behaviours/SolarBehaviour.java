package behaviours;
import jade.core.behaviours.TickerBehaviour;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;
import jade.core.AID;
import jade.core.Agent;


public class SolarBehaviour extends TickerBehaviour{
	
	public SolarBehaviour(Agent a, long period) {
		super(a, period);
	}
    
	protected void onTick() {
ACLMessage msg = this.myAgent.receive(MessageTemplate.MatchPerformative(ACLMessage.INFORM));
		
		if (msg != null)
		{
			System.out.println(this.myAgent.getLocalName() +
					 ": ho ricevuto un messaggio da " + msg.getSender().getLocalName() );
					  System.out.println(this.myAgent.getLocalName() + ": il contenuto e'");
					 System.out.println(this.myAgent.getLocalName() + ": " + msg.getContent());
			ACLMessage reply = msg.createReply();
			AID receiver = new AID();
			receiver.setLocalName("Battery");
			reply.setContent("Ciao Battery!");
			//reply.setPerformative(ACLMessage.INFORM);
			reply.setConversationId("richiesta");
			//System.out.println(reply);
		    this.myAgent.send(reply);
				
			
			
		}
		else
		{
			this.block();
		}
	}
}
