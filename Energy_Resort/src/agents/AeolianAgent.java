package agents;

import java.util.Calendar;

import behaviours.AeolianBehaviour;
import behaviours.ReceiveMessages;
import data.AeolianData;
//import behaviours.ReceiveMessagesAeolian;
import database.DbAeolianData;


public class AeolianAgent extends BaseAgent{
	
	private AeolianData aeolian;
	private DbAeolianData dbAeolian;
	
	public AeolianData getAeolian() {
		return aeolian;
	}

	public void setAeolian(AeolianData aeolian) {
		this.aeolian = aeolian;
	}

	public DbAeolianData getDbAeolian() {
		return dbAeolian;
	}

	public void setDbAeolian(DbAeolianData dbAeolian) {
		this.dbAeolian = dbAeolian;
	}

	protected void setup(){
		aeolian = new AeolianData();
		dbAeolian = new DbAeolianData();
		Calendar calendar = Calendar.getInstance();
        int day=calendar.get(Calendar.DAY_OF_WEEK);
        int hour= calendar.get(Calendar.HOUR_OF_DAY)+2;
        aeolian.setDayHour(hour);
        aeolian.setWeekDay(day);
        aeolian.setWindForecast(dbAeolian.getWind(aeolian.getDayHour(), aeolian.getWeekDay()));
        
       if(aeolian.getWindForecast()==1) {           
            aeolian.setWindPrice(0.3);
            aeolian.setWindKw(10);
        }
        else if(aeolian.getWindForecast()==2) {
            aeolian.setWindPrice(0.6);
            aeolian.setWindKw(5);
        }
        else {
            aeolian.setWindPrice(1.2);
            aeolian.setWindKw(2);
        }
        
        aeolian.setCounterWindKw(aeolian.getWindKw());
		registerDfAgent(this.getHap(), "AeolianAgent");
		
		this.addBehaviour(new AeolianBehaviour(this, aeolian));
		//this.addBehaviour(new ReceiveMessages(this, 10000));
		//this.addBehaviour(new ReceiveMessagesAeolian(this));
	}
}
