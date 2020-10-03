package behaviours;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import com.sun.tools.javac.util.*;

import agents.BungalowAgent;
import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;




public class ChoiceProviderBungalow extends CyclicBehaviour{
	
	public ChoiceProviderBungalow(Agent a) {
		super(a);
	}
	
	public void action() {
//		System.out.println(
//
//				Collections.min(((BungalowAgent) myAgent).getBungalow().getEnergyPrices().entrySet(), new Comparator<Hashtable.Entry<String,Integer>>() {
//
//				@Override
//				public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
//
//				return o1.getValue().intValue() - o2.getValue().intValue();
//
//				}})
//
//				.getKey()
//
//
//				);
		ArrayList<String> minKeys= new ArrayList<String>();
		Double minValue = 10.0;
		for(Map.Entry<String,Double> entry : ((BungalowAgent) myAgent).getBungalow().getEnergyPrices().entrySet()) {
		     if(entry.getValue() < minValue) {
		         minKeys.clear(); /* New max remove all current keys */
		         minKeys.add(entry.getKey());
		         minValue = entry.getValue();
		     }
		     else if(entry.getValue() == minValue)
		     {
		       minKeys.add(entry.getKey());
		     }
		}
		//System.out.println(minKeys);
		block();
//		Set entryset = ((BungalowAgent) myAgent).getBungalow().getEnergyPrices().entrySet();
//		Iterator it = entryset.iterator();
//		System.out.println("Hashtable entries : ");
//	    while(it.hasNext()) {
//	    	
//	    }
	    
	
	}

}
