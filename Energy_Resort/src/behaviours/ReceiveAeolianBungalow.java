
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
public class ReceiveAeolianBungalow extends OneShotBehaviour{
    
    AeolianData msgAeolianData;
    ACLMessage msg;
    
    
    public ReceiveAeolianBungalow(Agent a){
        super(a);
    }
    
    public ReceiveAeolianBungalow(ACLMessage msg) {
        try {
            this.msg=msg;
            msgAeolianData = (AeolianData)msg.getContentObject();
            }  catch (UnreadableException e) {
            e.printStackTrace();
        }
    }
    
    public void action()
    {
      
            System.out.println(this.myAgent.getLocalName() + ": " + 
                    msg.getSender().getLocalName() + " dice che ha prodotto " + msgAeolianData.getWindKw()+
                    " Kw al prezzo di "+msgAeolianData.getWindPrice()+" euro al Kw.");    
            ((BungalowAgent) myAgent).getBungalowDb().insertProviderData(msgAeolianData.getWindKw(), msgAeolianData.getWindPrice(), msg.getSender().getLocalName());
            //((BungalowAgent) myAgent).getBungalow().getEnergyPrices().put(msg.getSender().getLocalName(), msgAeolianData.getWindPrice());
        	//System.out.println(((BungalowAgent) myAgent).getBungalow().getEnergyPrices());
    }
}



