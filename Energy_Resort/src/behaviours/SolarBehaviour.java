package behaviours;

 


import agents.BaseAgent;
import jade.core.AID;
import agents.AeolianAgent;
import agents.BungalowAgent;

 

import data.SolarData;
import database.DbSolarData;
import java.util.Calendar;
import java.time.*;
import jade.core.Agent;
import jade.core.behaviours.OneShotBehaviour;
import jade.domain.FIPAAgentManagement.DFAgentDescription;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;
import jade.lang.acl.UnreadableException;

 

public class SolarBehaviour extends OneShotBehaviour{
    
//    LoadInfo loadInfo = new DbLoadInfo().getLoadInfoByIdAgent(this.myAgent.getName(), msgData.getDatetime());
//    //System.out.println("\nloadBeh id: "+loadInfo.getIdLoad()+" prima: "+msgData.getDatetime().getTime());
//    LoadData loadData = new DbLoadData().getLastLoadData(loadInfo.getIdLoad(), msgData.getDatetime());
//    //System.out.println("\nloadBeh id: "+loadInfo.getIdLoad()+" dopo: "+msgData.getDatetime().getTime());
    
    
    int day;//domenica Ã¨ 1...
  
    int hour; 
    
    ACLMessage msg;

 

    SolarData solar = new SolarData();
    
    DbSolarData solarDb=new DbSolarData();
    
    String msgData;
    
    public SolarBehaviour(Agent a)
    {
        super(a);
    }
    
    public SolarBehaviour(ACLMessage msg){
        try {
            this.msg = msg;
            this.msgData = msg.getContent();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void action() {
        Calendar calendar = Calendar.getInstance();
        day=calendar.get(Calendar.DAY_OF_WEEK);
        hour= calendar.get(Calendar.HOUR_OF_DAY)+1;
        solar.setDayHour(hour);
        solar.setWeekDay(day);
        solar.setSolarForecast(solarDb.getWeather(solar.getDayHour(), solar.getWeekDay()));
        
//        System.out.println("il vento e': "+aeolian.getWindForecast()); 
//          System.out.println("il giorno e': "+day);
//          System.out.println("l'ora e': " + hour);
        
        if(solar.getSolarForecast()==1) {          
            solar.setSolarPrice(0.2);
            solar.setSolarKw(20);
        }
        else if(solar.getSolarForecast()==2){
            solar.setSolarPrice(0.4);
            solar.setSolarKw(15);
            }
        else if(solar.getSolarForecast()==3){
        	solar.setSolarPrice(0.8);
            solar.setSolarKw(5);
        } else if(solar.getSolarForecast()==4){
        	solar.setSolarPrice(1);
            solar.setSolarKw(2);
        } else if(solar.getSolarForecast()==5){
        	solar.setSolarPrice(0.6);
            solar.setSolarKw(10);
        } 
           
            System.out.println(this.myAgent.getLocalName() +
                     ": " + msg.getSender().getLocalName() + " dice: " + msgData);

            new BaseAgent().sendMessageToAgentsByServiceType(this.myAgent, "BungalowAgent",
                    "pricesolar", solar);
       

    }

 

}