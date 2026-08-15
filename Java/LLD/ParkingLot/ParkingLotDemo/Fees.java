package LLD.ParkingLot.ParkingLotDemo;

import java.time.LocalDateTime;

public class Fees {
        VehicleType[] vehicleType;
        int[] fee;
        int totalFees;

        public Fees() {
            this.vehicleType = new VehicleType[]{VehicleType.CAR, VehicleType.BIKE, VehicleType.TRUCK};
            this.fee = new int[]{20, 10, 30};
        }

        public void calculateFee(LocalDateTime entryTime, VehicleType vehicleType ) {
            int hours = (int) java.time.Duration.between(entryTime, LocalDateTime.now()).toHours();
            int feeIndex = java.util.Arrays.asList(this.vehicleType).indexOf(vehicleType);
            this.totalFees = this.fee[feeIndex] + Math.max(hours - 1, 0) * this.fee[feeIndex];
        }

        public int getTotalFees() {
            return this.totalFees;
        }
    }
