package database;

import data.AeolianData;
import data.BungalowData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;




public class DbAeolianData extends DbConnection{
	
	public AeolianData getAeolianData () {
		
		AeolianData data= new AeolianData();
		//.....
		return data;
	}
	
//	public AeolianData getLastAeolianData (int idLoad, Calendar datetime)
//	{
//		LoadData data = new LoadData();
//		//System.out.println("In query: datetime:"+datetime.getTime());
//		String query = "SELECT *"
//				+ " FROM LoadDataHistory"
//				+ " WHERE IdLoad = "+idLoad
//				+ " AND DateTime = '"+format.format(datetime.getTime())+"'";
//		//System.out.println(query);
//		try {
//			ResultSet rs = stmt.executeQuery(query);
//			while(rs.next())
//			{
//				Calendar cal = Calendar.getInstance();
//				cal.setTime(rs.getTimestamp("DateTime"));
//				
//				Calendar cal1 = null;
//				if(rs.getTimestamp("ToDateTime") != null)
//				{
//					cal1 = Calendar.getInstance();
//					cal1.setTime(rs.getTimestamp("ToDateTime"));
//				}
//				data = new LoadData(rs.getInt("IdLoad"), cal, rs.getDouble("CostKwh"), 
//						rs.getDouble("CriticalConsumption"), rs.getDouble("NonCriticalConsumption"), 
//						rs.getDouble("ConsumptionMin"), rs.getDouble("ConsumptionMax"), 
//						rs.getDouble("PowerRequested"), rs.getDouble("DesiredChoice"), 
//						rs.getDouble("ConsumptionShifted"), cal1, rs.getInt("SolutionNumber"));
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			connClose();
//		}
//		return data;
//	}
	
	public int getWind(int dayHour, int weekDay) {
		
		//AeolianData data = new AeolianData();
		String query = "SELECT idVento" 
				+ " FROM Meteo"
				+ " WHERE idOrario = "+dayHour
				+ " AND idGiorno = "+weekDay;
		
		
		//System.out.println(query);
		try {
			ResultSet rs = stmt.executeQuery(query);
			while(rs.next())
			{			
				return rs.getInt("idVento");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			//connClose(); la connessione non può essere chiusa altrimenti 
			//onTick di AeolianBehaviour non riesce ad accedere periodicamente al db!!
		}
	
		
		return 0;
	}

}
