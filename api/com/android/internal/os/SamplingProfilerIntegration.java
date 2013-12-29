package com.android.internal.os;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
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
import android.content.pm.PackageInfo;
import android.os.Build;
import android.os.SystemProperties;
import android.util.Log;
import dalvik.system.profiler.BinaryHprofWriter;
import dalvik.system.profiler.SamplingProfiler;





public class SamplingProfilerIntegration {

    /**
     * Is profiling enabled?
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:42.104 -0500", hash_original_method = "7F96EB9041812BCBDE3CAB21860F0D78", hash_generated_method = "176744FB379C063ED5EE004EDB8E802B")
    public static boolean isEnabled() {
        return enabled;
    }

    /**
     * Starts the profiler if profiling is enabled.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:42.105 -0500", hash_original_method = "EB3E524D388CAA0001E918D3BE2E0050", hash_generated_method = "F8904635ACB2C47E51F6597E693D3268")
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

    /**
     * Writes a snapshot if profiling is enabled.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:42.108 -0500", hash_original_method = "B569CAA62A49ECE2C19ECFCEE09DE2D9", hash_generated_method = "486B482C4114FE9970374AFD889758BD")
    public static void writeSnapshot(final String processName, final PackageInfo packageInfo) {
        if (!enabled) {
            return;
        }
        if (samplingProfiler == null) {
            Log.e(TAG, "SamplingProfilerIntegration is not started");
            return;
        }

        /*
         * If we're already writing a snapshot, don't bother enqueueing another
         * request right now. This will reduce the number of individual
         * snapshots and in turn the total amount of memory consumed (one big
         * snapshot is smaller than N subset snapshots).
         */
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

    /**
     * Writes the zygote's snapshot to internal storage if profiling is enabled.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:42.109 -0500", hash_original_method = "A979A74A67ED90384C5F9F6956F4ECC6", hash_generated_method = "CAA6DC70FBFADEE08CBFA9A96FE4955F")
    public static void writeZygoteSnapshot() {
        if (!enabled) {
            return;
        }
        writeSnapshotFile("zygote", null);
        samplingProfiler.shutdown();
        samplingProfiler = null;
        startMillis = 0;
    }

    /**
     * pass in PackageInfo to retrieve various values for snapshot header
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:42.110 -0500", hash_original_method = "31CB55FEBB712AC9C6C246D13CF90696", hash_generated_method = "F38D38CEE1C403E8B7B2BE8AF85EA744")
    private static void writeSnapshotFile(String processName, PackageInfo packageInfo) {
        if (!enabled) {
            return;
        }
        samplingProfiler.stop();

        /*
         * We use the global start time combined with the process name
         * as a unique ID. We can't use a counter because processes
         * restart. This could result in some overlap if we capture
         * two snapshots in rapid succession.
         */
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
        // set file readable to the world so that SamplingProfilerService
        // can put it to dropbox
        new File(path).setReadable(true, false);

        long elapsed = System.currentTimeMillis() - start;
        Log.i(TAG, "Wrote snapshot " + path + " in " + elapsed + "ms.");
        samplingProfiler.start(samplingProfilerMilliseconds);
    }

    /**
     * generate header for snapshots, with the following format
     * (like an HTTP header but without the \r):
     *
     * Version: <version number of profiler>\n
     * Process: <process name>\n
     * Package: <package name, if exists>\n
     * Package-Version: <version number of the package, if exists>\n
     * Build: <fingerprint>\n
     * \n
     * <the actual snapshot content begins here...>
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:42.111 -0500", hash_original_method = "209578548F46DD00349D7E4CCC9857FB", hash_generated_method = "891970310FD08D7AE18CC86CEEA187C7")
    private static void generateSnapshotHeader(String processName, PackageInfo packageInfo,
            PrintStream out) {
        // profiler version
        out.println("Version: 3");
        out.println("Process: " + processName);
        if (packageInfo != null) {
            out.println("Package: " + packageInfo.packageName);
            out.println("Package-Version: " + packageInfo.versionCode);
        }
        out.println("Build: " + Build.FINGERPRINT);
        // single blank line means the end of snapshot header.
        out.println();
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:42.095 -0500", hash_original_field = "FC48C757CF7EBF9D213EA2A4BD870E63", hash_generated_field = "DED25F05264CF95D81AB507303D46649")


    private static final String TAG = "SamplingProfilerIntegration";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:42.096 -0500", hash_original_field = "EC4F7C78A85BB3ED8C1A3E830DB3BDEE", hash_generated_field = "72F48D94CC8ED4AD1FCA77C7196B2B92")


    public static final String SNAPSHOT_DIR = "/data/snapshots";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:42.097 -0500", hash_original_field = "D42E676CEDD1F98F54276A59532354DC", hash_generated_field = "DB43F08CE6FECA7A1C8C07B38FA1DE26")


    private static  boolean enabled;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:42.098 -0500", hash_original_field = "3D064D1C90BC253FA6F4BEE468114308", hash_generated_field = "1CBC3CB96AAE98A231CC700FE768AAAB")

    private static  Executor snapshotWriter;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:42.099 -0500", hash_original_field = "10B9FBAB20087600AB9A0108F8B541B9", hash_generated_field = "324765C6D5990B34101C0322A8EB574E")

    private static  int samplingProfilerMilliseconds;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:42.099 -0500", hash_original_field = "EAC4056E76428100C09751EB1F4CFC55", hash_generated_field = "C84A6D1B28B8C665382DBC51051F3004")

    private static  int samplingProfilerDepth;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:42.101 -0500", hash_original_field = "2E9E384BBA0EF726AD4A4C747EE31131", hash_generated_field = "0CA13F4CDB357F0CAB54BA7B55B7708E")

    private static final AtomicBoolean pending = new AtomicBoolean(false);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:42.103 -0500", hash_original_field = "F47D7C26E7EA9343134EACA8F7536E80", hash_generated_field = "D6D759FF1128C8C1D8674684F1ED3D4D")


    private static SamplingProfiler samplingProfiler;
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
                        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:42.102 -0500", hash_original_method = "0CDBA4487C2472A49E498ACF4C9DC17B", hash_generated_method = "9BECBBFD0B8DB73E5850D803C0924DE6")
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
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:42.104 -0500", hash_original_field = "CCC3D06B79CAFED038554FC560DC20F2", hash_generated_field = "3B0F262BDAD418B2BF1C2FBAE7548781")

    private static long startMillis;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:10.675 -0400", hash_original_method = "C843367E35B636EBAF34BDED63CFE66E", hash_generated_method = "C843367E35B636EBAF34BDED63CFE66E")
    public SamplingProfilerIntegration ()
    {
        //Synthesized constructor
    }
}

