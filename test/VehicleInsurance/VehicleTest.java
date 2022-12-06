package VehicleInsurance;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.*;

class VehicleTest {

    Vehicle testVehicle;

    @BeforeEach
    void setUp() {
        testVehicle = Vehicle.getBuilder()
                .setOwnerID(100)
                .setCurrentValue(1000.0)
                .setCurrentState("New")
                .setRegistrationNumber("CL 213")
                .build();
    }

    @AfterEach
    void tearDown() {
    }

    /**
     * Test function for the addPolicy and getPolicy functionalities.
     */
    @Test
    void getPolicy() {

        InsurancePolicy insurancePolicy = new InsurancePolicy(123, "CL 213");
        testVehicle.addPolicy(insurancePolicy);

        List<InsurancePolicy> policies = testVehicle.getPolicy();
        for (InsurancePolicy policy:policies) {
            assertEquals(policy, insurancePolicy);
        }
    }

    /**
     * Test function for the updateInventory and the getDamagedInventory functionalities.
     */
    @Test
    void getDamagedInventory() {
        testVehicle.updateInventory("Left Light");
        testVehicle.updateInventory("Right Wheel");

        List<String> expected = new ArrayList<>();
        expected.add("Left Light");
        expected.add("Right Wheel");
        assertArrayEquals(testVehicle.getDamagedInventory().toArray(), expected.toArray());

        testVehicle.updateInventory("Left Light");
        assertEquals(testVehicle.getDamagedInventory().toArray()[0], "Right Wheel");
    }

    /**
     * Test function for the registration number getter method.
     */
    @Test
    void getRegistrationNumber() {
        assertEquals(testVehicle.getRegistrationNumber(), "CL 213");
    }

    /**
     * Test function for the owner ID getter method.
     */
    @Test
    void getOwnerID() {
        assertEquals(testVehicle.getOwnerID(), 100);
    }

    /**
     * Test function for the current value getter and setter methods.
     */
    @Test
    void getCurrentValue() {
        assertEquals(testVehicle.getCurrentValue(), 1000.0);

        testVehicle.setCurrentValue(10.0);
        assertEquals(testVehicle.getCurrentValue(), 10.0);
    }

    /**
     * Test function for the toString method.
     */
    @Test
    void testToString() {
        assertEquals(testVehicle.toString(), String.format("""
                Registration Number: %s
                CurrentState: %s
                CurrentValue: %f
                ""","CL 213", "New", 1000.0));
    }
}