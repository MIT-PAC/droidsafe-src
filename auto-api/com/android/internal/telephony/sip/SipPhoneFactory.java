package com.android.internal.telephony.sip;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import com.android.internal.telephony.PhoneNotifier;
import android.content.Context;
import android.net.sip.SipProfile;
import android.util.Log;
import java.text.ParseException;

public class SipPhoneFactory {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.466 -0400", hash_original_method = "58A7161193CB0CF71FFF602E5D298512", hash_generated_method = "BC4BFACAF7BDFD62A8A1527DF38E7421")
    public static SipPhone makePhone(String sipUri, Context context,
            PhoneNotifier phoneNotifier) {
        try {
            SipProfile profile = new SipProfile.Builder(sipUri).build();
            return new SipPhone(context, phoneNotifier, profile);
        } catch (ParseException e) {
            Log.w("SipPhoneFactory", "makePhone", e);
            return null;
        }
    }

    
}


