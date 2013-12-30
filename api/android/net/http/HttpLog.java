package android.net.http;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import android.os.SystemClock;
import android.util.Log;



class HttpLog {

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:11.756 -0500", hash_original_method = "ED5177493AE058A868D658244327AECF", hash_generated_method = "A0600B767580BB09253A0D680DBA846C")
    
static void v(String logMe) {
        Log.v(LOGTAG, SystemClock.uptimeMillis() + " " + Thread.currentThread().getName() + " " + logMe);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:11.759 -0500", hash_original_method = "F34399D2262911B58E427353F2102EE3", hash_generated_method = "9F9F00C3A0A51D24385EF1E9BCE45A4E")
    
static void e(String logMe) {
        Log.e(LOGTAG, logMe);
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:11.750 -0500", hash_original_field = "AA2D481FA39E22C038AF79EEA0165EC5", hash_generated_field = "0E4264462F7725E28A9617A58C0502A6")

    private final static String LOGTAG = "http";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:11.752 -0500", hash_original_field = "81DD852ECBE07BA98A61C8F3D0C85F01", hash_generated_field = "58EDF43BA541A4D47EECFEC3901C7AED")


    private static final boolean DEBUG = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:11.754 -0500", hash_original_field = "A49D73F94042F134FD949A2058C44882", hash_generated_field = "7BF817D02AEAAD1175A3688D79B78EBB")

    static final boolean LOGV = false;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:20.190 -0400", hash_original_method = "979E726A42018524BC838D3AC9025153", hash_generated_method = "979E726A42018524BC838D3AC9025153")
    public HttpLog ()
    {
        //Synthesized constructor
    }
}

