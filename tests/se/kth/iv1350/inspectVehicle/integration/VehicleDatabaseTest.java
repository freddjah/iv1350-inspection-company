package se.kth.iv1350.inspectVehicle.integration;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import se.kth.iv1350.inspectVehicle.model.Vehicle;
import se.kth.iv1350.inspectVehicle.utils.DummyData;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by fredrik on 01/05/17.
 */
class VehicleDatabaseTest {
    private VehicleDatabase vehicleDatabase;

    @BeforeEach
    void setUp() {
        vehicleDatabase = new VehicleDatabase();
    }

    @AfterEach
    void tearDown() {
        vehicleDatabase = null;
    }

    @Test
    void getVehicle() {
        assertNotEquals(null, vehicleDatabase.getVehicle("123ABC"));
        assertEquals("123ABC", vehicleDatabase.getVehicle("123ABC").getRegNumber());
    }

    @Test
    void updateVehicleInDatabase() {
        DummyData dummyData = new DummyData();
        vehicleDatabase.updateVehicleInDatabase("123ABC", dummyData.generateEmptyInspectionList(), dummyData.generateEmptyInspectionList());
        assertEquals(0, vehicleDatabase.getVehicle("123ABC").getFailedInspectionList().size());
    }

}