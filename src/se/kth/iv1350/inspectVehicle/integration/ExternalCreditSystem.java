package se.kth.iv1350.inspectVehicle.integration;

import se.kth.iv1350.inspectVehicle.model.CreditCardDTO;
import se.kth.iv1350.inspectVehicle.model.Payment;

/**
 * Created by fredrik on 27/04/17.
 */
public class ExternalCreditSystem {
    public ExternalCreditSystem() {
    }

    public boolean requestPaymentAuthorization(float totalCost, CreditCardDTO creditCardDTO){
        return true;
    }
}
