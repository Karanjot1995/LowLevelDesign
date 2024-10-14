package ParkingLotSystem;

import java.util.ArrayList;
import java.util.List;

class ParkingLot {
    private static ParkingLot instance;
    private List<ParkingSpot> parkingSpots;
    private ParkingStrategy parkingStrategy;

    private ParkingLot(){
        parkingSpots = new ArrayList<>();
        parkingStrategy = new SmallestFitStrategy();
    }

    public static ParkingLot getInstance() {
        if (instance == null) {
            instance = new ParkingLot();
        }
        return instance;
    }

    public void setParkingStrategy(ParkingStrategy strategy) {
        this.parkingStrategy = strategy;
    }

    public void createParkingSpot(ParkingSpotType type, int spotId){
        switch(type){
            case MOTORBIKE_SPOT:
                parkingSpots.add(new MotorbikeSpot(spotId));
                break;
            case COMPACT_SPOT:
                parkingSpots.add(new CompactSpot(spotId));
                break;
            case MEDIUM_SPOT:
                parkingSpots.add(new MediumSpot(spotId));
                break;
            case LARGE_SPOT:
                parkingSpots.add(new LargeSpot(spotId));
                break;
            case DISABLED_SPOT:
                parkingSpots.add(new DisabledSpot(spotId));
                break;
        }

    }

    public void parkVehicle(Vehicle vehicle) {
        ParkingSpot spot = parkingStrategy.findParkingSpot(parkingSpots, vehicle);
        if(spot!=null){
            spot.park(vehicle);
        }else {
            System.out.println("No available spot for vehicle " + vehicle.getLicensePlate());
        }
    }

    public void removeVehicle(int spotId) {
        for(ParkingSpot spot: parkingSpots){
            if(spot.spotId == spotId && spot.isOccupied){
                spot.freeSpot();
                return;
            }
        }
        System.out.println("Spot " + spotId + " is already free.");
    }
}

