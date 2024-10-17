package FlightReservation;

import java.util.*;

abstract class Flight {
    protected String flightNumber;
    protected String origin;
    protected String destination;
    protected Map<String, Seat> seats;
    protected List<String> availableSeats;

    public Flight(String flightNumber,String origin, String destination){
        this.flightNumber = flightNumber;
        this.origin = origin;
        this.destination = destination;
        this.seats = new HashMap<String, Seat>();
        this.availableSeats = new ArrayList<String>();
    }

    public void addSeat(Seat seat){
        if(seat!=null){
            seats.put(seat.getId(), seat);
            availableSeats.add(seat.getId());
        }
    }
//
    public Seat getSeat(String seatID){
        return seats.get(seatID);
    }

    public String getFlightNumber(){
        return flightNumber;
    }

    public boolean isSeatAvailable(String seatID){
        return availableSeats.contains(seatID);
    }

    public boolean bookSeat(String seatID){
        if(isSeatAvailable(seatID)){
            seats.get(seatID).book();
            availableSeats.remove(seatID);
            return true;
        }else{
            return false;
        }
    }

    public List<String> getAvailableSeats(){
        return availableSeats;
    }

    public abstract String getFlightType();

}
