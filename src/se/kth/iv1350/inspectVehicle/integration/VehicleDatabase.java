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

    /**
     * Creates an instance of a vehicle database with dummydata.
     */
    public VehicleDatabase() {
        DummyData dummyData = new DummyData();
        this.vehicles = dummyData.generateVehicleList();
    }

    /**
     * Retrieves a copy of a vehicle in the database by searching for a registration number. If it's not found it will return a null.
     * @param regNumber A registration number given as <code>String</code>.
     * @return Returns a copy of <code>Vehicle</code>.
     */
    public Vehicle getVehicle(String regNumber){
        for (Vehicle vehicle : this.vehicles){
            if (vehicle.getRegNumber().equals(regNumber)){
                return vehicle.copy();
            }
        }
        return null;
    }

    /**
     * Updates a vehicles list failed inspections and passed inspections in the database by matching a registration number.
     * @param regNumber A registration number given as <code>String</code>.
     * @param failedInspectionList An <code>ArrayList</code> of failed inspections.
     * @param passedInspectionList An <code>ArrayList</code> of passed inspections.
     */
    public void updateVehicleInDatabase(String regNumber, ArrayList<Inspection> failedInspectionList, ArrayList<Inspection> passedInspectionList){
        for (Vehicle vehicle : vehicles){
            if (vehicle.getRegNumber().equals(regNumber)){
                vehicle.updateFailedInspectionList(failedInspectionList);
                vehicle.updatePassedInspectionList(passedInspectionList);
            }
        }

    }

}
