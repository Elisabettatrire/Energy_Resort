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
	
	public int getWind(int dayHour, int weekDay) {
		
		String query = "SELECT idVento" 
				+ " FROM Meteo"
				+ " WHERE idOrario = "+dayHour
				+ " AND idGiorno = "+weekDay;
	
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
	public Boolean updateProviderData(int Kw, String name) {
		String query = "UPDATE dati_fornitori"
				+" SET Kw = "+Kw
				+" WHERE Nome = '"+name+"'";
		try {
			return stmt.execute(query);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			//connClose();
		}
		return false;
	}
}
