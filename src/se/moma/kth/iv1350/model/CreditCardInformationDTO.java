/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.moma.kth.iv1350.model;

import java.util.Date;

/**
 * Skapar ett kreditkort.
 * @author monde
 */
public final class CreditCardInformationDTO {
    
    private String creditCardVendor = null;
    private int creditCardNumber;
    private Date validDate = null;
    private String creditCardHolder = null;
    private int CCV;
    
    
   
    /**
     * Skapar en ny instans.
     */
    public CreditCardInformationDTO() {
    }
    
    /**
     * @return Ett instansen av <code>CreditCardInformationDTO</code>.
     */
    public CreditCardInformationDTO getCreditCard() {
        return this;
    }
    /**
     * 
     * @return En textsträngrepresentation av <code>CreditCardDTO</code>.
     */
   @Override
    public String toString() {
        return "kreditkortsinformation....";
    }
    
    
}
