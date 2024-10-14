package RestaurantManagementSystem;

import java.util.ArrayList;
import java.util.List;

class RestaurantManagementSystem {
    private static RestaurantManagementSystem instance;
    private List<Table> tables;
    private List<MenuItem> menuItems;
    private List<Customer> customers;
    private Kitchen kitchen;

    private RestaurantManagementSystem() {
        tables = new ArrayList<>();
        menuItems = new ArrayList<>();
        customers = new ArrayList<>();
        kitchen = new Kitchen();
    }

    public static RestaurantManagementSystem getInstance() {
        if (instance == null) {
            instance = new RestaurantManagementSystem();
        }
        return instance;
    }

    public void addTable(Table table) {
        tables.add(table);
    }

    public void addMenuItem(MenuItem item) {
        menuItems.add(item);
    }

    public Table findAvailableTable(int capacity) {
        for (Table table : tables) {
            if (table.getCapacity() >= capacity && table.getStatus() == TableStatus.AVAILABLE) {
                return table;
            }
        }
        return null;
    }

    public void notifyKitchen(Order order) {
        kitchen.update(order);
    }

    public List<MenuItem> getMenuItems(){
        return menuItems;
    }
}
