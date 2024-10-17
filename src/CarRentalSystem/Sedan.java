package CarRentalSystem;

class Sedan extends Vehicle {
    public Sedan(String licensePlate, String model, double rentalRatePerDay) {
        super(licensePlate, model, rentalRatePerDay);
    }

    @Override
    public String getVehicleType() {
        return "Sedan";
    }
}