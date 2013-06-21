package android.os;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import com.android.internal.telephony.TelephonyProperties;

public class Build {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.357 -0400", hash_original_method = "4807E0622680BD4FD8FB1C8B31431053", hash_generated_method = "4807E0622680BD4FD8FB1C8B31431053")
        public Build ()
    {
    }


        public static String getRadioVersion() {
        return SystemProperties.get(TelephonyProperties.PROPERTY_BASEBAND_VERSION, null);
    }

    
        private static String getString(String property) {
        return SystemProperties.get(property, UNKNOWN);
    }

    
        private static long getLong(String property) {
        try {
            return Long.parseLong(SystemProperties.get(property));
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    
    public static class VERSION {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.359 -0400", hash_original_method = "2D41677CFE28D1731B37A1BD29A27369", hash_generated_method = "2D41677CFE28D1731B37A1BD29A27369")
                public VERSION ()
        {
        }


        public static final String INCREMENTAL = getString("ro.build.version.incremental");
        public static final String RELEASE = getString("ro.build.version.release");
        @Deprecated public static final String SDK = getString("ro.build.version.sdk");
        public static final int SDK_INT = SystemProperties.getInt(
                "ro.build.version.sdk", 0);
        public static final String CODENAME = getString("ro.build.version.codename");
        public static final int RESOURCES_SDK_INT = SDK_INT
                + ("REL".equals(CODENAME) ? 0 : 1);
    }


    
    public static class VERSION_CODES {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.359 -0400", hash_original_method = "01057732E34569F8781D6B1EF6614F35", hash_generated_method = "01057732E34569F8781D6B1EF6614F35")
                public VERSION_CODES ()
        {
        }


        public static final int CUR_DEVELOPMENT = 10000;
        public static final int BASE = 1;
        public static final int BASE_1_1 = 2;
        public static final int CUPCAKE = 3;
        public static final int DONUT = 4;
        public static final int ECLAIR = 5;
        public static final int ECLAIR_0_1 = 6;
        public static final int ECLAIR_MR1 = 7;
        public static final int FROYO = 8;
        public static final int GINGERBREAD = 9;
        public static final int GINGERBREAD_MR1 = 10;
        public static final int HONEYCOMB = 11;
        public static final int HONEYCOMB_MR1 = 12;
        public static final int HONEYCOMB_MR2 = 13;
        public static final int ICE_CREAM_SANDWICH = 14;
        public static final int ICE_CREAM_SANDWICH_MR1 = 15;
    }


    
    public static final String UNKNOWN = "unknown";
    public static final String ID = getString("ro.build.id");
    public static final String DISPLAY = getString("ro.build.display.id");
    public static final String PRODUCT = getString("ro.product.name");
    public static final String DEVICE = getString("ro.product.device");
    public static final String BOARD = getString("ro.product.board");
    public static final String CPU_ABI = getString("ro.product.cpu.abi");
    public static final String CPU_ABI2 = getString("ro.product.cpu.abi2");
    public static final String MANUFACTURER = getString("ro.product.manufacturer");
    public static final String BRAND = getString("ro.product.brand");
    public static final String MODEL = getString("ro.product.model");
    public static final String BOOTLOADER = getString("ro.bootloader");
    @Deprecated public static final String RADIO = getString(TelephonyProperties.PROPERTY_BASEBAND_VERSION);
    public static final String HARDWARE = getString("ro.hardware");
    public static final String SERIAL = getString("ro.serialno");
    public static final String TYPE = getString("ro.build.type");
    public static final String TAGS = getString("ro.build.tags");
    public static final String FINGERPRINT = getString("ro.build.fingerprint");
    public static final long TIME = getLong("ro.build.date.utc") * 1000;
    public static final String USER = getString("ro.build.user");
    public static final String HOST = getString("ro.build.host");
    public static final boolean IS_DEBUGGABLE =
            SystemProperties.getInt("ro.debuggable", 0) == 1;
}

