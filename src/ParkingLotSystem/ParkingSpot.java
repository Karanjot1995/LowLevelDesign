package ParkingLotSystem;

abstract class ParkingSpot {
    protected int spotId;
    protected ParkingSpotType spotType;
    protected boolean isOccupied;
    protected Vehicle parkedVehicle;

    public ParkingSpot(int spotId, ParkingSpotType spotType) {
        this.spotId = spotId;
        this.spotType = spotType;
        this.isOccupied = false;
    }

    public boolean isAvailable() {
        return !isOccupied;
    }

    public void park(Vehicle vehicle) {
        isOccupied = true;
        parkedVehicle = vehicle;
        System.out.println("Vehicle " + vehicle.getLicensePlate() + " parked at spot " + spotId);
    }

    public void freeSpot() {
        isOccupied = false;
        System.out.println("Spot " + spotId + " is now free.");
        parkedVehicle = null;
    }

    public ParkingSpotType getSpotType() {
        return spotType;
    }
}
