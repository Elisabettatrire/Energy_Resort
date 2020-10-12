package database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import data.BatteryData;
import jade.core.Agent;


public class DbBatteryData extends DbConnection {

	private String provider;
	private String consumer;
	private int data;
	private int kw;
	private int enReq;
	private double budget;
	
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
	public int getMaxEnReq() {
		String query = "SELECT MAX(CounterKw)" 
				+ " FROM dati_consumatori";
		try {
			ResultSet rs= stmt.executeQuery(query);
			while(rs.next())
			{			
                data=rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			//connClose();
		}
		return data;
	}
	public String selectBestConsumer(int enReq) {
		String query = "SELECT Nome" 
				+ " FROM dati_consumatori"
				+ " WHERE CounterKw = "+enReq;
		try {
			ResultSet rs= stmt.executeQuery(query);
			while(rs.next())
			{			
                consumer = rs.getString(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			//connClose();
		}
		return consumer;
	}
	public Boolean updateProviderData(int Kw, double price, String name) {
		String query = "UPDATE dati_fornitori"
				+" SET Kw = "+Kw +", Prezzo = "+price
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
	public Boolean updateConsumerData(int Kw, double budget, String name) {
		String query = "UPDATE dati_consumatori"
				+" SET CounterKw = "+Kw+", Budget = "+budget
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
	public int getMyKw(String name) {
		String query = "SELECT Kw" 
				+ " FROM dati_fornitori"
				+" WHERE Nome = '"+name+"'";
		try {
			ResultSet rs= stmt.executeQuery(query);
			while(rs.next())
			{			
                kw = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			//connClose();
		}
		return kw;
	}
	public int getConsumerEnReq(String name) {
		String query = "SELECT CounterKw" 
				+ " FROM dati_consumatori"
				+" WHERE Nome = '"+name+"'";
		try {
			ResultSet rs= stmt.executeQuery(query);
			while(rs.next())
			{			
                enReq = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			//connClose();
		}
		return enReq;
	}
	public double getConsumerBudget(String name){
		String query = "SELECT Budget" 
				+ " FROM dati_consumatori"
				+" WHERE Nome = '"+name+"'";
		try {
			ResultSet rs= stmt.executeQuery(query);
			while(rs.next())
			{			
                budget = rs.getDouble(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			//connClose();
		}
		return budget;
	}
}
