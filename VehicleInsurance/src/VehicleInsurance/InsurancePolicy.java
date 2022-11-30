package VehicleInsurance;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Insurance Policy class containing one or more plans for a vehicle.
 * Attributes: Plans, Risks, Claims, Vehicle, PolicyNumber
 */
public class InsurancePolicy {
    /**
     * Attributes
     */
    private List<Integer> plans;
    private List<Risk> risksCovered;
    private String vehicleRegistrationNumber;
    private final int policyNumber;

    public InsurancePolicy(int policyNumber)
    {
        this.plans = new ArrayList<>();
        this.risksCovered = new ArrayList<>();
        this.policyNumber = policyNumber;
    }

    /**
     * Member functions.
     */

    public void updateRisksCovered(ArrayList<Risk> riskCovered) {
        for(Risk risk:riskCovered) {
            this.risksCovered.add(risk);
        }
    }

    public void updatePlans(int planID) {
        this.plans.add(planID);
    }

    public void setVehicle(String vehicleRegistrationNumber) {
        this.vehicleRegistrationNumber = vehicleRegistrationNumber;
    }

    public int getPolicyNumber() {
        return this.policyNumber;
    }

    public List<Risk> getRisksCovered() {
        return this.risksCovered;
    }

    public List<Integer> getPlans() {
        return this.plans;
    }

    @Override
    public String toString() {
        return String.format("Insurance Policy Number: %d\nVehicle Details: %s\nRisks Covered: %s\n",
                this.getPolicyNumber(), this.vehicleRegistrationNumber, this.risksCovered);//this.getRisksString());
    }
}
