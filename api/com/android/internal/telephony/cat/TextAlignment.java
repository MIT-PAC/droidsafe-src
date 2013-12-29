package com.android.internal.telephony.cat;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;



public enum TextAlignment {
    LEFT(0x0),
    CENTER(0x1),
    RIGHT(0x2),
    DEFAULT(0x3);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:24.469 -0500", hash_original_field = "177FAFFA7A38FCF6D55DEE4AFF0E6CEC", hash_generated_field = "1FE26AAF0F7068BF50C3FDD7D6BD850D")


    private int mValue;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:24.470 -0500", hash_original_method = "65BEFDD6F9FD01556EC027F435F4D3BB", hash_generated_method = "65BEFDD6F9FD01556EC027F435F4D3BB")
        TextAlignment(int value) {
        mValue = value;
    }

    /**
     * Create a TextAlignment object.
     * @param value Integer value to be converted to a TextAlignment object.
     * @return TextAlignment object whose value is {@code value}. If no
     *         TextAlignment object has that value, null is returned.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:24.471 -0500", hash_original_method = "EE4E674CDA4C57E84BB652D16F8BF8CF", hash_generated_method = "4FE90C874477F41538FA88B9E4CB5C27")
        public static TextAlignment fromInt(int value) {
        for (TextAlignment e : TextAlignment.values()) {
            if (e.mValue == value) {
                return e;
            }
        }
        return null;
    }
}
