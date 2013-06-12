package android.os;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;


public class SystemProperties {
    public static final int PROP_NAME_MAX = 31;
    public static final int PROP_VALUE_MAX = 91;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.031 -0400", hash_original_method = "CA833F49C69B424D4C08E9D7ED5D6EDB", hash_generated_method = "F1FBF8FABA6229C337FF32F89D7EDB33")
    private static String native_get(String key) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.032 -0400", hash_original_method = "532AC1F914A1AFEA8B3AF8A096D41B54", hash_generated_method = "0DF7E1F64CD4AF251FD9A255CA21C49D")
    private static String native_get(String key, String def) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.032 -0400", hash_original_method = "45661F07D83FA6892AED2E53C14D89CE", hash_generated_method = "369699EB7E4E26F05BC90D807B48C0B2")
    private static int native_get_int(String key, int def) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.032 -0400", hash_original_method = "6BA26D6976BF1188ADAD7BF024944A16", hash_generated_method = "200EC3217CC6E073305AA9C2331FD5AF")
    private static long native_get_long(String key, long def) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.032 -0400", hash_original_method = "B4BA9C205AEF8635D7738C135A3065FB", hash_generated_method = "A7214D95E255C1055E461F514626B1C1")
    private static boolean native_get_boolean(String key, boolean def) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.032 -0400", hash_original_method = "DBADE9D98518DB1F5A99F8ACE29C5B53", hash_generated_method = "2D62728416D3B3501E959F890CA73E11")
    private static void native_set(String key, String def) {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.032 -0400", hash_original_method = "B997DE3DE9BA95C34347E06C068D82A8", hash_generated_method = "C60A20FE888A2DD766165E1F2FF70ECA")
    public static String get(String key) {
        if (key.length() > PROP_NAME_MAX) {
            throw new IllegalArgumentException("key.length > " + PROP_NAME_MAX);
        }
        return native_get(key);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.032 -0400", hash_original_method = "7927D7DDD6D83599D90013F78BBE1138", hash_generated_method = "F021805CC906B7BFA941BB74022F57FD")
    public static String get(String key, String def) {
        if (key.length() > PROP_NAME_MAX) {
            throw new IllegalArgumentException("key.length > " + PROP_NAME_MAX);
        }
        return native_get(key, def);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.032 -0400", hash_original_method = "2B579EE5EA12E18DA0DEBF243BDA40A5", hash_generated_method = "6B4E26320E146BB78D7DC3DA40891C3B")
    public static int getInt(String key, int def) {
        if (key.length() > PROP_NAME_MAX) {
            throw new IllegalArgumentException("key.length > " + PROP_NAME_MAX);
        }
        return native_get_int(key, def);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.032 -0400", hash_original_method = "46A93D3E877DAA208F2DC21A57D65544", hash_generated_method = "B5CA8A46D3DC760DA720A2F35E7CDF13")
    public static long getLong(String key, long def) {
        if (key.length() > PROP_NAME_MAX) {
            throw new IllegalArgumentException("key.length > " + PROP_NAME_MAX);
        }
        return native_get_long(key, def);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.032 -0400", hash_original_method = "8BC830300989F14679E6D713EBBD8F47", hash_generated_method = "E0463A9B08C0CDDE713846357EFB97AC")
    public static boolean getBoolean(String key, boolean def) {
        if (key.length() > PROP_NAME_MAX) {
            throw new IllegalArgumentException("key.length > " + PROP_NAME_MAX);
        }
        return native_get_boolean(key, def);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.032 -0400", hash_original_method = "B68AAFB393238F23874EB5D82F3E0580", hash_generated_method = "F2AB2276EAAE5D97F306539BF85F02D3")
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

    
}


