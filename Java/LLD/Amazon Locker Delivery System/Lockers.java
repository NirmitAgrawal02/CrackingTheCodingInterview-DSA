package LLD.Amazon;

public class Lockers {
    int id;
    LockerType type;
    LockerStatus status;
    boolean isDoorOpen;

    Lockers(int id, String type)
    {
        this.id = id;
        this.status = LockerStatus.AVAILABLE;
        isDoorOpen = false;
        if(type == "SMALL")
        {
            this.type = LockerType.SMALL;
        }
        else if(type == "MEDIUM")
        {
            this.type = LockerType.MEDIUM;
        }
        else
        {
            this.type = LockerType.BIG;
        }
    }
    boolean isAvailable()
    {
        return this.status == LockerStatus.AVAILABLE;
    }
    LockerType getType()
    {
        return this.type;
    }

    boolean getisDoorOpen()
    {
        return this.isDoorOpen;
    }
    boolean getId()
    {
        return this.id;
    }
    void openDoor()
    {
        this.isDoorOpen = true;
    }
    void closeDoor()
    {
        this.isDoorOpen = false;
    }
    void setAvailable()
    {
        this.status = LockerStatus.AVAILABLE;
    }
    void setUnavailable()
    {
        this.status = LockerStatus.UNAVAILABLE;
    }
}
