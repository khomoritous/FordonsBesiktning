package se.moma.kth.iv1350;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


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
import se.moma.kth.iv1350.model.exceptions.InspectionNotFoundException;

/**
 *
 * @author monde
 */
public class VehicleTest {
    
    private Vehicle vehicle = null;
    private Inspection inspection = null;
    private ByteArrayOutputStream outContent = null;
    private PrintStream originalSysOut = null;
    private static final int INSPECTION_COST = 100;
    private static final int VEHICLE_NUMBER = 10;
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        inspection = new Inspection(INSPECTION_COST);
        vehicle = new Vehicle(VEHICLE_NUMBER, inspection);
    }
    
    @After
    public void cleanUpStreams() {
        outContent = null;
        System.setOut(originalSysOut);

    }

    @Test
    public void testGetVehicleInspectionCost() {
        int expResult = 100;
        int result = vehicle.getVehicleInspectionCost();
        assertEquals(expResult, result);
        
    }
 
    @Test
    public void testGetVehicle() {
        Vehicle result = vehicle.getVehicle();
        assertNotNull(result);
    }
 
    @Test
    public void testGetVehicleNumber() {
        int expResult = 10;
        int result = vehicle.getVehicleNumber();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetVehicleInspection() throws InspectionNotFoundException {
         assertNotNull(vehicle.getVehicleInspection());
    }
  
    @Test
    public void testPrintVehicleInspectionResult() throws InspectionNotFoundException {
        outContent = new ByteArrayOutputStream();
        originalSysOut = System.out;
        
        System.setOut(new PrintStream(outContent));
        
        vehicle.resultOfInspection("Pass");
        String expResult = "The result of the inspection: " + inspection.getResult();
        ExternalPrinter printer = new ExternalPrinter(vehicle.getVehicleInspection());
        printer.print();
        String result = outContent.toString();
        
        assertTrue("Wrong printout",result.contains(expResult));
        
    }
    
    @Test
    public void testResultOfInspection() throws InspectionNotFoundException {
        vehicle.resultOfInspection("Pass");
        String expResult = "Pass";
        String result = vehicle.getVehicleInspection().getResult();
        assertEquals(expResult,result);
    }
    
}
