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
import se.moma.kth.iv1350.model.exception.InspectionException;

/**
 * Skapar ett fordonsregister.
 * @author monde
 */
public class VehicleRegistry {
    
    private List<Vehicle> vehicleRegistry = null;
    private static final int VEHICLE_NUMBER = 10;
    private static final int VEHICLE_TWO_NUMBER = 20;
    private static final int INSPECTION_COST = 100;
    
    
   /**
    * Skapar en ny instans.
    */
    public VehicleRegistry() {
     vehicleRegistry = new ArrayList<>();
     vehicleRegistry.add(new Vehicle(VEHICLE_NUMBER, new Inspection(INSPECTION_COST)));
     vehicleRegistry.add(new Vehicle(VEHICLE_TWO_NUMBER, null));
     
       
    }
    
    /**
     * @param vehicle Lägger till en instans av <code>Vehicle</code>
     * till <code>VehicleRegistry</code>.
     */
    public void addVehicle(Vehicle vehicle) {
        vehicleRegistry.add(vehicle);
    }
    
    /**
     * @param index int som hjälper till att hämta <code>Vehicle</code>.
     * @return En instans av <code>Vehicle</code>.
     */
    public Vehicle getVehicle(int index) {
        return vehicleRegistry.get(index);
    }
    /**
     * @return Antal <code>Vehicle</code> i <code>VehicleRegistry</code>.
     */
    public int sizeOfVehicleRegistry() {
            return vehicleRegistry.size();
    }
    
    public boolean isVehiclePresent(int registrationNumber) {
        return vehicleRegistry.contains(new Vehicle(registrationNumber, null));
    }
    
    /**
     * @param registrationNumber <code>Vehicle</code> registreringsnummer.
     * @return Kostnad för <code>Inspection</code>.
     * @throws se.moma.kth.iv1350.model.exception.InspectionException Kastar undantag
     * då <code>Vehicle</code> inte har någon <code>Inspection</code>.
     */
    public int findVehicleInspectionCost(int registrationNumber) throws InspectionException {
       return getVehicle(vehicleRegistry.indexOf(new Vehicle(registrationNumber, null))).getVehicleInspectionCost();
    }
    
    public Inspection findVehicleInspection(int registrationNumber) throws InspectionException {
        return getVehicle(vehicleRegistry.indexOf(new Vehicle(registrationNumber, null))).getVehicleInspection();
    }
    
    public void setVehicleInspectionResult(int registrationNumber, String result) {
        int index = vehicleRegistry.indexOf(new Vehicle(registrationNumber, null));
        vehicleRegistry.get(index).resultOfInspection(result);
    }
    
    public void printVehicleInspectionResult(int registrationNumber) {
       int index = vehicleRegistry.indexOf(new Vehicle(registrationNumber,null));
       vehicleRegistry.get(index).printVehicleInspectionResult();
    }
    
}
