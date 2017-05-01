package se.kth.iv1350.inspectVehicle.model;

import java.util.ArrayList;

/**
 * Created by fredrik on 27/04/17.
 */
public class Printout {
    private ArrayList<Inspection> failedInspectionList;
    private ArrayList<Inspection> passedInspectionList;

    /**
     * Creates an instance of printout which is needed for printing out passed and failed inspections.
     * @param failedInspectionList Failed inspections given as <code>ArrayList</code>.
     * @param passedInspectionList Passed inspections given as <code>ArrayList</code>.
     */
    public Printout(ArrayList<Inspection> failedInspectionList, ArrayList<Inspection> passedInspectionList) {
        this.failedInspectionList = failedInspectionList;
        this.passedInspectionList = passedInspectionList;
    }

    /**
     * Returns the failed inspections.
     * @return Returns the failed inspections as <code>ArrayList</code>.
     */
    public ArrayList<Inspection> getFailedInspectionList() {
        return failedInspectionList;
    }

    /**
     * Returns the passed inspections.
     * @return Returns the passed inspections as <code>ArrayList</code>.
     */
    public ArrayList<Inspection> getPassedInspectionList() {
        return passedInspectionList;
    }
}
