package VendingMachineSystem;

class ProcessingPaymentState implements VendingMachineState {
    private VendingMachine vendingMachine;

    public ProcessingPaymentState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void selectProduct(Product product) {
        System.out.println("Product already selected.");
    }

    // should be able to add money and add that to current balance
    @Override
    public void insertMoney(double amount) {
        vendingMachine.addToBalance(amount);
        System.out.println("Inserted $" + amount + ". Current balance: $" + vendingMachine.getBalance());
        if(vendingMachine.getBalance()>=vendingMachine.getCurrentProduct().getPrice()){
            vendingMachine.setState(vendingMachine.getDispensingProductState());
        }
    }

    @Override
    public void dispenseProduct() {
        System.out.println("Please insert more money.");
    }

    @Override
    public void returnChange() {
        System.out.println("Returning change.");
        vendingMachine.returnChange();
        vendingMachine.setState(vendingMachine.getIdleState());
    }
}
