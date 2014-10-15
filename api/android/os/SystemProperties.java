package android.os;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

import droidsafe.helpers.DSUtils;

public class SystemProperties {
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static String native_get(String key) {
		return new String();
	}
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static String native_get(String key, String def) {
		return new String();
	}
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static int native_get_int(String key, int def) {
        return (key.getTaintInt() + def);
	}
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static long native_get_long(String key, long def) {
        return (key.getTaintInt() + def);
	}
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static boolean native_get_boolean(String key, boolean def) {
        return toTaintBoolean(key.getTaintInt() + ((def) ? 1 : 0));
	}
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static void native_set(String key, String def) {
	}

    /**
     * Get the value for the given key.
     * @return an empty string if the key isn't found
     * @throws IllegalArgumentException if the key exceeds 32 characters
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSSource({DSSourceKind.SYSTEM_PROPERTY})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:26.300 -0500", hash_original_method = "B997DE3DE9BA95C34347E06C068D82A8", hash_generated_method = "C60A20FE888A2DD766165E1F2FF70ECA")
    
public static String get(String key) {
        if (key.length() > PROP_NAME_MAX) {
            throw new IllegalArgumentException("key.length > " + PROP_NAME_MAX);
        }
        return native_get(key);
    }

    /**
     * Get the value for the given key.
     * @return if the key isn't found, return def if it isn't null, or an empty string otherwise
     * @throws IllegalArgumentException if the key exceeds 32 characters
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSSource({DSSourceKind.SYSTEM_PROPERTY})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:26.302 -0500", hash_original_method = "7927D7DDD6D83599D90013F78BBE1138", hash_generated_method = "F021805CC906B7BFA941BB74022F57FD")
    
public static String get(String key, String def) {
        if (key.length() > PROP_NAME_MAX) {
            throw new IllegalArgumentException("key.length > " + PROP_NAME_MAX);
        }
        return native_get(key, def);
    }

    /**
     * Get the value for the given key, and return as an integer.
     * @param key the key to lookup
     * @param def a default value to return
     * @return the key parsed as an integer, or def if the key isn't found or
     *         cannot be parsed
     * @throws IllegalArgumentException if the key exceeds 32 characters
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSSource({DSSourceKind.SYSTEM_PROPERTY})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:26.304 -0500", hash_original_method = "2B579EE5EA12E18DA0DEBF243BDA40A5", hash_generated_method = "6B4E26320E146BB78D7DC3DA40891C3B")
    
public static int getInt(String key, int def) {
        if (key.length() > PROP_NAME_MAX) {
            throw new IllegalArgumentException("key.length > " + PROP_NAME_MAX);
        }
        return native_get_int(key, def);
    }

    /**
     * Get the value for the given key, and return as a long.
     * @param key the key to lookup
     * @param def a default value to return
     * @return the key parsed as a long, or def if the key isn't found or
     *         cannot be parsed
     * @throws IllegalArgumentException if the key exceeds 32 characters
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSSource({DSSourceKind.SYSTEM_PROPERTY})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:26.307 -0500", hash_original_method = "46A93D3E877DAA208F2DC21A57D65544", hash_generated_method = "B5CA8A46D3DC760DA720A2F35E7CDF13")
    
public static long getLong(String key, long def) {
        if (key.length() > PROP_NAME_MAX) {
            throw new IllegalArgumentException("key.length > " + PROP_NAME_MAX);
        }
        return native_get_long(key, def);
    }

    /**
     * Get the value for the given key, returned as a boolean.
     * Values 'n', 'no', '0', 'false' or 'off' are considered false.
     * Values 'y', 'yes', '1', 'true' or 'on' are considered true.
     * (case sensitive).
     * If the key does not exist, or has any other value, then the default
     * result is returned.
     * @param key the key to lookup
     * @param def a default value to return
     * @return the key parsed as a boolean, or def if the key isn't found or is
     *         not able to be parsed as a boolean.
     * @throws IllegalArgumentException if the key exceeds 32 characters
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSSource({DSSourceKind.SYSTEM_PROPERTY})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:26.310 -0500", hash_original_method = "8BC830300989F14679E6D713EBBD8F47", hash_generated_method = "E0463A9B08C0CDDE713846357EFB97AC")
    
public static boolean getBoolean(String key, boolean def) {
        if (key.length() > PROP_NAME_MAX) {
            throw new IllegalArgumentException("key.length > " + PROP_NAME_MAX);
        }
        return native_get_boolean(key, def);
    }

    /**
     * Set the value for the given key.
     * @throws IllegalArgumentException if the key exceeds 32 characters
     * @throws IllegalArgumentException if the value exceeds 92 characters
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:26.312 -0500", hash_original_method = "B68AAFB393238F23874EB5D82F3E0580", hash_generated_method = "F2AB2276EAAE5D97F306539BF85F02D3")
    
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
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:26.273 -0500", hash_original_field = "F9AA98F8573EEA111580F486211C5324", hash_generated_field = "780DCAA353568BD378E28553216C8395")

    public static final int PROP_NAME_MAX = 31;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:26.275 -0500", hash_original_field = "9A85A999D31B21D59D83603DF5802072", hash_generated_field = "2AB02350084E9F1FB1771551A1B2E17D")

    public static final int PROP_VALUE_MAX = 91;
    
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.812 -0400", hash_original_method = "2ADA160F039E0597E5E49685589340CB", hash_generated_method = "2ADA160F039E0597E5E49685589340CB")
    public SystemProperties ()
    {
        //Synthesized constructor
    }
}

