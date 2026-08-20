package LLD.Amazon;

import java.util.ArrayList;
import java.util.List;
public class LockerManagers {
    List<Lockers> lockers = new ArrayList<>();
    PIN instance;
    static int lockerId;
    LockerManager()
    {
        instance = PIN.getInstance();
        lockerId = 1;
    }  
    void AddLocker(String lockerType)
    {
        Lockers locker = new Lockers(lockerId ++, lockerType);
        lockers.add(locker);
    }
    void removeLocker(int lockerId)
    {
        Lockers locker = lockers.get(lockerId - 1);
        lockers.remove(locker);
    }
    String bookLocker(String lockerType, User User)
    {
        for(Lockers locker : lockers)
        {
            if(locker.type == lockerType && locker.status == LockerStatus.AVAILABLE)
            {
                locker.status = LockerStatus.UNAVAILABLE;
                String pin = instance.generatePIN(User, locker);
                return pin;
            }
        }
        return null;
    }
    void unbookLocker(String pin)
    {
        Locker locker = instance.removePin(pin);
        locker.status = LockerStatus.AVAILABLE;
        openLockerDoor(locker);
    } 
    void openLockerDoor(Locker locker)
    {
        locker.isDoorOpen = true;
    }
    void openLockerDoor(String pin)
    {
        Lockers locker = instance.getLocker(pin);
        locker.isDoorOpen = true;
    }
}
