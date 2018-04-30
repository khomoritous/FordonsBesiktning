/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.moma.kth.iv1350.model.external;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import se.moma.kth.iv1350.model.Customer;

/**
 *
 * @author monde
 */
public class CustomerQueueTest {
    
    private List<Customer> customerList = null;
    CustomerQueue customerQueue = null;
    private static final int CUSTOMER_QUEUE_NUMBER = 1;
    private static final int CUSTOMER_QUEUE_INDEX = 0;
    private ByteArrayOutputStream outContent = null;
    private String expResult = null;
    private String result = null;
    
    
    @Before
    public void setUp() {
        customerList = new ArrayList<>();
        customerList.add(new Customer(CUSTOMER_QUEUE_NUMBER));
    }
    @After
    public void cleanUp() {
        outContent = null;
    }
 
    @Test
    public void testCustomerTakeQueueNumber() {
        assertFalse(customerList.isEmpty());
    }

    @Test
    public void testNextCustomer() {
     
       outContent = new ByteArrayOutputStream();
       System.setOut(new PrintStream(outContent));
       customerQueue = new CustomerQueue();
       customerQueue.customerTakeQueueNumber();
       customerQueue.nextCustomer();
       
       expResult = "Next customer number:  " + customerList.get(CUSTOMER_QUEUE_INDEX).getCustomerNumber();
       result = outContent.toString();
       assertTrue("No customer with a number!", result.contains(expResult));
    }
}
