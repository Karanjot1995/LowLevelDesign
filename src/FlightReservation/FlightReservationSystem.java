package FlightReservation;

import java.util.*;

public class FlightReservationSystem {
    // Map from flightNumber to Flight
    private Map<String, Flight> flights;
    private Map<String, Passenger> passengers;
    private Map<String, Reservation> reservations;

    // Private constructor to prevent external instantiation
    private FlightReservationSystem() {
        flights = new HashMap<>();
        passengers = new HashMap<>();
        reservations = new HashMap<>();
    }

    // The Library is a singleton class that ensures it will have only one active instance at a time
    private static FlightReservationSystem flightSystem = null;

    // Created a static method to access the singleton instance of Library class
    public static FlightReservationSystem getInstance(){
        if(flightSystem==null){
            flightSystem = new FlightReservationSystem();
        }
        return flightSystem;
    }

    public void addFlight(Flight flight){
        flights.put(flight.getFlightNumber(), flight);
    }

    public void addPassenger(Passenger passenger) {
        passengers.put(passenger.getId(), passenger);
    }

    public Flight getFlight(String flightNumber){
        return flights.get(flightNumber);
    }

    public List<String> getFlights(){
        List<String> displayFlights = new ArrayList<String>();
        for(String key : flights.keySet()){
            displayFlights.add(key);
        }
        System.out.println(displayFlights.toString());
        return displayFlights;
    }

    public Reservation bookSeat(Passenger passenger, Flight flight, String seatID) {
        if (flight == null) {
            System.out.println("Flight not found.");
            return null;
        }

        if (flight.getAvailableSeats().contains(seatID)) {
            flight.bookSeat(seatID);
            Seat seat = flight.getSeat(seatID);
            String reservationId = generateReservationId();
            Reservation reservation = new Reservation(reservationId, passenger, flight, seat);
            reservations.put(reservationId, reservation);
            System.out.println(reservation);
            return reservation;
        }
        return null;
    }

//    public Reservation bookSeat(String flightNumber, String seatID){

//        boolean success = flight.bookSeat(seatID);
//        if (success) {
//            System.out.println("Seat " + seatID + " booked on flight " + flightNumber);
//        } else {
//            System.out.println("Seat " + seatID + " is already booked or invalid.");
//        }
//        return success;
//    }

    private String generateReservationId() {
        // Generate a unique reservation ID
        return "RES" + UUID.randomUUID().toString().substring(0, 8).toUpperCase();
    }

    public void displayAvailableSeats(String flightNumber) {
        Flight flight = flights.get(flightNumber);
        if (flight != null) {
            System.out.println(flight);
        } else {
            System.out.println("Flight not found.");
        }
    }

}
