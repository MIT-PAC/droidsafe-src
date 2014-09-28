package com.android.internal.telephony.cdma;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import android.util.Log;

import com.android.internal.telephony.Connection;

public class CdmaCallWaitingNotification {

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:59.348 -0500", hash_original_method = "17134404D2294EBB271C484F185A3E7C", hash_generated_method = "E834F62839EEEE49114E40E15C4CF912")
    
public static int
    presentationFromCLIP(int cli)
    {
        switch(cli) {
            case 0: return Connection.PRESENTATION_ALLOWED;
            case 1: return Connection.PRESENTATION_RESTRICTED;
            case 2: return Connection.PRESENTATION_UNKNOWN;
            default:
                // This shouldn't happen, just log an error and treat as Unknown
                Log.d(LOG_TAG, "Unexpected presentation " + cli);
                return Connection.PRESENTATION_UNKNOWN;
        }
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:59.320 -0500", hash_original_field = "DB10E3AE28CC9996A816C3CCD7216A83", hash_generated_field = "37C2AB96DD7CCDC96FF809DAC1A6D712")

    static final String LOG_TAG = "CDMA";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:59.322 -0500", hash_original_field = "C5D9AA6EDF218E348AEF048EB45AD371", hash_generated_field = "376AFD5842E589F4F70A309CABF53160")

    public String number = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:59.324 -0500", hash_original_field = "CCF6244B8A9CBE4E6C8D51CD802CA7F5", hash_generated_field = "0E501B58DAE8B8FF76DC46269F63915A")

    public int numberPresentation = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:59.327 -0500", hash_original_field = "BC3C85A81DD987708D9857262FFEAD3F", hash_generated_field = "F2FFE2648285E6B8E9F59D1DAF270CEE")

    public String name = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:59.329 -0500", hash_original_field = "7864F89C4679736894886FCF092D7C47", hash_generated_field = "17841A7B31477C4E936FC5E12992AA1E")

    public int namePresentation = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:59.332 -0500", hash_original_field = "06373F2B5830B6EA599A0EF2B953DBBE", hash_generated_field = "78371F87633C86E83490E919CA9BE03D")

    public int numberType = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:59.334 -0500", hash_original_field = "5BB43EBB62B57EE81DF2F9E5C4DCBE3C", hash_generated_field = "7059F03F2901AE0C041D4DCD014ACE97")

    public int numberPlan = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:59.336 -0500", hash_original_field = "A1CCB19F45B5E5EDB74CE8F87DB237C0", hash_generated_field = "272B3666BF0B9CB248E537A756B7B247")

    public int isPresent = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:59.338 -0500", hash_original_field = "181DA57DE0659AC7259A88E25FA21CEA", hash_generated_field = "8662C6CFB51BC84311D8B582BC69DBA6")

    public int signalType = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:59.341 -0500", hash_original_field = "2F69BEF3BC7E564D692E6C3D1E9CCF52", hash_generated_field = "118C952C5DF6EDAD376EB1C112E17B85")

    public int alertPitch = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:59.343 -0500", hash_original_field = "E5DC8545A44DCACB5AEA456B7AF8220B", hash_generated_field = "162F9055A3611B913A1F7B8F7E2D4B72")

    public int signal = 0;
    
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.317 -0400", hash_original_method = "EA80599905C22E601830CAF570ACF6E5", hash_generated_method = "EA80599905C22E601830CAF570ACF6E5")
    public CdmaCallWaitingNotification ()
    {
        //Synthesized constructor
    }

    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:59.345 -0500", hash_original_method = "7BACCCFD399686BD18F0B929D0C46F63", hash_generated_method = "92BEBCF1C005A037AEE58D191E487C04")
    
public String toString()
    {
        return super.toString() + "Call Waiting Notification  "
            + " number: " + number
            + " numberPresentation: " + numberPresentation
            + " name: " + name
            + " namePresentation: " + namePresentation
            + " numberType: " + numberType
            + " numberPlan: " + numberPlan
            + " isPresent: " + isPresent
            + " signalType: " + signalType
            + " alertPitch: " + alertPitch
            + " signal: " + signal ;
    }
}

