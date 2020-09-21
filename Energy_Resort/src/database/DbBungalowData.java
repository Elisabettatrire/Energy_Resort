package database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import data.BungalowData;
import utils.EnergyData;
import jade.core.Agent;


public class DbBungalowData extends DbConnection {
	int id;
	public int getBungalowID(String name) {	
		final String query = "SELECT id FROM bungalow WHERE nome = ? ";
		PreparedStatement ps = null;
		
		try {
			ps = conn.prepareStatement(query);
			ps.setString(1, name);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){			
				id = rs.getInt("id");
			}
		}
		catch (Exception e) {
	    e.printStackTrace();
		}
		finally {
//			  if (ps != null) {
//			    try {
//			      ps.close();
//			    } catch (Exception ignored) {
//			    }
////			ResultSet rs = stmt.executeQuery(query);
////			while(rs.next())
			
////		} catch (SQLException e) {
////			e.printStackTrace();
////		} finally {
////			//connClose();
////		}
//		
//	}
}
		return id;
}
	
	public BungalowData getBungalowData(BungalowData data)
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
				data.setEnReq(rs.getInt("Bisogni_b"+data.getId()));
				data.setBudget(rs.getInt("Budget_b"+data.getId()));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			//connClose();
		}
		return data;
	}
}
