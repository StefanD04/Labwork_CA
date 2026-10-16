package services;

import models.customer;

public class gymservices {

    private static final int MAX_CAPACITY = 10;

    private final customer[] customers = new customer[MAX_CAPACITY];
    private int customerCount = 0;

    public boolean addCustomer(customer newCustomer) {

        if (newCustomer == null) {
            System.out.println("Customer cannot be null.");
            return false;
        }

        if (customerCount >= MAX_CAPACITY) {
            System.out.println("Gym is full! Maximum 10 customers.");
            return false;
        }

        customers[customerCount] = newCustomer;
        customerCount++;

        System.out.println("Customer registered successfully!");
        System.out.println("Total customers: " + customerCount);

        return true;
    }

    public void printAllCustomers() {

        if (customerCount == 0) {
            System.out.println("No customers registered yet.");
            return;
        }

        System.out.println("\n========== REGISTERED CUSTOMERS ==========");

        for (int i = 0; i < customerCount; i++) {

            System.out.println("\nCustomer #" + (i + 1));

            customers[i].Print_info();
        }

        System.out.println("\nTotal registered customers: " + customerCount);
        System.out.println("==========================================");
    }

    public int getCustomerCount() {
        return customerCount;
    }
}