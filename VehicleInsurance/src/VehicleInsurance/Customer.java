package VehicleInsurance;

import java.util.*;
/**
 * Customer class that contains vehicles, policies for each vehicle
 * Customer can create a claim, and get it settled. Pays premium to activate a plan.
 */
public class Customer {
    /**
     * Attributes: Admin Info: Name, Contact Info, Vehicles, Claims, Payments.
     * Member Functions to: add a policy to a car, payPremium, createClaim
     */
    private final int customerID;
    private String name;
    private String contactInfo;

    private List<String> vehicles;
    private List<Integer> claims;
    private List<Integer> payments;

    public Customer(int customerID,  String name, String contactInfo) {
        // default customer creation.
        // update the vehicles, claims, payments as the system progresses.
        this.customerID =  customerID;
        this.name = name;
        this.contactInfo = contactInfo;
        this.vehicles = new ArrayList<>();
        this.claims = new ArrayList<>();
        this.payments = new ArrayList<>();
    }

    /**
     * Member functions: setter and getter methods
     */
    public String getName(){
        return this.name;
    }
    public void updateName(String newName) {
        this.name = newName;
    }
    public void updateContactInfo(String newContactInfo) {
        this.contactInfo = newContactInfo;
    }
    public String getContactInfo() {
        return this.contactInfo;
    }
    public int getCustomerID() {
        return this.customerID;
    }

    public void updateVehicles(String vehicleRegistrationNumber) {
        this.vehicles.add(vehicleRegistrationNumber);
    }
    public List<String> getVehicles() {
        return this.vehicles;
    }

    public void makePayment(double paymentAmount) {
        // TODO: add this to the payments list for the user and in the main storage.
    }
    public List<Integer> getPayments() {
        return this.payments;
    }

    public List<Integer> getClaims() {
        return this.claims;
    }

    void addClaim(int claimID) {
        this.claims.add(claimID);
    }

    @Override
    public String toString() {
        return String.format("Customer Name: %s\nContact Info: %s\nCustomer ID: %d",
                this.getName(), this.getContactInfo(), this.getCustomerID());
    }
}
