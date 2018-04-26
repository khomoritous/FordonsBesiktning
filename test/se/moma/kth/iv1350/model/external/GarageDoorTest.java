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

/**
 *
 * @author monde
 */
public class GarageDoorTest {
    
     
     ByteArrayOutputStream outContent = null;
     GarageDoor garageDoor = null;
     
    @After
    public void cleanUpStreams() {
       outContent = null;
        

    }
    @Test
    public void testCloseDoor() {
        
        outContent = new ByteArrayOutputStream();
       
        System.setOut(new PrintStream(outContent));
        
        garageDoor = new GarageDoor();
        garageDoor.closeDoor();
        String expResult = "Closing garage door...";
        String result = outContent.toString();
        assertTrue("Garage Door not closing",result.contains(expResult));
        
    }

    @Test
    public void testOpenDoor() {
        outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        
        garageDoor = new GarageDoor();
        garageDoor.openDoor();
        String expResult = "Opening garage door...";
        String result = outContent.toString();
        assertTrue("Garage Door not opening",result.contains(expResult));
    }
    
}
