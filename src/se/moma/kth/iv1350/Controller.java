package se.moma.kth.iv1350;


import se.moma.kth.iv1350.Garage;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author monde
 */
public class Controller {
    
    private Garage garage; //instansvariabel
    
    /**
     * Skapar en instans av klassen <code>Controller</code>.
     * @param garage Är en instans av klassen <code>Garage</code>.
     */
    public Controller(Garage garage) {
        this.garage = garage;
        
    }
    /**
     * Stänger garaget.
     */
    public void closeDoor() {
        garage.closeGarageDoor();    
    }
    
}
