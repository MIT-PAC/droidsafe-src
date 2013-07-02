package com.android.internal.telephony.cat;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;

public enum TextAlignment {
    LEFT(0x0),
    CENTER(0x1),
    RIGHT(0x2),
    DEFAULT(0x3);
    private int mValue;
    TextAlignment(int value) {
        mValue = value;
    }
    @DSModeled(DSC.SAFE)
    public static TextAlignment fromInt(int value) {
        for (TextAlignment e : TextAlignment.values()) {
            if (e.mValue == value) {
                return e;
            }
        }
        return null;
    }
}
