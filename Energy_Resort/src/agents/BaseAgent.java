package agents;

import java.io.IOException;
import java.io.Serializable;
import java.util.Arrays;

import jade.core.AID;
import jade.core.Agent;
import jade.domain.DFService;
import jade.domain.FIPAException;
import jade.domain.FIPAAgentManagement.DFAgentDescription;
import jade.domain.FIPAAgentManagement.ServiceDescription;
import jade.lang.acl.ACLMessage;

/**
 * Questa classe definisce i metodi base per il funzionamento di tutti gli
 * agenti della piattaforma, in particolare i vari
 * sendMessageToAgentsByServiceType, utilizzati per scambiare messaggi di
 * diverso contenuto e destinatari tra i vari agenti.
 */

@SuppressWarnings("serial")
public class BaseAgent extends Agent {

	protected void registerDfAgent(String platform, String type, String idType) {
		DFAgentDescription ad = new DFAgentDescription();
		ServiceDescription sd = new ServiceDescription();
		sd.setName("Platform-" + platform);
		sd.setType(type);

		ServiceDescription sd1 = new ServiceDescription();
		sd1.setName("Platform-" + platform);
		sd1.setType(idType);

		ad.addServices(sd1);
		ad.addServices(sd);

		try {
			DFService.register(this, ad);
		} catch (FIPAException e) {
			e.printStackTrace();
		}
	}

	protected void registerDfAgent(String platform, String type) {
		DFAgentDescription ad = new DFAgentDescription();
		ServiceDescription sd = new ServiceDescription();
		sd.setName("Platform-" + platform);
		sd.setType(type);
		ad.addServices(sd);

		try {
			DFService.register(this, ad);
		} catch (FIPAException e) {
			e.printStackTrace();
		}
	}

	public Boolean sendMessageToAgentsByServiceType(Agent myAgent, String serviceType, String conversationId,
			String messageData) {
		try {
			DFAgentDescription[] agents = getAgentsbyServiceType(myAgent, serviceType);
			for (int i = 0; i < agents.length; i++) {
				ACLMessage message = new ACLMessage(ACLMessage.INFORM);
				message.setContentObject(messageData);
				message.addReceiver(agents[i].getName());
				message.setConversationId(conversationId);
				myAgent.send(message);
			}
			return true;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}

	public Boolean sendMessageToAgentsByServiceType(Agent myAgent, AID receiver, String conversationId,
			String messageData) {
		try {
			ACLMessage message = new ACLMessage(ACLMessage.INFORM);
			message.setContentObject(messageData);
			message.addReceiver(receiver);
			message.setConversationId(conversationId);
			myAgent.send(message);
			return true;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}

	public Boolean sendMessageToAgentsByServiceType(Agent myAgent, String serviceType, String conversationId,
			Serializable messageData) {
		try {
			DFAgentDescription[] agents = getAgentsbyServiceType(myAgent, serviceType);
			for (int i = 0; i < agents.length; i++) {
				ACLMessage message = new ACLMessage(ACLMessage.INFORM);
				message.setContentObject(messageData);
				message.addReceiver(agents[i].getName());
				message.setConversationId(conversationId);
				myAgent.send(message);
			}
			return true;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}

	public Boolean sendMessageToAgentsByServiceType(Agent myAgent, AID receiver, String conversationId,
			Serializable messageData) {
		try {
			ACLMessage message = new ACLMessage(ACLMessage.INFORM);
			message.setContentObject(messageData);
			message.addReceiver(receiver);
			message.setConversationId(conversationId);
			myAgent.send(message);
			return true;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}

	public Boolean sendMessageToAgentsByServiceType(Agent myAgent, AID receiver, String conversationId,
			Serializable messageData, String sentence) {
		try {
			ACLMessage message = new ACLMessage(ACLMessage.INFORM);
			message.setContentObject(messageData);
			message.setContent(sentence);
			message.addReceiver(receiver);
			message.setConversationId(conversationId);
			myAgent.send(message);
			return true;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}

	public Boolean sendMessageToAgentsByServiceType(Agent myAgent, AID receiver, String conversationId,
			String messageData, int performative) {
		try {
			ACLMessage message = new ACLMessage(performative);
			message.setContentObject(messageData);
			message.addReceiver(receiver);
			message.setConversationId(conversationId);
			myAgent.send(message);
			return true;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}

	public Boolean sendMessageToAgentsByServiceType(Agent myAgent, AID receiver, String conversationId) {
		try {
			ACLMessage message = new ACLMessage(ACLMessage.INFORM);
			String messageData = "Ciao " + receiver.getLocalName() + ", quanta energia mi puoi vendere?"
					+ " E a che prezzo?";
			message.setContent(messageData);
			message.addReceiver(receiver);
			message.setConversationId(conversationId);
			myAgent.send(message);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public DFAgentDescription[] getAgentsbyServiceType(Agent myAgent, String serviceType) {
		DFAgentDescription ad = new DFAgentDescription();
		ServiceDescription sd = new ServiceDescription();
		sd.setType(serviceType);
		ad.addServices(sd);
		DFAgentDescription[] ca = null;
		try {
			ca = DFService.search(myAgent, ad);
		} catch (FIPAException e) {
			e.printStackTrace();
		}
		return ca;
	}

	public String getShortName(String idAgent) {
		String[] names = idAgent.split("@");
		return names[0];
	}

	public int[] addElement(int i, int[] myarray, int ele) {
		myarray[i] = ele;
		return myarray;
	}

}