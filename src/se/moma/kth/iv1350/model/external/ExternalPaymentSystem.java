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
      private Receipt receipt = null;
      
      /**
       * Skapar en ny instans.
       * @param request Är en instans av klassen <code>PaymentAuthorizationRequest</code>
       * som används vid betalning mot externt system.
       */
      public ExternalPaymentSystem(PaymentAuthorizationRequest request) {
         this.request = request;
      }
      
      /**
       * @return <code>true</code>, om betalning går igenom, annars <code>false</code>.
       */
      public boolean isValid() {
          return true;
      }
      
      /**
       * @param amount Belopp som betalas.
       * @return Kvittoinstans på betalning av klass <code>Receipt</code>.
       */
      public Receipt getReceipt(int amount) {
          receipt = new Receipt(amount);
          return receipt.getReceipt();
      }
    
}
