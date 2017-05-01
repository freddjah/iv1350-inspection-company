package se.kth.iv1350.inspectVehicle.integration;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by fredrik on 29/04/17.
 */
class DisplayTest {
    @BeforeEach
    void setUp() {

    }

    @Test
    void setNumberToDisplay() {
        Display display = new Display();
        display.setNumberToDisplay(10);
        assertEquals(10, display.getNumberToDisplay());
    }

    @Test
    void getNumberToDisplay() {
        Display display = new Display();
        display.setNumberToDisplay(15);
        assertEquals(15, display.getNumberToDisplay());
    }

}