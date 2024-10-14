package VendingMachineSystem;

class VendingMachine {
    private static VendingMachine instance;
    private VendingMachineState idleState;
    private VendingMachineState processingPaymentState;
    private VendingMachineState dispensingProductState;

    private Product currentProduct;
    private int balance;
    private VendingMachineState currentState;
    private Inventory inventory;

    private VendingMachine(){
        this.idleState = new IdleState(this);
        this.processingPaymentState = new ProcessingPaymentState(this);
        this.dispensingProductState = new DispensingProductState(this);

        this.currentState = idleState;
        this.balance = 0;
        this.inventory = new Inventory();
    }

    public static VendingMachine getInstance() {
        if (instance == null) {
            instance = new VendingMachine();
        }
        return instance;
    }

    public void selectProduct(Product product){
        currentState.selectProduct(product);
    }

    public void insertMoney(double amount){
        currentState.insertMoney(amount);
    }

    public void dispenseProduct(){
        currentState.dispenseProduct();
    }

    public void returnChange(){
        double change = balance - currentProduct.getPrice();
        if(change>0){
            System.out.println("Returning change: $" + change);
        }
        balance = 0;
    }

    public Inventory getInventory(){
        return inventory;
    }

    public void addToBalance(double amount){
        balance+=amount;
    }

    public double getBalance(){
        return balance;
    }

    public Product getCurrentProduct(){
        return currentProduct;
    }

    public void setCurrentProduct(Product currentProduct) {
        this.currentProduct = currentProduct;
    }

    public void setState(VendingMachineState state){
        this.currentState = state;
    }

    public VendingMachineState getIdleState() {
        return idleState;
    }

    public VendingMachineState getProcessingPaymentState() {
        return processingPaymentState;
    }

    public VendingMachineState getDispensingProductState() {
        return dispensingProductState;
    }
}

