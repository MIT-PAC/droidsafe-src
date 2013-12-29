package com.android.internal.telephony.cat;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;



public enum ResultCode {
    OK(0x00),
    PRFRMD_WITH_PARTIAL_COMPREHENSION(0x01),
    PRFRMD_WITH_MISSING_INFO(0x02),
    PRFRMD_WITH_ADDITIONAL_EFS_READ(0x03),
    PRFRMD_ICON_NOT_DISPLAYED(0x04),
    PRFRMD_MODIFIED_BY_NAA(0x05),
    PRFRMD_LIMITED_SERVICE(0x06),
    PRFRMD_WITH_MODIFICATION(0x07),
    PRFRMD_NAA_NOT_ACTIVE(0x08),
    PRFRMD_TONE_NOT_PLAYED(0x09),
    UICC_SESSION_TERM_BY_USER(0x10),
    BACKWARD_MOVE_BY_USER(0x11),
    NO_RESPONSE_FROM_USER(0x12),
    HELP_INFO_REQUIRED(0x13),
    USSD_SS_SESSION_TERM_BY_USER(0x14),
    TERMINAL_CRNTLY_UNABLE_TO_PROCESS(0x20),
    NETWORK_CRNTLY_UNABLE_TO_PROCESS(0x21),
    USER_NOT_ACCEPT(0x22),
    USER_CLEAR_DOWN_CALL(0x23),
    CONTRADICTION_WITH_TIMER(0x24),
    NAA_CALL_CONTROL_TEMPORARY(0x25),
    LAUNCH_BROWSER_ERROR(0x26),
    MMS_TEMPORARY(0x27),
    BEYOND_TERMINAL_CAPABILITY(0x30),
    CMD_TYPE_NOT_UNDERSTOOD(0x31),
    CMD_DATA_NOT_UNDERSTOOD(0x32),
    CMD_NUM_NOT_KNOWN(0x33),
    SS_RETURN_ERROR(0x34),
    SMS_RP_ERROR(0x35),
    REQUIRED_VALUES_MISSING(0x36),
    USSD_RETURN_ERROR(0x37),
    MULTI_CARDS_CMD_ERROR(0x38),
    USIM_CALL_CONTROL_PERMANENT(0x39),
    BIP_ERROR(0x3a),
    ACCESS_TECH_UNABLE_TO_PROCESS(0x3b),
    FRAMES_ERROR(0x3c),
    MMS_ERROR(0x3d);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:25.734 -0500", hash_original_field = "72DDC44E3DCFD57F1A99143C6BCFD37C", hash_generated_field = "814428A5309A583B3B018643DB7956B1")



    private int mCode;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:25.735 -0500", hash_original_method = "8F24C9B06F9440EBB8D55C34DB4C46F4", hash_generated_method = "8F24C9B06F9440EBB8D55C34DB4C46F4")
        ResultCode(int code) {
        mCode = code;
    }

    /**
     * Retrieves the actual result code that this object represents.
     * @return Actual result code
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:25.736 -0500", hash_original_method = "107FF77B7A75BF457CAC3BECBA565481", hash_generated_method = "AF1F00321A509FB9157E483BB098C049")
        public int value() {
        return mCode;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:25.737 -0500", hash_original_method = "6AA8B8FE507776B08C03F9916581D2CC", hash_generated_method = "36806E655A9A215E5254C9836D902918")
        public static ResultCode fromInt(int value) {
        for (ResultCode r : ResultCode.values()) {
            if (r.mCode == value) {
                return r;
            }
        }
        return null;
    }
}
