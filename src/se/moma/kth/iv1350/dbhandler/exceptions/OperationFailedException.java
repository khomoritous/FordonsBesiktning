/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.moma.kth.iv1350.dbhandler.exceptions;

/**
 * Kastas vid nekad åtkomst till <code>VehicleRegistry</code> av någon anledning.
 * @author monde
 */
public class OperationFailedException extends Exception {

    public OperationFailedException(String message, Throwable cause) {
        super(message, cause);
    }
    
}
