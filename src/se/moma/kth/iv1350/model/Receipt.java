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
    
    private final int amount;
    /**
     * Skapar en ny instans.
     * @param amount Betald summa.
     */
    public Receipt(int amount) {
       this.amount = amount;
    }
    /**
     * @return En instans av <code>Receipt</code> som används 
     * vid en transaktion.
     */
    public Receipt getReceiptInstance() {
        return this;
    }
    /**
     * @return En textsträngrepresentation av instansen <code>Receipt</code>.
     */
    @Override
    public String toString() {
        return "You have payed: "+ amount;
    }
}
