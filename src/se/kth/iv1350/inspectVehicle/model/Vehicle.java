package se.kth.iv1350.inspectVehicle.model;

import java.util.ArrayList;

/**
 * Created by fredrik on 27/04/17.
 */
public class Vehicle {
    private String regNumber;
    private ArrayList<Inspection> inspectionList;
    private ArrayList<Inspection> failedInspectionList;
    private ArrayList<Inspection> passedInspectionList;

    /**
     * Creates and instance of a vehicle.
     *
     * @param regNumber The registration number of the car.
     * @param inspectionList A list of inspections.
     */

    public Vehicle(String regNumber, ArrayList<Inspection> inspectionList) {
        this.regNumber = regNumber;
        this.inspectionList = inspectionList;
    }

    public Vehicle(String regNumber, ArrayList<Inspection> failedInspectionList, ArrayList<Inspection> passedInspectionList){
        this.regNumber = regNumber;
        this.failedInspectionList = failedInspectionList;
        this.passedInspectionList = passedInspectionList;
    }

    /**
     * Returns the <code>ArrayList</code> of <code>Inspection</code> from this object.
     *
     * @return Returns a list of inspections.
     */

    public ArrayList<Inspection> getInspectionList(){
        return this.inspectionList;
    }

    public ArrayList<Inspection> getFailedInspectionList() {
        return this.failedInspectionList;
    }

    public ArrayList<Inspection> getPassedInspectionList(){
        return this.passedInspectionList;
    }

    public void updateFailedInspectionList(ArrayList<Inspection> failedInspectionList){
        this.failedInspectionList = failedInspectionList;
    }

    public void updatePassedInspectionList(ArrayList<Inspection> passedInspectionList){
        this.passedInspectionList = passedInspectionList;
    }

    /**
     * Returns the registration number as <code>String</code> from this object.
     *
     * @return Returns the registration number
     */

    public String getRegNumber(){
        return this.regNumber;
    }

    /**
     * Updates the <code>ArrayList</code> of <code>Inspections</code> in this instance.
     *
     * @param performedInspectionList The <code>ArrayList</code> of performed inspections.
     */

    public void updateInspectionList(ArrayList<Inspection> performedInspectionList){
        this.inspectionList = performedInspectionList;
    }

    /**
     * Makes a copy of the vehicle instance and returns a new instance of <code>Vehicle</code>.
     *
     * @return Returns a copy of the vehicle.
     */

    public Vehicle copy(){
        ArrayList<Inspection> failedInspectionListCopy = new ArrayList<>();
        ArrayList<Inspection> passedInspectionListCopy = new ArrayList<>();

        for (Inspection inspection : this.getFailedInspectionList())
            failedInspectionListCopy.add(inspection.copy());
        for (Inspection inspection : this.getPassedInspectionList())
            passedInspectionListCopy.add(inspection.copy());

        return new Vehicle(this.getRegNumber(), failedInspectionListCopy, passedInspectionListCopy);
    }
}
