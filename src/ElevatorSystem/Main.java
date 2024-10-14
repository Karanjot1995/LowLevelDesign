package ElevatorSystem;

public class Main {
    public static void main(String[] args) {
        // Initialize the system with one controller and two elevators
        ElevatorSystem system = ElevatorSystem.getInstance();
        Elevator elevator1 = new Elevator(1);
        Elevator elevator2 = new Elevator(2);

        system.addElevator(elevator1);
        system.addElevator(elevator2);

        // Outside panels on various floors
        OutsidePanel panel1 = new OutsidePanel(1, system);
        OutsidePanel panel2 = new OutsidePanel(5, system);

        // Simulate pressing buttons from outside
        panel1.pressUpButton();  // Request for floor 1 to go up
        panel2.pressUpButton();  // Request for floor 5 to go down

        // Inside panel for elevator 1
        InsidePanel insidePanel1 = new InsidePanel(elevator1);
        insidePanel1.pressFloorButton(3);  // Request to go to floor 3 from inside the elevator
        panel2.pressDownButton();

        InsidePanel insidePanel2 = new InsidePanel(elevator2);
        insidePanel2.pressFloorButton(2);  // Request to go to floor 3 from inside the elevator

        // Simulate elevator movements
        System.out.println("\nMoving Elevators Step by Step:");
        for (int i = 0; i < 10; i++) {  // Simulate 10 steps
            System.out.println("\nStep " + (i + 1));
            system.moveElevators();  // Move all elevators one step
        }
    }
}
