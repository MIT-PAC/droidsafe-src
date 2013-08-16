package com.android.internal.telephony.cat;

// Droidsafe Imports
import droidsafe.annotations.*;

public interface AppInterface {

    
    public static final String CAT_CMD_ACTION =
                                    "android.intent.action.stk.command";
    public static final String CAT_SESSION_END_ACTION =
                                    "android.intent.action.stk.session_end";

    
    void onCmdResponse(CatResponseMessage resMsg);

    
    public static enum CommandType {
        DISPLAY_TEXT(0x21),
        GET_INKEY(0x22),
        GET_INPUT(0x23),
        LAUNCH_BROWSER(0x15),
        PLAY_TONE(0x20),
        REFRESH(0x01),
        SELECT_ITEM(0x24),
        SEND_SS(0x11),
        SEND_USSD(0x12),
        SEND_SMS(0x13),
        SEND_DTMF(0x14),
        SET_UP_EVENT_LIST(0x05),
        SET_UP_IDLE_MODE_TEXT(0x28),
        SET_UP_MENU(0x25),
        SET_UP_CALL(0x10),
        PROVIDE_LOCAL_INFORMATION(0x26);

        private int mValue;

        CommandType(int value) {
            mValue = value;
        }

        @DSModeled(DSC.BAN)
        public int value() {
            return mValue;
        }

        
        @DSModeled(DSC.BAN)
        public static CommandType fromInt(int value) {
            for (CommandType e : CommandType.values()) {
                if (e.mValue == value) {
                    return e;
                }
            }
            return null;
        }
    }
}
