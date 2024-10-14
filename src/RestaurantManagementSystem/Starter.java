package RestaurantManagementSystem;

class Starter extends MenuItem {
    public Starter(String name, double price) {
        super(name, price, MenuItemType.STARTER);
    }

    @Override
    public String getDescription() {
        return "Starter: " + name + " - $" + price;
    }
}