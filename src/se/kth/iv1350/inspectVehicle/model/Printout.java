package se.kth.iv1350.inspectVehicle.model;

import java.util.ArrayList;

/**
 * Created by fredrik on 27/04/17.
 */
public class Printout {
    private ArrayList<Inspection> failedInspectionList;
    private ArrayList<Inspection> passedInspectionList;

    public Printout(ArrayList<Inspection> failedInspectionList, ArrayList<Inspection> passedInspectionList) {
        this.failedInspectionList = failedInspectionList;
        this.passedInspectionList = passedInspectionList;
    }

    public ArrayList<Inspection> getFailedInspectionList() {
        return failedInspectionList;
    }

    public ArrayList<Inspection> getPassedInspectionList() {
        return passedInspectionList;
    }
}
