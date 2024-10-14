package VendingMachineSystem;

class IdleState implements VendingMachineState {
    private VendingMachine vendingMachine;

    public IdleState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void selectProduct(Product product) {
        if (vendingMachine.getInventory().isAvailable(product)) {
            System.out.println("Product selected: " + product.getName());
            vendingMachine.setCurrentProduct(product);
            vendingMachine.setState(vendingMachine.getProcessingPaymentState());
        } else {
            System.out.println("Product out of stock!");
        }
    }

    @Override
    public void insertMoney(double amount) {
        System.out.println("Please select a product first.");
    }

    @Override
    public void dispenseProduct() {
        System.out.println("Please select a product and make a payment first.");
    }

    @Override
    public void returnChange() {
        System.out.println("No money to return.");
    }
}