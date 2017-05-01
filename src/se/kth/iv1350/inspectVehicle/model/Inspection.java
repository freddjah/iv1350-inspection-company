package se.kth.iv1350.inspectVehicle.model;

/**
 * Created by fredrik on 27/04/17.
 */
public class Inspection {

    private String name;
    private float cost;
    private boolean passedInspection;

    /**
     * Creates a new instance of inspection
     *
     * @param name The name of the inspection as <code>String</code>
     * @param cost The cost of the inspection as <code>float</code>
     */
    public Inspection(String name, float cost) {
        this.name = name;
        this.cost = cost;
        this.passedInspection = false;
    }

    /**
     * Creates an instance of inspection, where you can choose initial state of passedInspection.
     *
     * @param name The name of the inspection as <code>String</code>.
     * @param cost The cost of the inspection as <code>float</code>.
     * @param initialState The initial state of <code>passedInspection</code> as <code>boolean</code>.
     */
    public Inspection(String name, int cost, boolean initialState) {
        this.name = name;
        this.cost = cost;
        this.passedInspection = initialState;
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
        return this.name;
    }

    /**
     * Returns the cost as <code>float</code>
     * @return Returns the cost of the inspection.
     */
    public float getCost() {
        return this.cost;
    }

    public boolean getPassedInspection(){
        return this.passedInspection;
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
