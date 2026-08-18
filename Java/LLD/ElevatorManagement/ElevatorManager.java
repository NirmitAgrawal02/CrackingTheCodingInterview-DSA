package LLD.ElevatorManagement;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class ElevatorManager {
    private static ElevatorManager instance;
    static int id = 1;
    public Elevator Elevator;
    ElevatorManager()
    {
        Elevator = new Elevator(id++);
    }
    public static ElevatorManager getInstance()
    {
        if (instance == null) {
        instance = new ElevatorManager();
        }
        return instance;
    }
    public synchronized void  addStop(int floor)
    {
        if(Elevator.getCurrentFloor() > floor)
        {
            Elevator.addDownStop(floor);
        }
        else if(Elevator.getCurrentFloor() < floor)
        {
            Elevator.addUpStop(floor);
        }
        moveElevator();
    }
    public void moveElevator()
    {
        if(Elevator.direction == Direction.NONE)
        {
            changeDirection();
        }
        while(Elevator.direction != Direction.NONE)
        {
        if(Elevator.direction == Direction.UP && Elevator.getUpStopLiftSize() > 0)
            {
            int cf = Elevator.moveElevatorUp();
         }
        else if(Elevator.direction == Direction.DOWN && Elevator.getDownStopLiftSize() > 0)
            {
            int cf = Elevator.moveElevatorDown();
            }
            changeDirection();
        }
    }

    public void changeDirection()
    {
        PriorityQueue<Integer> upStopList = Elevator.upStopList;
        PriorityQueue<Integer> downStopList = Elevator.downStopList;
        Direction direction = Elevator.direction;
        if(direction == direction.NONE && upStopList.size() > 0 && downStopList.size() == 0)
        {
            Elevator.setDirection(Direction.UP);
        }
        else if(direction == direction.NONE && upStopList.size() == 0 && downStopList.size() > 0)
        {
            Elevator.setDirection(Direction.DOWN);
        }
        else if(direction == direction.UP && upStopList.size() == 0 && downStopList.size() > 0)
        {
            Elevator.setDirection(Direction.DOWN);
        }
        else if(direction == direction.DOWN && upStopList.size() > 0 && downStopList.size() == 0)
        {
            Elevator.setDirection(Direction.UP);
        }
        else if((direction == Direction.UP || direction == direction.DOWN) && (upStopList.size() == 0 && downStopList.size() == 0))
        {
            Elevator.setDirection(Direction.NONE);
        }
    }
}
