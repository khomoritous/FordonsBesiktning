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
     * @param vehicle Lägger till en instans av <code>Vehicle</code>.
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
    
    /**
     * @param registrationNumber Sökt <code>Vehicle</code> registreringsnummer.
     * @return <code>True</code>, om <code>Vehicle</code> finns i <code>VehicleRegistry</code>,
     * <code>false</code> annars.
     */
    public boolean isVehiclePresent(int registrationNumber) {
        return vehicleRegistry.contains(createVehicleInstance(registrationNumber));
    }
    
    /**
     * @param registrationNumber <code>Vehicle</code> registreringsnummer.
     * @return Kostnad för <code>Inspection</code>.
     * @throws se.moma.kth.iv1350.model.exception.InspectionException Kastas
     * då <code>Vehicle</code> inte har någon <code>Inspection</code>.
     */
    public int findVehicleInspectionCost(int registrationNumber) throws InspectionException {
       return getVehicle(vehicleRegistry.indexOf(createVehicleInstance(registrationNumber))).getVehicleInspectionCost();
    }
    
    /**
     * @param registrationNumber <code>Vehicle</code> registeringsnummer.
     * @return <code>Inspection</code> tillhörande <code>Vehicle</code>
     * @throws InspectionException Kastas då ingen <code>Inspection</code> hittats.
     */
    public Inspection findVehicleInspection(int registrationNumber) throws InspectionException {
        return getVehicle(vehicleRegistry.indexOf(createVehicleInstance(registrationNumber))).getVehicleInspection();
    }
    
    /**
     * @param registrationNumber <code>Vehicle</code> registreringsnummer.
     * @param result Resultatet av <code>Inspection</code> av <code>Vehicle</code>.
     */
    public void setVehicleInspectionResult(int registrationNumber, String result) {
        int index = vehicleRegistry.indexOf(createVehicleInstance(registrationNumber));
        vehicleRegistry.get(index).resultOfInspection(result);
    }
    /**
     * @param registrationNumber <code>Vehicle</code> registreringsnummer.
     */
    public void printVehicleInspectionResult(int registrationNumber) {
       int index = vehicleRegistry.indexOf(createVehicleInstance(registrationNumber));
       vehicleRegistry.get(index).printVehicleInspectionResult();
    }
    
    private Vehicle createVehicleInstance(int registrationNumber) {
        return new Vehicle(registrationNumber, null);
    }
    
}
