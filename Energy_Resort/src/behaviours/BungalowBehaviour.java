package behaviours;

import java.util.Calendar;

import agents.AeolianAgent;
import agents.BaseAgent;
import agents.BatteryAgent;
import agents.BungalowAgent;
import agents.DsoAgent;
import agents.SolarAgent;
import data.AeolianData;
import data.BungalowData;
import database.DbBungalowData;
import jade.core.Agent;
import jade.core.behaviours.OneShotBehaviour;
import jade.domain.FIPAAgentManagement.DFAgentDescription;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.UnreadableException;
import jade.lang.acl.MessageTemplate;
import jade.core.AID;

/**
 * Questo behaviour degli agenti Bungalow viene eseguito per primo in modo da
 * iniziare le contrattazioni. I Bungalow inviano i propri dati all'agente Dso,
 * in modo che esso possa calcolare il prezzo unitario di un Kw in base al
 * fabbisogno generale dei Bungalow. Infine i Bungalow richiedono i prezzi
 * unitari e i Kw prodotti ai vari agenti fornitori.
 */

@SuppressWarnings("serial")
public class BungalowBehaviour extends OneShotBehaviour {

	BungalowData bungalow;

	public BungalowBehaviour(Agent a, BungalowData bungalow) {
		super(a);
		this.bungalow = bungalow;
	}

	DFAgentDescription[] dfagents;

	public void action() {

		System.out.println("Sono l'agente " + this.myAgent.getLocalName() + ", il mio ID e' " + bungalow.getId()
		+ ", ho bisogno di " + bungalow.getEnReq() + " kW e ho un budget di " + bungalow.getBudget()
		+ " euro.");

		new BaseAgent().sendMessageToAgentsByServiceType(this.myAgent, "DsoAgent", "calculateprice", bungalow);

		String[] agents = { "AeolianAgent", "DsoAgent", "SolarAgent", "BatteryAgent" };

		for (int i = 0; i < agents.length; i++) {
			dfagents = new BaseAgent().getAgentsbyServiceType(this.myAgent, agents[i]);
			new BaseAgent().sendMessageToAgentsByServiceType(this.myAgent, dfagents[0].getName(), "energyrequest");
		}
	}
}