package se.kth.iv1350.inspectVehicle.integration;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by fredrik on 02/05/17.
 */
class GarageDoorTest {
    private GarageDoor garageDoor;

    @BeforeEach
    void setUp() {
        garageDoor = new GarageDoor();
    }

    @AfterEach
    void tearDown() {
        garageDoor = null;
    }

    @Test
    void openDoor() {
        garageDoor.openDoor();
        assertEquals(true, garageDoor.getCurrentState());
    }

    @Test
    void closeDoor() {
        garageDoor.closeDoor();
        assertEquals(false, garageDoor.getCurrentState());
    }

    @Test
    void getCurrentState() {
        // Tested above
    }

}