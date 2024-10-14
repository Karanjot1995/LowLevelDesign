package ATMSystem;

class WithdrawalTransaction implements Transaction {
    private double amount;

    public WithdrawalTransaction(double amount){
        this.amount = amount;
    }

    @Override
    public void execute(Account account){
        if (account.withdraw(amount)) {
            System.out.println("Withdrawal successful: $" + amount);
        } else {
            System.out.println("Withdrawal failed: Insufficient funds.");
        }
    }
}
