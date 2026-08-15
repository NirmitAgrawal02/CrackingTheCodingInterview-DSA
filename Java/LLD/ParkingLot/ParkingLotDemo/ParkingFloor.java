package LLD.ParkingLot.ParkingLotDemo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ParkingFloor {
    static int floorId = 0;
    List<ParkingSpot> spot = new ArrayList<>();
    HashMap<VehicleType, SpotSize> vehicleSpotSizeMap = new HashMap<>();
    public ParkingFloor() {
        floorId++;
        vehicleSpotSizeMap.put(VehicleType.CAR, SpotSize.MEDIUM);
        vehicleSpotSizeMap.put(VehicleType.BIKE, SpotSize.SMALL);
        vehicleSpotSizeMap.put(VehicleType.TRUCK, SpotSize.LARGE);
    }
    public int[] parkVehicles(VehicleType vehicleType)
    {
       for(ParkingSpot spot : spot)
       {
           if(spot.isAvailable())
           {
                if(spot.getSpotSize() == vehicleSpotSizeMap.get(vehicleType))
                {
               spot.parkVehicles();
               return new int[]{this.floorId, spot.getSpot()};
                }
           }
       }
       return new int[]{-1, -1};
    }
    public void unParkVehicles(int spotId)
    {
        spot.get(spotId).unParkVehicles();
    }

    public void addParkingSpot(ParkingSpot spot) {
        this.spot.add(spot);
    } 
}
