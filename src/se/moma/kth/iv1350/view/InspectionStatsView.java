/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.moma.kth.iv1350.view;

import java.util.ArrayList;
import java.util.List;
import se.moma.kth.iv1350.model.Inspection;
import moma.se.kth.iv1350.util.VehicleObserver;

/**
 * Skapar en display som visar antal <code>Inspection</code> som är utförda.
 * @author monde
 */
public class InspectionStatsView implements VehicleObserver {
    
    
    private List<String> passedInspections = null;
    private List<String> failedInspections = null;
    
    /**
     * Skapar en ny instans.
     */
    public InspectionStatsView() {
        passedInspections = new ArrayList<>();
        failedInspections = new ArrayList<>();
    }
    
    @Override
    public void newInspection(Inspection inspection) {
        if(inspection.getResult().equals("Pass")) {
            addNewPassedInspection(inspection);
        }else {
            addNewFailedInspection(inspection);
        }
        
     printCurrenState();
    }
    
    private void addNewPassedInspection(Inspection inspection) {
      passedInspections.add(inspection.getResult());
    }
    private void addNewFailedInspection(Inspection inspection) {
        failedInspections.add(inspection.getResult());
    }
    
    private void printCurrenState() {
        System.out.println("### We have now completed ###");
        System.out.print(passedInspections.size()+ " passed");
        System.out.println(" and "+failedInspections.size()+ " failed inspections.");
        System.out.println("######################################################");
       
    }

    
}
