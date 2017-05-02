package se.kth.iv1350.inspectVehicle.integration;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by fredrik on 02/05/17.
 */
class QueueHandlerTest {
    private QueueHandler queueHandler;
    private Queue queue;
    private Display display;

    @BeforeEach
    void setUp() {
        queue = new Queue();
        display = new Display();
        queueHandler = new QueueHandler(queue, display);
    }

    @AfterEach
    void tearDown() {
        queue = null;
        display = null;
        queueHandler = null;
    }

    @Test
    void nextCustomer() {
        queueHandler.nextCustomer();
        assertEquals(1, display.getNumberToDisplay());
    }

}