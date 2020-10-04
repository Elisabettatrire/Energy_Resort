
package behaviours;
import jade.core.Agent;

import java.util.Hashtable;

import agents.*;
import jade.core.Agent;
import jade.core.behaviours.TickerBehaviour;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;
import jade.lang.acl.UnreadableException;
import jade.core.behaviours.OneShotBehaviour;
import agents.BungalowAgent;
import data.AeolianData;
import data.SolarData;



@SuppressWarnings("serial")
public class ReceiveSolarBungalow extends OneShotBehaviour{
    
	SolarData msgSolarData;
    ACLMessage msg;
    
    
    public ReceiveSolarBungalow(Agent a){
        super(a);
    }
    
    public ReceiveSolarBungalow(ACLMessage msg) {
        try {
            this.msg=msg;
            msgSolarData = (SolarData)msg.getContentObject();
            }  catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void action()
    {
            System.out.println(this.myAgent.getLocalName() + ": " + 
                    msg.getSender().getLocalName() + " dice che ha prodotto " + msgSolarData.getSolarKw()+
                    " Kw al prezzo di "+msgSolarData.getSolarPrice()+" euro al Kw.");   
            ((BungalowAgent) myAgent).getBungalowDb().insertProviderData(msgSolarData.getSolarKw(), msgSolarData.getSolarPrice(), msg.getSender().getLocalName());
    }
}



