package se.kth.iv1350.inspectVehicle.model;

/**
 * Created by fredrik on 27/04/17.
 */
public class Inspection {

    private final String name;
    private final int cost;
    private boolean passedInspection;

    /**
     * Creates a new instance of inspection
     *
     * @param name The name of the inspection
     * @param cost The cost of the inspection
     */
    public Inspection(String name, int cost) {
        this.name = name;
        this.cost = cost;
        this.passedInspection = false;
    }

    /**
     * The inspection has passed the inspection.
     */
    public void setPassedInspection() {
        this.passedInspection = true;
    }

    /**
     * Returns the name of the inspection as <code>String</code>
     * @return Returns the name of the inspection.
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the cost as <code>float</code>
     * @return Returns the cost of the inspection.
     */
    public int getCost() {
        return cost;
    }

    /**
     * Copies the inspection and returns a new <code>Inspection</code>.
     * @return Returns the copy of the inspection.
     */
    public Inspection copy(){
        Inspection copiedInspection = new Inspection(this.getName(), this.getCost());
        copiedInspection.passedInspection = this.passedInspection;
        return copiedInspection;
    }

}
