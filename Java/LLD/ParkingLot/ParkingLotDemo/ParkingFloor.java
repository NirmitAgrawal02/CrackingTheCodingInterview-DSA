package LLD.ParkingLot.ParkingLotDemo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

public class ParkingFloor {
    int floorId;
    List<ParkingSpot> spot = new ArrayList<>();
    HashMap<VehicleType, SpotSize> vehicleSpotSizeMap = new HashMap<>();
    public ParkingFloor(int floorId) {
        this.floorId = floorId;
        vehicleSpotSizeMap.put(VehicleType.CAR, SpotSize.MEDIUM);
        vehicleSpotSizeMap.put(VehicleType.BIKE, SpotSize.SMALL);
        vehicleSpotSizeMap.put(VehicleType.TRUCK, SpotSize.LARGE);
    }
    public int[] parkVehicles(ParkingSpot spot)
    {
        spot.parkVehicles();
        return new int[]{floorId, spot.getSpot()};
    }
    public void unParkVehicles(int spotId)
    {
        spot.get(spotId).unParkVehicles();
    }

    public void addParkingSpot(ParkingSpot spot) {
        this.spot.add(spot);
    }
    public ParkingSpot ifAvailableSpot(VehicleType vehicleType)
    {
        Stack<ParkingSpot> availableSpots = new Stack<>();
        boolean nextBiggestSizeAvailable = false;
        for(ParkingSpot spot : spot)
        {
            if(spot.isAvailable())
            {
                if(spot.getSpotSize() == vehicleSpotSizeMap.get(vehicleType))
                {
                    return spot;
                }
                else if(vehicleType == VehicleType.CAR && spot.getSpotSize() == SpotSize.LARGE && nextBiggestSizeAvailable == false)
                {
                    availableSpots.push(spot);
                    nextBiggestSizeAvailable = true;
                }
                else if(vehicleType == VehicleType.BIKE && spot.getSpotSize() == SpotSize.MEDIUM && nextBiggestSizeAvailable == false)
                {
                    availableSpots.push(spot);
                    nextBiggestSizeAvailable = true;
                }
                else if(vehicleType == VehicleType.BIKE && spot.getSpotSize() == SpotSize.LARGE && nextBiggestSizeAvailable == false && availableSpots.isEmpty())
                {
                    availableSpots.push(spot);
                }
            }
        }
        return availableSpots.isEmpty() ? null : availableSpots.peek();
    }
}