package CarRentalSystem;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

class CarRentalSystem {
    private static CarRentalSystem instance;
    private List<Vehicle> vehicles;
    private List<Customer> customers;
    private List<Reservation> reservations;

    private CarRentalSystem() {
        vehicles = new ArrayList<>();
        customers = new ArrayList<>();
        reservations = new ArrayList<>();
    }

    public static CarRentalSystem getInstance() {
        if (instance == null) {
            instance = new CarRentalSystem();
        }
        return instance;
    }

    public void addVehicle(Vehicle vehicle) {
        vehicles.add(vehicle);
    }

    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    public Vehicle findAvailableVehicle(String type) {
        for (Vehicle vehicle : vehicles) {
            if (vehicle.getVehicleType().equalsIgnoreCase(type) && vehicle.getStatus() == VehicleStatus.AVAILABLE) {
                return vehicle;
            }
        }
        return null;
    }

    public Reservation createReservation(Customer customer, Vehicle vehicle, Date startDate, Date endDate) {
        Reservation reservation = new Reservation(vehicle, customer, startDate, endDate);
        reservations.add(reservation);
        return reservation;
    }

    public void cancelReservation(Reservation reservation) {
        reservations.remove(reservation);
        reservation.cancelReservation();
    }
}

