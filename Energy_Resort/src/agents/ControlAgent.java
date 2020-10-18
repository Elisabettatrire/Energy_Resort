package agents;

import database.DbBungalowData;
import jade.core.Agent;
import jade.core.behaviours.OneShotBehaviour;
import jade.core.behaviours.TickerBehaviour;

public class ControlAgent extends BaseAgent {

	DbBungalowData dbBunData;

	protected void setup() {

		dbBunData = new DbBungalowData();

		addBehaviour(new TickerBehaviour(this, 40000) {

			protected void onTick() {

				if (dbBunData.getMyEnReq("Bungalow1") == 0 && dbBunData.getMyEnReq("Bungalow2") == 0
						&& dbBunData.getMyEnReq("Bungalow3") == 0) {

					System.out.println("E' FINITA ANAKIN!!! ... SONO PIU' IN ALTO DI TE!!");
				
				        System.exit(0);

//					Thread t = new Thread() {
//
//						public void run() {
//
//							try {
//
//								getContainerController().getPlatformController().kill();
//
//							}
//
//							catch (Exception e) {
//
//								e.printStackTrace();
//
//							}
//
//						}
//
//					};
//
//					t.start();

				}
			}
		});

		registerDfAgent(this.getHap(), "ControlAgent");
	}

}
