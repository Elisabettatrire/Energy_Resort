package behaviours;

import data.BatteryData;
import data.DsoData;
import jade.core.Agent;
import jade.core.behaviours.OneShotBehaviour;
import jade.core.behaviours.WakerBehaviour;
import jade.lang.acl.ACLMessage;

import java.util.Hashtable;

import agents.BaseAgent;
import agents.BungalowAgent;

public class ReceiveBatteryBungalow extends OneShotBehaviour{
	
	BatteryData msgBatteryData;
    ACLMessage msg;

    
    
    
    
    public ReceiveBatteryBungalow(Agent a){
        super(a);
    }
    
    
    public ReceiveBatteryBungalow(ACLMessage msg) {
        try {
            this.msg=msg;
            msgBatteryData = (BatteryData)msg.getContentObject();
            }  catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void action()
    {
  
    	System.out.println(this.myAgent.getLocalName() + ": " + 
                msg.getSender().getLocalName() + " dice che ha a disposizione " + msgBatteryData.getCapacity()+
                " Kw al prezzo di "+msgBatteryData.getBatteryPrice()+" euro al Kw.");    
    	((BungalowAgent) myAgent).getBungalowDb().insertProviderData(msgBatteryData.getCapacity(), msgBatteryData.getBatteryPrice(), msg.getSender().getLocalName());
    
        if(((BungalowAgent) myAgent).getBungalowDb().selectBestProvider(((BungalowAgent) myAgent).getBungalowDb().selectMinPrice(((BungalowAgent) myAgent).getBungalow())).equals("Battery")) {
        	this.myAgent.addBehaviour(new WakerBehaviour(this.myAgent, 40000) {
        		protected void onWake() {
                	new BaseAgent().sendMessageToAgentsByServiceType(this.myAgent, msg.getSender(), "BuyFromYou", "Ciao "+msg.getSender().getLocalName()
                        	+", voglio acquistare "+((BungalowAgent) myAgent).getBungalow().getEnReq()+" Kw da te.");
        		}
        	});
        }
    }
}
