package RestaurantManagementSystem;

import java.util.ArrayList;
import java.util.List;

class Order {
    private List<MenuItem> items;
    private Table table;
    private Customer customer;
    private boolean isPrepared;

    public Order(Table table, Customer customer) {
        this.items = new ArrayList<>();
        this.table = table;
        this.customer = customer;
        this.isPrepared = false;
    }

    public void addItem(MenuItem item) {
        items.add(item);
        System.out.println("Added " + item.getName() + " to the order.");
    }

    public void prepare() {
        isPrepared = true;
        System.out.println("Order for Table " + table.getTableNumber() + " is prepared.");
    }

    public double getTotalAmount() {
        double total = 0;
        for(MenuItem item : items){
            total+=item.getPrice();
        }
        return total;
    }

    public void displayOrder() {
        System.out.println("Order for Table " + table.getTableNumber() + ":");
        for (MenuItem item : items) {
            System.out.println(item.getDescription());
        }
        System.out.println("Total Amount: $" + getTotalAmount());
    }

    public Table getTable() {
        return table;
    }

    public boolean isPrepared() {
        return isPrepared;
    }
}

