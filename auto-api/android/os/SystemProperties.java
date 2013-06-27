package android.os;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class SystemProperties {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:27.372 -0400", hash_original_method = "2ADA160F039E0597E5E49685589340CB", hash_generated_method = "2ADA160F039E0597E5E49685589340CB")
    public SystemProperties ()
    {
        //Synthesized constructor
    }


        private static String native_get(String key) {
        //DSFIXME:  CODE0012: Native static method requires manual modeling
    }

    
        private static String native_get(String key, String def) {
        //DSFIXME:  CODE0012: Native static method requires manual modeling
    }

    
        private static int native_get_int(String key, int def) {
        return DSUtils.UNKNOWN_INT;
    }

    
        private static long native_get_long(String key, long def) {
        return DSUtils.UNKNOWN_LONG;
    }

    
        private static boolean native_get_boolean(String key, boolean def) {
        return DSUtils.UNKNOWN_BOOLEAN;
    }

    
        private static void native_set(String key, String def) {
    }

    
        public static String get(String key) {
        if (key.length() > PROP_NAME_MAX) {
            throw new IllegalArgumentException("key.length > " + PROP_NAME_MAX);
        }
        return native_get(key);
    }

    
        public static String get(String key, String def) {
        if (key.length() > PROP_NAME_MAX) {
            throw new IllegalArgumentException("key.length > " + PROP_NAME_MAX);
        }
        return native_get(key, def);
    }

    
        public static int getInt(String key, int def) {
        if (key.length() > PROP_NAME_MAX) {
            throw new IllegalArgumentException("key.length > " + PROP_NAME_MAX);
        }
        return native_get_int(key, def);
    }

    
        public static long getLong(String key, long def) {
        if (key.length() > PROP_NAME_MAX) {
            throw new IllegalArgumentException("key.length > " + PROP_NAME_MAX);
        }
        return native_get_long(key, def);
    }

    
        public static boolean getBoolean(String key, boolean def) {
        if (key.length() > PROP_NAME_MAX) {
            throw new IllegalArgumentException("key.length > " + PROP_NAME_MAX);
        }
        return native_get_boolean(key, def);
    }

    
        public static void set(String key, String val) {
        if (key.length() > PROP_NAME_MAX) {
            throw new IllegalArgumentException("key.length > " + PROP_NAME_MAX);
        }
        if (val != null && val.length() > PROP_VALUE_MAX) {
            throw new IllegalArgumentException("val.length > " +
                PROP_VALUE_MAX);
        }
        native_set(key, val);
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:27.389 -0400", hash_original_field = "421F11BB25DB9C1D0DC4AB6BF3C20D97", hash_generated_field = "780DCAA353568BD378E28553216C8395")

    public static final int PROP_NAME_MAX = 31;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:27.389 -0400", hash_original_field = "AD073E405F956424F3753E80AEBE91DB", hash_generated_field = "2AB02350084E9F1FB1771551A1B2E17D")

    public static final int PROP_VALUE_MAX = 91;
}

