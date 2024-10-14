package RestaurantManagementSystem;

class Beverage extends MenuItem {
    public Beverage(String name, double price) {
        super(name, price, MenuItemType.BEVERAGE);
    }

    @Override
    public String getDescription() {
        return "Beverage: " + name + " - $" + price;
    }
}
