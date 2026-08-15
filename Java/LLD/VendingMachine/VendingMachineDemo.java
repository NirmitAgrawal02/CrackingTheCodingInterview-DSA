package LLD.VendingMachine;

public class VendingMachineDemo {

    public static void main(String[] args) {
        VendingMachine vendingMachine = new VendingMachine(5);
        vendingMachine.addProduct("Coke", 10, 1.5);
        vendingMachine.addProduct("Pepsi", 10, 1.0);
        vendingMachine.addProduct("Sprite", 10, 1.2);
        vendingMachine.addProduct("Fanta", 10, 1.3);
        vendingMachine.addProduct("Mountain Dew", 10, 1.4);
        vendingMachine.showProducts();
        vendingMachine.ChooseProduct(1, 2);
        vendingMachine.calculateTotalAmount(1, 2);
        vendingMachine.insertMoney(Coins.QUARTER, Notes.ONE);
        while(!vendingMachine.isPaymentSufficient())
        {
            System.out.println("Payment is not sufficient .... Add Additional Money");
            vendingMachine.insertMoney(Coins.QUARTER, Notes.ONE);
        }
        vendingMachine.dispenseProduct(1, 2);
        vendingMachine.ReturnChange();
        vendingMachine.restockProducts();
    }
    
}
