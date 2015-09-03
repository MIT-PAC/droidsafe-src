/*
 * Copyright (C) 2015,  Massachusetts Institute of Technology
 * 
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License as published by the
 * Free Software Foundation; either version 2 of the License, or (at your
 * option) any later version.
 * 
 * This program is distributed in the hope that it will be useful, but 
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 * or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * for more details.
 * 
 * You should have received a copy of the GNU General Public License along
 * with this program; if not, write to the Free Software Foundation, Inc., 
 * 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 * 
 * Please email droidsafe@lists.csail.mit.edu if you need additional
 * information or have any questions.
 * 
 * 
 * This file incorporates work covered by the following copyright and
 * permission notice:
 *
 * Copyright (C) 2006 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */


/***** THIS FILE HAS BEEN MODIFIED FROM THE ORIGINAL BY THE DROIDSAFE PROJECT. *****/


package com.android.internal.os;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.TimeZone;
import java.util.logging.LogManager;

import org.apache.harmony.luni.internal.util.TimezoneGetter;

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

import droidsafe.helpers.DSUtils;

public class RuntimeInit {

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:51.222 -0500", hash_original_method = "C7622073E000BE2542D010C6F669959A", hash_generated_method = "771018B1D01CA66B5C048E790F69C13F")
    
private static final void commonInit() {
        if (DEBUG) Slog.d(TAG, "Entered RuntimeInit!");

        /* set default handler; this applies to all threads in the VM */
        Thread.setDefaultUncaughtExceptionHandler(new UncaughtHandler());

        int hasQwerty = getQwertyKeyboard();

        if (DEBUG) Slog.d(TAG, ">>>>> qwerty keyboard = " + hasQwerty);
        if (hasQwerty == 1) {
            System.setProperty("qwerty", "1");
        }

        /*
         * Install a TimezoneGetter subclass for ZoneInfo.db
         */
        TimezoneGetter.setInstance(new TimezoneGetter() {
            @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @Override
            public String getId() {
                return SystemProperties.get("persist.sys.timezone");
            }
        });
        TimeZone.setDefault(null);

        /*
         * Sets handler for java.util.logging to use Android log facilities.
         * The odd "new instance-and-then-throw-away" is a mirror of how
         * the "java.util.logging.config.class" system property works. We
         * can't use the system property here since the logger has almost
         * certainly already been initialized.
         */
        LogManager.getLogManager().reset();
        new AndroidConfig();

        /*
         * Sets the default HTTP User-Agent used by HttpURLConnection.
         */
        String userAgent = getDefaultUserAgent();
        System.setProperty("http.agent", userAgent);

        /*
         * Wire socket tagging to traffic stats.
         */
        NetworkManagementSocketTagger.install();

        /*
         * If we're running in an emulator launched with "-trace", put the
         * VM into emulator trace profiling mode so that the user can hit
         * F9/F10 at any time to capture traces.  This has performance
         * consequences, so it's not something you want to do always.
         */
        String trace = SystemProperties.get("ro.kernel.android.tracing");
        if (trace.equals("1")) {
            Slog.i(TAG, "NOTE: emulator trace profiling enabled");
            Debug.enableEmulatorTraceOutput();
        }

        initialized = true;
    }

    /**
     * Returns an HTTP user agent of the form
     * "Dalvik/1.1.0 (Linux; U; Android Eclair Build/MASTER)".
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:51.224 -0500", hash_original_method = "CC6D52B1B7C2781118F4D0CDEF717B7F", hash_generated_method = "21BCD93CA8F78FB04BE6067E43347FE3")
    
private static String getDefaultUserAgent() {
        StringBuilder result = new StringBuilder(64);
        result.append("Dalvik/");
        result.append(System.getProperty("java.vm.version")); // such as 1.1.0
        result.append(" (Linux; U; Android ");

        String version = Build.VERSION.RELEASE; // "1.0" or "3.4b5"
        result.append(version.length() > 0 ? version : "1.0");

        // add the model for the release build
        if ("REL".equals(Build.VERSION.CODENAME)) {
            String model = Build.MODEL;
            if (model.length() > 0) {
                result.append("; ");
                result.append(model);
            }
        }
        String id = Build.ID; // "MASTER" or "M4-rc20"
        if (id.length() > 0) {
            result.append(" Build/");
            result.append(id);
        }
        result.append(")");
        return result.toString();
    }

    /**
     * Invokes a static "main(argv[]) method on class "className".
     * Converts various failing exceptions into RuntimeExceptions, with
     * the assumption that they will then cause the VM instance to exit.
     *
     * @param className Fully-qualified class name
     * @param argv Argument vector for main()
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:51.227 -0500", hash_original_method = "57D106C9A5F0931B48EF6F0A7020131B", hash_generated_method = "E6DC0239745199AB2318C248A870A99E")
    
private static void invokeStaticMain(String className, String[] argv)
            throws ZygoteInit.MethodAndArgsCaller {
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

        /*
         * This throw gets caught in ZygoteInit.main(), which responds
         * by invoking the exception's run() method. This arrangement
         * clears up all the stack frames that were required in setting
         * up the process.
         */
        throw new ZygoteInit.MethodAndArgsCaller(m, argv);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:51.230 -0500", hash_original_method = "0D2BE4D132F751EADEC03AA29790EAA4", hash_generated_method = "367D7E6B6EAEC19E1E850899BAEFFFF9")
    
public static final void main(String[] argv) {
        if (argv.length == 2 && argv[1].equals("application")) {
            if (DEBUG) Slog.d(TAG, "RuntimeInit: Starting application");
            redirectLogStreams();
        } else {
            if (DEBUG) Slog.d(TAG, "RuntimeInit: Starting tool");
        }

        commonInit();

        /*
         * Now that we're running in interpreted code, call back into native code
         * to run the system.
         */
        finishInit();

        if (DEBUG) Slog.d(TAG, "Leaving RuntimeInit!");
    }
    
    public static final void finishInit() {
    }

    /**
     * The main function called when started through the zygote process. This
     * could be unified with main(), if the native code in finishInit()
     * were rationalized with Zygote startup.<p>
     *
     * Current recognized args:
     * <ul>
     *   <li> <code> [--] &lt;start class name&gt;  &lt;args&gt;
     * </ul>
     *
     * @param targetSdkVersion target SDK version
     * @param argv arg strings
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:51.237 -0500", hash_original_method = "9881403720ADE533F77BFD7C116DE8A0", hash_generated_method = "0F2DC0835E1E6FB890D0373B8BD49B08")
    
public static final void zygoteInit(int targetSdkVersion, String[] argv)
            throws ZygoteInit.MethodAndArgsCaller {
        if (DEBUG) Slog.d(TAG, "RuntimeInit: Starting application from zygote");

        redirectLogStreams();

        commonInit();
        zygoteInitNative();

        applicationInit(targetSdkVersion, argv);
    }

    /**
     * The main function called when an application is started through a
     * wrapper process.
     *
     * When the wrapper starts, the runtime starts {@link RuntimeInit#main}
     * which calls {@link WrapperInit#main} which then calls this method.
     * So we don't need to call commonInit() here.
     *
     * @param targetSdkVersion target SDK version
     * @param argv arg strings
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:51.240 -0500", hash_original_method = "7C54E6389E453FD515994E6002004E39", hash_generated_method = "DD353CABA71F1E8C54F83BBAC5481E24")
    
public static void wrapperInit(int targetSdkVersion, String[] argv)
            throws ZygoteInit.MethodAndArgsCaller {
        if (DEBUG) Slog.d(TAG, "RuntimeInit: Starting application from wrapper");

        applicationInit(targetSdkVersion, argv);
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:51.242 -0500", hash_original_method = "ED4327773C53459AF7AFC1B9F1BFFE58", hash_generated_method = "51ABAE0A416A1BEAFBE4E8FEAC94ED8E")
    
private static void applicationInit(int targetSdkVersion, String[] argv)
            throws ZygoteInit.MethodAndArgsCaller {
        // We want to be fairly aggressive about heap utilization, to avoid
        // holding on to a lot of memory that isn't needed.
        VMRuntime.getRuntime().setTargetHeapUtilization(0.75f);
        VMRuntime.getRuntime().setTargetSdkVersion(targetSdkVersion);

        final Arguments args;
        try {
            args = new Arguments(argv);
        } catch (IllegalArgumentException ex) {
            Slog.e(TAG, ex.getMessage());
            // let the process exit
            return;
        }

        // Remaining arguments are passed to the start class's static main
        invokeStaticMain(args.startClass, args.startArgs);
    }

    /**
     * Redirect System.out and System.err to the Android log.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:51.245 -0500", hash_original_method = "64B494D57495388AEA3A29297F0CBFFC", hash_generated_method = "7764F224334641D2EC0D60CEFC73A728")
    
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

    /**
     * Report a serious error in the current process.  May or may not cause
     * the process to terminate (depends on system settings).
     *
     * @param tag to record with the error
     * @param t exception describing the error site and conditions
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:51.263 -0500", hash_original_method = "F1B813BD238681733DAFF269616C7CF7", hash_generated_method = "F681E3FD634766498B11C935AE1CEDA2")
    
public static void wtf(String tag, Throwable t) {
        try {
            if (ActivityManagerNative.getDefault().handleApplicationWtf(
                    mApplicationObject, tag, new ApplicationErrorReport.CrashInfo(t))) {
                // The Activity Manager has already written us off -- now exit.
                Process.killProcess(Process.myPid());
                System.exit(10);
            }
        } catch (Throwable t2) {
            Slog.e(TAG, "Error reporting WTF", t2);
        }
    }

    /**
     * Set the object identifying this application/process, for reporting VM
     * errors.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:51.265 -0500", hash_original_method = "C39B9D61998C599A14A36C909D0DA77C", hash_generated_method = "6F401FB1E069C59322E5684437DF2D4F")
    
public static final void setApplicationObject(IBinder app) {
        mApplicationObject = app;
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:51.267 -0500", hash_original_method = "E901955560D4A31547FD724447878F67", hash_generated_method = "22E2E5155AECEAD3EABB5DFA20E1CD96")
    
public static final IBinder getApplicationObject() {
        return mApplicationObject;
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:51.200 -0500", hash_original_field = "C73D9F25E5F6CAFECCE98CB85C10D990", hash_generated_field = "527BFEF4E332EB2DD2EA4CFDB3D09D89")

    private final static String TAG = "AndroidRuntime";
    
    private static class UncaughtHandler implements Thread.UncaughtExceptionHandler {
        
        @DSComment("Private Method")
        @DSBan(DSCat.PRIVATE_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:10.655 -0400", hash_original_method = "DEBC568C3CCF1424A96EDBFCCD0328BF", hash_generated_method = "DEBC568C3CCF1424A96EDBFCCD0328BF")
        public UncaughtHandler ()
        {
            //Synthesized constructor
        }
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:51.213 -0500", hash_original_method = "498D7614C18F40B02B7387DE4641DDCF", hash_generated_method = "4D4A550BC86A534E273B85EC759C5EDB")
        
public void uncaughtException(Thread t, Throwable e) {
            try {
                // Don't re-enter -- avoid infinite loops if crash-reporting crashes.
                if (mCrashing) return;
                mCrashing = true;

                if (mApplicationObject == null) {
                    Slog.e(TAG, "*** FATAL EXCEPTION IN SYSTEM PROCESS: " + t.getName(), e);
                } else {
                    Slog.e(TAG, "FATAL EXCEPTION: " + t.getName(), e);
                }

                // Bring up crash dialog, wait for it to be dismissed
                ActivityManagerNative.getDefault().handleApplicationCrash(
                        mApplicationObject, new ApplicationErrorReport.CrashInfo(e));
            } catch (Throwable t2) {
                try {
                    Slog.e(TAG, "Error reporting crash", t2);
                } catch (Throwable t3) {
                    // Even Slog.e() fails!  Oh well.
                }
            } finally {
                // Try everything to make sure this process goes away.
                Process.killProcess(Process.myPid());
                System.exit(10);
            }
        }
        
    }
    
    static class Arguments {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:51.270 -0500", hash_original_field = "54F1E4F701E6BC5080DD319C8D10B220", hash_generated_field = "54F1E4F701E6BC5080DD319C8D10B220")

        String startClass;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:51.272 -0500", hash_original_field = "711B2441164D898E55743AC3E8A55306", hash_generated_field = "711B2441164D898E55743AC3E8A55306")

        String[] startArgs;

        /**
         * Constructs instance and parses args
         * @param args runtime command-line args
         * @throws IllegalArgumentException
         */
        @DSComment("Package priviledge")
        @DSBan(DSCat.DEFAULT_MODIFIER)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:51.276 -0500", hash_original_method = "35BDC5101A4DE38616FDCE6EF4D8CA10", hash_generated_method = "35BDC5101A4DE38616FDCE6EF4D8CA10")
        
Arguments(String args[]) throws IllegalArgumentException {
            parseArgs(args);
        }

        /**
         * Parses the commandline arguments intended for the Runtime.
         */
        @DSComment("Private Method")
        @DSBan(DSCat.PRIVATE_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:51.278 -0500", hash_original_method = "8231389587D8A1396F36A075174F3D3F", hash_generated_method = "BA0AD7E18F4DCF5C52C0A2E2DC39C35F")
        
private void parseArgs(String args[])
                throws IllegalArgumentException {
            int curArg = 0;
            for (; curArg < args.length; curArg++) {
                String arg = args[curArg];

                if (arg.equals("--")) {
                    curArg++;
                    break;
                } else if (!arg.startsWith("--")) {
                    break;
                }
            }

            if (curArg == args.length) {
                throw new IllegalArgumentException("Missing classname argument to RuntimeInit!");
            }

            startClass = args[curArg++];
            startArgs = new String[args.length - curArg];
            System.arraycopy(args, curArg, startArgs, 0, startArgs.length);
        }
        
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:51.203 -0500", hash_original_field = "81DD852ECBE07BA98A61C8F3D0C85F01", hash_generated_field = "7841AA055B417A7E8C3D727A4ADDD91D")

    private final static boolean DEBUG = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:51.205 -0500", hash_original_field = "6FBE6536E7CE204510C4979FD7989151", hash_generated_field = "9FD51B35B9E2224AA107F59D57389A34")

    private static boolean initialized;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:51.207 -0500", hash_original_field = "FFD16133019F2BA1473D1931EA0B77AF", hash_generated_field = "254F062FB27979B6C2E631565CC9502B")

    private static IBinder mApplicationObject;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:51.210 -0500", hash_original_field = "01558103F728473DCF5D7E6B0402B753", hash_generated_field = "7061173743FAA271B75796C94B51B8DD")

    private static volatile boolean mCrashing = false;
    
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:10.652 -0400", hash_original_method = "82505B17DF4892252BD2E987919E8FA9", hash_generated_method = "82505B17DF4892252BD2E987919E8FA9")
    public RuntimeInit ()
    {
        //Synthesized constructor
    }
    static {
        android.ddm.DdmRegister.registerHandlers();
    }
    
}

