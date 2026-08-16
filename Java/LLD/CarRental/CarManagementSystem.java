package LLD.CarRental;

import java.time.Instant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CarManagementSystem {
    List<Car> carList;
    HashMap<String, Car> cars;
    List<Booking> bookingList;
    HashMap<Integer, Car> bookings;
    static int bookingId;
    private static CarManagementSystem  instance = new CarManagementSystem();
    
    CarManagementSystem()
    {
        carList = new ArrayList<>();
        cars = new HashMap<>();
        bookingList = new ArrayList<>();
        bookings = new HashMap<>();
        bookingId = 1;
    }
    public static CarManagementSystem getInstance()
    {
        return instance;
    }
    public void addCar(String carRegistrationNumber, String model, String color, double carFees)
    {
        if(cars.containsKey(carRegistrationNumber))
        {
            Car car = cars.get(carRegistrationNumber);
            car.addCar();
            return;
        }
        Car car = new Car(carRegistrationNumber, model, color, carFees);
        cars.put(carRegistrationNumber, car);
        carList.add(car);
    }
    public boolean isCarAvailable(String carRegisterationNumber, Instant startDateTime, Instant endDateTime)
    {
        Car car = cars.get(carRegisterationNumber);
        return car.getAvailability(startDateTime, endDateTime);
    }
     public boolean addBooking(String carRegisterationNumber, String name, Instant startDateTime, Instant endDateTime)
    {
        if(!isCarAvailable(carRegisterationNumber, startDateTime, endDateTime))
        {
            return false;
        }
        Car car = cars.get(carRegisterationNumber);
        Booking booking = car.addBooking(bookingId++, name, startDateTime, endDateTime);
        bookings.put(booking.bookingId,car);
        bookingList.add(booking);
        double fees = calculatefees(booking, car);
        booking.bookingFees = fees;
        return true;
    }
    public double calculatefees(Booking booking,Car car)
    {
        long duration = booking.endTime.toEpochMilli() - booking.startTime.toEpochMilli();
        long durationInHours = duration / (1000 * 60 * 60);
        double fees = durationInHours * car.carFees;
        return fees;
    }

    public void cancelBooking(int bookingId)
    {
        Booking cancelBooking = null;
        Car car = bookings.get(bookingId);
        boolean bookingCancelled = car.cancelBooking(bookingId);
        if(bookingCancelled)
        {
            bookings.remove(bookingId);
        for(Booking booking : bookingList)
        {
            if(booking.getBookingId() == bookingId)
            {
                cancelBooking = booking;
                break;
            }
        }
        bookingList.remove(cancelBooking);
    }
    }

    public void showBookings()
    {
        for(Booking booking : bookingList)
        {
            System.out.println(booking.bookingId + " " + booking.carRegisterationNumber + " " + booking.username + " " + booking.startTime + " " + booking.endTime);
        }
    }

    public void removeCar(String carRegisterationNumber)
    {
        Car car = cars.get(carRegisterationNumber);
        car.removeCar();
        carList.remove(car);
    }

    public void showCar(String model, String color, Instant startDateTime, Instant endDateTime)
    {
       for(Car car : carList)
       {
           if(car.isAvailable && car.model.equals(model) && car.color.equals(color))
           {
               if(car.getAvailability(startDateTime, endDateTime))
               {
                   System.out.println(car.registrationNumber + " " + car.model + " " + car.color);
               }
           }
       }
    }
}
