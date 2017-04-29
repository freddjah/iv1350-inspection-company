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

    public Controller(QueueHandler queueHandler, GarageDoor door, VehicleDatabase vehicleDB, CreditPaymentHandler creditPaymentHandler, Printer printer) {
        this.queueHandler           = queueHandler;
        this.door                   = door;
        this.vehicleDB              = vehicleDB;
        this.creditPaymentHandler   = creditPaymentHandler;
        this.printer = printer;
    }

    private Vehicle vehicle;
    private Payment payment;
    private InspectionHandler inspectionHandler;

    public void beginNewInspection() {
        queueHandler.nextCustomer();
        openDoor();
    }

    public void openDoor(){
        door.openDoor();
    }


    public float getCostForInspections(String regNumber){
        vehicle             = vehicleDB.getVehicle(regNumber);
        payment             = new Payment(vehicle.getInspectionList());
        inspectionHandler   = new InspectionHandler(vehicle.getInspectionList());
        return payment.getTotalCost();
    }

    public void pay(CreditCardDTO creditCardDTO){
        boolean approvedPayment         = creditPaymentHandler.processPayment(payment.getTotalCost(), creditCardDTO);
        CreditPaymentReceipt receipt    = creditPaymentHandler.createReceipt(payment.getTotalCost(), creditCardDTO, payment.getInspectionsToPayFor(), approvedPayment);
        printer.printReceipt(receipt);
    }

    public Inspection getInspection(){

        if (inspectionHandler.getCurrentInspection() == null) {
            endInspectionSession();
        }

        return inspectionHandler.getCurrentInspection();
    }

    public void setInspectionPassed(boolean vehiclePassedInspection){

        inspectionHandler.setInspectionPassed(vehiclePassedInspection);

    }

    private void endInspectionSession(){
        Printout printout = new Printout(vehicle.getInspectionList());
        printer.printPrintout(printout);
        vehicleDB.updateVehicleInDatabase(vehicle.getRegNumber(), vehicle.getInspectionList());
    }


}
