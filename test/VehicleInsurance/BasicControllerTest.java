package VehicleInsurance;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for the controller class.
 */
class BasicControllerTest {

    InsuranceCompany testCompany;

    /**
     * Sets up all further controller tests by instantiating the model and view.
     */
    @BeforeEach
    void setUp() {
        testCompany = new InsuranceCompany();
    }

    /**
     * Test function to verify the add vehicle functionality.
     * Inputs are read from the string. outputs are verified from the model records.
     */
    @Test
    void goAddVehicle() {
        Reader in = new StringReader("abc\n");
        BasicController testController = new BasicController(in, System.out);
        // verify failure and correct cases.
        testController.goAddVehicle(testCompany, new Scanner(in));

        in = new StringReader("123\n");
        testController.goAddVehicle(testCompany, new Scanner(in));

        in = new StringReader("Michael\nabc@xyz.com\n");
        testController.goAddCustomer(testCompany, new Scanner(in));
        in = new StringReader("0\nCL 123\n100.0\nNew\n");
        testController.goAddVehicle(testCompany, new Scanner(in));
        assertEquals(1, testCompany.getCustomerRecord(0).getVehicles().size());
    }

    /**
     * Tests the functionality of the addPlan call from the controller.
     * Inputs are read from the string, verification of functionality is done through the model records.
     */
    @Test
    void goAddPlan() {
        Reader in = new StringReader("CL 123\nAll\n");
        BasicController testController = new BasicController(in, System.out);

        // verify failure cases.
        testController.goAddPlan(testCompany, new Scanner(in));

        // Add a vehicle to add this plan to.
        in = new StringReader("Michael\nabc@xyz.com\n");
        testController.goAddCustomer(testCompany, new Scanner(in));
        in = new StringReader("0\nCL 123\n100.0\nNew\n");
        testController.goAddVehicle(testCompany, new Scanner(in));

        in = new StringReader("CL 123\nRandomString");
        testController.goAddPlan(testCompany, new Scanner(in));

        in = new StringReader("CL 123\nAll\n");
        testController.goAddPlan(testCompany, new Scanner(in));
        assertEquals(1, testCompany.getPlanCounter());
    }

    /**
     * Test function to verify customer entry to the system.
     */
    @Test
    void goAddCustomer() {
        Reader in = new StringReader("Michael\nabc.in\n");
        BasicController testController = new BasicController(in, System.out);

        // Fairly simple-naive customer registry. No checks involved.
        testController.goAddCustomer(testCompany, new Scanner(in));
        assertEquals(1, testCompany.getCustomerCounter());
    }

    /**
     * Test function to verify the claim process.
     */
    @Test
    void goClaim() {
        Reader in = new StringReader("");
        BasicController testController = new BasicController(in, System.out);

        // Add a customer
        in = new StringReader("Michael\nabc@xyz.com\n");
        testController.goAddCustomer(testCompany, new Scanner(in));
        // Add a vehicle
        in = new StringReader("0\nCL 123\n100.0\nNew\n");
        testController.goAddVehicle(testCompany, new Scanner(in));

        // Add a plan
        in = new StringReader("CL 123\nAll\n");
        testController.goAddPlan(testCompany, new Scanner(in));

        // Failure cases.
        in = new StringReader("RandomRegNumber\n");
        testController.goClaim(testCompany, new Scanner(in));

        in = new StringReader("CL 123\nabc\n");
        testController.goClaim(testCompany, new Scanner(in));

        in = new StringReader("CL 123\n-1\n");
        testController.goClaim(testCompany, new Scanner(in));

        in = new StringReader("CL 123\n2\nSelf\nabc\n");
        testController.goClaim(testCompany, new Scanner(in));

        in = new StringReader("CL 123\n2\nSelf\n100.0\nRandomJustification\n");
        testController.goClaim(testCompany, new Scanner(in));

        // Expected to work correctly
        in = new StringReader("CL 123\n2\nSelf\n100.0\nVehicleDamage\nCity\n150.0\nThirdParty");
        testController.goClaim(testCompany, new Scanner(in));
        assertEquals(1, testCompany.getClaimCounter());
    }

    /**
     * Test function to verify the settlement process.
     */
    @Test
    void goSettle() {
        Reader in = new StringReader("");
        BasicController testController = new BasicController(in, System.out);

        // Failure cases.
        in = new StringReader("0\n");
        testController.goSettle(testCompany, new Scanner(in));


        // Add a customer
        in = new StringReader("Michael\nabc@xyz.com\n");
        testController.goAddCustomer(testCompany, new Scanner(in));
        // Add a vehicle
        in = new StringReader("0\nCL 123\n100.0\nNew\n");
        testController.goAddVehicle(testCompany, new Scanner(in));

        // Add a plan
        in = new StringReader("CL 123\nAll\n");
        testController.goAddPlan(testCompany, new Scanner(in));

        in = new StringReader("CL 123\n2\nSelf\n100.0\nVehicleDamage\nCity\n150.0\nThirdParty");
        testController.goClaim(testCompany, new Scanner(in));
        in = new StringReader("0\n");
        testController.goSettle(testCompany, new Scanner(in));
        assertEquals(false, testCompany.getSettlementRecord(0).getRejected());
        assertEquals(false, testCompany.getSettlementRecord(1).getRejected());

        in = new StringReader("CL 123\n2\nSelf\n10.0\nVehicleDamage\nCity\n150000.0\nThirdParty");
        testController.goClaim(testCompany, new Scanner(in));
        in = new StringReader("1\n");
        testController.goSettle(testCompany, new Scanner(in));
        // this incident will be settled as the coverage cap won't be exceeded.
        assertEquals(false, testCompany.getSettlementRecord(2).getRejected());
        // this incident will be rejected as the coverage cap will be exceeded.
        assertEquals(true, testCompany.getSettlementRecord(3).getRejected());
    }

    /**
     * Simple verification to check input-output are properly passes to the controller.
     * All the other methods handle the main implementation.
     */
    @Test
    void go() {
    }
}