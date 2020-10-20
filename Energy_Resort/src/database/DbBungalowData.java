package database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import data.BungalowData;
import jade.core.Agent;

public class DbBungalowData extends DbConnection {
	private int id;
	private String provider;
	private int enReq;

	public int getBungalowID(String name) {
		final String query = "SELECT id FROM bungalow WHERE nome = ? ";
		PreparedStatement ps = null;

		try {
			ps = conn.prepareStatement(query);
			ps.setString(1, name);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				id = rs.getInt("id");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return id;
	}

	public BungalowData getBungalowData(BungalowData data) {

		String query = "SELECT *" + " FROM Bisogni_energetici" + " WHERE Ora_giorno = " + data.getDayHour()
				+ " AND Giorno_set = " + data.getWeekDay();

		try {
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				data.setEnReq(rs.getInt("Bisogni_b" + data.getId()));
				data.setBudget(rs.getDouble("Budget_b" + data.getId()));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return data;
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

	public Boolean setNullBPrice(String name) {
		String query = "UPDATE dati_fornitori" + " SET Prezzo = " + null + " WHERE Nome = '" + name + "'";
		try {
			return stmt.execute(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public double selectMinPrice(BungalowData data) {
		String query = "SELECT MIN(Prezzo)" + " FROM dati_fornitori" + " WHERE Kw > 0";
		try {
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				data.setMinPrice(rs.getDouble(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return data.getMinPrice();
	}

	public String selectBestProvider(double price) {
		String query = "SELECT Nome" + " FROM dati_fornitori" + " WHERE Prezzo = " + price;
		try {
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				provider = rs.getString(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return provider;
	}

	public int getMyEnReq(String name) {
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

}
