package se.kth.iv1350.inspectVehicle.integration;

import se.kth.iv1350.inspectVehicle.model.CreditCardDTO;
import se.kth.iv1350.inspectVehicle.model.CreditPaymentReceipt;
import se.kth.iv1350.inspectVehicle.model.Inspection;

import java.util.ArrayList;

/**
 * Created by fredrik on 27/04/17.
 */
public class ReceiptHandler {

    public ReceiptHandler() {

    }

    public CreditPaymentReceipt createCreditPaymentReceipt(float totalCost, CreditCardDTO creditCard, ArrayList<Inspection> inspectionList, boolean paymentApproved){
        return new CreditPaymentReceipt(totalCost, creditCard, inspectionList, paymentApproved);
    }
}
