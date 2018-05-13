/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.moma.kth.iv1350.model.external;

import java.time.LocalDate;
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
    private static final String VENDOR = "VISA";
    private static final int CARD_NUMBER = 2334;
    private final LocalDate validDate = LocalDate.now();
    private static final  String CARD_OWNER = "Jan";
    private static final int CCV = 222;
    
    
    
    @Before
    public void setUp() {
        creditCard = new CreditCardInformationDTO(VENDOR, CARD_NUMBER, validDate, CARD_OWNER,CCV);
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
