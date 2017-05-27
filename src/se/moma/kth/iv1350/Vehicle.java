/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.moma.kth.iv1350;

/**
 * Skapar ett fordon med registreringsnummer och inspektion.
 * @author monde
 */
class Vehicle {
    
    private int vehicleRegistrationNumber;//instansvariabel
    private Inspection inspection;//instansvariabel
    
    /**
     * Skapar en instans av klassen <code>Vehicle</code>.
     * @param vehicleRegistrationNumber registreringsnummer för fordonet.
     * @param inspection inspektionen som ska utföras på fordonet vid besiktning.
     */
    
    public Vehicle(int vehicleRegistrationNumber, Inspection inspection) {
        this.vehicleRegistrationNumber  = vehicleRegistrationNumber;
        this.inspection  = inspection;
    }
    /**
     * Används vid besiktning för att hämta kostnad för en inspektion 
     * som hör till ett fordon.
     * @return Kostnaden för fordonet.
     */
    public int getVehicleInspectionCost() {
        return inspection.getInspectionCost();
    }
    /**
     * Metod av typ getter-
     * @return En instans av klassen <code>Vehicle</code>.
     */
    public Vehicle getVehicle() {
        return this;
    }
    /**
     * Metod av typ getter-
     * @return fordonets registreringsnummer.
     */
    public int getVehicleNumber() {
        return vehicleRegistrationNumber;
    }
    /**
     * Används för att hämta en inspektion som hör till ett fordon.
     * @return En instans av klassen <code> Inspection</code> som 
     * hör till fordonet.
     */
    public Inspection getVehicleInspection() {
       return inspection.getInspection();
    }
    /**
     * Gör en utskrift av resultatet från fordonsbesiktningen.
     */
    public void printVehicleInspectionResult() {
        inspection.printInspectionResult();
    }
    /**
     * 
     * @param result Anger "pass" eller "fail".
     */
    public void resultOfInspection(String result) {
       inspection.setResultOfInspection(result);
    }
    
    
}
