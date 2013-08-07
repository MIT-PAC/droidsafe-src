package com.android.internal.telephony.cat;

// Droidsafe Imports
import droidsafe.annotations.*;



public enum FontSize {
    NORMAL(0x0),
    LARGE(0x1),
    SMALL(0x2);
    private int mValue;
    @DSModeled(DSC.SAFE)
    FontSize(int value) {
        mValue = value;
    }
    @DSModeled(DSC.BAN)
    public static FontSize fromInt(int value) {
        for (FontSize e : FontSize.values()) {
            if (e.mValue == value) {
                return e;
            }
        }
        return null;
    }
}
