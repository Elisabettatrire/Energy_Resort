package behaviours;


import agents.BaseAgent;
import agents.BungalowAgent;
import data.BungalowData;
import database.DbBungalowData;
import jade.core.Agent;
import jade.core.behaviours.TickerBehaviour;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.UnreadableException;
import jade.lang.acl.MessageTemplate;
import jade.core.AID;

@SuppressWarnings("serial")
public class BungalowBehaviour extends TickerBehaviour{
	

	public BungalowBehaviour(Agent a, long period) {
		super(a, period);
	} 
//	ResultPowerPrice msgData;
//	
//	public BungalowBehaviour(ACLMessage msg) {
//		try {
//			msgData = (ResultPowerPrice)msg.getContentObject();
//		} catch (UnreadableException e) {
//			e.printStackTrace();
//		}
//	}
	
	String msgData;
	
	
	protected void onTick() {
		
		//BungalowData bungalowData = new DbBungalowData().getBungalowData();
		
		//System.out.println("il budget è: "+bungalowData.getBudget()+", i bisogni sono:  "+ bungalowData.getEnReq()+
			//	", l'ora è: "+ bungalowData.getDayHour()+ ", il giorno è: "+ bungalowData.getWeekDay());
		
 	  // ACLMessage msg = new ACLMessage(ACLMessage.INFORM);
       //msg.setContent( "bla...bla...bla" );
//	     for (int i = 1; i<=2; i++)
//	        msg.addReceiver( new AID( "Aeolian" + i, AID.ISLOCALNAME) );
//	     send(msg);
//	     
		msgData = "Ciao eolico, quanta energia mi puoi vendere? E a che prezzo?";
	    AID aid=new AID("Aeolian", AID.ISLOCALNAME);
		new BaseAgent().sendMessageToAgentsByServiceType(this.myAgent, 
				aid, "request", msgData);
	}

}
