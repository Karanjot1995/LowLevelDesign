package VendingMachineSystem;

/*
State Pattern:
The vending machine transitions between different states: IdleState, ProcessingPaymentState, and DispensingProductState.
Each state defines its own behavior, allowing the vending machine to handle actions appropriately based on its current state.

Factory Pattern:
Although not directly implemented as a separate factory class, the vending machine effectively uses the Factory Pattern when
creating product instances (Snack, Beverage, Candy) and adding them to inventory.

Strategy Pattern (optional for payments):
We could further enhance the system by adding a strategy for different payment methods (e.g., coins, credit card, etc.).
This pattern would allow flexible handling of various payment types.

Observer Pattern (optional for stock management):
The system could be extended to use an Observer Pattern to notify when a product is low in stock or out of stock,
allowing the vending machine to trigger a restocking process or notify a maintenance system.
 */

public class VendingMachineDemo {
    public static void main(String[] args) {
        // Initialize the vending machine
        VendingMachine vendingMachine = VendingMachine.getInstance();

        // Add products to inventory
        Product chips = new Snack("Chips", 1.50);
        Product soda = new Beverage("Soda", 2.00);
        Product candy = new Candy("Candy", 1.00);

        vendingMachine.getInventory().addProduct(chips, 5);
        vendingMachine.getInventory().addProduct(soda, 3);
        vendingMachine.getInventory().addProduct(candy, 10);

        // Simulate purchasing process
        System.out.println("\n--- Purchasing Candy ---");
        vendingMachine.selectProduct(candy);  // Select product
        vendingMachine.insertMoney(1.00);     // Insert money
        vendingMachine.dispenseProduct();     // Dispense product

        System.out.println("\n--- Purchasing Soda ---");
        vendingMachine.selectProduct(soda);   // Select product
        vendingMachine.insertMoney(1.00);     // Insert insufficient money
        vendingMachine.insertMoney(1.00);     // Insert more money
        vendingMachine.dispenseProduct();     // Dispense product

        System.out.println("\n--- Purchasing Chips ---");
        vendingMachine.selectProduct(chips);  // Select product
        vendingMachine.insertMoney(2.00);     // Insert more than required
        vendingMachine.dispenseProduct();     // Dispense product and return change
        System.out.println(vendingMachine.getInventory().toString());
    }
}

