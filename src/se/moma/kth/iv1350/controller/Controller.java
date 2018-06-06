package se.moma.kth.iv1350.controller;

import java.util.ArrayList;
import java.util.List;
import se.moma.kth.iv1350.dbhandler.VehicleRegistry;
import se.moma.kth.iv1350.model.CreditCardInformationDTO;
import se.moma.kth.iv1350.model.external.Garage;
import se.moma.kth.iv1350.model.Inspection;
import se.moma.kth.iv1350.model.PaymentAuthorizationRequest;
import se.moma.kth.iv1350.model.Receipt;
import se.moma.kth.iv1350.model.exception.InspectionException;
import se.moma.kth.iv1350.model.interfaces.VehicleObserver;

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
    
    private List<VehicleObserver> vehicleObservers = new ArrayList<>();
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
     * Hämta kostnaden av <code>Inspection</code> för <code>Vehicle</code>.
     * @param registrationNumber Är <code>Vehicle</code> registreringsnummer och används 
     * för hitta <code>Vehicle</code> i <code>VehicleRegistry</code>. 
     * @return Kostnaden för <code>Inspection</code> av <code>Vehicle</code>.
     * @throws se.moma.kth.iv1350.model.exception.InspectionException Kastas då ingen <code>Inspection</code>
     * hittas för <code>Vehicle</code> med det registreringsnummret.
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
        PaymentAuthorizationRequest request = null;
        request = createPaymentRequest(amount, creditCard);
        if(request.isApproved()) {
          receipt = request.getCustomerReceipt();
        }
        return receipt;
    }
    
    /**
     * Används för att besikta <code>Vehicle</code>. 
     * @param registrationNumber Ett <code>Vehicle</code> registreringsnummer för 
     * att söka i <code>VehicleRegistry</code>.
     * @return Instans av <code>Inspection</code> som visar vad på <code>Vehicle</code>
     * som behöver besiktas.
     * @throws se.moma.kth.iv1350.model.exception.InspectionException Kastas då ingen <code>Inspection</code>
     * hittas.
     */ 
    public Inspection inspectVehicle(int registrationNumber) throws InspectionException {
        vehicleRegistry.findVehicleInspection(registrationNumber).addVehicleObservers(vehicleObservers);
        return vehicleRegistry.findVehicleInspection(registrationNumber);
    } 
    
   /**
    * Skriver resultatet vid en <code>Inspection</code> av <code>Vehicle</code>.
    * @param registrationNumber Används för att hitta <code>Vehicle</code> i 
    * <code>VehicleRegistry</code>.
    * @param result Textsträng som anger resultat på en <code>Inspection</code>
    * av <code>Vehicle</code>.
    * @throws se.moma.kth.iv1350.model.exception.InspectionException  Kastas
    * då ingen <code>Inspection</code> hittats för <code>Vehicle</code>.
    */
   public void enterResultOfInspection(int registrationNumber,String result) throws InspectionException {
       vehicleRegistry.setVehicleInspectionResult(registrationNumber, result);
   }
    
    /**
     * Gör en utskrift av resultatet vid fordonsbesiktningen.
     * @param registrationNumber <code>Vehicle</code> registreringsnummer.
     * @throws se.moma.kth.iv1350.model.exception.InspectionException Kastas
     * då ingen <code>Inspection</code> hittats för <code>Vehicle</code>.
     */
   public void printResult(int registrationNumber) throws InspectionException {
        vehicleRegistry.printVehicleInspectionResult(registrationNumber);
   }
   /**
    * Lägger till Observers till lista.
    * @param obs En instans av <code>VehicleObserver</code>.
    */
   public void addVehicleObservers(VehicleObserver obs) {
       vehicleObservers.add(obs);
   }
   
   /**
    * Öppnar <code>Garage</code>
    */
   public void openGarage() {
       garage.openGarage();
   }
   
   private void customerQueueHandling() {
        garage.customerTakeNumber();
        garage.nextCustomerInQueue();
   }
   
   private PaymentAuthorizationRequest createPaymentRequest(int amount, CreditCardInformationDTO creditCard) {
       return new PaymentAuthorizationRequest(amount, creditCard);
   }
    
}
    
