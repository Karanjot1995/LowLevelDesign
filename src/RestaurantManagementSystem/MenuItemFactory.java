package RestaurantManagementSystem;

class MenuItemFactory {
    public static MenuItem createMenuItem(MenuItemType type, String name, double price) {
        switch (type) {
            case STARTER:
                return new Starter(name, price);
            case MAIN_COURSE:
                return new MainCourse(name, price);
            case DESSERT:
                return new Dessert(name, price);
            case BEVERAGE:
                return new Beverage(name, price);
            default:
                throw new IllegalArgumentException("Unknown menu item type.");
        }
    }
}

