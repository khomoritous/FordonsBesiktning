/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.moma.kth.iv1350.view;

import java.time.LocalDate;
import java.time.LocalTime;
import se.moma.kth.iv1350.controller.Controller;
import se.moma.kth.iv1350.dbhandler.exceptions.OperationFailedException;
import se.moma.kth.iv1350.model.CreditCardInformationDTO;
import se.moma.kth.iv1350.model.exceptions.InspectionNotFoundException;

/**
 * Skapar ett användargränssnitt.
 * @author monde
 */
public class View {
    
   
   
    private Controller controller = null;
    private LocalDate dnow = LocalDate.now();
    private LocalTime tnow = LocalTime.now();
    private final static int VEHICLE_NUMBER = 10;
    private final static int VEHICLE_NUMBER_WITH_NO_INSPECTION = 15;
    
    private final static int AMOUNT = 100;
    
    
    
    /**
     * Skapar en ny instans.
     */
    public View()  {
       controller = new Controller();
    }
    
    /**
     * Startar en ny fordonsbesiktning.
     */
    public void sampleExecution() {
        
        try {
            controller.inspectNewVehicle();
            controller.closeGarage();
            
            
            System.out.println("Inspection cost for Vehicle: "+ controller.registerNumber(VEHICLE_NUMBER));
            System.out.println("-----Begin receipt-----");
            System.out.println("Date: "+dnow);
            System.out.println("Time: "+tnow);
            System.out.println("Transaction: "+ controller.pay(AMOUNT,new CreditCardInformationDTO()));
            System.out.println("-----End receipt-----");
            
      
            System.out.println("Inspection for the vehicle: " + controller.inspectVehicle());
            
            
            controller.enterResultOfInspection("Pass");
            
            controller.printResult();
            controller.openGarage();
            controller.closeGarage();
        }catch (OperationFailedException ex) {
            ex.printStackTrace();
        }catch (InspectionNotFoundException ex) {
           ex.printStackTrace();
        } 
    } 
               
                
        
    
    
    
    
}
