package ATMSystem;

interface ATMState {
    void insertCard(Card card);
    void ejectCard();
    void enterPin(String pin);
    void selectTransaction(Transaction transaction);
    void executeTransaction();
}
