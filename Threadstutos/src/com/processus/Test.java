/**
 * 
 */
package com.processus;

/**
 * @author BEN LAHMAR EL HABIB
 *
 */
public class Test {

	public static void main(String[] args) {
	
	 final Chaudiere chaudiere =  new Chaudiere() ;

	 
	Runnable habitant =  new Runnable() {
	    public  void run() { 
	       // chaque habitant poss�de son propre thermostat
	      Thermostat thermostat =  new Thermostat(chaudiere) ;
	       int nTry =  0 ;
	       do {
	         thermostat.plusChaud() ;
	         nTry++ ;	         
	          // on lui donne le droit de le faire 5 fois
	      }  while (nTry <  5) ;
	   }
	};

	 
	Thread [] habitants =  new Thread[20] ;
	// cr�ation de nos habitants
	 for (int i =  0 ; i < habitants.length ; i++) {
	   habitants[i] =  new Thread(habitant) ;
	}
	 // lancement de nos habitants
	 for (int i =  0 ; i < habitants.length ; i++) {
	   habitants[i].start() ;
	}
	 // on attend que chaque thread ait fini son ex�cution
	 for (int i =  0 ; i < habitants.length ; i++) {
	   try {
		habitants[i].join() ;
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
	 // on affiche la temp�rature de notre chaudi�re
	System.out.println("Temperature finale = " + chaudiere.getTemperature()) ;
}
}