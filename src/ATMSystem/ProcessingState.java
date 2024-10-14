package ATMSystem;

class ProcessingState implements ATMState {
    private ATM atm;

    public ProcessingState(ATM atm) {
        this.atm = atm;
    }

    @Override
    public void insertCard(Card card) {
        System.out.println("Transaction in progress.");
    }

    @Override
    public void ejectCard() {
        System.out.println("Transaction in progress.");
    }

    @Override
    public void enterPin(String pin) {
        System.out.println("PIN already entered.");
    }

    @Override
    public void selectTransaction(Transaction transaction) {
        atm.setCurrentTransaction(transaction);
        atm.setState(atm.getTransactionInProgressState());
    }

    @Override
    public void executeTransaction() {
        System.out.println("Please select a transaction first.");
    }
}
