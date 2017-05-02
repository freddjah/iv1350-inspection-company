package se.kth.iv1350.inspectVehicle.main;

import se.kth.iv1350.inspectVehicle.controller.Controller;
import se.kth.iv1350.inspectVehicle.integration.*;
import se.kth.iv1350.inspectVehicle.integration.CreditPaymentHandler;
import se.kth.iv1350.inspectVehicle.integration.ReceiptHandler;
import se.kth.iv1350.inspectVehicle.view.View;

/**
 * Created by fredrik on 27/04/17.
 */
public class Main {
    public static void main(String[] args){
        Queue queue                                 = new Queue();
        Display display                             = new Display();
        QueueHandler queueHandler                   = new QueueHandler(queue, display);
        GarageDoor door                             = new GarageDoor();
        VehicleDatabase vehicleDB                   = new VehicleDatabase();
        ExternalCreditSystem externalCreditSystem   = new ExternalCreditSystem();
        ReceiptHandler receiptHandler               = new ReceiptHandler();
        CreditPaymentHandler creditPaymentHandler   = new CreditPaymentHandler(externalCreditSystem, receiptHandler);
        Printer printer                             = new Printer();

        Controller controller = new Controller(queueHandler, door, vehicleDB, creditPaymentHandler, printer);
        View view = new View(controller);

        view.sampleExecution();
    }
}
