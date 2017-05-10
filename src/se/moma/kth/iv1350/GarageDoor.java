package se.moma.kth.iv1350;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Skapar en garagedörr till en instans av klassen <code>Garage</code>
 * @author monde
 */
public class GarageDoor {
    
    /**
     * Skapar en ny instans.
     */
    public GarageDoor() {
    }
    
    /**
     * Stänger dörren till garaget.
     */
    public void close() {
        System.out.println("Closing garage door....");
    }
    
    /**
     * Öppnar dörren till garaget.
     */
    public void open() {
        System.out.println("Opening garage door....");   
    }
    
}
