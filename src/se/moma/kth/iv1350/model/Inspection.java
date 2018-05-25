/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.moma.kth.iv1350.model;

import java.util.ArrayList;
import java.util.List;
import se.moma.kth.iv1350.model.external.ExternalPrinter;
import se.moma.kth.iv1350.model.interfaces.VehicleObserver;

/**
 * Skapar en <code>Inspection</code> med tillhörande kostnad.
 * @author monde
 */
public class Inspection {
    
    private final int cost;
    private String result;
    
    private List<VehicleObserver> vehicleObservers = null;
    
    
    /**
     * Skapar en ny instans.
     * @param cost Kostnad för en <code>Inspection</code>.
     */
    
    public Inspection(int cost) {
        this.cost  = cost;
        vehicleObservers = new ArrayList<>();
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
        notifyObservers();
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
    
    /**
     * Lägger till en <code>VehicleObserver</code> som är intresserad utav utförda <code>Inspection</code>.
     * @param obs Instans av <code>VehicleObserver</code>.
     */
    public void addVehicleObserver(VehicleObserver obs) {
         vehicleObservers.add(obs);
    }
    /**
     * Lägger till en lista av <code>VehicleObserver</code> som är intresserade utav utförda <code>Inspection</code>.
     * @param obs Instans av lista av <code>VehicleObserver</code>.
     */
    public void addVehicleObservers(List<VehicleObserver> obs) {
        vehicleObservers.addAll(obs);
    }
    
    
    private void notifyObservers() {
        for(VehicleObserver inspectionObserver: vehicleObservers) {
            inspectionObserver.newInspection(result);
        }
    }
     
    
    private ExternalPrinter createInstanceOfPrinter() {
       return new ExternalPrinter(this);
    } 
    
    
    
    
    
    
    
    
}
