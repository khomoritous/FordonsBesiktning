/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.moma.kth.iv1350.controller;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import se.moma.kth.iv1350.dbhandler.VehicleRegistry;
import se.moma.kth.iv1350.model.external.CustomerQueue;
import se.moma.kth.iv1350.model.external.Garage;
import se.moma.kth.iv1350.model.external.GarageDoor;

/**
 *
 * @author monde
 */
public class ControllerTest {
    
    private Controller controller = null;
   
    
    @Before
    public void setUp() {
        controller = new Controller(new Garage(new GarageDoor(), new CustomerQueue()), new VehicleRegistry());
    }

    @Test
    public void testInspectNewVehicle() {
       
    }

    @Test
    public void testCloseGarage() {
    }

    @Test
    public void testRegisterNumber() {
    }

    @Test
    public void testPay() {
    }

    @Test
    public void testInspectVehicle() {
    }

    @Test
    public void testEnterResultOfInspection() {
    }

    @Test
    public void testPrintResult() {
    }

    @Test
    public void testOpenGarage() {
    }
    
}
