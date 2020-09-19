package behaviours;

 


import agents.BaseAgent;
import jade.core.AID;
import agents.AeolianAgent;
import agents.BungalowAgent;

 

import data.AeolianData;
import database.DbAeolianData;
import java.util.Calendar;
import java.time.*;
import jade.core.Agent;
import jade.core.behaviours.OneShotBehaviour;
import jade.domain.FIPAAgentManagement.DFAgentDescription;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;
import jade.lang.acl.UnreadableException;

 

public class AeolianBehaviour extends OneShotBehaviour{
    
//    LoadInfo loadInfo = new DbLoadInfo().getLoadInfoByIdAgent(this.myAgent.getName(), msgData.getDatetime());
//    //System.out.println("\nloadBeh id: "+loadInfo.getIdLoad()+" prima: "+msgData.getDatetime().getTime());
//    LoadData loadData = new DbLoadData().getLastLoadData(loadInfo.getIdLoad(), msgData.getDatetime());
//    //System.out.println("\nloadBeh id: "+loadInfo.getIdLoad()+" dopo: "+msgData.getDatetime().getTime());
    
    
    int day;//domenica Ã¨ 1...
  
    int hour; 
    
    ACLMessage msg;
    String msgData;
    
    AeolianData aeolian=new AeolianData();
    
    DbAeolianData windDb=new DbAeolianData();
    
    
    public AeolianBehaviour(Agent a)
    {
        super(a);
    }
    
    public AeolianBehaviour(ACLMessage msg){
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
        
        aeolian.setDayHour(hour);
        aeolian.setWeekDay(day);
        aeolian.setWindForecast( windDb.getWind(aeolian.getDayHour(), aeolian.getWeekDay()));
              
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
 
            System.out.println(this.myAgent.getLocalName() +
                     ": " + msg.getSender().getLocalName() + " dice: " + msgData);
       
            new BaseAgent().sendMessageToAgentsByServiceType(this.myAgent, "BungalowAgent",
                    "priceaeolian", aeolian);
  
    } 

}