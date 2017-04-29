package se.kth.iv1350.inspectVehicle.integration;

import se.kth.iv1350.inspectVehicle.model.Inspection;
import se.kth.iv1350.inspectVehicle.model.Vehicle;
import se.kth.iv1350.inspectVehicle.utils.DummyData;

import java.util.ArrayList;

/**
 * Created by fredrik on 27/04/17.
 */
public class VehicleDatabase {

    private ArrayList<Vehicle> vehicles;

    public VehicleDatabase() {

        DummyData dummyData = new DummyData();
        this.vehicles = dummyData.generateVehicleList();

    }

    public Vehicle getVehicle(String regNumber){
        for (Vehicle vehicle : this.vehicles){
            if (vehicle.getRegNumber().equals(regNumber)){
                return vehicle.copy();
            }
        }
        return null;
    }

    public void updateVehicleInDatabase(String regNumber, ArrayList<Inspection> performedInspectionList){
        for (Vehicle vehicle : vehicles){
            if (vehicle.getRegNumber().equals(regNumber)){
                vehicle.updateInspectionList(performedInspectionList);
            }
        }

    }

}
