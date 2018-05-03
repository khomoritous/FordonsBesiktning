/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.moma.kth.iv1350.model;

import se.moma.kth.iv1350.model.external.ExternalPrinter;

/**
 * Skapar en inspektion med tillhörande kostnad.
 * @author monde
 */
public class Inspection {
    
    private final int cost;
    private String result;
    
    
    /**
     * Skapar en ny instans.
     * @param cost Kostnad för en <code>Inspection</code>.
     */
    
    public Inspection(int cost) {
        this.cost  = cost;
       // this.result = result;
    }
    
    /**
     * @return Kostnad för en <code>Inspection</code>.
     */
    public int getInspectionCost() {
        return cost;
    }
    
    /**
     * @return En instans av <code>Inspection</code>.
     */
    public Inspection getInspection() {
        return this;
    }
    
    /**
     * @param result Anger resultat vid <code>Inspection</code>.
     */
    public void setResultOfInspection(String result) {
        this.result = result;
    }
    
    /**
     * @return Resultat av en <code>Inspection</code>. 
     */
    public String getResult() {
        return result;
    }
    
    /**
     * Skriver ut resultat av <code>Inspection</code>.
     */
    public void printInspectionResult() {
       createInstanceOfPrinter().print();
    }
    
    /**
     * @return Textrepresentation av <code>Inspection</code>.  
     */
    @Override
    public String toString() {
        return "Inspections to perform....";
    }
    
    private ExternalPrinter createInstanceOfPrinter() {
       return new ExternalPrinter(this);
    } 
    
}
