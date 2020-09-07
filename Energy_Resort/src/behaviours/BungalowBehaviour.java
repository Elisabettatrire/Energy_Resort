package behaviours;


import java.util.Calendar;

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
	BungalowData bungalow=new BungalowData();
	DbBungalowData enDb=new DbBungalowData();
	String msgData;
	
	int day;//domenica è 1...
	  
    int hour; 
	
	protected void onTick() {
		
		//BungalowData bungalowData = new DbBungalowData().getBungalowData();
		
		
		
 	  // ACLMessage msg = new ACLMessage(ACLMessage.INFORM);
       //msg.setContent( "bla...bla...bla" );
//	     for (int i = 1; i<=2; i++)
//	        msg.addReceiver( new AID( "Aeolian" + i, AID.ISLOCALNAME) );
//	     send(msg);
	    Calendar calendar = Calendar.getInstance();
		day=calendar.get(Calendar.DAY_OF_WEEK);
		hour= calendar.get(Calendar.HOUR_OF_DAY)+1;
		bungalow.setDayHour(hour);
		bungalow.setWeekDay(day);
		enDb.getBungalowData(bungalow);
		
//		msgData = "Ciao eolico, quanta energia mi puoi vendere? E a che prezzo?";
//	    AID aid=new AID("Aeolian", AID.ISLOCALNAME);
//		new BaseAgent().sendMessageToAgentsByServiceType(this.myAgent, 
//				aid, "request", msgData);
//		System.out.println("il budget e': "+bungalow.getBudget()+", i bisogni sono: "+ bungalow.getEnReq()+
//				", l'ora e': "+ bungalow.getDayHour()+ ", il giorno e': "+ bungalow.getWeekDay());
	}

}
