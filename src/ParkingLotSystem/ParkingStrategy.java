package ParkingLotSystem;

import java.util.List;

interface ParkingStrategy {
    ParkingSpot findParkingSpot(List<ParkingSpot> spots, Vehicle vehicle);
}
