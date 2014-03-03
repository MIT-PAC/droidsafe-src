package android.util;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.UnknownHostException;

import com.android.internal.os.RuntimeInit;

import droidsafe.helpers.DSUtils;

public final class Log {

    /**
     * Send a {@link #VERBOSE} log message.
     * @param tag Used to identify the source of a log message.  It usually identifies
     *        the class or activity where the log call occurs.
     * @param msg The message you would like logged.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSSink({DSSinkKind.LOG})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:20.085 -0500", hash_original_method = "3D050B3246ABFA92814436071545CB13", hash_generated_method = "A1B3C1896BBBEB497B7178CE2AB2F833")
    
public static int v(String tag, String msg) {
        return println_native(LOG_ID_MAIN, VERBOSE, tag, msg);
    }

    /**
     * Send a {@link #VERBOSE} log message and log the exception.
     * @param tag Used to identify the source of a log message.  It usually identifies
     *        the class or activity where the log call occurs.
     * @param msg The message you would like logged.
     * @param tr An exception to log
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSSink({DSSinkKind.LOG})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:20.088 -0500", hash_original_method = "6371CCA1AACEE15A82F0B64483CB973F", hash_generated_method = "A2C9957C0FB31C6DFA21C0116F594BB3")
    
public static int v(String tag, String msg, Throwable tr) {
        return println_native(LOG_ID_MAIN, VERBOSE, tag, msg + '\n' + getStackTraceString(tr));
    }

    /**
     * Send a {@link #DEBUG} log message.
     * @param tag Used to identify the source of a log message.  It usually identifies
     *        the class or activity where the log call occurs.
     * @param msg The message you would like logged.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSSink({DSSinkKind.LOG})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:20.091 -0500", hash_original_method = "AFD39BBB2869311A4545E6AF5E18494B", hash_generated_method = "0C5D5AC5212DF40B5E19C863CBCB39D4")
    
public static int d(String tag, String msg) {
        return println_native(LOG_ID_MAIN, DEBUG, tag, msg);
    }

    /**
     * Send a {@link #DEBUG} log message and log the exception.
     * @param tag Used to identify the source of a log message.  It usually identifies
     *        the class or activity where the log call occurs.
     * @param msg The message you would like logged.
     * @param tr An exception to log
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSSink({DSSinkKind.LOG})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:20.093 -0500", hash_original_method = "4492C71DA07A18BB6C5A18B63CA7FEE4", hash_generated_method = "1A551339626D67B9608E3578A9C1C58D")
    
public static int d(String tag, String msg, Throwable tr) {
        return println_native(LOG_ID_MAIN, DEBUG, tag, msg + '\n' + getStackTraceString(tr));
    }

    /**
     * Send an {@link #INFO} log message.
     * @param tag Used to identify the source of a log message.  It usually identifies
     *        the class or activity where the log call occurs.
     * @param msg The message you would like logged.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSSink({DSSinkKind.LOG})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:20.095 -0500", hash_original_method = "90D3F6175B896C0304A3EF3A595CA2C2", hash_generated_method = "738EAED8F13FB872BEC6302B30228D6D")
    
public static int i(String tag, String msg) {
        return println_native(LOG_ID_MAIN, INFO, tag, msg);
    }

    /**
     * Send a {@link #INFO} log message and log the exception.
     * @param tag Used to identify the source of a log message.  It usually identifies
     *        the class or activity where the log call occurs.
     * @param msg The message you would like logged.
     * @param tr An exception to log
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSSink({DSSinkKind.LOG})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:20.097 -0500", hash_original_method = "D380393FD3C099B2671AFD42E854EB56", hash_generated_method = "5C503D9C65E03A67736F030C07E440ED")
    
public static int i(String tag, String msg, Throwable tr) {
        return println_native(LOG_ID_MAIN, INFO, tag, msg + '\n' + getStackTraceString(tr));
    }

    /**
     * Send a {@link #WARN} log message.
     * @param tag Used to identify the source of a log message.  It usually identifies
     *        the class or activity where the log call occurs.
     * @param msg The message you would like logged.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSSink({DSSinkKind.LOG})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:20.100 -0500", hash_original_method = "BB8A0F0F374EC19DB78F36BE9CB1080F", hash_generated_method = "7631A992905D8C63EED62786A2C0603F")
    
public static int w(String tag, String msg) {
        return println_native(LOG_ID_MAIN, WARN, tag, msg);
    }

    /**
     * Send a {@link #WARN} log message and log the exception.
     * @param tag Used to identify the source of a log message.  It usually identifies
     *        the class or activity where the log call occurs.
     * @param msg The message you would like logged.
     * @param tr An exception to log
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSSink({DSSinkKind.LOG})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:20.102 -0500", hash_original_method = "56EF6624BA8DC40BA895131478A46CEE", hash_generated_method = "B9EE69E711B13C584EF8EBF2A38ED5F5")
    
public static int w(String tag, String msg, Throwable tr) {
        return println_native(LOG_ID_MAIN, WARN, tag, msg + '\n' + getStackTraceString(tr));
    }
    
    @DSComment("Android logging subsystem")
    @DSSpec(DSCat.LOGGING)
    public static boolean isLoggable(String tag, int level) {
        return (tag.getTaintInt() > level);
    }

    /*
     * Send a {@link #WARN} log message and log the exception.
     * @param tag Used to identify the source of a log message.  It usually identifies
     *        the class or activity where the log call occurs.
     * @param tr An exception to log
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSSink({DSSinkKind.LOG})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:20.108 -0500", hash_original_method = "FC76D95DCCFE80C9D53EB09BCEAF8146", hash_generated_method = "3E09D34AC66462E0DA241E5B3631A611")
    
public static int w(String tag, Throwable tr) {
        return println_native(LOG_ID_MAIN, WARN, tag, getStackTraceString(tr));
    }

    /**
     * Send an {@link #ERROR} log message.
     * @param tag Used to identify the source of a log message.  It usually identifies
     *        the class or activity where the log call occurs.
     * @param msg The message you would like logged.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSSink({DSSinkKind.LOG})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:20.110 -0500", hash_original_method = "CCAD4AAF1B926E5A09DC6FEC20772811", hash_generated_method = "CDD9A8498CAE7BCCD00E7EBAC1BC7B11")
    
public static int e(String tag, String msg) {
        return println_native(LOG_ID_MAIN, ERROR, tag, msg);
    }

    /**
     * Send a {@link #ERROR} log message and log the exception.
     * @param tag Used to identify the source of a log message.  It usually identifies
     *        the class or activity where the log call occurs.
     * @param msg The message you would like logged.
     * @param tr An exception to log
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSSink({DSSinkKind.LOG})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:20.112 -0500", hash_original_method = "0E0F39B47315805DA235DB6910E951BD", hash_generated_method = "E9C2958DD82B5B86E3A87143494051BA")
    
public static int e(String tag, String msg, Throwable tr) {
        return println_native(LOG_ID_MAIN, ERROR, tag, msg + '\n' + getStackTraceString(tr));
    }

    /**
     * What a Terrible Failure: Report a condition that should never happen.
     * The error will always be logged at level ASSERT with the call stack.
     * Depending on system configuration, a report may be added to the
     * {@link android.os.DropBoxManager} and/or the process may be terminated
     * immediately with an error dialog.
     * @param tag Used to identify the source of a log message.
     * @param msg The message you would like logged.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:20.115 -0500", hash_original_method = "55ECF3B8141D5A99D3F9726C340DA85F", hash_generated_method = "BABAA912F5D364975590475B974ACC91")
    
public static int wtf(String tag, String msg) {
        return wtf(tag, msg, null);
    }

    /**
     * What a Terrible Failure: Report an exception that should never happen.
     * Similar to {@link #wtf(String, String)}, with an exception to log.
     * @param tag Used to identify the source of a log message.
     * @param tr An exception to log.
     */
    @DSComment("Android logging subsystem")
    @DSSpec(DSCat.LOGGING)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:20.117 -0500", hash_original_method = "3EB47F02741364EE89C039A374330D1C", hash_generated_method = "B8CF05BFB9704480A0617E7DE2815CF3")
    
public static int wtf(String tag, Throwable tr) {
        return wtf(tag, tr.getMessage(), tr);
    }

    /**
     * What a Terrible Failure: Report an exception that should never happen.
     * Similar to {@link #wtf(String, Throwable)}, with a message as well.
     * @param tag Used to identify the source of a log message.
     * @param msg The message you would like logged.
     * @param tr An exception to log.  May be null.
     */
    @DSSink({DSSinkKind.LOG})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:20.119 -0500", hash_original_method = "181C11BE6032133F9C5410C68DB86F4F", hash_generated_method = "9436003A1F0DDF141A169F89BD484EDA")
    
public static int wtf(String tag, String msg, Throwable tr) {
        TerribleFailure what = new TerribleFailure(msg, tr);
        int bytes = println_native(LOG_ID_MAIN, ASSERT, tag, msg + '\n' + getStackTraceString(tr));
        sWtfHandler.onTerribleFailure(tag, what);
        return bytes;
    }

    /**
     * Sets the terrible failure handler, for testing.
     *
     * @return the old handler
     *
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:20.122 -0500", hash_original_method = "C5025C206AD728CD6E603988CFF92F85", hash_generated_method = "9BE36ECEB34DE367488E4246F0618293")
    
public static TerribleFailureHandler setWtfHandler(TerribleFailureHandler handler) {
        if (handler == null) {
            throw new NullPointerException("handler == null");
        }
        TerribleFailureHandler oldHandler = sWtfHandler;
        sWtfHandler = handler;
        return oldHandler;
    }

    /**
     * Handy function to get a loggable stack trace from a Throwable
     * @param tr An exception to log
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:20.125 -0500", hash_original_method = "7719F1A14DFF815E0B66B3EB7CF1C00E", hash_generated_method = "16AFC01DBED706B77B6A4AB015FDC5BD")
    
public static String getStackTraceString(Throwable tr) {
        if (tr == null) {
            return "";
        }

        // This is to reduce the amount of log spew that apps do in the non-error
        // condition of the network being unavailable.
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

    /**
     * Low-level logging call.
     * @param priority The priority/type of this log message
     * @param tag Used to identify the source of a log message.  It usually identifies
     *        the class or activity where the log call occurs.
     * @param msg The message you would like logged.
     * @return The number of bytes written.
     */
    @DSComment("IO movement methodName")
    @DSSpec(DSCat.IO_ACTION_METHOD)
    @DSSink({DSSinkKind.LOG})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:20.127 -0500", hash_original_method = "5FBBD39B6D46109F46B6F9786F21DE2B", hash_generated_method = "BA41CA312351027D578A271A03AF5AC6")
    
public static int println(int priority, String tag, String msg) {
        return println_native(LOG_ID_MAIN, priority, tag, msg);
    }
    
    public static int println_native(int bufID,
            int priority, String tag, String msg) {
        return (bufID + priority + tag.getTaintInt() + msg.getTaintInt());
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:20.057 -0500", hash_original_field = "F56CF3B1687883ED2E2E2F2BEB496CD9", hash_generated_field = "183ECC1630CBD890D38268E5859FD6F6")

    public static final int VERBOSE = 2;
    
    private static class TerribleFailure extends Exception {
        @DSComment("Package priviledge")
        @DSBan(DSCat.DEFAULT_MODIFIER)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:20.072 -0500", hash_original_method = "0F8223B52B3C6FF6727F78AC7E36D4B8", hash_generated_method = "0F8223B52B3C6FF6727F78AC7E36D4B8")
        
TerribleFailure(String msg, Throwable cause) { super(msg, cause); }
        
    }
    
    public interface TerribleFailureHandler {
        void onTerribleFailure(String tag, TerribleFailure what);
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:20.060 -0500", hash_original_field = "B144CD9705E3AC63274D417A61CE1D03", hash_generated_field = "26AABFCC751A881E695E902E0608E346")

    public static final int DEBUG = 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:20.062 -0500", hash_original_field = "C860C995A9AFA74B4B8C41E7BFBB1983", hash_generated_field = "6A8CBF4155F7D9169D37C74D4C14F8A9")

    public static final int INFO = 4;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:20.065 -0500", hash_original_field = "4E1517959C98EBF5F0F632F1C3274A8B", hash_generated_field = "6A26B7A055D881912AAB57C2278AA725")

    public static final int WARN = 5;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:20.067 -0500", hash_original_field = "FFF95B6A33E6D621BE46667F83F04316", hash_generated_field = "B6B991924F4F8C2A773B84BA83915632")

    public static final int ERROR = 6;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:20.069 -0500", hash_original_field = "43039C31AC83C2B46EA061924323B654", hash_generated_field = "9BB2A0262D13A08A51875E90349F0239")

    public static final int ASSERT = 7;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.354 -0400", hash_original_field = "1A1695BDB6E58ED53BC49925AFADC824", hash_generated_field = "EB9AD5727A6FE358590060E6265767B7")

    private static TerribleFailureHandler sWtfHandler = new TerribleFailureHandler() {
    	
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.354 -0400", hash_original_method = "90BA23F8182E406DC4D5C312FC444694", hash_generated_method = "4C8A9452FEB3740EEFD06B4E1BFB8698")
        public void onTerribleFailure(String tag, TerribleFailure what) {
            
            RuntimeInit.wtf(tag, what);
            addTaint(tag.getTaint());
            addTaint(what.getTaint());
            
        }
        
};
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:20.129 -0500", hash_original_field = "83BD1ED71CEFBE3B95929AA2F3198EB2", hash_generated_field = "7E86192626B20953FA1B583614101236")
 public static final int LOG_ID_MAIN = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:20.132 -0500", hash_original_field = "B472FBC86E68DA0F66AF47B72D3BD5F9", hash_generated_field = "E89D862BC59B25829A8E08E5B964FC9E")
 public static final int LOG_ID_RADIO = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:20.135 -0500", hash_original_field = "ED1311B52E952C9495AB4AD0697FBDEB", hash_generated_field = "4947723A852DD11847F2EDCCBC616E97")
 public static final int LOG_ID_EVENTS = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:20.138 -0500", hash_original_field = "48E6934BA361DE3880FF894B984C6ED6", hash_generated_field = "DBE2B7C9E039730F0529887D92D731CF")
 public static final int LOG_ID_SYSTEM = 3;

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:20.083 -0500", hash_original_method = "869367D375FC874369E92ACB08C85ECE", hash_generated_method = "FA91EC1506EF8966CF2A314916866116")
    
private Log() {
    }
}

