/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.moma.kth.iv1350.view;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.logging.Level;
import java.util.logging.Logger;
import se.moma.kth.iv1350.controller.Controller;
import se.moma.kth.iv1350.dbhandler.exception.VehicleRegistryException;
import se.moma.kth.iv1350.model.CreditCardInformationDTO;
import se.moma.kth.iv1350.model.exception.InspectionException;
import se.moma.kth.iv1350.util.exception.OperationFailedException;

/**
 * Skapar ett användargränssnitt.
 * @author monde
 */
public class View {
    
   
  
    Controller controller = null;
    LocalDate dnow = LocalDate.now();
    LocalTime tnow = LocalTime.now();
    
    private final static int VEHICLE_NUMBER = 10;
    private final static int VEHICLE_NUMBER_WITH_NO_INSPECTION = 20;
   
    
    
    /**
     * Skapar en ny instans.
     * @param controller En instans av <code>Controller</code>.
     */
    public View(Controller controller)  {
       this.controller = controller;
    }
    
    /**
     * Startar en ny fordonsbesiktning.
     */
    public void sampleExecution()  {
        int cost = 0;
       
        controller.inspectNewVehicle();
        controller.closeGarage();
        
        
        try {
            if((cost = controller.registerNumber(VEHICLE_NUMBER)) == 0) {
                System.out.println("No vehicle with that number.");
            }else {
                System.out.println("Inspection cost for Vehicle: "+ cost);
            }
        
     
        
            System.out.println("-----Begin receipt-----");
            System.out.println("Date: "+dnow);
            System.out.println("Time: "+tnow);
            System.out.println("Transaction: "+ controller.pay(cost, new CreditCardInformationDTO()));
            System.out.println("-----End receipt-----");

       
            System.out.println("Inspection for the vehicle: " + controller.inspectVehicle());
        } catch (InspectionException ex) {
            //Logger.getLogger(View.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
            System.out.println(ex.getVehicleWithNoInspections());
        }

        controller.enterResultOfInspection("PASS");

        controller.printResult();
        controller.openGarage();
        controller.closeGarage();
        
    }
    
    
    
}
