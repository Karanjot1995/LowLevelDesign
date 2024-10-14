package VendingMachineSystem;

interface VendingMachineState{
    void selectProduct(Product product);
    void insertMoney(double amount);
    void dispenseProduct();
    void returnChange();
}
