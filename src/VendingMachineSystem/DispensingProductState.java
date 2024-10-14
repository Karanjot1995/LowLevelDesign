package VendingMachineSystem;


class DispensingProductState implements VendingMachineState {
    private VendingMachine vendingMachine;

    public DispensingProductState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void selectProduct(Product product) {
        System.out.println("Please wait, we are dispensing your product.");
    }

    @Override
    public void insertMoney(double amount) {
        System.out.println("Product is being dispensed. No need for more money.");
    }

    @Override
    public void dispenseProduct() {
        vendingMachine.getInventory().dispenseProduct(vendingMachine.getCurrentProduct());
        vendingMachine.returnChange();
        vendingMachine.setState(vendingMachine.getIdleState());
    }

    @Override
    public void returnChange() {
        System.out.println("Returning change.");
        vendingMachine.returnChange();
        vendingMachine.setState(vendingMachine.getIdleState());
    }
}

