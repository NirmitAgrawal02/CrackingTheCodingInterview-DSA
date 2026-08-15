package LLD.VendingMachine;

public class Product {
    int id;
    int quantity;
    String name;
    int price;

    public int getId() {
        return id;
    }
    public int getQuantity() {
        return quantity;
    }
    public String getName() {
        return name;
    }
    public double getPrice() {
        return price;
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setPrice(int price) {
        this.price = price;
    }
}
