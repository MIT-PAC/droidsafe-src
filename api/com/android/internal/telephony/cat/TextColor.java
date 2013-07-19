package com.android.internal.telephony.cat;

// Droidsafe Imports
import droidsafe.annotations.DSC;
import droidsafe.annotations.DSModeled;

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
    private int mValue;
    @DSModeled(DSC.SAFE)
    TextColor(int value) {
        mValue = value;
    }
    public static TextColor fromInt(int value) {
        for (TextColor e : TextColor.values()) {
            if (e.mValue == value) {
                return e;
            }
        }
        return null;
    }
}
