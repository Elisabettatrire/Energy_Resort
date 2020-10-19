package behaviours;

import agents.BaseAgent;
import agents.BungalowAgent;
import data.BungalowData;
import jade.core.Agent;
import jade.core.behaviours.OneShotBehaviour;
import jade.core.behaviours.WakerBehaviour;
import jade.lang.acl.ACLMessage;

public class ResearchProviderBehaviour extends OneShotBehaviour {

	ACLMessage msg;

	public ResearchProviderBehaviour(Agent a) {
		super(a);
	}

	public ResearchProviderBehaviour(ACLMessage msg) {
		try {
			this.msg = msg;

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void action() {

		if (((BungalowAgent) myAgent).getBungalowDb()
				.selectBestProvider(((BungalowAgent) myAgent).getBungalowDb()
						.selectMinPrice(((BungalowAgent) myAgent).getBungalow()))
				.equals("Solar")
				&& ((BungalowAgent) myAgent).getBungalowDb().getMyEnReq(this.myAgent.getLocalName()) > 0) {
			this.myAgent.addBehaviour(new WakerBehaviour(this.myAgent, 10000) {
				protected void onWake() {
					new BaseAgent().sendMessageToAgentsByServiceType(this.myAgent, "SolarAgent", "BuyFromYou",
							"Ciao Solar, voglio acquistare "
									+ ((BungalowAgent) myAgent).getBungalowDb().getMyEnReq(this.myAgent.getLocalName())
									+ " Kw da te.");
				}
			});
		} else if (((BungalowAgent) myAgent).getBungalowDb()
				.selectBestProvider(((BungalowAgent) myAgent).getBungalowDb()
						.selectMinPrice(((BungalowAgent) myAgent).getBungalow()))
				.equals("Aeolian")
				&& ((BungalowAgent) myAgent).getBungalowDb().getMyEnReq(this.myAgent.getLocalName()) > 0) {
			this.myAgent.addBehaviour(new WakerBehaviour(this.myAgent, 10000) {
				protected void onWake() {
					new BaseAgent().sendMessageToAgentsByServiceType(this.myAgent, "AeolianAgent", "BuyFromYou",
							"Ciao Aeolian, voglio acquistare "
									+ ((BungalowAgent) myAgent).getBungalowDb().getMyEnReq(this.myAgent.getLocalName())
									+ " Kw da te.");
				}
			});
		} else if (((BungalowAgent) myAgent).getBungalowDb()
				.selectBestProvider(((BungalowAgent) myAgent).getBungalowDb()
						.selectMinPrice(((BungalowAgent) myAgent).getBungalow()))
				.equals("Battery")
				&& ((BungalowAgent) myAgent).getBungalowDb().getMyEnReq(this.myAgent.getLocalName()) > 0) {

			this.myAgent.addBehaviour(new WakerBehaviour(this.myAgent, 10000) {
				protected void onWake() {
					new BaseAgent().sendMessageToAgentsByServiceType(this.myAgent, "BatteryAgent", "BuyFromYou",
							"Ciao Battery, voglio acquistare "
									+ ((BungalowAgent) myAgent).getBungalowDb().getMyEnReq(this.myAgent.getLocalName())
									+ " Kw da te.");
				}
			});
		} else if (((BungalowAgent) myAgent).getBungalowDb()
				.selectBestProvider(((BungalowAgent) myAgent).getBungalowDb()
						.selectMinPrice(((BungalowAgent) myAgent).getBungalow()))
				.equals("Dso")
				&& ((BungalowAgent) myAgent).getBungalowDb().getMyEnReq(this.myAgent.getLocalName()) > 0) {
			
			//System.out.println(((BungalowAgent) myAgent).getBungalowDb().getMyEnReq(this.myAgent.getLocalName()));

			this.myAgent.addBehaviour(new WakerBehaviour(this.myAgent, 10000) {
				protected void onWake() {
					new BaseAgent().sendMessageToAgentsByServiceType(this.myAgent, "DsoAgent", "BuyFromYou",
							"Ciao Dso, voglio acquistare "
									+ ((BungalowAgent) myAgent).getBungalowDb().getMyEnReq(this.myAgent.getLocalName())
									+ " Kw da te.");
				}
			});
		} else {
			System.out.println(this.myAgent.getLocalName() + ": Ho acquistato tutti i Kw del mio fabbisogno.");
			this.myAgent.doDelete();
		}
	}

}
