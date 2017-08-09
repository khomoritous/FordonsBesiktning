/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.moma.kth.iv1350.dbhandler;

import java.util.ArrayList;
import java.util.List;
import se.moma.kth.iv1350.dbhandler.exceptions.VehicleRegistryException;
import se.moma.kth.iv1350.model.Inspection;
import se.moma.kth.iv1350.model.Vehicle;
import se.moma.kth.iv1350.model.exceptions.InspectionNotFoundException;

/**
 * Skapar ett fordonsregister.
 * @author monde
 */
public class VehicleRegistry {
    
    private List<Vehicle> vehicleRegistry = null;
    private static final int VEHICLE_NUMBER_1 = 10;
    private static final int VEHICLE_NUMBER_2 = 15;
    
    private static final int INSPECTION_COST = 100;
    
    
   /**
    * Skapar en ny instans.
    */
    public VehicleRegistry() {
     vehicleRegistry = new ArrayList<>();
     vehicleRegistry.add(new Vehicle(VEHICLE_NUMBER_1,new Inspection(INSPECTION_COST)));
     vehicleRegistry.add(new Vehicle(VEHICLE_NUMBER_2, null));
    }
    
    /**
     * @param vehicle Lägger till en instans av klassen <code>Vehicle</code>
     * till registret.
     */
    public void addVehicle(Vehicle vehicle) {
        vehicleRegistry.add(vehicle);
    }
    
    /**
     * @param index int som hjälper till att hämta ett <code>Vehicle</code>.
     * @return En instans av <code>Vehicle</code>.
     */
    public Vehicle getVehicle(int index) {
        return vehicleRegistry.get(index);
    }
    
    /**
     * @return Antal <code>Vehicle</code> i registret.
     */
    public int size() throws VehicleRegistryException {
        if(vehicleRegistry == null)
            throw new VehicleRegistryException("Could not access registry.");
        return vehicleRegistry.size();
    }
    /**
     * @param vehicle Instans av <code>Vehicle</code> som har <code>Inspection</code>.
     * @return Kostnad för <code>Inspection</code>.
     * @throws InspectionNotFoundException Kastas då inga <code>Inspection</code> hittas.
     */
    public int findVehicleInspection(Vehicle vehicle) throws InspectionNotFoundException {
      return vehicle.getVehicleInspection().getInspectionCost();
    }
    
    /**
     * @param index För att hitta i <code>vehicleRegistry</code>.
     * @param registrationNumber Registreringsnummer på <code>Vehicle</code> i <code>vehicleRegistry</code>.
     * @return <code>true</code>, om <code>Vehicle</code> hittas.
     */
    public boolean findVehicleByNo(int index, int registrationNumber) {
         return vehicleRegistry.get(index).getVehicleNumber() == registrationNumber;
    }
   
    
}
