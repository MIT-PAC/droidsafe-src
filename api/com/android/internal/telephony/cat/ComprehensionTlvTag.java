package com.android.internal.telephony.cat;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

public enum ComprehensionTlvTag {
    COMMAND_DETAILS(0x01),
    DEVICE_IDENTITIES(0x02),
    RESULT(0x03),
    DURATION(0x04),
    ALPHA_ID(0x05),
    ADDRESS(0x06),
    USSD_STRING(0x0a),
    SMS_TPDU(0x0b),
    TEXT_STRING(0x0d),
    TONE(0x0e),
    ITEM(0x0f),
    ITEM_ID(0x10),
    RESPONSE_LENGTH(0x11),
    FILE_LIST(0x12),
    HELP_REQUEST(0x15),
    DEFAULT_TEXT(0x17),
    EVENT_LIST(0x19),
    ICON_ID(0x1e),
    ITEM_ICON_ID_LIST(0x1f),
    IMMEDIATE_RESPONSE(0x2b),
    LANGUAGE(0x2d),
    URL(0x31),
    BROWSER_TERMINATION_CAUSE(0x34),
    TEXT_ATTRIBUTE(0x50);
    private int mValue;
    ComprehensionTlvTag(int value) {
        mValue = value;
    }
    @DSModeled(DSC.SAFE)
    public int value() {
        return mValue;
    }
    public static ComprehensionTlvTag fromInt(int value) {
        for (ComprehensionTlvTag e : ComprehensionTlvTag.values()) {
            if (e.mValue == value) {
                return e;
            }
        }
        return null;
    }
}
