package database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import data.BatteryData;
import jade.core.Agent;


public class DbBatteryData extends DbConnection {

	private String provider;
	
	public double selectMinPrice(BatteryData data) {
		String query = "SELECT MIN(Prezzo)" 
				+ " FROM dati_fornitori"
				+ " WHERE Kw != 0";
		try {
			ResultSet rs= stmt.executeQuery(query);
			while(rs.next())
			{			
                data.setMinPrice(rs.getDouble(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			//connClose();
		}
		return data.getMinPrice();
	}
	
	public String selectBestProvider(double price) {
		String query = "SELECT Nome" 
				+ " FROM dati_fornitori"
				+ " WHERE Prezzo = "+price;
		try {
			ResultSet rs= stmt.executeQuery(query);
			while(rs.next())
			{			
                provider = rs.getString(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			//connClose();
		}
		return provider;
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
