package android.util;

// Droidsafe Imports
import droidsafe.annotations.*;
import java.util.Locale;

import libcore.icu.ICU;



public class LocaleUtil {
    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:40.739 -0400", hash_original_method = "DB2CFC1123D815AD16F73168E1C2B755", hash_generated_method = "F9680582E9F3FF3D5F3D7BEF7775E7F5")
    private  LocaleUtil() {
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.BAN)
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

    
    @DSModeled(DSC.BAN)
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:40.740 -0400", hash_original_field = "2094811D2B2E86353F45C466D1C688F6", hash_generated_field = "7744385ACF1B2FC567A3D2318DC8A9A1")

    public static final int TEXT_LAYOUT_DIRECTION_LTR_DO_NOT_USE = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:40.740 -0400", hash_original_field = "AC16530D7EE795CC3489623038A1878E", hash_generated_field = "50E594E2F225A9A852068F9733429110")

    public static final int TEXT_LAYOUT_DIRECTION_RTL_DO_NOT_USE = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:40.740 -0400", hash_original_field = "C4EE46BA3926712F62A5F87BB2AC057E", hash_generated_field = "BDD6D5F89EF25696F38BF4CDA303B03E")

    private static final char UNDERSCORE_CHAR = '_';
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:40.740 -0400", hash_original_field = "363AD1361821E0781815A69F706BF327", hash_generated_field = "E671077DBE84DEFDA400ACC06557696C")

    private static String ARAB_SCRIPT_SUBTAG = "Arab";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:40.740 -0400", hash_original_field = "E2452177015CF26111D058CAD2718900", hash_generated_field = "585680D6F417A4378E85E18D90332D17")

    private static String HEBR_SCRIPT_SUBTAG = "Hebr";
}

