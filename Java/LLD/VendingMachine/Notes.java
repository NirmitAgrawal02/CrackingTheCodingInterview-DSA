package LLD.VendingMachine;
public enum Notes{
    
    Zero(0), ONE(1), TWO(2), FIVE(5), TEN(10), TWENTY(20), FIFTY(50), HUNDRED(100);

    private final int value;

    Notes(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}