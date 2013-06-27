package com.android.internal.telephony;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import com.android.internal.telephony.RILConstants;
import android.util.Log;

public class CommandException extends RuntimeException {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:14.877 -0400", hash_original_field = "E1671797C52E15F763380B45E841EC32", hash_generated_field = "237634D9088F176545E1DA209B5F69AC")

    private Error e;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:14.890 -0400", hash_original_method = "AE462A80EC1EE4B5A1CC7ED5CD5F752D", hash_generated_method = "CCCCBFED75AB3988A8F88F5CA73BC6A4")
    public  CommandException(Error e) {
        super(e.toString());
        this.e = e;
        // ---------- Original Method ----------
        //this.e = e;
    }

    
        public static CommandException fromRilErrno(int ril_errno) {
        switch(ril_errno) {
            case RILConstants.SUCCESS:                       return null;
            case RILConstants.RIL_ERRNO_INVALID_RESPONSE:
                return new CommandException(Error.INVALID_RESPONSE);
            case RILConstants.RADIO_NOT_AVAILABLE:
                return new CommandException(Error.RADIO_NOT_AVAILABLE);
            case RILConstants.GENERIC_FAILURE:
                return new CommandException(Error.GENERIC_FAILURE);
            case RILConstants.PASSWORD_INCORRECT:
                return new CommandException(Error.PASSWORD_INCORRECT);
            case RILConstants.SIM_PIN2:
                return new CommandException(Error.SIM_PIN2);
            case RILConstants.SIM_PUK2:
                return new CommandException(Error.SIM_PUK2);
            case RILConstants.REQUEST_NOT_SUPPORTED:
                return new CommandException(Error.REQUEST_NOT_SUPPORTED);
            case RILConstants.OP_NOT_ALLOWED_DURING_VOICE_CALL:
                return new CommandException(Error.OP_NOT_ALLOWED_DURING_VOICE_CALL);
            case RILConstants.OP_NOT_ALLOWED_BEFORE_REG_NW:
                return new CommandException(Error.OP_NOT_ALLOWED_BEFORE_REG_NW);
            case RILConstants.SMS_SEND_FAIL_RETRY:
                return new CommandException(Error.SMS_FAIL_RETRY);
            case RILConstants.SIM_ABSENT:
                return new CommandException(Error.SIM_ABSENT);
            case RILConstants.SUBSCRIPTION_NOT_AVAILABLE:
                return new CommandException(Error.SUBSCRIPTION_NOT_AVAILABLE);
            case RILConstants.MODE_NOT_SUPPORTED:
                return new CommandException(Error.MODE_NOT_SUPPORTED);
            case RILConstants.FDN_CHECK_FAILURE:
                return new CommandException(Error.FDN_CHECK_FAILURE);
            case RILConstants.ILLEGAL_SIM_OR_ME:
                return new CommandException(Error.ILLEGAL_SIM_OR_ME);
            default:
                Log.e("GSM", "Unrecognized RIL errno " + ril_errno);
                return new CommandException(Error.INVALID_RESPONSE);
        }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:14.901 -0400", hash_original_method = "279F774637579DF8D6F317F53F6621B2", hash_generated_method = "EFABC05D4D0765F905A6E7FDB9D1268E")
    public Error getCommandError() {
        Error varB4EAC82CA7396A68D541C85D26508E83_390389245 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_390389245 = e;
        varB4EAC82CA7396A68D541C85D26508E83_390389245.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_390389245;
        // ---------- Original Method ----------
        //return e;
    }

    
    public enum Error {
        INVALID_RESPONSE,
        RADIO_NOT_AVAILABLE,
        GENERIC_FAILURE,
        PASSWORD_INCORRECT,
        SIM_PIN2,
        SIM_PUK2,
        REQUEST_NOT_SUPPORTED,
        OP_NOT_ALLOWED_DURING_VOICE_CALL,
        OP_NOT_ALLOWED_BEFORE_REG_NW,
        SMS_FAIL_RETRY,
        SIM_ABSENT,
        SUBSCRIPTION_NOT_AVAILABLE,
        MODE_NOT_SUPPORTED,
        FDN_CHECK_FAILURE,
        ILLEGAL_SIM_OR_ME,
    }

    
}

