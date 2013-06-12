package android.util;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import com.android.internal.os.RuntimeInit;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.UnknownHostException;

public final class Log {
    public static final int VERBOSE = 2;
    public static final int DEBUG = 3;
    public static final int INFO = 4;
    public static final int WARN = 5;
    public static final int ERROR = 6;
    public static final int ASSERT = 7;
    private static TerribleFailureHandler sWtfHandler = new TerribleFailureHandler() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.612 -0400", hash_original_method = "90BA23F8182E406DC4D5C312FC444694", hash_generated_method = "74B9AF387B092AE9B7EEF9AEF1452618")
        @DSModeled(DSC.SAFE)
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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.613 -0400", hash_original_method = "869367D375FC874369E92ACB08C85ECE", hash_generated_method = "46FAEB94D03632495F7D979B8112BD48")
    @DSModeled(DSC.SAFE)
    private Log() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.613 -0400", hash_original_method = "3D050B3246ABFA92814436071545CB13", hash_generated_method = "A1B3C1896BBBEB497B7178CE2AB2F833")
    public static int v(String tag, String msg) {
        return println_native(LOG_ID_MAIN, VERBOSE, tag, msg);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.613 -0400", hash_original_method = "6371CCA1AACEE15A82F0B64483CB973F", hash_generated_method = "A2C9957C0FB31C6DFA21C0116F594BB3")
    public static int v(String tag, String msg, Throwable tr) {
        return println_native(LOG_ID_MAIN, VERBOSE, tag, msg + '\n' + getStackTraceString(tr));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.613 -0400", hash_original_method = "AFD39BBB2869311A4545E6AF5E18494B", hash_generated_method = "0C5D5AC5212DF40B5E19C863CBCB39D4")
    public static int d(String tag, String msg) {
        return println_native(LOG_ID_MAIN, DEBUG, tag, msg);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.613 -0400", hash_original_method = "4492C71DA07A18BB6C5A18B63CA7FEE4", hash_generated_method = "1A551339626D67B9608E3578A9C1C58D")
    public static int d(String tag, String msg, Throwable tr) {
        return println_native(LOG_ID_MAIN, DEBUG, tag, msg + '\n' + getStackTraceString(tr));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.613 -0400", hash_original_method = "90D3F6175B896C0304A3EF3A595CA2C2", hash_generated_method = "738EAED8F13FB872BEC6302B30228D6D")
    public static int i(String tag, String msg) {
        return println_native(LOG_ID_MAIN, INFO, tag, msg);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.613 -0400", hash_original_method = "D380393FD3C099B2671AFD42E854EB56", hash_generated_method = "5C503D9C65E03A67736F030C07E440ED")
    public static int i(String tag, String msg, Throwable tr) {
        return println_native(LOG_ID_MAIN, INFO, tag, msg + '\n' + getStackTraceString(tr));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.613 -0400", hash_original_method = "BB8A0F0F374EC19DB78F36BE9CB1080F", hash_generated_method = "7631A992905D8C63EED62786A2C0603F")
    public static int w(String tag, String msg) {
        return println_native(LOG_ID_MAIN, WARN, tag, msg);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.613 -0400", hash_original_method = "56EF6624BA8DC40BA895131478A46CEE", hash_generated_method = "B9EE69E711B13C584EF8EBF2A38ED5F5")
    public static int w(String tag, String msg, Throwable tr) {
        return println_native(LOG_ID_MAIN, WARN, tag, msg + '\n' + getStackTraceString(tr));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.613 -0400", hash_original_method = "873107C82EDD6211442BDDC38602BB04", hash_generated_method = "5D338F4B13F848F038341FD416A4C73B")
    public static boolean isLoggable(String tag, int level) {
       DSTaintObject taint = new DSTaintObject();
       taint.addTaint(tag);
       taint.addTaint(level);
       return taint.getTaintBoolean();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.613 -0400", hash_original_method = "FC76D95DCCFE80C9D53EB09BCEAF8146", hash_generated_method = "3E09D34AC66462E0DA241E5B3631A611")
    public static int w(String tag, Throwable tr) {
        return println_native(LOG_ID_MAIN, WARN, tag, getStackTraceString(tr));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.613 -0400", hash_original_method = "CCAD4AAF1B926E5A09DC6FEC20772811", hash_generated_method = "CDD9A8498CAE7BCCD00E7EBAC1BC7B11")
    public static int e(String tag, String msg) {
        return println_native(LOG_ID_MAIN, ERROR, tag, msg);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.613 -0400", hash_original_method = "0E0F39B47315805DA235DB6910E951BD", hash_generated_method = "E9C2958DD82B5B86E3A87143494051BA")
    public static int e(String tag, String msg, Throwable tr) {
        return println_native(LOG_ID_MAIN, ERROR, tag, msg + '\n' + getStackTraceString(tr));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.613 -0400", hash_original_method = "55ECF3B8141D5A99D3F9726C340DA85F", hash_generated_method = "BABAA912F5D364975590475B974ACC91")
    public static int wtf(String tag, String msg) {
        return wtf(tag, msg, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.613 -0400", hash_original_method = "3EB47F02741364EE89C039A374330D1C", hash_generated_method = "B8CF05BFB9704480A0617E7DE2815CF3")
    public static int wtf(String tag, Throwable tr) {
        return wtf(tag, tr.getMessage(), tr);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.614 -0400", hash_original_method = "181C11BE6032133F9C5410C68DB86F4F", hash_generated_method = "9436003A1F0DDF141A169F89BD484EDA")
    public static int wtf(String tag, String msg, Throwable tr) {
        TerribleFailure what = new TerribleFailure(msg, tr);
        int bytes = println_native(LOG_ID_MAIN, ASSERT, tag, msg + '\n' + getStackTraceString(tr));
        sWtfHandler.onTerribleFailure(tag, what);
        return bytes;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.614 -0400", hash_original_method = "C5025C206AD728CD6E603988CFF92F85", hash_generated_method = "9BE36ECEB34DE367488E4246F0618293")
    public static TerribleFailureHandler setWtfHandler(TerribleFailureHandler handler) {
        if (handler == null) {
            throw new NullPointerException("handler == null");
        }
        TerribleFailureHandler oldHandler = sWtfHandler;
        sWtfHandler = handler;
        return oldHandler;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.614 -0400", hash_original_method = "7719F1A14DFF815E0B66B3EB7CF1C00E", hash_generated_method = "687A80411C18F006B563D00B8EE15272")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.614 -0400", hash_original_method = "5FBBD39B6D46109F46B6F9786F21DE2B", hash_generated_method = "BA41CA312351027D578A271A03AF5AC6")
    public static int println(int priority, String tag, String msg) {
        return println_native(LOG_ID_MAIN, priority, tag, msg);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.614 -0400", hash_original_method = "7DFDDA5AD50B686185205D310279ADBE", hash_generated_method = "953AA5B9198D9E68F1460CA78BEB6169")
    public static int println_native(int bufID,
            int priority, String tag, String msg) {
    	DSTaintObject taint = new DSTaintObject();
    	taint.addTaint(bufID);
    	taint.addTaint(priority);
    	taint.addTaint(tag);
    	taint.addTaint(msg);
    	return taint.getTaintInt();
    }

    
    private static class TerribleFailure extends Exception {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.614 -0400", hash_original_method = "0F8223B52B3C6FF6727F78AC7E36D4B8", hash_generated_method = "1708394E37E8CFF47073196AB4A7509B")
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
    
}


