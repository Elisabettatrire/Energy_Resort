package behaviours;

import agents.BaseAgent;
import agents.BungalowAgent;
import data.DsoData;
import jade.core.Agent;
import jade.core.behaviours.OneShotBehaviour;
import jade.core.behaviours.WakerBehaviour;
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
            
            if(((BungalowAgent) myAgent).getBungalowDb().selectBestProvider(((BungalowAgent) myAgent).getBungalowDb().selectMinPrice(((BungalowAgent) myAgent).getBungalow())).equals("Dso")) {
            	this.myAgent.addBehaviour(new WakerBehaviour(this.myAgent, 40000) {
            		protected void onWake() {
                    	new BaseAgent().sendMessageToAgentsByServiceType(this.myAgent, msg.getSender(), "BuyFromYou", "Ciao "+msg.getSender().getLocalName()
                            	+", voglio acquistare "+((BungalowAgent) myAgent).getBungalow().getEnReq()+" Kw da te.");
            		}
            	});
            }
    }

}
