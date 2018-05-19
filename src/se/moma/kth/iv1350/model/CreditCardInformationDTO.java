/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.moma.kth.iv1350.model;

import java.time.LocalDate;
import java.util.Date;

/**
 * Skapar ett kreditkort.
 * @author monde
 */
public final class CreditCardInformationDTO {
    
    private String creditCardVendor = null;
    private final int creditCardNumber;
    private LocalDate validDate = null;
    private String creditCardHolder = null;
    private final int CCV;
    
    
   
    /**
     * Skapar en ny instans.
     * @param creditCardVendor Kortutgivare
     * @param creditCardNumber Kortnummer
     * @param validDate Giltigtsdatum t.o.m
     * @param creditCardHolder Namn på kortinnehavare
     * @param CCV autentiseringskod
     */
    public CreditCardInformationDTO(String creditCardVendor, int creditCardNumber, LocalDate validDate,String creditCardHolder, int CCV) {
        this.creditCardVendor = creditCardVendor;
        this.creditCardNumber = creditCardNumber;
        this.validDate = validDate;
        this.creditCardHolder = creditCardHolder;
        this.CCV = CCV;
    }
    
    /**
     * @return Ett instansen av <code>CreditCardInformationDTO</code>.
     */
    public CreditCardInformationDTO getCreditCard() {
        return this;
    }

    public String getCreditCardVendor() {
        return creditCardVendor;
    }

    public int getCreditCardNumber() {
        return creditCardNumber;
    }

    public LocalDate getValidDate() {
        return validDate;
    }

    public String getCreditCardHolder() {
        return creditCardHolder;
    }

    public int getCCV() {
        return CCV;
    }
    
    
    
    /**
     * 
     * @return En textsträngrepresentation av <code>CreditCardInformationDTO</code>.
     */
   @Override
    public String toString() {
        return "kreditkortsinformation....";
    }
    
    
}
