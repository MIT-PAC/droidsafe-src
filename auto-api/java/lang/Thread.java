package java.lang;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import dalvik.system.VMStack;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import libcore.util.EmptyArray;

public class Thread implements Runnable {
    volatile VMThread vmThread;
    volatile ThreadGroup group;
    volatile boolean daemon;
    volatile String name;
    volatile int priority;
    volatile long stackSize;
    Runnable target;
    private long id;
    ThreadLocal.Values localValues;
    ThreadLocal.Values inheritableValues;
    private List<Runnable> interruptActions = new ArrayList<Runnable>();
    private ClassLoader contextClassLoader;
    private UncaughtExceptionHandler uncaughtHandler;
    boolean hasBeenStarted = false;
    private int parkState = ParkState.UNPARKED;
    private Object parkBlocker;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.309 -0400", hash_original_method = "A2846A412942D9A4A6734B659C3C08EA", hash_generated_method = "FC648266C8623CAE59D46FDD8401EFDA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Thread() {
        create(null, null, null, 0);
        // ---------- Original Method ----------
        //create(null, null, null, 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.309 -0400", hash_original_method = "FFE43BBD5535897A2D4ADC63E06A2D0F", hash_generated_method = "6ABAA42CB6828F466E69DD86ECB6C992")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Thread(Runnable runnable) {
        dsTaint.addTaint(runnable.dsTaint);
        create(null, runnable, null, 0);
        // ---------- Original Method ----------
        //create(null, runnable, null, 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.310 -0400", hash_original_method = "BDCA95CAB999722EC25DF6B8E927C95F", hash_generated_method = "B6B04C63FE3323866055ED2D8F94995F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Thread(Runnable runnable, String threadName) {
        dsTaint.addTaint(threadName);
        dsTaint.addTaint(runnable.dsTaint);
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        } //End block
        create(null, runnable, threadName, 0);
        // ---------- Original Method ----------
        //if (threadName == null) {
            //throw new NullPointerException();
        //}
        //create(null, runnable, threadName, 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.310 -0400", hash_original_method = "ACB5E26D2EF52FBACC4A4E78EC843CDD", hash_generated_method = "1165CE88E24D13BF282B424982762266")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Thread(String threadName) {
        dsTaint.addTaint(threadName);
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        } //End block
        create(null, null, threadName, 0);
        // ---------- Original Method ----------
        //if (threadName == null) {
            //throw new NullPointerException();
        //}
        //create(null, null, threadName, 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.310 -0400", hash_original_method = "CFE0254168731091471FC08E1B68E532", hash_generated_method = "B27628787EB7E972A863141D59604D88")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Thread(ThreadGroup group, Runnable runnable) {
        dsTaint.addTaint(runnable.dsTaint);
        dsTaint.addTaint(group.dsTaint);
        create(group, runnable, null, 0);
        // ---------- Original Method ----------
        //create(group, runnable, null, 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.311 -0400", hash_original_method = "492306C5FED9EC58991A5E8736E27F15", hash_generated_method = "91B30C86E76BC402F40EFAE4BE4B4DBE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Thread(ThreadGroup group, Runnable runnable, String threadName) {
        dsTaint.addTaint(threadName);
        dsTaint.addTaint(runnable.dsTaint);
        dsTaint.addTaint(group.dsTaint);
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        } //End block
        create(group, runnable, threadName, 0);
        // ---------- Original Method ----------
        //if (threadName == null) {
            //throw new NullPointerException();
        //}
        //create(group, runnable, threadName, 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.311 -0400", hash_original_method = "D83475E079BCC4E2E3558A574C3A704E", hash_generated_method = "C9EF4222598B259FC40C9550215CB44D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Thread(ThreadGroup group, String threadName) {
        dsTaint.addTaint(threadName);
        dsTaint.addTaint(group.dsTaint);
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        } //End block
        create(group, null, threadName, 0);
        // ---------- Original Method ----------
        //if (threadName == null) {
            //throw new NullPointerException();
        //}
        //create(group, null, threadName, 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.311 -0400", hash_original_method = "38DDF80F64A6875AC3B97FC941143FB8", hash_generated_method = "7F244F5BDC154DCB77F15D800634D39F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Thread(ThreadGroup group, Runnable runnable, String threadName, long stackSize) {
        dsTaint.addTaint(threadName);
        dsTaint.addTaint(runnable.dsTaint);
        dsTaint.addTaint(stackSize);
        dsTaint.addTaint(group.dsTaint);
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        } //End block
        create(group, runnable, threadName, stackSize);
        // ---------- Original Method ----------
        //if (threadName == null) {
            //throw new NullPointerException();
        //}
        //create(group, runnable, threadName, stackSize);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.312 -0400", hash_original_method = "DA36D17A4C27DE9C11E6923E1A7A26CA", hash_generated_method = "DFE7FB0AE064929E0F6D1B138ADB752C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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
        {
            if (DroidSafeAndroidRuntime.control) throw new InternalError("group not specified");
        } //End block
        this.target = null;
        this.stackSize = 0;
        this.group.addThread(this);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.313 -0400", hash_original_method = "B7E7B76C5A1CA256325AA2280577DF6E", hash_generated_method = "463FEED50A3D27D50FB0E50A333BC143")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void create(ThreadGroup group, Runnable runnable, String threadName, long stackSize) {
        dsTaint.addTaint(threadName);
        dsTaint.addTaint(runnable.dsTaint);
        dsTaint.addTaint(stackSize);
        dsTaint.addTaint(group.dsTaint);
        Thread currentThread;
        currentThread = Thread.currentThread();
        {
            group = currentThread.getThreadGroup();
        } //End block
        {
            boolean var1C58EACCC96861E06E4F3C98EDF34DE2_2048691269 = (group.isDestroyed());
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalThreadStateException("Group already destroyed");
            } //End block
        } //End collapsed parenthetic
        {
            id = ++Thread.count;
        } //End block
        {
            this.name = "Thread-" + id;
        } //End block
        this.priority = currentThread.getPriority();
        this.contextClassLoader = currentThread.contextClassLoader;
        {
            inheritableValues = new ThreadLocal.Values(currentThread.inheritableValues);
        } //End block
        this.group.addThread(this);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        public static int activeCount() {
        return currentThread().getThreadGroup().activeCount();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.313 -0400", hash_original_method = "9AC5D8EF15BD7837ACD785C0772615A1", hash_generated_method = "58C0335FEF548999868CED53D4078AEE")
    @DSModeled(DSC.SAFE)
    public final void checkAccess() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.314 -0400", hash_original_method = "6B880F3A25E0C40C35D8EAA702DA9116", hash_generated_method = "FD1FF37E93036295AE8795EC17CA3209")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Deprecated
    public int countStackFrames() {
        int var9E94C75F0A654EE4FD94FC83E274820D_1490082640 = (getStackTrace().length);
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return getStackTrace().length;
    }

    
        public static Thread currentThread() {
        return VMThread.currentThread();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.314 -0400", hash_original_method = "E295DBEBB7624DABB0FA2D3E0377892B", hash_generated_method = "36C3BECAF55A9A5399EDB2847CA487F4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Deprecated
    public void destroy() {
        if (DroidSafeAndroidRuntime.control) throw new NoSuchMethodError("Thread.destroy()");
        // ---------- Original Method ----------
        //throw new NoSuchMethodError("Thread.destroy()");
    }

    
        public static void dumpStack() {
        new Throwable("stack dump").printStackTrace();
    }

    
        public static int enumerate(Thread[] threads) {
        Thread thread = Thread.currentThread();
        return thread.getThreadGroup().enumerate(threads);
    }

    
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.315 -0400", hash_original_method = "D65A36EB6AF7077545898D8D2274216D", hash_generated_method = "5BF82424C89F16969873C2C715D7A27F")
    @DSModeled(DSC.BAN)
    public ClassLoader getContextClassLoader() {
        return (ClassLoader)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return contextClassLoader;
    }

    
        public static UncaughtExceptionHandler getDefaultUncaughtExceptionHandler() {
        return defaultUncaughtHandler;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.316 -0400", hash_original_method = "AC34FCBA00CFFBED3290FFC752B7D422", hash_generated_method = "CEC0EAA37DD59216E388387B30D261C5")
    @DSModeled(DSC.SAFE)
    public long getId() {
        return dsTaint.getTaintLong();
        // ---------- Original Method ----------
        //return id;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.319 -0400", hash_original_method = "7070E6AABEDCBA653834DDC8CF79A47C", hash_generated_method = "656D8CA904D03A75C55F220277A90C06")
    @DSModeled(DSC.SAFE)
    public final String getName() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return name;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.320 -0400", hash_original_method = "0FA6C5514FC3354D3A5FFA078FF2070D", hash_generated_method = "38CC6CC3F0ECB14FF831EFB6E61CF3AB")
    @DSModeled(DSC.SAFE)
    public final int getPriority() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return priority;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.320 -0400", hash_original_method = "105ECA4B48BD428C2A4BFADC722280E4", hash_generated_method = "CD4C71076B56B9BC07C097BC46D8038D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public StackTraceElement[] getStackTrace() {
        StackTraceElement ste[];
        ste = VMStack.getThreadStackTrace(this);
        return (StackTraceElement[])dsTaint.getTaint();
        // ---------- Original Method ----------
        //StackTraceElement ste[] = VMStack.getThreadStackTrace(this);
        //return ste != null ? ste : EmptyArray.STACK_TRACE_ELEMENT;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.321 -0400", hash_original_method = "07EB6E55BA9633DD05ED126331098808", hash_generated_method = "87D469E8D26332CD426436152F6FAA39")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.321 -0400", hash_original_method = "00D5D6D0C2A305848EB6704B96DA1F7A", hash_generated_method = "A94991C3027FCBEB6079AEB10347F739")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final ThreadGroup getThreadGroup() {
        {
            boolean var171B2BD556C2DAB7616FF410FA854B68_1294615498 = (getState() == Thread.State.TERMINATED);
        } //End collapsed parenthetic
        return (ThreadGroup)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (getState() == Thread.State.TERMINATED) {
            //return null;
        //} else {
            //return group;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.321 -0400", hash_original_method = "5CF1F81DC91E6D2E78C73116F661ED4D", hash_generated_method = "E58950B893970B45AED1369ADF2FCD37")
    @DSModeled(DSC.SAFE)
    public UncaughtExceptionHandler getUncaughtExceptionHandler() {
        return (UncaughtExceptionHandler)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (uncaughtHandler != null)
            //return uncaughtHandler;
        //else
            //return group;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.322 -0400", hash_original_method = "17DDF3808A6EBB129363B48719FB5512", hash_generated_method = "A6E18F908BBF5EA081EC8BF7D33A91C1")
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

    
        public static boolean interrupted() {
        return VMThread.interrupted();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.322 -0400", hash_original_method = "FDF1C6D176BF98E9EEA025E5AC84BE96", hash_generated_method = "269F75EAF1BE3C4FD9591725166C658C")
    @DSModeled(DSC.SAFE)
    public final boolean isAlive() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return (vmThread != null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.323 -0400", hash_original_method = "C545A28661A0C27F268C3C9CA79B188B", hash_generated_method = "14B6A9EB82BB82C6B1DA2736F3168383")
    @DSModeled(DSC.SAFE)
    public final boolean isDaemon() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return daemon;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.323 -0400", hash_original_method = "8001B196EB7A1BAE7873C2E86818FA5F", hash_generated_method = "5C0BD88EC52BC28D4DEB2E7558222641")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isInterrupted() {
        VMThread vmt;
        vmt = this.vmThread;
        {
            boolean varB147E6E3B016011716EF89C5EF4EE91E_1445670173 = (vmt.isInterrupted());
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //VMThread vmt = this.vmThread;
        //if (vmt != null) {
            //return vmt.isInterrupted();
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.323 -0400", hash_original_method = "39C10B080916DB467DF3B4EA48EC57E3", hash_generated_method = "D2C79D8C8A25ACA3170A4EF08A3F75EC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final void join() throws InterruptedException {
        VMThread t;
        t = vmThread;
        {
            {
                boolean var873063CBC3B5729E18294AEF568DDA2D_864696423 = (isAlive());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.324 -0400", hash_original_method = "4A31F3D41623AEE48E003D8DCAD5BFFA", hash_generated_method = "E8ED09E19CD864F9FBB9B38C98B9552A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final void join(long millis) throws InterruptedException {
        dsTaint.addTaint(millis);
        join(millis, 0);
        // ---------- Original Method ----------
        //join(millis, 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.324 -0400", hash_original_method = "7E549C860CA937D59E3BB1D99D89340F", hash_generated_method = "7B6BCD5AE77892DE54F42486FB98C586")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final void join(long millis, int nanos) throws InterruptedException {
        dsTaint.addTaint(nanos);
        dsTaint.addTaint(millis);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException();
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
                boolean var0566EB6AFDD7377E42AFAFF497085687_1983500137 = (!isAlive());
            } //End collapsed parenthetic
            long nanosToWait;
            nanosToWait = millis * NANOS_PER_MILLI + nanos;
            long start;
            start = System.nanoTime();
            {
                t.wait(millis, nanos);
                {
                    boolean varCB6183A31E0FF6013B5249081F624AB9_1815582229 = (!isAlive());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.325 -0400", hash_original_method = "A6ED0DA6D495D98AD3E3BF5221571689", hash_generated_method = "7127AFE74D1383F789C3C1650F177DCD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Deprecated
    public final void resume() {
        if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.326 -0400", hash_original_method = "74F6289977938D08C5FBC2624A0DC216", hash_generated_method = "2BF63E07544CF8CAC1A6A84003858A15")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void run() {
        {
            target.run();
        } //End block
        // ---------- Original Method ----------
        //if (target != null) {
            //target.run();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.326 -0400", hash_original_method = "93EFC46ED375C1C54A6285C5204CF25C", hash_generated_method = "F5745035FFB5FA4E2BB823CC598473E8")
    @DSModeled(DSC.BAN)
    public void setContextClassLoader(ClassLoader cl) {
        dsTaint.addTaint(cl.dsTaint);
        // ---------- Original Method ----------
        //contextClassLoader = cl;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.326 -0400", hash_original_method = "9670EAA0D97E9800D90F260AB00393C1", hash_generated_method = "F7F23EADC4E250746DD0ECDAE69FB12D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final void setDaemon(boolean isDaemon) {
        dsTaint.addTaint(isDaemon);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalThreadStateException("Thread already started.");
        } //End block
        // ---------- Original Method ----------
        //if (hasBeenStarted) {
            //throw new IllegalThreadStateException("Thread already started."); 
        //}
        //if (vmThread == null) {
            //daemon = isDaemon;
        //}
    }

    
        public static void setDefaultUncaughtExceptionHandler(UncaughtExceptionHandler handler) {
        Thread.defaultUncaughtHandler = handler;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.327 -0400", hash_original_method = "C18D87700F0558E88B776CB695EE515A", hash_generated_method = "BAABE891E3F9BACB7029ED1135C8C89F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final void pushInterruptAction$(Runnable interruptAction) {
        dsTaint.addTaint(interruptAction.dsTaint);
        {
            interruptActions.add(interruptAction);
        } //End block
        {
            boolean var43B340B57A719D4D7C0CFC3F5006FC45_1964502230 = (interruptAction != null && isInterrupted());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.328 -0400", hash_original_method = "134AC2DB3FFDAEE2D6D132954D878FFF", hash_generated_method = "6BB3413A4D3CDAD1592866D26AD96B21")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final void popInterruptAction$(Runnable interruptAction) {
        dsTaint.addTaint(interruptAction.dsTaint);
        {
            Runnable removed;
            removed = interruptActions.remove(interruptActions.size() - 1);
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException(
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.328 -0400", hash_original_method = "52D88413A8A1215EC9D935022AA7508F", hash_generated_method = "DB0D81B1F1400F25DFAA286DA8CC93AF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final void setName(String threadName) {
        dsTaint.addTaint(threadName);
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.328 -0400", hash_original_method = "A91023FCF06B8647A6CEF3B99492A3A2", hash_generated_method = "A83956B1D98BBEF6A1A3BEB39C7B0318")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final void setPriority(int priority) {
        dsTaint.addTaint(priority);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Priority out of range");
        } //End block
        {
            boolean var09022039D3A5CC2E35F1A0263EEA0B28_1553086340 = (priority > group.getMaxPriority());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.328 -0400", hash_original_method = "D58D250923779D2B2016D80FC2081BA1", hash_generated_method = "585F3021CB4ABD9753ADE488DDD8A1B0")
    @DSModeled(DSC.SAFE)
    public void setUncaughtExceptionHandler(UncaughtExceptionHandler handler) {
        dsTaint.addTaint(handler.dsTaint);
        // ---------- Original Method ----------
        //uncaughtHandler = handler;
    }

    
        public static void sleep(long time) throws InterruptedException {
        Thread.sleep(time, 0);
    }

    
        public static void sleep(long millis, int nanos) throws InterruptedException {
        VMThread.sleep(millis, nanos);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.329 -0400", hash_original_method = "389CF6E0D3A08F228CF4E4A156CC86D9", hash_generated_method = "A9E55DD47285DE615AB80AE7D304FD86")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public synchronized void start() {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalThreadStateException("Thread already started.");
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.329 -0400", hash_original_method = "345C33A5CF7530BB38CAED519DB524FA", hash_generated_method = "4CF021D91E790FABEAD72EF8B01ED19B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Deprecated
    public final void stop() {
        stop(new ThreadDeath());
        // ---------- Original Method ----------
        //stop(new ThreadDeath());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.329 -0400", hash_original_method = "B034829378D149E76566D897B904AD02", hash_generated_method = "C79078276977B9F78DCB76AA97D14CEB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Deprecated
    public final synchronized void stop(Throwable throwable) {
        dsTaint.addTaint(throwable.dsTaint);
        if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.330 -0400", hash_original_method = "BFD882A151848FA6FDA9CF11B3EB5020", hash_generated_method = "9A7B3ED01C039412AA9411EB2D88C724")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Deprecated
    public final void suspend() {
        if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.330 -0400", hash_original_method = "E21D755A7854968438B35D363D61DC14", hash_generated_method = "6A1817857CCC4DBB47F531140FC775CF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public String toString() {
        String var043BAB29BDEC42A229FDD571A271B3C3_2104569558 = ("Thread[" + name + "," + priority + "," + group.getName() + "]");
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return "Thread[" + name + "," + priority + "," + group.getName() + "]";
    }

    
        public static void yield() {
        VMThread.yield();
    }

    
        public static boolean holdsLock(Object object) {
        return currentThread().vmThread.holdsLock(object);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.331 -0400", hash_original_method = "A23472E398F1697320641EE9BCE07378", hash_generated_method = "155D260F9601300AEE8BB6DE80919762")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.331 -0400", hash_original_method = "25C50086F373F8B2A1357A67BAD56EA4", hash_generated_method = "3B95F3BD60B4CD4FE216C1FBA18C1422")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void parkFor(long nanos) {
        dsTaint.addTaint(nanos);
        VMThread vmt;
        vmt = vmThread;
        {
            if (DroidSafeAndroidRuntime.control) throw new AssertionError();
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
                if (DroidSafeAndroidRuntime.control) throw new AssertionError(
                            "shouldn't happen: attempt to repark");
            } //End block
            //End case default 
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.332 -0400", hash_original_method = "98F10CBBB26C44644E065EAD29E052AC", hash_generated_method = "09C0B78869214A2AA47CD38E14AD4125")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void parkUntil(long time) {
        dsTaint.addTaint(time);
        VMThread vmt;
        vmt = vmThread;
        {
            if (DroidSafeAndroidRuntime.control) throw new AssertionError();
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
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.333 -0400", hash_original_method = "764167A302C4BA0D6FD2D579A7D47E7F", hash_generated_method = "764167A302C4BA0D6FD2D579A7D47E7F")
                public ParkState ()
        {
        }


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
    
    private static final int NANOS_PER_MILLI = 1000000;
    public static final int MAX_PRIORITY = 10;
    public static final int MIN_PRIORITY = 1;
    public static final int NORM_PRIORITY = 5;
    private static int count = 0;
    private static UncaughtExceptionHandler defaultUncaughtHandler;
}

