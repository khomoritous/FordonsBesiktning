package se.moma.kth.iv1350.model.external;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Skapar ett garage.
 * @author monde
 */
public class Garage {
    
   
    private GarageDoor garageDoor = null; 
    private CustomerQueue customerQueue = null; 
    
    /**
     * Skapar en ny instans.
     * @param garageDoor Är en instans av <code>GarageDoor</code> som
     * hjälper till att öppna och stänga <code>Garage</code>.
     */
    public Garage(GarageDoor garageDoor) {
        this.garageDoor = garageDoor;
        customerQueue = new CustomerQueue();
    }
    
    /**
     * Stänger <code>Garage</code>.
     */
    public void closeGarage() {
        garageDoor.closeDoor();
    }
    /**
     * Öppnar <code>Garage</code>.
     */
    public void openGarage() {
        garageDoor.openDoor();
    }
    /**
     * <code>Customer</code> tar en nummerlapp.
     */
    public void customerTakeNumber() {
        customerQueue.customerTakeQueueNumber();
    }
    /**
     * Nästa <code>Customer</code> i <code>CustomerQueue</code>.
     */
    public void nextCustomerInQueue() {
        customerQueue.nextCustomer();
    }
}
