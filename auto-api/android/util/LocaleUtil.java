package android.util;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.util.Locale;
import libcore.icu.ICU;

public class LocaleUtil {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.214 -0400", hash_original_method = "DB2CFC1123D815AD16F73168E1C2B755", hash_generated_method = "F9680582E9F3FF3D5F3D7BEF7775E7F5")
    @DSModeled(DSC.SAFE)
    private LocaleUtil() {
        // ---------- Original Method ----------
    }

    
        public static int getLayoutDirectionFromLocale(Locale locale) {
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

    
    public static final int TEXT_LAYOUT_DIRECTION_LTR_DO_NOT_USE = 0;
    public static final int TEXT_LAYOUT_DIRECTION_RTL_DO_NOT_USE = 1;
    private static final char UNDERSCORE_CHAR = '_';
    private static String ARAB_SCRIPT_SUBTAG = "Arab";
    private static String HEBR_SCRIPT_SUBTAG = "Hebr";
}

