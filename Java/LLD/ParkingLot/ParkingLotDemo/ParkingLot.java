package LLD.ParkingLot.ParkingLotDemo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ParkingLot { 
    List<ParkingFloor> floor = new ArrayList<>();
    HashMap<String, ParketTickets> tickets = new HashMap<>();
    HashMap<VehicleType, SpotSize> vehicleSpotSizeMap = new HashMap<>();
    ParkingLot()
    {
        vehicleSpotSizeMap.put(VehicleType.CAR, SpotSize.MEDIUM);
        vehicleSpotSizeMap.put(VehicleType.BIKE, SpotSize.SMALL);
        vehicleSpotSizeMap.put(VehicleType.TRUCK, SpotSize.LARGE);
    }
    public String parkVehicles(VehicleType vehicleType, String vehicleNumber) {
        ParkingSpot nextBiggestSizeSpot = null;
        ParkingFloor nextBiggestSizeFloor = null;
        for(ParkingFloor floor : floor)
        {
            ParkingSpot spot = floor.ifAvailableSpot(vehicleType);
            if(spot == null)
            {
                continue;
            }
            else if(spot.spotSize != vehicleSpotSizeMap.get(vehicleType))
            {
                nextBiggestSizeFloor = floor;
                nextBiggestSizeSpot = spot;
                continue;
            }
            int[] result = floor.parkVehicles(spot);
            ParketTickets ticket = new ParketTickets();
            ticket.generateTicket(vehicleNumber, vehicleType, result[0], result[1]);
            tickets.put(ticket.ticketId, ticket);
            return ticket.ticketId;
        }
        if(nextBiggestSizeSpot != null)
        {
            int[] result = nextBiggestSizeFloor.parkVehicles(nextBiggestSizeSpot);
            ParketTickets ticket = new ParketTickets();
            ticket.generateTicket(vehicleNumber, vehicleType, result[0], result[1]);
            tickets.put(ticket.ticketId, ticket);
            return ticket.ticketId;
        }
        return "";
    }
    public void unParkVehicles(String ticketId) {
        ParketTickets ticket = tickets.get(ticketId);
        if (ticket != null) {
            floor.get(ticket.getFloor() -1).unParkVehicles(ticket.getSpot());
            tickets.remove(ticketId);
            Fees fees = new Fees();
            fees.calculateFee(ticket.entryTime, ticket.vehicleType);
            System.out.println("Total Fees: " + fees.getTotalFees());
            System.out.println("Vehicle unparked successfully");   
        }
        else
        {
            System.out.println("Invalid Ticket ID");
        }
    }

    public void addFloors(ParkingFloor floor) {
        this.floor.add(floor);
    }
}
