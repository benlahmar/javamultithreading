/**
 * 
 */
package com.processus.sync;

/**
 * @author BEN LAHMAR EL HABIB
 *
 */
public class Bouteille {
    private  boolean plein = false ;  
    private Verre verre ;
    // on ne peut se remplir que si le verre est plein
    public   void remplis() {
       if (verre.isPlein()) {
         plein = true ;
         verre.setPlein(false) ;
      }
   }
    // et l'on ne peut se vider que si le verre est vide
    public    void vide() {
       if (!verre.isPlein()) {
         plein = false ;
         verre.setPlein(true) ;
      }
   }
   
    // permet au monde extérieur de savoir
    // si nous sommes plein ou vide
    public    boolean isPlein() {
       return  this.plein ;
   }

    // reste des getters non synchronisé
    public  void setPlein(boolean plein) {
       this.plein = plein ;
   }
	
    public Verre getVerre() {
       return verre ;
   }

	public void setVerre(Verre verre) {
		this.verre = verre;
	}
}
