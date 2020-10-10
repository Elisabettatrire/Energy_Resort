package behaviours;

import agents.AeolianAgent;
import agents.BaseAgent;
import agents.BatteryAgent;
import agents.SolarAgent;
import data.BungalowData;
import jade.core.Agent;
import jade.core.behaviours.OneShotBehaviour;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.UnreadableException;

public class KwsProposalBehaviour extends OneShotBehaviour{

	BungalowData msgBungalowData;
	ACLMessage msg;

	public KwsProposalBehaviour(Agent a){
		super(a);
	}

	public KwsProposalBehaviour(ACLMessage msg) {
		try {
			this.msg=msg;
			msgBungalowData = (BungalowData)msg.getContentObject();
		} catch (UnreadableException e) {
			e.printStackTrace();
		}
	}

	public void action() {
      if(this.myAgent instanceof SolarAgent)
      {
			try {
				if(((SolarAgent) myAgent).getSolar().getCounterSolarKw() <= msgBungalowData.getCounterEnReq())
				{
					System.out.println(((SolarAgent) myAgent).getSolar().getCounterSolarKw());
					System.out.println(((SolarAgent) myAgent).getSolar().getCounterSolarKw());
					new BaseAgent().sendMessageToAgentsByServiceType(this.myAgent, msg.getSender(),
							"Finished", "Vendo a te "+((SolarAgent) myAgent).getSolar().getCounterSolarKw() +" Kw.");
					msgBungalowData.setCounterEnReq(msgBungalowData.getCounterEnReq() - ((SolarAgent) myAgent).getSolar().getCounterSolarKw());
					((SolarAgent) myAgent).getSolar().setCounterSolarKw(0);
					((SolarAgent) myAgent).getDbSolar().updateProviderData(((SolarAgent) myAgent).getSolar().getCounterSolarKw(), "Solar");
				} else {
					new BaseAgent().sendMessageToAgentsByServiceType(this.myAgent, msg.getSender(),
							"Finished", "Vendo a te "+msgBungalowData.getCounterEnReq() +" Kw.");
					((SolarAgent) myAgent).getSolar().setCounterSolarKw(((SolarAgent) myAgent).getSolar().getCounterSolarKw() - msgBungalowData.getCounterEnReq());
					msgBungalowData.setCounterEnReq(0);
					((SolarAgent) myAgent).getDbSolar().updateProviderData(((SolarAgent) myAgent).getSolar().getCounterSolarKw(), "Solar");
					
				}
				new BaseAgent().sendMessageToAgentsByServiceType(this.myAgent, "BungalowAgent", "WakeUp", "Sveglia!");
			} catch(Exception e) {
				e.printStackTrace();
			}						
    }
      if(this.myAgent instanceof AeolianAgent)
      {
			try {
				if(((AeolianAgent) myAgent).getAeolian().getCounterWindKw() <= msgBungalowData.getCounterEnReq())
				{					
					new BaseAgent().sendMessageToAgentsByServiceType(this.myAgent, msg.getSender(),
							"Finished", "Vendo a te "+((AeolianAgent) myAgent).getAeolian().getCounterWindKw() +" Kw.");
					msgBungalowData.setCounterEnReq(msgBungalowData.getCounterEnReq() - ((AeolianAgent) myAgent).getAeolian().getCounterWindKw());
					((AeolianAgent) myAgent).getAeolian().setCounterWindKw(0);
					((AeolianAgent) myAgent).getDbAeolian().updateProviderData(((AeolianAgent) myAgent).getAeolian().getCounterWindKw(), "Aeolian");
					
				} else {
					new BaseAgent().sendMessageToAgentsByServiceType(this.myAgent, msg.getSender(),
							"Finished", "Vendo a te "+msgBungalowData.getCounterEnReq() +" Kw.");
					((AeolianAgent) myAgent).getAeolian().setCounterWindKw(((AeolianAgent) myAgent).getAeolian().getCounterWindKw() - msgBungalowData.getCounterEnReq());
					msgBungalowData.setCounterEnReq(0);
					((AeolianAgent) myAgent).getDbAeolian().updateProviderData(((AeolianAgent) myAgent).getAeolian().getCounterWindKw(), "Aeolian");
					
				}
				new BaseAgent().sendMessageToAgentsByServiceType(this.myAgent, "BungalowAgent", "WakeUp", "Sveglia!");
			} catch(Exception e) {
				e.printStackTrace();
			}						
    }
      
      if(this.myAgent instanceof BatteryAgent)
      {
			try {
				if(((BatteryAgent) myAgent).getBattery().getCounterCapacity() <= msgBungalowData.getCounterEnReq())
				{					
					new BaseAgent().sendMessageToAgentsByServiceType(this.myAgent, msg.getSender(),
							"Finished", "Vendo a te "+((BatteryAgent) myAgent).getBattery().getCounterCapacity() +" Kw.");
					msgBungalowData.setCounterEnReq(msgBungalowData.getCounterEnReq() - ((BatteryAgent) myAgent).getBattery().getCounterCapacity());
					((BatteryAgent) myAgent).getBattery().setCounterCapacity(0);
					((BatteryAgent) myAgent).getDbBattery().updateProviderData(((BatteryAgent) myAgent).getBattery().getCounterCapacity(), "Battery");
					
				} else {
					new BaseAgent().sendMessageToAgentsByServiceType(this.myAgent, msg.getSender(),
							"Finished", "Vendo a te "+msgBungalowData.getCounterEnReq() +" Kw.");
					((BatteryAgent) myAgent).getBattery().setCounterCapacity(((BatteryAgent) myAgent).getBattery().getCounterCapacity() - msgBungalowData.getCounterEnReq());
					msgBungalowData.setCounterEnReq(0);
					((BatteryAgent) myAgent).getDbBattery().updateProviderData(((BatteryAgent) myAgent).getBattery().getCounterCapacity(), "Battery");
					
				}
				new BaseAgent().sendMessageToAgentsByServiceType(this.myAgent, "BungalowAgent", "WakeUp", "Sveglia!");
			} catch(Exception e) {
				e.printStackTrace();
			}						
    }
	}
}
