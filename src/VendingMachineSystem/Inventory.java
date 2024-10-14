package VendingMachineSystem;

import java.util.HashMap;
import java.util.Map;

public class Inventory {
    private Map<Product, Integer> productInventory = new HashMap<>();

    // Add product to inventory
    public void addProduct(Product product, int quantity) {
        productInventory.put(product, productInventory.getOrDefault(product, 0) + quantity);
    }

    // Check if the product is available in the inventory
    public boolean isAvailable(Product product) {
        return productInventory.getOrDefault(product, 0) > 0;
    }

    // Dispense the product and reduce its quantity
    public void dispenseProduct(Product product) {
        if (isAvailable(product)) {
            int currentStock = productInventory.get(product);
            productInventory.put(product, currentStock - 1);
            System.out.println("Dispensing " + product.getName());
        } else {
            System.out.println(product.getName() + " is out of stock!");
        }
    }

    // Check the stock of a particular product
    public int getStock(Product product) {
        return productInventory.getOrDefault(product, 0);
    }

    @Override
    public String toString() {
        String inventory = "\n--- Updated Inventory Count --- ";
        for(Product product : productInventory.keySet()){
            inventory+= "\n" + product.getName() + ": " + productInventory.get(product);
        }
        return inventory;
    }
}
