package com.processus;

public class Thermostat {

	private Chaudiere chaudiere ;

    // un thermostat s'adresse à une unique chaudiere
    public Thermostat(Chaudiere chaudiere) {
       this.chaudiere = chaudiere ;
   }

    public  boolean plusChaud() { 
    	// synchronized(chaudiere) {
       if (chaudiere.getTemperature() <  25) {
          // l'appel à cette méthode indique simplement à la machine Java 
          // qu'elle doit interrompre momentanément l'exécution de ce thread, 
          // et passer la main au thread suivant
         Thread.yield() ;
         chaudiere.augmenteTemperature() ;
          return true ;
      }
    	// }
       return false ;
   }
}
