package behaviours;

import agents.BaseAgent;
import agents.BungalowAgent;
import data.BungalowData;
import jade.core.Agent;
import jade.core.behaviours.OneShotBehaviour;
import jade.core.behaviours.WakerBehaviour;
import jade.lang.acl.ACLMessage;


public class ResearchProviderBehaviour extends OneShotBehaviour{
	
	ACLMessage msg;
	
	public ResearchProviderBehaviour(Agent a){
		super(a);
	}

	public ResearchProviderBehaviour(ACLMessage msg) {
		try {
			this.msg=msg;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void action() {
		
//		System.out.println(this.myAgent.getLocalName() +
//				": " + msg.getSender().getLocalName() + " dice: " + msg.getContent());
//		
//		
		
		if (((BungalowAgent) myAgent).getBungalowDb().selectBestProvider(
				((BungalowAgent) myAgent).getBungalowDb().selectMinPrice(((BungalowAgent) myAgent).getBungalow()))
				.equals("Solar") && ((BungalowAgent) myAgent).getBungalow().getCounterEnReq()>0) {
			
			this.myAgent.addBehaviour(new WakerBehaviour(this.myAgent, 40000) {
				protected void onWake() {
					new BaseAgent().sendMessageToAgentsByServiceType(this.myAgent, msg.getSender(), "BuyFromYou",
							"Ciao " + msg.getSender().getLocalName() + ", voglio acquistare "
									+ ((BungalowAgent) myAgent).getBungalow().getCounterEnReq() + " Kw da te.");
				}
			});
		} 
		else {
			System.out.println(this.myAgent.getLocalName()+": SHTAPPOSHT!!!!!!!!");
			this.myAgent.blockingReceive();
		}
	}

}
