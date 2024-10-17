package CarRentalSystem;
import java.util.Date;

/*
Design Patterns Used:
Factory Pattern:

The Factory Pattern is used to create different types of vehicles (Sedan, SUV, Truck) using the VehicleFactory. This simplifies the vehicle creation process and allows easy extension for new vehicle types.
Where: VehicleFactory class for creating vehicles.

Strategy Pattern:
The Strategy Pattern is used for handling different payment methods (CreditCardPayment, CashPayment, OnlinePayment). Each payment method has its own strategy, making it flexible to add new payment methods in the future.
Where: PaymentStrategy interface and its implementations (CreditCardPayment, CashPayment, OnlinePayment).

Singleton Pattern:
The Singleton Pattern ensures that only one instance of the CarRentalSystem exists. This allows centralized management of vehicle inventory, customers, and reservations.
Where: CarRentalSystem class.

Observer Pattern (optional extension):
The Observer Pattern can be used to notify customers when a vehicle they reserved becomes available or when their rental period is approaching its end. This can be implemented in the CarRentalSystem or as part of the Reservation class.
Where: Would be used to notify customers about reservation or vehicle status.

Decorator Pattern (optional extension):
The Decorator Pattern could be used to add additional services (e.g., GPS, child seat, insurance) to a rental, allowing flexibility in extending a rental's functionality.
Where: Would be used in the Rental class to add extra features to a vehicle rental (e.g., GPSDecorator, ChildSeatDecorator).
 */

public class CarRentalDemo {
    public static void main(String[] args) {
        // Initialize the car rental system
        CarRentalSystem carRentalSystem = CarRentalSystem.getInstance();

        // Add vehicles to the system
        carRentalSystem.addVehicle(VehicleFactory.createVehicle("sedan", "ABC-123", "Toyota Camry", 50.0));
        carRentalSystem.addVehicle(VehicleFactory.createVehicle("suv", "XYZ-456", "Honda CR-V", 80.0));
        carRentalSystem.addVehicle(VehicleFactory.createVehicle("truck", "LMN-789", "Ford F-150", 100.0));

        // Create customers
        Customer member = new Member("John Doe", "D1234567", "M123");
        Customer guest = new Guest("Jane Smith", "D7654321");

        // Add customers to the system
        carRentalSystem.addCustomer(member);
        carRentalSystem.addCustomer(guest);

        // Find an available SUV and create a reservation for John (member)
        Vehicle vehicle = carRentalSystem.findAvailableVehicle("suv");
        if (vehicle != null) {
            Reservation reservation = carRentalSystem.createReservation(member, vehicle, new Date(), new Date(System.currentTimeMillis() + 2 * 24 * 60 * 60 * 1000)); // 2-day reservation
            reservation.confirmReservation();

            // Simulate rental
            Rental rental = new Rental(vehicle, member, reservation.getStartDate(), reservation.getEndDate());
            System.out.println("Rental cost: $" + rental.calculateRentalCost());

            // Make payment using credit card
            PaymentStrategy payment = new CreditCardPayment("4111-1111-1111-1111");
            payment.pay(rental.calculateRentalCost());

            // Return the vehicle
            rental.returnVehicle();
        } else {
            System.out.println("No SUV is available.");
        }

        // Create a reservation for Jane (guest) with a truck
        Vehicle truck = carRentalSystem.findAvailableVehicle("truck");
        if (truck != null) {
            Reservation reservation = carRentalSystem.createReservation(guest, truck, new Date(), new Date(System.currentTimeMillis() + 1 * 24 * 60 * 60 * 1000)); // 1-day reservation
            reservation.confirmReservation();

            // Simulate rental
            Rental rental = new Rental(truck, guest, reservation.getStartDate(), reservation.getEndDate());
            System.out.println("Rental cost: $" + rental.calculateRentalCost());

            // Make payment using cash
            PaymentStrategy payment = new CashPayment();
            payment.pay(rental.calculateRentalCost());

            // Return the vehicle
            rental.returnVehicle();
        } else {
            System.out.println("No truck is available.");
        }
    }
}

