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
    
   
    private GarageDoor garageDoor = null; //instansvariabel
    private CustomerQueue customerQueue = null;
    
    /**
     * Skapar en ny instans.
     * @param garageDoor Är en instans av klassen <code>GarageDoor</code> som
     * hjälper till att öppna och stänga garaget.
     */
    public Garage(GarageDoor garageDoor) {
        this.garageDoor = garageDoor;
        customerQueue = new CustomerQueue();
    }
    
    /**
     * Stänger garaget.
     */
    public void closeGarage() {
        garageDoor.closeDoor();
    }
    /**
     * Oppnar garaget.
     */
    public void openGarage() {
        garageDoor.openDoor();
    }
    /**
     * Kund tar en nummerlapp.
     */
    public void customerTakeNumber() {
        customerQueue.customerTakeQueueNumber();
    }
    /**
     * Trycker fram nästa kund i kön.
     */
    public void nextCustomerInQueue() {
        customerQueue.nextCustomer();
    }
}
