package LLD.CarRental;

import java.time.Instant;

public class Booking {
    int bookingId;
    String carRegisterationNumber;
    String username;
    Instant startTime;
    Instant endTime;
    double bookingFees;

    public Booking(int bookingId, String carRegisterationNumber, String username, Instant startTime, Instant endTime, double bookingFees) {
        this.bookingId = bookingId;
        this.carRegisterationNumber = carRegisterationNumber;
        this.username = username;
        this.startTime = startTime;
        this.endTime = endTime;
        this.bookingFees = bookingFees;
    }

    public int getBookingId() {
        return this.bookingId;
    }

    public String getCarRegisterationNumber() {
        return this.carRegisterationNumber;
    }


    public String getUsername() {
        return this.username;
    }
    public Instant getStartTime() {
        return this.startTime;
    }
    public Instant getEndTime() {
        return this.endTime;
    }
    public double getBookingFees() {
        return this.bookingFees;
    }
}
