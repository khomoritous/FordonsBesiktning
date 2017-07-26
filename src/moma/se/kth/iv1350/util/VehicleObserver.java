/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moma.se.kth.iv1350.util;

/**
 * Ett interface som implementeras av klasser intresserade av att bevaka färdiga <code>Inspection</code>.
 * Objekt av den klassen registrerar sig med <code>addVehicleObserver</code>. När en <code>Inspection</code> har uförts anropas
 * objektets <code>newInspection</code> metod.
 * 
 * @author monde
 */
public interface VehicleObserver {
    
    /**
     * Anropas när en inspektion har utförts.
     * @param inspectionResult Resultat av en <code>Inspection</code>.
     */
    void newInspection(String inspectionResult); 
}
