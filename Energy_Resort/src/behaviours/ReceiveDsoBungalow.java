package behaviours;

import data.DsoData;
import jade.core.Agent;
import jade.core.behaviours.OneShotBehaviour;
import jade.lang.acl.ACLMessage;

public class ReceiveDsoBungalow extends OneShotBehaviour{
	
	DsoData msgDsoData;
    ACLMessage msg;
    
    
    public ReceiveDsoBungalow(Agent a){
        super(a);
    }
    
    public ReceiveDsoBungalow(ACLMessage msg) {
        try {
            this.msg=msg;
            msgDsoData = (DsoData)msg.getContentObject();
            }  catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void action()
    {
      
            System.out.println(this.myAgent.getLocalName() + ": " + 
                    msg.getSender().getLocalName() + " dice che vende i suoi "+
                    " Kw al prezzo di "+msgDsoData.getDsoPrice()+" euro al Kw.");        

    }

}
