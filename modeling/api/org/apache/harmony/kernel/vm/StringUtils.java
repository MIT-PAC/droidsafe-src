package org.apache.harmony.kernel.vm;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public final class StringUtils {

    /**
     * Combine a list of strings in an <code>Object[]</code> into a single
     * string.
     *
     * @param list non-null; the strings to combine
     * @return non-null; the combined form
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:19.365 -0500", hash_original_method = "888FC51886C6044A7D8C9FF6C24BD9F3", hash_generated_method = "2BD935C62418A5B02B2F993978154287")
    
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
    /**
     * This class is uninstantiable.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:19.362 -0500", hash_original_method = "9E881C2879A613DB548C02DA2AC20129", hash_generated_method = "445D9BE0B3E6A16F60D0C20F91B79742")
    
private StringUtils() {
        // This space intentionally left blank.
    }
    
}

