package se.kth.iv1350.inspectVehicle.integration;

import se.kth.iv1350.inspectVehicle.model.CreditCardDTO;
import se.kth.iv1350.inspectVehicle.model.Payment;

/**
 * Created by fredrik on 27/04/17.
 */
public class ExternalCreditSystem {

    /**
     * Creates an instance of the external credit system which handles confirmations of a credit payment.
     */
    public ExternalCreditSystem() {
    }

    /**
     * Returns the result of a payment authorization as <code>boolean</code>.
     * @param totalCost The total cost of the payment as <code>float</code>.
     * @param creditCardDTO Credit card information given as <code>CreditCardDTO</code>.
     * @return Returns a <code>boolean</code> value that tells if the payment went through.
     */
    public boolean requestPaymentAuthorization(float totalCost, CreditCardDTO creditCardDTO){
        return true;
    }
}
