package com.android.internal.telephony.gsm;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.telephony.PhoneNumberUtils;

public class SuppServiceNotification {
    public int notificationType;
    public int code;
    public int index;
    public int type;
    public String number;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:16.989 -0400", hash_original_method = "CCFFD7BFAFD7BB00F5023E59AF9F8B34", hash_generated_method = "CCFFD7BFAFD7BB00F5023E59AF9F8B34")
        public SuppServiceNotification ()
    {
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:16.989 -0400", hash_original_method = "A03F8251EC229F0DECFD7D9A52A7C82D", hash_generated_method = "F42035C3EDA365F5890377782F593987")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String toString() {
        String var93E1747B3666E1E08C9F1195045D2D0D_585777437 = (super.toString() + " mobile"
            + (notificationType == 0 ? " originated " : " terminated ")
            + " code: " + code
            + " index: " + index
            + " \""
            + PhoneNumberUtils.stringFromStringAndTOA(number, type) + "\" "); //DSFIXME:  CODE0008: Nested ternary operator in expression
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return super.toString() + " mobile"
            //+ (notificationType == 0 ? " originated " : " terminated ")
            //+ " code: " + code
            //+ " index: " + index
            //+ " \""
            //+ PhoneNumberUtils.stringFromStringAndTOA(number, type) + "\" ";
    }

    
    static public final int MO_CODE_UNCONDITIONAL_CF_ACTIVE     = 0;
    static public final int MO_CODE_SOME_CF_ACTIVE              = 1;
    static public final int MO_CODE_CALL_FORWARDED              = 2;
    static public final int MO_CODE_CALL_IS_WAITING             = 3;
    static public final int MO_CODE_CUG_CALL                    = 4;
    static public final int MO_CODE_OUTGOING_CALLS_BARRED       = 5;
    static public final int MO_CODE_INCOMING_CALLS_BARRED       = 6;
    static public final int MO_CODE_CLIR_SUPPRESSION_REJECTED   = 7;
    static public final int MO_CODE_CALL_DEFLECTED              = 8;
    static public final int MT_CODE_FORWARDED_CALL              = 0;
    static public final int MT_CODE_CUG_CALL                    = 1;
    static public final int MT_CODE_CALL_ON_HOLD                = 2;
    static public final int MT_CODE_CALL_RETRIEVED              = 3;
    static public final int MT_CODE_MULTI_PARTY_CALL            = 4;
    static public final int MT_CODE_ON_HOLD_CALL_RELEASED       = 5;
    static public final int MT_CODE_FORWARD_CHECK_RECEIVED      = 6;
    static public final int MT_CODE_CALL_CONNECTING_ECT         = 7;
    static public final int MT_CODE_CALL_CONNECTED_ECT          = 8;
    static public final int MT_CODE_DEFLECTED_CALL              = 9;
    static public final int MT_CODE_ADDITIONAL_CALL_FORWARDED   = 10;
}

