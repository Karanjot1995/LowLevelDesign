package CarRentalSystem;

import java.util.Date;

class Reservation {
    private Vehicle vehicle;
    private Customer customer;
    private Date startDate;
    private Date endDate;

    public Reservation(Vehicle vehicle, Customer customer, Date startDate, Date endDate) {
        this.vehicle = vehicle;
        this.customer = customer;
        this.startDate = startDate;
        this.endDate = endDate;
        vehicle.setStatus(VehicleStatus.RESERVED);
    }

    public void confirmReservation() {
        System.out.println("Reservation confirmed for " + vehicle.getModel() + " by " + customer.getName());
    }

    public void cancelReservation() {
        vehicle.setStatus(VehicleStatus.AVAILABLE);
        System.out.println("Reservation canceled for " + vehicle.getModel());
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }
}

