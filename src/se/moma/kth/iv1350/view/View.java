/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.moma.kth.iv1350.view;

import java.time.LocalDate;
import java.time.LocalTime;
import se.moma.kth.iv1350.controller.Controller;
import se.moma.kth.iv1350.model.CreditCardInformationDTO;

/**
 * Skapar ett användargränssnitt.
 * @author monde
 */
public class View {
    
   
  
    Controller controller = null;
    LocalDate dnow = LocalDate.now();
    LocalTime tnow = LocalTime.now();
    
    private static final String VENDOR = "VISA";
    private static final int CARD_NUMBER = 2334;
    private final LocalDate validDate = LocalDate.now();
    private static final  String CARD_OWNER = "Jan";
    private static final int CCV = 222;
    
   
    
    
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
    public void sampleExecution() {
        int cost = 0;
       
        controller.inspectNewVehicle();
        controller.closeGarage();
        
        if((cost = controller.registerNumber(10)) == 0) {
            System.out.println("No vehicle with that number.");
           }else {
             System.out.println("Inspection cost for Vehicle: "+ cost);
        }
        System.out.println("-----Begin receipt-----");
        System.out.println("Transaction: "+ controller.pay(cost, new CreditCardInformationDTO(VENDOR, CARD_NUMBER,validDate,CARD_OWNER,CCV)));
        System.out.println("Date: "+dnow);
        System.out.println("Time: "+tnow);
      
        System.out.println("-----End receipt-----");

        System.out.println("Inspection for the vehicle: " + controller.inspectVehicle());

        controller.enterResultOfInspection("PASS");

        controller.printResult();
        controller.openGarage();
        controller.closeGarage();
        
    }
    
    
    
}
