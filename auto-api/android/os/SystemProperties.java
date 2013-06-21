package android.os;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class SystemProperties {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.385 -0400", hash_original_method = "973B75DDC8E858143851BE20F8D2B3ED", hash_generated_method = "973B75DDC8E858143851BE20F8D2B3ED")
        public SystemProperties ()
    {
    }


        private static String native_get(String key) {
        return DSUtils.UNKNOWN_STRING;
    }

    
        private static String native_get(String key, String def) {
        return DSUtils.UNKNOWN_STRING;
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

    
    public static final int PROP_NAME_MAX = 31;
    public static final int PROP_VALUE_MAX = 91;
}

