package behaviours;

import jade.core.AID;
import jade.core.Agent;
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
	
	ACLMessage msg;
	String msgData;
	BatteryData battery = new BatteryData();
	
	public BatteryBehaviour(Agent a) {
		super(a);
	} 
	
	public BatteryBehaviour(ACLMessage msg){
	        try {
	            this.msg = msg;
	            this.msgData = msg.getContent();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	}
	
	public void action() {
		
		System.out.println(this.myAgent.getLocalName() +
				 ": " + msg.getSender().getLocalName() + " dice: " + msg.getContent());
		
		 new BaseAgent().sendMessageToAgentsByServiceType(this.myAgent, "BungalowAgent",
                 "pricebattery", battery);
		 
		this.myAgent.addBehaviour(new TickerBehaviour(this.myAgent, 1000)
		{
			protected void onTick()
			{				
				if(battery.getCapacity()<=10 && msg.getConversationId().equals("energyrequest")) {
					new BaseAgent().sendMessageToAgentsByServiceType (this.myAgent, "BungalowAgent", 
							"stopselling", "Non posso piu' vendere energia! Ho la capacita' al 20%.");
					MessageTemplate template = MessageTemplate.MatchConversationId("recharge");
				    ACLMessage msg = this.myAgent.receive(template);
				}
				else if(battery.getCapacity()<=10 ) {
					String[] agents = {"AeolianAgent", "DsoAgent", "SolarAgent"};
					for(int i=0; i<agents.length; i++) {
			            DFAgentDescription[] dfagents = new BaseAgent().getAgentsbyServiceType(this.myAgent, agents[i]);
			            new BaseAgent().sendMessageToAgentsByServiceType(this.myAgent, dfagents[0].getName(), "recharge");
			        }

				}
			}
		});


	}
}
