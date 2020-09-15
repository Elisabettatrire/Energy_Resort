package behaviours;


import java.util.Calendar;

import agents.BaseAgent;
import agents.BungalowAgent;
import data.AeolianData;
import data.BungalowData;
import database.DbBungalowData;
import jade.core.Agent;
import jade.core.behaviours.OneShotBehaviour;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.UnreadableException;
import jade.lang.acl.MessageTemplate;
import jade.core.AID;

@SuppressWarnings("serial")
public class BungalowBehaviour extends OneShotBehaviour{
	

	public BungalowBehaviour(Agent a) {
		super(a);
	} 
	
	
	
	
//	public BungalowBehaviour(ACLMessage msg){
//		try {
//			this.msg = msg;
//			this.msgData = msg.getContent();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
	
	AeolianData msgAeolianData;
	BungalowData bungalow=new BungalowData();
	DbBungalowData enDb=new DbBungalowData();
	ACLMessage msg;
	
	int day;//domenica è 1...
	  
    int hour; 
	
	public void action() {
		
	
//	    Calendar calendar = Calendar.getInstance();
//		day=calendar.get(Calendar.DAY_OF_WEEK);
//		hour= calendar.get(Calendar.HOUR_OF_DAY)+1;
//		bungalow.setDayHour(hour);
//		bungalow.setWeekDay(day);
//		enDb.getBungalowData(bungalow);
		
		String aeolianMessage= "Ciao eolico, quanta energia mi puoi vendere e a che prezzo?";
		new BaseAgent().sendMessageToAgentsByServiceType(this.myAgent, "AeolianAgent",
				"energyrequest", aeolianMessage);
		
		

	}

}
