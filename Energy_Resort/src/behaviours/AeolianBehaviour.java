package behaviours;


import agents.BaseAgent;
import jade.core.AID;
import agents.AeolianAgent;
import data.AeolianData;
import database.DbAeolianData;
import java.util.Calendar;
import java.time.*;
import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.core.behaviours.TickerBehaviour;
import jade.core.behaviours.WakerBehaviour;
import jade.domain.FIPAAgentManagement.DFAgentDescription;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;
import jade.lang.acl.UnreadableException;

public class AeolianBehaviour extends CyclicBehaviour{
	
//	LoadInfo loadInfo = new DbLoadInfo().getLoadInfoByIdAgent(this.myAgent.getName(), msgData.getDatetime());
//	//System.out.println("\nloadBeh id: "+loadInfo.getIdLoad()+" prima: "+msgData.getDatetime().getTime());
//	LoadData loadData = new DbLoadData().getLastLoadData(loadInfo.getIdLoad(), msgData.getDatetime());
//	//System.out.println("\nloadBeh id: "+loadInfo.getIdLoad()+" dopo: "+msgData.getDatetime().getTime());
	
	
    int day;//domenica è 1...
  
    int hour; 
    
  

	AeolianData aeolian=new AeolianData();
	
	DbAeolianData windDb=new DbAeolianData();
	
	String msgData;
	
	public AeolianBehaviour(Agent a)
	{
		super(a);
	}
	
	public void action() {
		Calendar calendar = Calendar.getInstance();
		day=calendar.get(Calendar.DAY_OF_WEEK);
		hour= calendar.get(Calendar.HOUR_OF_DAY)+1;
		aeolian.setDayHour(hour);
		aeolian.setWeekDay(day);
		aeolian.setWindForecast( windDb.getWind(aeolian.getDayHour(), aeolian.getWeekDay()));
		
		System.out.println("il vento e': "+aeolian.getWindForecast()); 
		  System.out.println("il giorno e': "+day);
		  System.out.println("l'ora e': " + hour);
		
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
		
ACLMessage msg = this.myAgent.receive(MessageTemplate.MatchPerformative(ACLMessage.INFORM));
		
		if (msg != null)
		{
			System.out.println(this.myAgent.getLocalName() +
					 ": ho ricevuto un messaggio da " + msg.getSender().getLocalName() );
					  System.out.println(this.myAgent.getLocalName() + ": il contenuto e'");
					 System.out.println(this.myAgent.getLocalName() + ": " + msg.getContent());
			ACLMessage reply = msg.createReply();
			AID receiver = new AID();
			receiver.setLocalName("Bungalow");
			reply.setContent("Ho prodotto "+aeolian.getWindKw()+
					" kW e il prezzo e': "+aeolian.getWindPrice()+" euro al kW.");
			//reply.setPerformative(ACLMessage.INFORM);
			reply.setConversationId("richiesta");
			//System.out.println(reply);
		    this.myAgent.send(reply);
				
			
			
		}
		else
		{
			this.block();
		}
	}

}


