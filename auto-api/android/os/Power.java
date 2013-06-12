package android.os;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import java.io.IOException;
import android.os.ServiceManager;

public class Power {
    public static final int PARTIAL_WAKE_LOCK = 1;
    public static final int FULL_WAKE_LOCK = 2;
    public static final int BRIGHTNESS_OFF = 0;
    public static final int BRIGHTNESS_DIM = 20;
    public static final int BRIGHTNESS_ON = 255;
    public static final int BRIGHTNESS_LOW_BATTERY = 10;
    public static final int LOW_BATTERY_THRESHOLD = 10;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.834 -0400", hash_original_method = "5BE60834AE300DE523C7A57D7E78082D", hash_generated_method = "4731AEDC1B30E2DC7C730CE9E8E5DC99")
    @DSModeled(DSC.SAFE)
    private Power() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.835 -0400", hash_original_method = "08F3455B342604DDD7DC8A1B40292FF1", hash_generated_method = "1E472493760CAC094FB634BED2A5DE52")
    public static void acquireWakeLock(int lock, String id) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.835 -0400", hash_original_method = "3EE8D907078E8766BB09FAD9A2B469CB", hash_generated_method = "89D5F521B729675DD05B359D5A03EB4E")
    public static void releaseWakeLock(String id) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.835 -0400", hash_original_method = "B5612B883170D6651C3E816F8B62607B", hash_generated_method = "9E8DC496BCE5EF2B6BB4F4102E22CC55")
    public static int setScreenState(boolean on) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.835 -0400", hash_original_method = "FE506D68D146041D823150EB3B200AD9", hash_generated_method = "25AF38188C1FD277FAC7192577730C1F")
    public static int setLastUserActivityTimeout(long ms) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.835 -0400", hash_original_method = "C375783E9DBB501142C3707467AE2DD2", hash_generated_method = "B9FDCF47190D19474DB841DF2D38F7C2")
    @Deprecated
    public static void shutdown() {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.835 -0400", hash_original_method = "EC05D42FDC08A74CC1BA3E59CA3EB8E4", hash_generated_method = "DC383A933172936B91E544EE6A61437F")
    public static void reboot(String reason) throws IOException {
        rebootNative(reason);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.835 -0400", hash_original_method = "E4DDFC320DF2CDC99F328B3FAE841B59", hash_generated_method = "D39E034DAD10142638AB86B2AC367D62")
    private static void rebootNative(String reason) throws IOException {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
}


