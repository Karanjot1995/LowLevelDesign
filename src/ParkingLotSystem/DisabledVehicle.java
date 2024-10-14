package ParkingLotSystem;

class DisabledVehicle extends Vehicle {
    public DisabledVehicle(String licensePlate) {
        super(licensePlate, VehicleType.DISABLED);
    }
}