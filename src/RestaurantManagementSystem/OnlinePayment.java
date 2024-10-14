package RestaurantManagementSystem;

class OnlinePayment implements PaymentStrategy {
    private String email;

    public OnlinePayment(String email) {
        this.email = email;
    }

    @Override
    public void pay(double amount) {
        System.out.println("Paid $" + amount + " using online payment (email: " + email + ").");
    }
}
