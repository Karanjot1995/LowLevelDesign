package CarRentalSystem;

class SUV extends Vehicle {
    public SUV(String licensePlate, String model, double rentalRatePerDay) {
        super(licensePlate, model, rentalRatePerDay);
    }

    @Override
    public String getVehicleType() {
        return "SUV";
    }
}
