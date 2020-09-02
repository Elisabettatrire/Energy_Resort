package database;

import java.sql.ResultSet;
import java.sql.SQLException;
import data.BungalowData;
import utils.EnergyData;


public class DbBungalowData extends DbConnection {
	
	
	// dayHour e weekDay devono essere settati da un altro metodo
	
	
	public BungalowData getBungalowData (BungalowData data)
	{
		//System.out.println("In query: datetime:"+datetime.getTime());
		String query = "SELECT *" 
				+ " FROM Bisogni_energetici"
				+ " WHERE Ora_giorno = "+data.getDayHour()
				+ " AND Giorno_set = "+data.getWeekDay();
		//System.out.println(query);
		try {
			ResultSet rs = stmt.executeQuery(query);
			while(rs.next())
			{			
				data.setEnReq(rs.getInt("Bisogni_b1"));
				data.setBudget(rs.getInt("Budget_b1"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			//connClose();
		}
		return data;
	}
}
