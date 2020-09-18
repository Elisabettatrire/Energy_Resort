
package behaviours;
import jade.core.Agent;
import agents.*;
import jade.core.Agent;
import jade.core.behaviours.TickerBehaviour;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;
import jade.lang.acl.UnreadableException;
import jade.core.behaviours.OneShotBehaviour;
import agents.BungalowAgent;
import data.AeolianData;



@SuppressWarnings("serial")
public class ReceiveSolarBungalow extends OneShotBehaviour{
    
    String msgData;
    ACLMessage msg;
    
    
    public ReceiveSolarBungalow(Agent a){
        super(a);
    }
    
    public ReceiveSolarBungalow(ACLMessage msg) {
        try {
            this.msg=msg;
            msgData = msg.getContent();
            }  catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void action()
    {
        // System.out.print(msgAeolianData);
            System.out.println(this.myAgent.getLocalName() + ": " + 
                    msg.getSender().getLocalName() + " dice: " +msgData);    
//        else
//        {
//            this.block();
//        }
    }
}



