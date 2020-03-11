/**
 * 
 */
package com.pool;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * @author BEN LAHMAR EL HABIB
 *
 */
public class ExecutorService1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// cr�ation d'un service d'ex�cution avec de 4 threads
		ExecutorService service = Executors.newFixedThreadPool(4) ;

		 // cr�ation de 20 futures pour r�cup�rer le r�sultat 
		 // de nos t�ches
		Future<Integer> [] futures =  new Future[20] ;

		 for (int i =  0 ; i < futures.length ; i++) {
		    // pour �tre utilis�e dans une classe anonyme, 
		    // cette variable doit �tre final, ce ne peut donc pas �tre i
		    final  int k = i ;
		   System.out.println("Lancement de " + k) ;
		   futures[i] = service.submit(new Callable<Integer>() {

		       public Integer call()  throws Exception {
		          // simulation d'un traitement
		         System.out.println("[" + k +  "] thread : " + Thread.currentThread().getName()) ;
		          return k ;
		      }

		   }) ;
		}

		 // autres traitement dans le thread courant

		 // tableau des r�sultats
		 int [] result =  new  int [futures.length] ;

		 // r�cup�ration des r�sultats par interrogation des
		 // futures
		 for (int i =  0 ; i < futures.length ; i++) {
		    try {
		       // on donne 100ms � un future pour r�pondre
		      result[i] = futures[i].get(100, TimeUnit.MILLISECONDS) ;
		      System.out.println(result[i]) ;
		   
		    // gestion des exceptions
		   }  catch (TimeoutException e) {
		      result[i] = -1 ;
		   }  catch (ExecutionException e) {
		      result[i] = -1 ;
		   }  catch (InterruptedException e) {
		      result[i] = -1 ;
		   }
		}

		 // fermeture du service
		 // sans quoi la JVM reste active
		service.shutdown() ;
		System.out.println("Fin du traitement") ;

	}

}
