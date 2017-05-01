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
     * @param regNumber The registration number of the car as <code>String</code>.
     * @param failedInspectionList A list of failed inspections on the vehicle as <code>ArrayList</code>.
     * @param passedInspectionList A list of passed inspections on the vehicle as <code>ArrayList</code>.
     */

    public Vehicle(String regNumber, ArrayList<Inspection> failedInspectionList, ArrayList<Inspection> passedInspectionList){
        this.regNumber = regNumber;
        this.failedInspectionList = failedInspectionList;
        this.passedInspectionList = passedInspectionList;
    }

    /**
     * Returns the failed inspecions of the vehicle as <code>ArrayList</code>
     * @return The failed inspections as <code>ArrayList</code>
     */
    public ArrayList<Inspection> getFailedInspectionList() {
        return this.failedInspectionList;
    }

    /**
     * Returns the passed inspections of the vehicle as <code>ArrayList</code>
     * @return The passed inspections as <code>ArrayList</code>
     */
    public ArrayList<Inspection> getPassedInspectionList(){
        return this.passedInspectionList;
    }

    public void updateFailedInspectionList(ArrayList<Inspection> failedInspectionList){
        this.failedInspectionList = failedInspectionList;
    }

    /**
     * Updates the <code>ArrayList</code> of passed inspections of the vehicle.
     * @param passedInspectionList A list of passed inspections given as <code>ArrayList</code>
     */
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
