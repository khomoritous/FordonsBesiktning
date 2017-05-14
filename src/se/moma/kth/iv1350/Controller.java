package se.moma.kth.iv1350;

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
    
    private CustomerQueue customerQueue;//instansvariabel
    private Garage garage; //instansvariabel
    private Vehicle vehicle; //instansvariabel
   
    
    
    /**
     * Skapar en ny instans. 
     * @param vehicle Är en instans av klassen <code>Vehicle</code> som hjälper
     * till att hämta fordon för besiktning.
     */
    public Controller(Vehicle vehicle) {
      this.vehicle = vehicle;
    }
    
    
    /**
     * Skapar en ny fordonsbesiktning.
     */
    public void inspectNewVehicle() {
     customerQueue.nextCustomer();
     garage.openGarage();
    } 
    
    /**
     * Stänger garaget.
     */
    public void closeDoor() {
        garage.closeGarage();    
    }
    
    /**
     * Försöker hitta fordonets registreringsnummer.
     * @param registrationNumber Är fordonets registreringsnummer och används 
     * för hitta fordonet. 
     *
     * @return Kostnaden för inspektion av fordonet.
     */
    public int registerNumber(int registrationNumber) {
        int cost = 0;
        if((vehicle.getVehicle().getVehicleNumber() == registrationNumber) && ((vehicle.getVehicle().getVehicleInspection()) != null)) {
            cost = vehicle.getVehicleInspectionCost();
        } else {
            System.out.println("No vehicle with that number.");
        }
        return cost;
    } 
    
   /* public Receipt pay(CreditCardInformation creditCard) {
        Receipt receipt = null;
        PaymentAuthorizationRequest payRequest = new PaymentAuthorizationRequest(10,creditCard);
        if(payRequest.isApproved()) {
          receipt = payRequest.getCustomerReceipt();
        }
        return receipt;
    }*/
    
   /* public Inspection inspectVehicle() {
      return vehicle.getVehicleInspection();
    } */
    
   /* public void enterResultOfInspection(String result) {
        vehicle.resultOfInspection(result);
    }*/
    
  /*  public void printResult(String result) {
        ExternalPrinter printer = new ExternalPrinter();
        printer.print(result);
        
    }*/
    
    
}
    
