/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.moma.kth.iv1350.model.external;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 * @author monde
 */
public class GarageDoorTest {
    
     
     ByteArrayOutputStream outContent = null;
     GarageDoor garageDoor = null;
     String result = null;
     String expResult = null;
     
    @Before
    public void setUp() {
        outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        garageDoor = new GarageDoor();
    }
     
    @After
    public void cleanUpStreams() {
       outContent = null;
    }
    
    @Test
    public void testCloseDoor() {
        garageDoor.closeDoor();
        expResult = "Closing garage door...";
        result = outContent.toString();
        assertTrue("Garage door not closing",result.contains(expResult));
    }

    @Test
    public void testOpenDoor() {
        garageDoor.openDoor();
        expResult = "Opening garage door...";
        result = outContent.toString();
        assertTrue("Garage door not opening",result.contains(expResult));
    }
    
}
