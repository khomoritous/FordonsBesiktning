/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.moma.kth.iv1350.model;

import moma.se.kth.iv1350.util.VehicleObserver;
import java.util.ArrayList;
import java.util.List;
import moma.se.kth.iv1350.util.VehicleObserved;
import se.moma.kth.iv1350.model.external.ExternalPrinter;

/**
 * Skapar en inspektion med tillhörande kostnad.
 * @author monde
 */
public class Inspection implements VehicleObserved {
   
    private List<VehicleObserver> vehicleObservers = new ArrayList<>(); //Lista med objekt som observerar den här klassen.
    private int cost;
    private String result;
    
    
    /**
     * Skapar en ny instans.
     * @param cost Kostnaden för en inspektion.
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
        notifyObservers();
    }
    /**
     * 
     * @return Resultat från en utförd <code>Inspection</code>.
     */
    @Override
    public String getResult() {
        return result;
    }
    /**
     * Gör en utskrift av resultat från inspektion.
     */
    public void printInspectionResult() {
        ExternalPrinter printer = new ExternalPrinter(this);
        printer.print();
    }
    
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
            vehicleObserver.newInspection(this);
        }
    }
    
}
