package LLD.VendingMachine;

public class Payment {

    private double totalAmount = 0;
    private double insertedAmount = 0;
    public void calculateTotalAmount(int quantity, double price) {
        this.totalAmount = quantity * price;
        System.out.println("Total Amount: " + this.totalAmount);
    }
    public void insertMoney(Coins coin, Notes note) {
        this.insertedAmount += coin.getValue() + note.getValue();
        System.out.println("Money Inserted: " + this.insertedAmount);
    }
    public boolean isPaymentSufficient() {
        return this.insertedAmount >= this.totalAmount;
    }
    public double calculateChange() {
        double change = this.insertedAmount - this.totalAmount;
        System.out.println("Change: " + change);
        return change;
    }
    
}
