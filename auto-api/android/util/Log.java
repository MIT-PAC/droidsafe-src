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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:44.891 -0400", hash_original_method = "869367D375FC874369E92ACB08C85ECE", hash_generated_method = "A62EB914C3FFD50186C13765FE4CB4E6")
    private  Log() {
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
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:44.916 -0400", hash_original_method = "0F8223B52B3C6FF6727F78AC7E36D4B8", hash_generated_method = "C1561E5D30B86F3897AF8E18F385FFFE")
          TerribleFailure(String msg, Throwable cause) {
            super(msg, cause);
            addTaint(msg.getTaint());
            addTaint(cause.getTaint());
            // ---------- Original Method ----------
        }

        
    }


    
    public interface TerribleFailureHandler {
        void onTerribleFailure(String tag, TerribleFailure what);
    }
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:44.917 -0400", hash_original_field = "CAD8C4DC986F95096FF26D44987A3C24", hash_generated_field = "183ECC1630CBD890D38268E5859FD6F6")

    public static final int VERBOSE = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:44.917 -0400", hash_original_field = "8F6DDEBAE3A3DB44389E1FB1E5408AD7", hash_generated_field = "26AABFCC751A881E695E902E0608E346")

    public static final int DEBUG = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:44.917 -0400", hash_original_field = "5759D9AAA2E6F04AD55217CD59B534EC", hash_generated_field = "6A8CBF4155F7D9169D37C74D4C14F8A9")

    public static final int INFO = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:44.917 -0400", hash_original_field = "394364B7D3297C26950D2238139AFF91", hash_generated_field = "6A26B7A055D881912AAB57C2278AA725")

    public static final int WARN = 5;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:44.917 -0400", hash_original_field = "7FD6D66B926D8917D561E5E98CA696D5", hash_generated_field = "B6B991924F4F8C2A773B84BA83915632")

    public static final int ERROR = 6;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:44.917 -0400", hash_original_field = "CBB8FCA07981B9789A4AC58A4B746FF2", hash_generated_field = "9BB2A0262D13A08A51875E90349F0239")

    public static final int ASSERT = 7;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:44.917 -0400", hash_original_field = "1A1695BDB6E58ED53BC49925AFADC824", hash_generated_field = "7133E8B8C00EDE45DD493C68637B60E0")

    private static TerribleFailureHandler sWtfHandler = new TerribleFailureHandler() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:44.917 -0400", hash_original_method = "90BA23F8182E406DC4D5C312FC444694", hash_generated_method = "4C8A9452FEB3740EEFD06B4E1BFB8698")
        public void onTerribleFailure(String tag, TerribleFailure what) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            RuntimeInit.wtf(tag, what);
            addTaint(tag.getTaint());
            addTaint(what.getTaint());
            // ---------- Original Method ----------
            //RuntimeInit.wtf(tag, what);
        }

        
};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:44.917 -0400", hash_original_field = "79AC738350B55062D8BE39604A4D333F", hash_generated_field = "7E86192626B20953FA1B583614101236")

    public static final int LOG_ID_MAIN = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:44.917 -0400", hash_original_field = "9E1ECB1B07074063EAD437D86EF6B3AD", hash_generated_field = "E89D862BC59B25829A8E08E5B964FC9E")

    public static final int LOG_ID_RADIO = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:44.917 -0400", hash_original_field = "FAA78458B5500C2103973A96E9E071A2", hash_generated_field = "4947723A852DD11847F2EDCCBC616E97")

    public static final int LOG_ID_EVENTS = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:44.917 -0400", hash_original_field = "01DCA39D17DAA065D26E61F28B010BD3", hash_generated_field = "DBE2B7C9E039730F0529887D92D731CF")

    public static final int LOG_ID_SYSTEM = 3;
}

