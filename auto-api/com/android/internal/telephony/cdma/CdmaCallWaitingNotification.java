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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:19.850 -0400", hash_original_field = "923514A5863F58F99BFC8BE708235C6E", hash_generated_field = "376AFD5842E589F4F70A309CABF53160")

    public String number = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:19.850 -0400", hash_original_field = "C5DCF11D99E2A42E07419AB5D0932361", hash_generated_field = "0E501B58DAE8B8FF76DC46269F63915A")

    public int numberPresentation = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:19.850 -0400", hash_original_field = "6D6832C945CE1F820B62E7ED6D65FF6B", hash_generated_field = "F2FFE2648285E6B8E9F59D1DAF270CEE")

    public String name = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:19.850 -0400", hash_original_field = "F039575D07B46A4903D3C46392B74BC6", hash_generated_field = "17841A7B31477C4E936FC5E12992AA1E")

    public int namePresentation = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:19.850 -0400", hash_original_field = "F4735AA58F49285AB3BE5E02D62143A7", hash_generated_field = "78371F87633C86E83490E919CA9BE03D")

    public int numberType = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:19.860 -0400", hash_original_field = "53D28A3B67432301FEF53BCE8EC6C20D", hash_generated_field = "7059F03F2901AE0C041D4DCD014ACE97")

    public int numberPlan = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:19.860 -0400", hash_original_field = "17BF17DF6D593EED3D02FD445623CD8A", hash_generated_field = "272B3666BF0B9CB248E537A756B7B247")

    public int isPresent = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:19.860 -0400", hash_original_field = "2930A59F93B0AB07901FC6DF886DE3A7", hash_generated_field = "8662C6CFB51BC84311D8B582BC69DBA6")

    public int signalType = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:19.860 -0400", hash_original_field = "007CA00C34E25642632FE141EF557272", hash_generated_field = "118C952C5DF6EDAD376EB1C112E17B85")

    public int alertPitch = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:19.860 -0400", hash_original_field = "B6B4A2FF4DF5CF7C3D70DF832825CB5E", hash_generated_field = "162F9055A3611B913A1F7B8F7E2D4B72")

    public int signal = 0;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:19.860 -0400", hash_original_method = "EA80599905C22E601830CAF570ACF6E5", hash_generated_method = "EA80599905C22E601830CAF570ACF6E5")
    public CdmaCallWaitingNotification ()
    {
        //Synthesized constructor
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:19.862 -0400", hash_original_method = "7BACCCFD399686BD18F0B929D0C46F63", hash_generated_method = "D84F126AB3C48A6DB1A02546589E2BA7")
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_1966775548 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1966775548 = super.toString() + "Call Waiting Notification  "
            + " number: " + number
            + " numberPresentation: " + numberPresentation
            + " name: " + name
            + " namePresentation: " + namePresentation
            + " numberType: " + numberType
            + " numberPlan: " + numberPlan
            + " isPresent: " + isPresent
            + " signalType: " + signalType
            + " alertPitch: " + alertPitch
            + " signal: " + signal;
        varB4EAC82CA7396A68D541C85D26508E83_1966775548.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1966775548;
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:19.863 -0400", hash_original_field = "951C150E6D062E6AED2C45BB9B756185", hash_generated_field = "3985FC5365F0E17AC0BA70F3DC93B852")

    static String LOG_TAG = "CDMA";
}

