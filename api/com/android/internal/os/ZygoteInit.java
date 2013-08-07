package com.android.internal.os;

// Droidsafe Imports
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
    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:10.881 -0400", hash_original_method = "428A10BCE5663B72CCCACBE02D386E37", hash_generated_method = "B822867C5762398B852DFCB190C609C4")
    private  ZygoteInit() {
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.BAN)
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

    
    @DSModeled(DSC.BAN)
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

    
    @DSModeled(DSC.BAN)
    private static ZygoteConnection acceptCommandPeer() {
        try {
            return new ZygoteConnection(sServerSocket.accept());
        } catch (IOException ex) {
            throw new RuntimeException(
                    "IOException during accept()", ex);
        }
    }

    
    @DSModeled(DSC.BAN)
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

    
    @DSModeled(DSC.BAN)
    private static void setEffectiveUser(int uid) {
        int errno = setreuid(ROOT_UID, uid);
        if (errno != 0) {
            Log.e(TAG, "setreuid() failed. errno: " + errno);
        }
    }

    
    @DSModeled(DSC.BAN)
    private static void setEffectiveGroup(int gid) {
        int errno = setregid(ROOT_GID, gid);
        if (errno != 0) {
            Log.e(TAG, "setregid() failed. errno: " + errno);
        }
    }

    
    @DSModeled(DSC.BAN)
    static void preload() {
        preloadClasses();
        preloadResources();
    }

    
    @DSModeled(DSC.BAN)
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

    
    @DSModeled(DSC.BAN)
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

    
    @DSModeled(DSC.BAN)
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

    
    @DSModeled(DSC.BAN)
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

    
    @DSModeled(DSC.BAN)
    static void gc() {
        final VMRuntime runtime = VMRuntime.getRuntime();
        System.gc();
        runtime.runFinalizationSync();
        System.gc();
        runtime.runFinalizationSync();
        System.gc();
        runtime.runFinalizationSync();
    }

    
    @DSModeled(DSC.BAN)
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

    
    @DSModeled(DSC.BAN)
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

    
    @DSModeled(DSC.BAN)
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

    
    @DSModeled(DSC.BAN)
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

    
    @DSModeled(DSC.SAFE)
    static int setreuid(int ruid, int euid) {
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_21444046 = DSUtils.UNKNOWN_INT;
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_21444046;
    }

    
    @DSModeled(DSC.SAFE)
    static int setregid(int rgid, int egid) {
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1792758307 = DSUtils.UNKNOWN_INT;
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1792758307;
    }

    
    @DSModeled(DSC.SAFE)
    static int setpgid(int pid, int pgid) {
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1270716942 = DSUtils.UNKNOWN_INT;
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1270716942;
    }

    
    @DSModeled(DSC.SAFE)
    static int getpgid(int pid) throws IOException {
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1260756067 = DSUtils.UNKNOWN_INT;
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1260756067;
    }

    
    @DSModeled(DSC.SAFE)
    static void reopenStdio(FileDescriptor in,
            FileDescriptor out, FileDescriptor err) throws IOException {
    }

    
    @DSModeled(DSC.SAFE)
    static void setCloseOnExec(FileDescriptor fd, boolean flag) throws IOException {
    }

    
    @DSModeled(DSC.SAFE)
    static long capgetPermitted(int pid) throws IOException {
                long var0F5264038205EDFB1AC05FBB0E8C5E94_1659405050 = DSUtils.UNKNOWN_LONG;
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1659405050;
    }

    
    @DSModeled(DSC.SAFE)
    static void setCapabilities(
            long permittedCapabilities,
            long effectiveCapabilities) throws IOException {
    }

    
    @DSModeled(DSC.SAFE)
    static int selectReadable(FileDescriptor[] fds) throws IOException {
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1197257160 = DSUtils.UNKNOWN_INT;
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1197257160;
    }

    
    @DSModeled(DSC.SAFE)
    static FileDescriptor createFileDescriptor(int fd) throws IOException {
    	return new FileDescriptor();
    }

    
    public static class MethodAndArgsCaller extends Exception implements Runnable {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:10.893 -0400", hash_original_field = "411D2DFDB93368C46AFADBEC76A54162", hash_generated_field = "B855DD63C0CF0451E81317C9109F465D")

        private Method mMethod;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:10.894 -0400", hash_original_field = "E8543AD9E6F42B0AF96855D6D0BAB0A3", hash_generated_field = "36A0BDC0E98A86654E4FB41A74F823AC")

        private String[] mArgs;
        
        @DSModeled(DSC.BAN)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:10.895 -0400", hash_original_method = "B7C77C284F7B165702F670BC703A8A6B", hash_generated_method = "74F6AB53C19992EBB7A9622494594EA9")
        public  MethodAndArgsCaller(Method method, String[] args) {
            mMethod = method;
            mArgs = args;
            // ---------- Original Method ----------
            //mMethod = method;
            //mArgs = args;
        }

        
        @DSModeled(DSC.BAN)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:10.896 -0400", hash_original_method = "9C4F25D836A229393F13206C69120090", hash_generated_method = "6D6767063E10B6B8699CA581AE37AF13")
        public void run() {
            try 
            {
                mMethod.invoke(null, new Object[] { mArgs });
            } //End block
            catch (IllegalAccessException ex)
            {
                RuntimeException varF35D3C95F99DACEE8C542CF38D772C50_1435773278 = new RuntimeException(ex);
                varF35D3C95F99DACEE8C542CF38D772C50_1435773278.addTaint(taint);
                throw varF35D3C95F99DACEE8C542CF38D772C50_1435773278;
            } //End block
            catch (InvocationTargetException ex)
            {
                Throwable cause = ex.getCause();
                if(cause instanceof RuntimeException)                
                {
                    RuntimeException var2BEB6EF3D41E44EED5E35024D3C50335_309821532 = (RuntimeException) cause;
                    var2BEB6EF3D41E44EED5E35024D3C50335_309821532.addTaint(taint);
                    throw var2BEB6EF3D41E44EED5E35024D3C50335_309821532;
                } //End block
                else
                if(cause instanceof Error)                
                {
                    Error varF690D0FEA4496CAA0F487E9481A0D919_351974312 = (Error) cause;
                    varF690D0FEA4496CAA0F487E9481A0D919_351974312.addTaint(taint);
                    throw varF690D0FEA4496CAA0F487E9481A0D919_351974312;
                } //End block
                RuntimeException varF35D3C95F99DACEE8C542CF38D772C50_1295386962 = new RuntimeException(ex);
                varF35D3C95F99DACEE8C542CF38D772C50_1295386962.addTaint(taint);
                throw varF35D3C95F99DACEE8C542CF38D772C50_1295386962;
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


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:10.896 -0400", hash_original_field = "07E71AB65C7C829BB9961A38207CC4B3", hash_generated_field = "2A664B91B7AF4DD6DD39F407BBDAB91B")

    private static final String TAG = "Zygote";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:10.896 -0400", hash_original_field = "74ED4A3339BA719836966555F2BB8456", hash_generated_field = "21A14DBCE7B0B42B26E0AE4D21BE6374")

    private static final String ANDROID_SOCKET_ENV = "ANDROID_SOCKET_zygote";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:10.896 -0400", hash_original_field = "6904B35C1A451347B6DDB8838BF0D5A7", hash_generated_field = "72D0A8D066088F349825C90FFD278BF3")

    private static final int LOG_BOOT_PROGRESS_PRELOAD_START = 3020;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:10.896 -0400", hash_original_field = "6BE8B8852FD8C90D6ABDE3CDD37BA01A", hash_generated_field = "36D14AFABA880F6F31DEC33191D862C7")

    private static final int LOG_BOOT_PROGRESS_PRELOAD_END = 3030;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:10.896 -0400", hash_original_field = "BE2FC9EDC8C9CFA6D74B29E1164114B1", hash_generated_field = "1C4BDCB10C814E5E5C1E121F3CFFB398")

    private static final int PRELOAD_GC_THRESHOLD = 50000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:10.896 -0400", hash_original_field = "53D21B25167F85B220B296F674560AF3", hash_generated_field = "11B5CFA86B8C286EFBAA6F7566AACF92")

    public static final String USAGE_STRING =
            " <\"start-system-server\"|\"\" for startSystemServer>";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:10.896 -0400", hash_original_field = "9DA2EA580D8EE807DAFCCE6BBA0D48C4", hash_generated_field = "9E17DF7A35B42830EDB580D52F5D2BFC")

    private static LocalServerSocket sServerSocket;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:10.896 -0400", hash_original_field = "0D8AC9B29D5FDF7FAC18EB1269D7F6D0", hash_generated_field = "F35B055A0E956F42EA68C0747FE25322")

    private static Resources mResources;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:10.896 -0400", hash_original_field = "383BDC782A0D77C74C0F51745AFDB4C3", hash_generated_field = "CC8FEE4337ADDACC7ADB7DFDC231F802")

    static final int GC_LOOP_COUNT = 10;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:10.896 -0400", hash_original_field = "18C93A25692F82E7B6AC4BDD9E6B3272", hash_generated_field = "470965EC21BC0250593F36CAC4C56B5B")

    private static final boolean ZYGOTE_FORK_MODE = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:10.896 -0400", hash_original_field = "ED5AD2D872F39B9E87A0F7CDDEC53578", hash_generated_field = "D971A35E1DDB9EC284B93F8A315DE174")

    private static final String PRELOADED_CLASSES = "preloaded-classes";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:10.896 -0400", hash_original_field = "854ED3D79F10691E1EDF378691DD893C", hash_generated_field = "217E927B066193DC32AE01A97B64A06F")

    private static final boolean PRELOAD_RESOURCES = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:10.896 -0400", hash_original_field = "82271FEC3EC1DC6127B21091FEB27C0E", hash_generated_field = "B7C284A979FDA8DD7A1E86E6B13F83B4")

    private static final int UNPRIVILEGED_UID = 9999;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:10.897 -0400", hash_original_field = "7F55A4BF3FE31011A2B5E5A987D7431F", hash_generated_field = "20022E96E92B292F7F27BAE668605B1C")

    private static final int UNPRIVILEGED_GID = 9999;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:10.897 -0400", hash_original_field = "FA745CD5D30D9C787B092D405EF77A37", hash_generated_field = "AA8F959796928F28B5B6310780704CB2")

    private static final int ROOT_UID = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:10.897 -0400", hash_original_field = "21C303C2FC2C1A72AED8865024F50115", hash_generated_field = "1A2EF32D420BCC0E5CC1DF0ABF44BE23")

    private static final int ROOT_GID = 0;
}

