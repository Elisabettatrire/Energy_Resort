package data;

import jade.util.leap.Serializable;

public class DsoData implements Serializable{
	
	public DsoData(double dsoPrice) {

		this.dsoPrice = dsoPrice;
		
	}
	
	public DsoData() {
		
	}
	
	
	private double dsoPrice;

	public double getDsoPrice() {
		return dsoPrice;
	}

	public void setDsoPrice(double dsoPrice) {
		this.dsoPrice = dsoPrice;
	}

}
