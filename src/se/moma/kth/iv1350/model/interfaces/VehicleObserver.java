/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.moma.kth.iv1350.model.interfaces;

import se.moma.kth.iv1350.model.Inspection;

/**
 * Ett lyssnarinterface som implementeras av klasser intresserade av färdiga inspektioner.
 * Objekt av den klassen registrerar sig med <code>addVehicleObserver</code>. När en inspektion har uförts anropas
 * objektets <code>newInspection</code> metod.
 * 
 * @author monde
 */
public interface VehicleObserver {
    
    /**
     * Anropas när en inspektion har utförts.
     * @param inspection Instans av <code>Inspection</code> som är inspekterad.
     */
    void newInspection(Inspection inspection); // Skickar en inspektion men kan bryta inkapsling och kan behöva skicka endast en textsträng.
}
