package com.android.internal.telephony.sip;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import com.android.internal.telephony.PhoneNotifier;
import android.content.Context;
import android.net.sip.SipProfile;
import android.util.Log;
import java.text.ParseException;

public class SipPhoneFactory {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:26.399 -0400", hash_original_method = "15E2472645F6BD56CA55CE00B2D7EBA0", hash_generated_method = "15E2472645F6BD56CA55CE00B2D7EBA0")
    public SipPhoneFactory ()
    {
        //Synthesized constructor
    }


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

