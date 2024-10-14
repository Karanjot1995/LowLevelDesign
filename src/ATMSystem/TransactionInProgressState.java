package ATMSystem;

class TransactionInProgressState implements ATMState {
    private ATM atm;

    public TransactionInProgressState(ATM atm) {
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
        System.out.println("Transaction in progress.");
    }

    @Override
    public void selectTransaction(Transaction transaction) {
        System.out.println("Transaction in progress.");
    }

    @Override
    public void executeTransaction() {
        atm.getCurrentTransaction().execute(atm.getCurrentAccount());
        atm.setState(atm.getIdleState());
        atm.ejectCard();
    }
}
