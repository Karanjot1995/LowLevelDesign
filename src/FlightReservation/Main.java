package FlightReservation;

public class Main {
    public static void main(String[] args) {
        FlightReservationSystem system = FlightReservationSystem.getInstance();

        // add a passenger/guest
        Passenger p1 = new Passenger("P001", "Karan", "ASD123");
        system.addPassenger(p1);

        // Adding flights
        Flight flight = new Flight("AA101", "Dallas", "New York");
        flight.addSeat(new Seat("S001", SeatType.ECONOMY, 100.00));
        flight.addSeat(new Seat("S002", SeatType.ECONOMY, 100.00));
        flight.addSeat(new Seat("S003", SeatType.ECONOMY, 100.00));
        flight.addSeat(new Seat("S004", SeatType.ECONOMY, 100.00));


        Flight flight2 = new Flight("AA102", "New York", "Chicago");
        flight2.addSeat(new Seat("S001", SeatType.ECONOMY, 100.00));
        flight2.addSeat(new Seat("S002", SeatType.ECONOMY, 100.00));
        flight2.addSeat(new Seat("S003", SeatType.ECONOMY, 100.00));
        flight2.addSeat(new Seat("S004", SeatType.ECONOMY, 100.00));

        system.addFlight(flight);
        system.addFlight(flight2);

        system.bookSeat(p1, flight, "S001");
        system.bookSeat(p1, flight2, "S003");

        system.displayAvailableSeats("AA101");
        system.displayAvailableSeats("AA102");

        System.out.println(system.getFlight("AA101"));


//        FlightReservationSystem system = FlightReservationSystem.getInstance();
//
//        // Adding flights
//        system.addFlight("AA101", "Dallas", "New York", 10);
//        system.addFlight("AA102", "Los Angeles", "Chicago", 5);
//
//        // Display available seats
//        system.displayAvailableSeats("AA101");
//
//        // Booking seats
//        system.bookSeat("AA101", 3);
//        system.bookSeat("AA101", 3);  // Trying to book the same seat again (should fail)
//
//        // Display available seats after booking
//        system.displayAvailableSeats("AA101");
//
//        // Booking a seat on a non-existent flight (should fail)
//        system.bookSeat("AA999", 1);
//
//        System.out.println("---------------------------------");
//
//        FlightReservationSystem system2 = FlightReservationSystem.getInstance();
//        system2.addFlight("AA103", "Dallas", "Chicago", 5);
//
//        system.getFlights();
    }
}
