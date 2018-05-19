/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.moma.kth.iv1350.model;

import java.time.LocalDate;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import se.moma.kth.iv1350.model.external.ExternalPaymentSystem;

/**
 *
 * @author monde
 */
public class PaymentAuthorizationRequestTest {
    
    private PaymentAuthorizationRequest paymentAuthorizationRequest = null;
    private ExternalPaymentSystem externalPaymentSystem  = null;
    private static final int AMOUNT = 100;
    private static final String VENDOR = "VISA";
    private static final int CARD_NUMBER = 2334;
    private final LocalDate validDate = LocalDate.now();
    private static final  String CARD_OWNER = "Jan";
    private static final int CCV = 222;
    
    
    @Before
    public void setUp() {
         paymentAuthorizationRequest = new PaymentAuthorizationRequest(100, new CreditCardInformationDTO(VENDOR, CARD_NUMBER, validDate,CARD_OWNER, CCV));
         externalPaymentSystem = new ExternalPaymentSystem(paymentAuthorizationRequest);
    }

    @Test
    public void testIsApproved() {
       assertTrue("Payment not valid!", externalPaymentSystem.isValid());
    }

    @Test
    public void testGetCustomerReceipt() {
        externalPaymentSystem.getReceipt(AMOUNT);
        
    }
    
}
