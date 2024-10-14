package FlightReservation;

public class Seat {
    private String id;
    private SeatType type;
    private SeatStatus status;
    private double price;

    public Seat(String id, SeatType type, double price) {
        this.id = id;
        this.type = type;
        this.price = price;
        this.status = SeatStatus.AVAILABLE;
    }

    public boolean book(){
        if(status==SeatStatus.AVAILABLE){
            status = SeatStatus.BOOKED;
            return true;
        }
        return false;
    }

    public String getId() {
        return id;
    }

    public SeatType getType() {
        return type;
    }

    public double getPrice() {
        return price;
    }

    public SeatStatus getStatus() {
        return status;
    }
    @Override
    public String toString() {
        return "Seat " + id + ", Price: " + price + ", Status:" + status;
    }

}
