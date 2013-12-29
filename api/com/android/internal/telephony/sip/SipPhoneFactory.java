package com.android.internal.telephony.sip;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.text.ParseException;

import android.content.Context;
import android.net.sip.SipProfile;
import android.util.Log;

import com.android.internal.telephony.PhoneNotifier;



public class SipPhoneFactory {
    /**
     * Makes a {@link SipPhone} object.
     * @param sipUri the local SIP URI the phone runs on
     * @param context {@code Context} needed to create a Phone object
     * @param phoneNotifier {@code PhoneNotifier} needed to create a Phone
     *      object
     * @return the {@code SipPhone} object or null if the SIP URI is not valid
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:33.392 -0500", hash_original_method = "58A7161193CB0CF71FFF602E5D298512", hash_generated_method = "BC4BFACAF7BDFD62A8A1527DF38E7421")
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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:26.399 -0400", hash_original_method = "15E2472645F6BD56CA55CE00B2D7EBA0", hash_generated_method = "15E2472645F6BD56CA55CE00B2D7EBA0")
    public SipPhoneFactory ()
    {
        //Synthesized constructor
    }

    
}

