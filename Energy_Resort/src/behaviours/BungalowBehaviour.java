package behaviours;


import agents.BaseAgent;
import agents.BungalowAgent;
import data.BungalowData;
import database.DbBungalowData;
import jade.core.Agent;
import jade.core.behaviours.OneShotBehaviour;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.UnreadableException;

@SuppressWarnings("serial")
public class BungalowBehaviour extends OneShotBehaviour{
	
	//String nameBudget="Budget_b1";
	//String nameNeeds="Bisogni_b1";
	//int dayHour=1;
	//int weekDay=1;
	
	public BungalowBehaviour(Agent a) {
		super(a);
	} 
	
	public void action() {
		
		//BungalowData bungalowData = new DbBungalowData().getBungalowData();
		
		//System.out.println("il budget è: "+bungalowData.getBudget()+", i bisogni sono:  "+ bungalowData.getEnReq()+
			//	", l'ora è: "+ bungalowData.getDayHour()+ ", il giorno è: "+ bungalowData.getWeekDay());
		
	}

}
