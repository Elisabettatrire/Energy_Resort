package behaviours;

import agents.BaseAgent;
import agents.BungalowAgent;

import jade.core.Agent;

import jade.core.behaviours.OneShotBehaviour;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;

/**
 * Behaviour degli agenti Bungalow.
 * 
 * Se il Bungalow riceve dal fornitore contattato un messaggio con performative
 * ACCEPT_PROPOSAL, allora tale Bungalow è stato scelto per l'acquisto dei kw,
 * altrimenti, se riceve un messaggio con performative REJECT_PROPOSAL viene
 * messo in attesa.
 * 
 */

public class ManageSellingBehaviour extends OneShotBehaviour {

	ACLMessage msg;

	public ManageSellingBehaviour(Agent a) {
		super(a);
	}

	public ManageSellingBehaviour(ACLMessage msg) {
		try {
			this.msg = msg;

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void action() {

		if (msg != null && msg.getPerformative() == ACLMessage.ACCEPT_PROPOSAL) {
			System.out.println(
					this.myAgent.getLocalName() + ": " + msg.getSender().getLocalName() + " dice: " + msg.getContent());
			new BaseAgent().sendMessageToAgentsByServiceType(this.myAgent, msg.getSender(), "AnswerToClient",
					"Grazie!");

		} else if (msg != null && msg.getPerformative() == ACLMessage.REJECT_PROPOSAL) {
			System.out.println(
					this.myAgent.getLocalName() + ": " + msg.getSender().getLocalName() + " dice: " + msg.getContent());

		} else {

		}
	}
}
