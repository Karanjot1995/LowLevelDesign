package VendingMachineSystem;

class Beverage extends Product{
    public Beverage(String name, double price){
        super(name, price, ProductCategory.BEVERAGE);
    }
}
