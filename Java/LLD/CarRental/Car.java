package LLD.CarRental;

import java.time.Instant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Car {
    public String registrationNumber;
    public String model;
    public String color;
    public boolean isAvailable;  
    List<Booking> bookings = new ArrayList<>();
    HashMap<Integer, Booking> bookingsMap = new HashMap<>();
    public double carFees;

    Car(String registrationNumber, String model, String color, double carFees) {
        this.registrationNumber = registrationNumber;
        this.model = model;
        this.color = color;
        this.carFees = carFees;
        this.isAvailable = true;     
    }
    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }
    public void setModel(String model) {
        this.model = model;
    }
    public void setColor(String color) {
        this.color = color;
    }
    public void setCarFees(double carFees) {
        this.carFees = carFees;
    }
    public String getRegistrationNumber() {
        return registrationNumber;
    }
    public String getModel() {
        return model;
    }
    public String getColor() {
        return color;
    }
    public boolean getAvailability(Instant startDateTime, Instant endDateTime) {
        for(Booking booking : bookings)
        {
            if((booking.getEndTime().isBefore(startDateTime)) || (booking.getStartTime().isAfter(endDateTime)))
            {
                continue;
                }
            else
            {
                return false;
            }
        }
        return true;
    }

    public Booking addBooking(int bookingId, String name, Instant startDateTime, Instant endDateTime) {
        Booking booking = new Booking(bookingId,registrationNumber, name, startDateTime, endDateTime, carFees);
        bookings.add(booking);
        bookingsMap.put(bookingId, booking);
        return booking;
    }
    public double getCarFees() {
        return carFees;
    }

    public boolean cancelBooking(int bookingID)
    {
        Booking booking = bookingsMap.get(bookingID);
        if(booking.getStartTime().isBefore(Instant.now()))
        {    
            bookings.remove(booking);
            return true;
        }
        return false;
    }
    public void removeCar()
    {
        this.isAvailable = false;
    }
    public void addCar()
    {
        this.isAvailable = true;
    }
}
