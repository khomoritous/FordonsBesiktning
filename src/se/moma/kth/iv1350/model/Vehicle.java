/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.moma.kth.iv1350.model;

import java.util.ArrayList;
import java.util.List;
import se.moma.kth.iv1350.dbhandler.exceptions.VehicleRegistryException;

/**
 * Skapar ett fordon med registreringsnummer och inspektion.
 * @author monde
 */
public class Vehicle {
    
    private final int vehicleRegistrationNumber;//instansvariabel
    private Inspection inspection; //null;//instansvariabel
   
    
    /**
     * Skapar en ny instans.
     * @param vehicleRegistrationNumber Registreringsnummer för fordonet.
     * @param inspection Instans av klassen <code>Inspection</code> som hör till fordonet.
     */
    public Vehicle(int vehicleRegistrationNumber, Inspection inspection) {
        this.vehicleRegistrationNumber  = vehicleRegistrationNumber;
        this.inspection  = inspection;
    }
    
    /**
     * @return Kostnaden för inspektion som hör till fordonet.
     */
    public int getVehicleInspectionCost() {
        return inspection.getInspectionCost();
    }
    /**
     * @return En instans av klassen <code>Vehicle</code>.
     */
    public Vehicle getVehicle() {
        return this;
    }
    /**
     * @return Fordonets registreringsnummer.
     */
    public int getVehicleNumber() {
        return vehicleRegistrationNumber;
    }
    /**
     * @return En instans av klassen <code> Inspection</code> som 
     * hör till fordonet.
     */
    public Inspection getVehicleInspection() {
        if(inspection == null)
            throw new VehicleRegistryException("No inspections found.");
        else 
            return inspection.getInspection();
    }
    /**
     * Gör en utskrift av resultatet från fordonsbesiktningen.
     */
    public void printVehicleInspectionResult() {
        inspection.printInspectionResult();
    }
    /**
     * @param result Textsträng som anger resultat från besiktning av fordonet.
     */
    public void resultOfInspection(String result) {
       inspection.setResultOfInspection(result);
    }
    
    
}
