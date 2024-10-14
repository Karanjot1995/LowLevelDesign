package ElevatorSystem;

class InsidePanel {
    private Elevator elevator;

    public InsidePanel(Elevator elevator) {
        this.elevator = elevator;
    }

    public void pressFloorButton(int floor) {
        System.out.println("Inside elevator "+ elevator.getId()+" , elevator on floor " + elevator.getCurrentFloor() + ", floor button " + floor + " pressed");
        elevator.addRequest(floor);
    }
}
