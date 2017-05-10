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
       
       
       
    }
}
       

       
     
   

