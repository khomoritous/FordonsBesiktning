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
    
    public Inspection(int cost) {
        this.cost  = cost;
       // this.result = result;
    }
    
    public int getInspectionCost() {
        return cost;
    }
    
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
