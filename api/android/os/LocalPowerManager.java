package android.os;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
public interface LocalPowerManager {
    
    
    public static final int OTHER_EVENT = 0;
    public static final int BUTTON_EVENT = 1;
    public static final int TOUCH_EVENT = 2;

    public static final int POKE_LOCK_IGNORE_TOUCH_EVENTS = 0x1;

    public static final int POKE_LOCK_SHORT_TIMEOUT = 0x2;
    public static final int POKE_LOCK_MEDIUM_TIMEOUT = 0x4;
    public static final int POKE_LOCK_TIMEOUT_MASK = 0x6;

    void goToSleep(long time);
    
    
    void setKeyboardVisibility(boolean visible);

    
    void enableUserActivity(boolean enabled);

    
    void userActivity(long time, boolean noChangeLights, int eventType);

    boolean isScreenOn();

    void setScreenBrightnessOverride(int brightness);
    void setButtonBrightnessOverride(int brightness);
}
