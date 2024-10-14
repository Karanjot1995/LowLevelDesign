package ElevatorSystem;

class OutsidePanel {
    private int floor;
    private ElevatorSystem system;

    public  OutsidePanel(int floor, ElevatorSystem system){
        this.floor = floor;
        this.system = system;
    }

    public void pressUpButton(){
        System.out.println("Up button pressed on floor " + floor);
        system.requestElevator(floor, "UP");
    }
    public void pressDownButton(){
        System.out.println("Down button pressed on floor " + floor);
        system.requestElevator(floor, "DOWN");
    }
}
