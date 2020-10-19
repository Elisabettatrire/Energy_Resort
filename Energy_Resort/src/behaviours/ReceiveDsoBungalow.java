package behaviours;

import agents.BaseAgent;
import agents.BungalowAgent;
import data.DsoData;
import jade.core.Agent;
import jade.core.behaviours.OneShotBehaviour;
import jade.core.behaviours.WakerBehaviour;
import jade.lang.acl.ACLMessage;

/**
 * Behaviour degli agenti Bungalow che si attiva subito dopo la presentazione
 * dei kw e del relativo prezzo unitario da parte degli agenti fornitori
 * 
 * Il bungalow riceve i dati dei kw prodotti e del relativo prezzo dal fornitore
 * scritto nel nome della classe. Esegue un controllo per verificare se tale
 * fornitore è quello che propone il prezzo più basso e in caso positivo lo
 * contatta per chiedergli di vendergli i kw di cui ha bisogno.
 */

public class ReceiveDsoBungalow extends OneShotBehaviour {

	double dsoPrice;
	ACLMessage msg;

	public ReceiveDsoBungalow(Agent a) {
		super(a);
	}

	public ReceiveDsoBungalow(ACLMessage msg) {
		try {
			this.msg = msg;
			dsoPrice = (double) msg.getContentObject();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void action() {

		System.out.println(this.myAgent.getLocalName() + ": " + msg.getSender().getLocalName()
				+ " dice che vende i suoi " + " Kw al prezzo di " + dsoPrice + " euro al Kw.");

		if (((BungalowAgent) myAgent).getBungalowDb().selectBestProvider(
				((BungalowAgent) myAgent).getBungalowDb().selectMinPrice(((BungalowAgent) myAgent).getBungalow()))
				.equals("Dso")) {
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
