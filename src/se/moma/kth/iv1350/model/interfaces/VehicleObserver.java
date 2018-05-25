/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.moma.kth.iv1350.model.interfaces;

/**
 * Ett lyssnarinterface för klasser som är intresserade av att bli notifierade vid resultat från 
 * en <code>Inspection</code> efter en besiktning av <code>Vehicle</code>.
 * @author monde
 */
public interface VehicleObserver {
    
    void newInspection(String result);
    
}
