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

    /**
     * Creates an instance of a credit payment handler which handles the credit payment operations.
     * @param externalCreditSystem The external credit card system given as <code>ExternalCreditSystem</code>.
     * @param receiptHandler The receipt handler given as <code>ReceiptHandler</code>.
     */
    public CreditPaymentHandler(ExternalCreditSystem externalCreditSystem, ReceiptHandler receiptHandler){
        this.externalCreditSystem = externalCreditSystem;
        this.receiptHandler = receiptHandler;
    }

    /**
     * Returns a <code>boolean</code> value that tells if the credit payment was able to be processed (<code>true</code>) or not (<code>false</code>).
     * @param totalCost The total cost of the payment given as <code>float</code>.
     * @param creditCardDTO The credit card information given as <code>CreditCardDTO</code>.
     * @return Returns a <code>boolean</code> that tells if the payment was processed (<code>true</code>) or not (<code>false</code>).
     */
    public boolean processPayment(float totalCost, CreditCardDTO creditCardDTO){
        return externalCreditSystem.requestPaymentAuthorization(totalCost, creditCardDTO);
    }

    /**
     * Calls the <code>ReceiptHandler</code> to create a receipt as <code>CreditPaymentReceipt</code>.
     * @param totalCost The total cost as <code>float</code>.
     * @param creditCardDTO The credit card information given as <code>CreditCardDTO</code>.
     * @param inspectionList The inspection list that should be paid for as <code>ArrayList</code>
     * @param paymentApproved The information that tells if the payment was processed or not as <code>boolean</code>.
     * @return Returns a receipt of type <code>CreditPaymentReceipt</code>.
     */
    public CreditPaymentReceipt createReceipt(float totalCost, CreditCardDTO creditCardDTO, ArrayList<Inspection> inspectionList, boolean paymentApproved){
        return receiptHandler.createCreditPaymentReceipt(totalCost, creditCardDTO, inspectionList, paymentApproved);
    }
}
