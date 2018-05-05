/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.moma.kth.iv1350.model;

import se.moma.kth.iv1350.model.CreditCardInformationDTO;
import se.moma.kth.iv1350.model.external.ExternalPaymentSystem;
import se.moma.kth.iv1350.model.Receipt;

/**
 *
 * @author monde
 */
public class PaymentAuthorizationRequest {
    
   
    private int amount;
    private CreditCardInformationDTO creditCard = null;
    private ExternalPaymentSystem payment = null;
  
    
    
    /**
     * Skapar en ny instans.
     * @param amount Belopp att betala.
     * @param creditCard Är en instans av <code>CreditCardInformationDTO</code>
     * som används vid betalning.
     */
    
    public PaymentAuthorizationRequest(int amount, CreditCardInformationDTO creditCard) {
        this.amount = amount;
        this.creditCard = creditCard;
    }
    /**
     * @return <code>True</code> ,om betalningen godkänds, annars <code>false</code>.
     */
    public boolean isApproved() {
        return createExternalPaymentRequestInstance().isValid();
    }

    private ExternalPaymentSystem createExternalPaymentRequestInstance() {
        return new ExternalPaymentSystem(this);
    }
    /** 
     * @return En instans av <code>Receipt</code> som kvitto på betalning.
     */
    public Receipt getCustomerReceipt() {
        return payment.getReceipt(amount);
    }
    
}
