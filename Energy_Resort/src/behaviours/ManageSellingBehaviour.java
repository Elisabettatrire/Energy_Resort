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
		
			//qua si scalano i contatori provvisori

		} else if(msg != null && msg.getPerformative()==ACLMessage.REJECT_PROPOSAL) 
		{
			System.out.println(this.myAgent.getLocalName()+": "+msg.getSender().getLocalName()+" dice: "+msg.getContent());
			this.myAgent.blockingReceive();
			
		}

		else {
			//this.block();
		}


	}



}
