package FlightReservation;

public class InternationalFlight extends Flight{
    public InternationalFlight(String flightNumber,String origin, String destination){
        super(flightNumber, origin, destination);
    }

    public String getFlightType(){
        return "International";
    }

    @Override
    public String toString() {
        return "International Flight " + flightNumber + " from " + origin + " to " + destination + ". Available seats: " + availableSeats;
    }
}
