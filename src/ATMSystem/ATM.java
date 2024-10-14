package ATMSystem;

class ATM {
    private static ATM instance;
    private ATMState idleState;
    private ATMState cardInsertedState;
    private ATMState processingState;
    private ATMState transactionInProgressState;

    private ATMState currentState;
    private Card currentCard;
    private Account currentAccount;
    private Transaction currentTransaction;

    private ATM() {
        this.idleState = new IdleState(this);
        this.cardInsertedState = new CardInsertedState(this);
        this.processingState = new ProcessingState(this);
        this.transactionInProgressState = new TransactionInProgressState(this);
        this.currentState = idleState;
    }

    public static ATM getInstance() {
        if (instance == null) {
            instance = new ATM();
        }
        return instance;
    }

    public void insertCard(Card card) {
        currentState.insertCard(card);
    }

    public void ejectCard() {
        currentState.ejectCard();
    }

    public void enterPin(String pin) {
        currentState.enterPin(pin);
    }

    public void selectTransaction(Transaction transaction) {
        currentState.selectTransaction(transaction);
    }

    public void executeTransaction() {
        currentState.executeTransaction();
    }

    public void setState(ATMState state) {
        this.currentState = state;
    }

    public void setCard(Card card) {
        this.currentCard = card;
    }

    public void setCurrentAccount(Account account) {
        this.currentAccount = account;
    }

    public void setCurrentTransaction(Transaction transaction) {
        this.currentTransaction = transaction;
    }

    public Card getCard() {
        return currentCard;
    }

    public Account getCurrentAccount() {
        return currentAccount;
    }

    public Transaction getCurrentTransaction() {
        return currentTransaction;
    }

    public ATMState getIdleState() {
        return idleState;
    }

    public ATMState getCardInsertedState() {
        return cardInsertedState;
    }

    public ATMState getProcessingState() {
        return processingState;
    }

    public ATMState getTransactionInProgressState() {
        return transactionInProgressState;
    }
}

