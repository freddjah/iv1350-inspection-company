package se.kth.iv1350.inspectVehicle.utils;

import se.kth.iv1350.inspectVehicle.integration.VehicleDatabase;
import se.kth.iv1350.inspectVehicle.model.Inspection;
import se.kth.iv1350.inspectVehicle.model.Vehicle;

import java.util.ArrayList;

/**
 * Created by fredrik on 28/04/17.
 */
public class DummyData {

    /**
     * Returns some dummy data that can be used to create a vehicle database.
     * @return Returns a list of vehicles as <code>ArrayList</code>.
     */
    public ArrayList<Vehicle> generateVehicleList(){
        ArrayList<Vehicle> vehicleList = new ArrayList<>();
        vehicleList.add(new Vehicle("123REF", generateFailedInspectionList(), generateEmptyInspectionList()));
        vehicleList.add(new Vehicle("283FOE", generateFailedInspectionList(), generateEmptyInspectionList()));
        vehicleList.add(new Vehicle("562ROP", generateFailedInspectionList(), generateEmptyInspectionList()));
        vehicleList.add(new Vehicle("123ABC", generateFailedInspectionList(), generateEmptyInspectionList()));
        return vehicleList;
    }

    /**
     * Generates an <code>ArrayList</code> of failed inspections for testing purposes.
     * @return List of failed inspections as <code>ArrayList</code>.
     */
    public ArrayList<Inspection> generateFailedInspectionList(){
        ArrayList<Inspection> dummyInspections = new ArrayList<>();
        dummyInspections.add(new Inspection("Belt Inspection", 50));
        dummyInspections.add(new Inspection("Wheel Inspection", 100));
        dummyInspections.add(new Inspection("Brakes Inspection", 250));
        dummyInspections.add(new Inspection("Tail Lights Inspection", 150));
        return dummyInspections;
    }

    /**
     * Generates an <code>ArrayList</code> of inspections that has been passed.
     * @return List of passed inspections as <code>ArrayList</code>.
     */
    public ArrayList<Inspection> generatePassedInspectionList(){
        ArrayList<Inspection> dummyInspections = new ArrayList<>();
        dummyInspections.add(new Inspection("Electrical Components Inspection", 500, true));
        dummyInspections.add(new Inspection("Exhaust Inspection", 120, true));
        dummyInspections.add(new Inspection("Engine Inspection", 350, true));
        return dummyInspections;
    }

    /**
     * Generates an <code>ArrayList</code> that is empty.
     * @return Empty list as <code>ArrayList</code>.
     */
    public ArrayList<Inspection> generateEmptyInspectionList(){
        return new ArrayList<>();
    }
}
