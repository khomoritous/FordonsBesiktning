/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.moma.kth.iv1350.view;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import moma.se.kth.iv1350.util.ErrorMessageHandler;
import moma.se.kth.iv1350.util.LogHandler;
import se.moma.kth.iv1350.controller.Controller;
import se.moma.kth.iv1350.controller.exceptions.OperationFailedException;
import se.moma.kth.iv1350.model.CreditCardInformationDTO;
import se.moma.kth.iv1350.model.exceptions.InspectionNotFoundException;

/**
 * Skapar ett användargränssnitt.
 * @author monde
 */
public class View {
    
   
   
    private Controller controller = null;
    
    private LocalDateTime now = LocalDateTime.now();
    private DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM);
    private final static int VEHICLE_NUMBER = 10;
    private final static int VEHICLE_NUMBER_WITH_NO_INSPECTION = 15;
    private ErrorMessageHandler errorMsgHandler = new ErrorMessageHandler();
    
    private final static int AMOUNT = 100;
    private LogHandler logger = null;
    
    
    
    /**
     * Skapar en ny instans.
     * @throws java.io.IOException Kastas då det inte går att 
     * skriva på in- och utströmmar.
     */
    public View() throws IOException  {
       controller = new Controller();
       controller.addVehicleObserver(new InspectionStatsView());
       logger = new LogHandler();
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
           
            
            System.out.println("Date/Time: "+ now.format(formatter));
            System.out.println("Transaction: "+ controller.pay(AMOUNT,new CreditCardInformationDTO()));
            System.out.println("-----End receipt-----");
            
      
            System.out.println("Inspection for the vehicle: " + controller.inspectVehicle());
            
            
            controller.enterResultOfInspection("Pass");
            
            controller.printResult();
            
            controller.openGarage();
            controller.closeGarage();
        }catch (OperationFailedException ofe) {
            handleException("Access to VehicleRegistry denied. ",ofe);
        }catch (InspectionNotFoundException ife) {
            handleException("Inspection not found ", ife);
        }
         
       
    } 
    
    private void handleException(String uiMsg, Exception exc) {
        errorMsgHandler.showErrorMsg(uiMsg);
        logger.logException(exc);
    }
               
                
        
    
    
    
    
}
