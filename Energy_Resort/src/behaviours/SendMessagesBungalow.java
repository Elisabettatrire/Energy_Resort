package behaviours;
//package behaviours;
//
//import jade.core.AID;
//import jade.core.Agent;
//import agents.BaseAgent;
//import data.AeolianData;
//import jade.core.behaviours.OneShotBehaviour;
//import jade.lang.acl.ACLMessage;
//import jade.lang.acl.UnreadableException;
//import java.util.Hashtable;
//
//public class SendMessages extends OneShotBehaviour {
//	
//
//	ACLMessage msg;
//	AeolianData aeolian;
//	Hashtable<String, Integer> msgData;
//	String serviceType;
//	
//	public SendMessages(ACLMessage msg, String serviceType){
//		
//		this.msg = msg;
//		this.serviceType = serviceType;
//		try {
//			this.msgData = (ArrayList<TimePowerPrice>) msg.getContentObject();
//		} catch (UnreadableException e) {
//			e.printStackTrace();
//		}
//	
//	}

import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.TickerBehaviour;
import jade.core.behaviours.WakerBehaviour;
import jade.lang.acl.ACLMessage;

public class SendMessagesBungalow extends TickerBehaviour
{
	public SendMessagesBungalow(Agent a, long period)
	{
		super(a, period);
	}
	
	protected void onTick()
	{
		this.myAgent.addBehaviour(new WakerBehaviour(this.myAgent, 10000)
		{
			protected void onWake()
			{	
		ACLMessage msg = new ACLMessage(ACLMessage.INFORM);
		AID receiver = new AID();
		receiver.setLocalName("Aeolian");
		msg.setContent("Ciao eolico, quanta energia mi puoi vendere? E a che prezzo?");
		msg.setConversationId("richiesta");
		msg.addReceiver(receiver);
		this.myAgent.send(msg); }
		}
		);
	}
	

}

