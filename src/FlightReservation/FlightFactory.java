package FlightReservation;

class FlightFactory {
    public static Flight createFlight(String flightType, String flightNumber, String origin, String destination) {
        switch (flightType.toLowerCase()) {
            case "domestic":
                return new DomesticFlight(flightNumber, origin, destination);
            case "international":
                return new InternationalFlight(flightNumber, origin, destination);
            default:
                throw new IllegalArgumentException("Unknown flight type.");
        }
    }
}
