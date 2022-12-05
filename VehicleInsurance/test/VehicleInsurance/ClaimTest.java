package VehicleInsurance;

import com.sun.jdi.IntegerType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for the Claim class functionalities.
 */
class ClaimTest {

    Claim testClaim;
    /**
     * Sets up all further tests by creating an instance of claim.
     */
    @BeforeEach
    void setUp() {
        testClaim = new Claim(1, "CL 123", "10-12-2022 09:10:11");
    }

    /**
     * test function for the getter method - getClaimID.
     */
    @Test
    void getClaimID() {
        assertEquals(1, testClaim.getClaimID());
    }

    /**
     * Test function for the getter method - getSettled.
     */
    @Test
    void getSettled() {
        assertEquals(false, testClaim.getSettled());
    }

    /**
     * Test method for the setter method - markSettled.
     */
    @Test
    void markSettled() {
        testClaim.markSettled();
        assertEquals(true, testClaim.getSettled());
    }

    /**
     * Tests for both functionalities - updatePaymentsDue, and getPaymentsDue.
     * Add paymentDue and check if updates and gets are equal.
     */
    @Test
    void getPaymentsDue() {
        List<Double> expected = new ArrayList<>();
        assertArrayEquals(expected.toArray(), testClaim.getPaymentsDue().toArray());

        testClaim.updatePaymentsDue(120.0);
        expected.add(120.0);
        assertArrayEquals(expected.toArray(), testClaim.getPaymentsDue().toArray());

        testClaim.updatePaymentsDue(200.0);
        expected.add(200.0);
        assertArrayEquals(expected.toArray(), testClaim.getPaymentsDue().toArray());
    }

    /**
     * Test method that verifies the functioning of two methods: updateJustification, getJustification.
     * justifications are added and verified alternatively.
     */
    @Test
    void getJustification() {
        List<String> expected = new ArrayList<>();
        assertArrayEquals(expected.toArray(), testClaim.getJustification().toArray());

        testClaim.updateJustifications("VehicleDamage");
        expected.add("VehicleDamage");
        assertArrayEquals(expected.toArray(), testClaim.getJustification().toArray());

        testClaim.updateJustifications("PersonalInjury");
        expected.add("PersonalInjury");
        assertArrayEquals(expected.toArray(), testClaim.getJustification().toArray());

        // not a copy paste mistake. justification list should allow duplicates.
        testClaim.updateJustifications("PersonalInjury");
        expected.add("PersonalInjury");
        assertArrayEquals(expected.toArray(), testClaim.getJustification().toArray());
    }

    /**
     * Tets method that verifies the functionality of two class methods: updateDestinations and getDestinations.
     * Destinations are added and verified alternatively.
     */
    @Test
    void getDestinations() {
        List<String> expected = new ArrayList<>();
        assertArrayEquals(expected.toArray(), testClaim.getDestinations().toArray());

        testClaim.updateDestinations("Self");
        expected.add("Self");
        assertArrayEquals(expected.toArray(), testClaim.getDestinations().toArray());

        // not a copy paste mistake. destination list should allow duplicates.
        testClaim.updateDestinations("Self");
        expected.add("Self");
        assertArrayEquals(expected.toArray(), testClaim.getDestinations().toArray());

        testClaim.updateDestinations("City");
        expected.add("City");
        assertArrayEquals(expected.toArray(), testClaim.getDestinations().toArray());
    }

    /**
     * Test method that verifies the functionality of two class methods: updateSettlements and getSettlements.
     * Adds a settlementID and verifies alternatively.
     */
    @Test
    void getSettlements() {
        List<Integer> expected = new ArrayList<>();
        assertArrayEquals(expected.toArray(), testClaim.getSettlements().toArray());

        testClaim.updateSettlements(1);
        expected.add(1);
        assertArrayEquals(expected.toArray(), testClaim.getSettlements().toArray());

        testClaim.updateSettlements(2);
        expected.add(2);
        assertArrayEquals(expected.toArray(), testClaim.getSettlements().toArray());

        testClaim.updateSettlements(3);
        expected.add(3);
        assertArrayEquals(expected.toArray(), testClaim.getSettlements().toArray());
    }

    /**
     * Test function for the getter method - getDateTime.
     */
    @Test
    void getDateTime() {
        assertEquals("10-12-2022 09:10:11", testClaim.getDateTime());
    }

    /**
     * Test function for the getter method - getVehicle.
     */
    @Test
    void getVehicle() {
        assertEquals("CL 123", testClaim.getVehicle());
    }

    /**
     * Test method for the overridden function - toString.
     */
    @Test
    void testToString() {

        testClaim.updateDestinations("Self");
        testClaim.updateDestinations("City");
        testClaim.updatePaymentsDue(100.0);
        testClaim.updatePaymentsDue(150.0);

        assertEquals(testClaim.toString(), String.format("""
                Claim ID: %d
                Vehicle Registration Number: %s
                Compensation amounts: %s
                Third Parties: %s
                Date and Time:%s
                Settled: %b
                 """,
                1, "CL 123", "[100.0, 150.0]",
                "[Self, City]", "10-12-2022 09:10:11", false));
    }
}