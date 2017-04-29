package se.moma.kth.iv1350;


import se.moma.kth.iv1350.GarageDoor;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author monde
 */
public class Garage {
    
   
    private GarageDoor garageDoor; //instansvariabel
    /**
     * Skapar en instans av klassen <code>Garage</code>.
     * @param garageDoor Är en instans av klassen <code>GarageDoor</code>
     */
    public Garage(GarageDoor garageDoor) {
        this.garageDoor = garageDoor;
    }
    
    /**
     * Stänger garaget och använder sig av en instans av klassen 
     * <code>GarageDoor</code>.
     */
    public void closeGarage() {
        garageDoor.close();
    }
    /**
     * Stänger garaget och använder sig av en instans av klassen
     * <code>GarageDoor</code>.
     */
    public void openGarage() {
        garageDoor.open();
    }
}
