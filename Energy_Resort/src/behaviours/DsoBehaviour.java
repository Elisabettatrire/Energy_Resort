package behaviours;

import agents.BaseAgent;
import data.DsoData;
import jade.core.behaviours.OneShotBehaviour;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.UnreadableException;

public class DsoBehaviour extends OneShotBehaviour{
	
	  ACLMessage msg;
	  String msgData;
	  DsoData dso;
	  
	  
	public DsoBehaviour(ACLMessage msg){
		
		try {
            this.msg = msg;
            this.msgData = msg.getContent();
        } catch (Exception e) {
            e.printStackTrace();
        }
	}
	
	public void action() {
		
		System.out.println(this.myAgent.getLocalName() +
                ": " + msg.getSender().getLocalName() + " dice: " + msgData);
		
		new BaseAgent().sendMessageToAgentsByServiceType(this.myAgent, "BungalowAgent",
                "pricedso", dso);
		
	}

}
