package VehicleInsurance;

import java.util.*;

/**
 * Insurance Policy class containing one or more plans for a given vehicle.
 * Contains the plan IDs included, risks covered by the policy as a whole.
 */
public class InsurancePolicy {
    /**
     * Attributes for the InsurancePolicy.
     * plans: Insurance Plan IDs included in a Policy.
     * risksCovered: risks covered by a policy -> union of all the risks covered by included plans.
     * vehicleRegistrationNumber: registration Number of the vehicle for the policy.
     * policyNumber: policy ID for the Company records. Acts as a key for the hashmap storing the policy objects.
     */
    private List<Integer> plans;
    private List<Risk> risksCovered;
    private final String vehicleRegistrationNumber;
    private final int policyNumber;

    /**
     * Constructor for the InsurancePolicy class. Other attributes are set after instance creation.
     * @param policyNumber policy ID for the company policy records.
     * @param vehicleRegistrationNumber vehicle to which the policy gets added.
     * Other attributes are defined as new Lists.
     */
    public InsurancePolicy(int policyNumber, String vehicleRegistrationNumber)
    {
        this.plans = new ArrayList<>();
        this.risksCovered = new ArrayList<>();
        this.policyNumber = policyNumber;
        this.vehicleRegistrationNumber = vehicleRegistrationNumber;
    }

    /**
     * Adds a new plan's risks to the policy.
     * @param riskCovered List of risks to be added to the policy coverage. Skips already covered risks.
     */
    public void updateRisksCovered(ArrayList<Risk> riskCovered) {
        for(Risk risk:riskCovered) {
            if(!this.risksCovered.contains(risk))
                this.risksCovered.add(risk);
        }
    }

    /**
     * Adds a new plan to the policy.
     * @param planID plan ID to be added to the policy.
     */
    public void updatePlans(int planID) {
        this.plans.add(planID);
    }

    /**
     * Getter method for the policy number.
     * @return policyID for the current policy. Acts as the key for the policyRecord for the Company.
     */
    public int getPolicyNumber() {
        return this.policyNumber;
    }

    /**
     * Getter method for the risks covered by the plan.
     * @return risks covered by the policy.
     */
    public List<Risk> getRisksCovered() {
        return this.risksCovered;
    }

    /**
     * Getter method for the plan IDs included in the policy.
     * @return List of planIDs included in the policy.
     */
    public List<Integer> getPlans() {
        return this.plans;
    }

    /**
     * Getter method for the registration number.
     * @return registration number as string.
     */
    public String getVehicleRegistrationNumber() {return this.vehicleRegistrationNumber;}

    /**
     * Overriding the toString function to print only relevant information for the class.
     * @return String representing the relevant information for a policy.
     */
    @Override
    public String toString() {
        return String.format("Insurance Policy Number: %d\nVehicle Details: %s\nRisks Covered: %s\n",
                this.getPolicyNumber(), this.getVehicleRegistrationNumber(), this.getRisksCovered());
    }
}
