package VehicleInsurance;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for InsuranceCompany - the main model for the project
 */
class InsuranceCompanyTest {

    InsuranceCompany insuranceCompany;

    /**
     * Sets up the insuranceCompany instance for all further tests.
     */
    @BeforeEach
    void setUp() {
        insuranceCompany = new InsuranceCompany();
    }

    @Test
    void getPlanDetails() {

        ArrayList<String> obligatoryPlanDetails = new ArrayList<>();
        obligatoryPlanDetails.add("ThirdParty");
        obligatoryPlanDetails.add("0.1");
        obligatoryPlanDetails.add("0.2");
        obligatoryPlanDetails.add("1000");
        obligatoryPlanDetails.add("0");

        ArrayList<String> personalInjuryPlanDetails = new ArrayList<>();
        personalInjuryPlanDetails.add("PersonalInjury");
        personalInjuryPlanDetails.add("0.2");
        personalInjuryPlanDetails.add("0.4");
        personalInjuryPlanDetails.add("2500");
        personalInjuryPlanDetails.add("25000");

        ArrayList<String> vehicleDamagePlanDetails = new ArrayList<>();
        vehicleDamagePlanDetails.add("VehicleDamage");
        vehicleDamagePlanDetails.add("0.15");
        vehicleDamagePlanDetails.add("0.4");
        vehicleDamagePlanDetails.add("4000");
        vehicleDamagePlanDetails.add("0");

        ArrayList<String> vehicleAssistanceDetails = new ArrayList<>();
        vehicleAssistanceDetails.add("VehicleAssistance");
        vehicleAssistanceDetails.add("0.1");
        vehicleAssistanceDetails.add("0.3");
        vehicleAssistanceDetails.add("2000");
        vehicleAssistanceDetails.add("0");

        ArrayList<String> allCoverDetails = new ArrayList<>();
        allCoverDetails.add("ThirdParty PersonalInjury VehicleDamage VehicleAssistance");
        allCoverDetails.add("0.3");
        allCoverDetails.add("0.9");
        allCoverDetails.add("10000");
        allCoverDetails.add("100000");

        assertArrayEquals(obligatoryPlanDetails.toArray(), insuranceCompany.getPlanDetails("Obligatory").toArray());
        assertArrayEquals(personalInjuryPlanDetails.toArray(), insuranceCompany.getPlanDetails("Injury").toArray());
        assertArrayEquals(vehicleDamagePlanDetails.toArray(), insuranceCompany.getPlanDetails("Damage").toArray());
        assertArrayEquals(vehicleAssistanceDetails.toArray(), insuranceCompany.getPlanDetails("Assistance").toArray());
        assertArrayEquals(allCoverDetails.toArray(), insuranceCompany.getPlanDetails("All").toArray());
    }

    /**
     * Test function for getCustomerCounter and incrementCustomerCounter.
     */
    @Test
    void customerCounter() {
        assertEquals(insuranceCompany.getCustomerCounter(), 0);
        insuranceCompany.incrementCustomerCounter();
        assertEquals(insuranceCompany.getCustomerCounter(), 1);
    }

    /**
     * Test function for getPlanCounter and incrementPlanCounter.
     */
    @Test
    void planCounter() {
        assertEquals(insuranceCompany.getPlanCounter(), 0);
        insuranceCompany.incrementPlanCounter();
        assertEquals(insuranceCompany.getPlanCounter(), 1);
    }

    /**
     * Test function for getPolicyCounter and incrementPolicyCounter.
     */
    @Test
    void policyCounter() {
        assertEquals(insuranceCompany.getPolicyCounter(), 0);
        insuranceCompany.incrementPolicyCounter();
        assertEquals(insuranceCompany.getPolicyCounter(), 1);
    }

    /**
     * Test function for getClaimCounter and incrementClaimCounter
     */
    @Test
    void claimCounter() {
        assertEquals(insuranceCompany.getClaimCounter(), 0);
        insuranceCompany.incrementClaimCounter();
        assertEquals(insuranceCompany.getClaimCounter(), 1);
    }

    /**
     * Test function for getSettlementCounter and incrementSettlementCounter
     */
    @Test
    void settlementCounter() {
        assertEquals(insuranceCompany.getSettlementCounter(), 0);
        insuranceCompany.incrementSettlementCounter();
        assertEquals(insuranceCompany.getSettlementCounter(), 1);
    }

    /**
     * Test function for getPaymentCounter and incrementPaymentCounter.
     */
    @Test
    void paymentCounter() {
        assertEquals(insuranceCompany.getPaymentCounter(), 0);
        insuranceCompany.incrementPaymentCounter();
        assertEquals(insuranceCompany.getPaymentCounter(), 1);
    }

    /**
     * Test function for getReceiptCounter and incrementReceiptCounter.
     */
    @Test
    void receiptCounter() {
        assertEquals(insuranceCompany.getReceiptCounter(), 0);
        insuranceCompany.incrementReceiptCounter();
        assertEquals(insuranceCompany.getReceiptCounter(), 1);
    }

    /**
     * Test for updateVehicleRecord and getVehicleRecord functions.
     */
    @Test
    void vehicleRecord() {
        // Create a vehicle with all default values to test.
        Vehicle testVehicle = Vehicle.getBuilder().build();
        insuranceCompany.updateVehicleRecord(testVehicle.getRegistrationNumber(), testVehicle);

        assertEquals(testVehicle, insuranceCompany.getVehicleRecord(testVehicle.getRegistrationNumber()));
    }

    /**
     * Test function to verify if vehicle record exists in the system.
     */
    @Test
    void checkVehicleRecord() {
        // Create a vehicle with all default values to test.
        Vehicle testVehicle = Vehicle.getBuilder().build();
        insuranceCompany.updateVehicleRecord(testVehicle.getRegistrationNumber(), testVehicle);

        assertEquals(insuranceCompany.checkVehicleRecord(testVehicle.getRegistrationNumber()), true);
        assertEquals(insuranceCompany.checkVehicleRecord("Random String"), false);
    }

    /**
     * Test function for getCustomerRecord, updateCustomerRecord
     */
    @Test
    void customerRecord() {
        // Create a customer with all default values.
        Customer testCustomer = new Customer(1, "Abc", "xyz@abc");
        insuranceCompany.updateCustomerRecord(0, testCustomer);

        assertEquals(testCustomer, insuranceCompany.getCustomerRecord(0));
    }

    /**
     * Test function to verify if a customerID is valid.
     */
    @Test
    void checkCustomerRecord() {
        // Create a customer with all default values.
        Customer testCustomer = new Customer(1, "Abc", "xyz@abc");
        insuranceCompany.updateCustomerRecord(0, testCustomer);

        assertEquals(insuranceCompany.checkCustomerRecord(0), true);
        assertEquals(insuranceCompany.checkCustomerRecord(11), false);
    }

    /**
     * Test function for updatePlanRecord and getPlanRecord
     */
    @Test
    void planRecord() {
        //Create an InsurancePlan object with all default values to test.
        InsurancePlan testPlan = InsurancePlan.getBuilder().build();
        insuranceCompany.updatePlanRecord(0, testPlan);

        assertEquals(testPlan, insuranceCompany.getPlanRecord(0));
    }

    /**
     * Test function for updatePolicyRecord and getPolicyRecord.
     */
    @Test
    void policyRecord() {
        // Create an InsurancePolicy with all default values to test.
        InsurancePolicy testPolicy = new InsurancePolicy(0, "CL 123");
        insuranceCompany.updatePolicyRecord(0, testPolicy);

        assertEquals(insuranceCompany.getPolicyRecord(0), testPolicy);
    }

    /**
     * Test function to verify if a claimID is valid.
     */
    @Test
    void checkClaimRecord() {
        Claim testClaim = new Claim(0, "CL 123", "11-12-2022 10:11:22");
        insuranceCompany.updateClaimRecord(0, testClaim);

        assertEquals(insuranceCompany.checkClaimRecord(0), true);
        assertEquals(insuranceCompany.checkClaimRecord(1), false);
    }

    /**
     * Test function for updateClaimRecord and getClaimRecord
     */
    @Test
    void claimRecord() {
        Claim testClaim = new Claim(0, "CL 123", "11-12-2022 10:11:22");
        insuranceCompany.updateClaimRecord(0, testClaim);

        assertEquals(insuranceCompany.getClaimRecord(0), testClaim);
    }

    /**
     * Test function for updateSettlementRecord and getSettlementRecord.
     */
    @Test
    void settlementRecord() {
        Settlement testSettlement = new Settlement(0, 1, 100.0,
                "PersonalInjury", "CL 123");
        insuranceCompany.updateSettlementRecord(0, testSettlement);

        assertEquals(insuranceCompany.getSettlementRecord(0), testSettlement);
    }

    /**
     * Test function for updatePaymentRecord and getPaymentRecord.
     */
    @Test
    void paymentRecord() {
        Payment testPayment = new Payment("ABC", 1, 2, 100.0,
                "11-12-2022 10:11:22");
        insuranceCompany.updatePaymentRecord(1, testPayment);

        assertEquals(insuranceCompany.getPaymentRecord(1), testPayment);
    }

    /**
     * Test function for updateReceiptRecord and getReceiptRecord
     */
    @Test
    void receiptRecord() {
        Receipt testReceipt = new Receipt(0, 1, "Abc", "Xyz",
                "11-12-2022 10:11:22", 100.0);
        insuranceCompany.updateReceiptRecord(0, testReceipt);

        assertEquals(insuranceCompany.getReceiptRecord(0), testReceipt);
    }


    /**
     * Test function to verify a string is parsed appropriately as a Risk.
     */
    @Test
    void parseStringToRisks() {
        String riskString = "ThirdParty";
        ArrayList<Risk> expected = new ArrayList<>();
        expected.add(Risk.ThirdParty);

        assertArrayEquals(expected.toArray(), insuranceCompany.parseStringToRisks(riskString).toArray());

        riskString = "ThirdParty VehicleAssistance VehicleDamage";
        expected.add(Risk.VehicleAssistance);
        expected.add(Risk.VehicleDamage);
        assertArrayEquals(expected.toArray(), insuranceCompany.parseStringToRisks(riskString).toArray());
    }
}