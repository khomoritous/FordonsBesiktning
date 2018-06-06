/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.moma.kth.iv1350.model;

import se.moma.kth.iv1350.model.exception.InspectionException;

/**
 * Skapar ett <code>Vehicle</code> med registreringsnummer och <code>Inspection</code>.
 * @author monde
 */
public class Vehicle {
    
    private final int vehicleRegistrationNumber;//instansvariabel
    private Inspection inspection = null;//instansvariabel
    
    /**
     * Skapar en ny instans.
     * @param vehicleRegistrationNumber Registreringsnummer för <code>Vehicle</code>.
     * @param inspection Instans av <code>Inspection</code> som ska utföras på <code>Vehicle</code>.
     */
    public Vehicle(int vehicleRegistrationNumber, Inspection inspection) {
        this.vehicleRegistrationNumber  = vehicleRegistrationNumber;
        this.inspection  = inspection;
    }
    /**
     * @return Kostnad för <code>Inspection</code> som hör till <code>Vehicle</code>.
     * @throws se.moma.kth.iv1350.model.exception.InspectionException Kastas då ingen 
     * <code>Inspection</code> hittats för <code>Vehicle</code>.
     */
    public int getVehicleInspectionCost() throws InspectionException {
        return getVehicleInspection().getInspectionCost();
    }
    /**
     * @return En instans av <code>Vehicle</code>.
     */
    public Vehicle getVehicleInstance() {
        return this;
    }
    /**
     * @return <code>Vehicle</code> registreringsnummer.
     */
    public int getVehicleNumber() {
        return vehicleRegistrationNumber;
    }
    /**
     * @return En instans av <code> Inspection</code> som 
     * hör till <code>Vehicle</code>.
     * @throws se.moma.kth.iv1350.model.exception.InspectionException Kastas då ingen <code>Inspection<U/code>
     * hittats för <code>Vehicle</code>.
     */
    public Inspection getVehicleInspection() throws InspectionException {
        if(inspection == null) {
            throw new InspectionException(this);
        }else {
            return inspection.getInspectionInstance();
        }
    }
   
    /**
     * Utskrift av resultat vid <code>Inspection</code> av <code>Vehicle</code>.
     * @throws InspectionException Kastas då ingen <code>Inspection</code> för 
     * <code>Vehicle</code>hittats.
     */
    public void printVehicleInspectionResult() throws InspectionException {
        getVehicleInspection().printInspectionResult();
    }
    
    /**
     * @param result Ange resultat vid <code>Inspection</code> av <code>Vehicle</code>.
     * @throws se.moma.kth.iv1350.model.exception.InspectionException Kastas då ingen 
     * <code>Inspection</code> för <code>Vehicle</code> hittats.
     */
    public void resultOfInspection(String result) throws InspectionException {
        getVehicleInspection().setResultOfInspection(result);
    }
    
    /**
     * 
     * @return Hashkod för en instans av <code>Vehicle</code>.
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.vehicleRegistrationNumber;
        return hash;
    }
    /**
     * Testar likhet för två <code>Vehicle</code> med avseende på registreringsnummer.
     * @param obj En instans av <code>Vehicle</code>
     * @return <code>True</code>, om två instanser av <code>Vehicle</code> är lika, annars
     * <code>false</code>.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Vehicle other = (Vehicle) obj;
        if (this.vehicleRegistrationNumber != other.vehicleRegistrationNumber) {
            return false;
        }
        return true;
    }

    
    
    /**
     * 
     * @return Ett <code>Vehicle</code> på strängformat.
     */
    @Override
    public String toString() {
        return "" + vehicleRegistrationNumber; 
    }
    
}
