package VehicleInsurance;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.*;

/**
 * Vehicle Class for the Insurance company
 * Contains admin info such as Registration Number.
 * Insurance details such as: Policies, State of the vehicle, Damaged parts.
 */
public class Vehicle {
    /**
     * Attributes
     */
    private String registrationNumber;
    private int ownerID;
    private List<String> damagedInventory;
    private List<InsurancePolicy> policies;
    private double currentValue;
    private String currentState;

    /**
     * private Constructor to aid Builder class
     */
    private Vehicle(String registrationNumber, String currentState, double currentValue, List<String> damagedInventory,
                   List<InsurancePolicy> policies, int ownerID) {
        this.registrationNumber = registrationNumber;
        this.currentState = currentState;
        this.currentValue = currentValue;
        this.damagedInventory = damagedInventory;
        this.policies = policies;
        this.ownerID = ownerID;
    }

    @Contract(" -> new")
    public static @NotNull VehicleBuilder getBuilder() {
        return new VehicleBuilder();
    }
    public static class VehicleBuilder
    {
        // Same as the base class
        private String registrationNumber;
        private List<InsurancePolicy> policies;
        private double currentValue;
        private List<String> damagedInventory;
        private String currentState;
        private int ownerID;

        private VehicleBuilder() {
            this.registrationNumber = "ABC123";
            this.currentState = "New";
            this.currentValue = 1000;
            this.damagedInventory = new ArrayList<>();
            this.policies = new ArrayList<>();
            this.ownerID = 0;
        }

        // Setter functions for the builder class
        public VehicleBuilder setRegistrationNumber(String regNumber) {
            this.registrationNumber = regNumber;
            return this;
        }
        public VehicleBuilder setCurrentState(String currentState) {
            this.currentState = currentState;
            return this;
        }
        public VehicleBuilder setCurrentValue(double currentValue) {
            this.currentValue = currentValue;
            return this;
        }
        public VehicleBuilder setPolicies(List<InsurancePolicy> policies) {
            this.policies = policies;
            return this;
        }
        public VehicleBuilder setDamagedInventory(List<String> damagedInventory) {
            this.damagedInventory = damagedInventory;
            return this;
        }

        public VehicleBuilder setOwnerID(int ownerID) {
            this.ownerID = ownerID;
            return this;
        }
        public Vehicle build() {
            return new Vehicle(this.registrationNumber, this.currentState, this.currentValue, this.damagedInventory,
                    this.policies, this.ownerID);
        }
    }

    /**
     * Function to help the vehicle class view.
     * @return a string with registration Number, current state and value of the car.
     */
    @Override
    public String toString() {
        return String.format("Registration Number: %s\nCurrentState: %s\nCurrentValue: %f\n",
                this.registrationNumber,
                this.currentState,
                this.currentValue
        );
    }

    /**
     * Add a policy to the vehicle. Policy includes one or more insurance plans and protects against a set of risks.
     * @param policy: Insurance Policy to add to the vehicle.
     */
    public void addPolicy(InsurancePolicy policy) {
        this.policies.add(policy);
    }

    /**
     * Getter method for the policies associated with the vehicle.
     * @return List of insurance policies linked to the vehicle.
     */
    public List<InsurancePolicy> getPolicy() {
        return this.policies;
    }

    /**
     * Getter method for all the damaged Inventory of the vehicle.
     * @return List of Strings representing inventory
     */
    public List<String> getDamagedInventory() {
        return this.damagedInventory;
    }

    /**
     * Getter method for the registration number
     * @return registration number
     */
    public String getRegistrationNumber() {
        return this.registrationNumber;
    }

    /**
     * Getter method for the ownerID
     * @return owner's ID from the system.
     */
    public int getOwnerID() { return this.ownerID;}
    /**
     * Add an inventory to the damagedInventory or take an inventory off the list after replacement.
     * @param damagedPart String representation of the inventory. If already present in the list it's removed.
     *                   If not it's added to the list.
     */
    public void updateInventory(String damagedPart) {
        if(this.damagedInventory.contains(damagedPart)) {
            this.damagedInventory.remove(damagedPart);
        }
        else {
            this.damagedInventory.add(damagedPart);
        }
    }

    public void setCurrentValue(double newValue) {
        this.currentValue = newValue;
    }

    public void setCurrentState(String newState) {
        this.currentState = newState;
    }
    public double getCurrentValue() {return this.currentValue;}
}
