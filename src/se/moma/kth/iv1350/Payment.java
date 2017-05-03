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
public class Payment {
    
    //private int cash;
    private int amount;
    //private PaymentAuthorizationRequest paymentRequest;
    private CreditCardInformation creditCard;
    private Receipt receipt;
    
    public Payment(int amount,CreditCardInformation creditCard, Receipt receipt ) {
        this.amount = amount;
        this.creditCard = creditCard;
        this.receipt = receipt;
        
    }
    
    public void setAmount(int amount) {
        creditCard.getCreditCard();
        
    }
    
    public CreditCardInformation getCreditCard() {
        return creditCard.getCreditCard();
    }
    
    public Receipt getReceipt() {
       return receipt.getReceipt();
    }
    
    
    
}
