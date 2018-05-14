/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.moma.kth.iv1350.model;

import se.moma.kth.iv1350.model.Vehicle;
import se.moma.kth.iv1350.model.external.ExternalPrinter;
import se.moma.kth.iv1350.model.Inspection;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

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
    private static final String INSPECTION_RESULT = "PASS";
    private static final int INSPECTION_COST = 100;
    private static final int VEHICLE_NUMBER = 10;
    
   
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
    public void testGetVehicleInspectionCost() {
       assertEquals(INSPECTION_COST, vehicle.getVehicleInspectionCost());
    }
 
    @Test
    public void testGetVehicle() {
       assertNotNull(vehicle.getVehicle());
    }
 
    @Test
    public void testGetVehicleNumber() {
        assertEquals(VEHICLE_NUMBER, vehicle.getVehicleNumber());
    }

    @Test
    public void testGetVehicleInspection() {
         assertNotNull(vehicle.getVehicleInspection());
    }
  
    @Test
    public void testPrintVehicleInspectionResult() {
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
    public void testResultOfInspection() {
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
}
