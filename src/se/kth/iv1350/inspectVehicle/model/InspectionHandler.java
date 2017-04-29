package se.kth.iv1350.inspectVehicle.model;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by fredrik on 28/04/17.
 *
 * Represents an InspectionHandler. An InspectionHandler is used for iterating the inspection and fetching what inspection the inspector should perform.
 *
 */
public class InspectionHandler {

    private ArrayList<Inspection> failedInspectionList;
    private ArrayList<Inspection> passedInspectionList;

    private Inspection currentInspection;
    private Iterator<Inspection> iterator;

     /**
     * Creates a new instance. An InspectionHandler is used for iterating the inspection and fetching what inspection the inspector should perform.
     *
     * @param failedInspectionList <code>ArrayList</code> of inspections that should be performed.
     * @param passedInspectionList <code>ArrayList</code> of passed inspections.
     */

    public InspectionHandler(ArrayList<Inspection> failedInspectionList, ArrayList<Inspection> passedInspectionList){
        this.failedInspectionList = failedInspectionList;
        this.passedInspectionList = passedInspectionList;
        this.iterator = failedInspectionList.listIterator();
        this.currentInspection = this.iterator.next();
    }

    /**
    * Fetches the current inspection that should be performed.
    *
    * @return The inspection to perform.
    */
    public Inspection getCurrentInspection(){
        return this.currentInspection;
    }

    /**
     * Sets the result of the inspection.
     *
     * @param inspectionPassed <code>true</code> if vehicle passed inspection.
     */
    public void setInspectionPassed(boolean inspectionPassed){

        if (inspectionPassed) {
            addCurrentInspectionToPassedInspections();
            this.iterator.remove();
        }

        this.currentInspection = getNextInspectionInList();

    }

    /**
     * Returns the next inspection (if there are more to do and the next inspection needs to be performed).
     *
     * @return The next <code>Inspection</code>.
     */
    private Inspection getNextInspectionInList(){

        if (isLastInspection())
            return null;

        return this.iterator.next();
    }

    /**
     * Checks if there is more inspections in the list.
     *
     * @return <code>true</code> if there is more inspections, else <code>false</code>.
     */
    private boolean isLastInspection(){
        if (this.iterator.hasNext())
            return false;
        else
            return true;
    }

    /**
     * Adds the current inspection to the passedInspectionList of the <code>InspectionHandler</code>.
     */
    private void addCurrentInspectionToPassedInspections(){
        this.currentInspection.setPassedInspection();
        this.passedInspectionList.add(this.currentInspection);
    }

}
