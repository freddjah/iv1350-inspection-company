package se.kth.iv1350.inspectVehicle.integration;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import se.kth.iv1350.inspectVehicle.model.CreditCardDTO;
import se.kth.iv1350.inspectVehicle.utils.DummyData;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by fredrik on 02/05/17.
 */
class ExternalCreditSystemTest {
    private ExternalCreditSystem externalCreditSystem;
    private DummyData dummyData;

    @BeforeEach
    void setUp() {
        externalCreditSystem = new ExternalCreditSystem();
        dummyData = new DummyData();
    }

    @AfterEach
    void tearDown() {
        externalCreditSystem = null;
        dummyData = null;
    }

    @Test
    void requestPaymentAuthorization() {
        boolean approval = externalCreditSystem.requestPaymentAuthorization(100, dummyData.generateCreditCardDTO());
        assertEquals(true, approval);

    }

}