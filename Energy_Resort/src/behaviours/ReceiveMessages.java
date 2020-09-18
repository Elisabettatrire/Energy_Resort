package behaviours;

 

import agents.BaseAgent;
import agents.BatteryAgent;
import agents.AeolianAgent;
import agents.DsoAgent;
import agents.SolarAgent;
import agents.BungalowAgent;
import behaviours.AeolianBehaviour;
import behaviours.SolarBehaviour;
import behaviours.ReceiveAeolianBungalow;
import behaviours.ReceiveSolarBungalow;
import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.core.behaviours.TickerBehaviour;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;
import jade.lang.acl.UnreadableException;

 

public class ReceiveMessages extends TickerBehaviour{
       
    public ReceiveMessages(Agent a, long period) {
        super(a, period);
    }
    
    protected void onTick() {
        try{
            MessageTemplate template = MessageTemplate.MatchPerformative(ACLMessage.INFORM);
            ACLMessage msg = this.myAgent.receive(template); 
            if (msg!=null)
            {
                if(this.myAgent instanceof AeolianAgent)
                {
                    if(msg.getConversationId().equals("energyrequest"))
                    {
                        this.myAgent.addBehaviour(new AeolianBehaviour(msg));
                    }
                }
                if(this.myAgent instanceof BungalowAgent)
                {
                    if(msg.getConversationId().equals("priceaeolian"))
                    {
                        this.myAgent.addBehaviour(new ReceiveAeolianBungalow(msg));
                    } 
                    else if(msg.getConversationId().equals("pricesolar")) 
                    {
                        this.myAgent.addBehaviour(new ReceiveSolarBungalow(msg));
                    }
                }
                if(this.myAgent instanceof SolarAgent)
                {
                    if(msg.getConversationId().equals("energyrequest"))
                    {
                        this.myAgent.addBehaviour(new SolarBehaviour(msg));
                    }
                }
            }
            
            /*else
            {
                this.block();
            }*/
        } catch (Exception e) {
            e.printStackTrace();
        }    
    }
}