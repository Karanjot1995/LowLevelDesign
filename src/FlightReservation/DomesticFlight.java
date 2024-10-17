package FlightReservation;

import java.util.ArrayList;
import java.util.HashMap;

class DomesticFlight extends Flight{
    public DomesticFlight(String flightNumber,String origin, String destination){
        super(flightNumber, origin, destination);
    }

    public String getFlightType(){
        return "Domestic";
    }

    @Override
    public String toString() {
        return "Domestic Flight " + flightNumber + " from " + origin + " to " + destination + ". Available seats: " + availableSeats;
    }
}
