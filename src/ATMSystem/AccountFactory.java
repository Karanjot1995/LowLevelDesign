package ATMSystem;

class AccountFactory {
    public static Account createAccount(String accountType, String accountNumber, double balance) {
        switch(accountType.toLowerCase()){
            case "checking":
                return new CheckingAccount(accountNumber,balance);
            case "savings":
                return new SavingsAccount(accountNumber, balance);
            default:
                throw new IllegalArgumentException("Unknown account type.");
        }
    }
}