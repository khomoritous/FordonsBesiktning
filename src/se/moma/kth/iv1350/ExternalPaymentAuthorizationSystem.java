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
class ExternalPaymentAuthorizationSystem {
    
    
      private PaymentAuthorizationRequest request;    
      //private boolean paymentApproval;
      private Receipt receipt;
      /**
       * Skapar en ny instans.
       * @param request Är en instans av klassen <code>PaymentAuthorizationRequest</code>
       * som används vid betalning mot externt system.
       */
      public ExternalPaymentAuthorizationSystem(PaymentAuthorizationRequest request) {
         this.request = request;
      }
      /**
       * 
       * @return Ja eller nej om betalning går igenom.
       */
      public boolean isValid() {
          return true;
      }
      /**
       * Getter
       * @return kvitto på betalning.
       */
      public Receipt getReceipt(int amount) {
          receipt = new Receipt(amount);
          return receipt.getReceipt();
      }
    
}
