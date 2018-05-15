/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.moma.kth.iv1350.dbhandler.exception;

/**
 * Kastas vid nekad åtkomst till <code>VehicleRegistry</code>.
 * @author monde
 */
public class VehicleRegistryException extends RuntimeException {
    /**
     * Skapar en ny instans.
     * @param message Felmeddelande vid undantag.
     */
    public VehicleRegistryException(String message) {
        super(message);
    }
    
    
}

