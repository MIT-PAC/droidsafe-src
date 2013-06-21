package com.android.internal.os;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.app.ActivityManagerNative;
import android.app.ApplicationErrorReport;
import android.os.Build;
import android.os.Debug;
import android.os.IBinder;
import android.os.Process;
import android.os.SystemProperties;
import android.util.Log;
import android.util.Slog;
import com.android.internal.logging.AndroidConfig;
import com.android.server.NetworkManagementSocketTagger;
import dalvik.system.VMRuntime;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.TimeZone;
import java.util.logging.LogManager;
import org.apache.harmony.luni.internal.util.TimezoneGetter;

public class RuntimeInit {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.267 -0400", hash_original_method = "8FA505D683EF3586614AABD2B679262A", hash_generated_method = "8FA505D683EF3586614AABD2B679262A")
        public RuntimeInit ()
    {
    }


        private static final void commonInit() {
        if (DEBUG) Slog.d(TAG, "Entered RuntimeInit!");
        Thread.setDefaultUncaughtExceptionHandler(new UncaughtHandler());
        int hasQwerty = getQwertyKeyboard();
        if (DEBUG) Slog.d(TAG, ">>>>> qwerty keyboard = " + hasQwerty);
        if (hasQwerty == 1) {
            System.setProperty("qwerty", "1");
        }
        TimezoneGetter.setInstance(new TimezoneGetter() {
            @Override
            public String getId() {
                return SystemProperties.get("persist.sys.timezone");
            }
        });
        TimeZone.setDefault(null);
        LogManager.getLogManager().reset();
        new AndroidConfig();
        String userAgent = getDefaultUserAgent();
        System.setProperty("http.agent", userAgent);
        NetworkManagementSocketTagger.install();
        String trace = SystemProperties.get("ro.kernel.android.tracing");
        if (trace.equals("1")) {
            Slog.i(TAG, "NOTE: emulator trace profiling enabled");
            Debug.enableEmulatorTraceOutput();
        }
        initialized = true;
    }

    
        private static String getDefaultUserAgent() {
        StringBuilder result = new StringBuilder(64);
        result.append("Dalvik/");
        result.append(System.getProperty("java.vm.version"));
        result.append(" (Linux; U; Android ");
        String version = Build.VERSION.RELEASE;
        result.append(version.length() > 0 ? version : "1.0");
        if ("REL".equals(Build.VERSION.CODENAME)) {
            String model = Build.MODEL;
            if (model.length() > 0) {
                result.append("; ");
                result.append(model);
            }
        }
        String id = Build.ID;
        if (id.length() > 0) {
            result.append(" Build/");
            result.append(id);
        }
        result.append(")");
        return result.toString();
    }

    
        private static void invokeStaticMain(String className, String[] argv) throws ZygoteInit.MethodAndArgsCaller {
        Class<?> cl;
        try {
            cl = Class.forName(className);
        } catch (ClassNotFoundException ex) {
            throw new RuntimeException(
                    "Missing class when invoking static main " + className,
                    ex);
        }
        Method m;
        try {
            m = cl.getMethod("main", new Class[] { String[].class });
        } catch (NoSuchMethodException ex) {
            throw new RuntimeException(
                    "Missing static main on " + className, ex);
        } catch (SecurityException ex) {
            throw new RuntimeException(
                    "Problem getting static main on " + className, ex);
        }
        int modifiers = m.getModifiers();
        if (! (Modifier.isStatic(modifiers) && Modifier.isPublic(modifiers))) {
            throw new RuntimeException(
                    "Main method is not public and static on " + className);
        }
        throw new ZygoteInit.MethodAndArgsCaller(m, argv);
    }

    
        public static final void main(String[] argv) {
        if (argv.length == 2 && argv[1].equals("application")) {
            if (DEBUG) Slog.d(TAG, "RuntimeInit: Starting application");
            redirectLogStreams();
        } else {
            if (DEBUG) Slog.d(TAG, "RuntimeInit: Starting tool");
        }
        commonInit();
        finishInit();
        if (DEBUG) Slog.d(TAG, "Leaving RuntimeInit!");
    }

    
        public static final void finishInit() {
    }

    
        public static final void zygoteInit(int targetSdkVersion, String[] argv) throws ZygoteInit.MethodAndArgsCaller {
        if (DEBUG) Slog.d(TAG, "RuntimeInit: Starting application from zygote");
        redirectLogStreams();
        commonInit();
        zygoteInitNative();
        applicationInit(targetSdkVersion, argv);
    }

    
        public static void wrapperInit(int targetSdkVersion, String[] argv) throws ZygoteInit.MethodAndArgsCaller {
        if (DEBUG) Slog.d(TAG, "RuntimeInit: Starting application from wrapper");
        applicationInit(targetSdkVersion, argv);
    }

    
        private static void applicationInit(int targetSdkVersion, String[] argv) throws ZygoteInit.MethodAndArgsCaller {
        VMRuntime.getRuntime().setTargetHeapUtilization(0.75f);
        VMRuntime.getRuntime().setTargetSdkVersion(targetSdkVersion);
        final Arguments args;
        try {
            args = new Arguments(argv);
        } catch (IllegalArgumentException ex) {
            Slog.e(TAG, ex.getMessage());
            return;
        }
        invokeStaticMain(args.startClass, args.startArgs);
    }

    
        public static void redirectLogStreams() {
        System.out.close();
        System.setOut(new AndroidPrintStream(Log.INFO, "System.out"));
        System.err.close();
        System.setErr(new AndroidPrintStream(Log.WARN, "System.err"));
    }

    
        public static final void zygoteInitNative() {
    }

    
        public static final int isComputerOn() {
        return DSUtils.UNKNOWN_INT;
    }

    
        public static final void turnComputerOn() {
    }

    
        public static int getQwertyKeyboard() {
        return DSUtils.UNKNOWN_INT;
    }

    
        public static void wtf(String tag, Throwable t) {
        try {
            if (ActivityManagerNative.getDefault().handleApplicationWtf(
                    mApplicationObject, tag, new ApplicationErrorReport.CrashInfo(t))) {
                Process.killProcess(Process.myPid());
                System.exit(10);
            }
        } catch (Throwable t2) {
            Slog.e(TAG, "Error reporting WTF", t2);
        }
    }

    
        public static final void setApplicationObject(IBinder app) {
        mApplicationObject = app;
    }

    
        public static final IBinder getApplicationObject() {
        return mApplicationObject;
    }

    
    private static class UncaughtHandler implements Thread.UncaughtExceptionHandler {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.269 -0400", hash_original_method = "B53C81BF9A0D31B4E959B1B00E82AE28", hash_generated_method = "B53C81BF9A0D31B4E959B1B00E82AE28")
                public UncaughtHandler ()
        {
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.270 -0400", hash_original_method = "498D7614C18F40B02B7387DE4641DDCF", hash_generated_method = "CEEDD02AE7393626C581464EB8E8D852")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void uncaughtException(Thread t, Throwable e) {
            dsTaint.addTaint(e.dsTaint);
            dsTaint.addTaint(t.dsTaint);
            try 
            {
                mCrashing = true;
                ActivityManagerNative.getDefault().handleApplicationCrash(
                        mApplicationObject, new ApplicationErrorReport.CrashInfo(e));
            } //End block
            catch (Throwable t2)
            { }
            finally 
            {
                Process.killProcess(Process.myPid());
                System.exit(10);
            } //End block
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
    }


    
    static class Arguments {
        String startClass;
        String[] startArgs;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.270 -0400", hash_original_method = "35BDC5101A4DE38616FDCE6EF4D8CA10", hash_generated_method = "7C3C468C8855B70D2E2F10F8CC7B8088")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         Arguments(String args[]) throws IllegalArgumentException {
            dsTaint.addTaint(args);
            parseArgs(args);
            // ---------- Original Method ----------
            //parseArgs(args);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.270 -0400", hash_original_method = "8231389587D8A1396F36A075174F3D3F", hash_generated_method = "294CFBDC0BE35FBD72BB51C968F0794B")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private void parseArgs(String args[]) throws IllegalArgumentException {
            dsTaint.addTaint(args);
            int curArg;
            curArg = 0;
            {
                String arg;
                arg = args[curArg];
                {
                    boolean var566DD555814D764ED9A29C42F8874316_875650150 = (arg.equals("--"));
                    {
                        boolean var8DF5AAC12FA4329A4CC6BF5AA3E9BEE4_451439068 = (!arg.startsWith("--"));
                    } //End collapsed parenthetic
                } //End collapsed parenthetic
            } //End block
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Missing classname argument to RuntimeInit!");
            } //End block
            startClass = args[curArg++];
            startArgs = new String[args.length - curArg];
            System.arraycopy(args, curArg, startArgs, 0, startArgs.length);
            // ---------- Original Method ----------
            //int curArg = 0;
            //for (; curArg < args.length; curArg++) {
                //String arg = args[curArg];
                //if (arg.equals("--")) {
                    //curArg++;
                    //break;
                //} else if (!arg.startsWith("--")) {
                    //break;
                //}
            //}
            //if (curArg == args.length) {
                //throw new IllegalArgumentException("Missing classname argument to RuntimeInit!");
            //}
            //startClass = args[curArg++];
            //startArgs = new String[args.length - curArg];
            //System.arraycopy(args, curArg, startArgs, 0, startArgs.length);
        }

        
    }


    
    private final static String TAG = "AndroidRuntime";
    private final static boolean DEBUG = false;
    private static boolean initialized;
    private static IBinder mApplicationObject;
    private static volatile boolean mCrashing = false;
    static {
        android.ddm.DdmRegister.registerHandlers();
    }
    
}

