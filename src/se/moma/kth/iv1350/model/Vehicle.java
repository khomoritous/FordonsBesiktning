/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.moma.kth.iv1350.model;

/**
 * Skapar ett fordon med registreringsnummer och inspektion.
 * @author monde
 */
public class Vehicle {
    
    private final int vehicleRegistrationNumber;//instansvariabel
    private Inspection inspection = null;//instansvariabel
    
    /**
     * Skapar en ny instans.
     * @param vehicleRegistrationNumber registreringsnummer för <code>Vehicle</code>.
     * @param inspection <code>Inspection</code> som ska utföras på <code>Vehicle</code>.
     */
    public Vehicle(int vehicleRegistrationNumber, Inspection inspection) {
        this.vehicleRegistrationNumber  = vehicleRegistrationNumber;
        this.inspection  = inspection;
    }
    /**
     * @return Kostnad för <code>Inspection</code> som hör till <code>Vehicle</code>.
     */
    public int getVehicleInspectionCost() {
        return inspection.getInspectionCost();
    }
    /**
     * @return En instans av <code>Vehicle</code>.
     */
    public Vehicle getVehicle() {
        return this;
    }
    /**
     * @return <code>Vehicle</code> registreringsnummer.
     */
    public int getVehicleNumber() {
        return vehicleRegistrationNumber;
    }
    /**
     * @return En instans av <code> Inspection</code> som 
     * hör till <code>Vehicle</code>.
     */
    public Inspection getVehicleInspection() {
       return inspection.getInspection();
    }
    /**
     * Utskrift av resultat vid <code>Inspection</code> av <code>Vehicle</code>.
     */
    public void printVehicleInspectionResult() {
        inspection.printInspectionResult();
    }
    /**
     * @param result Ange resultat vid <code>Inspection</code> av <code>Vehicle</code>.
     */
    public void resultOfInspection(String result) {
       inspection.setResultOfInspection(result);
    }
    
    
}
