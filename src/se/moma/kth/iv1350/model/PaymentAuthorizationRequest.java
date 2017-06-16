/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.moma.kth.iv1350.model;

import se.moma.kth.iv1350.model.CreditCardInformationDTO;
import se.moma.kth.iv1350.model.ExternalPaymentSystem;
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
     * @param creditCard Är en instans av klassen <code>CreditCardInformationDTO</code>
     * som används vid betalning med kreditkort.
     */
    
    public PaymentAuthorizationRequest(int amount, CreditCardInformationDTO creditCard) {
        this.amount = amount;
        this.creditCard = creditCard;
    }
    /**
     * @return Om betalningen godkänds.
     */
    public boolean isApproved() {
          payment = new ExternalPaymentSystem(this);
          return payment.isValid();
    }
    /** 
     * @return En instans av klassen <code>Receipt</code> som kvitto på betalning.
     */
    public Receipt getCustomerReceipt() {
        return payment.getReceipt(amount);
    }
    
}
