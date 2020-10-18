package behaviours;

import java.util.Arrays;

import agents.AeolianAgent;
import agents.BaseAgent;
import agents.DsoAgent;
import data.AeolianData;
import data.BungalowData;
import data.DsoData;
import jade.core.behaviours.CyclicBehaviour;
import jade.core.behaviours.OneShotBehaviour;
import jade.core.behaviours.WakerBehaviour;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;
import jade.lang.acl.UnreadableException;

public class DsoPriceBehaviour extends OneShotBehaviour {

	BungalowData msgData;
	DsoData dso;
	int totalNeed = 0;

	public DsoPriceBehaviour(DsoData dso) {
		this.dso = dso;
	}

	public void action() {
		this.myAgent.addBehaviour(new CyclicBehaviour(this.myAgent) {
			public void action() {
				ACLMessage msg = this.myAgent.receive(MessageTemplate.MatchPerformative(ACLMessage.INFORM));
				if (msg != null && msg.getConversationId().equals("energyrequest")) {
					System.out.println(this.myAgent.getLocalName() + ": " + msg.getSender().getLocalName() + " dice: "
							+ msg.getContent());
				}
				else if (msg != null && msg.getConversationId().equals("calculateprice")) {
					try {
						msgData = (BungalowData) msg.getContentObject();
					} catch (UnreadableException e) {
						e.printStackTrace();
					}
					dso.setBungalowNeeds(new BaseAgent().addElement(msgData.getId() - 1, dso.getBungalowNeeds(),
							msgData.getEnReq()));
				} 
				else if (msg != null && msg.getConversationId().equals("BuyFromYou")) {
					System.out.println(this.myAgent.getLocalName() + ": " + msg.getSender().getLocalName() + " dice: "
							+ msg.getContent());
					
					if (msg.getSender().getLocalName().equals(((DsoAgent) myAgent).getDbDso()
							.selectBestConsumer(((DsoAgent) myAgent).getDbDso().getMaxEnReq()))) 
					{
						new BaseAgent().sendMessageToAgentsByServiceType(this.myAgent, msg.getSender(),
								"AnswerToClient", "Va bene. Li vendo a te.", ACLMessage.ACCEPT_PROPOSAL);
					} 
					else {
						new BaseAgent().sendMessageToAgentsByServiceType(this.myAgent, msg.getSender(),
								"AnswerToClient", "Aspetta in coda.", ACLMessage.REJECT_PROPOSAL);
					}
				} 
				else if (msg != null && msg.getConversationId().equals("AnswerToClient")) {
					this.myAgent.addBehaviour(new KwsProposalBehaviour(msg));
				} 
				else {
					this.block();
				}
			}
		});
		this.myAgent.addBehaviour(new WakerBehaviour(this.myAgent, 5000) {
			protected void onWake() {
				for (int i = 0; i < dso.getBungalowNeeds().length; i++) {
					totalNeed = totalNeed + dso.getBungalowNeeds()[i];
				}
				// System.out.println(totalNeed);
				if (totalNeed > 0 && totalNeed < 8) {
					dso.setDsoPrice(1.5);
				} else if (totalNeed >= 8 && totalNeed < 16) {
					dso.setDsoPrice(1.3);
				} else {
					dso.setDsoPrice(1.1);
				}
				
				((DsoAgent) myAgent).getDbDso().updateProviderData(200, dso.getDsoPrice(), "Dso");
				
				new BaseAgent().sendMessageToAgentsByServiceType(this.myAgent, "BungalowAgent", "pricedso",
						dso.getDsoPrice());
			}
		});
	}
}
