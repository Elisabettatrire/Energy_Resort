package behaviours;

 


import java.util.Calendar;

 

import agents.AeolianAgent;
import agents.BaseAgent;
import agents.BatteryAgent;
import agents.BungalowAgent;
import agents.DsoAgent;
import agents.SolarAgent;
import data.AeolianData;
import data.BungalowData;
import database.DbBungalowData;
import jade.core.Agent;
import jade.core.behaviours.OneShotBehaviour;
import jade.domain.FIPAAgentManagement.DFAgentDescription;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.UnreadableException;
import jade.lang.acl.MessageTemplate;
import jade.core.AID;

 

@SuppressWarnings("serial")
public class BungalowBehaviour extends OneShotBehaviour{
    

 

    public BungalowBehaviour(Agent a) {
        super(a);
    } 
    
    
    
    
//    public BungalowBehaviour(ACLMessage msg){
//        try {
//            this.msg = msg;
//            this.msgData = msg.getContent();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
    BungalowData bungalow=new BungalowData();
    DbBungalowData enDb=new DbBungalowData();
    ACLMessage msg;
    
    
    int day;//domenica Ã¨ 1...
      
    int hour; 
    
    DFAgentDescription[] dfagents;
    
    public void action() {
        
    
//        Calendar calendar = Calendar.getInstance();
//        day=calendar.get(Calendar.DAY_OF_WEEK);
//        hour= calendar.get(Calendar.HOUR_OF_DAY)+1;
//        bungalow.setDayHour(hour);
//        bungalow.setWeekDay(day);
//        enDb.getBungalowData(bungalow);
        
        
        String[] agents = {"AeolianAgent", "DsoAgent", "SolarAgent"};
        
        // System.out.println(dfagents);

 

        for(int i=0; i<agents.length; i++) {
            dfagents = new BaseAgent().getAgentsbyServiceType(this.myAgent, agents[i]);
            new BaseAgent().sendMessageToAgentsByServiceType(this.myAgent, dfagents[0].getName(), "energyrequest");
        }

 

    }

 

}