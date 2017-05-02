package se.kth.iv1350.inspectVehicle.model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import se.kth.iv1350.inspectVehicle.utils.DummyData;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by fredrik on 01/05/17.
 */
class PaymentTest {
    private Payment payment;
    private DummyData dummyData;

    @BeforeEach
    void setUp() {
        dummyData = new DummyData();
        payment = new Payment(dummyData.generateFailedInspectionList());
    }

    @AfterEach
    void tearDown() {
        payment = null;
        dummyData = null;
    }

    @Test
    void getTotalCost() {
        assertEquals(550, payment.getTotalCost());
    }

    @Test
    void getInspectionsToPayFor() {
        for (Inspection inspection : payment.getInspectionsToPayFor()){
            assertNotEquals(null, inspection);
            assertEquals(false, inspection.getPassedInspection());
        }
    }

}