package com.android.internal.telephony.cdma;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.util.Log;
import com.android.internal.telephony.Connection;

public class CdmaCallWaitingNotification {
    public String number = null;
    public int numberPresentation = 0;
    public String name = null;
    public int namePresentation = 0;
    public int numberType = 0;
    public int numberPlan = 0;
    public int isPresent = 0;
    public int signalType = 0;
    public int alertPitch = 0;
    public int signal = 0;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.303 -0400", hash_original_method = "84E3BFEB8FFE2EB119975738D26338C9", hash_generated_method = "84E3BFEB8FFE2EB119975738D26338C9")
        public CdmaCallWaitingNotification ()
    {
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.303 -0400", hash_original_method = "7BACCCFD399686BD18F0B929D0C46F63", hash_generated_method = "710495456B64C78ED3BBA9F83328445B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String toString() {
        String var796B6A835C30F77CE7C2E83C78F1D855_562582336 = (super.toString() + "Call Waiting Notification  "
            + " number: " + number
            + " numberPresentation: " + numberPresentation
            + " name: " + name
            + " namePresentation: " + namePresentation
            + " numberType: " + numberType
            + " numberPlan: " + numberPlan
            + " isPresent: " + isPresent
            + " signalType: " + signalType
            + " alertPitch: " + alertPitch
            + " signal: " + signal);
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return super.toString() + "Call Waiting Notification  "
            //+ " number: " + number
            //+ " numberPresentation: " + numberPresentation
            //+ " name: " + name
            //+ " namePresentation: " + namePresentation
            //+ " numberType: " + numberType
            //+ " numberPlan: " + numberPlan
            //+ " isPresent: " + isPresent
            //+ " signalType: " + signalType
            //+ " alertPitch: " + alertPitch
            //+ " signal: " + signal ;
    }

    
        public static int presentationFromCLIP(int cli) {
        switch(cli) {
            case 0: return Connection.PRESENTATION_ALLOWED;
            case 1: return Connection.PRESENTATION_RESTRICTED;
            case 2: return Connection.PRESENTATION_UNKNOWN;
            default:
                Log.d(LOG_TAG, "Unexpected presentation " + cli);
                return Connection.PRESENTATION_UNKNOWN;
        }
    }

    
    static final String LOG_TAG = "CDMA";
}

