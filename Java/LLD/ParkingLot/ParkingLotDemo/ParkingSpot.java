package LLD.ParkingLot.ParkingLotDemo;

public class ParkingSpot {
    boolean isAvailable;
    public static int spotId = 0;
    SpotSize spotSize;

    public ParkingSpot(SpotSize spotSize) {
        this.spotId = spotId++;
        this.spotSize = spotSize;
        this.isAvailable = true;
    }

    public boolean isAvailable()
    {
        return isAvailable;
    }
    public void parkVehicles()
    {
        isAvailable = false;
    }
    public void unParkVehicles()
    {
        isAvailable = true;
    }
    public int getSpot() {
        return spotId;
    }

    public SpotSize getSpotSize() {
        return spotSize;
    }
}