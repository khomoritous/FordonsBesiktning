/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.moma.kth.iv1350.model;

/**
 * Skapar ett kvitto på en transaktion.
 * @author monde
 */
public class Receipt {
    
    private int amount;
    /**
     * Skapar en ny instans.
     * @param amount Betald summa.
     */
    public Receipt(int amount) {
       this.amount = amount;
    }
    /**
     * @return En instans av klassen <code>Receipt</code> som används som kvitto
     * vid en transaktion.
     */
    public Receipt getReceipt() {
        return this;
    }
    /**
     * 
     * @return En textsträngrepresentation av instansen.
     */
    @Override
    public String toString() {
        return "You have payed: "+ amount;
    }
}
