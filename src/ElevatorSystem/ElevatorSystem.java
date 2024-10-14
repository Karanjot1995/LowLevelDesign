package ElevatorSystem;

import java.util.ArrayList;
import java.util.List;

class ElevatorSystem{
    private List<Elevator> elevators;
    private static ElevatorSystem instance;
    private RequestStrategy requestStrategy;

    private ElevatorSystem(){
        elevators = new ArrayList<Elevator>();
        requestStrategy = new NearestElevatorStrategy();
    }

    // Singleton pattern to ensure only one instance of the controller
    public static ElevatorSystem getInstance() {
        if (instance == null) {
            instance = new ElevatorSystem();
        }
        return instance;
    }

    public void addElevator(Elevator elevator) {
        elevators.add(elevator);
    }

    public void setRequestStrategy(RequestStrategy strategy) {
        this.requestStrategy = strategy;
    }

    // Handle an external request from the outside panel (Up/Down button press)

    public void requestElevator(int floor, String direction) {
        Elevator assignedElevator = requestStrategy.assignElevator(elevators, floor, direction);
        if (assignedElevator != null) {
            System.out.println("Elevator "+ assignedElevator.getId() +" on current floor " + assignedElevator.getCurrentFloor() + " assigned to floor " + floor);
            assignedElevator.addRequest(floor);
        } else {
            System.out.println("No available elevator to serve the request.");
        }
    }

    // Simulate moving all elevators one step at a time
    public void moveElevators() {
        for (Elevator elevator : elevators) {
            if (elevator.getState() != ElevatorState.IDLE) {
                elevator.move();
            }
        }
    }


//    public void requestElevator(int floor, String direction) {
//        Elevator closestElevator = null;
//        int minDistance = Integer.MAX_VALUE;
//
//        // Find the closest idle or available elevator
//        for (Elevator elevator : elevators) {
//            if (elevator.isIdle()) {
//                int distance = Math.abs(elevator.getCurrentFloor() - floor);
//                if (distance < minDistance) {
//                    closestElevator = elevator;
//                    minDistance = distance;
//                }
//            }
//        }
//
//        if (closestElevator != null) {
//            System.out.println("Elevator " + closestElevator.getCurrentFloor() + " assigned to floor " + floor);
//            closestElevator.addRequest(floor);
//        } else {
//            System.out.println("No available elevator to serve the request.");
//        }
//    }

}

