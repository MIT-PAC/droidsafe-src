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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.824 -0400", hash_original_method = "19886B3B3DEBC90286776E902A151A3F", hash_generated_method = "19886B3B3DEBC90286776E902A151A3F")
        public HttpLog ()
    {
    }


        static void v(String logMe) {
        Log.v(LOGTAG, SystemClock.uptimeMillis() + " " + Thread.currentThread().getName() + " " + logMe);
    }

    
        static void e(String logMe) {
        Log.e(LOGTAG, logMe);
    }

    
    private final static String LOGTAG = "http";
    private static final boolean DEBUG = false;
    static final boolean LOGV = false;
}

