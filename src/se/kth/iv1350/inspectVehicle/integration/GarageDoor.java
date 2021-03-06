package se.kth.iv1350.inspectVehicle.integration;

/**
 * Created by fredrik on 27/04/17.
 */
public class GarageDoor {
    private boolean isOpen;

    /**
     * Creates an instance of a garage door. Sets the initial state as closed.
     */
    public GarageDoor(){
        this.isOpen = false;
    }

    /**
     * Opens the garage door by setting the internal value isOpen to <code>true</code>.
     */
    public void openDoor(){
        this.isOpen = true;
    }

    /**
     * Closes the garage door by setting the internal value isOpen to <code>false</code>.
     */
    public void closeDoor(){
        this.isOpen = false;
    }

    /**
     * Returns the current state of the door
     * @return Returns state of door with a <code>boolean</code>, <code>true</code> if open and <code>false</code> if closed.
     */
    public boolean getCurrentState(){
        return this.isOpen;
    }
}
