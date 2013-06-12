package android.os;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class BatteryManager {
    public static String EXTRA_STATUS = "status";
    public static String EXTRA_HEALTH = "health";
    public static String EXTRA_PRESENT = "present";
    public static String EXTRA_LEVEL = "level";
    public static String EXTRA_SCALE = "scale";
    public static String EXTRA_ICON_SMALL = "icon-small";
    public static String EXTRA_PLUGGED = "plugged";
    public static String EXTRA_VOLTAGE = "voltage";
    public static String EXTRA_TEMPERATURE = "temperature";
    public static String EXTRA_TECHNOLOGY = "technology";
    public static String EXTRA_INVALID_CHARGER = "invalid_charger";
    public static int BATTERY_STATUS_UNKNOWN = 1;
    public static int BATTERY_STATUS_CHARGING = 2;
    public static int BATTERY_STATUS_DISCHARGING = 3;
    public static int BATTERY_STATUS_NOT_CHARGING = 4;
    public static int BATTERY_STATUS_FULL = 5;
    public static int BATTERY_HEALTH_UNKNOWN = 1;
    public static int BATTERY_HEALTH_GOOD = 2;
    public static int BATTERY_HEALTH_OVERHEAT = 3;
    public static int BATTERY_HEALTH_DEAD = 4;
    public static int BATTERY_HEALTH_OVER_VOLTAGE = 5;
    public static int BATTERY_HEALTH_UNSPECIFIED_FAILURE = 6;
    public static int BATTERY_HEALTH_COLD = 7;
    public static int BATTERY_PLUGGED_AC = 1;
    public static int BATTERY_PLUGGED_USB = 2;
    
}


