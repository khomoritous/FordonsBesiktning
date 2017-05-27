/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.moma.kth.iv1350;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author monde
 */
public class ExternalPaymentAuthorizationSystemTest {
    
    public ExternalPaymentAuthorizationSystemTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testIsValid() {
        System.out.println("isValid");
        ExternalPaymentAuthorizationSystem instance = null;
        boolean expResult = false;
        boolean result = instance.isValid();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetReceipt() {
        System.out.println("getReceipt");
        int amount = 0;
        ExternalPaymentAuthorizationSystem instance = null;
        Receipt expResult = null;
        Receipt result = instance.getReceipt(amount);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
