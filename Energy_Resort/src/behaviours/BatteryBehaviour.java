package behaviours;

import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.TickerBehaviour;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;
import jade.lang.acl.UnreadableException;
import agents.BaseAgent;
import agents.BatteryAgent;
import data.BatteryData;

public class BatteryBehaviour extends TickerBehaviour{
	
	public BatteryBehaviour(Agent a, long period) {
		super(a, period);
	} 
	
	BatteryData battery = new BatteryData();
	
	protected void onTick() {
//		if(battery.getCapacity() <= 20) {
//			ACLMessage msg = new ACLMessage(ACLMessage.INFORM);
//			AID receiver = new AID();
//			receiver.setLocalName("Aeolian");
//			try{
//				MessageTemplate template = MessageTemplate.MatchPerformative(ACLMessage.INFORM);
//				ACLMessage msg = this.myAgent.receive(template); 
//				if (msg!=null){
//					if(this.myAgent instanceof TsoAgent)
//					{
//						if(msg.getConversationId().equals("finish"))
//						{
//							this.myAgent.addBehaviour(new TsoBehaviour(msg));
//						}
//					}
//					if(this.myAgent instanceof GridAgent)
//					{
//						if(msg.getConversationId().equals("input"))
//						{
//							this.myAgent.addBehaviour(new CalculatePricesBehaviour(msg));
//						}
//						else if(msg.getConversationId().equals("result"))
//						{
//							this.myAgent.addBehaviour(new GiveOutput(msg));
//						}
//					}
//					else if(this.myAgent instanceof ControlAgent)
//					{
//						if(msg.getConversationId().equals("input"))
//						{
//							new BaseAgent().sendMessageToAgentsByServiceType(this.myAgent, "AggregatorAgent", 
//										"input", msg.getContentObject());
//						}
//						else if(msg.getConversationId().equals("proposal"))
//						{
//							this.myAgent.addBehaviour(new ControlBehaviour(msg));
//						}
//						else if(msg.getConversationId().equals("ok"))
//						{
//							this.myAgent.addBehaviour(new ControlOkBehaviour(msg));
//						}
//					}
//					else if(this.myAgent instanceof BatteryAgent)
//					{
//						if(msg.getConversationId().equals("input"))
//						{
//							this.myAgent.addBehaviour(new BatteryFlexibilityBehaviour(msg));
//						}
//						else if(msg.getConversationId().equals("result"))
//						{
//							this.myAgent.addBehaviour(new BatteryBehaviour(msg));
//						}
//					}
//					else if(this.myAgent instanceof LoadAgent)
//					{
//						if(msg.getConversationId().equals("input"))
//						{
//							this.myAgent.addBehaviour(new LoadFlexibilityBehaviour(msg));
//						}
//						else if(msg.getConversationId().equals("permission"))
//						{
//							this.myAgent.addBehaviour(new LoadFlexibilityBehaviour(msg));
//						}
//						else if(msg.getConversationId().equals("result"))
//						{
//							this.myAgent.addBehaviour(new LoadBehaviour(msg));
//						}
//					}
//					else if(this.myAgent instanceof DerAgent)
//					{
//						if(msg.getConversationId().equals("input"))
//						{
//							this.myAgent.addBehaviour(new DerFlexibilityBehaviour(msg));
//						}
//						else if(msg.getConversationId().equals("result"))
//						{
//							this.myAgent.addBehaviour(new DerBehaviour(msg));
//						}
//					}
//					else if(this.myAgent instanceof LoadAggregatorAgent)
//					{
//						if(msg.getConversationId().equals("input"))
//						{
//							this.myAgent.addBehaviour(new SendPricesToAgents(msg, "LoadAgent"));
//						}
//						else if(msg.getConversationId().equals("proposal"))
//						{
//							this.myAgent.addBehaviour(new AggregateLoadBehaviour(msg));
//						}
//						else if(msg.getConversationId().equals("result"))
//						{
//							this.myAgent.addBehaviour(new DisaggregateLoadBehaviour(msg));
//						}
//						else if(msg.getConversationId().equals("ok"))
//						{
//							this.myAgent.addBehaviour(new AggregateOkLoadBehaviour(msg));
//						}
//					}
//					else if(this.myAgent instanceof BatteryAggregatorAgent)
//					{
//						if(msg.getConversationId().equals("input"))
//						{
//							this.myAgent.addBehaviour(new SendPricesToAgents(msg, "BatteryAgent"));
//						}
//						else if(msg.getConversationId().equals("proposal"))
//						{
//							this.myAgent.addBehaviour(new AggregateBatteryBehaviour(msg));
//						}
//						else if(msg.getConversationId().equals("result"))
//						{
//							this.myAgent.addBehaviour(new DisaggregateBatteryBehaviour(msg));
//						}
//						else if(msg.getConversationId().equals("ok"))
//						{
//							this.myAgent.addBehaviour(new AggregateOkBatteryBehaviour(msg));
//						}
//						
//					}
//					else if(this.myAgent instanceof DerAggregatorAgent)
//					{
//						if(msg.getConversationId().equals("input"))
//						{
//							this.myAgent.addBehaviour(new SendPricesToAgents(msg, "DerAgent"));
//						}
//						else if(msg.getConversationId().equals("proposal"))
//						{
//							this.myAgent.addBehaviour(new AggregateDerBehaviour(msg));
//						}
//						else if(msg.getConversationId().equals("result"))
//						{	
//							this.myAgent.addBehaviour(new DisaggregateDerBehaviour(msg));
//						}
//						else if(msg.getConversationId().equals("ok"))
//						{
//							this.myAgent.addBehaviour(new AggregateOkDerBehaviour(msg));
//						}
//					}
//				}
//				/*else
//				{
//					this.block();
//				}*/
//			} catch (UnreadableException e) {
//				e.printStackTrace();
//			}	
		}
	}

