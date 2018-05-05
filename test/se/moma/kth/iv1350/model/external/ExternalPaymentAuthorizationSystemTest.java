/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.moma.kth.iv1350.model.external;

import se.moma.kth.iv1350.model.PaymentAuthorizationRequest;
import se.moma.kth.iv1350.model.CreditCardInformationDTO;
import se.moma.kth.iv1350.model.external.ExternalPaymentSystem;
import se.moma.kth.iv1350.model.Receipt;
import org.junit.Before;
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
    private ExternalPaymentSystem externalPaymentSystem = null;
    private Receipt receipt = null;
    private String expResult = null;
    
    
    
    @Before
    public void setUp() {
        creditCard = new CreditCardInformationDTO();
        request = new PaymentAuthorizationRequest(AMOUNT,creditCard);
        externalPaymentSystem = new ExternalPaymentSystem(request);
    }
    
    
    @Test
    public void testIsValid() {
        assertTrue("Not valid!", externalPaymentSystem.isValid());
        
    }

    @Test
    public void testGetReceipt() {
        expResult = "You have payed: "+ AMOUNT;
        receipt = externalPaymentSystem.getReceipt(AMOUNT);
        
        assertEquals(expResult, receipt.toString());
    }
    
}
