/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.moma.kth.iv1350;

/**
 * Skapar en kund.
 * @author monde
 */
class Customer {
    
    private final int customerQueueNumber; //instansvariabel
    
    /**
     * Skapar en ny instans.
     * @param customerQueueNumber En int som används för att tilldela en ny instans 
     * ett könummer.
     * 
     */
    public Customer(int customerQueueNumber) {
       this.customerQueueNumber = customerQueueNumber;
       
    }
    
    /**
     * Metod av typ getter.
     * @return Returnerar kundens könummer.
     * 
     */
    public int getCustomerNumber() {
        return customerQueueNumber;
    }
    
    
}
