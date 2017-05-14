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
class Inspection {
    
    private int cost;
    private String result;
    private Vehicle vehicle;
    
    public Inspection(int cost) {
        this.cost  = cost;
       // this.result = result;
    }
    /**
     * Metod av typ getter.
     * @return Kostnaden för en inspektion.
     */
    public int getInspectionCost() {
        return cost;
    }
    /**
     * Metod av typ getter.
     * @return En instans av klassen <code>Inspection</code> som hör till
     * ett fordon.
     */
    public Inspection getInspection() {
        return this;
    }
    public void setResultOfInspection(String result) {
        this.result = result;
    }
    public String getResult() {
        return result;
    }
    
    @Override
    public String toString() {
        return "Inspektioner att utföra....";
    }
    
}
