package android.net.http;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.os.SystemClock;
import android.util.Log;

class HttpLog {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:27.228 -0400", hash_original_method = "979E726A42018524BC838D3AC9025153", hash_generated_method = "979E726A42018524BC838D3AC9025153")
    public HttpLog ()
    {
        //Synthesized constructor
    }


        static void v(String logMe) {
        Log.v(LOGTAG, SystemClock.uptimeMillis() + " " + Thread.currentThread().getName() + " " + logMe);
    }

    
        static void e(String logMe) {
        Log.e(LOGTAG, logMe);
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:27.228 -0400", hash_original_field = "1E3B9C6A8ED947B6C407C24A2D9F386E", hash_generated_field = "0E4264462F7725E28A9617A58C0502A6")

    private final static String LOGTAG = "http";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:27.228 -0400", hash_original_field = "021906CCEC815FC820B74F760E7368C7", hash_generated_field = "58EDF43BA541A4D47EECFEC3901C7AED")

    private static final boolean DEBUG = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:27.229 -0400", hash_original_field = "610CEFDAFAA51B6305E772437889A17E", hash_generated_field = "7BF817D02AEAAD1175A3688D79B78EBB")

    static final boolean LOGV = false;
}

