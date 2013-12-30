package com.android.internal.telephony.cat;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;



public enum TextColor {
    BLACK(0x0),
    DARK_GRAY(0x1),
    DARK_RED(0x2),
    DARK_YELLOW(0x3),
    DARK_GREEN(0x4),
    DARK_CYAN(0x5),
    DARK_BLUE(0x6),
    DARK_MAGENTA(0x7),
    GRAY(0x8),
    WHITE(0x9),
    BRIGHT_RED(0xa),
    BRIGHT_YELLOW(0xb),
    BRIGHT_GREEN(0xc),
    BRIGHT_CYAN(0xd),
    BRIGHT_BLUE(0xe),
    BRIGHT_MAGENTA(0xf);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:07.049 -0500", hash_original_field = "177FAFFA7A38FCF6D55DEE4AFF0E6CEC", hash_generated_field = "1FE26AAF0F7068BF50C3FDD7D6BD850D")


    private int mValue;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:07.052 -0500", hash_original_method = "3D590D1ADED3F8E9D97FE66804FB8342", hash_generated_method = "3D590D1ADED3F8E9D97FE66804FB8342")
        
TextColor(int value) {
        mValue = value;
    }

    /**
     * Create a TextColor object.
     * @param value Integer value to be converted to a TextColor object.
     * @return TextColor object whose value is {@code value}. If no TextColor
     *         object has that value, null is returned.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:07.054 -0500", hash_original_method = "C1C64C598309A1C0897A2D46B8920DB6", hash_generated_method = "18FC67C18A5DADD280B9B0E8387DDB73")
        
public static TextColor fromInt(int value) {
        for (TextColor e : TextColor.values()) {
            if (e.mValue == value) {
                return e;
            }
        }
        return null;
    }
}
