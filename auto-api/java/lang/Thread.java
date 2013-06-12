package java.lang;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.runtime.DroidSafeAndroidRuntime;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import dalvik.system.VMStack;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import libcore.util.EmptyArray;

public class Thread implements Runnable {
    private static final int NANOS_PER_MILLI = 1000000;
    public static final int MAX_PRIORITY = 10;
    public static final int MIN_PRIORITY = 1;
    public static final int NORM_PRIORITY = 5;
    volatile VMThread vmThread;
    volatile ThreadGroup group;
    volatile boolean daemon;
    volatile String name;
    volatile int priority;
    volatile long stackSize;
    Runnable target;
    private static int count = 0;
    private long id;
    //ThreadLocal.Values localValues;
    //ThreadLocal.Values inheritableValues;
    private final List<Runnable> interruptActions = new ArrayList<Runnable>();
    private ClassLoader contextClassLoader;
    private UncaughtExceptionHandler uncaughtHandler;
    private static UncaughtExceptionHandler defaultUncaughtHandler;
    boolean hasBeenStarted = false;
    private int parkState = ParkState.UNPARKED;
    private Object parkBlocker;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.959 -0400", hash_original_method = "A2846A412942D9A4A6734B659C3C08EA", hash_generated_method = "AABF0989AE55A6C8F910D5DE21B72532")
    @DSModeled(DSC.SAFE)
    public Thread() {
        create(null, null, null, 0);
        // ---------- Original Method ----------
        //create(null, null, null, 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.959 -0400", hash_original_method = "FFE43BBD5535897A2D4ADC63E06A2D0F", hash_generated_method = "09DEDC0C61B8935B1B855351F7BA4156")
    @DSModeled(DSC.SAFE)
    public Thread(Runnable runnable) {
        dsTaint.addTaint(runnable.dsTaint);
        create(null, runnable, null, 0);
        // ---------- Original Method ----------
        //create(null, runnable, null, 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.959 -0400", hash_original_method = "BDCA95CAB999722EC25DF6B8E927C95F", hash_generated_method = "BF6B65CA4938A2E86873B8EFF7C469A8")
    @DSModeled(DSC.SAFE)
    public Thread(Runnable runnable, String threadName) {
        dsTaint.addTaint(runnable.dsTaint);
        dsTaint.addTaint(threadName);
        if (DroidSafeAndroidRuntime.control) {
            throw new NullPointerException();
        } //End block
        create(null, runnable, threadName, 0);
        // ---------- Original Method ----------
        //if (threadName == null) {
            //throw new NullPointerException();
        //}
        //create(null, runnable, threadName, 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.959 -0400", hash_original_method = "ACB5E26D2EF52FBACC4A4E78EC843CDD", hash_generated_method = "F06EAC98367E05EABACADA9C9A8557C0")
    @DSModeled(DSC.SAFE)
    public Thread(String threadName) {
        dsTaint.addTaint(threadName);
        if (DroidSafeAndroidRuntime.control) {
            throw new NullPointerException();
        } //End block
        create(null, null, threadName, 0);
        // ---------- Original Method ----------
        //if (threadName == null) {
            //throw new NullPointerException();
        //}
        //create(null, null, threadName, 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.959 -0400", hash_original_method = "CFE0254168731091471FC08E1B68E532", hash_generated_method = "E43945BDCEFA5EB5D5D5E31DBC3DA02A")
    @DSModeled(DSC.SAFE)
    public Thread(ThreadGroup group, Runnable runnable) {
        dsTaint.addTaint(runnable.dsTaint);
        dsTaint.addTaint(group.dsTaint);
        create(group, runnable, null, 0);
        // ---------- Original Method ----------
        //create(group, runnable, null, 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.959 -0400", hash_original_method = "492306C5FED9EC58991A5E8736E27F15", hash_generated_method = "97F1F79B38F81C504E81D64F2895EA1B")
    @DSModeled(DSC.SAFE)
    public Thread(ThreadGroup group, Runnable runnable, String threadName) {
        dsTaint.addTaint(runnable.dsTaint);
        dsTaint.addTaint(threadName);
        dsTaint.addTaint(group.dsTaint);
        if (DroidSafeAndroidRuntime.control) {
            throw new NullPointerException();
        } //End block
        create(group, runnable, threadName, 0);
        // ---------- Original Method ----------
        //if (threadName == null) {
            //throw new NullPointerException();
        //}
        //create(group, runnable, threadName, 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.959 -0400", hash_original_method = "D83475E079BCC4E2E3558A574C3A704E", hash_generated_method = "2694A2ECB9C826EAE02B65018922DB85")
    @DSModeled(DSC.SAFE)
    public Thread(ThreadGroup group, String threadName) {
        dsTaint.addTaint(threadName);
        dsTaint.addTaint(group.dsTaint);
        if (DroidSafeAndroidRuntime.control) {
            throw new NullPointerException();
        } //End block
        create(group, null, threadName, 0);
        // ---------- Original Method ----------
        //if (threadName == null) {
            //throw new NullPointerException();
        //}
        //create(group, null, threadName, 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.959 -0400", hash_original_method = "38DDF80F64A6875AC3B97FC941143FB8", hash_generated_method = "B6975D16A69CEA37D895B59C21D8656F")
    @DSModeled(DSC.SAFE)
    public Thread(ThreadGroup group, Runnable runnable, String threadName, long stackSize) {
        dsTaint.addTaint(runnable.dsTaint);
        dsTaint.addTaint(threadName);
        dsTaint.addTaint(stackSize);
        dsTaint.addTaint(group.dsTaint);
        if (DroidSafeAndroidRuntime.control) {
            throw new NullPointerException();
        } //End block
        create(group, runnable, threadName, stackSize);
        // ---------- Original Method ----------
        //if (threadName == null) {
            //throw new NullPointerException();
        //}
        //create(group, runnable, threadName, stackSize);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.959 -0400", hash_original_method = "DA36D17A4C27DE9C11E6923E1A7A26CA", hash_generated_method = "F878B315FDCBA2824C2ECCF130BFD3D6")
    @DSModeled(DSC.SAFE)
     Thread(ThreadGroup group, String name, int priority, boolean daemon) {
        dsTaint.addTaint(priority);
        dsTaint.addTaint(name);
        dsTaint.addTaint(daemon);
        dsTaint.addTaint(group.dsTaint);
        {
            id = ++Thread.count;
        } //End block
        {
            this.name = "Thread-" + id;
        } //End block
        if (DroidSafeAndroidRuntime.control) {
            throw new InternalError("group not specified");
        } //End block
        this.target = null;
        this.stackSize = 0;
        //this.group.addThread(this);
        // ---------- Original Method ----------
        //synchronized (Thread.class) {
            //id = ++Thread.count;
        //}
        //if (name == null) {
            //this.name = "Thread-" + id;
        //} else {
            //this.name = name;
        //}
        //if (group == null) {
            //throw new InternalError("group not specified");
        //}
        //this.group = group;
        //this.target = null;
        //this.stackSize = 0;
        //this.priority = priority;
        //this.daemon = daemon;
        //this.group.addThread(this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.960 -0400", hash_original_method = "B7E7B76C5A1CA256325AA2280577DF6E", hash_generated_method = "E4C4A972F50F482C836F2637871B7B13")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @DSModeled(DSC.BAN)
    private void create(ThreadGroup group, Runnable runnable, String threadName, long stackSize) {
        dsTaint.addTaint(runnable.dsTaint);
        dsTaint.addTaint(threadName);
        dsTaint.addTaint(stackSize);
        dsTaint.addTaint(group.dsTaint);
        Thread currentThread;
        currentThread = Thread.currentThread();
        {
            group = currentThread.getThreadGroup();
        } //End block
        {
            boolean var1C58EACCC96861E06E4F3C98EDF34DE2_465622954 = (group.isDestroyed());
            if (DroidSafeAndroidRuntime.control) {
                throw new IllegalThreadStateException("Group already destroyed");
            } //End block
        } //End collapsed parenthetic
        {
            id = ++Thread.count;
        } //End block
        {
            this.name = "Thread-" + id;
        } //End block
        this.priority = currentThread.getPriority();
        /*
        this.contextClassLoader = currentThread.contextClassLoader;
        {
            inheritableValues = new ThreadLocal.Values(currentThread.inheritableValues);
        } //End block
        this.group.addThread(this);
        */
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.960 -0400", hash_original_method = "72CB3A6A0CD8DFEFDD9F27A9340FE949", hash_generated_method = "E8DF2F9A27CDE94B070C859E848D0FEB")
    public static int activeCount() {
        return currentThread().getThreadGroup().activeCount();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.960 -0400", hash_original_method = "9AC5D8EF15BD7837ACD785C0772615A1", hash_generated_method = "C669480A95355836C191B605390649AF")
    @DSModeled(DSC.SAFE)
    public final void checkAccess() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.960 -0400", hash_original_method = "6B880F3A25E0C40C35D8EAA702DA9116", hash_generated_method = "0A3E926FB0CFB5E49231337ABA2251BA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Deprecated
    public int countStackFrames() {
        int var9E94C75F0A654EE4FD94FC83E274820D_1286457808 = (getStackTrace().length);
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return getStackTrace().length;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.960 -0400", hash_original_method = "E6DEC3347F951D8CF63DAEF794A9852A", hash_generated_method = "A6E83BE8198CFD257937EA056A110E8E")
    public static Thread currentThread() {
        return VMThread.currentThread();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.960 -0400", hash_original_method = "E295DBEBB7624DABB0FA2D3E0377892B", hash_generated_method = "D31BB2F4E04CBD645A5FB6C8F8BB251A")
    @DSModeled(DSC.SAFE)
    @Deprecated
    public void destroy() {
        throw new NoSuchMethodError("Thread.destroy()");
        // ---------- Original Method ----------
        //throw new NoSuchMethodError("Thread.destroy()");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.960 -0400", hash_original_method = "9CF46F98160BA265944E973BF0CF5516", hash_generated_method = "4BD7326C6CB379906F5E516C898AF985")
    public static void dumpStack() {
        new Throwable("stack dump").printStackTrace();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.960 -0400", hash_original_method = "F21037CBC74EFF42DC16954068137FCD", hash_generated_method = "279702287A8803CF7FD9B3CD0FDA5D55")
    public static int enumerate(Thread[] threads) {
        Thread thread = Thread.currentThread();
        return thread.getThreadGroup().enumerate(threads);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.960 -0400", hash_original_method = "D98109DB19C89E6A58A3F60993E1DFAD", hash_generated_method = "EF5362780C4AFA901B2E58705BD5AC3D")
    @DSModeled(DSC.BAN)
    public static Map<Thread, StackTraceElement[]> getAllStackTraces() {
        Map<Thread, StackTraceElement[]> map = new HashMap<Thread, StackTraceElement[]>();
        int count = ThreadGroup.mSystem.activeCount();
        Thread[] threads = new Thread[count + count / 2];
        count = ThreadGroup.mSystem.enumerate(threads);
        for (int i = 0; i < count; i++) {
            map.put(threads[i], threads[i].getStackTrace());
        }
        return map;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.960 -0400", hash_original_method = "D65A36EB6AF7077545898D8D2274216D", hash_generated_method = "D35AE1ECD695A77C63A339FF23C185F0")
    @DSModeled(DSC.BAN)
    public ClassLoader getContextClassLoader() {
        return (ClassLoader)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return contextClassLoader;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.960 -0400", hash_original_method = "73AAE965D068D2FCF4D0B9A099B9DE78", hash_generated_method = "7ABF83C4128010C1D8A2DA917DDD67F1")
    public static UncaughtExceptionHandler getDefaultUncaughtExceptionHandler() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        return defaultUncaughtHandler;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.960 -0400", hash_original_method = "AC34FCBA00CFFBED3290FFC752B7D422", hash_generated_method = "CAE5C50B3C0E5F8EBB6D1EE20336955D")
    @DSModeled(DSC.SAFE)
    public long getId() {
        return dsTaint.getTaintLong();
        // ---------- Original Method ----------
        //return id;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.960 -0400", hash_original_method = "7070E6AABEDCBA653834DDC8CF79A47C", hash_generated_method = "A892EF72E38635393E1E3CB08CBDBB43")
    @DSModeled(DSC.SAFE)
    public final String getName() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return name;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.960 -0400", hash_original_method = "0FA6C5514FC3354D3A5FFA078FF2070D", hash_generated_method = "2829D9BFF7A5F66AEAAE7E437A2DAB2E")
    @DSModeled(DSC.SAFE)
    public final int getPriority() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return priority;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.960 -0400", hash_original_method = "105ECA4B48BD428C2A4BFADC722280E4", hash_generated_method = "2D503B0165355BF745484AF71683D723")
    @DSModeled(DSC.SAFE)
    public StackTraceElement[] getStackTrace() {
        StackTraceElement ste[];
        ste = VMStack.getThreadStackTrace(this);
        return (StackTraceElement[])dsTaint.getTaint();
        // ---------- Original Method ----------
        //StackTraceElement ste[] = VMStack.getThreadStackTrace(this);
        //return ste != null ? ste : EmptyArray.STACK_TRACE_ELEMENT;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.960 -0400", hash_original_method = "07EB6E55BA9633DD05ED126331098808", hash_generated_method = "B5CC0F5FC661E470A53D5B25FB2F4C25")
    @DSModeled(DSC.SAFE)
    public State getState() {
        VMThread vmt;
        vmt = this.vmThread;
        VMThread thread;
        thread = vmThread;
        {
            int state;
            state = thread.getStatus();
        } //End block
        return (State)dsTaint.getTaint();
        // ---------- Original Method ----------
        //VMThread vmt = this.vmThread;
        //VMThread thread = vmThread;
        //if (thread != null) {
            //int state = thread.getStatus();
            //if(state != -1) {
                //return VMThread.STATE_MAP[state];
            //}
        //}
        //return hasBeenStarted ? Thread.State.TERMINATED : Thread.State.NEW;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.960 -0400", hash_original_method = "00D5D6D0C2A305848EB6704B96DA1F7A", hash_generated_method = "FB31A22C7C063891A7558F37201B8958")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final ThreadGroup getThreadGroup() {
        {
            boolean var171B2BD556C2DAB7616FF410FA854B68_481255356 = (getState() == Thread.State.TERMINATED);
        } //End collapsed parenthetic
        return (ThreadGroup)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (getState() == Thread.State.TERMINATED) {
            //return null;
        //} else {
            //return group;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.960 -0400", hash_original_method = "5CF1F81DC91E6D2E78C73116F661ED4D", hash_generated_method = "0B22374EEF6DE0D201D99DA524C3486A")
    @DSModeled(DSC.SAFE)
    public UncaughtExceptionHandler getUncaughtExceptionHandler() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        return (UncaughtExceptionHandler)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (uncaughtHandler != null)
            //return uncaughtHandler;
        //else
            //return group;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.961 -0400", hash_original_method = "17DDF3808A6EBB129363B48719FB5512", hash_generated_method = "8E7C1141DB6F083AEB5D12E692416E29")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void interrupt() {
        {
            {
                int i;
                i = interruptActions.size() - 1;
                {
                    interruptActions.get(i).run();
                } //End block
            } //End collapsed parenthetic
        } //End block
        VMThread vmt;
        vmt = this.vmThread;
        {
            vmt.interrupt();
        } //End block
        // ---------- Original Method ----------
        //synchronized (interruptActions) {
            //for (int i = interruptActions.size() - 1; i >= 0; i--) {
                //interruptActions.get(i).run();
            //}
        //}
        //VMThread vmt = this.vmThread;
        //if (vmt != null) {
            //vmt.interrupt();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.961 -0400", hash_original_method = "B8A4971B71D8B35D3212DC9C05DB29D4", hash_generated_method = "00ED1370A4CE19FDDCF3473034823E48")
    public static boolean interrupted() {
        return VMThread.interrupted();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.961 -0400", hash_original_method = "FDF1C6D176BF98E9EEA025E5AC84BE96", hash_generated_method = "CCCE8F50F544858FC355DE444F385EDF")
    @DSModeled(DSC.SAFE)
    public final boolean isAlive() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return (vmThread != null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.961 -0400", hash_original_method = "C545A28661A0C27F268C3C9CA79B188B", hash_generated_method = "B9CEEF71BA6A3F1B5B02077E87B47AF5")
    @DSModeled(DSC.SAFE)
    public final boolean isDaemon() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return daemon;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.961 -0400", hash_original_method = "8001B196EB7A1BAE7873C2E86818FA5F", hash_generated_method = "8DC3BB62F7200BA21FCDC18C3ACC4980")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isInterrupted() {
        VMThread vmt;
        vmt = this.vmThread;
        {
            boolean varB147E6E3B016011716EF89C5EF4EE91E_1526923121 = (vmt.isInterrupted());
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //VMThread vmt = this.vmThread;
        //if (vmt != null) {
            //return vmt.isInterrupted();
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.961 -0400", hash_original_method = "39C10B080916DB467DF3B4EA48EC57E3", hash_generated_method = "6A77C97753FB7408A66963BBB7842542")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final void join() throws InterruptedException {
        VMThread t;
        t = vmThread;
        {
            {
                boolean var873063CBC3B5729E18294AEF568DDA2D_2040111236 = (isAlive());
                {
                    t.wait();
                } //End block
            } //End collapsed parenthetic
        } //End block
        // ---------- Original Method ----------
        //VMThread t = vmThread;
        //if (t == null) {
            //return;
        //}
        //synchronized (t) {
            //while (isAlive()) {
                //t.wait();
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.961 -0400", hash_original_method = "4A31F3D41623AEE48E003D8DCAD5BFFA", hash_generated_method = "ACD9494E928635F712051BB715889F91")
    @DSModeled(DSC.SAFE)
    public final void join(long millis) throws InterruptedException {
        dsTaint.addTaint(millis);
        join(millis, 0);
        // ---------- Original Method ----------
        //join(millis, 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.961 -0400", hash_original_method = "7E549C860CA937D59E3BB1D99D89340F", hash_generated_method = "F1621E984306AFA0AD90F0616FE67FB7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final void join(long millis, int nanos) throws InterruptedException {
        dsTaint.addTaint(nanos);
        dsTaint.addTaint(millis);
        if (DroidSafeAndroidRuntime.control) {
            throw new IllegalArgumentException();
        } //End block
        boolean overflow;
        overflow = millis >= (Long.MAX_VALUE - nanos) / NANOS_PER_MILLI;
        boolean forever;
        forever = (millis | nanos) == 0;
        {
            join();
        } //End block
        VMThread t;
        t = vmThread;
        {
            {
                boolean var0566EB6AFDD7377E42AFAFF497085687_156979720 = (!isAlive());
            } //End collapsed parenthetic
            long nanosToWait;
            nanosToWait = millis * NANOS_PER_MILLI + nanos;
            long start;
            start = System.nanoTime();
            {
                t.wait(millis, nanos);
                {
                    boolean varCB6183A31E0FF6013B5249081F624AB9_1081281451 = (!isAlive());
                } //End collapsed parenthetic
                long nanosElapsed;
                nanosElapsed = System.nanoTime() - start;
                long nanosRemaining;
                nanosRemaining = nanosToWait - nanosElapsed;
                millis = nanosRemaining / NANOS_PER_MILLI;
                nanos = (int) (nanosRemaining - millis * NANOS_PER_MILLI);
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.961 -0400", hash_original_method = "A6ED0DA6D495D98AD3E3BF5221571689", hash_generated_method = "3CA5CC976CCD9F76CE9C1BF7CB1480C4")
    @DSModeled(DSC.SAFE)
    @Deprecated
    public final void resume() {
        throw new UnsupportedOperationException();
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.961 -0400", hash_original_method = "74F6289977938D08C5FBC2624A0DC216", hash_generated_method = "EDF4A135A398941C607D650945A09BC9")
    @DSModeled(DSC.SAFE)
    public void run() {
        {
            target.run();
        } //End block
        // ---------- Original Method ----------
        //if (target != null) {
            //target.run();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.961 -0400", hash_original_method = "93EFC46ED375C1C54A6285C5204CF25C", hash_generated_method = "0EEEF2F2223C4D203D5CD685A9B170C7")
    @DSModeled(DSC.BAN)
    public void setContextClassLoader(ClassLoader cl) {
        dsTaint.addTaint(cl.dsTaint);
        // ---------- Original Method ----------
        //contextClassLoader = cl;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.961 -0400", hash_original_method = "9670EAA0D97E9800D90F260AB00393C1", hash_generated_method = "7105B34946B75C9DBB6152DE00AB81A7")
    @DSModeled(DSC.SAFE)
    public final void setDaemon(boolean isDaemon) {
        dsTaint.addTaint(isDaemon);
        {
            throw new IllegalThreadStateException("Thread already started.");
        } //End block
        // ---------- Original Method ----------
        //if (hasBeenStarted) {
            //throw new IllegalThreadStateException("Thread already started."); 
        //}
        //if (vmThread == null) {
            //daemon = isDaemon;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.961 -0400", hash_original_method = "95384CA17BFB199A9F049656335D2B20", hash_generated_method = "C9A04E65A790F4E7C7743C38C536F6E2")
    public static void setDefaultUncaughtExceptionHandler(UncaughtExceptionHandler handler) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        Thread.defaultUncaughtHandler = handler;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.962 -0400", hash_original_method = "C18D87700F0558E88B776CB695EE515A", hash_generated_method = "84629E5125DEA7DEF65B636A8596D9DC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final void pushInterruptAction$(Runnable interruptAction) {
        dsTaint.addTaint(interruptAction.dsTaint);
        {
            interruptActions.add(interruptAction);
        } //End block
        {
            boolean var43B340B57A719D4D7C0CFC3F5006FC45_1470095808 = (interruptAction != null && isInterrupted());
            {
                interruptAction.run();
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //synchronized (interruptActions) {
            //interruptActions.add(interruptAction);
        //}
        //if (interruptAction != null && isInterrupted()) {
            //interruptAction.run();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.962 -0400", hash_original_method = "134AC2DB3FFDAEE2D6D132954D878FFF", hash_generated_method = "CB80E5C101E63E981ED7993C446BB1AF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final void popInterruptAction$(Runnable interruptAction) {
        dsTaint.addTaint(interruptAction.dsTaint);
        {
            Runnable removed;
            removed = interruptActions.remove(interruptActions.size() - 1);
            {
                throw new IllegalArgumentException(
                        "Expected " + interruptAction + " but was " + removed);
            } //End block
        } //End block
        // ---------- Original Method ----------
        //synchronized (interruptActions) {
            //Runnable removed = interruptActions.remove(interruptActions.size() - 1);
            //if (interruptAction != removed) {
                //throw new IllegalArgumentException(
                        //"Expected " + interruptAction + " but was " + removed);
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.962 -0400", hash_original_method = "52D88413A8A1215EC9D935022AA7508F", hash_generated_method = "CB9009DCAF7CB60F085B833E2913DAAD")
    @DSModeled(DSC.SAFE)
    public final void setName(String threadName) {
        dsTaint.addTaint(threadName);
        if (DroidSafeAndroidRuntime.control) {
            throw new NullPointerException();
        } //End block
        VMThread vmt;
        vmt = this.vmThread;
        {
            vmt.nameChanged(threadName);
        } //End block
        // ---------- Original Method ----------
        //if (threadName == null) {
            //throw new NullPointerException();
        //}
        //name = threadName;
        //VMThread vmt = this.vmThread;
        //if (vmt != null) {
            //vmt.nameChanged(threadName);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.962 -0400", hash_original_method = "A91023FCF06B8647A6CEF3B99492A3A2", hash_generated_method = "F85A806585A18F62B8248529E04DA3D0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final void setPriority(int priority) {
        dsTaint.addTaint(priority);
        if (DroidSafeAndroidRuntime.control) {
            throw new IllegalArgumentException("Priority out of range");
        } //End block
        {
            boolean var09022039D3A5CC2E35F1A0263EEA0B28_1983489193 = (priority > group.getMaxPriority());
            {
                priority = group.getMaxPriority();
            } //End block
        } //End collapsed parenthetic
        VMThread vmt;
        vmt = this.vmThread;
        {
            vmt.setPriority(priority);
        } //End block
        // ---------- Original Method ----------
        //if (priority < Thread.MIN_PRIORITY || priority > Thread.MAX_PRIORITY) {
            //throw new IllegalArgumentException("Priority out of range"); 
        //}
        //if (priority > group.getMaxPriority()) {
            //priority = group.getMaxPriority();
        //}
        //this.priority = priority;
        //VMThread vmt = this.vmThread;
        //if (vmt != null) {
            //vmt.setPriority(priority);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.962 -0400", hash_original_method = "D58D250923779D2B2016D80FC2081BA1", hash_generated_method = "E461014F5AB946CEF5EED6D59E0FDC79")
    @DSModeled(DSC.SAFE)
    public void setUncaughtExceptionHandler(UncaughtExceptionHandler handler) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(handler.dsTaint);
        // ---------- Original Method ----------
        //uncaughtHandler = handler;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.962 -0400", hash_original_method = "6EAEFD6D0AE091A9829D7DAE1948EA2E", hash_generated_method = "321DA4B5D3B0E5CF8FEB944014F5F83B")
    public static void sleep(long time) throws InterruptedException {
        Thread.sleep(time, 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.962 -0400", hash_original_method = "396ED61128C8E7F854EC39C7FFEB7DA7", hash_generated_method = "57206F2A678774ADCB68A0F7A2CD75BD")
    public static void sleep(long millis, int nanos) throws InterruptedException {
        VMThread.sleep(millis, nanos);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.962 -0400", hash_original_method = "389CF6E0D3A08F228CF4E4A156CC86D9", hash_generated_method = "69D6095A4846731D95288C9CEA71688B")
    @DSModeled(DSC.SAFE)
    public synchronized void start() {
        if (DroidSafeAndroidRuntime.control) {
            throw new IllegalThreadStateException("Thread already started.");
        } //End block
        hasBeenStarted = true;
        VMThread.create(this, stackSize);
        // ---------- Original Method ----------
        //if (hasBeenStarted) {
            //throw new IllegalThreadStateException("Thread already started."); 
        //}
        //hasBeenStarted = true;
        //VMThread.create(this, stackSize);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.962 -0400", hash_original_method = "345C33A5CF7530BB38CAED519DB524FA", hash_generated_method = "0831E683F381D9AEE72013F922D6B481")
    @DSModeled(DSC.SAFE)
    @Deprecated
    public final void stop() {
        stop(new ThreadDeath());
        // ---------- Original Method ----------
        //stop(new ThreadDeath());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.962 -0400", hash_original_method = "B034829378D149E76566D897B904AD02", hash_generated_method = "BB2FE863D4BE639E087C9F1B9932AE4C")
    @DSModeled(DSC.SAFE)
    @Deprecated
    public final synchronized void stop(Throwable throwable) {
        dsTaint.addTaint(throwable.dsTaint);
        throw new UnsupportedOperationException();
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.962 -0400", hash_original_method = "BFD882A151848FA6FDA9CF11B3EB5020", hash_generated_method = "55AC15CECDEB360A71A0BFCB8D42011F")
    @DSModeled(DSC.SAFE)
    @Deprecated
    public final void suspend() {
        throw new UnsupportedOperationException();
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.962 -0400", hash_original_method = "E21D755A7854968438B35D363D61DC14", hash_generated_method = "3EB1C5B560FEB96BAF020A45C24DD577")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public String toString() {
        String var043BAB29BDEC42A229FDD571A271B3C3_2060741756 = ("Thread[" + name + "," + priority + "," + group.getName() + "]");
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return "Thread[" + name + "," + priority + "," + group.getName() + "]";
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.962 -0400", hash_original_method = "20B3C869DA440A74B56436DD2A7E18B0", hash_generated_method = "ECC5CEEE91AB0DE77B9F3B933211D215")
    public static void yield() {
        VMThread.yield();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.962 -0400", hash_original_method = "4BFB422FC2892097647B5CFF3006D866", hash_generated_method = "1BCBF2A06539CEF9F83D2539DCAFCEAE")
    public static boolean holdsLock(Object object) {
        return currentThread().vmThread.holdsLock(object);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.962 -0400", hash_original_method = "A23472E398F1697320641EE9BCE07378", hash_generated_method = "CEB2E89043FF58C5ADDC7DFFB8991AB5")
    @DSModeled(DSC.SAFE)
    public void unpark() {
        VMThread vmt;
        vmt = vmThread;
        {
            parkState = ParkState.PREEMPTIVELY_UNPARKED;
        } //End block
        {
            //Begin case ParkState.UNPARKED 
            {
                parkState = ParkState.PREEMPTIVELY_UNPARKED;
            } //End block
            //End case ParkState.UNPARKED 
            //Begin case default 
            {
                parkState = ParkState.UNPARKED;
                vmt.notifyAll();
            } //End block
            //End case default 
        } //End block
        // ---------- Original Method ----------
        //VMThread vmt = vmThread;
        //if (vmt == null) {
            //parkState = ParkState.PREEMPTIVELY_UNPARKED;
            //return;
        //}
        //synchronized (vmt) {
            //switch (parkState) {
                //case ParkState.PREEMPTIVELY_UNPARKED: {
                    //break;
                //}
                //case ParkState.UNPARKED: {
                    //parkState = ParkState.PREEMPTIVELY_UNPARKED;
                    //break;
                //}
                //default : {
                    //parkState = ParkState.UNPARKED;
                    //vmt.notifyAll();
                    //break;
                //}
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.963 -0400", hash_original_method = "25C50086F373F8B2A1357A67BAD56EA4", hash_generated_method = "11937FA3B08EF68F356F784591B494BA")
    @DSModeled(DSC.SAFE)
    public void parkFor(long nanos) {
        dsTaint.addTaint(nanos);
        VMThread vmt;
        vmt = vmThread;
        if (DroidSafeAndroidRuntime.control) {
            throw new AssertionError();
        } //End block
        {
            //Begin case ParkState.PREEMPTIVELY_UNPARKED 
            {
                parkState = ParkState.UNPARKED;
            } //End block
            //End case ParkState.PREEMPTIVELY_UNPARKED 
            //Begin case ParkState.UNPARKED 
            {
                long millis;
                millis = nanos / NANOS_PER_MILLI;
                nanos %= NANOS_PER_MILLI;
                parkState = ParkState.PARKED;
                try 
                {
                    vmt.wait(millis, (int) nanos);
                } //End block
                catch (InterruptedException ex)
                {
                    interrupt();
                } //End block
                finally 
                {
                    {
                        parkState = ParkState.UNPARKED;
                    } //End block
                } //End block
            } //End block
            //End case ParkState.UNPARKED 
            //Begin case default 
            {
                throw new AssertionError(
                            "shouldn't happen: attempt to repark");
            } //End block
            //End case default 
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.963 -0400", hash_original_method = "98F10CBBB26C44644E065EAD29E052AC", hash_generated_method = "009F730A2C59F31E03C45DE2B77E56AD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void parkUntil(long time) {
        dsTaint.addTaint(time);
        VMThread vmt;
        vmt = vmThread;
        if (DroidSafeAndroidRuntime.control) {
            throw new AssertionError();
        } //End block
        
        {
            long delayMillis;
            delayMillis = time - System.currentTimeMillis();
            {
                parkState = ParkState.UNPARKED;
            } //End block
            {
                parkFor(delayMillis * NANOS_PER_MILLI);
            } //End block
        } //End block
        // ---------- Original Method ----------
        //VMThread vmt = vmThread;
        //if (vmt == null) {
            //throw new AssertionError();
        //}
        //synchronized (vmt) {
            //long delayMillis = time - System.currentTimeMillis();
            //if (delayMillis <= 0) {
                //parkState = ParkState.UNPARKED;
            //} else {
                //parkFor(delayMillis * NANOS_PER_MILLI);
            //}
        //}
    }

    
    private static class ParkState {
        private static final int UNPARKED = 1;
        private static final int PREEMPTIVELY_UNPARKED = 2;
        private static final int PARKED = 3;
        
    }


    
    public enum State {
        NEW,
        RUNNABLE,
        BLOCKED,
        WAITING,
        TIMED_WAITING,
        TERMINATED
    }

    
    public static interface UncaughtExceptionHandler {
        
        void uncaughtException(Thread thread, Throwable ex);
    }
    
}


