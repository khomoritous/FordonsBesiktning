/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.moma.kth.iv1350;

/**
 * Skapar ett kvitto.
 * @author monde
 */
class Receipt {
    
    private int amount;
    /**
     * Skapar en ny instans.
     */
    public Receipt() {
       
    }
    /**
     * Getter
     * @return Ett kvitto.
     */
    public Receipt getReceipt() {
        return this;
    }
    
    @Override
    public String toString() {
        return "You have payed: ....";
    }
}
