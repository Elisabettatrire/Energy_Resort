package agents;


import behaviours.BatteryBehaviour;
import behaviours.ReceiveMessages;
import data.BatteryData;
import database.DbAeolianData;
import database.DbBatteryData;

public class BatteryAgent extends BaseAgent{

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
		battery.setCapacity(dbBattery.getMyCapacity("Battery"));
		dbBattery.updateProviderData(battery.getCapacity(), battery.getBatteryPrice(), battery.getBudget(), "Battery");
		dbBattery.updateConsumerData(0, battery.getBudget(), "Battery");
		
		
		registerDfAgent(this.getHap(), "BatteryAgent");
		
		this.addBehaviour(new BatteryBehaviour(this, battery));
		//this.addBehaviour(new ReceiveMessages(this, 10000));
		
	}
}
