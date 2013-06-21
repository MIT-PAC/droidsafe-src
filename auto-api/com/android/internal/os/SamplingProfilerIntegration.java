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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.276 -0400", hash_original_method = "75CCCEF1F1C8F6D6E2F52808B28DDD7D", hash_generated_method = "75CCCEF1F1C8F6D6E2F52808B28DDD7D")
        public SamplingProfilerIntegration ()
    {
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

    
    private static final String TAG = "SamplingProfilerIntegration";
    public static final String SNAPSHOT_DIR = "/data/snapshots";
    private static final boolean enabled;
    private static final Executor snapshotWriter;
    private static final int samplingProfilerMilliseconds;
    private static final int samplingProfilerDepth;
    private static final AtomicBoolean pending = new AtomicBoolean(false);
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
    
    private static SamplingProfiler samplingProfiler;
    private static long startMillis;
}

