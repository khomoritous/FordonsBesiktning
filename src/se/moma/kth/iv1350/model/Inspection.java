/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.moma.kth.iv1350.model;

import moma.se.kth.iv1350.util.VehicleObserver;
import java.util.ArrayList;
import java.util.List;
import se.moma.kth.iv1350.model.external.ExternalPrinter;

/**
 * Skapar en inspektion med tillhörande kostnad.
 * @author monde
 */
public class Inspection  {
   
    private List<VehicleObserver> vehicleObservers = new ArrayList<>(); //Lista med objekt som observerar den här klassen.
    private int cost;
    private String result;
    
    
    /**
     * Skapar en ny instans.
     * @param cost Kostnaden för en <code>Inspection</code>.
     */
    
    public Inspection(int cost) {
        this.cost  = cost;
       
    }
    
    /**
     * @return Kostnad för en <code>Inspection</code>.
     */
    public int getInspectionCost() {
        return cost;
    }
    /**
     * @return En <code>Inspection</code>.
     */
    public Inspection getInspection() {
        return this;
    }
    
    /**
     * @param result Textsträng som används för resultat av en <code>Inspection</code>.
     */
    public void setResultOfInspection(String result) {
        this.result = result;
        notifyObservers();
    }
    /**
     * @return Resultat från en utförd <code>Inspection</code>.
     */
    public String getResult() {
        return result;
    }
    
    /**
     * Gör en utskrift av resultat från en <code>Inspection</code>.
     */
    public void printInspectionResult() {
        ExternalPrinter printer = new ExternalPrinter(this);
        printer.print();
    }
    /**
     * @return Typ av <code>Inspection</code>.
     */
    @Override
    public String toString() {
        return "Inspections to perform....";
    }
    
    /**
     * Lägger till objekt av klasser som är intresserade av utförda inspektioner.
     * @param obs Instans av <code>VehicleObserver</code> som läggs till listan.
     */
    public void addVehicleObserver(VehicleObserver obs) {
        vehicleObservers.add(obs);
    }
    
    /**
     * Lägger till en lista av <code>VehicleObserver</code> till en lista.
     * @param obs Lista av <code>VehicleObserver</code> 
     */
    public void addVehicleObservers(List<VehicleObserver> obs) {
        vehicleObservers.addAll(obs);
        
    }
    
    private void notifyObservers() {
        for(VehicleObserver vehicleObserver: vehicleObservers) {
            vehicleObserver.newInspection(this.getResult());
        }
    }
    
}
