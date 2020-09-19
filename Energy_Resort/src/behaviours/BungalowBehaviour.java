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
    
    BungalowData bungalow=new BungalowData();
    DbBungalowData enDb=new DbBungalowData();
    ACLMessage msg;
    
    
    int day;//domenica è 1...
      
    int hour; 
    
    DFAgentDescription[] dfagents;
    
    public void action() {

        
        String[] agents = {"AeolianAgent", "DsoAgent", "SolarAgent","BatteryAgent"};

        for(int i=0; i<agents.length; i++) {
            dfagents = new BaseAgent().getAgentsbyServiceType(this.myAgent, agents[i]);
            new BaseAgent().sendMessageToAgentsByServiceType(this.myAgent, dfagents[0].getName(), "energyrequest");
        }

 

    }

 

}