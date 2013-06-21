package com.android.internal.os;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.content.pm.ActivityInfo;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.net.LocalServerSocket;
import android.os.Debug;
import android.os.FileUtils;
import android.os.Process;
import android.os.SystemClock;
import android.os.SystemProperties;
import android.util.EventLog;
import android.util.Log;
import dalvik.system.VMRuntime;
import dalvik.system.Zygote;
import libcore.io.IoUtils;
import java.io.BufferedReader;
import java.io.FileDescriptor;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;

public class ZygoteInit {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.397 -0400", hash_original_method = "428A10BCE5663B72CCCACBE02D386E37", hash_generated_method = "B822867C5762398B852DFCB190C609C4")
    @DSModeled(DSC.SAFE)
    private ZygoteInit() {
        // ---------- Original Method ----------
    }

    
        static void invokeStaticMain(ClassLoader loader,
            String className, String[] argv) throws ZygoteInit.MethodAndArgsCaller {
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
        throw new ZygoteInit.MethodAndArgsCaller(m, argv);
    }

    
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

    
        private static ZygoteConnection acceptCommandPeer() {
        try {
            return new ZygoteConnection(sServerSocket.accept());
        } catch (IOException ex) {
            throw new RuntimeException(
                    "IOException during accept()", ex);
        }
    }

    
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

    
        private static void setEffectiveUser(int uid) {
        int errno = setreuid(ROOT_UID, uid);
        if (errno != 0) {
            Log.e(TAG, "setreuid() failed. errno: " + errno);
        }
    }

    
        private static void setEffectiveGroup(int gid) {
        int errno = setregid(ROOT_GID, gid);
        if (errno != 0) {
            Log.e(TAG, "setregid() failed. errno: " + errno);
        }
    }

    
        static void preload() {
        preloadClasses();
        preloadResources();
    }

    
        private static void preloadClasses() {
        final VMRuntime runtime = VMRuntime.getRuntime();
        InputStream is = ZygoteInit.class.getClassLoader().getResourceAsStream(
                PRELOADED_CLASSES);
        if (is == null) {
            Log.e(TAG, "Couldn't find " + PRELOADED_CLASSES + ".");
        } else {
            Log.i(TAG, "Preloading classes...");
            long startTime = SystemClock.uptimeMillis();
            setEffectiveGroup(UNPRIVILEGED_GID);
            setEffectiveUser(UNPRIVILEGED_UID);
            float defaultUtilization = runtime.getTargetHeapUtilization();
            runtime.setTargetHeapUtilization(0.8f);
            System.gc();
            runtime.runFinalizationSync();
            Debug.startAllocCounting();
            try {
                BufferedReader br
                    = new BufferedReader(new InputStreamReader(is), 256);
                int count = 0;
                String line;
                while ((line = br.readLine()) != null) {
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
                runtime.setTargetHeapUtilization(defaultUtilization);
                Debug.stopAllocCounting();
                setEffectiveUser(ROOT_UID);
                setEffectiveGroup(ROOT_GID);
            }
        }
    }

    
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

    
        static void gc() {
        final VMRuntime runtime = VMRuntime.getRuntime();
        System.gc();
        runtime.runFinalizationSync();
        System.gc();
        runtime.runFinalizationSync();
        System.gc();
        runtime.runFinalizationSync();
    }

    
        private static void handleSystemServerProcess(
            ZygoteConnection.Arguments parsedArgs) throws ZygoteInit.MethodAndArgsCaller {
        closeServerSocket();
        FileUtils.setUMask(FileUtils.S_IRWXG | FileUtils.S_IRWXO);
        if (parsedArgs.niceName != null) {
            Process.setArgV0(parsedArgs.niceName);
        }
        if (parsedArgs.invokeWith != null) {
            WrapperInit.execApplication(parsedArgs.invokeWith,
                    parsedArgs.niceName, parsedArgs.targetSdkVersion,
                    null, parsedArgs.remainingArgs);
        } else {
            RuntimeInit.zygoteInit(parsedArgs.targetSdkVersion, parsedArgs.remainingArgs);
        }
    }

    
        private static boolean startSystemServer() throws MethodAndArgsCaller, RuntimeException {
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
        if (pid == 0) {
            handleSystemServerProcess(parsedArgs);
        }
        return true;
    }

    
        public static void main(String argv[]) {
        try {
            SamplingProfilerIntegration.start();
            registerZygoteSocket();
            EventLog.writeEvent(LOG_BOOT_PROGRESS_PRELOAD_START,
                SystemClock.uptimeMillis());
            preload();
            EventLog.writeEvent(LOG_BOOT_PROGRESS_PRELOAD_END,
                SystemClock.uptimeMillis());
            SamplingProfilerIntegration.writeZygoteSnapshot();
            gc();
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

    
        private static void runForkMode() throws MethodAndArgsCaller {
        while (true) {
            ZygoteConnection peer = acceptCommandPeer();
            int pid;
            pid = Zygote.fork();
            if (pid == 0) {
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

    
        private static void runSelectLoopMode() throws MethodAndArgsCaller {
        ArrayList<FileDescriptor> fds = new ArrayList();
        ArrayList<ZygoteConnection> peers = new ArrayList();
        FileDescriptor[] fdArray = new FileDescriptor[4];
        fds.add(sServerSocket.getFileDescriptor());
        peers.add(null);
        int loopCount = GC_LOOP_COUNT;
        while (true) {
            int index;
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

    
        static int setreuid(int ruid, int euid) {
        return DSUtils.UNKNOWN_INT;
    }

    
        static int setregid(int rgid, int egid) {
        return DSUtils.UNKNOWN_INT;
    }

    
        static int setpgid(int pid, int pgid) {
        return DSUtils.UNKNOWN_INT;
    }

    
        static int getpgid(int pid) throws IOException {
        return DSUtils.UNKNOWN_INT;
    }

    
        static void reopenStdio(FileDescriptor in,
            FileDescriptor out, FileDescriptor err) throws IOException {
    }

    
        static void setCloseOnExec(FileDescriptor fd, boolean flag) throws IOException {
    }

    
        static long capgetPermitted(int pid) throws IOException {
        return DSUtils.UNKNOWN_LONG;
    }

    
        static void setCapabilities(
            long permittedCapabilities,
            long effectiveCapabilities) throws IOException {
    }

    
        static int selectReadable(FileDescriptor[] fds) throws IOException {
        return DSUtils.UNKNOWN_INT;
    }

    
        static FileDescriptor createFileDescriptor(int fd) throws IOException {
        //DSFIXME:  CODE0012: Native static method requires manual modeling
    }

    
    public static class MethodAndArgsCaller extends Exception implements Runnable {
        private Method mMethod;
        private String[] mArgs;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.403 -0400", hash_original_method = "B7C77C284F7B165702F670BC703A8A6B", hash_generated_method = "B5BF25CAABE240F4E2307E2EF9603011")
        @DSModeled(DSC.SAFE)
        public MethodAndArgsCaller(Method method, String[] args) {
            dsTaint.addTaint(args[0]);
            dsTaint.addTaint(method.dsTaint);
            // ---------- Original Method ----------
            //mMethod = method;
            //mArgs = args;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.404 -0400", hash_original_method = "9C4F25D836A229393F13206C69120090", hash_generated_method = "3413254AA9BEF9C84852AE44B001DFF5")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void run() {
            try 
            {
                mMethod.invoke(null, new Object[] { mArgs });
            } //End block
            catch (IllegalAccessException ex)
            {
                if (DroidSafeAndroidRuntime.control) throw new RuntimeException(ex);
            } //End block
            catch (InvocationTargetException ex)
            {
                Throwable cause;
                cause = ex.getCause();
                {
                    if (DroidSafeAndroidRuntime.control) throw (RuntimeException) cause;
                } //End block
                {
                    if (DroidSafeAndroidRuntime.control) throw (Error) cause;
                } //End block
                if (DroidSafeAndroidRuntime.control) throw new RuntimeException(ex);
            } //End block
            // ---------- Original Method ----------
            //try {
                //mMethod.invoke(null, new Object[] { mArgs });
            //} catch (IllegalAccessException ex) {
                //throw new RuntimeException(ex);
            //} catch (InvocationTargetException ex) {
                //Throwable cause = ex.getCause();
                //if (cause instanceof RuntimeException) {
                    //throw (RuntimeException) cause;
                //} else if (cause instanceof Error) {
                    //throw (Error) cause;
                //}
                //throw new RuntimeException(ex);
            //}
        }

        
    }


    
    private static final String TAG = "Zygote";
    private static final String ANDROID_SOCKET_ENV = "ANDROID_SOCKET_zygote";
    private static final int LOG_BOOT_PROGRESS_PRELOAD_START = 3020;
    private static final int LOG_BOOT_PROGRESS_PRELOAD_END = 3030;
    private static final int PRELOAD_GC_THRESHOLD = 50000;
    public static final String USAGE_STRING =
            " <\"start-system-server\"|\"\" for startSystemServer>";
    private static LocalServerSocket sServerSocket;
    private static Resources mResources;
    static final int GC_LOOP_COUNT = 10;
    private static final boolean ZYGOTE_FORK_MODE = false;
    private static final String PRELOADED_CLASSES = "preloaded-classes";
    private static final boolean PRELOAD_RESOURCES = true;
    private static final int UNPRIVILEGED_UID = 9999;
    private static final int UNPRIVILEGED_GID = 9999;
    private static final int ROOT_UID = 0;
    private static final int ROOT_GID = 0;
}

