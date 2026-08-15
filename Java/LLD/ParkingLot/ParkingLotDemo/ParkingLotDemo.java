package LLD.ParkingLot.ParkingLotDemo;

import java.util.Scanner;

public class ParkingLotDemo {
    public static void main(String[] args) {
        ParkingLot parkingLot = new ParkingLot();
       parkingLot.addFloors(new ParkingFloor(1));
       parkingLot.addFloors(new ParkingFloor(2));
       parkingLot.floor.get(0).addParkingSpot(new ParkingSpot(SpotSize.SMALL));
       parkingLot.floor.get(0).addParkingSpot(new ParkingSpot(SpotSize.MEDIUM));
       parkingLot.floor.get(0).addParkingSpot(new ParkingSpot(SpotSize.LARGE));;
       parkingLot.floor.get(1).addParkingSpot(new ParkingSpot(SpotSize.SMALL));
       parkingLot.floor.get(1).addParkingSpot(new ParkingSpot(SpotSize.MEDIUM));
       parkingLot.floor.get(1).addParkingSpot(new ParkingSpot(SpotSize.LARGE));

       do
        {
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter 1 to Park Vehicle");
            System.out.println("Enter 2 to Unpark Vehicle");    
            int choice = sc.nextInt();
            if(choice == 1)
            {
            System.out.println("Enter Vehicle Type: 1. CAR 2. BIKE 3. TRUCK");
            int vehicleTypeInput = sc.nextInt();
            sc.nextLine();
            VehicleType vehicleType = null;
            switch (vehicleTypeInput) {
                case 1:
                    vehicleType = VehicleType.CAR;
                    break;
                case 2:
                    vehicleType = VehicleType.BIKE;
                    break;
                case 3:
                    vehicleType = VehicleType.TRUCK;
                    break;
                default:
                    System.out.println("Invalid Input");
                    break;
            }
            System.out.println("Enter Vehicle Number");
            String vehicleNumber = sc.nextLine();
            String result = parkingLot.parkVehicles(vehicleType, vehicleNumber);
            if((!result.equals("")))
            {
                System.out.println("Ticket ID: " + result); 
            }
            else
             {
                  System.out.println("No Spot Found");
             }
            }
            else if(choice == 2)
            {
                sc.nextLine();
                System.out.println("Enter Ticket ID");
                String ticketId = sc.nextLine();
                parkingLot.unParkVehicles(ticketId);
            }
            else
            {
                System.out.println("Invalid Input .... Exiting System");
                break;
            }
        }     
    while(true);}
}
