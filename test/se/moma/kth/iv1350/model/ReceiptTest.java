/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.moma.kth.iv1350.model;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author monde
 */
public class ReceiptTest {
    
     private Receipt receipt = null;
     private static final int AMOUNT = 100;
    
    @Before
    public void setUp() {
        receipt = new Receipt(AMOUNT);
    }

    @Test
    public void testGetReceipt() {
        assertNotNull("No receipt created!",receipt.getReceipt());
    }

    @Test
    public void testToString() {
        String expResult = "You have payed: " + AMOUNT;
        assertEquals(expResult, receipt.toString());
    }
    
}
