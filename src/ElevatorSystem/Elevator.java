package ElevatorSystem;

import java.util.TreeSet;

class Elevator{
    private int id;
    private int currentFloor;
    private TreeSet<Integer> requests;
    private ElevatorState state;

    public Elevator(int id, int currentFloor){
        this.id = id;
        this.currentFloor = currentFloor;
        this.state = ElevatorState.IDLE;
        this.requests = new TreeSet<Integer>();
    }

    public void addRequest(int floor){
        requests.add(floor);
        updateState();
        System.out.println("Requests" + requests.toString());
    }

    public void move(){
        if(state == ElevatorState.MOVING_UP){
            currentFloor++;
        }else if(state==ElevatorState.MOVING_DOWN){
            currentFloor--;
        }
        System.out.println("Elevator " + id + " moved to floor " + currentFloor);

        if(requests.contains(currentFloor)){
            requests.remove(currentFloor);
            System.out.println("Elevator " + id + " reached requested floor " + currentFloor);
            updateState();
        }
    }

    public void updateState(){
        if(requests.isEmpty()){
            state = ElevatorState.IDLE;
        }else if(requests.first() > currentFloor){
            state = ElevatorState.MOVING_UP;
        }else if(requests.first() < currentFloor){
            state = ElevatorState.MOVING_DOWN;
        }
    }

    public ElevatorState getState(){
        return state;
    }

    public int getId(){
        return id;
    }

    public int getCurrentFloor(){
        return currentFloor;
    }

    public boolean isIdle(){
        return state == ElevatorState.IDLE;
    }

}





















//
//class Elevator {
//    private int id;
//    private int currentFloor;
//    private ElevatorState state;
//    private TreeSet<Integer> requests;  // Sorted set of floor requests
//
//    public Elevator(int id) {
//        this.id = id;
//        this.currentFloor = 0;
//        this.state = ElevatorState.IDLE;
//        this.requests = new TreeSet<>();
//    }
//
//    // Process one step of the elevator (move one floor)
//    public void move() {
//        if (state == ElevatorState.MOVING_UP) {
//            currentFloor++;
//        } else if (state == ElevatorState.MOVING_DOWN) {
//            currentFloor--;
//        }
//
//        System.out.println("Elevator " + id + " moved to floor " + currentFloor);
//
//        // If reached a requested floor, stop and handle the request
//        if (requests.contains(currentFloor)) {
//            System.out.println("Elevator " + id + " reached requested floor " + currentFloor);
//            requests.remove(currentFloor);
//            updateState();
//        }
//    }
//
//    // Add a floor request
//    public void addRequest(int floor) {
//        requests.add(floor);
//        updateState();
//    }
//
//    // Update the state of the elevator
//    private void updateState() {
//        if (requests.isEmpty()) {
//            state = ElevatorState.IDLE;
//        } else if (requests.first() > currentFloor) {
//            state = ElevatorState.MOVING_UP;
//        } else if (requests.first() < currentFloor) {
//            state = ElevatorState.MOVING_DOWN;
//        }
//    }
//
//    public ElevatorState getState() {
//        return state;
//    }
//
//    public int getCurrentFloor() {
//        return currentFloor;
//    }
//
//    public boolean isIdle() {
//        return state == ElevatorState.IDLE;
//    }
//}
