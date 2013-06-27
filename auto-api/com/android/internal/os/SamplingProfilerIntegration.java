package com.android.internal.os;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.os.SystemProperties;
import android.util.Log;
import dalvik.system.profiler.BinaryHprofWriter;
import dalvik.system.profiler.SamplingProfiler;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Date;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicBoolean;
import libcore.io.IoUtils;

public class SamplingProfilerIntegration {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:14.000 -0400", hash_original_method = "C843367E35B636EBAF34BDED63CFE66E", hash_generated_method = "C843367E35B636EBAF34BDED63CFE66E")
    public SamplingProfilerIntegration ()
    {
        //Synthesized constructor
    }


        public static boolean isEnabled() {
        return enabled;
    }

    
        public static void start() {
        if (!enabled) {
            return;
        }
        if (samplingProfiler != null) {
            Log.e(TAG, "SamplingProfilerIntegration already started at " + new Date(startMillis));
            return;
        }
        ThreadGroup group = Thread.currentThread().getThreadGroup();
        SamplingProfiler.ThreadSet threadSet = SamplingProfiler.newThreadGroupTheadSet(group);
        samplingProfiler = new SamplingProfiler(samplingProfilerDepth, threadSet);
        samplingProfiler.start(samplingProfilerMilliseconds);
        startMillis = System.currentTimeMillis();
    }

    
        public static void writeSnapshot(final String processName, final PackageInfo packageInfo) {
        if (!enabled) {
            return;
        }
        if (samplingProfiler == null) {
            Log.e(TAG, "SamplingProfilerIntegration is not started");
            return;
        }
        if (pending.compareAndSet(false, true)) {
            snapshotWriter.execute(new Runnable() {
                public void run() {
                    try {
                        writeSnapshotFile(processName, packageInfo);
                    } finally {
                        pending.set(false);
                    }
                }
            });
        }
    }

    
        public static void writeZygoteSnapshot() {
        if (!enabled) {
            return;
        }
        writeSnapshotFile("zygote", null);
        samplingProfiler.shutdown();
        samplingProfiler = null;
        startMillis = 0;
    }

    
        private static void writeSnapshotFile(String processName, PackageInfo packageInfo) {
        if (!enabled) {
            return;
        }
        samplingProfiler.stop();
        String name = processName.replaceAll(":", ".");
        String path = SNAPSHOT_DIR + "/" + name + "-" + startMillis + ".snapshot";
        long start = System.currentTimeMillis();
        OutputStream outputStream = null;
        try {
            outputStream = new BufferedOutputStream(new FileOutputStream(path));
            PrintStream out = new PrintStream(outputStream);
            generateSnapshotHeader(name, packageInfo, out);
            if (out.checkError()) {
                throw new IOException();
            }
            BinaryHprofWriter.write(samplingProfiler.getHprofData(), outputStream);
        } catch (IOException e) {
            Log.e(TAG, "Error writing snapshot to " + path, e);
            return;
        } finally {
            IoUtils.closeQuietly(outputStream);
        }
        new File(path).setReadable(true, false);
        long elapsed = System.currentTimeMillis() - start;
        Log.i(TAG, "Wrote snapshot " + path + " in " + elapsed + "ms.");
        samplingProfiler.start(samplingProfilerMilliseconds);
    }

    
        private static void generateSnapshotHeader(String processName, PackageInfo packageInfo,
            PrintStream out) {
        out.println("Version: 3");
        out.println("Process: " + processName);
        if (packageInfo != null) {
            out.println("Package: " + packageInfo.packageName);
            out.println("Package-Version: " + packageInfo.versionCode);
        }
        out.println("Build: " + Build.FINGERPRINT);
        out.println();
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:14.085 -0400", hash_original_field = "ADA93ED91EF6828F05B02C85AD635D22", hash_generated_field = "21113262800901ADB74E2F828EABBE0D")

    private static String TAG = "SamplingProfilerIntegration";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:14.085 -0400", hash_original_field = "DB80734174326335BBE387199FEE37AE", hash_generated_field = "72F48D94CC8ED4AD1FCA77C7196B2B92")

    public static final String SNAPSHOT_DIR = "/data/snapshots";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:14.085 -0400", hash_original_field = "A10311459433ADF322F2590A4987C423", hash_generated_field = "DB43F08CE6FECA7A1C8C07B38FA1DE26")

    private static boolean enabled;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:14.085 -0400", hash_original_field = "A12A27CDC927440565CEE3B9D8DB3B19", hash_generated_field = "1CBC3CB96AAE98A231CC700FE768AAAB")

    private static Executor snapshotWriter;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:14.085 -0400", hash_original_field = "C76EB22651A4F686E69F3214FBD5E66A", hash_generated_field = "324765C6D5990B34101C0322A8EB574E")

    private static int samplingProfilerMilliseconds;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:14.085 -0400", hash_original_field = "D50A2D63A220A444C92A31A2AFD89162", hash_generated_field = "C84A6D1B28B8C665382DBC51051F3004")

    private static int samplingProfilerDepth;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:14.085 -0400", hash_original_field = "39604AD385B7AD153080EA77853D745C", hash_generated_field = "A3E4F20576C9FCDC6094D2ADC5551F91")

    private static AtomicBoolean pending = new AtomicBoolean(false);
    static {
        samplingProfilerMilliseconds = SystemProperties.getInt("persist.sys.profiler_ms", 0);
        samplingProfilerDepth = SystemProperties.getInt("persist.sys.profiler_depth", 4);
        if (samplingProfilerMilliseconds > 0) {
            File dir = new File(SNAPSHOT_DIR);
            dir.mkdirs();
            dir.setWritable(true, false);
            dir.setExecutable(true, false);
            if (dir.isDirectory()) {
                snapshotWriter = Executors.newSingleThreadExecutor(new ThreadFactory() {
                        public Thread newThread(Runnable r) {
                            return new Thread(r, TAG);
                        }
                    });
                enabled = true;
                Log.i(TAG, "Profiling enabled. Sampling interval ms: "
                      + samplingProfilerMilliseconds);
            } else {
                snapshotWriter = null;
                enabled = true;
                Log.w(TAG, "Profiling setup failed. Could not create " + SNAPSHOT_DIR);
            }
        } else {
            snapshotWriter = null;
            enabled = false;
            Log.i(TAG, "Profiling disabled.");
        }
    }
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:14.088 -0400", hash_original_field = "D21763DBA70CD991747D485437570F06", hash_generated_field = "D6D759FF1128C8C1D8674684F1ED3D4D")

    private static SamplingProfiler samplingProfiler;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:14.088 -0400", hash_original_field = "B9A6573709935C9B3FECAA4DEC3B7269", hash_generated_field = "3B0F262BDAD418B2BF1C2FBAE7548781")

    private static long startMillis;
}

