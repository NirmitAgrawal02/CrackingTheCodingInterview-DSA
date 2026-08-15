package LLD.VendingMachine;

import java.util.HashMap;
import java.util.Map;

public class VendingMachine{
    static int size = 0;
    HashMap<Integer, Product> productMap = new HashMap<>();
    Payment payment;
    VendingMachine(int size)
    {
        this.size = size;
        this.payment = new Payment();

    }
    public void addProduct(String name, int quantity, double price)
    {
        if(size > 0)
        {
            Product product = new Product();
            product.setName(name);
            product.setQuantity(quantity);
            product.setPrice((int) price);
            product.setId(size--);
            productMap.put(product.getId(), product);
            size--;
        }
        else 
        {
            System.out.println("Vending Machine is full");
        }
    }
    public void showProducts()
    {
        for(Map.Entry<Integer, Product> entry : productMap.entrySet())
        {
            System.out.println("Product Name: " + entry.getValue().name + " Product Quantity: " + entry.getValue().quantity + " Product Price: " + entry.getValue().price);
        }
    }
    public void ChooseProduct(int id, int quantity)
    {
        Product product = productMap.get(id);
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
        Product product = productMap.get(id);
        if(product != null)
        {
            product.setQuantity(product.getQuantity() - quantity);
        }
        else
        {
            System.out.println("Product is not available");
        }
    }

    public void calculateTotalAmount(int id, int quantity)
    {
        Product product = productMap.get(id);
        payment.calculateTotalAmount(quantity, product.getPrice());
    }
    public void insertMoney(Coins coin, Notes note)
    {
        this.payment.insertMoney(coin, note);
    }

    public boolean isPaymentSufficient()
    {
        return this.payment.isPaymentSufficient();
    }
    public double ReturnChange()
    {
        return this.payment.calculateChange();
    }

    public void restockProducts()
    {
        for(Map.Entry<Integer, Product> entry : productMap.entrySet())
        {
            entry.getValue().setQuantity(10);
        }
    }

}
