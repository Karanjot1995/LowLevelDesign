package ParkingLotSystem;

class DisabledSpot extends ParkingSpot{
    public DisabledSpot(int spotId){
        super(spotId, ParkingSpotType.DISABLED_SPOT);
    }
}