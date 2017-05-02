package se.kth.iv1350.inspectVehicle.model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import se.kth.iv1350.inspectVehicle.utils.DummyData;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by fredrik on 01/05/17.
 */
class CreditPaymentReceiptTest {
    private CreditPaymentReceipt creditPaymentReceipt;
    private DummyData dummyData;

    @BeforeEach
    void setUp() {
        dummyData = new DummyData();
        creditPaymentReceipt = new CreditPaymentReceipt(50, dummyData.generateCreditCardDTO(), dummyData.generateFailedInspectionList(), true);
    }

    @AfterEach
    void tearDown() {
        creditPaymentReceipt = null;
    }

    @Test
    void getTotalCost() {
        assertEquals(50, creditPaymentReceipt.getTotalCost());
    }

    @Test
    void getCreditCard() {
        assertEquals("101" , creditPaymentReceipt.getCreditCard().getCvc());
    }

    @Test
    void getInspectionList() {
        assertEquals(4, creditPaymentReceipt.getInspectionList().size());
    }

    @Test
    void getPaymentApproved() {
        assertEquals(true, creditPaymentReceipt.getPaymentApproved());
    }

}