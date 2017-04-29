package se.kth.iv1350.inspectVehicle.integration;

/**
 * Created by fredrik on 27/04/17.
 */
public class QueueHandler {
    private Queue queue;
    private Display display;

    public QueueHandler(Queue queue, Display display) {
        this.queue = queue;
        this.display = display;
    }

    public void nextCustomer(){
        display.setNumberToDisplay(queue.getNextInQueue());
    }

}
