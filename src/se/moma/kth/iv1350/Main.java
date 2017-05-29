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

            GarageDoor garageDoor = new GarageDoor();
            Garage garage = new Garage(garageDoor);
            CustomerQueue customerQueue = new CustomerQueue();
            customerQueue.customerTakeQueueNumber();
            customerQueue.nextCustomer();
            garage.openGarage();
            garage.closeGarage(); 

            
      
            
            Vehicle vehicle = new Vehicle(10,new Inspection(100));

            Controller controller = new Controller(vehicle);

            System.out.println("Inspection cost for Vehicle: "+ controller.registerNumber(10));

            System.out.println("Receipt from transaction: "+ controller.pay(100,new CreditCardInformation()));

            System.out.println("Inspection for the vehicle: " + controller.inspectVehicle());

            controller.enterResultOfInspection("Pass");

            controller.printResult();
        
      
            garage.openGarage();
            garage.closeGarage();
       
   }
}
       

       
     
   

