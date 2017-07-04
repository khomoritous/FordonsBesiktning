/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.moma.kth.iv1350.model;

import se.moma.kth.iv1350.model.exceptions.InspectionNotFoundException;
import se.moma.kth.iv1350.model.external.ExternalPrinter;

/**
 * Skapar en inspektion med tillhörande kostnad.
 * @author monde
 */
public class Inspection {
    
    private int cost;
    private String result;
    
    
    /**
     * Skapar en ny instans.
     * @param cost En inspektions kostnad.
     */
    
    public Inspection(int cost) {
        this.cost  = cost;
       // this.result = result;
    }
    
    /**
     * @return Kostnaden för en inspektion.
     */
    public int getInspectionCost() {
        return cost;
    }
    /**
     * @return En instans av klassen <code>Inspection</code> som hör till
     * ett fordon.
     */
    public Inspection getInspection()  {
      
        return this;
    }
    /**
     * @param result Textsträng som används för resultat av inspektion.
     */
    public void setResultOfInspection(String result) {
        this.result = result;
    }
    public String getResult() {
        return result;
    }
    
    public void printInspectionResult() {
        ExternalPrinter printer = new ExternalPrinter(this);
        printer.print();
    }
    
    @Override
    public String toString() {
        return "Inspections to perform....";
    }
    
}
