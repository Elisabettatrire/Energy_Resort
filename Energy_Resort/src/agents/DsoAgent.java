package agents;

import behaviours.DsoPriceBehaviour;
import behaviours.ReceiveMessages;
import data.DsoData;

@SuppressWarnings("serial")
public class DsoAgent extends BaseAgent{
	protected void setup(){
		
		registerDfAgent(this.getHap(), "DsoAgent");
		DsoData dso = new DsoData();
		this.addBehaviour(new DsoPriceBehaviour(dso));
		this.addBehaviour(new ReceiveMessages(this, 10000));
	}
	

}
