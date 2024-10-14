package ATMSystem;

/*
State Pattern:
The ATM uses different states (IdleState, CardInsertedState, ProcessingState, TransactionInProgressState) to manage its behavior.
The ATM transitions between these states as actions are performed (e.g., inserting a card, entering a PIN, selecting a transaction).
Where: ATMState, IdleState, CardInsertedState, ProcessingState, and TransactionInProgressState.

Strategy Pattern:
Different transactions (e.g., WithdrawalTransaction, DepositTransaction, BalanceInquiryTransaction) are handled using the Strategy Pattern.
Each transaction has a different implementation but follows the same interface.
Where: Transaction interface and its concrete classes (WithdrawalTransaction, DepositTransaction, etc.).

Factory Pattern:
The Factory Pattern is used to create different types of accounts (e.g., CheckingAccount, SavingsAccount) through the AccountFactory.
Where: AccountFactory class to create accounts.

Singleton Pattern:
The Singleton Pattern is applied to ensure that there is only one instance of the ATM class in the system.
Where: ATM.getInstance() ensures there is a single ATM instance.

Observer Pattern (optional):
The Observer Pattern can be applied to notify bank systems or administrators in cases of insufficient funds, maintenance alerts, etc.
 */
public class ATMDemo {
    public static void main(String[] args) {
        ATM atm = ATM.getInstance();

        // Create a user card and account
        Card card = new Card("1234-5678-9101", "1234");
        Account checkingAccount = AccountFactory.createAccount("checking", "CHK-123", 500);

        // Set the current account for the simulation
        atm.setCurrentAccount(checkingAccount);

        // Simulate inserting a card, entering PIN, and doing a transaction
        System.out.println("\n--- ATM Simulation ---");

        atm.insertCard(card);                // Insert card
        atm.enterPin("1234");                // Enter correct PIN
        atm.selectTransaction(new WithdrawalTransaction(100)); // Select Withdrawal transaction
        atm.executeTransaction();            // Execute the transaction

        atm.insertCard(card);                // Insert card again
        atm.enterPin("1234");                // Enter correct PIN
        atm.selectTransaction(new BalanceInquiryTransaction()); // Balance inquiry
        atm.executeTransaction();            // Execute the transaction
    }
}

