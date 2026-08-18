package LLD.ElevatorManagement;

import java.util.Collections;
import java.util.PriorityQueue;


class Elevator
{
    Direction direction;
    int id;
    int currentFloor;
    int totalFloors;
    PriorityQueue<Integer> downStopList;
    PriorityQueue<Integer> upStopList;

    public Elevator(int id)
    {
        this.direction = Direction.NONE;
        this.id = id;
        downStopList = new PriorityQueue<>(Collections.reverseOrder());
        upStopList = new PriorityQueue<>();
        this.currentFloor = 1;
        this.totalFloors = 10;
    }
    public void addDownStop(int floor)
    {
                    downStopList.add(floor);
    }
    public void addUpStop(int floor)
    {
                    upStopList.add(floor);
    }
    public Direction checkDirection()
    {
        return this.direction;
    }
    public void setDirection(Direction direction)
    {
        this.direction = direction;
    }

    public int moveElevatorUp()
    {
        if(upStopList.size() == 0)
        {
            return this.currentFloor;
        }
        int currentFloor = upStopList.poll();
        setFloor(currentFloor);
        return this.currentFloor;
    }
    public int moveElevatorDown()
    {
        int currentFloor = downStopList.poll();
        setFloor(currentFloor);
        return this.currentFloor;
    }

    public void setFloor(int floor)
    {
        this.currentFloor = floor;
    }

    public int getCurrentFloor()
    {
        return this.currentFloor;
    }
    public int getUpStopLiftSize()
    {
        return this.upStopList.size();
    }
    public int getDownStopLiftSize()
    {
        return this.downStopList.size();
    }
}