package RestaurantManagementSystem;

/*
Design Patterns Used:

Factory Pattern:
The MenuItemFactory creates different types of menu items based on the type of dish (starter, main course, dessert, beverage).
This makes it easy to manage the creation of menu items and allows for future expansion if new categories are added.
Where: MenuItemFactory class for creating menu items.

Strategy Pattern:
The Strategy Pattern is used to handle different payment methods (e.g., credit card, cash, online payment).
Each payment method is implemented using the PaymentStrategy interface, making it easy to extend the system with new payment types.
Where: PaymentStrategy interface and concrete classes (CreditCardPayment, CashPayment, OnlinePayment).

Singleton Pattern:
The Singleton Pattern is applied to ensure that only one instance of the RestaurantManagementSystem exists.
This allows centralized control over tables, menu items, orders, and the kitchen.
Where: RestaurantManagementSystem class.

Observer Pattern:
The Observer Pattern is used to notify the kitchen when an order is placed.
The Kitchen class observes the order, gets notified, and starts preparing the order.
Where: OrderObserver interface and Kitchen class.

Command Pattern:
The Command Pattern is used to encapsulate customer orders. Each order consists of multiple items,
and the order can be executed (prepared by the kitchen) and displayed. This pattern allows for easy extension of order management functionalities.
Where: Order class for managing customer orders.
 */

public class RestaurantManagementDemo {
    public static void main(String[] args) {
        // Initialize restaurant system
        RestaurantManagementSystem rms = RestaurantManagementSystem.getInstance();

        // Add tables
        rms.addTable(new Table(1, 4));
        rms.addTable(new Table(2, 2));

        // Add menu items
        rms.addMenuItem(MenuItemFactory.createMenuItem(MenuItemType.STARTER, "Caesar Salad", 7.99));
        rms.addMenuItem(MenuItemFactory.createMenuItem(MenuItemType.MAIN_COURSE, "Grilled Chicken", 15.99));
        rms.addMenuItem(MenuItemFactory.createMenuItem(MenuItemType.DESSERT, "Cheesecake", 6.99));
        rms.addMenuItem(MenuItemFactory.createMenuItem(MenuItemType.BEVERAGE, "Coke", 1.99));

        // Create a customer
        Customer customer = new Customer("Alice", "1234567890");

        // Find an available table and place an order
        Table table = rms.findAvailableTable(4);
        if (table != null) {
            table.reserve();
            Order order = new Order(table, customer);
            for(MenuItem item: rms.getMenuItems()){
                if(item.getName() == "Caesar Salad" || item.getName() == "Grilled Chicken"){
                    order.addItem(item);
                }
            }
//            order.addItem(MenuItemFactory.createMenuItem(MenuItemType.STARTER, "Caesar Salad", 7.99));
//            order.addItem(MenuItemFactory.createMenuItem(MenuItemType.MAIN_COURSE, "Grilled Chicken", 15.99));

            // Notify the kitchen to prepare the order
            rms.notifyKitchen(order);

            // Display the order
            order.displayOrder();

            // Make payment
            PaymentStrategy payment = new CreditCardPayment("4111-1111-1111-1111");
            payment.pay(order.getTotalAmount());

            // Release the table after dining
            table.release();
        } else {
            System.out.println("No available tables.");
        }
    }
}
