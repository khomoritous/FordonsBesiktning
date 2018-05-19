/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.moma.kth.iv1350.dbhandler;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import se.moma.kth.iv1350.model.Inspection;
import se.moma.kth.iv1350.model.Vehicle;

/**
 *
 * @author monde
 */
public class VehicleRegistryTest {
    
    private VehicleRegistry vehicleRegistry = null;
    private static final int VEHICLE_NUMBER = 100;
    private static final int INSPECTION_COST = 100;
    private static final int VEHICLE_INDEX = 0;
    private static final int SIZE_OF_REGISTRY_INIT = 2;
    private static final int SIZE_OF_REGISTRY = 3;
    
    @Before
    public void setUp() {
      vehicleRegistry = new VehicleRegistry();
    }

    @Test
    public void testAddVehicle() {
        vehicleRegistry.addVehicle(new Vehicle(VEHICLE_NUMBER, new Inspection(INSPECTION_COST)));
        assertEquals(SIZE_OF_REGISTRY, vehicleRegistry.sizeOfVehicleRegistry());
    }

    @Test
    public void testGetVehicle() {
        assertNotNull(vehicleRegistry.getVehicle(VEHICLE_INDEX));
    }

    @Test
    public void testSizeOfVehicleRegistry() {
        assertEquals(SIZE_OF_REGISTRY_INIT, vehicleRegistry.sizeOfVehicleRegistry());
    }
    
    
}
