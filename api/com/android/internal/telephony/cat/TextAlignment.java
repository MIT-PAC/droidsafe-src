package com.android.internal.telephony.cat;

// Droidsafe Imports
import droidsafe.annotations.*;



public enum TextAlignment {
    LEFT(0x0),
    CENTER(0x1),
    RIGHT(0x2),
    DEFAULT(0x3);
    private int mValue;
    @DSModeled(DSC.SAFE)
    TextAlignment(int value) {
        mValue = value;
    }
    @DSModeled(DSC.BAN)
    public static TextAlignment fromInt(int value) {
        for (TextAlignment e : TextAlignment.values()) {
            if (e.mValue == value) {
                return e;
            }
        }
        return null;
    }
}
