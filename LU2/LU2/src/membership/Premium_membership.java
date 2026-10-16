package membership;

public class Premium_membership implements  membership{

    private static final double price = 60;


    @Override

    public double getPrice() {
        return price;
    }

    public void printBenefits() {
        System.out.println(
                "Benefits: Access to gym equipment and sauna."
        );
    }


}
