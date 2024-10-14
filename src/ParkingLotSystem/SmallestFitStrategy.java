package ParkingLotSystem;

import java.util.List;

class SmallestFitStrategy implements ParkingStrategy{
    @Override
    public ParkingSpot findParkingSpot(List<ParkingSpot> spots, Vehicle vehicle) {
        for (ParkingSpot spot : spots) {
            if (spot.isAvailable() && isSuitableSpot(spot, vehicle)) {
                return spot;
            }
        }
        return null;
    }

    public boolean isSuitableSpot(ParkingSpot spot, Vehicle vehicle){
        switch(vehicle.getType()){
            case MOTORBIKE:
                return spot.getSpotType() == ParkingSpotType.MOTORBIKE_SPOT || spot.getSpotType() == ParkingSpotType.COMPACT_SPOT;
            case COMPACT:
                return spot.getSpotType() == ParkingSpotType.COMPACT_SPOT || spot.getSpotType() == ParkingSpotType.MEDIUM_SPOT;
            case MEDIUM:
                return spot.getSpotType() == ParkingSpotType.MEDIUM_SPOT || spot.getSpotType() == ParkingSpotType.LARGE_SPOT;
            case LARGE:
                return spot.getSpotType() == ParkingSpotType.LARGE_SPOT;
            case DISABLED:
                return spot.getSpotType() == ParkingSpotType.DISABLED_SPOT;
            default:
                return false;
        }
    }
}
