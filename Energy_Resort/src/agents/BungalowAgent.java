package agents;

import behaviours.ReceiveMessages;
import data.BungalowData;
import database.DbBungalowData;
import jade.core.Agent;
import agents.BaseAgent;

import java.util.Calendar;
import java.util.Hashtable;

import behaviours.BungalowBehaviour;

public class BungalowAgent extends BaseAgent {

	private DbBungalowData bungalowDb;
	private BungalowData bungalow;

	public DbBungalowData getBungalowDb() {
		return bungalowDb;
	}

	public void setBungalowDb(DbBungalowData bungalowDb) {
		this.bungalowDb = bungalowDb;
	}

	public BungalowData getBungalow() {
		return bungalow;
	}

	public void setBungalow(BungalowData bungalow) {
		this.bungalow = bungalow;
	}

	protected void setup() {
		bungalow = new BungalowData();
		bungalowDb = new DbBungalowData();
		Calendar calendar = Calendar.getInstance();
		int day = calendar.get(Calendar.DAY_OF_WEEK);
		int hour = calendar.get(Calendar.HOUR_OF_DAY) + 2;
		bungalow.setDayHour(hour);
		bungalow.setWeekDay(day);
		bungalow.setId(bungalowDb.getBungalowID(this.getLocalName()));
		bungalow.setBudget(bungalowDb.getBungalowData(bungalow).getBudget());
		bungalow.setEnReq(bungalowDb.getBungalowData(bungalow).getEnReq());

		bungalowDb.updateConsumerData(bungalow.getEnReq(), bungalow.getBudget(), "Bungalow" + bungalow.getId());

		registerDfAgent(this.getHap(), "BungalowAgent");

		this.addBehaviour(new BungalowBehaviour(this, bungalow));
		this.addBehaviour(new ReceiveMessages(this, 10000));

	}
}
