package FlightReservation;

public class Passenger {
    private String id;
    private String name;
    private String passportNumber;

    public Passenger(String id, String name, String passportNumber){
        this.id = id;
        this.name = name;
        this.passportNumber = passportNumber;
    }
    public String getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getPassportNumber() {
        return passportNumber;
    }
}
