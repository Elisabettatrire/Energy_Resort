package agents;

import behaviours.DsoPriceBehaviour;
import behaviours.ReceiveMessages;
import data.DsoData;
import data.SolarData;
import database.DbDsoData;
import database.DbSolarData;

/**
 * Questo è l'agente che è a diretto contatto con il gestore nazionale di
 * energia elettrica
 */

@SuppressWarnings("serial")
public class DsoAgent extends BaseAgent {

	private DsoData dso;
	private DbDsoData dbDso;

	public DsoData getDso() {
		return dso;
	}

	public void setDso(DsoData dso) {
		this.dso = dso;
	}

	public DbDsoData getDbDso() {
		return dbDso;
	}

	public void setDbDso(DbDsoData dbDso) {
		this.dbDso = dbDso;
	}

	protected void setup() {
		registerDfAgent(this.getHap(), "DsoAgent");
		dso = new DsoData();
		dbDso = new DbDsoData();

		this.addBehaviour(new DsoPriceBehaviour(dso));

	}
}
