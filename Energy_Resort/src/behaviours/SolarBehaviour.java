package behaviours;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;
import jade.core.AID;
import jade.core.Agent;
import agents.BatteryAgent;



public class SolarBehaviour extends CyclicBehaviour{
	
	public SolarBehaviour(Agent a) {
		super(a);
	}
    
	public void action() {
// ACLMessage msg = this.myAgent.receive(MessageTemplate.MatchPerformative(ACLMessage.INFORM));
		
//		if (msg != null)
//		{
//			System.out.println(this.myAgent.getLocalName() +
//					 ": ho ricevuto un messaggio da " + msg.getSender().getLocalName() );
//					  System.out.println(this.myAgent.getLocalName() + ": il contenuto e'");
//					 System.out.println(this.myAgent.getLocalName() + ": " + msg.getContent());
//			ACLMessage reply = msg.createReply();
//			AID receiver = new AID();
//			receiver.setLocalName("Battery");
//			reply.setContent("Ciao batteria!");
//			//reply.setPerformative(ACLMessage.INFORM);
//			reply.setConversationId("richiesta");
//			//System.out.println(reply);
//		    this.myAgent.send(reply);
		    try {
				//MessageTemplate template = MessageTemplate.MatchPerformative(ACLMessage.INFORM);
			    ACLMessage msg = this.myAgent.receive(MessageTemplate.MatchPerformative(ACLMessage.INFORM)); 
		    if (msg!=null){
		    	System.out.println(this.myAgent.getLocalName() +
						 ": " + msg.getSender().getLocalName() + " dice: " + msg.getContent());
					//if(this.myAgent.getLocalName()=="Battery")
					//{
						
							ACLMessage reply = msg.createReply();
							AID receiver = new AID();
							receiver.setLocalName("Battery");
							reply.setContent("Non ce n'e' Coviddi!");
							reply.setPerformative(ACLMessage.INFORM);
							reply.setConversationId("Covid");
							//System.out.println(reply);
						    this.myAgent.send(reply);
					//}
			}	
		    }
		    catch (Exception e) {
				e.printStackTrace();
		}
	}
}

