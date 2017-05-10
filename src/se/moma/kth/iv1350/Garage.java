package se.moma.kth.iv1350;


import se.moma.kth.iv1350.GarageDoor;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Skapar ett garage.
 * @author monde
 */
public class Garage {
    
   
    private GarageDoor garageDoor; //instansvariabel
    
    /**
     * Skapar en ny instans.
     * @param garageDoor Är en instans av klassen <code>GarageDoor</code> som
     * hjälper till att öppna och stänga garaget.
     */
    public Garage(GarageDoor garageDoor) {
        this.garageDoor = garageDoor;
    }
    
    /**
     * Stänger garaget.
     */
    public void closeGarage() {
        garageDoor.close();
    }
    /**
     * Oppnar garaget.
     */
    public void openGarage() {
        garageDoor.open();
    }
}
