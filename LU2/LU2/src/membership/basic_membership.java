package membership;

public class basic_membership implements membership {
    private static final double price = 30;

    @Override
    public double getPrice() {
        return price;
    }

}
