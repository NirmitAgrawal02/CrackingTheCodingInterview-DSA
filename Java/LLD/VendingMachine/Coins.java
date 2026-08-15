package LLD.VendingMachine;
public enum Coins {
    PENNY(0.01), NICKEL(0.05), DIME(0.10), QUARTER(0.25), HALF_DOLLAR(0.50), DOLLAR(1.00);

    private final double value;

    Coins(double value) {
        this.value = value;
    }

    public double getValue() {
        return value;
    }
}