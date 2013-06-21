package com.android.internal.telephony.cat;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public enum FontSize {
    NORMAL(0x0),
    LARGE(0x1),
    SMALL(0x2);
    private int mValue;
    FontSize(int value) {
        mValue = value;
    }
    public static FontSize fromInt(int value) {
        for (FontSize e : FontSize.values()) {
            if (e.mValue == value) {
                return e;
            }
        }
        return null;
    }
}
