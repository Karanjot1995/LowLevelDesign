package CarRentalSystem;

import java.util.Date;

class Rental {
    private Vehicle vehicle;
    private Customer customer;
    private Date rentalStartDate;
    private Date rentalEndDate;

    public Rental(Vehicle vehicle, Customer customer, Date rentalStartDate, Date rentalEndDate) {
        this.vehicle = vehicle;
        this.customer = customer;
        this.rentalStartDate = rentalStartDate;
        this.rentalEndDate = rentalEndDate;
        vehicle.setStatus(VehicleStatus.RENTED);
    }

    public void returnVehicle() {
        vehicle.setStatus(VehicleStatus.AVAILABLE);
        System.out.println("Vehicle " + vehicle.getModel() + " returned by " + customer.getName());
    }

    public double calculateRentalCost() {
        long rentalDuration = rentalEndDate.getTime() - rentalStartDate.getTime();
        double rentalCost = (rentalDuration / (1000 * 60 * 60 * 24)) * vehicle.getRentalRatePerDay();
        return rentalCost;
    }
}
