package LLD.ElevatorManagement;

import java.util.List;

public class ElevatorDispatcher {
    ElevatorManager elevatorManager;
    ElevatorDispatcher()
    {
        elevatorManager = ElevatorManager.getInstance();
    }
    public void addStop(int floor)
    {
        int id = calculateNearestElevator(floor);
    }
    public int calculateNearestElevator(int floor)
    {
        List<Elevator> elevators = elevatorManager.getElevators();
        for(Elevator elevator : elevators)
        {
            
        }
    }

}
