package CarRentalSystem;

abstract class Customer {
    protected String name;
    protected String driverLicense;

    public Customer(String name, String driverLicense) {
        this.name = name;
        this.driverLicense = driverLicense;
    }

    public String getName() {
        return name;
    }

    public String getDriverLicense() {
        return driverLicense;
    }

    public abstract String getCustomerType();
}
