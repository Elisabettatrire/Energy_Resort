package behaviours;
import jade.core.Agent;
import agents.*;
import jade.core.Agent;
import jade.core.behaviours.TickerBehaviour;
import jade.core.behaviours.WakerBehaviour;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;
import jade.lang.acl.UnreadableException;
import jade.core.behaviours.CyclicBehaviour;
import jade.core.behaviours.OneShotBehaviour;
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
		} catch (UnreadableException e) {
			e.printStackTrace();
		}
	}

	public void action()
	{

		System.out.println(this.myAgent.getLocalName() + ": " +
				msg.getSender().getLocalName() + " dice che ha prodotto " + msgAeolianData.getWindKw()+
				" Kw al prezzo di "+msgAeolianData.getWindPrice()+" euro al Kw.");
		((BungalowAgent) myAgent).getBungalowDb().insertProviderData(msgAeolianData.getWindKw(), msgAeolianData.getWindPrice(), msg.getSender().getLocalName());

		if(((BungalowAgent) myAgent).getBungalowDb().selectBestProvider(((BungalowAgent) myAgent).getBungalowDb().selectMinPrice(((BungalowAgent) myAgent).getBungalow())).equals("Aeolian")) {
			this.myAgent.addBehaviour(new WakerBehaviour(this.myAgent, 40000) {
				protected void onWake() {
					new BaseAgent().sendMessageToAgentsByServiceType(this.myAgent, msg.getSender(), "BuyFromYou", "Ciao "+msg.getSender().getLocalName()
							+", voglio acquistare "+((BungalowAgent) myAgent).getBungalow().getEnReq()+" Kw da te.");
				}
			});
		}

	}
}



