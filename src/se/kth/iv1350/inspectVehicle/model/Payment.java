package se.kth.iv1350.inspectVehicle.model;

import java.util.ArrayList;

/**
 * Created by fredrik on 27/04/17.
 */
public class Payment {

    private int totalCost;
    private ArrayList<Inspection> inspectionsToPayFor = new ArrayList<>();

    /**
     * Creates an instance of payment.
     *
     * @param failedInspectionList An <code>ArrayList</code> of <code>Inspection</code> that should be performed.
     */
    public Payment(ArrayList<Inspection> failedInspectionList){
        for (Inspection inspection : failedInspectionList){
            this.inspectionsToPayFor.add(inspection);
            this.totalCost += inspection.getCost();
        }
    }

    /**
     * Returns the total cost of the payment.
     *
     * @return The cost.
     */
    public int getTotalCost(){
        return this.totalCost;
    }

    /**
     * Returns an <code>ArrayList</code> of <code>Inspection</code> that needs to be paid for.
     *
     * @return The list that needs to be paid for.
     */
    public ArrayList<Inspection> getInspectionsToPayFor(){
        return this.inspectionsToPayFor;
    }

}
