package se.kth.iv1350.inspectVehicle.integration;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import se.kth.iv1350.inspectVehicle.model.CreditCardDTO;
import se.kth.iv1350.inspectVehicle.model.CreditPaymentReceipt;
import se.kth.iv1350.inspectVehicle.model.Printout;
import se.kth.iv1350.inspectVehicle.utils.DummyData;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by fredrik on 02/05/17.
 */
class PrinterTest {
    private Printer printer;
    private DummyData dummyData;

    @BeforeEach
    void setUp() {
        printer = new Printer();
        dummyData = new DummyData();
    }

    @AfterEach
    void tearDown() {
        printer = null;
        dummyData = null;
    }

    @Test
    void printReceipt() {
        CreditPaymentReceipt receipt = new CreditPaymentReceipt(100, dummyData.generateCreditCardDTO(), dummyData.generateFailedInspectionList(), true);
        printer.printReceipt(receipt);
    }

    @Test
    void printPrintout() {
        Printout printout = new Printout(dummyData.generateFailedInspectionList(), dummyData.generatePassedInspectionList());
        printer.printPrintout(printout);
    }

}