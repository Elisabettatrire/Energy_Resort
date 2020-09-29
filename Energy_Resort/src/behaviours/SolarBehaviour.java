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
import jade.core.behaviours.CyclicBehaviour;
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
    SolarData solar;
    
    public SolarBehaviour(Agent a, SolarData solar)
    {
        super(a);
        this.solar = solar;
    }
    

    
    public void action() {
    	this.myAgent.addBehaviour(new CyclicBehaviour(this.myAgent) {
    		public void action() {
    			MessageTemplate template = MessageTemplate.MatchPerformative(ACLMessage.INFORM);
    	        ACLMessage msg = this.myAgent.receive(template); 
    	        if(msg != null && (msg.getConversationId().equals("energyrequest") || msg.getConversationId().equals("recharge")))
                {
                	System.out.println(this.myAgent.getLocalName() +
                            ": " + msg.getSender().getLocalName() + " dice: " + msg.getContent());
                	new BaseAgent().sendMessageToAgentsByServiceType(this.myAgent, msg.getSender(),
                            "pricesolar", solar);
                } else {
                	this.block();
                }
    		}
    	});
} 
}