package ATMSystem;

class IdleState implements ATMState {
    private ATM atm;

    public IdleState(ATM atm) {
        this.atm = atm;
    }

    @Override
    public void insertCard(Card card) {
        System.out.println("Card inserted. Please enter your PIN.");
        atm.setCard(card);
        atm.setState(atm.getCardInsertedState());
    }

    @Override
    public void ejectCard() {
        System.out.println("No card to eject.");
    }

    @Override
    public void enterPin(String pin) {
        System.out.println("No card inserted.");
    }

    @Override
    public void selectTransaction(Transaction transaction) {
        System.out.println("No card inserted.");
    }

    @Override
    public void executeTransaction() {
        System.out.println("No card inserted.");
    }
}
