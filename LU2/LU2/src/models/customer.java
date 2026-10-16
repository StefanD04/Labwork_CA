package models;

import membership.membership;
import membership.basic_membership;
import membership.Premium_membership;

public class customer {

    private String name;
    private int age;
    private membership membership;

    public customer(String name, double age, membership membership) {

        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException(
                    "Customer name cannot be empty."
            );
        }

        if (age <= 0 || age != (int) age) {
            throw new IllegalArgumentException(
                    "Customer age must be a positive integer."
            );
        }

        if (membership == null) {
            throw new IllegalArgumentException(
                    "Membership cannot be null."
            );
        }

        this.name = name;
        this.age = (int) age;
        this.membership = membership;
    }

    public void Print_info() {

        System.out.println("\n---------- CUSTOMER INFO ----------");
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);

        if (membership instanceof basic_membership) {
            System.out.println("Membership: Basic");
        } else if (membership instanceof Premium_membership) {
            System.out.println("Membership: Premium");
        }

        System.out.printf(
                "Membership price: %.2f EUR%n",
                membership.getPrice()
        );

        membership.printBenefits();

        System.out.println("-----------------------------------");
    }
}
