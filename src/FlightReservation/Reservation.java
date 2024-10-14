package FlightReservation;

public class Reservation {
    private String id;
    private Passenger passenger;
    private Flight flight;
    private Seat seat;

    public Reservation(String id, Passenger passenger, Flight flight, Seat seat) {
        this.id = id;
        this.passenger = passenger;
        this.flight = flight;
        this.seat = seat;
    }

    public String getId() {
        return id;
    }

    public Passenger getGuest() {
        return passenger;
    }

    public Flight getRoom() {
        return flight;
    }

    public Seat getSeat() {
        return seat;
    }

    @Override
    public String toString() {
        return "Passenger:"+ passenger.getId() + ", Flight: " + flight.getFlightNumber() + ", Seat: " + seat.getId() +  ", Seat Status: " + seat.getStatus();
    }


}
