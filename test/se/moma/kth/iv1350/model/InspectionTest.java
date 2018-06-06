/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.moma.kth.iv1350.model;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author monde
 */
public class InspectionTest {
    
    private Inspection inspection = null;
    private ByteArrayOutputStream outContent = null;
    private String expResult = null;
    private String result = null;
    private static final int COST = 200;
    
    @Before
    public void setUp() {
        inspection = new Inspection(COST);
    }

    @Test
    public void testGetInspectionCost() {
        inspection.getInspectionCost();
        assertEquals(COST, inspection.getInspectionCost());
    }

    @Test
    public void testGetInspection() {
        assertNotNull(inspection.getInspectionInstance());
    }

    @Test
    public void testSetResultOfInspection() {
        inspection.setResultOfInspection("PASS");
        assertEquals("PASS", inspection.getResult());
        inspection.setResultOfInspection("FAIL");
        assertEquals("FAIL", inspection.getResult());
    }

    @Test
    public void testGetResult() {
        inspection.setResultOfInspection("PASS");
        assertEquals("PASS", inspection.getResult());
    }

    @Test
    public void testPrintInspectionResult() {
        outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        
        inspection.setResultOfInspection("PASS");
        expResult = "The result of the inspection: " + inspection.getResult();
        inspection.printInspectionResult();
        result = outContent.toString();
        assertTrue("Not printing", result.contains(expResult));
    }

    @Test
    public void testToString() {
        assertEquals("Inspections to perform....", inspection.toString());
    }
    
}
