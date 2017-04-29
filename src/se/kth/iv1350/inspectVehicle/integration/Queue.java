package se.kth.iv1350.inspectVehicle.integration;

/**
 * Created by fredrik on 27/04/17.
 */
public class Queue {
    private int currentNumber;

    public Queue() {
        this.currentNumber = 0;
    }

    public int getNextInQueue(){
        this.currentNumber++;
        return this.currentNumber;
    }
}
