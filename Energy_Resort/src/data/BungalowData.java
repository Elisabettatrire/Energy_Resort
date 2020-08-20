package data;


@SuppressWarnings("serial")
public class BungalowData {
	
	//private int idBungalow;
	private int budget;
	private int en_req; //sarebbe bisogni
	//private ora_del_giorno: è char o int?;
	//private giorno_set: è char o int?;
	
	
//	public DerData(int idDer, Calendar datetime, double costKwh, double productionMin, double productionMax,
//			double productionRequested, double desiredChoice) 
//	{
//		this.idDer = idDer;
//		this.datetime = (Calendar)datetime.clone();
//		this.costKwh = costKwh;
//		this.productionMin = productionMin;
//		this.productionMax = productionMax;
//		this.productionRequested = productionRequested;
//		this.desiredChoice = desiredChoice;
//	}

	public int getBudget() {
		return budget;
	}
	public void setBudget(int budget) {
		this.budget = budget;
	}
	public int getEn_req() {
		return en_req;
	}
	public void setEn_req(int en_req) {
		this.en_req = en_req;
	}

}
