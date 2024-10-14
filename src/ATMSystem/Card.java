package ATMSystem;

class Card {
    private String cardNumber;
    private String pin;

    public Card(String cardNumber, String pin) {
        this.cardNumber = cardNumber;
        this.pin = pin;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public boolean verifyPin(String inputPin) {
        return pin.equals(inputPin);
    }
}
