package database;

import java.sql.ResultSet;
import java.sql.SQLException;

import data.SolarData;

public class DbDsoData extends DbConnection {

	private String consumer;
	private int data;
	private int kw;
	private int enReq;
	private double budget;

	public int getMaxEnReq() {
		String query = "SELECT MAX(CounterKw)" + " FROM dati_consumatori";
		try {
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				data = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return data;
	}

	public String selectBestConsumer(int enReq) {
		String query = "SELECT Nome" + " FROM dati_consumatori" + " WHERE CounterKw = " + enReq;
		try {
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				consumer = rs.getString(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return consumer;
	}

	public Boolean updateProviderData(int Kw, double price, String name) {
		String query = "UPDATE dati_fornitori" + " SET Kw = " + Kw + ", Prezzo = " + price + " WHERE Nome = '" + name
				+ "'";
		try {
			return stmt.execute(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public Boolean updateConsumerData(int Kw, double budget, String name) {
		String query = "UPDATE dati_consumatori" + " SET CounterKw = " + Kw + ", Budget = " + budget + " WHERE Nome = '"
				+ name + "'";
		try {
			return stmt.execute(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public int getMyKw(String name) {
		String query = "SELECT Kw" + " FROM dati_fornitori" + " WHERE Nome = '" + name + "'";
		try {
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				kw = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return kw;
	}

	public int getConsumerEnReq(String name) {
		String query = "SELECT CounterKw" + " FROM dati_consumatori" + " WHERE Nome = '" + name + "'";
		try {
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				enReq = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return enReq;
	}

	public double getConsumerBudget(String name) {
		String query = "SELECT Budget" + " FROM dati_consumatori" + " WHERE Nome = '" + name + "'";
		try {
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				budget = rs.getDouble(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return budget;
	}

}
