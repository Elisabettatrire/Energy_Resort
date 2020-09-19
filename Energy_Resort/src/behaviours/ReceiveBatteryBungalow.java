package behaviours;

import data.BatteryData;
import data.DsoData;
import jade.core.Agent;
import jade.core.behaviours.OneShotBehaviour;
import jade.lang.acl.ACLMessage;
import agents.BaseAgent;

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

    }


}
