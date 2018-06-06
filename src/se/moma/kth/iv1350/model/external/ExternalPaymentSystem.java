/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.moma.kth.iv1350.model.external;

import se.moma.kth.iv1350.model.PaymentAuthorizationRequest;
import se.moma.kth.iv1350.model.Receipt;

/**
 * Skapar ett externt betalningsystem.
 * @author monde
 */
public class ExternalPaymentSystem {
    
    
      private PaymentAuthorizationRequest request = null;   
      private final Receipt receipt = null;
      
      /**
       * Skapar en ny instans.
       * @param request Är en instans av <code>PaymentAuthorizationRequest</code>
       * som används vid betalning mot externt system.
       */
      public ExternalPaymentSystem(PaymentAuthorizationRequest request) {
         this.request = request;
      }
      
      /**
       * @return <code>True</code>, om betalning går igenom, annars <code>False</code>.
       */
      public boolean isValid() {
          return true;
      }
      
      /**
       * @param amount Belopp som betalas.
       * @return <code>Receipt</code> på betalning.
       */
      public Receipt getReceipt(int amount) {
          return createReceiptInstance(amount).getReceiptInstance();
      }

      private Receipt createReceiptInstance(int amount) {
        return new Receipt(amount);
      }
    
}
