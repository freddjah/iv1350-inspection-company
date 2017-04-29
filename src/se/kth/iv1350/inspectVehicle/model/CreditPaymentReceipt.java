package se.kth.iv1350.inspectVehicle.model;

import java.util.ArrayList;

/**
 * Created by fredrik on 27/04/17.
 */
public class CreditPaymentReceipt {

    private float totalCost;
    private CreditCardDTO creditCard;
    private ArrayList<Inspection> inspectionList;
    private boolean paymentApproved;

    /**
     * Creates an instance of a CreditPaymentReceipt
     * @param totalCost The total cost of the payment as <code>int</code>.
     * @param creditCard The information about the credit card as <code>CreditCardDTO</code>.
     * @param inspectionList A list of inspections that has been performed as <code>ArrayList</code>.
     * @param paymentApproved Tells if the payment went through or not. Given as <code>boolean</code>.
     */

    public CreditPaymentReceipt(float totalCost, CreditCardDTO creditCard, ArrayList<Inspection> inspectionList, boolean paymentApproved) {

        this.totalCost = totalCost;
        this.creditCard = creditCard;
        this.inspectionList = inspectionList;
        this.paymentApproved = paymentApproved;

    }

    /**
     * Returns the total cost of the payment as <code>int</code>.
     * @return Returns the total cost of the payment.
     */

    public float getTotalCost() {
        return this.totalCost;
    }

    /**
     * Returns the credit card information as <code>CreditCardDTO</code>.
     * @return Returns the credit card information.
     */

    public CreditCardDTO getCreditCard() {
        return this.creditCard;
    }

    /**
     * Returns the inspections that has been performed and paid for as <code>ArrayList</code>
     * @return Returns the inspections that has been paid for.
     */

    public ArrayList<Inspection> getInspectionList() {
        return this.inspectionList;
    }

    /**
     * Returns a <code>boolean</code> that is <code>true</code> if the payment went through, else <code>false</code>.
     * @return
     */

    public boolean getPaymentApproved(){
        return this.paymentApproved;
    }

}
