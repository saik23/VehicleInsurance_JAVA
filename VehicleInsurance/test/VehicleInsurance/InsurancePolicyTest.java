package VehicleInsurance;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for insurance policy class.
 */
class InsurancePolicyTest {

    InsurancePolicy insurancePolicy;

    /**
     * Instantiation of the insurancePolicy for further test.
     */
    @BeforeEach
    void setUp() {
        insurancePolicy = new InsurancePolicy(23, "TS 7685");
    }

    @Test
    void updateRisksCovered() {
        ArrayList<Risk> riskCovered1 = new ArrayList<>();
        ArrayList<Risk> riskCovered2 = new ArrayList<>();
        ArrayList<Risk> riskCovered3 = new ArrayList<>();
        ArrayList<Risk> riskCovered4 = new ArrayList<>();

        riskCovered1.add(Risk.PersonalInjury);
        riskCovered1.add(Risk.VehicleDamage);
        riskCovered2.add(Risk.ThirdParty);
        riskCovered2.add(Risk.VehicleAssistance);
        riskCovered3.add(Risk.PersonalInjury);
        riskCovered4.add(Risk.VehicleAssistance);

        ArrayList<Risk> expectRisks = new ArrayList<>();
        expectRisks.addAll(riskCovered1);
        expectRisks.addAll(riskCovered2);

        insurancePolicy.updateRisksCovered(riskCovered1);
        assertArrayEquals(insurancePolicy.getRisksCovered().toArray(), riskCovered1.toArray());
        insurancePolicy.updateRisksCovered(riskCovered2);
        assertArrayEquals(insurancePolicy.getRisksCovered().toArray(), expectRisks.toArray());

        // No update to the risksCovered.
        insurancePolicy.updateRisksCovered(riskCovered3);
        assertArrayEquals(insurancePolicy.getRisksCovered().toArray(), expectRisks.toArray());

        // No update to the riskCovered.
        insurancePolicy.updateRisksCovered(riskCovered4);
        assertArrayEquals(insurancePolicy.getRisksCovered().toArray(), expectRisks.toArray());
    }

    /**
     * Test function for the updatePlan member function.
     */
    @Test
    void updatePlans() {
        insurancePolicy.updatePlans(12);
        insurancePolicy.updatePlans(23);
        insurancePolicy.updatePlans(34);

        List<Integer> expectedPlans = new ArrayList<>();
        expectedPlans.add(12);
        expectedPlans.add(23);
        expectedPlans.add(34);

        assertArrayEquals(insurancePolicy.getPlans().toArray(), expectedPlans.toArray());
    }

    /**
     * test for the policy number getter method.
     */
    @Test
    void getPolicyNumber() {
        assertEquals(insurancePolicy.getPolicyNumber(), 23);
    }

    /**
     * test for the toString functionality.
     */
    @Test
    void testToString() {

        ArrayList<Risk> riskCovered1 = new ArrayList<>();
        ArrayList<Risk> riskCovered2 = new ArrayList<>();

        riskCovered1.add(Risk.PersonalInjury);
        riskCovered1.add(Risk.VehicleDamage);
        riskCovered2.add(Risk.ThirdParty);
        riskCovered2.add(Risk.VehicleAssistance);

        insurancePolicy.updateRisksCovered(riskCovered1);
        insurancePolicy.updateRisksCovered(riskCovered2);

        assertEquals(insurancePolicy.toString(), String.format("""
                Insurance Policy Number: %d
                Vehicle Details: %s
                Risks Covered: %s
                """,
                23, "TS 7685", "[PersonalInjury, VehicleDamage, ThirdParty, VehicleAssistance]"));
    }
}