package android.os;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.IOException;
import android.os.ServiceManager;

public class Power {
    public static int PARTIAL_WAKE_LOCK = 1;
    public static int FULL_WAKE_LOCK = 2;
    public static int BRIGHTNESS_OFF = 0;
    public static int BRIGHTNESS_DIM = 20;
    public static int BRIGHTNESS_ON = 255;
    public static int BRIGHTNESS_LOW_BATTERY = 10;
    public static int LOW_BATTERY_THRESHOLD = 10;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:02:00.660 -0400", hash_original_method = "5BE60834AE300DE523C7A57D7E78082D", hash_generated_method = "4731AEDC1B30E2DC7C730CE9E8E5DC99")
    @DSModeled(DSC.SAFE)
    private Power() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:02:00.660 -0400", hash_original_method = "08F3455B342604DDD7DC8A1B40292FF1", hash_generated_method = "D016B94D833E03C82ECDEF0DED6E929E")
    public static void acquireWakeLock(int lock, String id) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:02:00.661 -0400", hash_original_method = "3EE8D907078E8766BB09FAD9A2B469CB", hash_generated_method = "231BBA72C60C036E95D05DEC84B9D837")
    public static void releaseWakeLock(String id) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:02:00.661 -0400", hash_original_method = "B5612B883170D6651C3E816F8B62607B", hash_generated_method = "922F304542A96609F37B2221D47857F3")
    public static int setScreenState(boolean on) {
        return DSUtils.UNKNOWN_INT;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:02:00.661 -0400", hash_original_method = "FE506D68D146041D823150EB3B200AD9", hash_generated_method = "52451D76441C7538D723B6AB1BE676C5")
    public static int setLastUserActivityTimeout(long ms) {
        return DSUtils.UNKNOWN_INT;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:02:00.661 -0400", hash_original_method = "C375783E9DBB501142C3707467AE2DD2", hash_generated_method = "35CE3C54E6BE67B13D4D3F2B0A84A0A2")
    @Deprecated
    public static void shutdown() {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:02:00.662 -0400", hash_original_method = "EC05D42FDC08A74CC1BA3E59CA3EB8E4", hash_generated_method = "DC383A933172936B91E544EE6A61437F")
    public static void reboot(String reason) throws IOException {
        rebootNative(reason);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:02:00.662 -0400", hash_original_method = "E4DDFC320DF2CDC99F328B3FAE841B59", hash_generated_method = "4440D7E8BCED3F210F3C0017B92F9482")
    private static void rebootNative(String reason) throws IOException {
    }

    
}


