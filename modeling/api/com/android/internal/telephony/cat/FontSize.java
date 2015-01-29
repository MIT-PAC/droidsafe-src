package com.android.internal.telephony.cat;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;



public enum FontSize {
    NORMAL(0x0),
    LARGE(0x1),
    SMALL(0x2);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:08.766 -0500", hash_original_field = "177FAFFA7A38FCF6D55DEE4AFF0E6CEC", hash_generated_field = "1FE26AAF0F7068BF50C3FDD7D6BD850D")


    private int mValue;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:08.768 -0500", hash_original_method = "B4C637769F859D9AE5A4E202F97884F8", hash_generated_method = "B4C637769F859D9AE5A4E202F97884F8")
        
FontSize(int value) {
        mValue = value;
    }

    /**
     * Create a FontSize object.
     * @param value Integer value to be converted to a FontSize object.
     * @return FontSize object whose value is {@code value}. If no
     *         FontSize object has that value, null is returned.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:08.771 -0500", hash_original_method = "8B16DE223162B976889AAB14A1A91537", hash_generated_method = "08E0A9E926BD51746398A3DDF7AE150D")
        
public static FontSize fromInt(int value) {
        for (FontSize e : FontSize.values()) {
            if (e.mValue == value) {
                return e;
            }
        }
        return null;
    }
}
