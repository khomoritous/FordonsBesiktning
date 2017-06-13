/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.moma.kth.iv1350.model;

/**
 * Skapar ett kreditkort.
 * @author monde
 */
public class CreditCardInformationDTO {
    
   
    /**
     * Skapar en ny instans.
     */
    public CreditCardInformationDTO() {
    }
    
    /**
     * @return Ett kreditkort av instansen <code>CreditCardInformationDTO</code>.
     */
    public CreditCardInformationDTO getCreditCard() {
        return this;
    }
    
   @Override
    public String toString() {
        return "kreditkortsinformation....";
    }
    
    
}
