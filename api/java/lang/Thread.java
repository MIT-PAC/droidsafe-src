package java.lang;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import dalvik.system.VMStack;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import libcore.util.EmptyArray;

public class Thread implements Runnable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:47.486 -0400", hash_original_field = "DFCB349389E84D15F92F0101BDA522EF", hash_generated_field = "AD2271ADED5B0642EAD7F6C10D7138A3")

    volatile VMThread vmThread;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:47.486 -0400", hash_original_field = "DB0F6F37EBEB6EA09489124345AF2A45", hash_generated_field = "323908075291FF73A0BF0480EC78D762")

    volatile ThreadGroup group;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:47.486 -0400", hash_original_field = "1F15FCF5421EECD6CA1B61337C319495", hash_generated_field = "1ED59F53ED2B99A4AD9663473B1CC006")

    volatile boolean daemon;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:47.486 -0400", hash_original_field = "B068931CC450442B63F5B3D276EA4297", hash_generated_field = "34558C70E1377442D4C0DBDA56BC6C23")

    volatile String name;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:47.486 -0400", hash_original_field = "B988295C268025B49DFB3DF26171DDC3", hash_generated_field = "FDCCFF27A359BAE03856205C3A73A167")

    volatile int priority;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:47.486 -0400", hash_original_field = "DE15E127B153666F6C6C4FBCAE60419B", hash_generated_field = "31CCA7F61A6273CAFC2F2A0EB46C6C22")

    volatile long stackSize;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:47.486 -0400", hash_original_field = "42AEFBAE01D2DFD981F7DA7D823D689E", hash_generated_field = "3BC51F00CA4514C3C4790A78C316DD07")

    Runnable target;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:47.486 -0400", hash_original_field = "B80BB7740288FDA1F201890375A60C8F", hash_generated_field = "AE2623257C6319B5969DD2321BB374E1")

    private long id;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:47.486 -0400", hash_original_field = "6996C07FA899CEE946C99E7A25F61CC0", hash_generated_field = "BC582D53333FA9EE36376F01B3892F08")

    ThreadLocal.Values localValues;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:47.487 -0400", hash_original_field = "A9F47F486EE26178B4A9BD31D96AF7BF", hash_generated_field = "1DCD99C357BDD63DBAEA19AB3742D070")

    ThreadLocal.Values inheritableValues;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:47.487 -0400", hash_original_field = "39B85D264A49C16734A98A1B294FEB8F", hash_generated_field = "90F6FDD1E7EA8160FB4E33738C8B4E2A")

    private final List<Runnable> interruptActions = new ArrayList<Runnable>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:47.487 -0400", hash_original_field = "8E1DEE07E23DAA726BAAF0EE9C3C8EE1", hash_generated_field = "C41102AB5C0E4C512DB1FC97849C5D3F")

    private ClassLoader contextClassLoader;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:47.487 -0400", hash_original_field = "D620DC3DE4E8991B36D1C529F352B7D6", hash_generated_field = "9E70AF0C0F09E0E8D22000D357561505")

    private UncaughtExceptionHandler uncaughtHandler;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:47.487 -0400", hash_original_field = "B34C39ECBBEB4BBF8B9FDE58CF443A44", hash_generated_field = "F52710C226B829B42671DDE4B1108733")

    boolean hasBeenStarted = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:47.487 -0400", hash_original_field = "A868BAFA6B5FA0E61CE2762A9B315944", hash_generated_field = "1586B270E49D73D94EC53EC7F719398A")

    private int parkState = ParkState.UNPARKED;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:47.487 -0400", hash_original_field = "14EE858A6EC2B082926F68B4AA434051", hash_generated_field = "34932EF005581D2A5FD235907377EED6")

    private Object parkBlocker;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:47.487 -0400", hash_original_method = "A2846A412942D9A4A6734B659C3C08EA", hash_generated_method = "FC648266C8623CAE59D46FDD8401EFDA")
    public  Thread() {
        create(null, null, null, 0);
        // ---------- Original Method ----------
        //create(null, null, null, 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:47.488 -0400", hash_original_method = "FFE43BBD5535897A2D4ADC63E06A2D0F", hash_generated_method = "3784830CC12A01134E29A04BE69E0386")
    public  Thread(Runnable runnable) {
        addTaint(runnable.getTaint());
        create(null, runnable, null, 0);
        // ---------- Original Method ----------
        //create(null, runnable, null, 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:47.488 -0400", hash_original_method = "BDCA95CAB999722EC25DF6B8E927C95F", hash_generated_method = "9AE6D43B7355DBE568A6ED32DB1A5579")
    public  Thread(Runnable runnable, String threadName) {
        addTaint(threadName.getTaint());
        addTaint(runnable.getTaint());
    if(threadName == null)        
        {
            NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_739860335 = new NullPointerException();
            var7338BC9F48D81FE0BBD6183F4014DCC4_739860335.addTaint(taint);
            throw var7338BC9F48D81FE0BBD6183F4014DCC4_739860335;
        } //End block
        create(null, runnable, threadName, 0);
        // ---------- Original Method ----------
        //if (threadName == null) {
            //throw new NullPointerException();
        //}
        //create(null, runnable, threadName, 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:47.489 -0400", hash_original_method = "ACB5E26D2EF52FBACC4A4E78EC843CDD", hash_generated_method = "B00F27225392636AFE706D12567EF45F")
    public  Thread(String threadName) {
        addTaint(threadName.getTaint());
    if(threadName == null)        
        {
            NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_1365240904 = new NullPointerException();
            var7338BC9F48D81FE0BBD6183F4014DCC4_1365240904.addTaint(taint);
            throw var7338BC9F48D81FE0BBD6183F4014DCC4_1365240904;
        } //End block
        create(null, null, threadName, 0);
        // ---------- Original Method ----------
        //if (threadName == null) {
            //throw new NullPointerException();
        //}
        //create(null, null, threadName, 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:47.489 -0400", hash_original_method = "CFE0254168731091471FC08E1B68E532", hash_generated_method = "853E07A889463840212E70255D3EEDAF")
    public  Thread(ThreadGroup group, Runnable runnable) {
        addTaint(runnable.getTaint());
        addTaint(group.getTaint());
        create(group, runnable, null, 0);
        // ---------- Original Method ----------
        //create(group, runnable, null, 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:47.489 -0400", hash_original_method = "492306C5FED9EC58991A5E8736E27F15", hash_generated_method = "497802ED7AE3C273D7CB077D6F09AD97")
    public  Thread(ThreadGroup group, Runnable runnable, String threadName) {
        addTaint(threadName.getTaint());
        addTaint(runnable.getTaint());
        addTaint(group.getTaint());
    if(threadName == null)        
        {
            NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_1489618643 = new NullPointerException();
            var7338BC9F48D81FE0BBD6183F4014DCC4_1489618643.addTaint(taint);
            throw var7338BC9F48D81FE0BBD6183F4014DCC4_1489618643;
        } //End block
        create(group, runnable, threadName, 0);
        // ---------- Original Method ----------
        //if (threadName == null) {
            //throw new NullPointerException();
        //}
        //create(group, runnable, threadName, 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:47.490 -0400", hash_original_method = "D83475E079BCC4E2E3558A574C3A704E", hash_generated_method = "37417F4F63139B4E9E86CEB1068AE3B1")
    public  Thread(ThreadGroup group, String threadName) {
        addTaint(threadName.getTaint());
        addTaint(group.getTaint());
    if(threadName == null)        
        {
            NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_890149603 = new NullPointerException();
            var7338BC9F48D81FE0BBD6183F4014DCC4_890149603.addTaint(taint);
            throw var7338BC9F48D81FE0BBD6183F4014DCC4_890149603;
        } //End block
        create(group, null, threadName, 0);
        // ---------- Original Method ----------
        //if (threadName == null) {
            //throw new NullPointerException();
        //}
        //create(group, null, threadName, 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:47.490 -0400", hash_original_method = "38DDF80F64A6875AC3B97FC941143FB8", hash_generated_method = "6B3ACF2B260C9CC4D9942E6449CADC2B")
    public  Thread(ThreadGroup group, Runnable runnable, String threadName, long stackSize) {
        addTaint(stackSize);
        addTaint(threadName.getTaint());
        addTaint(runnable.getTaint());
        addTaint(group.getTaint());
    if(threadName == null)        
        {
            NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_1652810951 = new NullPointerException();
            var7338BC9F48D81FE0BBD6183F4014DCC4_1652810951.addTaint(taint);
            throw var7338BC9F48D81FE0BBD6183F4014DCC4_1652810951;
        } //End block
        create(group, runnable, threadName, stackSize);
        // ---------- Original Method ----------
        //if (threadName == null) {
            //throw new NullPointerException();
        //}
        //create(group, runnable, threadName, stackSize);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:47.493 -0400", hash_original_method = "DA36D17A4C27DE9C11E6923E1A7A26CA", hash_generated_method = "63D15D421DB3245126E760C8549E4BD0")
      Thread(ThreadGroup group, String name, int priority, boolean daemon) {
        synchronized
(Thread.class)        {
            id = ++Thread.count;
        } //End block
    if(name == null)        
        {
            this.name = "Thread-" + id;
        } //End block
        else
        {
            this.name = name;
        } //End block
    if(group == null)        
        {
            InternalError var9120CCB88F897215235B0E8DBA5319D5_388258184 = new InternalError("group not specified");
            var9120CCB88F897215235B0E8DBA5319D5_388258184.addTaint(taint);
            throw var9120CCB88F897215235B0E8DBA5319D5_388258184;
        } //End block
        this.group = group;
        this.target = null;
        this.stackSize = 0;
        this.priority = priority;
        this.daemon = daemon;
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

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:47.496 -0400", hash_original_method = "B7E7B76C5A1CA256325AA2280577DF6E", hash_generated_method = "8CD03064E9444E26FE9E865D699EF5D9")
    private void create(ThreadGroup group, Runnable runnable, String threadName, long stackSize) {
        Thread currentThread = Thread.currentThread();
    if(group == null)        
        {
            group = currentThread.getThreadGroup();
        } //End block
    if(group.isDestroyed())        
        {
            IllegalThreadStateException varC058BA3B80F847C4D37109956EBCEA2A_1017812460 = new IllegalThreadStateException("Group already destroyed");
            varC058BA3B80F847C4D37109956EBCEA2A_1017812460.addTaint(taint);
            throw varC058BA3B80F847C4D37109956EBCEA2A_1017812460;
        } //End block
        this.group = group;
        synchronized
(Thread.class)        {
            id = ++Thread.count;
        } //End block
    if(threadName == null)        
        {
            this.name = "Thread-" + id;
        } //End block
        else
        {
            this.name = threadName;
        } //End block
        this.target = runnable;
        this.stackSize = stackSize;
        this.priority = currentThread.getPriority();
        this.contextClassLoader = currentThread.contextClassLoader;
    if(currentThread.inheritableValues != null)        
        {
            inheritableValues = new ThreadLocal.Values(currentThread.inheritableValues);
        } //End block
        this.group.addThread(this);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.SPEC)
    public static int activeCount() {
        return currentThread().getThreadGroup().activeCount();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:47.497 -0400", hash_original_method = "9AC5D8EF15BD7837ACD785C0772615A1", hash_generated_method = "58C0335FEF548999868CED53D4078AEE")
    public final void checkAccess() {
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:47.498 -0400", hash_original_method = "6B880F3A25E0C40C35D8EAA702DA9116", hash_generated_method = "674EBD876BA068F6148E932C6EEB7966")
    @Deprecated
    public int countStackFrames() {
        int varE7DCDEAB275966ADC28F03E09ECA3812_1017389547 = (getStackTrace().length);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1548036177 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1548036177;
        // ---------- Original Method ----------
        //return getStackTrace().length;
    }

    
        @DSModeled(DSC.SPEC)
    public static Thread currentThread() {
        return VMThread.currentThread();
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:47.498 -0400", hash_original_method = "E295DBEBB7624DABB0FA2D3E0377892B", hash_generated_method = "AAC50DEFEEDD4BF3E7AF73E5FDF67A8E")
    @Deprecated
    public void destroy() {
        NoSuchMethodError varEC935BC28734C445C690AFF68B3FA782_1112292980 = new NoSuchMethodError("Thread.destroy()");
        varEC935BC28734C445C690AFF68B3FA782_1112292980.addTaint(taint);
        throw varEC935BC28734C445C690AFF68B3FA782_1112292980;
        // ---------- Original Method ----------
        //throw new NoSuchMethodError("Thread.destroy()");
    }

    
        @DSModeled(DSC.SPEC)
    public static void dumpStack() {
        new Throwable("stack dump").printStackTrace();
    }

    
        @DSModeled(DSC.SPEC)
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

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:47.500 -0400", hash_original_method = "D65A36EB6AF7077545898D8D2274216D", hash_generated_method = "F858D604933D6354BAA79FB8133F71C7")
    public ClassLoader getContextClassLoader() {
ClassLoader varCDB6A46B81C356659A30478714667CAA_2000297776 =         contextClassLoader;
        varCDB6A46B81C356659A30478714667CAA_2000297776.addTaint(taint);
        return varCDB6A46B81C356659A30478714667CAA_2000297776;
        // ---------- Original Method ----------
        //return contextClassLoader;
    }

    
        @DSModeled(DSC.SPEC)
    public static UncaughtExceptionHandler getDefaultUncaughtExceptionHandler() {
        return defaultUncaughtHandler;
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:47.500 -0400", hash_original_method = "AC34FCBA00CFFBED3290FFC752B7D422", hash_generated_method = "65042993FB88CFA38ADBE0B317C8AE60")
    public long getId() {
        long varB80BB7740288FDA1F201890375A60C8F_308727485 = (id);
                long var0F5264038205EDFB1AC05FBB0E8C5E94_1604225939 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1604225939;
        // ---------- Original Method ----------
        //return id;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:47.500 -0400", hash_original_method = "7070E6AABEDCBA653834DDC8CF79A47C", hash_generated_method = "8E16323CC155117AB86DA0CFAA597A07")
    public final String getName() {
String varB017984728AC60AD1F0BF8734F33F15C_1548546710 =         name;
        varB017984728AC60AD1F0BF8734F33F15C_1548546710.addTaint(taint);
        return varB017984728AC60AD1F0BF8734F33F15C_1548546710;
        // ---------- Original Method ----------
        //return name;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:47.501 -0400", hash_original_method = "0FA6C5514FC3354D3A5FFA078FF2070D", hash_generated_method = "649A8CFF157B4A7C2EA961DD99AACE6E")
    public final int getPriority() {
        int varB988295C268025B49DFB3DF26171DDC3_468655963 = (priority);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_457481528 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_457481528;
        // ---------- Original Method ----------
        //return priority;
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:47.501 -0400", hash_original_method = "105ECA4B48BD428C2A4BFADC722280E4", hash_generated_method = "6956B779EF327367D8D65669EF396C24")
    public StackTraceElement[] getStackTrace() {
        StackTraceElement ste[] = VMStack.getThreadStackTrace(this);
StackTraceElement[] var4BE632EBE6A3388F93FE2D88ACD3A469_360630139 =         ste != null ? ste : EmptyArray.STACK_TRACE_ELEMENT;
        var4BE632EBE6A3388F93FE2D88ACD3A469_360630139.addTaint(taint);
        return var4BE632EBE6A3388F93FE2D88ACD3A469_360630139;
        // ---------- Original Method ----------
        //StackTraceElement ste[] = VMStack.getThreadStackTrace(this);
        //return ste != null ? ste : EmptyArray.STACK_TRACE_ELEMENT;
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:47.502 -0400", hash_original_method = "07EB6E55BA9633DD05ED126331098808", hash_generated_method = "FCE4420724D8E1329F48763FF17239D5")
    public State getState() {
        VMThread vmt = this.vmThread;
        VMThread thread = vmThread;
    if(thread != null)        
        {
            int state = thread.getStatus();
    if(state != -1)            
            {
State var2D991B4F3C5F46C730CE990DC46EDE7F_1265777311 =                 VMThread.STATE_MAP[state];
                var2D991B4F3C5F46C730CE990DC46EDE7F_1265777311.addTaint(taint);
                return var2D991B4F3C5F46C730CE990DC46EDE7F_1265777311;
            } //End block
        } //End block
State varFFFA24361953E87A22A606CCE4DC911E_1156697228 =         hasBeenStarted ? Thread.State.TERMINATED : Thread.State.NEW;
        varFFFA24361953E87A22A606CCE4DC911E_1156697228.addTaint(taint);
        return varFFFA24361953E87A22A606CCE4DC911E_1156697228;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:47.502 -0400", hash_original_method = "00D5D6D0C2A305848EB6704B96DA1F7A", hash_generated_method = "8B7E981EE1CAB086E65D90E3B3BC0871")
    public final ThreadGroup getThreadGroup() {
    if(getState() == Thread.State.TERMINATED)        
        {
ThreadGroup var540C13E9E156B687226421B24F2DF178_559793405 =             null;
            var540C13E9E156B687226421B24F2DF178_559793405.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_559793405;
        } //End block
        else
        {
ThreadGroup varD15A27BD67EB0D670CD5C298FF20B74F_1202712973 =             group;
            varD15A27BD67EB0D670CD5C298FF20B74F_1202712973.addTaint(taint);
            return varD15A27BD67EB0D670CD5C298FF20B74F_1202712973;
        } //End block
        // ---------- Original Method ----------
        //if (getState() == Thread.State.TERMINATED) {
            //return null;
        //} else {
            //return group;
        //}
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:47.503 -0400", hash_original_method = "5CF1F81DC91E6D2E78C73116F661ED4D", hash_generated_method = "8F2423F23787477B292CB4C3CC81965A")
    public UncaughtExceptionHandler getUncaughtExceptionHandler() {
    if(uncaughtHandler != null)        
        {
UncaughtExceptionHandler var3EAD0AF1B7D4B4A20305483BB4DE9A66_1068857581 =         uncaughtHandler;
        var3EAD0AF1B7D4B4A20305483BB4DE9A66_1068857581.addTaint(taint);
        return var3EAD0AF1B7D4B4A20305483BB4DE9A66_1068857581;
        }
        else
        {
UncaughtExceptionHandler varD15A27BD67EB0D670CD5C298FF20B74F_1697957473 =         group;
        varD15A27BD67EB0D670CD5C298FF20B74F_1697957473.addTaint(taint);
        return varD15A27BD67EB0D670CD5C298FF20B74F_1697957473;
        }
        // ---------- Original Method ----------
        //if (uncaughtHandler != null)
            //return uncaughtHandler;
        //else
            //return group;
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:47.503 -0400", hash_original_method = "17DDF3808A6EBB129363B48719FB5512", hash_generated_method = "60E0257AEA965A5EAB759BF80F11520F")
    public void interrupt() {
        synchronized
(interruptActions)        {
for(int i = interruptActions.size() - 1;i >= 0;i--)
            {
                interruptActions.get(i).run();
            } //End block
        } //End block
        VMThread vmt = this.vmThread;
    if(vmt != null)        
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

    
        @DSModeled(DSC.SPEC)
    public static boolean interrupted() {
        return VMThread.interrupted();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:47.504 -0400", hash_original_method = "FDF1C6D176BF98E9EEA025E5AC84BE96", hash_generated_method = "8AE32755A7DAFCA62A36442699273594")
    public final boolean isAlive() {
        boolean varBF620006D854D991F5BE4CB9FA6C4736_649991361 = ((vmThread != null));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_841418456 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_841418456;
        // ---------- Original Method ----------
        //return (vmThread != null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:47.505 -0400", hash_original_method = "C545A28661A0C27F268C3C9CA79B188B", hash_generated_method = "73C602736972785E4EF603CABB5525BD")
    public final boolean isDaemon() {
        boolean var1F15FCF5421EECD6CA1B61337C319495_1426034229 = (daemon);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_320678750 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_320678750;
        // ---------- Original Method ----------
        //return daemon;
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:47.506 -0400", hash_original_method = "8001B196EB7A1BAE7873C2E86818FA5F", hash_generated_method = "BDA1D2999F71127D46869ED0DB05E0E8")
    public boolean isInterrupted() {
        VMThread vmt = this.vmThread;
    if(vmt != null)        
        {
            boolean var8D3E00D03D9130B23E4006313C659A91_1511686786 = (vmt.isInterrupted());
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2106976696 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_2106976696;
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_445579861 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1424236662 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1424236662;
        // ---------- Original Method ----------
        //VMThread vmt = this.vmThread;
        //if (vmt != null) {
            //return vmt.isInterrupted();
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:47.507 -0400", hash_original_method = "39C10B080916DB467DF3B4EA48EC57E3", hash_generated_method = "393F9723BFAC127B0D58C4D6DC5BA712")
    public final void join() throws InterruptedException {
        VMThread t = vmThread;
    if(t == null)        
        {
            return;
        } //End block
        synchronized
(t)        {
            while
(isAlive())            
            {
                t.wait();
            } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:47.507 -0400", hash_original_method = "4A31F3D41623AEE48E003D8DCAD5BFFA", hash_generated_method = "958F3AFBD3507B4CFCF8A301F16ACE56")
    public final void join(long millis) throws InterruptedException {
        addTaint(millis);
        join(millis, 0);
        // ---------- Original Method ----------
        //join(millis, 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:47.509 -0400", hash_original_method = "7E549C860CA937D59E3BB1D99D89340F", hash_generated_method = "93579802F4101B7D43FD8597C7A75CAA")
    public final void join(long millis, int nanos) throws InterruptedException {
        addTaint(nanos);
        addTaint(millis);
    if(millis < 0 || nanos < 0 || nanos >= NANOS_PER_MILLI)        
        {
            IllegalArgumentException var5783EF97022AA508B74A1E3EA38534AF_1643759484 = new IllegalArgumentException();
            var5783EF97022AA508B74A1E3EA38534AF_1643759484.addTaint(taint);
            throw var5783EF97022AA508B74A1E3EA38534AF_1643759484;
        } //End block
        boolean overflow = millis >= (Long.MAX_VALUE - nanos) / NANOS_PER_MILLI;
        boolean forever = (millis | nanos) == 0;
    if(forever | overflow)        
        {
            join();
            return;
        } //End block
        VMThread t = vmThread;
    if(t == null)        
        {
            return;
        } //End block
        synchronized
(t)        {
    if(!isAlive())            
            {
                return;
            } //End block
            long nanosToWait = millis * NANOS_PER_MILLI + nanos;
            long start = System.nanoTime();
            while
(true)            
            {
                t.wait(millis, nanos);
    if(!isAlive())                
                {
                    break;
                } //End block
                long nanosElapsed = System.nanoTime() - start;
                long nanosRemaining = nanosToWait - nanosElapsed;
    if(nanosRemaining <= 0)                
                {
                    break;
                } //End block
                millis = nanosRemaining / NANOS_PER_MILLI;
                nanos = (int) (nanosRemaining - millis * NANOS_PER_MILLI);
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:47.510 -0400", hash_original_method = "A6ED0DA6D495D98AD3E3BF5221571689", hash_generated_method = "DD4411EECC058055703CC87F6D407F77")
    @Deprecated
    public final void resume() {
        UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_599175939 = new UnsupportedOperationException();
        var81FA7E299EEE7F062EBFBEEF08B0464D_599175939.addTaint(taint);
        throw var81FA7E299EEE7F062EBFBEEF08B0464D_599175939;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:47.511 -0400", hash_original_method = "74F6289977938D08C5FBC2624A0DC216", hash_generated_method = "03477583C250A36BA8909E553E5BD078")
    public void run() {
    if(target != null)        
        {
            target.run();
        } //End block
        // ---------- Original Method ----------
        //if (target != null) {
            //target.run();
        //}
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:47.511 -0400", hash_original_method = "93EFC46ED375C1C54A6285C5204CF25C", hash_generated_method = "3571A2A1E3CF85993D3F0CF0F870AA51")
    public void setContextClassLoader(ClassLoader cl) {
        contextClassLoader = cl;
        // ---------- Original Method ----------
        //contextClassLoader = cl;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:47.512 -0400", hash_original_method = "9670EAA0D97E9800D90F260AB00393C1", hash_generated_method = "36E015496D9924934E59AC27417FAEBA")
    public final void setDaemon(boolean isDaemon) {
    if(hasBeenStarted)        
        {
            IllegalThreadStateException varA31FBD69B89BA6449A6CAE96E199797D_198689741 = new IllegalThreadStateException("Thread already started.");
            varA31FBD69B89BA6449A6CAE96E199797D_198689741.addTaint(taint);
            throw varA31FBD69B89BA6449A6CAE96E199797D_198689741;
        } //End block
    if(vmThread == null)        
        {
            daemon = isDaemon;
        } //End block
        // ---------- Original Method ----------
        //if (hasBeenStarted) {
            //throw new IllegalThreadStateException("Thread already started."); 
        //}
        //if (vmThread == null) {
            //daemon = isDaemon;
        //}
    }

    
        @DSModeled(DSC.SPEC)
    public static void setDefaultUncaughtExceptionHandler(UncaughtExceptionHandler handler) {
        Thread.defaultUncaughtHandler = handler;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:47.514 -0400", hash_original_method = "C18D87700F0558E88B776CB695EE515A", hash_generated_method = "1F4763FA66A84E8702113961AD92D106")
    public final void pushInterruptAction$(Runnable interruptAction) {
        addTaint(interruptAction.getTaint());
        synchronized
(interruptActions)        {
            interruptActions.add(interruptAction);
        } //End block
    if(interruptAction != null && isInterrupted())        
        {
            interruptAction.run();
        } //End block
        // ---------- Original Method ----------
        //synchronized (interruptActions) {
            //interruptActions.add(interruptAction);
        //}
        //if (interruptAction != null && isInterrupted()) {
            //interruptAction.run();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:47.515 -0400", hash_original_method = "134AC2DB3FFDAEE2D6D132954D878FFF", hash_generated_method = "50D71043F029F9C3FDA22625FB60E1E4")
    public final void popInterruptAction$(Runnable interruptAction) {
        addTaint(interruptAction.getTaint());
        synchronized
(interruptActions)        {
            Runnable removed = interruptActions.remove(interruptActions.size() - 1);
    if(interruptAction != removed)            
            {
                IllegalArgumentException varFEBB606D192EB5964085A7D78E6E6F26_1384542223 = new IllegalArgumentException(
                        "Expected " + interruptAction + " but was " + removed);
                varFEBB606D192EB5964085A7D78E6E6F26_1384542223.addTaint(taint);
                throw varFEBB606D192EB5964085A7D78E6E6F26_1384542223;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:47.516 -0400", hash_original_method = "52D88413A8A1215EC9D935022AA7508F", hash_generated_method = "22C8AF55D76D13F85807D451EC1CAEB0")
    public final void setName(String threadName) {
    if(threadName == null)        
        {
            NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_1687299846 = new NullPointerException();
            var7338BC9F48D81FE0BBD6183F4014DCC4_1687299846.addTaint(taint);
            throw var7338BC9F48D81FE0BBD6183F4014DCC4_1687299846;
        } //End block
        name = threadName;
        VMThread vmt = this.vmThread;
    if(vmt != null)        
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:47.517 -0400", hash_original_method = "A91023FCF06B8647A6CEF3B99492A3A2", hash_generated_method = "A104187DFF416395406D3CB54C8173DC")
    public final void setPriority(int priority) {
    if(priority < Thread.MIN_PRIORITY || priority > Thread.MAX_PRIORITY)        
        {
            IllegalArgumentException varEECC002C8BC5156BE3BE7CDCADFB2390_1645951958 = new IllegalArgumentException("Priority out of range");
            varEECC002C8BC5156BE3BE7CDCADFB2390_1645951958.addTaint(taint);
            throw varEECC002C8BC5156BE3BE7CDCADFB2390_1645951958;
        } //End block
    if(priority > group.getMaxPriority())        
        {
            priority = group.getMaxPriority();
        } //End block
        this.priority = priority;
        VMThread vmt = this.vmThread;
    if(vmt != null)        
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

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:47.518 -0400", hash_original_method = "D58D250923779D2B2016D80FC2081BA1", hash_generated_method = "32052A607317B2CF4FD95D37AFA858D8")
    public void setUncaughtExceptionHandler(UncaughtExceptionHandler handler) {
        uncaughtHandler = handler;
        // ---------- Original Method ----------
        //uncaughtHandler = handler;
    }

    
        @DSModeled(DSC.SPEC)
    public static void sleep(long time) throws InterruptedException {
        Thread.sleep(time, 0);
    }

    
        @DSModeled(DSC.SPEC)
    public static void sleep(long millis, int nanos) throws InterruptedException {
        VMThread.sleep(millis, nanos);
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:47.520 -0400", hash_original_method = "389CF6E0D3A08F228CF4E4A156CC86D9", hash_generated_method = "E54725B4A6D8EBCC5C0D04CDE0B199CE")
    public synchronized void start() {
    if(hasBeenStarted)        
        {
            IllegalThreadStateException varA31FBD69B89BA6449A6CAE96E199797D_1692122863 = new IllegalThreadStateException("Thread already started.");
            varA31FBD69B89BA6449A6CAE96E199797D_1692122863.addTaint(taint);
            throw varA31FBD69B89BA6449A6CAE96E199797D_1692122863;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:47.521 -0400", hash_original_method = "345C33A5CF7530BB38CAED519DB524FA", hash_generated_method = "4CF021D91E790FABEAD72EF8B01ED19B")
    @Deprecated
    public final void stop() {
        stop(new ThreadDeath());
        // ---------- Original Method ----------
        //stop(new ThreadDeath());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:47.521 -0400", hash_original_method = "B034829378D149E76566D897B904AD02", hash_generated_method = "EF6B3E182D064579B74B9055C6445206")
    @Deprecated
    public final synchronized void stop(Throwable throwable) {
        addTaint(throwable.getTaint());
        UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_205471894 = new UnsupportedOperationException();
        var81FA7E299EEE7F062EBFBEEF08B0464D_205471894.addTaint(taint);
        throw var81FA7E299EEE7F062EBFBEEF08B0464D_205471894;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:47.522 -0400", hash_original_method = "BFD882A151848FA6FDA9CF11B3EB5020", hash_generated_method = "411E412BCCBFE5676ECCF3E32F4903DE")
    @Deprecated
    public final void suspend() {
        UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_1378427027 = new UnsupportedOperationException();
        var81FA7E299EEE7F062EBFBEEF08B0464D_1378427027.addTaint(taint);
        throw var81FA7E299EEE7F062EBFBEEF08B0464D_1378427027;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:47.523 -0400", hash_original_method = "E21D755A7854968438B35D363D61DC14", hash_generated_method = "4506463D9D79CBDFD7D1C89AC5834DF9")
    @Override
    public String toString() {
String varBD9870DFC52F401CAC874F07B86030A0_338731243 =         "Thread[" + name + "," + priority + "," + group.getName() + "]";
        varBD9870DFC52F401CAC874F07B86030A0_338731243.addTaint(taint);
        return varBD9870DFC52F401CAC874F07B86030A0_338731243;
        // ---------- Original Method ----------
        //return "Thread[" + name + "," + priority + "," + group.getName() + "]";
    }

    
        @DSModeled(DSC.SPEC)
    public static void yield() {
        VMThread.yield();
    }

    
        @DSModeled(DSC.SPEC)
    public static boolean holdsLock(Object object) {
        return currentThread().vmThread.holdsLock(object);
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:47.525 -0400", hash_original_method = "A23472E398F1697320641EE9BCE07378", hash_generated_method = "43F89B373C1350806380D74769796ED0")
    public void unpark() {
        VMThread vmt = vmThread;
    if(vmt == null)        
        {
            parkState = ParkState.PREEMPTIVELY_UNPARKED;
            return;
        } //End block
        synchronized
(vmt)        {
switch(parkState){
            case ParkState.PREEMPTIVELY_UNPARKED:
            {
                break;
            } //End block
            case ParkState.UNPARKED:
            {
                parkState = ParkState.PREEMPTIVELY_UNPARKED;
                break;
            } //End block
            default :
            {
                parkState = ParkState.UNPARKED;
                vmt.notifyAll();
                break;
            } //End block
}
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

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:47.526 -0400", hash_original_method = "25C50086F373F8B2A1357A67BAD56EA4", hash_generated_method = "96FD6AD1269350685F94EA0B2B3D5E6E")
    public void parkFor(long nanos) {
        addTaint(nanos);
        VMThread vmt = vmThread;
    if(vmt == null)        
        {
            AssertionError varA81442E36297E737EB908877E58260E8_1207288659 = new AssertionError();
            varA81442E36297E737EB908877E58260E8_1207288659.addTaint(taint);
            throw varA81442E36297E737EB908877E58260E8_1207288659;
        } //End block
        synchronized
(vmt)        {
switch(parkState){
            case ParkState.PREEMPTIVELY_UNPARKED:
            {
                parkState = ParkState.UNPARKED;
                break;
            } //End block
            case ParkState.UNPARKED:
            {
                long millis = nanos / NANOS_PER_MILLI;
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
    if(parkState == ParkState.PARKED)                    
                    {
                        parkState = ParkState.UNPARKED;
                    } //End block
                } //End block
                break;
            } //End block
            default :
            {
                AssertionError varDD3C9D6B0CD003A7EA6BF1335F8817D2_813540893 = new AssertionError(
                            "shouldn't happen: attempt to repark");
                varDD3C9D6B0CD003A7EA6BF1335F8817D2_813540893.addTaint(taint);
                throw varDD3C9D6B0CD003A7EA6BF1335F8817D2_813540893;
            } //End block
}
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:47.527 -0400", hash_original_method = "98F10CBBB26C44644E065EAD29E052AC", hash_generated_method = "2EC7DFE54C9CE6CBACF8CCBCCC252B01")
    public void parkUntil(long time) {
        addTaint(time);
        VMThread vmt = vmThread;
    if(vmt == null)        
        {
            AssertionError varA81442E36297E737EB908877E58260E8_312693345 = new AssertionError();
            varA81442E36297E737EB908877E58260E8_312693345.addTaint(taint);
            throw varA81442E36297E737EB908877E58260E8_312693345;
        } //End block
        synchronized
(vmt)        {
            long delayMillis = time - System.currentTimeMillis();
    if(delayMillis <= 0)            
            {
                parkState = ParkState.UNPARKED;
            } //End block
            else
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
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:47.528 -0400", hash_original_method = "13ABD2C1475A75B421FFE7ADB6CF97D6", hash_generated_method = "13ABD2C1475A75B421FFE7ADB6CF97D6")
        public ParkState ()
        {
            //Synthesized constructor
        }


        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:47.528 -0400", hash_original_field = "E764ADEE54F384BBC4FD06FD8EF08C01", hash_generated_field = "5F7B3D5520F70EA2E650375F945D4166")

        private static final int UNPARKED = 1;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:47.528 -0400", hash_original_field = "04755C457D6EF4EAD76F049ABB047AA1", hash_generated_field = "7BF82648F2EB786712FF07EA5F35294C")

        private static final int PREEMPTIVELY_UNPARKED = 2;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:47.529 -0400", hash_original_field = "C7A56BEAC50908F3708BC4AC3CF7519C", hash_generated_field = "4906CF74EDC592846414C69420DD3136")

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
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:47.529 -0400", hash_original_field = "90F159E16A269B6F875D096F21ED865D", hash_generated_field = "E32D593DEDB2FDC7FE0DFB7474352DBA")

    private static final int NANOS_PER_MILLI = 1000000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:47.529 -0400", hash_original_field = "A75E0F742509618A299AC37B99AF7D9B", hash_generated_field = "706621D0D1857AEE97C3233E8B1CD39C")

    public static final int MAX_PRIORITY = 10;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:47.529 -0400", hash_original_field = "1264FCC1E4F8DDF0EE23E91F2EC7D41B", hash_generated_field = "4B0AE7C1DD2BB6CEB517D1F2268AEEFF")

    public static final int MIN_PRIORITY = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:47.530 -0400", hash_original_field = "1B497667C5350B8C5FE271A0E46B380B", hash_generated_field = "C493C9DD27E116A919077E0BD37657C0")

    public static final int NORM_PRIORITY = 5;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:47.530 -0400", hash_original_field = "B1F8A23315AB697B67E425C4B5F81545", hash_generated_field = "6A0B7CDB09C9D5381ED29C2BE609D34C")

    private static int count = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:47.530 -0400", hash_original_field = "CF5362A11D29DA9A03A7D3AF3A8F9BBA", hash_generated_field = "5C82310D1632632F57D1ECC47F5F0326")

    private static UncaughtExceptionHandler defaultUncaughtHandler;
}

