package behaviours;

import java.util.Arrays;

import agents.BaseAgent;
import data.AeolianData;
import data.BungalowData;
import data.DsoData;
import jade.core.behaviours.CyclicBehaviour;
import jade.core.behaviours.OneShotBehaviour;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;
import jade.lang.acl.UnreadableException;

public class DsoPriceBehaviour extends OneShotBehaviour{

	
	BungalowData msgData;
	DsoData dso;
	
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
				if (msg != null && msg.getConversationId().equals("dsoprice"))
				{
					try {
                    msgData = (BungalowData)msg.getContentObject();
					} catch(UnreadableException e) {
						e.printStackTrace();
					}
					dso.setBungalowNeeds(new BaseAgent().addElement(msgData.getId()-1, dso.getBungalowNeeds(), msgData.getEnReq()));
					System.out.println(Arrays.toString(dso.getBungalowNeeds()));
				}
				else
				{
					this.block();
				}
			}});	
}
}
