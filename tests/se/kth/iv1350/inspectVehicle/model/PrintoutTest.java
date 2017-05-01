package se.kth.iv1350.inspectVehicle.model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import se.kth.iv1350.inspectVehicle.utils.DummyData;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by fredrik on 01/05/17.
 */
class PrintoutTest {
    private Printout printout;

    @BeforeEach
    void setUp() {
        DummyData dummyData = new DummyData();
        printout = new Printout(dummyData.generateFailedInspectionList(), dummyData.generatePassedInspectionList());
    }

    @AfterEach
    void tearDown() {
        printout = null;
    }

    @Test
    void getFailedInspectionList() {
        for (Inspection inspection : printout.getFailedInspectionList()){
            assertNotEquals(null, inspection);
            assertEquals(false, inspection.getPassedInspection());
        }
    }

    @Test
    void getPassedInspectionList() {
        for (Inspection inspection : printout.getPassedInspectionList()){
            assertNotEquals(null, inspection);
            assertEquals(true, inspection.getPassedInspection());
        }
    }

}