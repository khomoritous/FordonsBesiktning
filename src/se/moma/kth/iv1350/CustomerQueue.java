/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.moma.kth.iv1350;

import java.util.ArrayList;
import java.util.List;

/**
 * Skapar en kö för kunder. 
 * @author monde
 */
class CustomerQueue {
    
    private int queueNumber = 1;//instansvariabel för nummerlapp.
    private int queue = 0; //instansvariabler för könummer.
   
    
    List<Customer> customerList; //instansvariabel av typ lista.
    /**
     * Skapar en ny instans.
     */
    public CustomerQueue() {
       customerList = new ArrayList<>();
    }
    
    /**
     * Lägger till en kund till kön.
     */
    public void customerTakeQueueNumber() {
        customerList.add(new Customer(queueNumber++));
    }
    
    /**
     * Skriver ut nästa könummer för kund till en display.
     */
    public void nextCustomer() {
        System.out.println("Next customer number:  "+customerList.get(queue++).getCustomerNumber());
        
    }
}
