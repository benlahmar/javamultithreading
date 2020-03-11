/**
 * 
 */
package com.processus.sync;

/**
 * @author BEN LAHMAR EL HABIB
 *
 */
public class Verre {
	 private  boolean plein = false ;
	   
	    // un verre a besoin d'une carafe pour se remplir
	    private Bouteille bouteille ;

	    // on ne peut se remplir que si la carafe est pleine
	    public    void remplis() {
	       if (bouteille.isPlein()) {
	         plein = true ;
	         bouteille.setPlein(false) ;
	      }
	   }

	    // et l'on ne peut se vider que si la carafe est vide
	    public    void vide() {
	       if (!bouteille.isPlein()) {
	         plein = false ;
	         bouteille.setPlein(true) ;
	      }
	   }
	   
	    // permet au monde extérieur de sa voir
	    // si nous sommes plein ou vide
	    public    boolean isPlein() {
	       return  this.plein ;
	   }

	    // reste des getters non synchronisé
	    public  void setPlein(boolean plein) {
	       this.plein = plein ;
	   }
		
	    public Bouteille getBouteille() {
	       return bouteille ;
	   }

		public void setBouteille(Bouteille bouteille) {
			this.bouteille = bouteille;
		}
}
