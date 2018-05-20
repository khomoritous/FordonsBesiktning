package se.moma.kth.iv1350.controller;

import se.moma.kth.iv1350.dbhandler.VehicleRegistry;
import se.moma.kth.iv1350.dbhandler.exception.VehicleRegistryException;
import se.moma.kth.iv1350.model.CreditCardInformationDTO;
import se.moma.kth.iv1350.model.external.Garage;
import se.moma.kth.iv1350.model.Inspection;
import se.moma.kth.iv1350.model.PaymentAuthorizationRequest;
import se.moma.kth.iv1350.model.Receipt;
import se.moma.kth.iv1350.model.Vehicle;
import se.moma.kth.iv1350.model.exception.InspectionException;
import se.moma.kth.iv1350.util.exception.OperationFailedException;

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
    
    
    /**
     * Skapar ny instans.
     * @param garage Instans av <code>Garage</code>.
     * @param vehicleRegistry Instans av <code>VehicleRegistry</code>.
     */
    public Controller(Garage garage, VehicleRegistry vehicleRegistry) {
       this.vehicleRegistry = vehicleRegistry;
       this.garage = garage;
    }
    
    
    /**
     *  Ny besiktning.
     */
    public void inspectNewVehicle() {
        customerQueueHandling();
        garage.openGarage();
    } 

    /**
     * Stänger <code>Garage</code>.
     */
    public void closeGarage() {
        garage.closeGarage();    
    }
    
    /**
     * Hämta kostnaden för <code>Inspection</code> för <code>Vehicle</code>.
     * @param registrationNumber Är <code>Vehicle</code> registreringsnummer och används 
     * för hitta <code>Vehicle</code> i <code>VehicleRegistry</code>. 
     * @return Kostnaden för <code>Inspection</code> av <code>Vehicle</code>.
     */
    public int registerNumber(int registrationNumber) throws InspectionException {
        int cost = 0;
        if(vehicleRegistry.isVehiclePresent(registrationNumber)) {
            cost = vehicleRegistry.findVehicleInspectionCost(registrationNumber);
        }
        return cost;
    } 

  
    
    /**
     * Används för att betala för en besiktning.
     * @param amount Beloppet som betalas.
     * @param creditCard Är en instans av <code>CreditCardInformationDTO</code>
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
     * @return Instans av <code>Inspection</code> som visar vad på <code>Vehicle</code>
     * som behöver besiktas.
     */
    public Inspection inspectVehicle(int registrationNumber) throws InspectionException {
        return vehicleRegistry.findVehicleInspection(registrationNumber);
    } 
    
   /**
    * Skriver resultatet vid inspektion av besiktning.
    * @param result Textsträng som visar resultat på en fordonsbesiktning.
    */
   public void enterResultOfInspection(int registrationNumber,String result) {
       vehicleRegistry.setVehicleInspectionResult(registrationNumber, result);
   }
    /**
     * GÖr en utskrift på resultatet vid fordonsbesiktningen.
     */
   public void printResult(int registrationNumber) {
        vehicleRegistry.printVehicleInspectionResult(registrationNumber);
   }
   
   /**
    * Öppnar garaget.
    */
   public void openGarage() {
       garage.openGarage();
   }
   
   private void customerQueueHandling() {
        garage.customerTakeNumber();
        garage.nextCustomerInQueue();
   }
   
   
    
}
    
