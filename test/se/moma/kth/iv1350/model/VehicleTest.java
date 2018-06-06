/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.moma.kth.iv1350.model;

import se.moma.kth.iv1350.model.external.ExternalPrinter;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import se.moma.kth.iv1350.dbhandler.VehicleRegistry;
import se.moma.kth.iv1350.model.exception.InspectionException;

/**
 *
 * @author monde
 */
public class VehicleTest {
    
    private Vehicle vehicle = null;
    private Inspection inspection = null;
    private ByteArrayOutputStream outContent = null;
    //private PrintStream originalSysOut = null;
    private ExternalPrinter printer = null;
    private String expResult = null;
    private String result = null;
    private VehicleRegistry vehicleRegistry = null;
    private static final String INSPECTION_RESULT = "PASS";
    private static final int INSPECTION_COST = 100;
    private static final int VEHICLE_NUMBER = 10;
    private static final int VEHICLE_NUMBER_WITH_NO_INSPECTION = 20;
    
   
    @Before
    public void setUp() {
        inspection = new Inspection(INSPECTION_COST);
        vehicle = new Vehicle(VEHICLE_NUMBER, inspection);
    }
    
    @After
    public void cleanUpStreams() {
        outContent = null;
    }

    @Test
    public void testGetVehicleInspectionCost() throws InspectionException {
       assertEquals(INSPECTION_COST, vehicle.getVehicleInspectionCost());
    }
 
    @Test
    public void testGetVehicle() {
       assertNotNull(vehicle.getVehicleInstance());
    }
 
    @Test
    public void testGetVehicleNumber() {
        assertEquals(VEHICLE_NUMBER, vehicle.getVehicleNumber());
    }

    @Test
    public void testGetVehicleInspection() throws InspectionException  {
         assertNotNull(vehicle.getVehicleInspection());
    }
  
    @Test
    public void testPrintVehicleInspectionResult() throws InspectionException {
        outContent = new ByteArrayOutputStream();
        
        System.setOut(new PrintStream(outContent));
        
        vehicle.resultOfInspection(INSPECTION_RESULT);
        expResult = "The result of the inspection: " + inspection.getResult();
        printer = new ExternalPrinter(vehicle.getVehicleInspection());
        printer.print();
        result = outContent.toString();
        
        assertTrue("Wrong printout",result.contains(expResult));
        
    }
    
    @Test
    public void testResultOfInspection() throws InspectionException {
        vehicle.resultOfInspection(INSPECTION_RESULT);
        assertEquals(INSPECTION_RESULT,vehicle.getVehicleInspection().getResult());
    }
    
    
    @Test
    public void testEqualsMethod() {
        Vehicle vehicle_two = new Vehicle(VEHICLE_NUMBER, inspection);
        assertTrue("Different vehicles!", vehicle_two.equals(vehicle));
    }
    
    @Test
    public void testHashMethod() {
       Vehicle vehicle_two = new Vehicle(VEHICLE_NUMBER, inspection);
       assertNotSame("Its not the same vehicle!",vehicle_two, vehicle);
    }
    
    @Test
    public void testGetVehicleWithNoInspection() {
        vehicleRegistry = new VehicleRegistry();
        try {
            vehicleRegistry.findVehicleInspectionCost(VEHICLE_NUMBER_WITH_NO_INSPECTION);
            fail("Could get inspection from vehicle with no inspections!");
        } catch (InspectionException ex) {
            assertTrue("Wrong exception message!", ex.getMessage().contains(ex.getVehicleWithNoInspections().toString()));
        }
        
        
        
    }
}
