
import java.lang.reflect.Array;
import java.util.Collections;

public class PIN
{
    HashMap<String, Locker> PINtoLocker;
    private static PIN instance;
    public PIN()
    {
        PINtoLocker = new HashMap<>(); 
    }
    public static PIN getInstance()
    {
        if(instance == null)
        {
            instance = new PIN();
        }
        return instance;
    }
    public String generatePIN(User user, Locker locker)
    {
        List<String> jumbledPin = Array.asList(user.getPhoneNumber().split(""));
        Collections.shuffle(jumbledPin);
        String pin = String.join("", jumbledPin);
        PINtoLocker.put(pin, locker);
        return pin;
    }
    public Locker getLocker(String pin)
    {
        if(!PINtoLocker.containsKey(pin)) return null;
        return Locker;
    }
    public boolean removePin(String pin)
    {
        if(!PINtoLocker.containsKey(pin)) return false;
        PINtoLocker.remove(pin);
        return true;
    }
}