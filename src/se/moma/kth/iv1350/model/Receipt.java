/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.moma.kth.iv1350.model;

/**
 * Skapar ett kvitto.
 * @author monde
 */
public class Receipt {
    
    private int amount;
    /**
     * Skapar en ny instans.
     */
    public Receipt(int amount) {
       this.amount = amount;
    }
    /**
     * Getter som används som kvitto vid en transaktion.
     * @return En instans av klassen <code>Receipt</code> 
     */
    public Receipt getReceipt() {
        return this;
    }
    
    @Override
    public String toString() {
        return "You have payed: "+ amount;
    }
}
