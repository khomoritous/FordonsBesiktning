/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.moma.kth.iv1350.db;

import java.util.ArrayList;
import java.util.List;
import se.moma.kth.iv1350.model.Inspection;
import se.moma.kth.iv1350.model.Vehicle;

/**
 * Skapar ett fordonsregister.
 * @author monde
 */
public class VehicleRegistry {
    
    private List<Vehicle> vehicleRegistry = null;
    private static final int VEHICLE_NUMBER = 10;
    private static final int INSPECTION_COST = 100;
    
   /**
    * Skapar en ny instans.
    */
    public VehicleRegistry() {
       vehicleRegistry = new ArrayList<>();
       vehicleRegistry.add(new Vehicle(VEHICLE_NUMBER,new Inspection(INSPECTION_COST)));
    }
    /**
     * 
     * @param vehicle Lägger till en instans av klassen <code>Vehicle</code>.
     * 
     */
    public void addVehicle(Vehicle vehicle) {
        vehicleRegistry.add(vehicle);
    }
    /**
     * Hämtar instans av klassen <code>Vehicle</code> från register.
     * @param index int som hjälper till att hämta ett fordon.
     * @return ett fordon.
     */
    public Vehicle getVehicle(int index) {
        return vehicleRegistry.get(index);
    }
    /**
     * 
     * @return antal fordon i registret.
     */
    public int sizeOfVehicleRegistry() {
       return vehicleRegistry.size();
    }
    
    
}
