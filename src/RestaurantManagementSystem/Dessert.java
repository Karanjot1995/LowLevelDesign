package RestaurantManagementSystem;

class Dessert extends MenuItem {
    public Dessert(String name, double price) {
        super(name, price, MenuItemType.DESSERT);
    }

    @Override
    public String getDescription() {
        return "Dessert: " + name + " - $" + price;
    }
}
