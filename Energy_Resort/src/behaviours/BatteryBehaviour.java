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
import jade.core.behaviours.WakerBehaviour;
import jade.domain.FIPAAgentManagement.DFAgentDescription;

import java.io.Serializable;

import agents.AeolianAgent;
import agents.BatteryAgent;
import agents.BungalowAgent;
import data.BatteryData;

public class BatteryBehaviour extends OneShotBehaviour {

	BatteryData battery;

	public BatteryBehaviour(Agent a, BatteryData battery) {
		super(a);
		this.battery = battery;
	}

	public void action() {

		this.myAgent.addBehaviour(new CyclicBehaviour(this.myAgent) {
			public void action() {
				// continuare da qui
				MessageTemplate template = MessageTemplate.MatchPerformative(ACLMessage.INFORM);
				ACLMessage msg = this.myAgent.receive(template);
				if (msg != null && (msg.getConversationId().equals("energyrequest"))) {
					System.out.println(this.myAgent.getLocalName() + ": " + msg.getSender().getLocalName() + " dice: "
							+ msg.getContent());

					if (((BatteryAgent) myAgent).getDbBattery().getMyCapacity("Battery") > 10) {
						new BaseAgent().sendMessageToAgentsByServiceType(this.myAgent, msg.getSender(), "pricebattery",
								battery);
					} else {
						new BaseAgent().sendMessageToAgentsByServiceType(this.myAgent, msg.getSender(), "stopselling",
								"Non posso piu' vendere energia! Ho la capacita' al 20%.");
						((BatteryAgent) myAgent).getDbBattery().updateConsumerData(50-
								((BatteryAgent) myAgent).getDbBattery().getMyCapacity("Battery"), battery.getBudget(), "Battery");
						((BatteryAgent) myAgent).getDbBattery().updateProviderData(0, battery.getBatteryPrice(), battery.getBudget(), "Battery");
						this.myAgent.addBehaviour(new WakerBehaviour(this.myAgent, 5000) {
							protected void onWake() {
								this.myAgent.addBehaviour(new ResearchProviderBattery(this.myAgent));
							}
						});
					}
				} else if (msg != null && (msg.getConversationId().equals("BuyFromYou"))) {

					System.out.println(this.myAgent.getLocalName() + ": " + msg.getSender().getLocalName() + " dice: "
							+ msg.getContent());
					if (((BatteryAgent) myAgent).getDbBattery().getMyCapacity("Battery") > 10) {
						if (msg.getSender().getLocalName().equals(((BatteryAgent) myAgent).getDbBattery()
								.selectBestConsumer(((BatteryAgent) myAgent).getDbBattery().getMaxEnReq()))) {
							new BaseAgent().sendMessageToAgentsByServiceType(this.myAgent, msg.getSender(),
									"AnswerToClient", "Vendo a te i Kw.", ACLMessage.ACCEPT_PROPOSAL);
						} else {
							new BaseAgent().sendMessageToAgentsByServiceType(this.myAgent, msg.getSender(),
									"AnswerToClient", "Aspetta in coda.", ACLMessage.REJECT_PROPOSAL);
						}
					} else {
						new BaseAgent().sendMessageToAgentsByServiceType(this.myAgent, msg.getSender(), "stopselling",
								"Non posso piu' vendere energia! Ho la capacita' al 20%.");
						((BatteryAgent) myAgent).getDbBattery().updateConsumerData(50-
								((BatteryAgent) myAgent).getDbBattery().getMyCapacity("Battery"), battery.getBudget(), "Battery");
						((BatteryAgent) myAgent).getDbBattery().updateProviderData(0, battery.getBatteryPrice(), battery.getBudget(), "Battery");
						this.myAgent.addBehaviour(new WakerBehaviour(this.myAgent, 5000) {
							protected void onWake() {
								this.myAgent.addBehaviour(new ResearchProviderBattery(this.myAgent));
							}
						});
					}
				} else if(msg != null && (msg.getConversationId().equals("AnswerToClient")))  {
					this.myAgent.addBehaviour(new KwsProposalBehaviour(msg));
				} else if(msg != null && (msg.getConversationId().equals("WakeUp"))) {
					this.myAgent.addBehaviour(new ResearchProviderBattery(this.myAgent));
				}
				else {
					this.block();
				}
				MessageTemplate template1 = MessageTemplate.or(MessageTemplate.MatchPerformative(ACLMessage.ACCEPT_PROPOSAL), MessageTemplate.MatchPerformative(ACLMessage.REJECT_PROPOSAL));
				ACLMessage msg1 = this.myAgent.receive(template1);
				if (msg1 != null && (msg1.getConversationId().equals("AnswerToClient"))) {
					if(msg1 != null && msg1.getPerformative()==ACLMessage.ACCEPT_PROPOSAL ) 
					{
						System.out.println(this.myAgent.getLocalName()+": "+msg1.getSender().getLocalName()+" dice: "+msg1.getContent());
						new BaseAgent().sendMessageToAgentsByServiceType(this.myAgent, msg1.getSender(),
			                    "AnswerToClient", "Grazie!");

					} else if(msg1 != null && msg1.getPerformative()==ACLMessage.REJECT_PROPOSAL) 
					{
						System.out.println(this.myAgent.getLocalName()+": "+msg1.getSender().getLocalName()+" dice: "+msg1.getContent());
						//l agente deve attendere in coda che il prescelto abbia finito col fornitore e poi deve ritornare a chiedere i kw
						
					}
				} else {
					this.block();
				}
			}
		});

	}
}
