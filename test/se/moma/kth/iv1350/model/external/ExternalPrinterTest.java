/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.moma.kth.iv1350.model.external;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import se.moma.kth.iv1350.model.Inspection;

/**
 *
 * @author monde
 */
public class ExternalPrinterTest {
    
    private static final int INSPECTION_COST = 100;
    private ByteArrayOutputStream outContent = null;
    private String result = null;
    private String expResult = null;
    private Inspection inspection = null;
    private ExternalPrinter externalPrinter = null;
    
    
    @Before
    public void setUp() {
        inspection =  new Inspection(INSPECTION_COST);
        externalPrinter = new ExternalPrinter(inspection);
        outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        
    }

    @Test
    public void testPrint() {
        
        
        externalPrinter.print();
        
        expResult = "The result of the inspection: "+ inspection.getResult();
        result = outContent.toString();
        assertTrue("No inspection result!", result.contains(expResult));
        
    }
    
}
