/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.moma.kth.iv1350.view;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import se.moma.kth.iv1350.controller.Controller;
import se.moma.kth.iv1350.model.CreditCardInformationDTO;
import se.moma.kth.iv1350.model.external.CustomerQueue;
import se.moma.kth.iv1350.model.external.Garage;
import se.moma.kth.iv1350.model.external.GarageDoor;

/**
 * Skapar ett användargränssnitt.
 * @author monde
 */
public class View {
    
   
   // Garage garage = null;
    CustomerQueue customerQueue = null;
    Controller controller = null;
    LocalDate dnow = LocalDate.now();
    LocalTime tnow = LocalTime.now();
    
    
    /**
     * Skapar en ny instans.
     */
    public View()  {
       // garage = new Garage(new GarageDoor());
        //customerQueue = new CustomerQueue();
        controller = new Controller();
        
    }
    
    /**
     * Startar en ny fordonsbesiktning.
     */
    public void sampleExecution() {
        int cost;
       
        controller.inspectNewVehicle();
        controller.closeGarage();
        
        if((cost = controller.registerNumber(10)) == 0) {
            System.out.println("No vehicle with that number.");
           }else {
             System.out.println("Inspection cost for Vehicle: "+ cost);
        }
        System.out.println("-----Begin receipt-----");
        System.out.println("Date: "+dnow);
        System.out.println("Time: "+tnow);
        System.out.println("Transaction: "+ controller.pay(100,new CreditCardInformationDTO()));
        System.out.println("-----End receipt-----");

        System.out.println("Inspection for the vehicle: " + controller.inspectVehicle());

        controller.enterResultOfInspection("Pass");

        controller.printResult();
        controller.openGarage();
        controller.closeGarage();
        
    }
    
    
    
}
