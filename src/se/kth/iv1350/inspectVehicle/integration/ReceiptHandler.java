package se.kth.iv1350.inspectVehicle.integration;

import se.kth.iv1350.inspectVehicle.model.CreditCardDTO;
import se.kth.iv1350.inspectVehicle.model.CreditPaymentReceipt;
import se.kth.iv1350.inspectVehicle.model.Inspection;

import java.util.ArrayList;

/**
 * Created by fredrik on 27/04/17.
 */
public class ReceiptHandler {


    /**
     * Creates an instance of a receipt handler which can create receipt for different payment methods. As of right now only for credit payment.
     */
    public ReceiptHandler() {

    }

    /**
     * Creates an instance which is a receipt for credit card payment.
     * @param totalCost Total cost of the payment given as <code>float</code>.
     * @param creditCard Credit card information given as <code>CreditCardDTO</code>.
     * @param inspectionList The inspection list for which the customer should pay for, given as <code>ArrayList</code>
     * @param paymentApproved A <code>boolean</code> value. If the payment was approved this should be given as <code>true</code>.
     * @return A receipt of the credit card payment as <code>CreditPaymentReceipt</code>.
     */
    public CreditPaymentReceipt createCreditPaymentReceipt(float totalCost, CreditCardDTO creditCard, ArrayList<Inspection> inspectionList, boolean paymentApproved){
        return new CreditPaymentReceipt(totalCost, creditCard, inspectionList, paymentApproved);
    }
}
