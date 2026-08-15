package LLD.VendingMachine;

import java.util.List;

public class Payment {

    private double totalAmount = 0;
    private double insertedAmount = 0;
    public void calculateTotalAmount(int quantity, double price) {
        this.totalAmount = quantity * price;
        System.out.println("Total Amount: " + this.totalAmount);
    }
    public void insertMoney(List<Coins> coins, List<Notes> notes) {
        for(Coins coin : coins) {
            this.insertedAmount += coin.getValue();
        }
        for(Notes note : notes) {
            this.insertedAmount += note.getValue();
        }
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
    public void clearState()
    {
        this.totalAmount = 0;
        this.insertedAmount = 0;
    }
    
}
