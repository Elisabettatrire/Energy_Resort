package behaviours;

import java.util.Hashtable;

import data.BungalowData;
import jade.core.Agent;
import jade.core.behaviours.OneShotBehaviour;

public class ChoiceBungalowBehaviour extends OneShotBehaviour{
	
	Hashtable<String, Double> energyPrices;
	
	
	public void setEnergyPrices(double price, Agent a) {
		energyPrices.put(a.getLocalName(), price);
		
	}

	
	public void action() {
		BungalowData bdata= new BungalowData(10, 7, 12, 7, energyPrices);
		
		
	}

}
