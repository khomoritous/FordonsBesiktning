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
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import se.moma.kth.iv1350.model.Customer;

/**
 *
 * @author monde
 */
public class GarageTest {
    
   private ByteArrayOutputStream outContent = null;
   private Garage garage = null;
   //private GarageDoor garageDoor = null;
   private String result = null;
   private String expResult = null;
   private static final int CUSTOMER_NUMBER = 1;
   
    
    @Before
    public void setUp() {
        outContent =  new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        //garageDoor = new GarageDoor();
        garage = new Garage(new GarageDoor(),new CustomerQueue());
    }
    
    @Test
    public void testCloseGarage() {
        garage.closeGarage();
        
        result = outContent.toString();
        expResult = "Closing garage door....";
        
        assertTrue("Garage not closing", result.contains(expResult));
    }

    @Test
    public void testOpenGarage() {
        garage.openGarage();
        
        result = outContent.toString();
        expResult = "Opening garage door....";
        
        assertTrue("Garage not closing", result.contains(expResult));
    }

    @Test
    public void testCustomerTakeNumber() {
        
        
        
    }

    @Test
    public void testNextCustomerInQueue() {
    }
    
}
