package behaviours;

import agents.BaseAgent;
import agents.BatteryAgent;
import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.core.behaviours.OneShotBehaviour;
import jade.core.behaviours.WakerBehaviour;

/**
 * Behaviour dell'agente batteria sulla scelta del fornitore dal quale
 * ricaricarsi.
 * 
 * La batteria controlla quale tra Aeolian, Solar e Dso sia il fornitore che
 * propone il prezzo più basso e, se ha ancora dei kw da acquistare, allora
 * contatta il fornitore scelto per acquistare i kw di cui ha bisogno. Quando la
 * batteria si è ricaricata al massimo, aspetta che tutti gli agenti Bungalow
 * abbiano soddisfatto il proprio fabbisogno energetico e setta i suoi kw da
 * venditore a 50.
 */

public class ResearchProviderBattery extends OneShotBehaviour {

	public ResearchProviderBattery(Agent a) {
		super(a);
	}

	public void action() {

		if (((BatteryAgent) myAgent).getDbBattery()
				.selectBestProvider(
						((BatteryAgent) myAgent).getDbBattery().selectMinPrice(((BatteryAgent) myAgent).getBattery()))
				.equals("Solar") && ((BatteryAgent) myAgent).getDbBattery().getConsumerEnReq("Battery") > 0) {
			this.myAgent.addBehaviour(new WakerBehaviour(this.myAgent, 10000) {
				protected void onWake() {
					new BaseAgent().sendMessageToAgentsByServiceType(this.myAgent, "SolarAgent", "BuyFromYou",
							"Ciao Solar, voglio acquistare "
									+ ((BatteryAgent) myAgent).getDbBattery().getConsumerEnReq("Battery")
									+ " Kw da te.");
				}
			});
		} else if (((BatteryAgent) myAgent).getDbBattery()
				.selectBestProvider(
						((BatteryAgent) myAgent).getDbBattery().selectMinPrice(((BatteryAgent) myAgent).getBattery()))
				.equals("Aeolian") && ((BatteryAgent) myAgent).getDbBattery().getConsumerEnReq("Battery") > 0) {
			this.myAgent.addBehaviour(new WakerBehaviour(this.myAgent, 10000) {
				protected void onWake() {
					new BaseAgent().sendMessageToAgentsByServiceType(this.myAgent, "AeolianAgent", "BuyFromYou",
							"Ciao Aeolian, voglio acquistare "
									+ ((BatteryAgent) myAgent).getDbBattery().getConsumerEnReq("Battery")
									+ " Kw da te.");
				}
			});
		} else if (((BatteryAgent) myAgent).getDbBattery()
				.selectBestProvider(
						((BatteryAgent) myAgent).getDbBattery().selectMinPrice(((BatteryAgent) myAgent).getBattery()))
				.equals("Dso") && ((BatteryAgent) myAgent).getDbBattery().getConsumerEnReq("Battery") > 0) {

			this.myAgent.addBehaviour(new WakerBehaviour(this.myAgent, 10000) {
				protected void onWake() {
					new BaseAgent().sendMessageToAgentsByServiceType(this.myAgent, "DsoAgent", "BuyFromYou",
							"Ciao Dso, voglio acquistare "
									+ ((BatteryAgent) myAgent).getDbBattery().getConsumerEnReq("Battery")
									+ " Kw da te.");
				}
			});
		} else {

			System.out.println(this.myAgent.getLocalName() + ": Sono di nuovo al massimo della carica.");

			this.myAgent.addBehaviour(new CyclicBehaviour(this.myAgent) {

				public void action() {

					if (((BatteryAgent) myAgent).getDbBattery().getConsumerEnReq("Bungalow1") == 0
							&& ((BatteryAgent) myAgent).getDbBattery().getConsumerEnReq("Bungalow2") == 0
							&& ((BatteryAgent) myAgent).getDbBattery().getConsumerEnReq("Bungalow3") == 0) {
						((BatteryAgent) myAgent).getDbBattery().updateProviderData(50,
								((BatteryAgent) myAgent).getBattery().getBatteryPrice(),
								((BatteryAgent) myAgent).getBattery().getBudget(), "Battery");
					}

				}
			});

		}
	}
}
