package se.kth.iv1350.inspectVehicle.controller;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import se.kth.iv1350.inspectVehicle.integration.*;
import se.kth.iv1350.inspectVehicle.model.CreditPaymentReceipt;
import se.kth.iv1350.inspectVehicle.model.Inspection;
import se.kth.iv1350.inspectVehicle.model.Payment;
import se.kth.iv1350.inspectVehicle.utils.DummyData;

import javax.naming.ldap.Control;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by fredrik on 02/05/17.
 */
class ControllerTest {
    private Controller controller;
    private DummyData dummyData;

    @BeforeEach
    void setUp() {
        Display display                             = new Display();
        Queue queue                                 = new Queue();
        QueueHandler queueHandler                   = new QueueHandler(queue, display);
        GarageDoor door                             = new GarageDoor();
        VehicleDatabase vehicleDatabase             = new VehicleDatabase();
        ExternalCreditSystem externalCreditSystem   = new ExternalCreditSystem();
        ReceiptHandler receiptHandler               = new ReceiptHandler();
        CreditPaymentHandler creditPaymentHandler   = new CreditPaymentHandler(externalCreditSystem, receiptHandler);
        Printer printer                             = new Printer();
        controller                                  = new Controller(queueHandler, door, vehicleDatabase, creditPaymentHandler, printer);
        dummyData                                   = new DummyData();
    }

    @AfterEach
    void tearDown() {
        controller = null;
        dummyData = null;
    }

    @Test
    void beginNewInspection() {
        controller.beginNewInspection();
    }

    @Test
    void closeDoor() {
        controller.closeDoor();
    }

    @Test
    void getCostForInspections() {
        float cost = controller.getCostForInspections("123ABC");
        assertEquals(550, cost);
    }

    @Test
    void pay() {
        controller.getCostForInspections("123ABC");
        controller.pay(dummyData.generateCreditCardDTO());
    }

    @Test
    void getInspection() {
        controller.getCostForInspections("123ABC");
        Inspection inspection = controller.getInspection();
        assertEquals("Belt Inspection", inspection.getName());
    }

    @Test
    void setInspectionPassed() {
        controller.getCostForInspections("123ABC");
        Inspection inspection = controller.getInspection();
        controller.setInspectionPassed(true);
        assertEquals(true, inspection.getPassedInspection());
    }

}