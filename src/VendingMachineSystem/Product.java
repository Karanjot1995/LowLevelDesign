package VendingMachineSystem;

abstract class Product {
    protected String name;
    protected double price;
    protected ProductCategory category;

    public Product(String name, double price, ProductCategory category){
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public String getName(){
        return name;
    }

    public double getPrice() {
        return price;
    }

    public ProductCategory getCategory() {
        return category;
    }
}
