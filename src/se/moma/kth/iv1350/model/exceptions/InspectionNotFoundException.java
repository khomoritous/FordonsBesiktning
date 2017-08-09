/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.moma.kth.iv1350.model.exceptions;

import se.moma.kth.iv1350.model.Vehicle;

/**
 * Kastas då ett <code>Vehicle</code> inte har några <code>Inspection</code>.
 * @author monde
 */
public class InspectionNotFoundException extends Exception  {
    
    private Vehicle vehicleWithNoInspections;
    
    /**
     * Skapar en ny instans.
     * @param vehicleWithNoInspection Instans av <code>Vehicle</code>
     * som inte har någon <code>Inspection</code>.
     */
   public InspectionNotFoundException(Vehicle vehicleWithNoInspection) {
        super("No inspections for vehicle number: "+ vehicleWithNoInspection.getVehicleNumber());
        this.vehicleWithNoInspections = vehicleWithNoInspection;
    }
   
    /**
    * @return </code>vehicleWithNoInspections</code> registernummer.
    */
  public Vehicle getVehicleWithNoInspections() {
        return vehicleWithNoInspections;
   }
}
