/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.moma.kth.iv1350.model.exception;

import se.moma.kth.iv1350.model.Vehicle;

/**
 * Kastas då ett <code>Vehicle</code> inte har några <code>Inspection</code>.
 * @author monde
 */
public class InspectionException extends Exception  {
    
     private Vehicle vehicleWithNoInspections = null;
    
    /**
     * Skapar en ny instans.
     * @param vehicleWithNoInspections Instans av <code>Vehicle</code>
     * utan <code>Inspection</code>.
     */
   public InspectionException(Vehicle vehicleWithNoInspections) {
        super("No inspections found with vehicle registration number: " + vehicleWithNoInspections);
        this.vehicleWithNoInspections = vehicleWithNoInspections;
    }
   
    /**
    * @return <code>Vehicle</code> med inga <code>Inspection</code>.
    */
   public Vehicle getVehicleWithNoInspections() {
        return vehicleWithNoInspections;
   } 
}