
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
		
//		((BungalowAgent) myAgent).getBungalowDb().updateProviderData(msgSolarData.getSolarKw(),
//				msgSolarData.getSolarPrice(), msg.getSender().getLocalName());

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
