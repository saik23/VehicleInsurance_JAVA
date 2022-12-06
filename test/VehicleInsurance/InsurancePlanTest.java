package VehicleInsurance;

import junit.framework.TestCase;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test code for the insurance plan class.
 */
class InsurancePlanTest extends TestCase {

    InsurancePlan insurancePlan;

    /**
     * Sets up the other test functions by creating an object to test.
     * @throws Exception
     */
    @org.junit.jupiter.api.BeforeEach
    public void setUp() throws Exception {
        super.setUp();
        ArrayList<Risk> risks = new ArrayList<>();
        risks.add(Risk.VehicleAssistance);
        risks.add(Risk.PersonalInjury);

        insurancePlan = InsurancePlan.getBuilder().
                setPlanNumber(34).
                setPremium(10).
                setCoverage(20).
                setCoverageCap(1000).
                setDeathCoverage(10000).
                setRisksCovered(risks).
                setVehicleValue(1000.0).build();
    }

    /**
     * Test function for toString functionality
     */
    @org.junit.jupiter.api.Test
    void testToString() {
        String expected = String.format("""
                                         Insurance Plan ID: %d
                                         Premium: %f
                                         Coverage: %f
                                         Coverage Cap: %f
                                         Death Coverage: %f
                                         Risks Covered: %s
                                         """, 34, 10000.0, 20000.0, 1000.0, 10000.0,
                "[VehicleAssistance, PersonalInjury]");
        assertEquals(insurancePlan.toString(), expected);
    }

    /**
     * Test function for the planNumber getter method.
     */
    @org.junit.jupiter.api.Test
    void getPlanNumber() {
        assertEquals(insurancePlan.getPlanNumber(), 34);
    }

    /**
     * Test functions for the premium getter method.
     */
    @org.junit.jupiter.api.Test
    void getPremium() {
        assertEquals(insurancePlan.getPremium(), 10.0);
    }

    /**
     * Test function for the coverage getter method.
     */
    @org.junit.jupiter.api.Test
    void getCoverage() {
        assertEquals(insurancePlan.getCoverage(), 20.0);
    }

    /**
     * Test functions for the coverage cap getter method.
     */
    @org.junit.jupiter.api.Test
    void getCoverageCap() {
        assertEquals(insurancePlan.getCoverageCap(), 1000.0);
    }

    /**
     * Test function for the death coverage getter method.
     */
    @org.junit.jupiter.api.Test
    void getDeathCoverage() {
        assertEquals(insurancePlan.getDeathCoverage(), 10000.0);
    }

    /**
     * Test function for the coverageCap update method.
     */
    @org.junit.jupiter.api.Test
    void updateCoverageCap() {
        assertEquals(insurancePlan.updateCoverageCap(100), 900.0);
        assertEquals(insurancePlan.updateCoverageCap(100), 800.0);
        assertEquals(insurancePlan.updateCoverageCap(200), 600.0);
    }
}