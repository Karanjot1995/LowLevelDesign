package ElevatorSystem;

import java.util.List;

public interface RequestStrategy {
    Elevator assignElevator(List<Elevator> elevators, int floor, String direction);
}
