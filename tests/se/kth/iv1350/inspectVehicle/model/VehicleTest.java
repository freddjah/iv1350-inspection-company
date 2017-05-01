package se.kth.iv1350.inspectVehicle.model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import se.kth.iv1350.inspectVehicle.utils.DummyData;

import java.lang.reflect.Array;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by fredrik on 29/04/17.
 */
class VehicleTest {
    private Vehicle vehicle;

    @BeforeEach
    void setUp() {
        DummyData dummyData = new DummyData();
        ArrayList<Inspection> failedInspectionList = dummyData.generateFailedInspectionList();
        ArrayList<Inspection> passedInspectionList = dummyData.generatePassedInspectionList();
        vehicle = new Vehicle("123ABC", failedInspectionList, passedInspectionList);
    }

    @AfterEach
    void tearDown() {
        vehicle = null;
    }

    @Test
    void getFailedInspectionList() {
        for (Inspection inspection : vehicle.getFailedInspectionList()){
            assertNotEquals(null, inspection);
            assertEquals(false, inspection.getPassedInspection());
        }
    }

    @Test
    void getPassedInspectionList() {
        for (Inspection inspection : vehicle.getPassedInspectionList()){
            assertNotEquals(null, inspection);
            assertEquals(true, inspection.getPassedInspection());
        }
    }

    @Test
    void updateFailedInspectionList() {
        DummyData dummyData = new DummyData();
        ArrayList<Inspection> emptyInspectionList = dummyData.generateEmptyInspectionList();
        vehicle.updateFailedInspectionList(emptyInspectionList);
        assertEquals(0, vehicle.getFailedInspectionList().size());
    }

    @Test
    void updatePassedInspectionList() {
        DummyData dummyData = new DummyData();
        ArrayList<Inspection> emptyInspectionList = dummyData.generateEmptyInspectionList();
        vehicle.updatePassedInspectionList(emptyInspectionList);
        assertEquals(0, vehicle.getPassedInspectionList().size());
    }

    @Test
    void getRegNumber() {
        assertEquals("123ABC", vehicle.getRegNumber());
    }

    @Test
    void copy() {
        Vehicle vehicleCopy = vehicle.copy();
        assertEquals(vehicleCopy.getRegNumber(), vehicle.getRegNumber());
        for (int i = 0; i < vehicleCopy.getFailedInspectionList().size()-1; i++){
            assertEquals(vehicleCopy.getFailedInspectionList().get(i).getName(), vehicle.getFailedInspectionList().get(i).getName());
            assertEquals(vehicleCopy.getPassedInspectionList().get(i).getName(), vehicle.getPassedInspectionList().get(i).getName());
        }
    }

}