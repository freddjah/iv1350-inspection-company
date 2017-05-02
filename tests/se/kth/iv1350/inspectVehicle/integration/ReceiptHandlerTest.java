package se.kth.iv1350.inspectVehicle.integration;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import se.kth.iv1350.inspectVehicle.model.CreditCardDTO;
import se.kth.iv1350.inspectVehicle.model.CreditPaymentReceipt;
import se.kth.iv1350.inspectVehicle.utils.DummyData;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by fredrik on 02/05/17.
 */
class ReceiptHandlerTest {
    private ReceiptHandler receiptHandler;
    private DummyData dummyData;

    @BeforeEach
    void setUp() {
        receiptHandler = new ReceiptHandler();
        dummyData = new DummyData();
    }

    @AfterEach
    void tearDown() {
        receiptHandler = null;
        dummyData = null;
    }

    @Test
    void createCreditPaymentReceipt() {
        CreditPaymentReceipt receipt = receiptHandler.createCreditPaymentReceipt(100, dummyData.generateCreditCardDTO(), dummyData.generateFailedInspectionList(), true);
        assertEquals(100, receipt.getTotalCost());
    }

}