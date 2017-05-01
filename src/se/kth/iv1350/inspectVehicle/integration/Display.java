package se.kth.iv1350.inspectVehicle.integration;

/**
 * Created by fredrik on 27/04/17.
 */
public class Display {
    private int numberToDisplay;

    /**
     * Creates an instance of Display.
     */
    public Display() {
        this.numberToDisplay = 0;
    }

    /**
     * Sets the <code>numberToDisplay</code> to a number of choice.
     * @param number A number given as <code>int</code>.
     */
    public void setNumberToDisplay(int number) {
        this.numberToDisplay = number;
    }

    /**
     * Returns the current number to display as an <code>int</code>.
     * @return Returns the number to display.
     */
    public int getNumberToDisplay(){
        return this.numberToDisplay;
    }
}
