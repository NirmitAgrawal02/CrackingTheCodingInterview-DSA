package LLD.VendingMachine;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VendingMachine{
    int size = 0;
    HashMap<Integer, Product> productMap = new HashMap<>();
    Payment payment;
    VendingMachine(int size)
    {
        this.size = size;
        this.payment = new Payment();

    }
    public void addProduct(String name, int quantity, double price)
    {
        if(size > 0 && quantity > 0)
        {
            Product product = new Product();
            product.setName(name);
            product.setQuantity(quantity);
            product.setPrice(price);
            product.setId(size--);
            this.productMap.put(product.getId(), product);
        }
        else 
        {
            System.out.println("Vending Machine is full");
        }
    }
    public void showProducts()
    {
        for(Map.Entry<Integer, Product> entry : this.productMap.entrySet())
        {
            System.out.println("Product Name: " + entry.getValue().name + " Product Quantity: " + entry.getValue().quantity + " Product Price: " + entry.getValue().price);
        }
    }
    public void ChooseProduct(int id, int quantity)
    {
        Product product = this.productMap.get(id);
        if(quantity <= 0)
        {
            System.out.println("Invalid Quantity");
            return;
        }
        if(product != null)
        {
            if(product.getQuantity() >= quantity)
            {
                System.out.println("Product is available");
            }
            else
            {
                System.out.println("Product is not available");
            }
        }
        else
        {
            System.out.println("Product is not available");
        }
    }
    public void dispenseProduct(int id, int quantity)
    {
        Product product = this.productMap.get(id);
        product.setQuantity(product.getQuantity() - quantity);
    }

    public void calculateTotalAmount(int id, int quantity)
    {
        Product product = productMap.get(id);
        payment.calculateTotalAmount(quantity, product.getPrice());
    }
    public void insertMoney(List<Coins> coins, List<Notes> notes)
    {
        this.payment.insertMoney(coins, notes);
    }

    public boolean isPaymentSufficient()
    {
        return this.payment.isPaymentSufficient();
    }
    public double ReturnChange()
    {
        double change = this.payment.calculateChange();
        this.clearState();
        return change;
    }

    public void restockProducts()
    {
        for(Map.Entry<Integer, Product> entry : productMap.entrySet())
        {
            entry.getValue().setQuantity(10);
        }
    }
    public void clearState()
    {
        this.payment.clearState();
    }

}
