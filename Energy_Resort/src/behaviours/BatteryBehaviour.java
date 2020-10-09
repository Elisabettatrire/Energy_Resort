package behaviours;

import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.core.behaviours.OneShotBehaviour;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;
import jade.lang.acl.UnreadableException;
import agents.BaseAgent;
import agents.SolarAgent;
import jade.core.behaviours.TickerBehaviour;
import jade.domain.FIPAAgentManagement.DFAgentDescription;

import java.io.Serializable;

import agents.AeolianAgent;
import agents.BatteryAgent;
import data.BatteryData;

public class BatteryBehaviour extends OneShotBehaviour{
	
	BatteryData battery;
	int max = 3;
	int min = 1;
	int random_int = (int)(Math.random() * (max - min + 1) + min);
	
	public BatteryBehaviour(Agent a, BatteryData battery) {
		super(a);
		this.battery = battery;  
	} 
	
//	public BatteryBehaviour(ACLMessage msg){
//	        try {
//	            this.msg = msg;
//	            this.msgData = msg.getContent();
//	        } catch (Exception e) {
//	            e.printStackTrace();
//	        }
//	}
//	
	public void action() {
		
		this.myAgent.addBehaviour(new CyclicBehaviour(this.myAgent) {
			public void action() {
				MessageTemplate template = MessageTemplate.MatchPerformative(ACLMessage.INFORM);
    	        ACLMessage msg = this.myAgent.receive(template); 
    	        if(msg != null && (msg.getConversationId().equals("energyrequest") ))
    	        {
					System.out.println(this.myAgent.getLocalName() +
					": " + msg.getSender().getLocalName() + " dice: " + msg.getContent());
		
					if(battery.getCapacity()>10) {
						new BaseAgent().sendMessageToAgentsByServiceType(this.myAgent, msg.getSender(),
						"pricebattery", battery);
					}else {
						new BaseAgent().sendMessageToAgentsByServiceType (this.myAgent, msg.getSender(), 
								"stopselling", "Non posso piu' vendere energia! Ho la capacita' al 20%.");
						 String[] agents = {"AeolianAgent", "DsoAgent", "SolarAgent"};
							for(int i=0; i<agents.length; i++) {
					            DFAgentDescription[] dfagents = new BaseAgent().getAgentsbyServiceType(this.myAgent, agents[i]);
					           // System.out.println(dfagents);
					           // new BaseAgent().sendMessageToAgentsByServiceType(this.myAgent, dfagents[0].getName(), "recharge");
					        }
					}
    	        } 
    	        else if(msg != null && (msg.getConversationId().equals("BuyFromYou") )) {
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
