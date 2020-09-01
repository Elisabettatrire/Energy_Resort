package behaviours;


import agents.BaseAgent;
import jade.core.AID;
import agents.AeolianAgent;
import data.AeolianData;
import database.DbAeolianData;
import java.util.Calendar;
import java.time.*;
import jade.core.Agent;
import jade.core.behaviours.OneShotBehaviour;
import jade.domain.FIPAAgentManagement.DFAgentDescription;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.UnreadableException;

public class AeolianBehaviour extends OneShotBehaviour{
	
//	LoadInfo loadInfo = new DbLoadInfo().getLoadInfoByIdAgent(this.myAgent.getName(), msgData.getDatetime());
//	//System.out.println("\nloadBeh id: "+loadInfo.getIdLoad()+" prima: "+msgData.getDatetime().getTime());
//	LoadData loadData = new DbLoadData().getLastLoadData(loadInfo.getIdLoad(), msgData.getDatetime());
//	//System.out.println("\nloadBeh id: "+loadInfo.getIdLoad()+" dopo: "+msgData.getDatetime().getTime());
	
	Calendar calendar = Calendar.getInstance() ;
    int day=calendar.get(Calendar.DAY_OF_WEEK);//domenica è 1...
  
    int hour = calendar.get(Calendar.HOUR_OF_DAY)+1;
    
  

	AeolianData aeolian=new AeolianData();
	
	DbAeolianData windDb=new DbAeolianData();
	
	String msgData;
	
	public AeolianBehaviour(Agent a)
	{
		super(a);
		
	}
	
	public void action() {
		
		aeolian.setDayHour(hour);
		aeolian.setWeekDay(day);
		aeolian.setWindForecast( windDb.getWind(aeolian.getDayHour(), aeolian.getWeekDay()));
		
		System.out.println("il vento è: "+aeolian.getWindForecast()); 
		  System.out.println("il giorno è: "+day);
		  System.out.println("l'ora è: " + hour);
		
		if(aeolian.getWindForecast()==1) {
			
			aeolian.setWindPrice(0.3);
			aeolian.setWindKw(10);
		}
		else if(aeolian.getWindForecast()==2){
			aeolian.setWindPrice(0.6);
			aeolian.setWindKw(5);
			}
		else {
		aeolian.setWindPrice(1.2);
		aeolian.setWindKw(2);
		}
		
//		System.out.println("il prezzo dell'energia eolica è: "+aeolian.getWindPrice());
//		System.out.println("i kw prodotti sono: "+aeolian.getWindKw());
		
		
		msgData = "Ho prodotto "+aeolian.getWindKw()+" kW e il prezzo �: "+aeolian.getWindPrice()+" euro al kW.";

		AID aid=new AID("Bungalow", AID.ISLOCALNAME);
		new BaseAgent().sendMessageToAgentsByServiceType(this.myAgent,
		aid, "request", msgData);

}
}
