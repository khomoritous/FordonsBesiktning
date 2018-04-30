/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.moma.kth.iv1350.model;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author monde
 */
public class CustomerTest {
    
    private static final int CUSTOMER_NUMBER = 1;
    Customer customer = null;
    

    @Test
    public void testGetCustomerNumber() {
        customer = new Customer(CUSTOMER_NUMBER);
        customer.getCustomerNumber();
        assertEquals(CUSTOMER_NUMBER ,customer.getCustomerNumber());
    }
    
}
