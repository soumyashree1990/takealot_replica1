package za.co.reverside.takealot_replica.Util;

import java.util.UUID;

public class KeyGenerator {
    public static long generateKey(){
        UUID uuidKey= UUID.randomUUID();
        long key = uuidKey.getMostSignificantBits();
        return key;
    }
}