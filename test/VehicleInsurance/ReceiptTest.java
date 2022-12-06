package VehicleInsurance;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for the receipt class.
 */
class ReceiptTest {

    Receipt testReceipt;

    /**
     * Instantiates a receipt object for all the other tests to use.
     */
    @BeforeEach
    void setUp() {
        testReceipt = new Receipt(1, 2, "Insurance Company",
                "Michael Scott", "10-12-2022 09:10:11", 100.0);
    }

    @Test
    void getDateTime() {
        assertEquals(testReceipt.getDateTime(), "10-12-2022 09:10:11");
    }

    @Test
    void getPayee() {
        assertEquals(testReceipt.getPayee(), "Insurance Company");
    }

    @Test
    void getPayer() {
        assertEquals(testReceipt.getPayer(), "Michael Scott");
    }

    @Test
    void getPaymentID() {
        assertEquals(testReceipt.getPaymentID(), 2);
    }

    @Test
    void getReceiptID() {
        assertEquals(testReceipt.getReceiptID(), 1);
    }

    @Test
    void getAmountPaid() {
        assertEquals(testReceipt.getAmountPaid(), 100.0);
    }

    @Test
    void testToString() {
        assertEquals(testReceipt.toString(), String.format("""
        ReceiptID: %d
        PaymentID: %d
        amount: %f
        Paid By: %s
        Paid To: %s
        Date Time: %s
        """, 1, 2, 100.0, "Michael Scott", "Insurance Company", "10-12-2022 09:10:11"));
    }
}