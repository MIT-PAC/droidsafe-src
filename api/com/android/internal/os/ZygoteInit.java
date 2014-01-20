package com.android.internal.os;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.BufferedReader;
import java.io.FileDescriptor;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;

import libcore.io.IoUtils;
import android.content.pm.ActivityInfo;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.net.LocalServerSocket;
import android.os.Debug;
import android.os.FileUtils;
import android.os.Process;
import android.os.SystemClock;
import android.util.EventLog;
import android.util.Log;
import dalvik.system.VMRuntime;
import dalvik.system.Zygote;

import droidsafe.helpers.DSUtils;

public class ZygoteInit {

    /**
     * Invokes a static "main(argv[]) method on class "className".
     * Converts various failing exceptions into RuntimeExceptions, with
     * the assumption that they will then cause the VM instance to exit.
     *
     * @param loader class loader to use
     * @param className Fully-qualified class name
     * @param argv Argument vector for main()
     */
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:50.746 -0500", hash_original_method = "92C0302C214CF8B39DC3046063D57663", hash_generated_method = "72463FCEC06525819F43BD0A022D2598")
    
static void invokeStaticMain(ClassLoader loader,
            String className, String[] argv)
            throws ZygoteInit.MethodAndArgsCaller {
        Class<?> cl;

        try {
            cl = loader.loadClass(className);
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

    /**
     * Registers a server socket for zygote command connections
     *
     * @throws RuntimeException when open fails
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:50.748 -0500", hash_original_method = "33238DBDD3EE10AC78A38524A4B30B45", hash_generated_method = "EB06F1DC315B21A9C36C419617D2C322")
    
private static void registerZygoteSocket() {
        if (sServerSocket == null) {
            int fileDesc;
            try {
                String env = System.getenv(ANDROID_SOCKET_ENV);
                fileDesc = Integer.parseInt(env);
            } catch (RuntimeException ex) {
                throw new RuntimeException(
                        ANDROID_SOCKET_ENV + " unset or invalid", ex);
            }

            try {
                sServerSocket = new LocalServerSocket(
                        createFileDescriptor(fileDesc));
            } catch (IOException ex) {
                throw new RuntimeException(
                        "Error binding to local socket '" + fileDesc + "'", ex);
            }
        }
    }

    /**
     * Waits for and accepts a single command connection. Throws
     * RuntimeException on failure.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:50.751 -0500", hash_original_method = "045B5F1BFA94DC7C2BFF459F85DF0833", hash_generated_method = "104DA174A6EFC5A4FFC070905649B9FB")
    
private static ZygoteConnection acceptCommandPeer() {
        try {
            return new ZygoteConnection(sServerSocket.accept());
        } catch (IOException ex) {
            throw new RuntimeException(
                    "IOException during accept()", ex);
        }
    }

    /**
     * Close and clean up zygote sockets. Called on shutdown and on the
     * child's exit path.
     */
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:50.753 -0500", hash_original_method = "E08E603F610DF9EAD1243BA93888D718", hash_generated_method = "5797599B65945F2B2406534D8E8A3524")
    
static void closeServerSocket() {
        try {
            if (sServerSocket != null) {
                sServerSocket.close();
            }
        } catch (IOException ex) {
            Log.e(TAG, "Zygote:  error closing sockets", ex);
        }

        sServerSocket = null;
    }

    /**
     * Sets effective user ID.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:50.767 -0500", hash_original_method = "E2A3189629A3C133F0ED36D24E845649", hash_generated_method = "728808F2947D3F3FB44DBE3A16D200F5")
    
private static void setEffectiveUser(int uid) {
        int errno = setreuid(ROOT_UID, uid);
        if (errno != 0) {
            Log.e(TAG, "setreuid() failed. errno: " + errno);
        }
    }

    /**
     * Sets effective group ID.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:50.770 -0500", hash_original_method = "18751F68EA30125352914BAC8CA8F1CD", hash_generated_method = "3F7975C5C0F71BC71D4C9DB6435E3592")
    
private static void setEffectiveGroup(int gid) {
        int errno = setregid(ROOT_GID, gid);
        if (errno != 0) {
            Log.e(TAG, "setregid() failed. errno: " + errno);
        }
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:50.772 -0500", hash_original_method = "31986CD3550679EB088D2B62322D5418", hash_generated_method = "47797ED3E0A3374C574CB8E5BF4443E2")
    
static void preload() {
        preloadClasses();
        preloadResources();
    }

    /**
     * Performs Zygote process initialization. Loads and initializes
     * commonly used classes.
     *
     * Most classes only cause a few hundred bytes to be allocated, but
     * a few will allocate a dozen Kbytes (in one case, 500+K).
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:50.776 -0500", hash_original_method = "8C4C1B59B00A9C1FB0F98F7424B5199F", hash_generated_method = "D96DD0F25F76242E105CF187E0E2089A")
    
private static void preloadClasses() {
        final VMRuntime runtime = VMRuntime.getRuntime();

        InputStream is = ZygoteInit.class.getClassLoader().getResourceAsStream(
                PRELOADED_CLASSES);
        if (is == null) {
            Log.e(TAG, "Couldn't find " + PRELOADED_CLASSES + ".");
        } else {
            Log.i(TAG, "Preloading classes...");
            long startTime = SystemClock.uptimeMillis();

            // Drop root perms while running static initializers.
            setEffectiveGroup(UNPRIVILEGED_GID);
            setEffectiveUser(UNPRIVILEGED_UID);

            // Alter the target heap utilization.  With explicit GCs this
            // is not likely to have any effect.
            float defaultUtilization = runtime.getTargetHeapUtilization();
            runtime.setTargetHeapUtilization(0.8f);

            // Start with a clean slate.
            System.gc();
            runtime.runFinalizationSync();
            Debug.startAllocCounting();

            try {
                BufferedReader br
                    = new BufferedReader(new InputStreamReader(is), 256);

                int count = 0;
                String line;
                while ((line = br.readLine()) != null) {
                    // Skip comments and blank lines.
                    line = line.trim();
                    if (line.startsWith("#") || line.equals("")) {
                        continue;
                    }

                    try {
                        if (false) {
                            Log.v(TAG, "Preloading " + line + "...");
                        }
                        Class.forName(line);
                        if (Debug.getGlobalAllocSize() > PRELOAD_GC_THRESHOLD) {
                            if (false) {
                                Log.v(TAG,
                                    " GC at " + Debug.getGlobalAllocSize());
                            }
                            System.gc();
                            runtime.runFinalizationSync();
                            Debug.resetGlobalAllocSize();
                        }
                        count++;
                    } catch (ClassNotFoundException e) {
                        Log.w(TAG, "Class not found for preloading: " + line);
                    } catch (Throwable t) {
                        Log.e(TAG, "Error preloading " + line + ".", t);
                        if (t instanceof Error) {
                            throw (Error) t;
                        }
                        if (t instanceof RuntimeException) {
                            throw (RuntimeException) t;
                        }
                        throw new RuntimeException(t);
                    }
                }

                Log.i(TAG, "...preloaded " + count + " classes in "
                        + (SystemClock.uptimeMillis()-startTime) + "ms.");
            } catch (IOException e) {
                Log.e(TAG, "Error reading " + PRELOADED_CLASSES + ".", e);
            } finally {
                IoUtils.closeQuietly(is);
                // Restore default.
                runtime.setTargetHeapUtilization(defaultUtilization);

                Debug.stopAllocCounting();

                // Bring back root. We'll need it later.
                setEffectiveUser(ROOT_UID);
                setEffectiveGroup(ROOT_GID);
            }
        }
    }

    /**
     * Load in commonly used resources, so they can be shared across
     * processes.
     *
     * These tend to be a few Kbytes, but are frequently in the 20-40K
     * range, and occasionally even larger.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:50.779 -0500", hash_original_method = "DE60FEC0184A03FE71EDAD4972871A6E", hash_generated_method = "55B4C0F1C018E7FD9AD76020CEE221A3")
    
private static void preloadResources() {
        final VMRuntime runtime = VMRuntime.getRuntime();

        Debug.startAllocCounting();
        try {
            System.gc();
            runtime.runFinalizationSync();
            mResources = Resources.getSystem();
            mResources.startPreloading();
            if (PRELOAD_RESOURCES) {
                Log.i(TAG, "Preloading resources...");

                long startTime = SystemClock.uptimeMillis();
                TypedArray ar = mResources.obtainTypedArray(
                        com.android.internal.R.array.preloaded_drawables);
                int N = preloadDrawables(runtime, ar);
                Log.i(TAG, "...preloaded " + N + " resources in "
                        + (SystemClock.uptimeMillis()-startTime) + "ms.");

                startTime = SystemClock.uptimeMillis();
                ar = mResources.obtainTypedArray(
                        com.android.internal.R.array.preloaded_color_state_lists);
                N = preloadColorStateLists(runtime, ar);
                Log.i(TAG, "...preloaded " + N + " resources in "
                        + (SystemClock.uptimeMillis()-startTime) + "ms.");
            }
            mResources.finishPreloading();
        } catch (RuntimeException e) {
            Log.w(TAG, "Failure preloading resources", e);
        } finally {
            Debug.stopAllocCounting();
        }
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:50.782 -0500", hash_original_method = "642EA9DEA1CC6BEC041E0008EC6088E4", hash_generated_method = "5AD30E9ACD7D186E85D5864B6934EE8F")
    
private static int preloadColorStateLists(VMRuntime runtime, TypedArray ar) {
        int N = ar.length();
        for (int i=0; i<N; i++) {
            if (Debug.getGlobalAllocSize() > PRELOAD_GC_THRESHOLD) {
                if (false) {
                    Log.v(TAG, " GC at " + Debug.getGlobalAllocSize());
                }
                System.gc();
                runtime.runFinalizationSync();
                Debug.resetGlobalAllocSize();
            }
            int id = ar.getResourceId(i, 0);
            if (false) {
                Log.v(TAG, "Preloading resource #" + Integer.toHexString(id));
            }
            if (id != 0) {
                mResources.getColorStateList(id);
            }
        }
        return N;
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:50.785 -0500", hash_original_method = "CD535216A85FF51D7A90936E24E9BD83", hash_generated_method = "5FF12C82422C0D3DFEB27DFE42C007C7")
    
private static int preloadDrawables(VMRuntime runtime, TypedArray ar) {
        int N = ar.length();
        for (int i=0; i<N; i++) {
            if (Debug.getGlobalAllocSize() > PRELOAD_GC_THRESHOLD) {
                if (false) {
                    Log.v(TAG, " GC at " + Debug.getGlobalAllocSize());
                }
                System.gc();
                runtime.runFinalizationSync();
                Debug.resetGlobalAllocSize();
            }
            int id = ar.getResourceId(i, 0);
            if (false) {
                Log.v(TAG, "Preloading resource #" + Integer.toHexString(id));
            }
            if (id != 0) {
                Drawable dr = mResources.getDrawable(id);
                if ((dr.getChangingConfigurations()&~ActivityInfo.CONFIG_FONT_SCALE) != 0) {
                    Log.w(TAG, "Preloaded drawable resource #0x"
                            + Integer.toHexString(id)
                            + " (" + ar.getString(i) + ") that varies with configuration!!");
                }
            }
        }
        return N;
    }

    /**
     * Runs several special GCs to try to clean up a few generations of
     * softly- and final-reachable objects, along with any other garbage.
     * This is only useful just before a fork().
     */
    /*package*/ @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:50.787 -0500", hash_original_method = "70491B88332D9FF72DEC0D53EB9B78BC", hash_generated_method = "8AD32AC07D7EC8740371A827D7EBA3E2")
    
static void gc() {
        final VMRuntime runtime = VMRuntime.getRuntime();

        /* runFinalizationSync() lets finalizers be called in Zygote,
         * which doesn't have a HeapWorker thread.
         */
        System.gc();
        runtime.runFinalizationSync();
        System.gc();
        runtime.runFinalizationSync();
        System.gc();
        runtime.runFinalizationSync();
    }

    /**
     * Finish remaining work for the newly forked system server process.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:50.789 -0500", hash_original_method = "EACAEF5EE9C7C8D5FCD8F40349D2EBF4", hash_generated_method = "8EDF06F06332D4082644557CE1DF5CCF")
    
private static void handleSystemServerProcess(
            ZygoteConnection.Arguments parsedArgs)
            throws ZygoteInit.MethodAndArgsCaller {

        closeServerSocket();

        // set umask to 0077 so new files and directories will default to owner-only permissions.
        FileUtils.setUMask(FileUtils.S_IRWXG | FileUtils.S_IRWXO);

        if (parsedArgs.niceName != null) {
            Process.setArgV0(parsedArgs.niceName);
        }

        if (parsedArgs.invokeWith != null) {
            WrapperInit.execApplication(parsedArgs.invokeWith,
                    parsedArgs.niceName, parsedArgs.targetSdkVersion,
                    null, parsedArgs.remainingArgs);
        } else {
            /*
             * Pass the remaining arguments to SystemServer.
             */
            RuntimeInit.zygoteInit(parsedArgs.targetSdkVersion, parsedArgs.remainingArgs);
        }

        /* should never reach here */
    }

    /**
     * Prepare the arguments and fork for the system server process.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:50.792 -0500", hash_original_method = "297E5C10002C80959BC209EA8C0A1D06", hash_generated_method = "D969800986D3E41FCEFAFED18B3D4C66")
    
private static boolean startSystemServer()
            throws MethodAndArgsCaller, RuntimeException {
        /* Hardcoded command line to start the system server */
        String args[] = {
            "--setuid=1000",
            "--setgid=1000",
            "--setgroups=1001,1002,1003,1004,1005,1006,1007,1008,1009,1010,1018,3001,3002,3003,3006,3007",
            "--capabilities=130104352,130104352",
            "--runtime-init",
            "--nice-name=system_server",
            "com.android.server.SystemServer",
        };
        ZygoteConnection.Arguments parsedArgs = null;

        int pid;

        try {
            parsedArgs = new ZygoteConnection.Arguments(args);
            ZygoteConnection.applyDebuggerSystemProperty(parsedArgs);
            ZygoteConnection.applyInvokeWithSystemProperty(parsedArgs);

            /* Request to fork the system server process */
            pid = Zygote.forkSystemServer(
                    parsedArgs.uid, parsedArgs.gid,
                    parsedArgs.gids,
                    parsedArgs.debugFlags,
                    null,
                    parsedArgs.permittedCapabilities,
                    parsedArgs.effectiveCapabilities);
        } catch (IllegalArgumentException ex) {
            throw new RuntimeException(ex);
        }

        /* For child process */
        if (pid == 0) {
            handleSystemServerProcess(parsedArgs);
        }

        return true;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:50.796 -0500", hash_original_method = "DB2C972552964C908550DBCEA0720EAD", hash_generated_method = "9FD6317B1EC0E80E51D476EA7766A252")
    
public static void main(String argv[]) {
        try {
            // Start profiling the zygote initialization.
            SamplingProfilerIntegration.start();

            registerZygoteSocket();
            EventLog.writeEvent(LOG_BOOT_PROGRESS_PRELOAD_START,
                SystemClock.uptimeMillis());
            preload();
            EventLog.writeEvent(LOG_BOOT_PROGRESS_PRELOAD_END,
                SystemClock.uptimeMillis());

            // Finish profiling the zygote initialization.
            SamplingProfilerIntegration.writeZygoteSnapshot();

            // Do an initial gc to clean up after startup
            gc();

            // If requested, start system server directly from Zygote
            if (argv.length != 2) {
                throw new RuntimeException(argv[0] + USAGE_STRING);
            }

            if (argv[1].equals("start-system-server")) {
                startSystemServer();
            } else if (!argv[1].equals("")) {
                throw new RuntimeException(argv[0] + USAGE_STRING);
            }

            Log.i(TAG, "Accepting command socket connections");

            if (ZYGOTE_FORK_MODE) {
                runForkMode();
            } else {
                runSelectLoopMode();
            }

            closeServerSocket();
        } catch (MethodAndArgsCaller caller) {
            caller.run();
        } catch (RuntimeException ex) {
            Log.e(TAG, "Zygote died with exception", ex);
            closeServerSocket();
            throw ex;
        }
    }

    /**
     * Runs the zygote in accept-and-fork mode. In this mode, each peer
     * gets its own zygote spawner process. This code is retained for
     * reference only.
     *
     * @throws MethodAndArgsCaller in a child process when a main() should
     * be executed.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:50.799 -0500", hash_original_method = "3C215F763D4714C2B1E8B4A6445CBFDE", hash_generated_method = "DAAA573F0655E75EC0107C9511603F80")
    
private static void runForkMode() throws MethodAndArgsCaller {
        while (true) {
            ZygoteConnection peer = acceptCommandPeer();

            int pid;

            pid = Zygote.fork();

            if (pid == 0) {
                // The child process should handle the peer requests

                // The child does not accept any more connections
                try {
                    sServerSocket.close();
                } catch (IOException ex) {
                    Log.e(TAG, "Zygote Child: error closing sockets", ex);
                } finally {
                    sServerSocket = null;
                }

                peer.run();
                break;
            } else if (pid > 0) {
                peer.closeSocket();
            } else {
                throw new RuntimeException("Error invoking fork()");
            }
        }
    }

    /**
     * Runs the zygote process's select loop. Accepts new connections as
     * they happen, and reads commands from connections one spawn-request's
     * worth at a time.
     *
     * @throws MethodAndArgsCaller in a child process when a main() should
     * be executed.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:50.802 -0500", hash_original_method = "4F451180FF9E93B0119857AFE5ACD842", hash_generated_method = "BD30B724511D9D00629B0F664C7C7B3C")
    
private static void runSelectLoopMode() throws MethodAndArgsCaller {
        ArrayList<FileDescriptor> fds = new ArrayList();
        ArrayList<ZygoteConnection> peers = new ArrayList();
        FileDescriptor[] fdArray = new FileDescriptor[4];

        fds.add(sServerSocket.getFileDescriptor());
        peers.add(null);

        int loopCount = GC_LOOP_COUNT;
        while (true) {
            int index;

            /*
             * Call gc() before we block in select().
             * It's work that has to be done anyway, and it's better
             * to avoid making every child do it.  It will also
             * madvise() any free memory as a side-effect.
             *
             * Don't call it every time, because walking the entire
             * heap is a lot of overhead to free a few hundred bytes.
             */
            if (loopCount <= 0) {
                gc();
                loopCount = GC_LOOP_COUNT;
            } else {
                loopCount--;
            }

            try {
                fdArray = fds.toArray(fdArray);
                index = selectReadable(fdArray);
            } catch (IOException ex) {
                throw new RuntimeException("Error in select()", ex);
            }

            if (index < 0) {
                throw new RuntimeException("Error in select()");
            } else if (index == 0) {
                ZygoteConnection newPeer = acceptCommandPeer();
                peers.add(newPeer);
                fds.add(newPeer.getFileDesciptor());
            } else {
                boolean done;
                done = peers.get(index).runOnce();

                if (done) {
                    peers.remove(index);
                    fds.remove(index);
                }
            }
        }
    }
    
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    static int setreuid(int ruid, int euid) {
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_21444046 = DSUtils.UNKNOWN_INT;
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_21444046;
    }
    
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    static int setregid(int rgid, int egid) {
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1792758307 = DSUtils.UNKNOWN_INT;
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1792758307;
    }
    
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    static int setpgid(int pid, int pgid) {
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1270716942 = DSUtils.UNKNOWN_INT;
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1270716942;
    }
    
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    static int getpgid(int pid) throws IOException {
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1260756067 = DSUtils.UNKNOWN_INT;
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1260756067;
    }
    
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    static void reopenStdio(FileDescriptor in,
            FileDescriptor out, FileDescriptor err) throws IOException {
    }
    
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    static void setCloseOnExec(FileDescriptor fd, boolean flag) throws IOException {
    }
    
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    static long capgetPermitted(int pid) throws IOException {
                long var0F5264038205EDFB1AC05FBB0E8C5E94_1659405050 = DSUtils.UNKNOWN_LONG;
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1659405050;
    }
    
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    static void setCapabilities(
            long permittedCapabilities,
            long effectiveCapabilities) throws IOException {
    }
    
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    static int selectReadable(FileDescriptor[] fds) throws IOException {
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1197257160 = DSUtils.UNKNOWN_INT;
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1197257160;
    }
    
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    static FileDescriptor createFileDescriptor(int fd) throws IOException {
    	return new FileDescriptor();
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:50.715 -0500", hash_original_field = "CA9104072FF1AE74E9853C2A46401BC7", hash_generated_field = "2A664B91B7AF4DD6DD39F407BBDAB91B")

    private static final String TAG = "Zygote";
    
    public static class MethodAndArgsCaller extends Exception implements Runnable {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:50.846 -0500", hash_original_field = "1AE782A3C6D55F3EEA9985EDCF6719E3", hash_generated_field = "B855DD63C0CF0451E81317C9109F465D")

        private  Method mMethod;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:50.849 -0500", hash_original_field = "FD5D103D9ACC39E94EFB314A70CF23CE", hash_generated_field = "36A0BDC0E98A86654E4FB41A74F823AC")

        private  String[] mArgs;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:50.851 -0500", hash_original_method = "B7C77C284F7B165702F670BC703A8A6B", hash_generated_method = "C0BAC984101ECBD13F18FC352003EB7B")
        
public MethodAndArgsCaller(Method method, String[] args) {
            mMethod = method;
            mArgs = args;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:50.854 -0500", hash_original_method = "9C4F25D836A229393F13206C69120090", hash_generated_method = "48EB695FC8742900F4B756B96C8623C2")
        
public void run() {
            try {
                mMethod.invoke(null, new Object[] { mArgs });
            } catch (IllegalAccessException ex) {
                throw new RuntimeException(ex);
            } catch (InvocationTargetException ex) {
                Throwable cause = ex.getCause();
                if (cause instanceof RuntimeException) {
                    throw (RuntimeException) cause;
                } else if (cause instanceof Error) {
                    throw (Error) cause;
                }
                throw new RuntimeException(ex);
            }
        }
        
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:50.717 -0500", hash_original_field = "FE64A8F9D190EA3489BA8CB96F558915", hash_generated_field = "21A14DBCE7B0B42B26E0AE4D21BE6374")

    private static final String ANDROID_SOCKET_ENV = "ANDROID_SOCKET_zygote";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:50.720 -0500", hash_original_field = "C431609858C64BFFA661CA0287DC05DC", hash_generated_field = "72D0A8D066088F349825C90FFD278BF3")

    private static final int LOG_BOOT_PROGRESS_PRELOAD_START = 3020;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:50.722 -0500", hash_original_field = "A323195975FD5A55072EBE2E7DEBA678", hash_generated_field = "36D14AFABA880F6F31DEC33191D862C7")

    private static final int LOG_BOOT_PROGRESS_PRELOAD_END = 3030;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:50.725 -0500", hash_original_field = "3D370AF0C07CC4EE5CCE091FAF80F5EF", hash_generated_field = "1C4BDCB10C814E5E5C1E121F3CFFB398")

    private static final int PRELOAD_GC_THRESHOLD = 50000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:50.727 -0500", hash_original_field = "AFA88C4B9C552005A41BC8F13A42D38A", hash_generated_field = "11B5CFA86B8C286EFBAA6F7566AACF92")

    public static final String USAGE_STRING =
            " <\"start-system-server\"|\"\" for startSystemServer>";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:50.730 -0500", hash_original_field = "FB40507F157D3BB1B2B7C526354E4B1D", hash_generated_field = "9E17DF7A35B42830EDB580D52F5D2BFC")

    private static LocalServerSocket sServerSocket;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:50.733 -0500", hash_original_field = "8C221FB485568FEFC5ABDDF092AD743A", hash_generated_field = "F35B055A0E956F42EA68C0747FE25322")

    private static Resources mResources;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:50.736 -0500", hash_original_field = "0FB803D08C387DD7F5E90B682D47E9AB", hash_generated_field = "CC8FEE4337ADDACC7ADB7DFDC231F802")

    static final int GC_LOOP_COUNT = 10;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:50.738 -0500", hash_original_field = "5966F2060418C690B415DAA37BB4AE45", hash_generated_field = "470965EC21BC0250593F36CAC4C56B5B")

    private static final boolean ZYGOTE_FORK_MODE = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:50.740 -0500", hash_original_field = "93C663FC0CD18592E50B655709C7FC73", hash_generated_field = "D971A35E1DDB9EC284B93F8A315DE174")

    private static final String PRELOADED_CLASSES = "preloaded-classes";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:50.743 -0500", hash_original_field = "A3A03410B52CF696F44F5D5A3235C4CD", hash_generated_field = "217E927B066193DC32AE01A97B64A06F")

    private static final boolean PRELOAD_RESOURCES = true;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:50.756 -0500", hash_original_field = "8C294BAB038DFDC08F17C2CFBEBC8659", hash_generated_field = "B7C284A979FDA8DD7A1E86E6B13F83B4")

    private static final int UNPRIVILEGED_UID = 9999;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:50.759 -0500", hash_original_field = "3FF8B3A0A59668361FB36720ECE174AB", hash_generated_field = "20022E96E92B292F7F27BAE668605B1C")

    private static final int UNPRIVILEGED_GID = 9999;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:50.762 -0500", hash_original_field = "AF039FE22D668EF9032DD7891D998BA1", hash_generated_field = "AA8F959796928F28B5B6310780704CB2")

    private static final int ROOT_UID = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:50.765 -0500", hash_original_field = "DB8DF0CE5F8A8D6410843EB3BF32E1E3", hash_generated_field = "1A2EF32D420BCC0E5CC1DF0ABF44BE23")

    private static final int ROOT_GID = 0;

    /**
     * Class not instantiable.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:50.843 -0500", hash_original_method = "428A10BCE5663B72CCCACBE02D386E37", hash_generated_method = "11CAD4ECB2F6D27A77FF1A5A5E2B3963")
    
private ZygoteInit() {
    }
}

