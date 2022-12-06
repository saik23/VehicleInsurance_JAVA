package VehicleInsurance;

import java.util.*;

/**
 * Customer class that contains vehicles, policies for each vehicle.
 * A customer can create a claim, and get it settled. Pays premium to activate a plan.
 */
public class Customer {
    /**
     * Attributes:
     * Admin Info: Name, Contact Info, Vehicles, Claims, Payments.
     * Member Functions to: add a policy to a car, payPremium, createClaim
     */
    private final int customerID;
    private String name;
    private String contactInfo;

    private List<String> vehicles;
    private List<Integer> claims;
    private List<Integer> payments;

    /**
     * Constructor for the Customer class.
     * @param customerID a number assigned to each customer by the system to keep track of the records.
     * @param name Name of the customer
     * @param contactInfo Email ID of the customer for records.
     */
    public Customer(int customerID,  String name, String contactInfo) {
        this.customerID =  customerID;
        this.name = name;
        this.contactInfo = contactInfo;
        this.vehicles = new ArrayList<>();
        this.claims = new ArrayList<>();
        this.payments = new ArrayList<>();
    }


    /**
     * Getter method for the customer name
     * @return customer name
     */
    public String getName(){
        return this.name;
    }

    /**
     * Setter method for the customer name
     * Currently not used, but allows name changes.
     * @param newName Updated name for the customer.
     */
    public void updateName(String newName) {
        this.name = newName;
    }

    /**
     * Update the contact info of the customer
     * @param newContactInfo new email ID to be used for communication
     */
    public void updateContactInfo(String newContactInfo) {
        this.contactInfo = newContactInfo;
    }

    /**
     * Getter method for the contact info
     * @return email ID of the customer
     */
    public String getContactInfo() {
        return this.contactInfo;
    }

    /**
     * Getter method for the customer ID
     * @return customer ID
     */
    public int getCustomerID() {
        return this.customerID;
    }

    /**
     * Add a vehicle to the customer.
     * @param vehicleRegistrationNumber registration number of the vehicle.
     */
    public void updateVehicles(String vehicleRegistrationNumber) {
        this.vehicles.add(vehicleRegistrationNumber);
    }

    /**
     * Getter method for the list of vehicles owned by the customer
     * @return list of registration numbers
     */
    public List<String> getVehicles() {
        return this.vehicles;
    }

    /**
     * Getter method for the payments list.
     * @return list of payment IDs for all the premium payments made.
     */
    public List<Integer> getPayments() {
        return this.payments;
    }

    /**
     * Getter method fot the claims done by the customer.
     * @return list of claim IDs.
     */
    public List<Integer> getClaims() {
        return this.claims;
    }

    /**
     * Updates the claims made by the customer.
     * @param claimID claim ID of the latest claim done by the customer.
     */
    void addClaim(int claimID) {
        this.claims.add(claimID);
    }

    /**
     * Overridden toString function to print only relevant information from the object.
     * @return String representing relevant information about the customer.
     */
    @Override
    public String toString() {
        return String.format("""
                Customer Name: %s
                Contact Info: %s
                Customer ID: %d
                """, this.getName(), this.getContactInfo(), this.getCustomerID());
    }
}
