package ATMSystem;

class CardInsertedState implements ATMState {
    private ATM atm;

    public CardInsertedState(ATM atm) {
        this.atm = atm;
    }

    @Override
    public void insertCard(Card card) {
        System.out.println("Card already inserted.");
    }

    @Override
    public void ejectCard() {
        System.out.println("Card ejected.");
        atm.setCard(null);
        atm.setState(atm.getIdleState());
    }

    @Override
    public void enterPin(String pin) {
        if (atm.getCard().verifyPin(pin)) {
            System.out.println("PIN verified.");
            atm.setState(atm.getProcessingState());
        } else {
            System.out.println("Invalid PIN.");
            atm.ejectCard();
        }
    }

    @Override
    public void selectTransaction(Transaction transaction) {
        System.out.println("Please enter PIN first.");
    }

    @Override
    public void executeTransaction() {
        System.out.println("Please enter PIN first.");
    }
}