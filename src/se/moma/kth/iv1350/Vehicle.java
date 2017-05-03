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
     * Används vid besiktning för att hämta en inspektion som hör till ett 
     * fordon
     * @return inspektionen som hör till fordonet
     */
    public int getVehicleInspection() {
        return inspection.getInspection();
    }
    
    public int getVehicle() {
        return vehicleRegistrationNumber;
    }
}
