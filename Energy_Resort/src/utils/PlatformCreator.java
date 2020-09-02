package utils;

import jade.core.Profile;
import jade.core.ProfileImpl;
import jade.core.Runtime;
import jade.wrapper.AgentController;
import jade.wrapper.ContainerController;
import jade.wrapper.StaleProxyException;

/**
 * Applicazione esterna che gestisce il lancio di una piattaforma ad agenti,
 * attraverso la creazione di un main container e la creazione di un'istanza di Agent0
 *
 */
public class PlatformCreator {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/**
		 * Recupero dell'istanza della classe Runtime
		 */
		Runtime rt = Runtime.instance();
		
		/**
		 * Creazione di un main container:
		 * - il Profile contiene eventuali parametri di configurazione
		 * - createMainContainer(p) crea il main container della piattaforma
		 */
		Profile p = new ProfileImpl();
		p.setParameter("gui", "true");
		ContainerController cc = rt.createMainContainer(p);
		
		try {
			AgentController dso = cc.createNewAgent("Dso", "agents.DsoAgent", null);
			AgentController bungalow = cc.createNewAgent("Bungalow", "agents.BungalowAgent", null);
			AgentController aeolian = cc.createNewAgent("Aeolian", "agents.AeolianAgent", null);
			
			dso.start();
			bungalow.start();
			aeolian.start();
			
			
			
		} catch (StaleProxyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}