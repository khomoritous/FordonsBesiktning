package se.moma.kth.iv1350.model.external;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Skapar en garagedörr till en instans av <code>Garage</code>.
 * @author monde
 */
public class GarageDoor {
    
    /**
     * Skapar en ny instans.
     */
    public GarageDoor() {
    }
    
    /**
     * Stänger dörren till <code>Garage</code>.
     */
    public void closeDoor() {
        System.out.println("Closing garage door....");
    }
    
    /**
     * Öppnar dörren till <code>Garage</code>.
     */
    public void openDoor() {
        System.out.println("Opening garage door....");   
    }
    
}
