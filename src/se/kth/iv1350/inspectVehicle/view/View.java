package se.kth.iv1350.inspectVehicle.view;

import se.kth.iv1350.inspectVehicle.controller.Controller;
import se.kth.iv1350.inspectVehicle.model.CreditCardDTO;

/**
 * Created by fredrik on 27/04/17.
 */
public class View {
    private Controller controller;

    /**
     * Creates a view.
     * @param controller The controller as <code>Controller</code>.
     */
    public View(Controller controller) {
        this.controller = controller;
    }

    public void sampleExecution() {

        controller.beginNewInspection();

        System.out.println("A new inspection has begun \n");

        float cost = controller.getCostForInspections("123ABC");

        System.out.println("You have entered the registration number 123ABC.");
        System.out.println("The total cost of the inspections is " + cost + " SEK. \n");

        CreditCardDTO creditcard = new CreditCardDTO("313", "4565232131394565", "0518");

        System.out.println("A creditcard has been given:");
        System.out.println("Cardnumber: " + creditcard.getCardNumber());
        System.out.println("Expiry date: " + creditcard.getExpiryDate());
        System.out.println("CVC: " + creditcard.getCvc() + "\n");

        System.out.println("----------------------------------------\n");

        System.out.println("Contacting external server for payment authorization.");
        controller.pay(creditcard);
        System.out.println("Payment has been Authorized... Proceed with inspections.\n");

        while (controller.getInspection() != null){
            System.out.println("Perform the following inspection: " + controller.getInspection().getName());

            if (Math.random() < 0.5) {
                controller.setInspectionPassed(true);
                System.out.println("The inspections result is set to pass.\n");
            } else {
                controller.setInspectionPassed(false);
                System.out.println("The inspection result is sett to fail\n");
            }

        }

        System.out.println("Results has been printed out. Have an okay day!");

    }

    public void multipleSampleExecution(){
        sampleExecution();
        sampleExecution();
    }
}
