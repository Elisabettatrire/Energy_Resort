package behaviours;

import data.BatteryData;
import data.DsoData;
import jade.core.Agent;
import jade.core.behaviours.OneShotBehaviour;
import jade.core.behaviours.WakerBehaviour;
import jade.lang.acl.ACLMessage;

import java.util.Hashtable;

import agents.BaseAgent;
import agents.BungalowAgent;

/**
 * Behaviour degli agenti Bungalow che si attiva subito dopo la presentazione
 * dei kw e del relativo prezzo unitario da parte degli agenti fornitori
 * 
 * Il bungalow riceve i dati dei kw prodotti e del relativo prezzo dal fornitore
 * scritto nel nome della classe. Esegue un controllo per verificare se tale
 * fornitore è quello che propone il prezzo più basso e in caso positivo lo
 * contatta per chiedergli di vendergli i kw di cui ha bisogno.
 */

public class ReceiveBatteryBungalow extends OneShotBehaviour {

	BatteryData msgBatteryData;
	ACLMessage msg;

	public ReceiveBatteryBungalow(Agent a) {
		super(a);
	}

	public ReceiveBatteryBungalow(ACLMessage msg) {
		try {
			this.msg = msg;
			msgBatteryData = (BatteryData) msg.getContentObject();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void action() {

		System.out.println(this.myAgent.getLocalName() + ": " + msg.getSender().getLocalName()
				+ " dice che ha a disposizione " + msgBatteryData.getCapacity() + " Kw al prezzo di "
				+ msgBatteryData.getBatteryPrice() + " euro al Kw.");

		if (((BungalowAgent) myAgent).getBungalowDb().selectBestProvider(
				((BungalowAgent) myAgent).getBungalowDb().selectMinPrice(((BungalowAgent) myAgent).getBungalow()))
				.equals("Battery")) {
			this.myAgent.addBehaviour(new WakerBehaviour(this.myAgent, 40000) {
				protected void onWake() {
					new BaseAgent().sendMessageToAgentsByServiceType(this.myAgent, msg.getSender(), "BuyFromYou",
							"Ciao " + msg.getSender().getLocalName() + ", voglio acquistare "
									+ ((BungalowAgent) myAgent).getBungalow().getEnReq() + " Kw da te.");
				}
			});
		}
	}
}
