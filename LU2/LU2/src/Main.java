import membership.basic_membership;
import membership.membership;
import membership.Premium_membership;
import models.customer;
import services.gymservices;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        gymservices gymService = new gymservices();

        membership.printGymRules();

        boolean running = true;

        while (running) {

            System.out.println("\n========== GYM MANAGEMENT ==========");
            System.out.println("1. Add new customer");
            System.out.println("2. Show all customers");
            System.out.println("3. Show customer count");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            String choice = scanner.nextLine();

            switch (choice) {

                case "1":
                    addCustomerManually(scanner, gymService);
                    break;

                case "2":
                    gymService.printAllCustomers();
                    break;

                case "3":
                    System.out.println(
                            "Registered customers: "
                                    + gymService.getCustomerCount()
                    );
                    break;

                case "4":
                    running = false;
                    System.out.println("Goodbye!");
                    break;

                default:
                    System.out.println(
                            "Invalid option. Please choose 1, 2, 3, or 4."
                    );
            }
        }

        scanner.close();
    }

    private static void addCustomerManually(
            Scanner scanner,
            gymservices gymService) {

        if (gymService.getCustomerCount() >= 10) {
            System.out.println(
                    "The gym is full! Maximum capacity is 10 customers."
            );
            return;
        }

        System.out.println("\n========== ADD NEW CUSTOMER ==========");

        System.out.print("Enter customer name: ");
        String name = scanner.nextLine().trim();

        if (name.isEmpty()) {
            System.out.println("Name cannot be empty.");
            return;
        }

        int age;

        try {
            System.out.print("Enter customer age: ");
            age = Integer.parseInt(scanner.nextLine());

            if (age <= 0) {
                System.out.println("Age must be a positive integer.");
                return;
            }

        } catch (NumberFormatException e) {
            System.out.println(
                    "Invalid age. Please enter a whole number."
            );
            return;
        }

        System.out.println("\nChoose membership type:");
        System.out.println("1. Basic - 30.00 EUR");
        System.out.println("2. Premium - 60.00 EUR (includes sauna)");
        System.out.print("Enter 1 or 2: ");

        String membershipChoice = scanner.nextLine().trim();

        membership selectedMembership;

        switch (membershipChoice) {

            case "1":
                selectedMembership = new basic_membership();
                System.out.println("Basic membership selected.");
                break;

            case "2":
                selectedMembership = new Premium_membership();
                System.out.println("Premium membership selected.");
                break;

            default:
                System.out.println(
                        "Invalid choice! Please enter 1 for Basic or 2 for Premium."
                );
                return;
        }

        try {
            customer newCustomer = new customer(
                    name,
                    age,
                    selectedMembership
            );

            if (gymService.addCustomer(newCustomer)) {
                System.out.println("Customer registered successfully!");
            }

        } catch (IllegalArgumentException e) {
            System.out.println(
                    "Could not register customer: " + e.getMessage()
            );
        }
    }
}