package behaviours;
import agents.BaseAgent;
import agents.BatteryAgent;
import jade.core.Agent;
import jade.core.behaviours.OneShotBehaviour;
import jade.core.behaviours.WakerBehaviour;

public class ResearchProviderBattery extends OneShotBehaviour {
	
	
	public ResearchProviderBattery(Agent a) {
		super(a);		
	}
	
    public void action() {
    	
    	if (((BatteryAgent) myAgent).getDbBattery().selectBestProvider(
    			((BatteryAgent) myAgent).getDbBattery().selectMinPrice(((BatteryAgent) myAgent).getBattery()))
				.equals("Solar") && ((BatteryAgent) myAgent).getDbBattery().getConsumerEnReq("Battery")>0) {
			this.myAgent.addBehaviour(new WakerBehaviour(this.myAgent, 10000) {
				protected void onWake() {
					new BaseAgent().sendMessageToAgentsByServiceType(this.myAgent, "SolarAgent", "BuyFromYou",
							"Ciao Solar, voglio acquistare " +((BatteryAgent) myAgent).getDbBattery().getConsumerEnReq("Battery") +" Kw da te.");
				}
			});
		} 
		else if (((BatteryAgent) myAgent).getDbBattery().selectBestProvider(
    			((BatteryAgent) myAgent).getDbBattery().selectMinPrice(((BatteryAgent) myAgent).getBattery()))
				.equals("Aeolian") && ((BatteryAgent) myAgent).getDbBattery().getConsumerEnReq("Battery")>0) {
			this.myAgent.addBehaviour(new WakerBehaviour(this.myAgent, 10000) {
				protected void onWake() {				
					new BaseAgent().sendMessageToAgentsByServiceType(this.myAgent, "AeolianAgent", "BuyFromYou",
							"Ciao Aeolian, voglio acquistare " + ((BatteryAgent) myAgent).getDbBattery().getConsumerEnReq("Battery") + " Kw da te.");
				}
			});
		}
		else if (((BatteryAgent) myAgent).getDbBattery().selectBestProvider(
    			((BatteryAgent) myAgent).getDbBattery().selectMinPrice(((BatteryAgent) myAgent).getBattery()))
				.equals("Dso") && ((BatteryAgent) myAgent).getDbBattery().getConsumerEnReq("Battery")>0) {
			
			this.myAgent.addBehaviour(new WakerBehaviour(this.myAgent, 10000) {
				protected void onWake() {
					new BaseAgent().sendMessageToAgentsByServiceType(this.myAgent, "DsoAgent", "BuyFromYou",
							"Ciao Dso, voglio acquistare "+ ((BatteryAgent) myAgent).getDbBattery().getConsumerEnReq("Battery") + " Kw da te.");
				}
			});
		}
		else {
			System.out.println(this.myAgent.getLocalName()+": Sono carica (a pallettoni)!!!!!!!!");
			((BatteryAgent) myAgent).getDbBattery().updateProviderData(50, ((BatteryAgent) myAgent).getBattery().getBatteryPrice(), ((BatteryAgent) myAgent).getBattery().getBudget(), "Battery");
			this.myAgent.doDelete();
		}    	
    }
}
