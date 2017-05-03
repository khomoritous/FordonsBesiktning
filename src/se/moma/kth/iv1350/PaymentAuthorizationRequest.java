/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.moma.kth.iv1350;

/**
 *
 * @author monde
 */
class PaymentAuthorizationRequest {
    
   
    private int amount;
    private CreditCardInformation creditCard;
    
    
    
    
    public PaymentAuthorizationRequest(int amount, CreditCardInformation creditCard ) {
        this.amount = amount;
        this.creditCard = creditCard;
       
        
    }
    
    public boolean isApproved() {
        ExternalPaymentAuthorizationSystem paymentSystem = new ExternalPaymentAuthorizationSystem();
        return paymentSystem.isValid();
    }
    
    public Receipt getCustomerReceipt() {
        Receipt receipt = new Receipt();
        return receipt.getReceipt();
    }
    
    
    
    
}
