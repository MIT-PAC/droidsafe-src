package com.android.internal.os;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
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
    private final static String TAG = "AndroidRuntime";
    private final static boolean DEBUG = false;
    private static boolean initialized;
    private static IBinder mApplicationObject;
    private static volatile boolean mCrashing = false;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.507 -0400", hash_original_method = "C7622073E000BE2542D010C6F669959A", hash_generated_method = "0F7283DD5B1D5A8E1D0A188173CF23E2")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.507 -0400", hash_original_method = "CC6D52B1B7C2781118F4D0CDEF717B7F", hash_generated_method = "C4402346D71F8732F23F83F88CEF82EA")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.507 -0400", hash_original_method = "57D106C9A5F0931B48EF6F0A7020131B", hash_generated_method = "4C998226B45D2E3DA3AF8E5EF973DF68")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.508 -0400", hash_original_method = "0D2BE4D132F751EADEC03AA29790EAA4", hash_generated_method = "ABCB09B3E54079D7988C39D3AD722689")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.508 -0400", hash_original_method = "D51E063D25A9A593EA85107D265AF500", hash_generated_method = "9AF480968228D8982F99D7BF6294DDE1")
    public static final void finishInit() {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.508 -0400", hash_original_method = "9881403720ADE533F77BFD7C116DE8A0", hash_generated_method = "0F2DC0835E1E6FB890D0373B8BD49B08")
    public static final void zygoteInit(int targetSdkVersion, String[] argv) throws ZygoteInit.MethodAndArgsCaller {
        if (DEBUG) Slog.d(TAG, "RuntimeInit: Starting application from zygote");
        redirectLogStreams();
        commonInit();
        zygoteInitNative();
        applicationInit(targetSdkVersion, argv);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.508 -0400", hash_original_method = "7C54E6389E453FD515994E6002004E39", hash_generated_method = "DD353CABA71F1E8C54F83BBAC5481E24")
    public static void wrapperInit(int targetSdkVersion, String[] argv) throws ZygoteInit.MethodAndArgsCaller {
        if (DEBUG) Slog.d(TAG, "RuntimeInit: Starting application from wrapper");
        applicationInit(targetSdkVersion, argv);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.508 -0400", hash_original_method = "ED4327773C53459AF7AFC1B9F1BFFE58", hash_generated_method = "2C41044E677847F4F9BDC4E5D3F60005")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.508 -0400", hash_original_method = "64B494D57495388AEA3A29297F0CBFFC", hash_generated_method = "7764F224334641D2EC0D60CEFC73A728")
    public static void redirectLogStreams() {
        System.out.close();
        System.setOut(new AndroidPrintStream(Log.INFO, "System.out"));
        System.err.close();
        System.setErr(new AndroidPrintStream(Log.WARN, "System.err"));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.508 -0400", hash_original_method = "91BBEC41258DFFA85DCB213BCB4DC261", hash_generated_method = "C9E5E3AB0504E929FBB2BF9966737E71")
    public static final void zygoteInitNative() {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.508 -0400", hash_original_method = "76F7A412389CABA7F8329E0CB5FF98BF", hash_generated_method = "2D006B9C854C1ECEB9369CAFDF736538")
    public static final int isComputerOn() {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.508 -0400", hash_original_method = "76E983410690A2E7AFF71EEDA1953A5E", hash_generated_method = "62537200EB0B8D1400159363C99E546F")
    public static final void turnComputerOn() {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.508 -0400", hash_original_method = "80850FD56CCC8C357FAF2C7CA0EE8D4D", hash_generated_method = "7DA705C2B0817D061D63A86D69E24E23")
    public static int getQwertyKeyboard() {
        //DSFIXME:  CODE0010: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.508 -0400", hash_original_method = "F1B813BD238681733DAFF269616C7CF7", hash_generated_method = "597CC66B8FCDEB50DCE5E7DB71935293")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.508 -0400", hash_original_method = "C39B9D61998C599A14A36C909D0DA77C", hash_generated_method = "2C53FFB7E4C7DA857CF12AA53B22AC75")
    public static final void setApplicationObject(IBinder app) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        mApplicationObject = app;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.508 -0400", hash_original_method = "E901955560D4A31547FD724447878F67", hash_generated_method = "63B85B6EE2E19E094367613A554AA043")
    public static final IBinder getApplicationObject() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        return mApplicationObject;
    }

    
    private static class UncaughtHandler implements Thread.UncaughtExceptionHandler {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.508 -0400", hash_original_method = "498D7614C18F40B02B7387DE4641DDCF", hash_generated_method = "586C1810C06A6E9DF8BDD2C555791876")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void uncaughtException(Thread t, Throwable e) {
            dsTaint.addTaint(t.dsTaint);
            dsTaint.addTaint(e.dsTaint);
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
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.508 -0400", hash_original_method = "35BDC5101A4DE38616FDCE6EF4D8CA10", hash_generated_method = "C586DB6497FC7C5ABF3068A4E2FBB92A")
        @DSModeled(DSC.SAFE)
         Arguments(String args[]) throws IllegalArgumentException {
            dsTaint.addTaint(args);
            parseArgs(args);
            // ---------- Original Method ----------
            //parseArgs(args);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.508 -0400", hash_original_method = "8231389587D8A1396F36A075174F3D3F", hash_generated_method = "1753E5268CC4771E367F3AC9DBCDB1E6")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private void parseArgs(String args[]) throws IllegalArgumentException {
            dsTaint.addTaint(args);
            int curArg;
            curArg = 0;
            {
                String arg;
                arg = args[curArg];
                {
                    boolean var566DD555814D764ED9A29C42F8874316_1599367637 = (arg.equals("--"));
                    {
                        curArg++;
                    } //End block
                    {
                        boolean var8DF5AAC12FA4329A4CC6BF5AA3E9BEE4_129284368 = (!arg.startsWith("--"));
                    } //End collapsed parenthetic
                } //End collapsed parenthetic
            } //End block
            {
                throw new IllegalArgumentException("Missing classname argument to RuntimeInit!");
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


    
    static {
        android.ddm.DdmRegister.registerHandlers();
    }
    
}


