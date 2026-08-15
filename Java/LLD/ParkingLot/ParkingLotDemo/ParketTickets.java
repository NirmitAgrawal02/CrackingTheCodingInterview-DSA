package LLD.ParkingLot.ParkingLotDemo;
import java.time.LocalDateTime;

public class ParketTickets {
    String ticketId;
    int spot;
    int floor; 
    String vehicleNumber;
    VehicleType vehicleType;
    LocalDateTime entryTime;

    public void generateTicket(String vehicleNumber, VehicleType vehicleType, int floor, int spot) {
        // Logic to generate a parking ticket
        this.vehicleNumber = vehicleNumber;
        this.vehicleType = vehicleType;
        this.spot = spot;
        this.floor = floor;
        this.entryTime = LocalDateTime.now();
        this.ticketId = vehicleNumber + "_" + vehicleType + "_" + entryTime.toString();
    }
    public int getSpot() {
        return this.spot;
    }
    public int getFloor() {
        return this.floor;
    }
}
