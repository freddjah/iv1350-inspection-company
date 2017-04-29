package se.kth.iv1350.inspectVehicle.utils;

import se.kth.iv1350.inspectVehicle.integration.VehicleDatabase;
import se.kth.iv1350.inspectVehicle.model.Inspection;
import se.kth.iv1350.inspectVehicle.model.Vehicle;

import java.util.ArrayList;

/**
 * Created by fredrik on 28/04/17.
 */
public class DummyData {
    public ArrayList<Vehicle> generateVehicleList(){
        ArrayList<Vehicle> vehicleList = new ArrayList<>();
        vehicleList.add(new Vehicle("123REF", generateInspectionList()));
        vehicleList.add(new Vehicle("283FOE", generateInspectionList()));
        vehicleList.add(new Vehicle("562ROP", generateInspectionList()));
        vehicleList.add(new Vehicle("123ABC", generateInspectionList()));
        return vehicleList;
    }

    private ArrayList<Inspection> generateInspectionList(){
        ArrayList<Inspection> dummyInspections = new ArrayList<>();
        dummyInspections.add(new Inspection("Belt Inspection", 50));
        dummyInspections.add(new Inspection("Wheel Inspection", 100));
        dummyInspections.add(new Inspection("Brakes Inspection", 250));
        dummyInspections.add(new Inspection("Tail Lights Inspection", 150));
        return dummyInspections;
    }
}
