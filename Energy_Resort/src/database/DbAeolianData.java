package database;

import data.AeolianData;
import data.BungalowData;
import java.sql.ResultSet;
import java.sql.SQLException;


public class DbAeolianData extends DbConnection{
	
	public AeolianData getAeolianData () {
		
		AeolianData data= new AeolianData();
		//.....
		return data;
	}
	
	public int getWind(int dayHour, int weekDay) {
		
		String query = "SELECT idVento" 
				+ " FROM Meteo"
				+ " WHERE Ora_giorno = "+dayHour
				+ " AND Giorno_set = "+weekDay;
		
		//SELECT idVento FROM `meteo` WHERE idGiorno=1 AND idOrario=17
		System.out.println(query);
		try {
			ResultSet rs = stmt.executeQuery(query);
			while(rs.next())
			{			
				return rs.getInt("idVento");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connClose();
		}
	
		
		return 0;
	}

}
