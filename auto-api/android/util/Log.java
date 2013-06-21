package android.util;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import com.android.internal.os.RuntimeInit;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.UnknownHostException;

public final class Log {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.221 -0400", hash_original_method = "869367D375FC874369E92ACB08C85ECE", hash_generated_method = "A62EB914C3FFD50186C13765FE4CB4E6")
    @DSModeled(DSC.SAFE)
    private Log() {
        // ---------- Original Method ----------
    }

    
        public static int v(String tag, String msg) {
        return println_native(LOG_ID_MAIN, VERBOSE, tag, msg);
    }

    
        public static int v(String tag, String msg, Throwable tr) {
        return println_native(LOG_ID_MAIN, VERBOSE, tag, msg + '\n' + getStackTraceString(tr));
    }

    
        public static int d(String tag, String msg) {
        return println_native(LOG_ID_MAIN, DEBUG, tag, msg);
    }

    
        public static int d(String tag, String msg, Throwable tr) {
        return println_native(LOG_ID_MAIN, DEBUG, tag, msg + '\n' + getStackTraceString(tr));
    }

    
        public static int i(String tag, String msg) {
        return println_native(LOG_ID_MAIN, INFO, tag, msg);
    }

    
        public static int i(String tag, String msg, Throwable tr) {
        return println_native(LOG_ID_MAIN, INFO, tag, msg + '\n' + getStackTraceString(tr));
    }

    
        public static int w(String tag, String msg) {
        return println_native(LOG_ID_MAIN, WARN, tag, msg);
    }

    
        public static int w(String tag, String msg, Throwable tr) {
        return println_native(LOG_ID_MAIN, WARN, tag, msg + '\n' + getStackTraceString(tr));
    }

    
        public static boolean isLoggable(String tag, int level) {
        return DSUtils.UNKNOWN_BOOLEAN;
    }

    
        public static int w(String tag, Throwable tr) {
        return println_native(LOG_ID_MAIN, WARN, tag, getStackTraceString(tr));
    }

    
        public static int e(String tag, String msg) {
        return println_native(LOG_ID_MAIN, ERROR, tag, msg);
    }

    
        public static int e(String tag, String msg, Throwable tr) {
        return println_native(LOG_ID_MAIN, ERROR, tag, msg + '\n' + getStackTraceString(tr));
    }

    
        public static int wtf(String tag, String msg) {
        return wtf(tag, msg, null);
    }

    
        public static int wtf(String tag, Throwable tr) {
        return wtf(tag, tr.getMessage(), tr);
    }

    
        public static int wtf(String tag, String msg, Throwable tr) {
        TerribleFailure what = new TerribleFailure(msg, tr);
        int bytes = println_native(LOG_ID_MAIN, ASSERT, tag, msg + '\n' + getStackTraceString(tr));
        sWtfHandler.onTerribleFailure(tag, what);
        return bytes;
    }

    
        public static TerribleFailureHandler setWtfHandler(TerribleFailureHandler handler) {
        if (handler == null) {
            throw new NullPointerException("handler == null");
        }
        TerribleFailureHandler oldHandler = sWtfHandler;
        sWtfHandler = handler;
        return oldHandler;
    }

    
        public static String getStackTraceString(Throwable tr) {
        if (tr == null) {
            return "";
        }
        Throwable t = tr;
        while (t != null) {
            if (t instanceof UnknownHostException) {
                return "";
            }
            t = t.getCause();
        }
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        tr.printStackTrace(pw);
        return sw.toString();
    }

    
        public static int println(int priority, String tag, String msg) {
        return println_native(LOG_ID_MAIN, priority, tag, msg);
    }

    
        public static int println_native(int bufID,
            int priority, String tag, String msg) {
        return DSUtils.UNKNOWN_INT;
    }

    
    private static class TerribleFailure extends Exception {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.227 -0400", hash_original_method = "0F8223B52B3C6FF6727F78AC7E36D4B8", hash_generated_method = "024C5D9BFCCE77DFDD68BFCCB2AB6ACE")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         TerribleFailure(String msg, Throwable cause) {
            super(msg, cause);
            dsTaint.addTaint(cause.dsTaint);
            dsTaint.addTaint(msg);
            // ---------- Original Method ----------
        }

        
    }


    
    public interface TerribleFailureHandler {
        void onTerribleFailure(String tag, TerribleFailure what);
    }
    
    public static final int VERBOSE = 2;
    public static final int DEBUG = 3;
    public static final int INFO = 4;
    public static final int WARN = 5;
    public static final int ERROR = 6;
    public static final int ASSERT = 7;
    private static TerribleFailureHandler sWtfHandler = new TerribleFailureHandler() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.227 -0400", hash_original_method = "90BA23F8182E406DC4D5C312FC444694", hash_generated_method = "68273E1AAB9EED38EAB5E10B55C7BD24")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void onTerribleFailure(String tag, TerribleFailure what) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            dsTaint.addTaint(what.dsTaint);
            dsTaint.addTaint(tag);
            RuntimeInit.wtf(tag, what);
            // ---------- Original Method ----------
            //RuntimeInit.wtf(tag, what);
        }

        
}; //Transformed anonymous class
    public static final int LOG_ID_MAIN = 0;
    public static final int LOG_ID_RADIO = 1;
    public static final int LOG_ID_EVENTS = 2;
    public static final int LOG_ID_SYSTEM = 3;
}

