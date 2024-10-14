package RestaurantManagementSystem;

abstract class MenuItem {
    protected String name;
    protected double price;
    protected MenuItemType type;

    public MenuItem(String name, double price, MenuItemType type) {
        this.name = name;
        this.price = price;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public MenuItemType getType() {
        return type;
    }

    public abstract String getDescription();
}
