package VehicleInsurance;

import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.text.SimpleDateFormat;
import java.util.*;
/**
 * Main class that hold together all the information regarding risks, plans, policies, users, claims, and settlements.
 */
public class InsuranceCompany {
    /**
     * Attributes
     */
    private Map<String, Vehicle> vehicleRecord;
    private int planCounter;
    private Map<Integer, InsurancePlan> planRecord;
    private Map<String, ArrayList<String>> planDetails;
    private int policyCounter;
    private Map<Integer, InsurancePolicy> policyRecord;
    private int customerCounter;
    private Map<Integer, Customer> customerRecord;
    private int receiptCounter;
    private Map<Integer, Receipt> receiptRecord;
    private int claimCounter;
    private Map<Integer, Claim> claimRecord;
    private int settlementCounter;
    private Map<Integer, Settlement> settlementRecord;
    private int paymentCounter;
    private Map<Integer, Payment> paymentRecord;

    public InsuranceCompany() {
        // TODO: Add some details?
        planCounter = 0;
        policyCounter = 0;
        customerCounter = 0;
        paymentCounter = 0;
        receiptCounter = 0;

        planRecord = new HashMap<>();
        policyRecord = new HashMap<>();
        customerRecord = new HashMap<>();
        vehicleRecord = new HashMap<>();

        planDetails = new HashMap<>();

        // Set the plan details.
        // TODO: Make this dynamic.
        // TODO: Create a struct/class for this.
        ArrayList<String> obligatoryPlanDetails = new ArrayList<>();
        obligatoryPlanDetails.add("None");
        obligatoryPlanDetails.add("10");
        obligatoryPlanDetails.add("10");

        ArrayList<String> personalInjuryPlanDetails = new ArrayList<>();
        personalInjuryPlanDetails.add("PersonalInjury");
        personalInjuryPlanDetails.add("10");
        personalInjuryPlanDetails.add("10");

        ArrayList<String> vehicleDamagePlanDetails = new ArrayList<>();
        vehicleDamagePlanDetails.add("VehicleDamage");
        vehicleDamagePlanDetails.add("10");
        vehicleDamagePlanDetails.add("10");

        ArrayList<String> vehicleAssistanceDetails = new ArrayList<>();
        vehicleAssistanceDetails.add("VehicleAssistance");
        vehicleAssistanceDetails.add("10");
        vehicleAssistanceDetails.add("10");

        ArrayList<String> allCoverDetails = new ArrayList<>();
        allCoverDetails.add("PersonalInjury VehicleDamage VehicleAssistance");
        allCoverDetails.add("10");
        allCoverDetails.add("10");

        planDetails.put("Obligatory", obligatoryPlanDetails);
        planDetails.put("Injury", personalInjuryPlanDetails);
        planDetails.put("Damage", vehicleDamagePlanDetails);
        planDetails.put("Assistance", vehicleAssistanceDetails);
        planDetails.put("All", allCoverDetails);
    }

    /**
     * Member functions to keep/update the records
     */
    public void incrementCustomerCounter() {
        this.customerCounter+=1;
    }
    public int getCustomerCounter() {
        return this.customerCounter;
    }
    public ArrayList<String> getPlanDetails(String key) {
        return this.planDetails.get(key);
    }

    public int getReceiptCounter() {
        return this.receiptCounter;
    }
    public void incrementReceiptCounter() {
        this.receiptCounter+=1;
    }

    public int getPaymentCounter() {
        return this.paymentCounter;
    }
    public void incrementPaymentCounter() {
        this.paymentCounter+=1;
    }

    public int getClaimCounter() {
        return this.claimCounter;
    }
    public void incrementClaimCounter() {
        this.claimCounter+=1;
    }
    public int getPlanCounter() {
        return this.planCounter;
    }
    public void incrementPlanCounter() {
        this.planCounter+=1;
    }
    public void incrementPolicyCounter() {
        this.policyCounter += 1;
    }
    public int getPolicyCounter() {
        return this.policyCounter;
    }
    public Customer getCustomerRecord(int customerID) { return this.customerRecord.get(customerID); }

    public Receipt getReceiptRecord(int receiptID) {
        return this.receiptRecord.get(receiptID);
    }

    public Boolean checkClaimRecord(int claimID) {return this.claimRecord.containsKey(claimID);}
    public Claim getClaimRecord(int claimID) {
        return this.claimRecord.get(claimID);
    }

    public int getSettlementCounter() {return this.settlementCounter;}
    public void incrementSettlementCounter() {this.settlementCounter+=1;}
    public Settlement getSettlementRecord(int settlementID) {
        return this.settlementRecord.get(settlementID);
    }

    public InsurancePlan getPlanRecord(int planID) {return this.planRecord.get(planID);}
    public InsurancePolicy getPolicyRecord(int policyID) {
        return this.policyRecord.get(policyID);
    }

    public Payment getPayment(int paymentID) {
        return this.paymentRecord.get(paymentID);
    }

    public void updateVehicleRecord(String registrationNumber, Vehicle vehicle) {
        this.vehicleRecord.put(registrationNumber, vehicle);
    }
    public Boolean checkVehicleRecord(String registrationNumber) {
        return this.vehicleRecord.containsKey(registrationNumber);
    }

    public Vehicle getVehicleRecord(String registrationNumber) {
        return this.vehicleRecord.get(registrationNumber);
    }
    public Boolean checkCustomerRecord(int customerID) {
        return this.customerRecord.containsKey(customerID);
    }
    public void updateCustomerRecord(int customerID, Customer customer) {
        this.customerRecord.put(customerID, customer);
    }

    public void updateReceiptRecord(int receiptID, Receipt receipt) {
        this.receiptRecord.put(receiptID, receipt);
    }

    public void updateClaimRecord(int claimID, Claim claim) {
        this.claimRecord.put(claimID, claim);
    }

    public void updateSettlementRecord(int settlementID, Settlement settlement) {
        this.settlementRecord.put(settlementID, settlement);
    }

    public void updatePolicyRecord(int policyID, InsurancePolicy insurancePolicy) {
        this.policyRecord.put(policyID, insurancePolicy);
    }

    public void updatePlanRecord(int planID, InsurancePlan insurancePlan) {
        this.planRecord.put(planID, insurancePlan);
    }
    public void updatePaymentRecord(int paymentID, Payment payment) {
    }

    // Functionality for the insurance.
    public void claimSettlements() {
    }

    public String getDateTime()
    {
        Date curDate = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("MM-dd-yyyy HH:mm:ss");
        return formatter.format(curDate);
    }

    public ArrayList<Risk> parseStringToRisks(String risks)
    {
        ArrayList<Risk> risksCovered = new ArrayList<>();
        String[] strSplit = risks.split(" ");
        for(String str:strSplit)
        {
            risksCovered.add(Risk.valueOf(str));
        }
        return risksCovered;
    }
    public static void main(String[] args) {
        BasicController controller = new BasicController(new InputStreamReader(System.in), System.out);
        controller.go(new InsuranceCompany());
    }
}

/**
 * A controller class for the insurance company
 * main method from above only creates the model - InsuranceCompany Object and calls the controller.
 * Controller takes input from user, runs the model, ends the program after printing receipts.
 */
class BasicController implements VehicleInsuranceController {
    final Readable in;
    final Appendable out;

    BasicController(Readable in, Appendable out) {
        this.in = in;
        this.out = out;
    }

    public void go(InsuranceCompany insuranceCompany) {
        Objects.requireNonNull(insuranceCompany);
        Scanner scanner = new Scanner(this.in);

        // TODO: Move this to a View interface/class.
        // TODO: Update the view when adding a new command.
        System.out.println("#########################################################################################");
        System.out.println("Welcome to the Vehicle Insurance Application. Please choose one of the following options:");
        System.out.println("#########################################################################################");
        System.out.println("To add a vehicle: add_vehicle");
        System.out.println("To add a plan to a vehicle: add_plan");
        System.out.println("To add a customer to the system: add_customer");
        System.out.println("To edit a customer of the system: edit_customer");
        System.out.println("To create a claim: claim");
        System.out.println("To settle a claim: settle");
        System.out.println("#########################################################################################");

        // Start the system
        System.out.print("What would you like to do today: ");

        while(scanner.hasNext()) {
            String inputCommand = scanner.nextLine();

            switch(inputCommand) {
                // TODO: Command Design Pattern to simplify the switch case logic.
                case "quit":
                    System.out.println("You entered quit. Exiting the application");
                    return;
                case "add_vehicle":
                    // Calling a builder pattern function to get the instance.
                    // Customer linked to the vehicle?
                    System.out.print("Enter the customerID you want to add this vehicle to: ");
                    int customerID = scanner.nextInt();
                    scanner.nextLine();
                    if(!insuranceCompany.checkCustomerRecord(customerID))
                    {
                        System.out.println("Please enter the customer into the system before adding vehicle to him.");
                        break;
                    }

                    System.out.print("Enter the vehicle's registration number: ");
                    String registrationNumber = scanner.nextLine();
                    System.out.print("Enter the vehicle's current value: ");
                    double currentValue = scanner.nextDouble();
                    scanner.nextLine();
                    System.out.print("Enter the vehicle's current state: ");
                    String currentState = scanner.nextLine();
                    Vehicle newVehicle = Vehicle.getBuilder().
                            setCurrentValue(currentValue).
                            setRegistrationNumber(registrationNumber).
                            setCurrentValue(currentValue).
                            setCurrentState(currentState).
                            setOwnerID(customerID).
                            build();

                    insuranceCompany.updateVehicleRecord(registrationNumber, newVehicle);
                    Customer customer = insuranceCompany.getCustomerRecord(customerID);
                    customer.updateVehicles(registrationNumber);
                    System.out.println("New vehicle entered into the system:");
                    System.out.println(newVehicle.toString());
                    break;
                case "add_plan":
                    // Get the vehicle details to add the plan.
                    // Get the policy if existing. Or create a new policy for this plan.
                    System.out.print("Enter the vehicle registration Number you want to add this plan to:");
                    String vehicleRegistrationNumber = scanner.nextLine();
                    // Check if the vehicle exists.
                    if(!insuranceCompany.checkVehicleRecord(vehicleRegistrationNumber))
                    {
                        System.out.println("Please enter the vehicle into the system before adding a plan to it.");
                        break;
                    }

                    // Add this plan to an existing policy or a new one
                    System.out.print("Enter the policy number you want to add this plan to," +
                            " or enter -1 to create a new policy with the current plan: ");
                    int policyID = scanner.nextInt();
                    scanner.nextLine();
                    InsurancePolicy policy;
                    if(policyID<0) {
                        // Create a new Policy
                        policy = new InsurancePolicy(insuranceCompany.getPolicyCounter());
                        // Instantiate the policy
                        policy.setVehicle(vehicleRegistrationNumber);
                        insuranceCompany.incrementPolicyCounter();
                    }
                    else {
                        policy = insuranceCompany.getPolicyRecord(policyID);
                    }
                    System.out.print("Enter the type of plan you are looking from the following options" +
                            "(Obligatory, Damage, Injury, Assistance, All): ");
                    String planType = scanner.nextLine();

                    ArrayList<String> planDetails = insuranceCompany.getPlanDetails(planType);
                    ArrayList<Risk> risksCovered = insuranceCompany.parseStringToRisks(planDetails.get(0));
                    double premium = Double.parseDouble(planDetails.get(1));
                    double coverage = Double.parseDouble(planDetails.get(2));

                    Vehicle vehicle = insuranceCompany.getVehicleRecord(vehicleRegistrationNumber);
                    InsurancePlan insurancePlan = InsurancePlan.getBuilder().
                            setPlanNumber(insuranceCompany.getPlanCounter()).
                            setPremium(premium).
                            setCoverage(coverage).
                            setRisksCovered(risksCovered).
                            setVehicleValue(vehicle.getCurrentValue()).
                            build();
                    insuranceCompany.incrementPlanCounter();

                    // Update the policy with new plans and risks covered.
                    policy.updatePlans(insurancePlan.getPlanNumber());
                    policy.updateRisksCovered(risksCovered);

                    // Update the records
                    insuranceCompany.updatePlanRecord(insurancePlan.getPlanNumber(), insurancePlan);
                    insuranceCompany.updatePolicyRecord(policy.getPolicyNumber(), policy);

                    // TODO: Create a payment object before adding and accepting the plan for the vehicle.
                    // TODO: Add a receipt after the payment is done.
                    // Enter the premiumPayment Details.

                    Customer vehicleOwner = insuranceCompany.getCustomerRecord(vehicle.getOwnerID());
                    String dateTime = insuranceCompany.getDateTime();
                    Payment newPayment = new Payment(vehicleOwner.getName(), insuranceCompany.getPaymentCounter(),
                            insurancePlan.getPlanNumber(),
                            insurancePlan.getPremium()*vehicle.getCurrentValue(),
                            dateTime
                            );
                    insuranceCompany.incrementPaymentCounter();
                    insuranceCompany.updatePaymentRecord(newPayment.getPaymentID(), newPayment);
                    System.out.println("Premium amount for the plan: " +
                            newPayment.getPremiumAmount());
                    System.out.println("#########################################################################################");

                    System.out.println("New plan added to the vehicle:");
                    System.out.println(insurancePlan.toString());
                    System.out.println("#########################################################################################");
                    System.out.println("Policy details:");
                    // TODO: Check if toString is implicit.
                    System.out.println(policy);

                    Receipt paymentReceipt = new Receipt(insuranceCompany.getReceiptCounter(),
                            newPayment.getPaymentID(),
                            "InsuranceCompany",
                            vehicleOwner.getName(),
                            dateTime,
                            newPayment.getPremiumAmount()
                    );
                    insuranceCompany.incrementReceiptCounter();
                    System.out.println("#########################################################################################");
                    System.out.println("Receipt generated for the payment: ");
                    System.out.println(paymentReceipt.toString());
                    break;
                case "add_customer":
                    //Customer newCustomer = new Customer(0, "abc", "xyz@gmail.com");
                    System.out.print("Enter the customer's name: ");
                    String name = scanner.nextLine();
                    // TODO: Prompt informing only accepting email IDs now.
                    System.out.print("Enter the customer's contact info: ");
                    String contactInfo = scanner.nextLine();
                    // TODO: Check how to add vehicle details to the customer object.
                    customerID = insuranceCompany.getCustomerCounter();
                    insuranceCompany.incrementCustomerCounter();
                    Customer newCustomer = new Customer(customerID, name, contactInfo);

                    // Update the records.
                    insuranceCompany.updateCustomerRecord(newCustomer.getCustomerID(), newCustomer);
                    System.out.println("New customer added");
                    System.out.println(newCustomer.toString());
                    break;
                case "claim":
                    System.out.print("Enter the vehicle registration Number you want to add this plan to:");
                    vehicleRegistrationNumber = scanner.nextLine();
                    // Check if the vehicle exists.
                    if(!insuranceCompany.checkVehicleRecord(vehicleRegistrationNumber))
                    {
                        System.out.println("Please enter the vehicle into the system before making claims for it.");
                        break;
                    }

                    System.out.print("Enter the number of third parties involved in the claim:");
                    int numberOfIncidents = scanner.nextInt();
                    scanner.nextLine();

                    dateTime = insuranceCompany.getDateTime();

                    Claim claim = new Claim(insuranceCompany.getClaimCounter(), vehicleRegistrationNumber, dateTime);
                    insuranceCompany.incrementClaimCounter();

                    System.out.println("Enter the name, payment expected, justification " +
                            "for each third party involved in the accident:");
                    while(numberOfIncidents-- > 0) {
                        System.out.print("Enter the name of the third party: ");
                        String name3P = scanner.nextLine();
                        System.out.print("Enter the compensation for the third party: ");
                        double compensation = scanner.nextDouble();
                        scanner.nextLine();
                        System.out.print("Enter the justification for the compensation expected: ");
                        String justification = scanner.nextLine();

                        claim.updateDestinations(name3P);
                        claim.updatePaymentsDue(compensation);
                        claim.updateJustifications(justification);
                    }

                    // Add the claim to the system.
                    insuranceCompany.updateClaimRecord(claim.getClaimID(), claim);
                    System.out.println("Claim created");
                    System.out.println(claim);
                    break;
                case "settle":
                    System.out.println("Enter the claim ID to settle:");
                    int claimID = scanner.nextInt();
                    scanner.nextLine();

                    if(!insuranceCompany.checkClaimRecord(claimID)) {
                        System.out.println("Please enter a claim before attempting to settle it.");
                        break;
                    }
                    Claim currentClaim = insuranceCompany.getClaimRecord(claimID);

                    // Check if already settled
                    if(currentClaim.getSettled()) {
                        System.out.println("Claim already settled. Settlement IDs:"+currentClaim.getSettlements());
                        break;
                    }

                    List<Double> paymentsDue = currentClaim.getPaymentsDue();
                    List<String> destinations = currentClaim.getDestinations();
                    List<String> justifications = currentClaim.getJustification();
                    int numberOfParties = destinations.size();

                    for(int thirdParty=0; thirdParty<numberOfParties; thirdParty++) {
                        // Create a settlement for each issue.
                        Settlement newSettlement = new Settlement(insuranceCompany.getSettlementCounter(),
                                currentClaim.getClaimID(),
                                paymentsDue.get(thirdParty),
                                justifications.get(thirdParty),
                                currentClaim.getVehicle()
                                );
                        insuranceCompany.incrementSettlementCounter();

                        int planIdx = newSettlement.verifyClaim(
                                insuranceCompany.getVehicleRecord(currentClaim.getVehicle()));
                        if(planIdx==-1) {
                            // Unable to settle.
                            System.out.println("Unable to settle this claim due to lack of plans covering this risk.");
                        }
                        else {
                            // call settle on the plan.
                            Boolean settled = newSettlement.settle(insuranceCompany.getPlanRecord(planIdx));
                            if(!settled) {
                                System.out.println("Unable to settle this claim as the plan's coverage cap reached");
                            }
                        }

                        insuranceCompany.updateSettlementRecord(newSettlement.getSettlementID(), newSettlement);
                        currentClaim.updateSettlements(newSettlement.getSettlementID());

                        // TODO: If settlement successful print the receipt for the same and update the receipt records.
                    }

                    currentClaim.markSettled();
                    System.out.println("Settlements processed");
                    break;
                default:
                    System.out.println("Unknown option detected. Please select again");
                    break;
            }
            System.out.print("What would you like to do today: ");
        }
    }
}