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
import jade.core.behaviours.CyclicBehaviour;
import jade.core.behaviours.OneShotBehaviour;
import jade.domain.FIPAAgentManagement.DFAgentDescription;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;
import jade.lang.acl.UnreadableException;

 

public class AeolianBehaviour extends OneShotBehaviour{
    
	AeolianData aeolian;
    
    public AeolianBehaviour(Agent a, AeolianData aeolian)
    {
    	super(a);
    	this.aeolian = aeolian;       
    }
    
//    public AeolianBehaviour(ACLMessage msg) {
//        try {
//            this.msg = msg;
//            this.msgData = msg.getContent();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
    
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
                            "priceaeolian", aeolian);
                } else {
                	this.block();
                }
    		}
    	});
}   
}