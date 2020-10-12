package agents;
import java.util.Calendar;

import behaviours.AeolianBehaviour;
import behaviours.ReceiveMessages;
import behaviours.SolarBehaviour;
import data.SolarData;
import database.DbSolarData;


public class SolarAgent extends BaseAgent{
	
	private SolarData solar;
	private DbSolarData dbSolar;
	
	public SolarData getSolar() {
		return solar;
	}
	public void setSolar(SolarData solar) {
		this.solar = solar;
	}
	public DbSolarData getDbSolar() {
		return dbSolar;
	}
	public void setDbSolar(DbSolarData dbSolar) {
		this.dbSolar = dbSolar;
	}
	protected void setup(){
		solar = new SolarData();
		dbSolar = new DbSolarData();
		Calendar calendar = Calendar.getInstance();
        int day=calendar.get(Calendar.DAY_OF_WEEK);
        int hour= calendar.get(Calendar.HOUR_OF_DAY)+2;
        solar.setDayHour(hour);
        solar.setWeekDay(day);
        solar.setSolarForecast(dbSolar.getWeather(solar.getDayHour(), solar.getWeekDay()));
        
//        System.out.println("il vento e': "+aeolian.getWindForecast()); 
//          System.out.println("il giorno e': "+day);
//          System.out.println("l'ora e': " + hour);
        
        if(solar.getSolarForecast()==1) {          
            solar.setSolarPrice(0.2);
            solar.setSolarKw(20);
        }
        else if(solar.getSolarForecast()==2){
            solar.setSolarPrice(0.4);
            solar.setSolarKw(15);
            }
        else if(solar.getSolarForecast()==3){
        	solar.setSolarPrice(0.8);
            solar.setSolarKw(5);
        } else if(solar.getSolarForecast()==4){
        	solar.setSolarPrice(1);
            solar.setSolarKw(2);
        } else if(solar.getSolarForecast()==5){
        	solar.setSolarPrice(0.6);
            solar.setSolarKw(10);
        } 
       
        dbSolar.updateProviderData(solar.getSolarKw(), solar.getSolarPrice(), "Solar");
        
		registerDfAgent(this.getHap(), "SolarAgent");
		this.addBehaviour(new SolarBehaviour(this, solar));
	}
}
