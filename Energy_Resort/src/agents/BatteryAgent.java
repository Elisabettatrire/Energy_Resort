package agents;

import behaviours.BatteryBehaviour;
import behaviours.ReceiveMessages;
import data.BatteryData;
import database.DbAeolianData;
import database.DbBatteryData;

/**
 * Behaviour per istanziazione e setup dell'agente Battery
 * 
 * Nel setup si controlla se la batteria nella sessione precedente si è
 * ricaricata al massimo, in caso affermativo si setta a 50 la sua capacità
 * altrimenti si lascia il valore della capacità che aveva alla fine della
 * sessione precedente
 */

public class BatteryAgent extends BaseAgent {

	BatteryData battery;
	DbBatteryData dbBattery;

	public DbBatteryData getDbBattery() {
		return dbBattery;
	}

	public void setDbBattery(DbBatteryData dbBattery) {
		this.dbBattery = dbBattery;
	}

	public BatteryData getBattery() {
		return battery;
	}

	public void setBattery(BatteryData battery) {
		this.battery = battery;
	}

	protected void setup() {

		battery = new BatteryData();
		dbBattery = new DbBatteryData();
		battery.setBatteryPrice(0.9);
		battery.setBudget(75);
		if (dbBattery.getMyCapacity("Battery") <= 10) {
			dbBattery.updateProviderData(50, battery.getBatteryPrice(), battery.getBudget(), "Battery");
			System.out.println(this.getLocalName() + " dice: Sono carica al massimo. Posso tornare a vendere.");
			battery.setCapacity(dbBattery.getMyCapacity("Battery"));
		} else {
			battery.setCapacity(dbBattery.getMyCapacity("Battery"));
			dbBattery.updateProviderData(battery.getCapacity(), battery.getBatteryPrice(), battery.getBudget(),
					"Battery");
		}

		dbBattery.updateConsumerData(0, battery.getBudget(), "Battery");

		registerDfAgent(this.getHap(), "BatteryAgent");

		this.addBehaviour(new BatteryBehaviour(this, battery));
	}
}
