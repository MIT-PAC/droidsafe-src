package android.os;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import com.android.internal.telephony.TelephonyProperties;

public class Build {
    public static String UNKNOWN = "unknown";
    public static String ID = getString("ro.build.id");
    public static String DISPLAY = getString("ro.build.display.id");
    public static String PRODUCT = getString("ro.product.name");
    public static String DEVICE = getString("ro.product.device");
    public static String BOARD = getString("ro.product.board");
    public static String CPU_ABI = getString("ro.product.cpu.abi");
    public static String CPU_ABI2 = getString("ro.product.cpu.abi2");
    public static String MANUFACTURER = getString("ro.product.manufacturer");
    public static String BRAND = getString("ro.product.brand");
    public static String MODEL = getString("ro.product.model");
    public static String BOOTLOADER = getString("ro.bootloader");
    @Deprecated public static String RADIO = getString(TelephonyProperties.PROPERTY_BASEBAND_VERSION);
    public static String HARDWARE = getString("ro.hardware");
    public static String SERIAL = getString("ro.serialno");
    public static String TYPE = getString("ro.build.type");
    public static String TAGS = getString("ro.build.tags");
    public static String FINGERPRINT = getString("ro.build.fingerprint");
    public static long TIME = getLong("ro.build.date.utc") * 1000;
    public static String USER = getString("ro.build.user");
    public static String HOST = getString("ro.build.host");
    public static boolean IS_DEBUGGABLE =
            SystemProperties.getInt("ro.debuggable", 0) == 1;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:01:59.362 -0400", hash_original_method = "3B8999FDFEE854B82721B15385523740", hash_generated_method = "6AA38C91E136D282F6E7B93D837E38E3")
    public static String getRadioVersion() {
        return SystemProperties.get(TelephonyProperties.PROPERTY_BASEBAND_VERSION, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:01:59.363 -0400", hash_original_method = "418D9C5925500F64D1F7A5BD4EFEEBDF", hash_generated_method = "5447853DC2CC16B9C3F64D805AE1C559")
    private static String getString(String property) {
        return SystemProperties.get(property, UNKNOWN);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:01:59.363 -0400", hash_original_method = "C6E00A05CF4577B1F2FE54583AF3AC48", hash_generated_method = "12919BF320CA15FB8D6B906889F09136")
    private static long getLong(String property) {
        try {
            return Long.parseLong(SystemProperties.get(property));
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    
    public static class VERSION {
        public static String INCREMENTAL = getString("ro.build.version.incremental");
        public static String RELEASE = getString("ro.build.version.release");
        @Deprecated public static String SDK = getString("ro.build.version.sdk");
        public static int SDK_INT = SystemProperties.getInt(
                "ro.build.version.sdk", 0);
        public static String CODENAME = getString("ro.build.version.codename");
        public static int RESOURCES_SDK_INT = SDK_INT
                + ("REL".equals(CODENAME) ? 0 : 1);
        
    }


    
    public static class VERSION_CODES {
        public static int CUR_DEVELOPMENT = 10000;
        public static int BASE = 1;
        public static int BASE_1_1 = 2;
        public static int CUPCAKE = 3;
        public static int DONUT = 4;
        public static int ECLAIR = 5;
        public static int ECLAIR_0_1 = 6;
        public static int ECLAIR_MR1 = 7;
        public static int FROYO = 8;
        public static int GINGERBREAD = 9;
        public static int GINGERBREAD_MR1 = 10;
        public static int HONEYCOMB = 11;
        public static int HONEYCOMB_MR1 = 12;
        public static int HONEYCOMB_MR2 = 13;
        public static int ICE_CREAM_SANDWICH = 14;
        public static int ICE_CREAM_SANDWICH_MR1 = 15;
        
    }


    
}


