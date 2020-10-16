package behaviours;

import agents.BungalowAgent;
import data.BatteryData;
import jade.core.Agent;
import jade.core.behaviours.OneShotBehaviour;
import jade.lang.acl.ACLMessage;

public class StopBatteryBehaviour extends OneShotBehaviour{

	ACLMessage msg;

	   
	    public StopBatteryBehaviour(Agent a){
	        super(a);
	    }
	    
		public StopBatteryBehaviour(ACLMessage msg) {
		    try {
		        this.msg=msg;
		      
		        }  catch (Exception e) {
		        e.printStackTrace();
		    }
		}

		public void action()
		{
		
			System.out.println(this.myAgent.getLocalName() + ": " + 
		            msg.getSender().getLocalName() + " dice: "+msg.getContent());  	
		}
		
}
