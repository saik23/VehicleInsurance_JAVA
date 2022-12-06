package VehicleInsurance;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for the Payment class.
 */
class PaymentTest {

    Payment testPayment;// = new Payment();

    /**
     * Sets up a payment object for further tests.
     */
    @BeforeEach
    void setUp() {
        testPayment = new Payment("Michael Scott", 1, 2,
                100.0, "10-12-2022 09:10:11");
    }

    @Test
    void getPremiumAmount() {
        assertEquals(testPayment.getPremiumAmount(), 100.0);
    }

    @Test
    void getDateTime() {
        assertEquals(testPayment.getDateTime(), "10-12-2022 09:10:11");
    }

    @Test
    void getPaymentID() {
        assertEquals(testPayment.getPaymentID(), 1);
    }

    @Test
    void getPlanID() {
        assertEquals(testPayment.getPlanID(), 2);
    }

    @Test
    void getCustomerName() {
        assertEquals(testPayment.getCustomerName(), "Michael Scott");
    }

    @Test
    void testToString() {
        assertEquals(testPayment.toString(), String.format("""
                paymentID: %d
                premium: %f
                planID: %d
                customer Name: %s,
                date and time: %s
                """, 1, 100.0, 2,
                "Michael Scott", "10-12-2022 09:10:11"));
    }
}