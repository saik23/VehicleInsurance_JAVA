package VehicleInsurance;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.*;
/**
 * Test class for the Settlement class.
 */
class SettlementTest {

    Settlement testSettlement;
    /**
     * Sets up all further test by instantiating a settlement object.
     */
    @BeforeEach
    void setUp() {
        testSettlement = new Settlement(1, 2, 100.0, "VehicleAssistance",
                "CL 123");
    }

    /**
     * Test method for the getter method - getSettlementID
     */
    @Test
    void getSettlementID() {
        assertEquals(1, testSettlement.getSettlementID());
    }

    /**
     * Test method for the getter method - getPaymentDue
     */
    @Test
    void getPaymentDue() {
        assertEquals(100.0, testSettlement.getPaymentDue());
    }

    /**
     * Test method for the getter method - getClaimID
     */
    @Test
    void getClaimID() {
        assertEquals(2, testSettlement.getClaimID());
    }

    /**
     * Test method for the getter method - getVehicleID
     */
    @Test
    void getVehicleID() {
        assertEquals("CL 123", testSettlement.getVehicleID());
    }

    /**
     * Test method for the getter method - getJustification
     */
    @Test
    void getJustification() {
        assertEquals("VehicleAssistance", testSettlement.getJustification());
    }

    /**
     * Test method for the reject functionality methods: getRejected, markRejected.
     * Initially each settlement is marked as not rejected.
     * After calling markRejected the getRejected function should return true.
     */
    @Test
    void markRejected() {
        assertEquals(false, testSettlement.getRejected());
        testSettlement.markRejected();
        assertEquals(true, testSettlement.getRejected());
    }

    /**
     * Test method that verifies whether a settlement is possible given the claim and the vehicle.
     */
    @Test
    void verifyClaim() {
        // get a vehicle with default values.
        Vehicle testVehicle = Vehicle.getBuilder().build();

        // Initially no policies attached to the vehicle the verifyClaim call should return false.
        int planIdx = testSettlement.verifyClaim(testVehicle);
        assertEquals(planIdx, -1);

        // Add a policy that covers the current risk.
        InsurancePolicy testPolicy = new InsurancePolicy(1, testVehicle.getRegistrationNumber());
        ArrayList<Risk> neededRisk = new ArrayList<Risk>();
        neededRisk.add(Risk.VehicleAssistance);
        testPolicy.updateRisksCovered(neededRisk);

        testPolicy.updatePlans(1);
        testVehicle.addPolicy(testPolicy);

        planIdx = testSettlement.verifyClaim(testVehicle);
        assertEquals(planIdx, 1);
    }

    @Test
    void settle() {
        // ArrayList to initialize the risksCovered.
        ArrayList<Risk> neededRisk = new ArrayList<Risk>();
        neededRisk.add(Risk.VehicleAssistance);

        // Insurance Plan to settle against the claim.
        InsurancePlan testPlan = InsurancePlan.getBuilder()
                .setPlanNumber(1)
                .setPremium(10.0)
                .setCoverage(25.0)
                .setRisksCovered(neededRisk)
                .setCoverageCap(1000.0)
                .setDeathCoverage(25000.0)
                .build();
        Boolean isSettled = testSettlement.settle(testPlan);
        assertEquals(isSettled, true);

        // Failure Cases - coverageCap exceed.
        InsurancePlan testPlan2 = InsurancePlan.getBuilder()
                .setPlanNumber(1)
                .setPremium(10.0)
                .setCoverage(25.0)
                .setRisksCovered(neededRisk)
                .setCoverageCap(10.0)
                .setDeathCoverage(25000.0)
                .build();
        isSettled = testSettlement.settle(testPlan2);
        assertEquals(isSettled, false);
    }

    /**
     * Test method verifying the overridden method - toString
     */
    @Test
    void testToString() {
        assertEquals(testSettlement.toString(), String.format("""
                Settlement ID: %d
                Claim ID: %d
                Rejected: %b
                Payment: %f
                Vehicle ID: %s
                """, 1, 2, false, 100.0, "CL 123"));
    }
}