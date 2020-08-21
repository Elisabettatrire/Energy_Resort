package database;

import java.sql.ResultSet;
import java.sql.SQLException;
import data.BungalowData;
import utils.EnergyData;


public class DbBungalowData extends DbConnection {
	// dayHour e weekDay devono essere settati da un altro metodo
	public BungalowData getBungalowData (String nameBudget, String nameNeeds, int dayHour, int weekDay)
	{
		BungalowData data = new BungalowData();
		//System.out.println("In query: datetime:"+datetime.getTime());
		String query = "SELECT " +nameBudget +nameNeeds
				+ " FROM Bisogni_energetici"
				+ " WHERE Ora_giorno = "+dayHour
				+ " AND Giorno_set = "+weekDay;
		//System.out.println(query);
		try {
			ResultSet rs = stmt.executeQuery(query);
			while(rs.next())
			{			
				data = new BungalowData(rs.getInt("budget"), 
						rs.getInt("enReq"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connClose();
		}
		return data;
	}
}
