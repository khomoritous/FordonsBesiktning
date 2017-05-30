/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.moma.kth.iv1350.model;

import se.moma.kth.iv1350.model.Inspection;

/**
 * Skapar en skrivare för utskrift.
 * @author monde
 */
public class ExternalPrinter {
    
    private Inspection inspection;//instansvariabel
    
    /**
     * Skapar en ny instans.
     * @param inspection En instans av klassen <code>Inspection</code> 
     * som skrivs ut.
     */
    public ExternalPrinter(Inspection inspection) {
        this.inspection = inspection;
    }
    /**
     * Gör en utskrift.
     */
    public void print() {
        System.out.println("The result of the inspection: " + inspection.getResult());
    }
    
    
}
