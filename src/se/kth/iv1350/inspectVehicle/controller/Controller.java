package se.kth.iv1350.inspectVehicle.controller;

import se.kth.iv1350.inspectVehicle.integration.*;
import se.kth.iv1350.inspectVehicle.model.*;

/**
 * Created by fredrik on 27/04/17.
 */
public class Controller {
    private QueueHandler queueHandler;
    private GarageDoor door;
    private VehicleDatabase vehicleDB;
    private Printer printer;
    private CreditPaymentHandler creditPaymentHandler;

    /**
     * Creates an instance of <code>Controller</code>.
     *
     * @param queueHandler <code>QueueHandler</code> takes care of queue operations.
     * @param door <code>GarageDoor</code> takes care of door operations.
     * @param vehicleDB <code>VehicleDatabase</code> is a database and has several functionalities, fetching and saving.
     * @param creditPaymentHandler <code>CreditPaymentHandler</code> handles credit payment operations.
     * @param printer <code>Printer</code> handles printer operations.
     */

    public Controller(QueueHandler queueHandler, GarageDoor door, VehicleDatabase vehicleDB, CreditPaymentHandler creditPaymentHandler, Printer printer) {
        this.queueHandler           = queueHandler;
        this.door                   = door;
        this.vehicleDB              = vehicleDB;
        this.creditPaymentHandler   = creditPaymentHandler;
        this.printer                = printer;
    }

    private Vehicle vehicle;
    private Payment payment;
    private InspectionHandler inspectionHandler;

    /**
     * Starts a new inspection session.
     */
    public void beginNewInspection() {
        queueHandler.nextCustomer();
        door.openDoor();
    }

    /**
     * Opens the garage door.
     */
    public void closeDoor(){
        door.closeDoor();
    }

    /**
     * Returns the cost of the inspections that should be paid for.
     * @param regNumber The registration given as <code>String</code>.
     * @return Returns the cost of the inspections as <code>float</code>.
     */
    public float getCostForInspections(String regNumber){
        vehicle             = vehicleDB.getVehicle(regNumber);
        payment             = new Payment(vehicle.getFailedInspectionList());
        inspectionHandler   = new InspectionHandler(vehicle.getFailedInspectionList(), vehicle.getPassedInspectionList());
        return payment.getTotalCost();
    }

    /**
     * A method to pay for inspections.
     * @param creditCardDTO Credit card information given as <code>CreditCardDTO</code>.
     */
    public void pay(CreditCardDTO creditCardDTO){
        boolean approvedPayment         = creditPaymentHandler.processPayment(payment.getTotalCost(), creditCardDTO);
        CreditPaymentReceipt receipt    = creditPaymentHandler.createReceipt(payment.getTotalCost(), creditCardDTO, payment.getInspectionsToPayFor(), approvedPayment);
        printer.printReceipt(receipt);
    }

    /**
     * Returns an inspection that should be made as <code>Inspection</code>.
     * @return Returns the inspection that should be performed as <code>Inspection</code>.
     */
    public Inspection getInspection(){

        if (inspectionHandler.getCurrentInspection() == null) {
            endInspectionSession();
        }

        return inspectionHandler.getCurrentInspection();
    }

    /**
     * Sets the result of the current inspection that was performed.
     * @param vehiclePassedInspection A result given as a <code>boolean</code> that tells if the vehicle passed the inspection (<code>true</code>) or not (<code>false</code>).
     */
    public void setInspectionPassed(boolean vehiclePassedInspection){

        inspectionHandler.setInspectionPassed(vehiclePassedInspection);

    }

    /**
     * Ends the current inspection by printing the results and updating the <code>Vehicle</code> instance in the <code>VehicleDatabase</code>.
     */
    private void endInspectionSession(){
        Printout printout = new Printout(vehicle.getFailedInspectionList(), vehicle.getPassedInspectionList());
        printer.printPrintout(printout);
        vehicleDB.updateVehicleInDatabase(vehicle.getRegNumber(), vehicle.getFailedInspectionList(), vehicle.getPassedInspectionList());
    }


}
