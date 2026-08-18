package LLD.ElevatorManagement;


public enum Direction
{
    UP(1),DOWN(-1),NONE(0);
    private int directionValue;
    Direction(int directionValue) {
        this.directionValue = directionValue;
    }
    public int getDirectionValue() {
        return this.directionValue;
    }
}