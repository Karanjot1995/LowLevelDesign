package FRS;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FlightReservationSystemFRS {
    // Map from flightNumber to Flight
    private Map<String, FlightFRS> flights;

    // Private constructor to prevent external instantiation
    private FlightReservationSystemFRS() {
        flights = new HashMap<>();
    }

    // The Library is a singleton class that ensures it will have only one active instance at a time
    private static FlightReservationSystemFRS flightSystem = null;

    // Created a static method to access the singleton instance of Library class
    public static FlightReservationSystemFRS getInstance(){
        if(flightSystem==null){
            flightSystem = new FlightReservationSystemFRS();
        }
        return flightSystem;
    }

    public void addFlight(String flightNumber, String origin, String destination, int totalSeats){
        FlightFRS flight = new FlightFRS(flightNumber, origin, destination, totalSeats);
        flights.put(flightNumber,flight);
    }

    public List<String> getFlights(){
        List<String> displayFlights = new ArrayList<String>();
        for(String key : flights.keySet()){
            displayFlights.add(key);
        }
        System.out.println(displayFlights.toString());
        return displayFlights;
    }

    public boolean bookSeat(String flightNumber, int seatNumber){
        FlightFRS flight = flights.get(flightNumber);
        if (flight == null) {
            System.out.println("Flight not found.");
            return false;
        }
        boolean success = flight.bookSeat(seatNumber);
        if (success) {
            System.out.println("Seat " + seatNumber + " booked on flight " + flightNumber);
        } else {
            System.out.println("Seat " + seatNumber + " is already booked or invalid.");
        }
        return success;
    }

    public void displayAvailableSeats(String flightNumber) {
        FlightFRS flight = flights.get(flightNumber);
        if (flight != null) {
            System.out.println(flight);
        } else {
            System.out.println("Flight not found.");
        }
    }

}
