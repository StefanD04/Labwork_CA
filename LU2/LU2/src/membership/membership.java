package membership;

public interface membership {

    double getPrice();

    default void printBenefits() {
        System.out.println("Benefits: Access to gym equipment.");
    }

    static void printGymRules() {
        System.out.println("\n========== GYM RULES ==========");
        System.out.println("1. Every customer must have a valid membership.");
        System.out.println("2. Customers must follow the gym rules.");
        System.out.println("3. Maximum registered customers: 10.");
        System.out.println("4. Premium members have access to the sauna.");
        System.out.println("================================\n");
    }
}

