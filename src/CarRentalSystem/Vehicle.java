package CarRentalSystem;

abstract class Vehicle {
    protected String licensePlate;
    protected String model;
    protected VehicleStatus status;
    protected double rentalRatePerDay;

    public Vehicle(String licensePlate, String model, double rentalRatePerDay) {
        this.licensePlate = licensePlate;
        this.model = model;
        this.rentalRatePerDay = rentalRatePerDay;
        this.status = VehicleStatus.AVAILABLE;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public String getModel() {
        return model;
    }

    public double getRentalRatePerDay() {
        return rentalRatePerDay;
    }

    public VehicleStatus getStatus() {
        return status;
    }

    public void setStatus(VehicleStatus status) {
        this.status = status;
    }

    public abstract String getVehicleType();
}
