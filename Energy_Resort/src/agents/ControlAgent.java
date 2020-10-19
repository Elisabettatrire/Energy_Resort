package agents;

import database.DbBatteryData;
import database.DbBungalowData;
import jade.core.Agent;
import jade.core.behaviours.OneShotBehaviour;
import jade.core.behaviours.TickerBehaviour;

public class ControlAgent extends BaseAgent {

	DbBungalowData dbBunData;
	DbBatteryData dbBatteryData;

	protected void setup() {

		dbBunData = new DbBungalowData();
		dbBatteryData = new DbBatteryData();

		addBehaviour(new TickerBehaviour(this, 40000) {

			protected void onTick() {

				if (dbBunData.getMyEnReq("Bungalow1") == 0 && dbBunData.getMyEnReq("Bungalow2") == 0
						&& dbBunData.getMyEnReq("Bungalow3") == 0 && dbBatteryData.getMyCapacity("Battery")!=0) {

					System.out.println("Fine delle contrattazioni.");
				
				        System.exit(0);

				}
			}
		});

		registerDfAgent(this.getHap(), "ControlAgent");
	}

}
