package se.kth.iv1350.inspectVehicle.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by fredrik on 28/04/17.
 */
class CreditPaymentReceiptTest {

    @BeforeEach
    void setUp() {
        ArrayList<Inspection> inspectionList = new ArrayList<>();
        inspectionList.add(new Inspection("Check steering wheel", 120));
        inspectionList.add(new Inspection("Check gas pedal", 210));
        inspectionList.add(new Inspection("Check front seat", 50));
        CreditCardDTO creditCard = new CreditCardDTO("103", "1858234598659823", "0518");
        CreditPaymentReceipt creditPaymentReceipt = new CreditPaymentReceipt(120, creditCard, inspectionList, true);
    }

    @Test
    void getTotalCost() {
    }

    @Test
    void getCreditCard() {
    }

    @Test
    void getInspectionList() {
    }

}