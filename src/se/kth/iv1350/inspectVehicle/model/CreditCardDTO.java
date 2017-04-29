package se.kth.iv1350.inspectVehicle.model;

/**
 * Created by fredrik on 27/04/17.
 */
public class CreditCardDTO {
    private String cvc;
    private String cardNumber;
    private String expiryDate;

    /**
     * Creates an instance of CreditCardDTO.
     * @param cvc The cvc number given as <code>String</code>.
     * @param cardNumber The card number given as <code>String</code>.
     * @param expiryDate The expiration date given as <code>String</code>.
     */

    public CreditCardDTO(String cvc, String cardNumber, String expiryDate){
        this.cvc = cvc;
        this.cardNumber = cardNumber;
        this.expiryDate = expiryDate;
    }

    /**
     * Returns the cvc as <code>String</code>.
     * @return Returns the cvc.
     */

    public String getCvc(){
        return this.cvc;
    }

    /**
     * Returns the card number as <code>String</code>.
     * @return Returns the card number.
     */

    public String getCardNumber(){
        return this.cardNumber;
    }

    /**
     * Returns the expiration date of the credit card as <code>String</code>.
     * @return Returns the expiration date.
     */

    public String getExpiryDate(){
        return this.expiryDate;
    }
}
