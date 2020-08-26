package behaviours;


import agents.BaseAgent;

import agents.AeolianAgent;
import data.AeolianData;
import database.DbAeolianData;
import java.util.Calendar;
import java.time.*;
import jade.core.Agent;
import jade.core.behaviours.TickerBehaviour;
import jade.domain.FIPAAgentManagement.DFAgentDescription;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.UnreadableException;

public class AeolianBehaviour extends TickerBehaviour{
	
//	LoadInfo loadInfo = new DbLoadInfo().getLoadInfoByIdAgent(this.myAgent.getName(), msgData.getDatetime());
//	//System.out.println("\nloadBeh id: "+loadInfo.getIdLoad()+" prima: "+msgData.getDatetime().getTime());
//	LoadData loadData = new DbLoadData().getLastLoadData(loadInfo.getIdLoad(), msgData.getDatetime());
//	//System.out.println("\nloadBeh id: "+loadInfo.getIdLoad()+" dopo: "+msgData.getDatetime().getTime());
	
	Calendar calendar = Calendar.getInstance() ;
    int day=calendar.get(Calendar.DAY_OF_WEEK);//domenica è 1...
  
    int hour = calendar.get(Calendar.HOUR_OF_DAY)+1;
    
  

	AeolianData aeolian=new AeolianData();
	
	DbAeolianData windDb=new DbAeolianData();
	
	
	public AeolianBehaviour(Agent a, long period)
	{
		super(a, period);
		
	}
	
	protected void onTick() {
		
		aeolian.setDayHour(hour);
		aeolian.setWeekDay(day);
		aeolian.setWindForecast( windDb.getWind(aeolian.getDayHour(), aeolian.getWeekDay()));
		
		System.out.println("il vento è: "+aeolian.getWindForecast()); 
		  System.out.println("il giorno è: "+day);
		  System.out.println("l'ora è: " + hour);
		
		if(aeolian.getWindForecast()==1) {
			
			aeolian.setWindPrice(0.3);
		}
		else if(aeolian.getWindForecast()==2){
			aeolian.setWindPrice(0.6);
			}
		else {
		aeolian.setWindPrice(1.2);
		}
		
		System.out.println("il prezzo dell'energia eolica è: "+aeolian.getWindPrice());
}
}
