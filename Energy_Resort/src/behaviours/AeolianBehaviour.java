package behaviours;


import agents.BaseAgent;
import agents.AeolianAgent;
import data.AeolianData;
import database.DbAeolianData;
import jade.core.Agent;
import jade.core.behaviours.TickerBehaviour;
import jade.domain.FIPAAgentManagement.DFAgentDescription;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.UnreadableException;

public class AeolianBehaviour extends TickerBehaviour{
	

	AeolianData aeolian;
	DbAeolianData windDb;
	long period=5000;
	
	public AeolianBehaviour(Agent a, long period)
	{
		super(a, period);
		
	}

	
	
	protected void onTick() {
		
		
		aeolian.setWindForecast( windDb.getWind(aeolian.getDayHour(), aeolian.getWeekDay()));
		
		//System.out.println(s1.equals(s2)); 
		
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
