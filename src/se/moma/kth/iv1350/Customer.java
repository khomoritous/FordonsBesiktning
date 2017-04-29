/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.moma.kth.iv1350;

/**
 *
 * @author monde
 */
class Customer {
    
    private final int customerQueueNumber;
    /**
     * Skapar en instans av klassen <code>Customer</code>
     * @param customerQueueNumber En int som används för att tilldela klassen
     * <code>Customer</code> ett könummer. 
     */
    public Customer(int customerQueueNumber) {
       this.customerQueueNumber = customerQueueNumber;
       
    }
    /**
     * Metod av typ getter.
     * @return Returnerar <code>customerQueueNumber</code> som tilldelas
     * instanser av klass <code>Customer</code>.
     */
    public int getCustomer() {
        return customerQueueNumber;
    }
    
    
}
