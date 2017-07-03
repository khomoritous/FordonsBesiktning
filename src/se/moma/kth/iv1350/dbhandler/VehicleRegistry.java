/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.moma.kth.iv1350.dbhandler;

import java.util.ArrayList;
import java.util.List;
import se.moma.kth.iv1350.model.Inspection;
import se.moma.kth.iv1350.model.Vehicle;
import se.moma.kth.iv1350.model.exceptions.IllegalLicenseNumber;

/**
 * Skapar ett fordonsregister.
 * @author monde
 */
public class VehicleRegistry {
    
    private List<Vehicle> vehicleRegistry = null;
    private static final int VEHICLE_NUMBER_1 = 10;
    private static final int VEHICLE_NUMBER_2 = 15;
    private static final int VEHICLE_NUMBER_3 = 20;
    
    private static final int INSPECTION_COST = 100;
    
    
   /**
    * Skapar en ny instans.
    */
    public VehicleRegistry() {
       vehicleRegistry = new ArrayList<>();
       
       vehicleRegistry.add(new Vehicle(VEHICLE_NUMBER_1,new Inspection(INSPECTION_COST)));
       vehicleRegistry.add(new Vehicle(VEHICLE_NUMBER_3));
       vehicleRegistry.add(new Vehicle(VEHICLE_NUMBER_2, null));
       
       
    }
    
    /**
     * @param vehicle Lägger till en instans av klassen <code>Vehicle</code>
     * till registret.
     * 
     */
    public void addVehicle(Vehicle vehicle) {
        vehicleRegistry.add(vehicle);
    }
    
    /**
     * @param index int som hjälper till att hämta ett fordon.
     * @return En fordonsinstans av klassen <code>Vehicle</code>.
     */
    public Vehicle getVehicle(int index) {
        return vehicleRegistry.get(index);
    }
    /**
     * @return Antal fordon i registret.
     */
    public int sizeOfVehicleRegistry() {
       return vehicleRegistry.size();
    }
    
    /*public boolean findVehicleInspection(int index,int registrationNumber) {
       return 
    }*/
    
    public boolean findVehicleByNo(int index, int registrationNumber) {
        return vehicleRegistry.get(index).getVehicleNumber() == registrationNumber;
    }
   
    
}
