package com.android.internal.telephony.sip;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import com.android.internal.telephony.PhoneNotifier;
import android.content.Context;
import android.net.sip.SipProfile;
import android.util.Log;
import java.text.ParseException;

public class SipPhoneFactory {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.456 -0400", hash_original_method = "324E8C1C6C45897C0A029A317B4DE5CF", hash_generated_method = "324E8C1C6C45897C0A029A317B4DE5CF")
        public SipPhoneFactory ()
    {
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

