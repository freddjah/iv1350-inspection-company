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

    public void sampleExecution(){
        System.out.println(
                "------------------------ SYSTEM OPERATIONS ------------------------ \n" +
                "Controller has been created with the following parameters: \n" +
                "queueHandler, door, vehicleDB, creditPaymentHandler, printer \n" +
                "------------------------------------------------------------------- \n"
        );

        controller.beginNewInspection();
        System.out.println(
                "------------------------ SYSTEM OPERATIONS ------------------------ \n" +
                "View calls controller.beginNewInspection(): \n" +
                "The queue updates, the new number is displayed and the door opens. \n" +
                "------------------------------------------------------------------- \n"
        );

        controller.closeDoor();
        System.out.println(
                "------------------------ SYSTEM OPERATIONS ------------------------ \n" +
                "View calls controller.closeDoor(): \n" +
                "The door closes. \n" +
                "------------------------------------------------------------------- \n"
        );

        System.out.println(
                "ENTERED REGISTRATION NUMBER: 123ABC \n" +
                "SEARCHING FOR REGISTRATION NUMBER IN DATABASE... \n");

        float cost = controller.getCostForInspections("123ABC");
        System.out.println(
                "------------------------ SYSTEM OPERATIONS ------------------------ \n" +
                "View calls controller.getCostForInspections('123ABC'): \n" +
                "The vehicle database searches for the vehicle, and returns it to controller. \n" +
                "A payment is created with the previously failed inspections of the vehicle. \n" +
                "The total cost is returned to the view. \n" +
                "------------------------------------------------------------------- \n"
        );

        System.out.println("VEHICLE FOUND. CALCULATING COST OF INSPECTIONS TO BE PERFORMED... \n");

        System.out.println(
                "TOTAL COST OF INSPECTIONS TO BE PERFORMED: " + cost + " SEK \n" +
                "PAYMENT METHOD CHOSEN: CREDIT CARD \n"
        );

        CreditCardDTO creditCardDTO = new CreditCardDTO("313", "4565232131394565", "0518");
        controller.pay(creditCardDTO);
        System.out.println(
                "------------------------ SYSTEM OPERATIONS ------------------------ \n" +
                "A credit card has been registered in the view as CreditCardDTO. \n" +
                "View calls controller.pay(CreditCardDTO) \n" +
                "The payment is processed and a boolean value is returned to controller that tells \n" +
                "if the payment went through. \n" +
                "A receipt is created with information about the payment and credit card.\n" +
                "The receipt is printed out with the printer. \n" +
                "------------------------------------------------------------------- \n"
        );

        System.out.println("PAYMENT APPROVED. PRINTING RECEIPT.\n");

        System.out.println(
                "------------------------ SYSTEM OPERATIONS ------------------------ \n" +
                "The inspections is now fetched one by one by view calling controller.getInspection()\n" +
                "We will also set the results randomly with Math.random() as view calls \n" +
                "controller.setInspectionPassed(true or false) \n" +
                "------------------------------------------------------------------- \n"
        );

        while (controller.getInspection() != null){
            System.out.println("PERFORM INSPECTION: " + controller.getInspection().getName() + "\n");

            if (Math.random() < 0.5) {
                controller.setInspectionPassed(true);
                System.out.println("RESULT SET TO PASS. \n");
            } else {
                controller.setInspectionPassed(false);
                System.out.println("RESULT SET TO FAIL. \n");
            }

        }

        System.out.println(
                "------------------------ SYSTEM OPERATIONS ------------------------ \n" +
                "Every previously failed inspection has been inspected. Controller calls \n" +
                "private method endInspectionSession() \n" +
                "Controller creates a printout with all the inspections that has been made and their results.\n" +
                "The printout is printed out by printer. \n" +
                "The vehicle database is updated by storing the inspections on the vehicle.\n" +
                "------------------------------------------------------------------- \n"
        );

        System.out.println("SESSION ENDED. PRINTOUT WITH RESULTS HAS BEEN PRINTED OUT.");

    }
}
