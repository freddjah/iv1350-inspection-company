package se.kth.iv1350.inspectVehicle.integration;

import se.kth.iv1350.inspectVehicle.model.CreditCardDTO;
import se.kth.iv1350.inspectVehicle.model.CreditPaymentReceipt;
import se.kth.iv1350.inspectVehicle.model.Inspection;

import java.util.ArrayList;

/**
 * Created by fredrik on 27/04/17.
 */
public class CreditPaymentHandler {
    private ExternalCreditSystem externalCreditSystem;
    private ReceiptHandler receiptHandler;

    public CreditPaymentHandler(ExternalCreditSystem externalCreditSystem, ReceiptHandler receiptHandler){
        this.externalCreditSystem = externalCreditSystem;
        this.receiptHandler = receiptHandler;
    }

    public boolean processPayment(float totalCost, CreditCardDTO creditCardDTO){
        return externalCreditSystem.requestPaymentAuthorization(totalCost, creditCardDTO);
    }

    public CreditPaymentReceipt createReceipt(float totalCost, CreditCardDTO creditCardDTO, ArrayList<Inspection> inspectionList, boolean paymentApproved){
        return receiptHandler.createCreditPaymentReceipt(totalCost, creditCardDTO, inspectionList, paymentApproved);
    }
}
