package CarRentalSystem;

class Truck extends Vehicle {
    public Truck(String licensePlate, String model, double rentalRatePerDay) {
        super(licensePlate, model, rentalRatePerDay);
    }

    @Override
    public String getVehicleType() {
        return "Truck";
    }
}
