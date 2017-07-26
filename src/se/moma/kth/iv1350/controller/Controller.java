package se.moma.kth.iv1350.controller;

import java.util.ArrayList;
import java.util.List;
import se.moma.kth.iv1350.controller.exceptions.OperationFailedException;
import se.moma.kth.iv1350.dbhandler.VehicleRegistry;
import se.moma.kth.iv1350.dbhandler.exceptions.VehicleRegistryException;
import se.moma.kth.iv1350.model.CreditCardInformationDTO;
import se.moma.kth.iv1350.model.external.Garage;
import se.moma.kth.iv1350.model.external.GarageDoor;
import se.moma.kth.iv1350.model.Inspection;
import se.moma.kth.iv1350.model.PaymentAuthorizationRequest;
import se.moma.kth.iv1350.model.Receipt;
import se.moma.kth.iv1350.model.Vehicle;
import se.moma.kth.iv1350.model.exceptions.InspectionNotFoundException;
import moma.se.kth.iv1350.util.VehicleObserver;


/**
 * Skapar en controller.
 * @author monde
 */
public class Controller {
    
   
    
    private Vehicle vehicle = null;
    private VehicleRegistry vehicleRegistry = null;
    private Garage garage = null;
    private GarageDoor garageDoor = null;
    private List<VehicleObserver> vehicleObservers = new ArrayList<>();
    
  
    
    
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
     * Försöker hitta <code>Vehicle</code> registreringsnummer.
     * @param registrationNumber Är <code>Vehicle</code> registreringsnummer och används 
     * för hitta <code>Vehicle</code> i <code>VehicleRegistry</code>. 
     * @return Kostnaden för <code>Inspection</code> av fordonet.
     * @throws se.moma.kth.iv1350.model.exceptions.InspectionNotFoundException 
     * Kastas då inga instanser av <code>Inspection</code> hittas.
     * @throws se.moma.kth.iv1350.controller.exceptions.OperationFailedException 
     * Kastas vid nekad åtkomst till <code>VehicleRegistry</code>.
     */
    public int registerNumber(int registrationNumber) throws InspectionNotFoundException, OperationFailedException {
        try {
            int cost = 0;
           
            return getCost(registrationNumber, cost);
        
        } catch(VehicleRegistryException vre) {
            throw new OperationFailedException("Could not access vehicle",vre);
        }
    }
        

    private int getCost(int registrationNumber, int cost) throws InspectionNotFoundException,OperationFailedException {
        for(int index = 0; index < vehicleRegistry.size(); index++) {
            if(vehicleRegistry.findVehicleByNo(index, registrationNumber)) {
                   vehicle = vehicleRegistry.getVehicle(index); 
                   return vehicleRegistry.findVehicleInspection(vehicle);
            }
        } 
       return cost;
    }
    
    /**
     * Används för att betala för en <code>Inspection</code>.
     * @param amount Beloppet som betalas.
     * @param creditCard Är en <code>CreditCardInformationDTO</code>
     * och används för att göra en kreditkortsbetalning.
     * @return <code>Receipt</code> på betalningen.
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
     * Används för att besikta <code>Vehicle</code>. 
     * @return <code>Inspection</code> som visar vad på <code>Vehicle</code>
     * som behöver besiktas.
     * @throws se.moma.kth.iv1350.model.exceptions.InspectionNotFoundException Kastas 
     * då inga <code>Inspection</code> hittas.
     */
    public Inspection inspectVehicle() throws InspectionNotFoundException {
        Inspection inspection = null;
        if(vehicle.getVehicleInspection() != null) {
            inspection = vehicle.getVehicleInspection();
            inspection.addVehicleObservers(vehicleObservers);
        }
        return inspection;
    } 
    
   /**
    * Skriver resultatet av en <code>Inspection</code>.
    * @param result Textsträng som visar resultat på en <code>Inspection</code>.
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
   
   /**
    * @param obs <code>VehiclObserver</code> som läggs till <code>vehicleObservers</code>.
    */
   public void addVehicleObserver(VehicleObserver obs) {
       vehicleObservers.add(obs);
   }
   
   
    
}
    
