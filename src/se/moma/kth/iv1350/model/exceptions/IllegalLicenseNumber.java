/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.moma.kth.iv1350.model.exceptions;

/**
 * Kastas då ett fordon inte har några inspektioner.
 * @author monde
 */
public class IllegalLicenseNumber extends Exception  {
    
    private int vehicleNumberWithNoInspection;
    
    /**
     * Skapar en ny instans.
     * @param vehicleNumberWithNoInspection Nummer på fordonet utan inspektionener.
     */
   public IllegalLicenseNumber(int vehicleNumberWithNoInspection) {
        super("Not inspections for vehicle number "+ vehicleNumberWithNoInspection);
        this.vehicleNumberWithNoInspection = vehicleNumberWithNoInspection;
    }
   
    /**
    * 
    * @return Fordonets registernummer.
    */
  public int getVehicleNumberWithNoInspection() {
        return vehicleNumberWithNoInspection;
   }
    
   
    
}
