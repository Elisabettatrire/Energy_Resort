package behaviours;

import agents.BaseAgent;
import agents.BungalowAgent;

import jade.core.Agent;

import jade.core.behaviours.OneShotBehaviour;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;


public class ManageSellingBehaviour extends OneShotBehaviour {



	ACLMessage msg;


	public ManageSellingBehaviour(Agent a){
		super(a);
	}

	public ManageSellingBehaviour(ACLMessage msg) {
		try {
			this.msg=msg;

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void action()
	{

		if(msg != null && msg.getPerformative()==ACLMessage.ACCEPT_PROPOSAL ) 
		{
			System.out.println(this.myAgent.getLocalName()+": "+msg.getSender().getLocalName()+" dice: "+msg.getContent());
			new BaseAgent().sendMessageToAgentsByServiceType(this.myAgent, msg.getSender(),
                    "AnswerToClient", "Grazie!");

		} else if(msg != null && msg.getPerformative()==ACLMessage.REJECT_PROPOSAL) 
		{
			System.out.println(this.myAgent.getLocalName()+": "+msg.getSender().getLocalName()+" dice: "+msg.getContent());
			//l agente deve attendere in coda che il prescelto abbia finito col fornitore e poi deve ritornare a chiedere i kw
			
		}
		else {
			//this.block();
		}
	}
}
