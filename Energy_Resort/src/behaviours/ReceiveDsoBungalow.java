package behaviours;

import agents.BungalowAgent;
import data.DsoData;
import jade.core.Agent;
import jade.core.behaviours.OneShotBehaviour;
import jade.lang.acl.ACLMessage;

public class ReceiveDsoBungalow extends OneShotBehaviour{
	
	double dsoPrice;
    ACLMessage msg;
    
    
    public ReceiveDsoBungalow(Agent a){
        super(a);
    }
    
    public ReceiveDsoBungalow(ACLMessage msg) {
        try {
            this.msg=msg;
            dsoPrice = (double)msg.getContentObject();
            }  catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void action()
    {
      
            System.out.println(this.myAgent.getLocalName() + ": " + 
                    msg.getSender().getLocalName() + " dice che vende i suoi "+
                    " Kw al prezzo di "+dsoPrice+" euro al Kw.");        
            ((BungalowAgent) myAgent).getBungalowDb().insertProviderData(200, dsoPrice, msg.getSender().getLocalName());
    }

}
