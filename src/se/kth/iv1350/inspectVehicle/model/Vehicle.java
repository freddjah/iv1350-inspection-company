package se.kth.iv1350.inspectVehicle.model;

import java.util.ArrayList;

/**
 * Created by fredrik on 27/04/17.
 */
public class Vehicle {
    private String regNumber;
    private ArrayList<Inspection> inspectionList;

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

    /**
     * Returns the <code>ArrayList</code> of <code>Inspection</code> from this object.
     *
     * @return Returns a list of inspections.
     */

    public ArrayList<Inspection> getInspectionList(){
        return this.inspectionList;
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
        ArrayList<Inspection> arrayListCopy = new ArrayList<>();
        for (Inspection inspection : this.getInspectionList())
            arrayListCopy.add(inspection.copy());
        return new Vehicle(this.getRegNumber(), arrayListCopy);
    }
}
