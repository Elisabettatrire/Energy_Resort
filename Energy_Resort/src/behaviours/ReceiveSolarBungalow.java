
package behaviours;

import jade.core.Agent;

import java.util.Hashtable;

import agents.*;
import jade.core.Agent;
import jade.core.behaviours.TickerBehaviour;
import jade.core.behaviours.WakerBehaviour;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;
import jade.lang.acl.UnreadableException;
import jade.core.behaviours.OneShotBehaviour;
import data.AeolianData;
import data.SolarData;

/**
 * Behaviour degli agenti Bungalow che si attiva subito dopo la presentazione
 * dei kw e del relativo prezzo unitario da parte degli agenti fornitori
 * 
 * Il bungalow riceve i dati dei kw prodotti e del relativo prezzo dal fornitore
 * scritto nel nome della classe. Esegue un controllo per verificare se tale
 * fornitore è quello che propone il prezzo più basso e in caso positivo lo
 * contatta per chiedergli di vendergli i kw di cui ha bisogno.
 */

@SuppressWarnings("serial")
public class ReceiveSolarBungalow extends OneShotBehaviour {

	SolarData msgSolarData;
	ACLMessage msg;

	public ReceiveSolarBungalow(Agent a) {
		super(a);
	}

	public ReceiveSolarBungalow(ACLMessage msg) {
		try {
			this.msg = msg;
			msgSolarData = (SolarData) msg.getContentObject();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void action() {

		System.out.println(this.myAgent.getLocalName() + ": " + msg.getSender().getLocalName()
				+ " dice che ha prodotto " + msgSolarData.getSolarKw() + " Kw al prezzo di "
				+ msgSolarData.getSolarPrice() + " euro al Kw.");

		if (((BungalowAgent) myAgent).getBungalowDb().selectBestProvider(
				((BungalowAgent) myAgent).getBungalowDb().selectMinPrice(((BungalowAgent) myAgent).getBungalow()))
				.equals("Solar")) {

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
