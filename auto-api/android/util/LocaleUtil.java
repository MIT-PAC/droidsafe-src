package android.util;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import java.util.Locale;
import libcore.icu.ICU;

public class LocaleUtil {
    public static final int TEXT_LAYOUT_DIRECTION_LTR_DO_NOT_USE = 0;
    public static final int TEXT_LAYOUT_DIRECTION_RTL_DO_NOT_USE = 1;
    private static final char UNDERSCORE_CHAR = '_';
    private static String ARAB_SCRIPT_SUBTAG = "Arab";
    private static String HEBR_SCRIPT_SUBTAG = "Hebr";
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.610 -0400", hash_original_method = "DB2CFC1123D815AD16F73168E1C2B755", hash_generated_method = "FF0630E9374371A3A86202B441F971F0")
    @DSModeled(DSC.SAFE)
    private LocaleUtil() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.610 -0400", hash_original_method = "C2C8A8579F7B4A3F5AD96041BBF267B5", hash_generated_method = "E53161CF782074AB58601A0AC6165FE4")
    public static int getLayoutDirectionFromLocale(Locale locale) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        if (locale != null && !locale.equals(Locale.ROOT)) {
            final String scriptSubtag = ICU.getScript(ICU.addLikelySubtags(locale.toString()));
            if (scriptSubtag == null) return getLayoutDirectionFromFirstChar(locale);
            if (scriptSubtag.equalsIgnoreCase(ARAB_SCRIPT_SUBTAG) ||
                    scriptSubtag.equalsIgnoreCase(HEBR_SCRIPT_SUBTAG)) {
                return TEXT_LAYOUT_DIRECTION_RTL_DO_NOT_USE;
            }
        }
        return TEXT_LAYOUT_DIRECTION_LTR_DO_NOT_USE;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.610 -0400", hash_original_method = "4B0B9488116BB6BD2FA538E03385F4D9", hash_generated_method = "C266638A7408BEA3945B46E15D7B6D36")
    private static int getLayoutDirectionFromFirstChar(Locale locale) {
        switch(Character.getDirectionality(locale.getDisplayName(locale).charAt(0))) {
            case Character.DIRECTIONALITY_RIGHT_TO_LEFT:
            case Character.DIRECTIONALITY_RIGHT_TO_LEFT_ARABIC:
                return TEXT_LAYOUT_DIRECTION_RTL_DO_NOT_USE;
            case Character.DIRECTIONALITY_LEFT_TO_RIGHT:
            default:
                return TEXT_LAYOUT_DIRECTION_LTR_DO_NOT_USE;
        }
    }

    
}


