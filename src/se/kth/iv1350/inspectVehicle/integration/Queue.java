package se.kth.iv1350.inspectVehicle.integration;

/**
 * Created by fredrik on 27/04/17.
 */
public class Queue {
    private int currentNumber;

    /**
     * Creates an intance of a queue. Initializes so that the current number is 0.
     */
    public Queue() {
        this.currentNumber = 0;
    }

    /**
     * Retrieves the number of the next customer.
     * @return The number of the next customer as <code>int</code>.
     */
    public int getNextInQueue(){
        this.currentNumber++;
        return this.currentNumber;
    }
}
