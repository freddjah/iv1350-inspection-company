package se.kth.iv1350.inspectVehicle.integration;

/**
 * Created by fredrik on 27/04/17.
 */
public class GarageDoor {
    private boolean isOpen;

    public GarageDoor(){

    }

    public void openDoor(){
        this.isOpen = true;
    }

    public void closeDoor(){
        this.isOpen = false;
    }
}
