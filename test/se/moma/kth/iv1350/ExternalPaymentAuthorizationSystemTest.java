/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.moma.kth.iv1350;

import se.moma.kth.iv1350.model.PaymentAuthorizationRequest;
import se.moma.kth.iv1350.model.CreditCardInformationDTO;
import se.moma.kth.iv1350.model.external.ExternalPaymentSystem;
import se.moma.kth.iv1350.model.Receipt;
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
    
    private static final int AMOUNT = 100;
    private CreditCardInformationDTO creditCard = null;
    private PaymentAuthorizationRequest request = null;
    private ExternalPaymentSystem instance = null;
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        creditCard = new CreditCardInformationDTO();
        request = new PaymentAuthorizationRequest(AMOUNT,creditCard);
        instance = new ExternalPaymentSystem(request);
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testIsValid() {
        boolean result = instance.isValid();
        assertTrue("Not true",result);
        
    }

    @Test
    public void testGetReceipt() {
        Receipt result = null;
        String expResult = "You have payed: "+ AMOUNT;
        result = instance.getReceipt(AMOUNT);
        
        assertEquals(expResult, result.toString());
        
    }
    
}
