package com.processus;

public class Chaudiere {

	// un unique champ privé : l'état de notre chaudière
    private  int temperature ;

    public Chaudiere() {
       this.temperature =  0 ;
   }

    public  int getTemperature() {
       return  this.temperature ;
   }

    public  void augmenteTemperature() {
       this.temperature =  this.temperature +  1 ;
   }
}
