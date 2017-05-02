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
class CreditPaymentHandlerTest {
    private CreditPaymentHandler creditPaymentHandler;
    private DummyData dummyData;

    @BeforeEach
    void setUp() {
        ReceiptHandler receiptHandler               = new ReceiptHandler();
        ExternalCreditSystem externalCreditSystem   = new ExternalCreditSystem();
        creditPaymentHandler                        = new CreditPaymentHandler(externalCreditSystem, receiptHandler);
        dummyData                                   = new DummyData();
    }

    @AfterEach
    void tearDown() {
        creditPaymentHandler = null;
        dummyData = null;
    }

    @Test
    void processPayment() {
        boolean approval = creditPaymentHandler.processPayment(100, dummyData.generateCreditCardDTO());
        assertEquals(true, approval);
    }

    @Test
    void createReceipt() {
        boolean approval = creditPaymentHandler.processPayment(100, dummyData.generateCreditCardDTO());
        CreditPaymentReceipt receipt = creditPaymentHandler.createReceipt(100, dummyData.generateCreditCardDTO(), dummyData.generateFailedInspectionList(), approval);
        assertEquals(true, receipt.getPaymentApproved());
    }

}