package behaviours;

import java.util.Arrays;

import agents.BaseAgent;
import data.AeolianData;
import data.BungalowData;
import data.DsoData;
import jade.core.behaviours.CyclicBehaviour;
import jade.core.behaviours.OneShotBehaviour;
import jade.core.behaviours.WakerBehaviour;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;
import jade.lang.acl.UnreadableException;

public class DsoPriceBehaviour extends OneShotBehaviour{

	
	BungalowData msgData;
	DsoData dso;
	int totalNeed=0;
//	public DsoPriceBehaviour(ACLMessage msg) {
//        try {
//            this.msg=msg;
//            msgData = (BungalowData)msg.getContentObject();
//            }  catch (UnreadableException e) {
//            e.printStackTrace();
//        }
//    }
	
	public DsoPriceBehaviour(DsoData dso) {
		this.dso = dso;
	}
	
	public void action() {
		this.myAgent.addBehaviour(new CyclicBehaviour(this.myAgent) {
			public void action() {
				ACLMessage msg = this.myAgent.receive(MessageTemplate.MatchPerformative(ACLMessage.INFORM));
				if (msg != null && msg.getConversationId().equals("energyrequest"))
				{
					System.out.println(this.myAgent.getLocalName() +
			                ": " + msg.getSender().getLocalName() + " dice: " + msg.getContent());
				}
				else if(msg != null && msg.getConversationId().equals("calculateprice")) {
					try {
	                    msgData = (BungalowData)msg.getContentObject();
						} catch(UnreadableException e) {
							e.printStackTrace();
						}
						dso.setBungalowNeeds(new BaseAgent().addElement(msgData.getId()-1, dso.getBungalowNeeds(), msgData.getEnReq()));
				}
				else
				{
					this.block();
				}
			}});	
		this.myAgent.addBehaviour(new WakerBehaviour(this.myAgent, 5000) {
			 protected void onWake() {
			for(int i=0; i<dso.getBungalowNeeds().length; i++) {
				 totalNeed = totalNeed + dso.getBungalowNeeds()[i];
			 }
			 // System.out.println(totalNeed);
			 if(totalNeed > 0 && totalNeed < 8) {
				 dso.setDsoPrice(1.5);
			 } else if (totalNeed >=8 && totalNeed < 16) {
				 dso.setDsoPrice(1.2);
			 } else {
				 dso.setDsoPrice(1);
			 }
			 new BaseAgent().sendMessageToAgentsByServiceType(this.myAgent, "BungalowAgent",
		                "pricedso", dso.getDsoPrice());
			 }});				
}
}
