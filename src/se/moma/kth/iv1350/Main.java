package se.moma.kth.iv1350;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author monde
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       /*GarageDoor garageDoor = new GarageDoor();
       Garage garage = new Garage(garageDoor);
       
       CustomerQueue customerQueue = new CustomerQueue();
       customerQueue.customerTakeQueueNumber();
       customerQueue.customerTakeQueueNumber();
       
       Inspection inspection = new Inspection(200);
       Vehicle vehicle = new Vehicle(12, inspection);
       
      
       Controller controller = new Controller(garage, customerQueue, vehicle);
       controller.inspectNewVehicle();
       controller.closeDoor();*/
       
       //System.out.println(controller.registerNumber(12));
       //PaymentAuthorizationRequest req = new PaymentAuthorizationRequest(10,new CreditCardInformation());
       CreditCardInformation creditCard = new CreditCardInformation();
       Controller controller = new Controller();
       System.out.println(controller.pay(creditCard));
       
    }
}
       

       
     
   

