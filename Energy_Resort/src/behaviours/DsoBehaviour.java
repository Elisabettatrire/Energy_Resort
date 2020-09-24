package behaviours;

import agents.BaseAgent;
import data.DsoData;
import jade.core.behaviours.OneShotBehaviour;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.UnreadableException;

public class DsoBehaviour extends OneShotBehaviour{
	
	  ACLMessage msg;
	  String msgData;
	  double dsoPrice;
	  
	  
	public DsoBehaviour(ACLMessage msg, double dsoPrice)
	{
		try {
			this.dsoPrice = dsoPrice;
            this.msg = msg;
            this.msgData = msg.getContent();
        } catch (Exception e) {
            e.printStackTrace();
        }
	}
	
	public void action() {
		new BaseAgent().sendMessageToAgentsByServiceType(this.myAgent, "BungalowAgent",
                "pricedso", dsoPrice);
		
	}

}
