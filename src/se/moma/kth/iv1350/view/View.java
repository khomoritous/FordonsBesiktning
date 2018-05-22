/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.moma.kth.iv1350.view;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import se.moma.kth.iv1350.controller.Controller;
import se.moma.kth.iv1350.model.CreditCardInformationDTO;
import se.moma.kth.iv1350.model.exception.InspectionException;
import se.moma.kth.iv1350.util.ErrorMessageHandler;
import se.moma.kth.iv1350.util.LogHandler;

/**
 * Skapar ett användargränssnitt.
 * @author monde
 */
public class View {
    
   
  
    private Controller controller = null;
    private LocalDate dnow = LocalDate.now();
    private LocalTime tnow = LocalTime.now();
    private ErrorMessageHandler errorMsgHandler = null;
    private LogHandler logger = null;
    
    

    private final static int VEHICLE_NUMBER = 10;
    private final static int VEHICLE_NUMBER_WITH_NO_INSPECTION = 20;

    private static final String VENDOR = "VISA";
    private static final int CARD_NUMBER = 2334;
    private final LocalDate validDate = LocalDate.now();
    private static final  String CARD_OWNER = "Jan";
    private static final int CCV = 222;
    
    private static final int EXIT_STATUS = 1;
    

   
    
    
    /**
     * Skapar en ny instans.
     * @param controller En instans av <code>Controller</code>.
     */
    public View(Controller controller)  {
        try {
            this.controller = controller;
            errorMsgHandler = new ErrorMessageHandler();
            logger = new LogHandler();
        } catch (IOException ex) {
            handleExecution("Cannot write to logfile! Exiting...");
            System.exit(EXIT_STATUS);
        }
    }
    
    /**
     * Startar en ny fordonsbesiktning.
     */
    public void sampleExecution()  {
        int cost = 0;
        
       try {
                controller.inspectNewVehicle();
                controller.closeGarage();
            
       
                if((cost = controller.registerNumber(VEHICLE_NUMBER)) == 0) {
                    System.out.println("No vehicle with that number.");
                }else {
                    System.out.println("Inspection cost for Vehicle: "+ cost);
                }

                System.out.println("-----Begin receipt-----");
                System.out.println("Transaction: "+ controller.pay(cost, new CreditCardInformationDTO(VENDOR, CARD_NUMBER,validDate,CARD_OWNER,CCV)));
                System.out.println("Date: "+dnow);
                System.out.println("Time: "+tnow);
                System.out.println("-----End receipt-----");

                System.out.println("Inspection for the vehicle: " + controller.inspectVehicle(VEHICLE_NUMBER));
        

                controller.enterResultOfInspection(VEHICLE_NUMBER,"PASS");

                controller.printResult(VEHICLE_NUMBER);
                controller.openGarage();
                controller.closeGarage();
        } catch (InspectionException iex) {
           handleExecution("No inspections found for vehicle number " + iex.getVehicleWithNoInspections().getVehicleNumber());
           logger.logException(iex);
        } catch(Exception ex) {
            handleExecution(ex.getMessage());
            logger.logException(ex);
        }
        
    }
    
    private void handleExecution(String uiMsg) {
        errorMsgHandler.showErrorMsg(uiMsg);
    }
    
    
    
}
