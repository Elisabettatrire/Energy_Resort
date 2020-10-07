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
    int max = 3;
	int min = 1;
	int random_int = (int)(Math.random() * (max - min + 1) + min);
    
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
                } 
    	        else if(msg != null && msg.getConversationId().equals("BuyFromYou")) {
                	
                	System.out.println(this.myAgent.getLocalName() +
                            ": " + msg.getSender().getLocalName() + " dice: " + msg.getContent());
                	
					//System.out.println(random_int);
					if (msg.getSender().getLocalName().equals("Bungalow"+random_int))
					{
						new BaseAgent().sendMessageToAgentsByServiceType(this.myAgent, msg.getSender(),
							"AnswerToClient", "Vendo a te i Kw.", ACLMessage.ACCEPT_PROPOSAL);
						}
					else
						{new BaseAgent().sendMessageToAgentsByServiceType(this.myAgent, msg.getSender(),
								"AnswerToClient", "Aspetta in coda.", ACLMessage.REJECT_PROPOSAL);
						}
                } 
    	        else {
                	this.block();
                }
    		}
    	});
} 
}