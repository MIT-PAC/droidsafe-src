package android.net.http;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.os.SystemClock;
import android.util.Log;

class HttpLog {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:21.181 -0400", hash_original_method = "979E726A42018524BC838D3AC9025153", hash_generated_method = "979E726A42018524BC838D3AC9025153")
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:21.182 -0400", hash_original_field = "1E3B9C6A8ED947B6C407C24A2D9F386E", hash_generated_field = "EECC2AF24318ABE0B4AF26461D40DD40")

    private static String LOGTAG = "http";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:21.182 -0400", hash_original_field = "021906CCEC815FC820B74F760E7368C7", hash_generated_field = "E83DF1E2E661A92B1AFDA8C473D190B2")

    private static boolean DEBUG = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:21.182 -0400", hash_original_field = "610CEFDAFAA51B6305E772437889A17E", hash_generated_field = "955AA5C0089B630CE132BE772DB385C8")

    static boolean LOGV = false;
}

