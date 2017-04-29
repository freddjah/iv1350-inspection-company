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

    private Inspection currentInspection;
    private Iterator<Inspection> iterator;

     /**
     * Creates a new instance. An InspectionHandler is used for iterating the inspection and fetching what inspection the inspector should perform.
     *
     * @param inspectionList The list to handle.
     *
     */
    public InspectionHandler(ArrayList<Inspection> inspectionList){
        this.iterator = inspectionList.listIterator();
        this.currentInspection = iterator.next();

        while(this.currentInspection.getPassedInspection()) {
            this.currentInspection = iterator.next();

            if (allInspectionsHasBeenPerformed())
                this.currentInspection = null;
        }
    }

    /**
    * Fetches the current inspection that should be performed.
    *
    * @return The inspection to perform.
    *
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

        if (inspectionPassed)
            currentInspection.setPassedInspection();

        currentInspection = getNextInspectionInList();

    }

    /**
     * Returns the next inspection (if there are more to do and the next inspection needs to be performed).
     *
     * @return The next <code>Inspection</code>.
     */
    private Inspection getNextInspectionInList(){

        while (!allInspectionsHasBeenPerformed()){
            Inspection nextInspection = iterator.next();

            if (!nextInspection.getPassedInspection()){
                return nextInspection;
            }
        }

        if (this.currentInspection.getPassedInspection() && allInspectionsHasBeenPerformed())
            return null;

        return null;
    }

    /**
     * Checks if there is more inspections in the list.
     *
     * @return <code>true</code> if there is more inspections, else <code>false</code>.
     */
    private boolean allInspectionsHasBeenPerformed(){
        if (iterator.hasNext())
            return false;
        else
            return true;
    }

}
