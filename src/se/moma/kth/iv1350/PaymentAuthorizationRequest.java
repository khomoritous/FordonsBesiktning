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
    private ExternalPaymentAuthorizationSystem payment;
    private Receipt receipt;
    
    
    /**
     * Skapar en ny instans.
     * @param amount Belopp att betala.
     * @param creditCard Är en instans av klassen <code>CreditCardInformation</code>
     * som används vid betalning.
     */
    
    public PaymentAuthorizationRequest(int amount, CreditCardInformation creditCard) {
        this.amount = amount;
        this.creditCard = creditCard;
    }
    /**
     * 
     * @return Om betalningen godkänds.
     */
    public boolean isApproved() {
          payment = new ExternalPaymentAuthorizationSystem(this);
          return payment.isValid();
    }
    /**
     * 
     * @return En instans av klassen <code>Receipt</code> som kvitto på betalning.
     */
    public Receipt getCustomerReceipt() {
        return payment.getReceipt(amount);
    }
    
}
