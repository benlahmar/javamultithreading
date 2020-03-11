/**
 * 
 */
package com.pool;

import java.net.InetAddress;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author BEN LAHMAR EL HABIB
 *
 */
public class ExecutorService2 {

	public static void main(String[] args) throws Throwable {  
		final InetAddress host= InetAddress.getByName("www.google.com");  
	ExecutorService executor = Executors.newCachedThreadPool();
	Future<Long> future = executor.submit( 
	// création et soumission d'une tâche qui retourne un long 
	new Callable<Long>() {	
		public Long call() throws Exception {	
			long t = System.nanoTime();	
				if(!host.isReachable(2000))
	throw new Exception(host.toString());  
				long t2 = System.nanoTime()-t;	
	return t2;
	}
	});
	executor.shutdown();	// fermeture de l'Executor  
	try {
	System.out.println("reach "+host+" in "+
	future.get()+" ns"); // l'appel à get est bloquant
	} catch (ExecutionException e) { 
		throw e.getCause(); 
		}
	} // Si l'exécution lève une exception, elle est transmise


}
