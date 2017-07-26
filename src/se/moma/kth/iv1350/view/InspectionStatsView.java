/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.moma.kth.iv1350.view;

import java.util.ArrayList;
import java.util.List;
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
    public void newInspection(String inspectionResult) {
        
        if(inspectionResult.equals("Pass")) {
            addNewPassedInspection(inspectionResult);
        } else {
            addNewFailedInspection(inspectionResult);
        }
     printCurrenState();
    }
    
    private void addNewPassedInspection(String passedInspection) {
      passedInspections.add(passedInspection);
    }
    
    private void addNewFailedInspection(String failedInspection) {
      failedInspections.add(failedInspection);
    }
    
    private void printCurrenState() {
        System.out.println("### We have now completed ###");
        System.out.print(passedInspections.size()+ " passed");
        System.out.println(" and "+failedInspections.size()+ " failed inspections.");
        System.out.println("######################################################");
       
    }

    
}
