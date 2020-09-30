//package behaviours;
//import jade.core.Agent;
//import agents.*;
//import jade.core.Agent;
//import jade.core.behaviours.TickerBehaviour;
//import jade.lang.acl.ACLMessage;
//import jade.lang.acl.MessageTemplate;
//import jade.lang.acl.UnreadableException;
//import jade.core.behaviours.OneShotBehaviour;
//import agents.BungalowAgent;
//import data.AeolianData;
//
//
//@SuppressWarnings("serial")
//public class ReceiveMessagesBungalow extends OneShotBehaviour{
//	
//	AeolianData msgAeolianData;
//	ACLMessage msg;
//	
//	
//	public ReceiveMessagesBungalow(Agent a){
//		super(a);
//	}
//	
//	public ReceiveMessagesBungalow(ACLMessage msg) {
//		try {
//			msgAeolianData = (AeolianData)msg.getContentObject();
//			this.msg=msg;
//		} catch (UnreadableException e) {
//			e.printStackTrace();
//		}
//	}
//	
//	public void action()
//	{
//		
//		
//		if (msg != null)
//		{
//			System.out.println(this.myAgent.getLocalName() + ": " + 
//					msg.getSender().getLocalName() + " dice che ha prodotto " + msgAeolianData.getWindKw()+
//					" Kw al prezzo di "+msgAeolianData.getWindPrice()+" euro al Kw.");
//		}
//		else
//		{
//			this.block();
//		}
//	}
//	
//	
//
//}
