package VehicleInsurance;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.*;

class CustomerTest {

    Customer testCustomer;

    /**
     * Setup function to create customer instance for all further tests.
     */
    @BeforeEach
    void setUp() {
        testCustomer = new Customer(1, "Michael Scott", "mikescott@gmail.com");
    }

    @AfterEach
    void tearDown() {
    }

    /**
     * test function for the name getter method.
     */
    @Test
    void getName() {
        assertEquals(testCustomer.getName(), "Michael Scott");
    }

    /**
     * Test function for the name update method.
     */
    @Test
    void updateName() {
        testCustomer.updateName("Michael Gary Scott");
        assertEquals(testCustomer.getName(), "Michael Gary Scott");
    }

    /**
     * Test function for the contact-info update method.
     */
    @Test
    void updateContactInfo() {
        testCustomer.updateContactInfo("scottiemike@yahoo.com");
        assertEquals(testCustomer.getContactInfo(), "scottiemike@yahoo.com");
    }

    /**
     * Test function for customer ID getter method.
     */
    @Test
    void getCustomerID() {
        assertEquals(testCustomer.getCustomerID(), 1);
    }

    /**
     * Test function for update and get vehicles functionality.
     */
    @Test
    void updateVehicles() {
        testCustomer.updateVehicles("CL 234");
        testCustomer.updateVehicles("ME 977");

        assertEquals(testCustomer.getVehicles().get(0), "CL 234");
        assertEquals(testCustomer.getVehicles().get(1), "ME 977");
    }

    @Test
    void testToString() {
        assertEquals(testCustomer.toString(), String.format("""
                Customer Name: %s
                Contact Info: %s
                Customer ID: %d
                """, "Michael Scott", "mikescott@gmail.com", 1));
    }
}