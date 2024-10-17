package CarRentalSystem;

class VehicleFactory {
    public static Vehicle createVehicle(String type, String licensePlate, String model, double rentalRatePerDay) {
        switch (type.toLowerCase()) {
            case "sedan":
                return new Sedan(licensePlate, model, rentalRatePerDay);
            case "suv":
                return new SUV(licensePlate, model, rentalRatePerDay);
            case "truck":
                return new Truck(licensePlate, model, rentalRatePerDay);
            default:
                throw new IllegalArgumentException("Unknown vehicle type.");
        }
    }
}

