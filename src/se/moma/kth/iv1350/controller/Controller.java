package se.moma.kth.iv1350.controller;

import se.moma.kth.iv1350.db.VehicleRegistry;
import se.moma.kth.iv1350.model.CreditCardInformation;
import se.moma.kth.iv1350.startup.CustomerQueue;
import se.moma.kth.iv1350.startup.Garage;
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
    
   
    private PaymentAuthorizationRequest request = null;
    private Vehicle vehicle = null;
    
    
    /**
     * Skapar en ny instans. 
     * 
     */
    public Controller() {
      
    }
    
    
    /**
     * Skapar en ny fordonsbesiktning.
     * @param customerQueue Instans av klassen <code>CustomerQueue</code>
     * som hjälper till att hålla reda på turodning för kunder.
     * @param garage Instans av klassen <code>Garage</code> som kontrollerar 
     * garaget.
     */
    public void inspectNewVehicle(CustomerQueue customerQueue,Garage garage) {
     customerQueue.nextCustomer();
     garage.openGarage();
    } 
    
    /**
     * Stänger garaget.
     * @param garage Instans av klassen <code>Garage</code> som kontrollerar
     * garaget.
     */
    public void closeDoor(Garage garage) {
        garage.closeGarage();    
    }
    
    /**
     * Försöker hitta fordonets registreringsnummer.
     * @param registrationNumber Är fordonets registreringsnummer och används 
     * för hitta fordonet i fordonsregistret. 
     *
     * @return Kostnaden för inspektion av fordonet.
     */
    public int registerNumber(int registrationNumber) {
        VehicleRegistry vehicleRegistry = new VehicleRegistry();
        int cost = 0;
        for(int index = 0; index < vehicleRegistry.sizeOfVehicleRegistry(); index++) {
            if((vehicleRegistry.getVehicle(index).getVehicleNumber()) == registrationNumber) {
                vehicle = vehicleRegistry.getVehicle(index);
                cost = vehicle.getVehicleInspectionCost();
            } 
        }
        return cost;
    } 
    /**
     * Används för att betala för en besiktning.
     * @param amount Beloppet som ska betalas.
     * @param creditCard Är en instans av klassen <code>CreditCardInformation</code>
     * och används för att göra en kreditkortsbetalning.
     * @return Kvitto på betalningen.
     */
    public Receipt pay(int amount, CreditCardInformation creditCard) {
        Receipt receipt = null;
        request = new PaymentAuthorizationRequest(amount,creditCard);
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
        if(vehicle.getVehicleInspection() != null)
            inspection = vehicle.getVehicleInspection();
        return inspection;
    } 
    
    
   /**
    * Skriver resultatet vid inspektion av besiktning.
    * @param result Textsträng som visar "pass" eller "fail" på en fordonsbesiktning.
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
    
    
}
    
