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
public class BungalowBehaviour extends OneShotBehaviour {
    
	BungalowData bungalow=new BungalowData();
    DbBungalowData bungalowDb=new DbBungalowData();
    ACLMessage msg;
    int day;
    int hour;
 

    public BungalowBehaviour(Agent a) {
        super(a);
    } 
    
    DFAgentDescription[] dfagents;
    
    public void action() {
    	Calendar calendar = Calendar.getInstance();
        day=calendar.get(Calendar.DAY_OF_WEEK);
        hour= calendar.get(Calendar.HOUR_OF_DAY)+2;
        bungalow.setDayHour(hour);
        bungalow.setWeekDay(day);
        bungalow.setId(bungalowDb.getBungalowID(this.myAgent.getLocalName()));
        bungalow.setBudget(bungalowDb.getBungalowData(bungalow).getBudget());
        bungalow.setEnReq(bungalowDb.getBungalowData(bungalow).getEnReq());
        
        System.out.println("Sono l'agente "+this.myAgent.getLocalName()+" e il mio ID e' "+bungalow.getId());
        
        String[] agents = {"AeolianAgent", "DsoAgent", "SolarAgent","BatteryAgent"};

        for(int i=0; i<agents.length; i++) {
            dfagents = new BaseAgent().getAgentsbyServiceType(this.myAgent, agents[i]);
            new BaseAgent().sendMessageToAgentsByServiceType(this.myAgent, dfagents[0].getName(), "energyrequest");
        }
    }
}