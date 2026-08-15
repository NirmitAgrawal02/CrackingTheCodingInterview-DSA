package LLD.VendingMachine;

public class VendingMachine {
    HashMap<Product, Integer> productMap = new HashMap<>();
    int size = 0;

    VendingMachine(int size)
    {
        this.size = size;
    }
    public void addProduct(Product product, int quantity)
    {
        if(size > 0)
        {
            productMap.put(product, quantity);
            size--;
        }
    }
    public void showProducts()
    {
        for(Map.Entry<Product, Integer> entry : productMap.entrySet())
        {
            System.out.println("Product Name: " + entry.getKey().name + " Product Quantity: " + entry.Key().quantity + " Product Price: " + entry.getKey().price);
        }
    }
    public void ChooseProduct(int id, int quantity)
    {
        
    }
    public void dispenseProduct(int id, int quantity)
    {

    }
    public void InsertMoney(Money coin, Money note)
    {

    }
    public void ReturnChange(Money coin, Money note)
    {

    }
    public void displayMessage(String Message)
    {

    }


}
