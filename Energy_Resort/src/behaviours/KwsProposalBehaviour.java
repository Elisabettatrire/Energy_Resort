package behaviours;

import agents.BaseAgent;
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

			try {
				if(((SolarAgent) myAgent).getSolar().getCounterSolarKw() <= msgBungalowData.getCounterEnReq())
				{
					new BaseAgent().sendMessageToAgentsByServiceType(this.myAgent, msg.getSender(),
							"AnswerToClient", "Vendo a te "+((SolarAgent) myAgent).getSolar().getCounterSolarKw() +" Kw.", ACLMessage.ACCEPT_PROPOSAL);
				} else {
					new BaseAgent().sendMessageToAgentsByServiceType(this.myAgent, msg.getSender(),
							"AnswerToClient", "Vendo a te "+msgBungalowData.getCounterEnReq() +" Kw.", ACLMessage.ACCEPT_PROPOSAL);
				}
			} catch(Exception e) {
				e.printStackTrace();
			}						

	}
}
