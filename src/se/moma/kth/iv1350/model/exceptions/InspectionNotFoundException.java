/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.moma.kth.iv1350.model.exceptions;

import se.moma.kth.iv1350.model.Vehicle;

/**
 * Kastas då ett fordon inte har några inspektioner.
 * @author monde
 */
public class InspectionNotFoundException extends Exception  {
    
    private Vehicle vehicleWithNoInspections;
    
    /**
     * Skapar en ny instans.
     * @param vehicleWithNoInspection Instans av klassen <code>Vehicle</code>
     * som inte har någon inspektion.
     */
   public InspectionNotFoundException(Vehicle vehicleWithNoInspection) {
        super("No inspections for vehicle number: "+ vehicleWithNoInspection.getVehicleNumber());
        this.vehicleWithNoInspections = vehicleWithNoInspection;
    }
   
    /**
    * 
    * @return Fordonets registernummer.
    */
  public Vehicle getVehicleWithNoInspections() {
        return vehicleWithNoInspections;
   }
}
