package VehicleInsurance;

public class View {
    View() {
        // Nothing for now.
    }

    public void displayInterface() {
        System.out.println("########################################################################################");
        System.out.println("Welcome to the Vehicle Insurance Application. Please choose one of the following options:");
        System.out.println("#########################################################################################");
        System.out.println("To add a vehicle: add_vehicle");
        System.out.println("To add a plan to a vehicle: add_plan");
        System.out.println("To add a customer to the system: add_customer");
        System.out.println("To edit a customer of the system: edit_customer");
        System.out.println("To create a claim: claim");
        System.out.println("To settle a claim: settle");
        System.out.println("#########################################################################################");
    }

    public void displayControllerPrompt(String input) {
        System.out.print(input);
    }

    public void displayControllerOut(String output) {
        System.out.println(output);
    }
}