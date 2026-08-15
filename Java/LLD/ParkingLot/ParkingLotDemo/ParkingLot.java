package LLD.ParkingLot.ParkingLotDemo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ParkingLot { 
    List<ParkingFloor> floor = new ArrayList<>();
    HashMap<String, ParketTickets> tickets = new HashMap<>();
    public String parkVehicles(VehicleType vehicleType, String vehicleNumber) {
        for(ParkingFloor floor : floor)
        {
            int[] result = floor.parkVehicles(VehicleType vehicleType);
            if(result[0] != -1 && result[1] != -1)
            {
            ParketTickets ticket = new ParketTickets();
            ticket.generateTicket(vehicleNumber, vehicleType, result[0], result[1]);
            tickets.put(ticket.ticketId, ticket);
            return ticket.ticketId;
            }
        }
        return "";
    }
    public void unParkVehicles(String ticketId) {
        ParketTickets ticket = tickets.get(ticketId);
        if (ticket != null) {
            floor.get(ticket.getFloor()).unParkVehicles(ticket.getSpot());
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
