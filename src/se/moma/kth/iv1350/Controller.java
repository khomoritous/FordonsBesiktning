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
    private PaymentAuthorizationRequest request;//instansvariabel
   
    
    
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
    
