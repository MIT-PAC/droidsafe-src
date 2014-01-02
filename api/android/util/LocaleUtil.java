package android.util;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.util.Locale;

import libcore.icu.ICU;



public class LocaleUtil {

    /**
     * Return the layout direction for a given Locale
     *
     * @param locale the Locale for which we want the layout direction. Can be null.
     * @return the layout direction. This may be one of:
     * {@link #TEXT_LAYOUT_DIRECTION_LTR_DO_NOT_USE} or
     * {@link #TEXT_LAYOUT_DIRECTION_RTL_DO_NOT_USE}.
     *
     * Be careful: this code will need to be changed when vertical scripts will be supported
     *
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:24.775 -0500", hash_original_method = "C2C8A8579F7B4A3F5AD96041BBF267B5", hash_generated_method = "812C133331A029EA67C0546D77E1BCB4")
    
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

    /**
     * Fallback algorithm to detect the locale direction. Rely on the fist char of the
     * localized locale name. This will not work if the localized locale name is in English
     * (this is the case for ICU 4.4 and "Urdu" script)
     *
     * @param locale
     * @return the layout direction. This may be one of:
     * {@link #TEXT_LAYOUT_DIRECTION_LTR_DO_NOT_USE} or
     * {@link #TEXT_LAYOUT_DIRECTION_RTL_DO_NOT_USE}.
     *
     * Be careful: this code will need to be changed when vertical scripts will be supported
     *
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:24.778 -0500", hash_original_method = "4B0B9488116BB6BD2FA538E03385F4D9", hash_generated_method = "C266638A7408BEA3945B46E15D7B6D36")
    
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
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:24.763 -0500", hash_original_field = "1C71915754D41127082991672DBBCBFB", hash_generated_field = "7744385ACF1B2FC567A3D2318DC8A9A1")

    public static final int TEXT_LAYOUT_DIRECTION_LTR_DO_NOT_USE = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:24.766 -0500", hash_original_field = "B6E5ACA43F4DBE2928F8966DD4C94189", hash_generated_field = "50E594E2F225A9A852068F9733429110")

    public static final int TEXT_LAYOUT_DIRECTION_RTL_DO_NOT_USE = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:24.768 -0500", hash_original_field = "2F88A7A720FE3AC9D2D577402FE96D1B", hash_generated_field = "BDD6D5F89EF25696F38BF4CDA303B03E")


    private static final char UNDERSCORE_CHAR = '_';
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:24.770 -0500", hash_original_field = "F1EC188F6B9A64E9CC2DDF1BFE231004", hash_generated_field = "E671077DBE84DEFDA400ACC06557696C")


    private static String ARAB_SCRIPT_SUBTAG = "Arab";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:24.772 -0500", hash_original_field = "444B44F4D44F456A016C4AA30A616C72", hash_generated_field = "585680D6F417A4378E85E18D90332D17")

    private static String HEBR_SCRIPT_SUBTAG = "Hebr";

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:24.761 -0500", hash_original_method = "DB2CFC1123D815AD16F73168E1C2B755", hash_generated_method = "1F8B01B2D1D91402BAACAACF29104D5C")
    
private LocaleUtil() { /* cannot be instantiated */ }
}

