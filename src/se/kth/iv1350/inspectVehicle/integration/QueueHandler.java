package se.kth.iv1350.inspectVehicle.integration;

/**
 * Created by fredrik on 27/04/17.
 */
public class QueueHandler {
    private Queue queue;
    private Display display;

    /**
     * Creates an instance of queue handler which handles a queue.
     * @param queue A queue given as <code>Queue</code>.
     * @param display A display given as <code>Display</code>.
     */
    public QueueHandler(Queue queue, Display display) {
        this.queue = queue;
        this.display = display;
    }

    /**
     * Sets the display to display the next number of the next customer in line.
     */
    public void nextCustomer(){
        display.setNumberToDisplay(queue.getNextInQueue());
    }

}
