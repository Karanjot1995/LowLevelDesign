package CarRentalSystem;

class Guest extends Customer {
    public Guest(String name, String driverLicense) {
        super(name, driverLicense);
    }

    @Override
    public String getCustomerType() {
        return "Guest";
    }
}
