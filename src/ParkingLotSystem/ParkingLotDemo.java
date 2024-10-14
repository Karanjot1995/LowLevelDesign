package ParkingLotSystem;

/*
Design Patterns Used:
Strategy Pattern: The parking strategy for finding suitable parking spots is implemented using the ParkingStrategy interface
and its SmallestFitStrategy implementation. This allows different strategies to be applied without modifying the core logic.
Example: SmallestFitStrategy assigns the smallest suitable spot available for a vehicle type (e.g., compact vehicle can fit into a compact or medium spot).

Factory Pattern: The ParkingLot uses the Factory Pattern to create parking spots based on their type.
This pattern simplifies the creation of parking spots and centralizes the logic.
Example: createParkingSpot() creates different spot types (compact, medium, large, etc.).

Singleton Pattern: The ParkingLot class follows the Singleton Pattern, ensuring only one instance of the parking lot exists.
This is crucial for managing the shared state of parking spots and vehicle allocations.
Example: ParkingLot.getInstance() returns the single instance of the parking lot.

Observer Pattern (Optional Extension): If needed, the system can be extended to notify observers when parking spots become available (e.g., a notification system for available spots).
*/

public class ParkingLotDemo {
    public static void main(String[] args) {
        // Create a parking lot with different types of parking spots
        ParkingLot parkingLot = ParkingLot.getInstance();
        parkingLot.createParkingSpot(ParkingSpotType.MOTORBIKE_SPOT, 1);
        parkingLot.createParkingSpot(ParkingSpotType.COMPACT_SPOT, 2);
        parkingLot.createParkingSpot(ParkingSpotType.MEDIUM_SPOT, 3);
        parkingLot.createParkingSpot(ParkingSpotType.LARGE_SPOT, 4);
        parkingLot.createParkingSpot(ParkingSpotType.DISABLED_SPOT, 5);

        // Create vehicles of different types
        Vehicle motorbike = new Motorbike("MB-123");
        Vehicle compactCar = new CompactVehicle("CP-234");
        Vehicle mediumCar = new MediumVehicle("MD-345");
        Vehicle largeCar = new LargeVehicle("LG-456");
        Vehicle disabledCar = new DisabledVehicle("DS-567");
        Vehicle compactCa2 = new CompactVehicle("AB-1234");

        // Park vehicles in the parking lot
        parkingLot.parkVehicle(motorbike);
        parkingLot.parkVehicle(compactCar);
        parkingLot.parkVehicle(mediumCar);
        parkingLot.parkVehicle(largeCar);
        parkingLot.parkVehicle(disabledCar);
        parkingLot.parkVehicle(compactCa2);

        // Remove vehicle from spot 2 (Compact Spot)
        parkingLot.removeVehicle(2);
        parkingLot.parkVehicle(compactCa2);
    }
}
