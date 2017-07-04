package se.moma.kth.iv1350.controller;

import se.moma.kth.iv1350.dbhandler.VehicleRegistry;
import se.moma.kth.iv1350.model.CreditCardInformationDTO;
import se.moma.kth.iv1350.model.external.CustomerQueue;
import se.moma.kth.iv1350.model.external.Garage;
import se.moma.kth.iv1350.model.external.GarageDoor;
import se.moma.kth.iv1350.model.Inspection;
import se.moma.kth.iv1350.model.PaymentAuthorizationRequest;
import se.moma.kth.iv1350.model.Receipt;
import se.moma.kth.iv1350.model.Vehicle;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Skapar en controller.
 * @author monde
 */
public class Controller {
    
   
    
    private Vehicle vehicle = null;
    private VehicleRegistry vehicleRegistry = null;
    private Garage garage = null;
    private GarageDoor garageDoor = null;
    private CustomerQueue customerQueue = null;
    
    
    /**
     * Skapar en ny instans. 
     */
    public Controller() {
       vehicleRegistry = new VehicleRegistry();
       garageDoor = new GarageDoor();
       garage = new Garage(garageDoor);
       

    }
    
    
    /**
     * Sätter igång en ny fordonsbesiktning.
     */
    public void inspectNewVehicle() {
        customerQueueHandling();
        garage.openGarage();
    } 

    private void customerQueueHandling() {
        garage.customerTakeNumber();
        garage.nextCustomerInQueue();
    }
    
    /**
     * Stänger garaget.
     */
    public void closeGarage() {
        garage.closeGarage();    
    }
    
    /**
     * Försöker hitta fordonets registreringsnummer.
     * @param registrationNumber Är fordonets registreringsnummer och används 
     * för hitta fordonet i fordonsregistret. 
     * @return Kostnaden för inspektion av fordonet.
     * @throws se.moma.kth.iv1350.model.exceptions.IllegalLicenseNumber
     */
    public int registerNumber(int registrationNumber) {
        int cost = 0;
        cost = matches(registrationNumber, cost);
        return cost;
    } 

    private int matches(int registrationNumber, int cost) {
        for(int index = 0; index < vehicleRegistry.sizeOfVehicleRegistry(); index++) {
            if(vehicleRegistry.findVehicleByNo(index, registrationNumber)) {
                   vehicle = vehicleRegistry.getVehicle(index); 
                   return vehicleRegistry.findVehicleInspection(vehicle);
            }
        }            
        return cost;
    }
    
    /**
     * Används för att betala för en besiktning.
     * @param amount Beloppet som betalas.
     * @param creditCard Är en instans av klassen <code>CreditCardInformationDTO</code>
     * och används för att göra en kreditkortsbetalning.
     * @return Kvitto på betalningen.
     */
    public Receipt pay(int amount, CreditCardInformationDTO creditCard) {
        Receipt receipt = null;
        PaymentAuthorizationRequest request = new PaymentAuthorizationRequest(amount,creditCard);
        if(request.isApproved()) {
          receipt = request.getCustomerReceipt();
        }
        return receipt;
    }
    
    /**
     * Används för att besikta fordonet. 
     * @return Instans av klassen <code>Inspection</code> som visar vad på fordonet
     * som behöver besiktas.
     */
    public Inspection inspectVehicle() {
        Inspection inspection = null;
        if(vehicle.getVehicleInspection() != null) {
            inspection = vehicle.getVehicleInspection();
        }
        return inspection;
    } 
    
   /**
    * Skriver resultatet vid inspektion av besiktning.
    * @param result Textsträng som visar resultat på en fordonsbesiktning.
    */
   public void enterResultOfInspection(String result) {
        vehicle.resultOfInspection(result);
   }
    /**
     * GÖr en utskrift på resultatet vid fordonsbesiktningen.
     */
   public void printResult() {
        vehicle.printVehicleInspectionResult();
   }
   /**
    * Öppnar garaget.
    */
   public void openGarage() {
       garage.openGarage();
   }
   
   
    
}
    
