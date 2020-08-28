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
//	@Override
//	public void action() {
//		
//		//new BaseAgent().sendMessageToAgentsByServiceType(this.myAgent, serviceType,
//		//	"input", msgData);
//		ACLMessage msg = new ACLMessage(ACLMessage.INFORM);
//		AID receiver = new AID();
//		receiver.setLocalName("Gilbert");
//		msg.setContent("messaggio");
//		msg.addReceiver(receiver);
//		msg.setConversationId("idconversazione");
//		
//		this.myAgent.send(msg);
//	
//	}
//
//}
