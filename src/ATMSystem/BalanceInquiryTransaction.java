package ATMSystem;

class BalanceInquiryTransaction implements Transaction {
    @Override
    public void execute(Account account) {
        System.out.println("Current balance: $" + account.getBalance());
    }
}
