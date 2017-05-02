package se.kth.iv1350.inspectVehicle.model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import se.kth.iv1350.inspectVehicle.utils.DummyData;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by fredrik on 01/05/17.
 */
class InspectionHandlerTest {
    private InspectionHandler inspectionHandler;
    private DummyData dummyData;

    @BeforeEach
    void setUp() {
        dummyData = new DummyData();
        inspectionHandler = new InspectionHandler(dummyData.generateFailedInspectionList(), dummyData.generatePassedInspectionList());
    }

    @AfterEach
    void tearDown() {
        inspectionHandler = null;
        dummyData = null;
    }

    @Test
    void getCurrentInspection() {
        assertEquals("Belt Inspection", inspectionHandler.getCurrentInspection().getName());
    }

    @Test
    void setInspectionPassed() {
        Inspection inspection = inspectionHandler.getCurrentInspection();
        inspectionHandler.setInspectionPassed(true);
        assertEquals(true, inspection.getPassedInspection());
    }

}