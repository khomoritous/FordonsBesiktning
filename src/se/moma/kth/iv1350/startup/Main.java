package se.moma.kth.iv1350.startup;

import java.io.IOException;
import se.moma.kth.iv1350.view.View;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Skapar en exempelkörning av programmet.
 * @author monde
 */
public class Main {
 
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        try {
            new View().sampleExecution();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
       

       
     
   

