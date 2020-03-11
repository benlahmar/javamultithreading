/**
 * 
 */
package com.processus.sync;

/**
 * @author BEN LAHMAR EL HABIB
 *
 */
public class Test {

	public static void main(String[] args) throws InterruptedException {
		
	final Bouteille bouteille =  new Bouteille() ;
	 final Verre verre =  new Verre() ;
	 bouteille.setVerre(verre) ;
	 verre.setBouteille(bouteille) ;

	 // création d'une instance de Runnable qui remplit et vide la carafe
	 // dans le verre
	 // on peut augmenter le nombre de cycles dans la boucle for
	Runnable carafeApp =  new Runnable() {
		
	    public  void run() {

	       for (int i =  0 ; i <  20 ; i++) {
	    	   bouteille.remplis() ;
	    	   bouteille.vide() ;
	      }
	   }
	} ;

	 // création d'une instance de Runnable qui remplit et vide le verre
	 // dans la carafe
	 // on peut augmenter le nombre de cycles dans la boucle for
	Runnable verreApp =  new Runnable() {

	    public  void run() {

	       for (int i =  0 ; i <  20 ; i++) {
	         verre.remplis() ;
	         verre.vide() ;
	      }
	   }
	} ;

	 // création des threads
	Thread [] carafeApps =  new Thread [5] ;
	Thread [] verreApps =  new Thread [5] ;

	 // creation des threads pour le vidage de la carafe
	 // et du verre
	 for (int i =  0 ; i < carafeApps.length ; i++) {
	   carafeApps[i] =  new Thread(carafeApp) ;
	   verreApps[i] =  new Thread(verreApp) ;
	}

	 // lancement des threads
	 for (int i =  0 ; i < carafeApps.length ; i++) {
	   carafeApps[i].start() ;
	   verreApps[i].start() ;
	}

	 // attente de la fin de l'exécution des threads
	 for (int i =  0 ; i < carafeApps.length ; i++) {
	   carafeApps[i].join() ;
	   verreApps[i].join() ;
	}
	 
}
}
