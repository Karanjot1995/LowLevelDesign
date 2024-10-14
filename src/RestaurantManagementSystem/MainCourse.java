package RestaurantManagementSystem;

class MainCourse extends MenuItem {
    public MainCourse(String name, double price) {
        super(name, price, MenuItemType.MAIN_COURSE);
    }

    @Override
    public String getDescription() {
        return "Main Course: " + name + " - $" + price;
    }
}
