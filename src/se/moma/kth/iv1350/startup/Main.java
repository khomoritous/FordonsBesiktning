package se.moma.kth.iv1350.startup;

import se.moma.kth.iv1350.controller.Controller;
import se.moma.kth.iv1350.dbhandler.VehicleRegistry;
import se.moma.kth.iv1350.model.external.CustomerQueue;
import se.moma.kth.iv1350.model.external.Garage;
import se.moma.kth.iv1350.model.external.GarageDoor;
import se.moma.kth.iv1350.view.View;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * 
 * @author monde
 */
public class Main {
 
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
            new View(new Controller(new Garage(new GarageDoor(), new CustomerQueue()),new VehicleRegistry())).sampleExecution();
    }
}
       

       
     
   

