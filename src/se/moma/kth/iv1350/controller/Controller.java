package se.moma.kth.iv1350.controller;

import se.moma.kth.iv1350.dbhandler.VehicleRegistry;
import se.moma.kth.iv1350.model.CreditCardInformationDTO;
import se.moma.kth.iv1350.model.external.Garage;
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
     *  Hitta <code>Vehicle</code> registreringsnummer.
     * @param registrationNumber Är <code>Vehicle</code> registreringsnummer och används 
     * för hitta <code>Vehicle</code> i <code>VehicleRegistry</code>. 
     * @return Kostnaden för <code>Inspection</code> av <code>Vehicle</code>.
     */
    public int registerNumber(int registrationNumber) {
        int cost = 0;
        cost = matches(registrationNumber, cost);
        return cost;
    } 

    private int matches(int registrationNumber, int cost) {
        for(int index = 0; index < vehicleRegistry.sizeOfVehicleRegistry(); index++) {
            if(vehicleRegistry.getVehicle(index).getVehicleNumber() == registrationNumber && vehicleRegistry.getVehicle(index).getVehicleInspection() != null) {
                vehicle = vehicleRegistry.getVehicle(index);
                cost = vehicle.getVehicleInspectionCost();
            } 
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
   
   private void customerQueueHandling() {
        garage.customerTakeNumber();
        garage.nextCustomerInQueue();
   }
   
   
    
}
    
