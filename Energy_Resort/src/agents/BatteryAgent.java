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
		battery.setBatteryPrice(0.8);
		battery.setBudget(60);
		battery.setCapacity(50);
		
		battery.setCounterCapacity(battery.getCapacity());
		registerDfAgent(this.getHap(), "BatteryAgent");
		this.addBehaviour(new BatteryBehaviour(this, battery));
		//this.addBehaviour(new ReceiveMessages(this, 10000));
		
	}
}
