/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.moma.kth.iv1350.util.exception;

/**
 * Kastas då ett mer användarvänligt meddelande behövs.
 * @author monde
 */
public class OperationFailedException extends Exception {
    
    /**
     * Skapar en ny instans.
     * @param message Meddelande till användaren.
     * @param cause Instans av <code>Throwable</code> som kastas.
     */
    public OperationFailedException(String message, Throwable cause) {
        super(message, cause);
    }
    
    
    
    
}
