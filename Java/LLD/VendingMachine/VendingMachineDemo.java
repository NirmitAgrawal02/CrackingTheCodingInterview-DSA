package LLD.VendingMachine;

import java.util.ArrayList;
import java.util.List;

public class VendingMachineDemo {

    public static void main(String[] args) {
        List<Coins> coins = new ArrayList<>();
        List<Notes> notes = new ArrayList<>();
        VendingMachine vendingMachine = new VendingMachine(5);
        vendingMachine.addProduct("Coke", 10, 1.5);
        vendingMachine.addProduct("Pepsi", 10, 1.0);
        vendingMachine.addProduct("Sprite", 10, 1.2);
        vendingMachine.addProduct("Fanta", 10, 1.3);
        vendingMachine.addProduct("Mountain Dew", 10, 1.4);
        vendingMachine.showProducts();
        vendingMachine.ChooseProduct(1, 2);
        vendingMachine.calculateTotalAmount(1, 2);
        coins.add(Coins.QUARTER);
        coins.add(Coins.QUARTER);
        notes.add(Notes.ONE);
        vendingMachine.insertMoney(coins, notes);
        while(!vendingMachine.isPaymentSufficient())
        {
            System.out.println("Payment is not sufficient .... Add Additional Money");
            vendingMachine.insertMoney(coins, notes);
        }
        vendingMachine.dispenseProduct(1, 2);
        vendingMachine.ReturnChange();
        vendingMachine.clearState();
        vendingMachine.restockProducts();
    }
    
}
