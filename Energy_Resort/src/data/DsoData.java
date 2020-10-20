package data;

import jade.util.leap.Serializable;

public class DsoData implements Serializable {

	private double dsoPrice;
	int[] bungalowNeeds = new int[3];

	public DsoData(double dsoPrice, int[] bungalowNeeds) {
		this.dsoPrice = dsoPrice;
		this.bungalowNeeds = bungalowNeeds;
	}

	public DsoData() {

	}

	public double getDsoPrice() {
		return dsoPrice;
	}

	public void setDsoPrice(double dsoPrice) {
		this.dsoPrice = dsoPrice;
	}

	public int[] getBungalowNeeds() {
		return bungalowNeeds;
	}

	public void setBungalowNeeds(int[] bungalowNeeds) {
		this.bungalowNeeds = bungalowNeeds;
	}
}
