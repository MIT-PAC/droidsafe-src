package com.android.internal.telephony;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.telephony.PhoneNumberUtils;

public class CallForwardInfo {
    public int             status;
    public int             reason;
    public int             serviceClass;
    public int             toa;
    public String          number;
    public int             timeSeconds;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.766 -0400", hash_original_method = "CF91EBDCAEA441679119019CCAC8281C", hash_generated_method = "CF91EBDCAEA441679119019CCAC8281C")
        public CallForwardInfo ()
    {
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.766 -0400", hash_original_method = "EA7E7BF9BED1BC105930545F926483CA", hash_generated_method = "FABB925E9130901662229E7A40654139")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String toString() {
        String varD9EC4C32971AAEE83F4B08EB607ABB4A_1225717557 = (super.toString() + (status == 0 ? " not active " : " active ")
            + " reason: " + reason
            + " serviceClass: " + serviceClass
            + " \"" + PhoneNumberUtils.stringFromStringAndTOA(number, toa) + "\" "
            + timeSeconds + " seconds"); //DSFIXME:  CODE0008: Nested ternary operator in expression
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return super.toString() + (status == 0 ? " not active " : " active ")
            //+ " reason: " + reason
            //+ " serviceClass: " + serviceClass
            //+ " \"" + PhoneNumberUtils.stringFromStringAndTOA(number, toa) + "\" "
            //+ timeSeconds + " seconds";
    }

    
}

