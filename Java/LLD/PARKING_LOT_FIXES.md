# Parking Lot LLD - Recommended Fixes

## 1. FIX: ParkingSpot Static Variable Bug

**Current (BROKEN):**
```java
public class ParkingSpot {
    boolean isAvailable;
    public static int spotId = 0;  // ❌ SHARED ACROSS ALL INSTANCES
    SpotSize spotSize;

    public ParkingSpot(SpotSize spotSize) {
        this.spotId = spotId++;  // All spots globally numbered!
        this.spotSize = spotSize;
        this.isAvailable = true;
    }
}
```

**Fixed:**
```java
public class ParkingSpot {
    private boolean isAvailable;
    private final int spotId;  // ✅ Instance variable
    private final SpotSize spotSize;

    public ParkingSpot(int spotId, SpotSize spotSize) {
        this.spotId = spotId;
        this.spotSize = spotSize;
        this.isAvailable = true;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void parkVehicle() {
        if (!isAvailable) {
            throw new IllegalStateException("Spot already occupied");
        }
        this.isAvailable = false;
    }

    public void unparkVehicle() {
        this.isAvailable = true;
    }

    public int getSpotId() {
        return spotId;
    }

    public SpotSize getSpotSize() {
        return spotSize;
    }
}
```

---

## 2. FIX: Add Vehicle Class

**New File: Vehicle.java**
```java
package LLD.ParkingLot.ParkingLotDemo;

public class Vehicle {
    private final String vehicleNumber;
    private final VehicleType vehicleType;
    private String ownerName;
    private String color;

    public Vehicle(String vehicleNumber, VehicleType vehicleType) {
        this.vehicleNumber = vehicleNumber;
        this.vehicleType = vehicleType;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
```

---

## 3. FIX: Rename ParketTickets to ParkingTicket

**Old Name:** ParketTickets → **New Name:** ParkingTicket

```java
package LLD.ParkingLot.ParkingLotDemo;

import java.time.LocalDateTime;

public class ParkingTicket {
    private final String ticketId;
    private final int spotId;
    private final int floorNumber;
    private final Vehicle vehicle;
    private final LocalDateTime entryTime;
    private LocalDateTime exitTime;

    public ParkingTicket(String ticketId, Vehicle vehicle, int floorNumber, int spotId) {
        this.ticketId = ticketId;
        this.vehicle = vehicle;
        this.floorNumber = floorNumber;
        this.spotId = spotId;
        this.entryTime = LocalDateTime.now();
    }

    public void setExitTime(LocalDateTime exitTime) {
        this.exitTime = exitTime;
    }

    // Getters
    public String getTicketId() { return ticketId; }
    public Vehicle getVehicle() { return vehicle; }
    public int getFloorNumber() { return floorNumber; }
    public int getSpotId() { return spotId; }
    public LocalDateTime getEntryTime() { return entryTime; }
    public LocalDateTime getExitTime() { return exitTime; }
    public long getParkingDurationInHours() {
        if (exitTime == null) return 0;
        return java.time.Duration.between(entryTime, exitTime).toHours();
    }
}
```

---

## 4. FIX: Add FeeConfiguration Class

**New File: FeeConfiguration.java**
```java
package LLD.ParkingLot.ParkingLotDemo;

import java.util.HashMap;
import java.util.Map;

public class FeeConfiguration {
    private static final FeeConfiguration instance = new FeeConfiguration();
    
    private final Map<VehicleType, Integer> hourlyRates;
    private final int minimumCharge;

    private FeeConfiguration() {
        hourlyRates = new HashMap<>();
        hourlyRates.put(VehicleType.BIKE, 10);
        hourlyRates.put(VehicleType.CAR, 20);
        hourlyRates.put(VehicleType.TRUCK, 30);
        this.minimumCharge = 10;  // Minimum parking charge
    }

    public static FeeConfiguration getInstance() {
        return instance;
    }

    public int getHourlyRate(VehicleType vehicleType) {
        return hourlyRates.getOrDefault(vehicleType, 0);
    }

    public int getMinimumCharge() {
        return minimumCharge;
    }

    public void setHourlyRate(VehicleType vehicleType, int rate) {
        hourlyRates.put(vehicleType, rate);
    }
}
```

---

## 5. FIX: Update Fees Class

```java
package LLD.ParkingLot.ParkingLotDemo;

import java.time.LocalDateTime;
import java.time.Duration;

public class Fees {
    private int totalFees;

    public void calculateFee(LocalDateTime entryTime, LocalDateTime exitTime, VehicleType vehicleType) {
        if (exitTime == null) {
            throw new IllegalArgumentException("Exit time not set");
        }

        long durationInHours = Duration.between(entryTime, exitTime).toHours();
        if (durationInHours == 0) {
            durationInHours = 1;  // Minimum 1 hour charge
        }

        FeeConfiguration config = FeeConfiguration.getInstance();
        int hourlyRate = config.getHourlyRate(vehicleType);
        this.totalFees = (int) (hourlyRate * durationInHours);
        
        // Ensure minimum charge
        this.totalFees = Math.max(this.totalFees, config.getMinimumCharge());
    }

    public int getTotalFees() {
        return totalFees;
    }
}
```

---

## 6. FIX: Update ParkingFloor with Proper Encapsulation

```java
package LLD.ParkingLot.ParkingLotDemo;

import java.util.*;

public class ParkingFloor {
    private final int floorNumber;
    private final List<ParkingSpot> spots;
    private final Map<VehicleType, SpotSize> vehicleSpotMapping;
    private int nextSpotId = 0;

    public ParkingFloor(int floorNumber, int smallSpots, int mediumSpots, int largeSpots) {
        this.floorNumber = floorNumber;
        this.spots = new ArrayList<>();
        this.vehicleSpotMapping = initializeVehicleSpotMapping();
        
        // Initialize spots
        for (int i = 0; i < smallSpots; i++) {
            spots.add(new ParkingSpot(nextSpotId++, SpotSize.SMALL));
        }
        for (int i = 0; i < mediumSpots; i++) {
            spots.add(new ParkingSpot(nextSpotId++, SpotSize.MEDIUM));
        }
        for (int i = 0; i < largeSpots; i++) {
            spots.add(new ParkingSpot(nextSpotId++, SpotSize.LARGE));
        }
    }

    private Map<VehicleType, SpotSize> initializeVehicleSpotMapping() {
        Map<VehicleType, SpotSize> map = new HashMap<>();
        map.put(VehicleType.BIKE, SpotSize.SMALL);
        map.put(VehicleType.CAR, SpotSize.MEDIUM);
        map.put(VehicleType.TRUCK, SpotSize.LARGE);
        return map;
    }

    public ParkingSpot findAvailableSpot(VehicleType vehicleType) {
        SpotSize requiredSize = vehicleSpotMapping.get(vehicleType);
        
        // First, try to find exact match
        for (ParkingSpot spot : spots) {
            if (spot.isAvailable() && spot.getSpotSize() == requiredSize) {
                return spot;
            }
        }
        
        // If no exact match, try bigger spot
        for (ParkingSpot spot : spots) {
            if (spot.isAvailable() && spot.getSpotSize().ordinal() > requiredSize.ordinal()) {
                return spot;
            }
        }
        
        return null;  // No spot available
    }

    public void parkVehicle(ParkingSpot spot) {
        spot.parkVehicle();
    }

    public void unparkVehicle(int spotId) {
        for (ParkingSpot spot : spots) {
            if (spot.getSpotId() == spotId) {
                spot.unparkVehicle();
                return;
            }
        }
        throw new IllegalArgumentException("Spot ID not found: " + spotId);
    }

    public int getAvailableSpotCount() {
        return (int) spots.stream().filter(ParkingSpot::isAvailable).count();
    }

    public int getFloorNumber() {
        return floorNumber;
    }

    public int getTotalSpots() {
        return spots.size();
    }
}
```

---

## 7. FIX: Update ParkingLot Class

```java
package LLD.ParkingLot.ParkingLotDemo;

import java.time.LocalDateTime;
import java.util.*;

public class ParkingLot {
    private static ParkingLot instance;
    private final List<ParkingFloor> floors;
    private final Map<String, ParkingTicket> ticketMap;

    private ParkingLot() {
        this.floors = new ArrayList<>();
        this.ticketMap = new HashMap<>();
    }

    public static synchronized ParkingLot getInstance() {
        if (instance == null) {
            instance = new ParkingLot();
        }
        return instance;
    }

    public void addFloor(ParkingFloor floor) {
        if (floor == null) {
            throw new IllegalArgumentException("Floor cannot be null");
        }
        floors.add(floor);
    }

    public String parkVehicle(Vehicle vehicle) throws ParkingException {
        if (vehicle == null) {
            throw new IllegalArgumentException("Vehicle cannot be null");
        }

        for (ParkingFloor floor : floors) {
            ParkingSpot availableSpot = floor.findAvailableSpot(vehicle.getVehicleType());
            
            if (availableSpot != null) {
                floor.parkVehicle(availableSpot);
                
                // Generate ticket
                String ticketId = generateTicketId();
                ParkingTicket ticket = new ParkingTicket(ticketId, vehicle, 
                                                         floor.getFloorNumber(), 
                                                         availableSpot.getSpotId());
                ticketMap.put(ticketId, ticket);
                
                return ticketId;
            }
        }
        
        throw new ParkingException("No parking spot available for vehicle type: " + vehicle.getVehicleType());
    }

    public int unparkVehicle(String ticketId) throws ParkingException {
        ParkingTicket ticket = ticketMap.get(ticketId);
        if (ticket == null) {
            throw new ParkingException("Invalid ticket ID: " + ticketId);
        }

        // Find floor and unpark
        ParkingFloor floor = floors.get(ticket.getFloorNumber() - 1);
        floor.unparkVehicle(ticket.getSpotId());

        // Set exit time and calculate fee
        ticket.setExitTime(LocalDateTime.now());
        
        Fees fees = new Fees();
        fees.calculateFee(ticket.getEntryTime(), ticket.getExitTime(), 
                         ticket.getVehicle().getVehicleType());
        
        ticketMap.remove(ticketId);
        return fees.getTotalFees();
    }

    public int getAvailableSpotCount() {
        return floors.stream()
                    .mapToInt(ParkingFloor::getAvailableSpotCount)
                    .sum();
    }

    public int getTotalSpots() {
        return floors.stream()
                    .mapToInt(ParkingFloor::getTotalSpots)
                    .sum();
    }

    private String generateTicketId() {
        return "TICKET_" + System.currentTimeMillis();
    }
}
```

---

## 8. FIX: Add ParkingException

**New File: ParkingException.java**
```java
package LLD.ParkingLot.ParkingLotDemo;

public class ParkingException extends Exception {
    public ParkingException(String message) {
        super(message);
    }

    public ParkingException(String message, Throwable cause) {
        super(message, cause);
    }
}
```

---

## 9. FIX: Update ParkingLotDemo (Resource Management)

```java
package LLD.ParkingLot.ParkingLotDemo;

import java.util.Scanner;

public class ParkingLotDemo {
    public static void main(String[] args) {
        ParkingLot parkingLot = ParkingLot.getInstance();
        
        // Initialize parking lot with floors and spots
        parkingLot.addFloor(new ParkingFloor(1, 2, 2, 1));
        parkingLot.addFloor(new ParkingFloor(2, 2, 2, 1));

        try (Scanner sc = new Scanner(System.in)) {
            boolean running = true;
            
            while (running) {
                System.out.println("\n=== Parking Lot System ===");
                System.out.println("1. Park Vehicle");
                System.out.println("2. Unpark Vehicle");
                System.out.println("3. Check Available Spots");
                System.out.println("4. Exit");
                System.out.print("Enter choice: ");
                
                int choice = sc.nextInt();
                sc.nextLine();  // Consume newline
                
                try {
                    switch (choice) {
                        case 1:
                            parkVehicleMenu(parkingLot, sc);
                            break;
                        case 2:
                            unparkVehicleMenu(parkingLot, sc);
                            break;
                        case 3:
                            System.out.println("Available spots: " + parkingLot.getAvailableSpotCount());
                            System.out.println("Total spots: " + parkingLot.getTotalSpots());
                            break;
                        case 4:
                            running = false;
                            System.out.println("Thank you!");
                            break;
                        default:
                            System.out.println("Invalid choice!");
                    }
                } catch (ParkingException e) {
                    System.out.println("Error: " + e.getMessage());
                }
            }
        }
    }

    private static void parkVehicleMenu(ParkingLot parkingLot, Scanner sc) throws ParkingException {
        System.out.print("Enter vehicle number: ");
        String vehicleNumber = sc.nextLine().trim();
        
        if (vehicleNumber.isEmpty()) {
            throw new ParkingException("Vehicle number cannot be empty");
        }
        
        System.out.println("Select vehicle type:");
        System.out.println("1. CAR");
        System.out.println("2. BIKE");
        System.out.println("3. TRUCK");
        System.out.print("Enter type (1-3): ");
        
        int typeChoice = sc.nextInt();
        VehicleType vehicleType = switch (typeChoice) {
            case 1 -> VehicleType.CAR;
            case 2 -> VehicleType.BIKE;
            case 3 -> VehicleType.TRUCK;
            default -> throw new ParkingException("Invalid vehicle type");
        };

        Vehicle vehicle = new Vehicle(vehicleNumber, vehicleType);
        String ticketId = parkingLot.parkVehicle(vehicle);
        System.out.println("✓ Vehicle parked successfully!");
        System.out.println("Ticket ID: " + ticketId);
    }

    private static void unparkVehicleMenu(ParkingLot parkingLot, Scanner sc) throws ParkingException {
        System.out.print("Enter ticket ID: ");
        String ticketId = sc.nextLine().trim();
        
        if (ticketId.isEmpty()) {
            throw new ParkingException("Ticket ID cannot be empty");
        }
        
        int fee = parkingLot.unparkVehicle(ticketId);
        System.out.println("✓ Vehicle unparked successfully!");
        System.out.println("Total Fee: $" + fee);
    }
}
```

---

## Testing Recommendations

Add unit tests for:
```java
// ParkingSpotTest.java
- testSpotIdUniqueness()
- testMultipleFloorsSpotIds()
- testParkAndUnparkSpot()

// ParkingLotTest.java
- testParkMultipleVehicles()
- testUnparkNonExistentTicket()
- testSpotAllocationPriority()
- testFeesCalculation()
```

---

## Summary of Changes

| Issue | Fix | Priority |
|-------|-----|----------|
| Static spotId bug | Make it instance variable | 🔴 Critical |
| Class name typo | Rename to ParkingTicket | 🔴 Critical |
| Missing Vehicle class | Create Vehicle class | 🔴 Critical |
| Encapsulation | Use getters/setters | 🟡 High |
| Error handling | Add exceptions | 🟡 High |
| Resource leak | Use try-with-resources | 🟡 High |
| Hardcoded fees | FeeConfiguration class | 🟡 High |
| Singleton pattern | Add getInstance() | 🟠 Medium |
| Fee calculation | Clearer logic | 🟠 Medium |

