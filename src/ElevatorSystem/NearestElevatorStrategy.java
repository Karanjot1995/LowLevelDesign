package ElevatorSystem;

import java.util.List;

public class NearestElevatorStrategy implements RequestStrategy{
    @Override
    public Elevator assignElevator(List<Elevator> elevators, int floor, String direction){
        Elevator nearest = null;
        int minDistance = Integer.MAX_VALUE;
        for (Elevator elevator : elevators) {
            // We only consider idle elevators or elevators already moving in the same direction
            if (elevator.isIdle()) {
                int distance = Math.abs(elevator.getCurrentFloor() - floor);
                if (distance < minDistance) {
                    nearest = elevator;
                    minDistance = distance;
                }
            }
//            if (elevator.isIdle() || (direction.equals("UP") && elevator.getDirection() == Direction.UP) ||
//                    (direction.equals("DOWN") && elevator.getDirection() == Direction.DOWN)) {
//                int distance = Math.abs(elevator.getCurrentFloor() - floor);
//                if (distance < minDistance) {
//                    nearest = elevator;
//                    minDistance = distance;
//                }
//            }
        }
        return nearest;
    }
}
