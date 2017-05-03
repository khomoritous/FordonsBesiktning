/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.moma.kth.iv1350;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author monde
 */
class CustomerQueue {
    
    private int queueNumber = 1;//instansvariabel för nummerlapp.
    private int queue = 0; //instansvariabler för könummer.
   
    
    List<Customer> customerList; //instansvariable av typ lista.
    /**
     * Skapar en instans av typ <code>CustomerQueue</code> bestående av en 
     * lista.
     */
    public CustomerQueue() {
       customerList = new ArrayList<>();
    }
    /**
     * Lägger till en kund av typ <code>Customer</code> 
     * i listan skapad av <code>CustomerQueue</code>. 
     */
    public void customerTakeQueueNumber() {
        //new Customer(queueNumber++);
        customerList.add(new Customer(queueNumber++));
        //queueNumber++;
    }
    /**
     * Skriver ut nästa könummer till en display och uppdaterar kön.
     */
    public void nextCustomer() {
        System.out.println(customerList.get(queue++).getCustomer());
        //queue++;
    }
}
