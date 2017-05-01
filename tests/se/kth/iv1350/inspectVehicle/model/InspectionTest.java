package se.kth.iv1350.inspectVehicle.model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by fredrik on 01/05/17.
 */
class InspectionTest {
    private Inspection inspection;

    @BeforeEach
    void setUp() {
        inspection = new Inspection("Belt Inspection", 50);
    }

    @AfterEach
    void tearDown() {
        inspection = null;
    }

    @Test
    void setPassedInspection() {
        inspection.setPassedInspection();
        assertEquals(true, inspection.getPassedInspection());
    }

    @Test
    void getName() {
        assertEquals("Belt Inspection", inspection.getName());
    }

    @Test
    void getCost() {
        assertEquals(50, inspection.getCost());
    }

    @Test
    void getPassedInspection() {
        assertEquals(false, inspection.getPassedInspection());
    }

    @Test
    void copy() {
        Inspection inspectionCopy = inspection.copy();
        assertEquals(inspectionCopy.getCost(), inspection.getCost());
    }

}