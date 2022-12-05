package VehicleInsurance;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.*;

/**
 * Vehicle Class for the Insurance company
 * Contains admin info such as Registration Number, owner ID, current value, and state.
 * Insurance details such as: Policies, State of the vehicle, Damaged parts.
 */
public class Vehicle {
    /**
     * Attributes for the Vehicle Class.
     * registrationNumber: vehicle registration number as a string.
     * ownerID: Customer ID, expected to be entered in the system before adding the vehicle.
     * damagedInventory: damaged vehicle parts to be updated after each claim/accident.
     * currentValue: value of the vehicle appreciated by the company.
     * currentState: currentState of the vehicle from: New, Used-New, Used-Good, Used-defective, Damaged.
     */
    private final String registrationNumber;
    private final int ownerID;
    private final List<String> damagedInventory;
    private final List<InsurancePolicy> policies;
    private double currentValue;
    private String currentState;

    /**
     * Private Constructor to be used by the Builder Class usage for instantiation.
     * @param registrationNumber vehicle registration number.
     * @param currentState current state of the vehicle (one of: New, Used-New, Used-Good, Used-defective, Damaged.)
     * @param currentValue current value of the vehicle appreciated by the company.
     * @param damagedInventory list of damaged parts of the vehicle.
     * @param policies list of policies for the vehicle.
     * @param ownerID customerID from the system that owns this vehicle.
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

    /**
     * Vehicle Builder object returned by the static function.
     * @return VehicleBuilder object
     */
    @Contract(" -> new")
    public static @NotNull VehicleBuilder getBuilder() {
        return new VehicleBuilder();
    }

    /**
     * Vehicle Builder class for the Vehicle Class. Example usage of the Builder Pattern.
     */
    public static class VehicleBuilder
    {
        // Same as the base class
        private String registrationNumber;
        private List<InsurancePolicy> policies;
        private double currentValue;
        private List<String> damagedInventory;
        private String currentState;
        private int ownerID;

        /**
         * Vehicle Builder constructor class. Default values are set here for each attribute.
         */
        private VehicleBuilder() {
            this.registrationNumber = "ABC123";
            this.currentState = "New";
            this.currentValue = 1000;
            this.damagedInventory = new ArrayList<>();
            this.policies = new ArrayList<>();
            this.ownerID = 0;
        }

        /**
         * Setter method for the vehicle's registration number.
         * @param regNumber registration number for the vehicle.
         * @return VehicleBuilder Class object.
         */
        public VehicleBuilder setRegistrationNumber(String regNumber) {
            this.registrationNumber = regNumber;
            return this;
        }

        /**
         * Setter method for the vehicle's current state.
         * @param currentState current state of the vehicle (one of: New, Used-New, Used-Good, Used-defective, Damaged.)
         * @return VehicleBuilder class object.
         */
        public VehicleBuilder setCurrentState(String currentState) {
            this.currentState = currentState;
            return this;
        }

        /**
         * Setter method for current value of the vehicle.
         * @param currentValue current value of the vehicle in dollars.
         * @return VehicleBuilder class object.
         */
        public VehicleBuilder setCurrentValue(double currentValue) {
            this.currentValue = currentValue;
            return this;
        }

        /**
         * Setter method for the ownerID
         * @param ownerID customerID for the vehicle's owner
         * @return VehicleBuilder object
         */
        public VehicleBuilder setOwnerID(int ownerID) {
            this.ownerID = ownerID;
            return this;
        }

        /**
         * Builds the vehicle object using the values set from the above setter functions.
         * @return Vehicle object with attributes set in the setter functions or defaults from the builder constructor.
         */
        public Vehicle build() {
            return new Vehicle(this.registrationNumber, this.currentState, this.currentValue, this.damagedInventory,
                    this.policies, this.ownerID);
        }
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
     * This logic helps to use same function for adding inventory to the list or removing an item from the list.
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

    /**
     * Setter method for the currentValue
     * @param newValue new value for the vehicle appreciated by the company.
     */
    public void setCurrentValue(double newValue) {
        this.currentValue = newValue;
    }

    /**
     * Setter method for the currentState.
     * @param newState new state after an accident or usage over time.
     */
    public void setCurrentState(String newState) {
        this.currentState = newState;
    }

    /**
     * Getter method for current value of the vehicle.
     * @return current value for the vehicle.
     */
    public double getCurrentValue() {return this.currentValue;}

    /**
     * Function to help the vehicle class view.
     * @return a string with registration Number, current state and value of the car.
     */
    @Override
    public String toString() {
        return String.format("""
                Registration Number: %s
                CurrentState: %s
                CurrentValue: %f
                """,
                this.registrationNumber, this.currentState, this.currentValue);
    }
}
