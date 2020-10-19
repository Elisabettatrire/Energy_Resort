package utils;

import java.util.Timer;
import java.util.TimerTask;


public class CountDown {
	  
	  Timer timer;

	  public CountDown() {
	    timer = new Timer();
	    timer.schedule(new WriteTimer(), 0,  60000);
	  }

	public class WriteTimer extends TimerTask {

	    // durata del conto alla rovescia in secondi
	    int duration = 5;

	    public void run() {
	      if (duration > 0) {
	        System.out.println("Restano " + duration + " minuti.");
	        duration--;
	      }else
	      {
	        System.out.println("E' scaduto il tempo.");
	        System.exit(0);
	      }
	    }
	  }
	}