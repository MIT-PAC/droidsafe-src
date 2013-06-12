package org.apache.harmony.kernel.vm;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;


public final class StringUtils {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.563 -0400", hash_original_method = "9E881C2879A613DB548C02DA2AC20129", hash_generated_method = "86870A444310F6AABD800048DA519F59")
    @DSModeled(DSC.SAFE)
    private StringUtils() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.563 -0400", hash_original_method = "888FC51886C6044A7D8C9FF6C24BD9F3", hash_generated_method = "2BD935C62418A5B02B2F993978154287")
    public static String combineStrings(Object[] list) {
        int listLength = list.length;
        switch (listLength) {
            case 0: {
                return "";
            }
            case 1: {
                return (String) list[0];
            }
        }
        int strLength = 0;
        for (int i = 0; i < listLength; i++) {
            strLength += ((String) list[i]).length();
        }
        StringBuilder sb = new StringBuilder(strLength);
        for (int i = 0; i < listLength; i++) {
            sb.append(list[i]);
        }
        return sb.toString();
    }

    
}


