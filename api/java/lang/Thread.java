package java.lang;

// Droidsafe Imports
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import libcore.util.EmptyArray;
import dalvik.system.VMStack;
import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

public class Thread implements Runnable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.425 -0400", hash_original_field = "DFCB349389E84D15F92F0101BDA522EF", hash_generated_field = "AD2271ADED5B0642EAD7F6C10D7138A3")

    volatile VMThread vmThread;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.425 -0400", hash_original_field = "DB0F6F37EBEB6EA09489124345AF2A45", hash_generated_field = "323908075291FF73A0BF0480EC78D762")

    volatile ThreadGroup group;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.425 -0400", hash_original_field = "1F15FCF5421EECD6CA1B61337C319495", hash_generated_field = "1ED59F53ED2B99A4AD9663473B1CC006")

    volatile boolean daemon;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.425 -0400", hash_original_field = "B068931CC450442B63F5B3D276EA4297", hash_generated_field = "34558C70E1377442D4C0DBDA56BC6C23")

    volatile String name;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.426 -0400", hash_original_field = "B988295C268025B49DFB3DF26171DDC3", hash_generated_field = "FDCCFF27A359BAE03856205C3A73A167")

    volatile int priority;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.426 -0400", hash_original_field = "DE15E127B153666F6C6C4FBCAE60419B", hash_generated_field = "31CCA7F61A6273CAFC2F2A0EB46C6C22")

    volatile long stackSize;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.426 -0400", hash_original_field = "42AEFBAE01D2DFD981F7DA7D823D689E", hash_generated_field = "3BC51F00CA4514C3C4790A78C316DD07")

    Runnable target;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.426 -0400", hash_original_field = "B80BB7740288FDA1F201890375A60C8F", hash_generated_field = "AE2623257C6319B5969DD2321BB374E1")

    private long id;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.426 -0400", hash_original_field = "6996C07FA899CEE946C99E7A25F61CC0", hash_generated_field = "BC582D53333FA9EE36376F01B3892F08")

    ThreadLocal.Values localValues;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.426 -0400", hash_original_field = "A9F47F486EE26178B4A9BD31D96AF7BF", hash_generated_field = "1DCD99C357BDD63DBAEA19AB3742D070")

    ThreadLocal.Values inheritableValues;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.426 -0400", hash_original_field = "39B85D264A49C16734A98A1B294FEB8F", hash_generated_field = "90F6FDD1E7EA8160FB4E33738C8B4E2A")

    private final List<Runnable> interruptActions = new ArrayList<Runnable>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.426 -0400", hash_original_field = "8E1DEE07E23DAA726BAAF0EE9C3C8EE1", hash_generated_field = "C41102AB5C0E4C512DB1FC97849C5D3F")

    private ClassLoader contextClassLoader;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.426 -0400", hash_original_field = "D620DC3DE4E8991B36D1C529F352B7D6", hash_generated_field = "9E70AF0C0F09E0E8D22000D357561505")

    private UncaughtExceptionHandler uncaughtHandler;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.426 -0400", hash_original_field = "B34C39ECBBEB4BBF8B9FDE58CF443A44", hash_generated_field = "F52710C226B829B42671DDE4B1108733")

    boolean hasBeenStarted = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.426 -0400", hash_original_field = "A868BAFA6B5FA0E61CE2762A9B315944", hash_generated_field = "1586B270E49D73D94EC53EC7F719398A")

    private int parkState = ParkState.UNPARKED;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.426 -0400", hash_original_field = "14EE858A6EC2B082926F68B4AA434051", hash_generated_field = "34932EF005581D2A5FD235907377EED6")

    private Object parkBlocker;
    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.427 -0400", hash_original_method = "A2846A412942D9A4A6734B659C3C08EA", hash_generated_method = "FC648266C8623CAE59D46FDD8401EFDA")
    public  Thread() {
        create(null, null, null, 0);
        // ---------- Original Method ----------
        //create(null, null, null, 0);
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.427 -0400", hash_original_method = "FFE43BBD5535897A2D4ADC63E06A2D0F", hash_generated_method = "3784830CC12A01134E29A04BE69E0386")
    public  Thread(Runnable runnable) {
        addTaint(runnable.getTaint());
        create(null, runnable, null, 0);
        // ---------- Original Method ----------
        //create(null, runnable, null, 0);
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.427 -0400", hash_original_method = "BDCA95CAB999722EC25DF6B8E927C95F", hash_generated_method = "E1D5E967B240C0B7C27B9CF1116F4A40")
    public  Thread(Runnable runnable, String threadName) {
        addTaint(threadName.getTaint());
        addTaint(runnable.getTaint());
        if(threadName == null)        
        {
            NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_143967786 = new NullPointerException();
            var7338BC9F48D81FE0BBD6183F4014DCC4_143967786.addTaint(taint);
            throw var7338BC9F48D81FE0BBD6183F4014DCC4_143967786;
        } //End block
        create(null, runnable, threadName, 0);
        // ---------- Original Method ----------
        //if (threadName == null) {
            //throw new NullPointerException();
        //}
        //create(null, runnable, threadName, 0);
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.428 -0400", hash_original_method = "ACB5E26D2EF52FBACC4A4E78EC843CDD", hash_generated_method = "91B3692AC736A53751C5B0C2732FD383")
    public  Thread(String threadName) {
        addTaint(threadName.getTaint());
        if(threadName == null)        
        {
            NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_1428982679 = new NullPointerException();
            var7338BC9F48D81FE0BBD6183F4014DCC4_1428982679.addTaint(taint);
            throw var7338BC9F48D81FE0BBD6183F4014DCC4_1428982679;
        } //End block
        create(null, null, threadName, 0);
        // ---------- Original Method ----------
        //if (threadName == null) {
            //throw new NullPointerException();
        //}
        //create(null, null, threadName, 0);
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.428 -0400", hash_original_method = "CFE0254168731091471FC08E1B68E532", hash_generated_method = "853E07A889463840212E70255D3EEDAF")
    public  Thread(ThreadGroup group, Runnable runnable) {
        addTaint(runnable.getTaint());
        addTaint(group.getTaint());
        create(group, runnable, null, 0);
        // ---------- Original Method ----------
        //create(group, runnable, null, 0);
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.429 -0400", hash_original_method = "492306C5FED9EC58991A5E8736E27F15", hash_generated_method = "4D14754B0A704B685B63FA40356E86D0")
    public  Thread(ThreadGroup group, Runnable runnable, String threadName) {
        addTaint(threadName.getTaint());
        addTaint(runnable.getTaint());
        addTaint(group.getTaint());
        if(threadName == null)        
        {
            NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_44212886 = new NullPointerException();
            var7338BC9F48D81FE0BBD6183F4014DCC4_44212886.addTaint(taint);
            throw var7338BC9F48D81FE0BBD6183F4014DCC4_44212886;
        } //End block
        create(group, runnable, threadName, 0);
        // ---------- Original Method ----------
        //if (threadName == null) {
            //throw new NullPointerException();
        //}
        //create(group, runnable, threadName, 0);
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.429 -0400", hash_original_method = "D83475E079BCC4E2E3558A574C3A704E", hash_generated_method = "041D942AC4C5D805B80476E3E88BD899")
    public  Thread(ThreadGroup group, String threadName) {
        addTaint(threadName.getTaint());
        addTaint(group.getTaint());
        if(threadName == null)        
        {
            NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_654456895 = new NullPointerException();
            var7338BC9F48D81FE0BBD6183F4014DCC4_654456895.addTaint(taint);
            throw var7338BC9F48D81FE0BBD6183F4014DCC4_654456895;
        } //End block
        create(group, null, threadName, 0);
        // ---------- Original Method ----------
        //if (threadName == null) {
            //throw new NullPointerException();
        //}
        //create(group, null, threadName, 0);
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.429 -0400", hash_original_method = "38DDF80F64A6875AC3B97FC941143FB8", hash_generated_method = "82E62012E45D7FABC953810FCBB47AB4")
    public  Thread(ThreadGroup group, Runnable runnable, String threadName, long stackSize) {
        addTaint(stackSize);
        addTaint(threadName.getTaint());
        addTaint(runnable.getTaint());
        addTaint(group.getTaint());
        if(threadName == null)        
        {
            NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_206023313 = new NullPointerException();
            var7338BC9F48D81FE0BBD6183F4014DCC4_206023313.addTaint(taint);
            throw var7338BC9F48D81FE0BBD6183F4014DCC4_206023313;
        } //End block
        create(group, runnable, threadName, stackSize);
        // ---------- Original Method ----------
        //if (threadName == null) {
            //throw new NullPointerException();
        //}
        //create(group, runnable, threadName, stackSize);
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.431 -0400", hash_original_method = "DA36D17A4C27DE9C11E6923E1A7A26CA", hash_generated_method = "14F42F3BF92542D376D72267DD60B378")
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
            InternalError var9120CCB88F897215235B0E8DBA5319D5_1189050893 = new InternalError("group not specified");
            var9120CCB88F897215235B0E8DBA5319D5_1189050893.addTaint(taint);
            throw var9120CCB88F897215235B0E8DBA5319D5_1189050893;
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
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.436 -0400", hash_original_method = "B7E7B76C5A1CA256325AA2280577DF6E", hash_generated_method = "42292564FF86B78E6195EDD1BDBFD22A")
    private void create(ThreadGroup group, Runnable runnable, String threadName, long stackSize) {
        Thread currentThread = Thread.currentThread();
        if(group == null)        
        {
            group = currentThread.getThreadGroup();
        } //End block
        if(group.isDestroyed())        
        {
            IllegalThreadStateException varC058BA3B80F847C4D37109956EBCEA2A_1374497555 = new IllegalThreadStateException("Group already destroyed");
            varC058BA3B80F847C4D37109956EBCEA2A_1374497555.addTaint(taint);
            throw varC058BA3B80F847C4D37109956EBCEA2A_1374497555;
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

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.437 -0400", hash_original_method = "9AC5D8EF15BD7837ACD785C0772615A1", hash_generated_method = "58C0335FEF548999868CED53D4078AEE")
    public final void checkAccess() {
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.437 -0400", hash_original_method = "6B880F3A25E0C40C35D8EAA702DA9116", hash_generated_method = "0D414A74B737329E250298348881C7DE")
    @Deprecated
    public int countStackFrames() {
        int varE7DCDEAB275966ADC28F03E09ECA3812_722774102 = (getStackTrace().length);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_559585081 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_559585081;
        // ---------- Original Method ----------
        //return getStackTrace().length;
    }

    
    @DSModeled(DSC.SPEC)
    public static Thread currentThread() {
        return VMThread.currentThread();
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.438 -0400", hash_original_method = "E295DBEBB7624DABB0FA2D3E0377892B", hash_generated_method = "FE565BC18C1DD42D9F5CC0926C43EDA8")
    @Deprecated
    public void destroy() {
        NoSuchMethodError varEC935BC28734C445C690AFF68B3FA782_2057247934 = new NoSuchMethodError("Thread.destroy()");
        varEC935BC28734C445C690AFF68B3FA782_2057247934.addTaint(taint);
        throw varEC935BC28734C445C690AFF68B3FA782_2057247934;
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

    
    @DSModeled(DSC.SPEC)
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
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.439 -0400", hash_original_method = "D65A36EB6AF7077545898D8D2274216D", hash_generated_method = "83D7F5EED90D5D0F4268D6624297C9D3")
    public ClassLoader getContextClassLoader() {
ClassLoader varCDB6A46B81C356659A30478714667CAA_1665654584 =         contextClassLoader;
        varCDB6A46B81C356659A30478714667CAA_1665654584.addTaint(taint);
        return varCDB6A46B81C356659A30478714667CAA_1665654584;
        // ---------- Original Method ----------
        //return contextClassLoader;
    }

    
    @DSModeled(DSC.SPEC)
    public static UncaughtExceptionHandler getDefaultUncaughtExceptionHandler() {
        return defaultUncaughtHandler;
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.439 -0400", hash_original_method = "AC34FCBA00CFFBED3290FFC752B7D422", hash_generated_method = "28D8480CF19AD5A9501313448D5F3E9B")
    public long getId() {
        long varB80BB7740288FDA1F201890375A60C8F_1467174782 = (id);
                long var0F5264038205EDFB1AC05FBB0E8C5E94_1732089083 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1732089083;
        // ---------- Original Method ----------
        //return id;
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.440 -0400", hash_original_method = "7070E6AABEDCBA653834DDC8CF79A47C", hash_generated_method = "EDCC5EAEFA30B8148F34012DCDC79007")
    public final String getName() {
String varB017984728AC60AD1F0BF8734F33F15C_771119088 =         name;
        varB017984728AC60AD1F0BF8734F33F15C_771119088.addTaint(taint);
        return varB017984728AC60AD1F0BF8734F33F15C_771119088;
        // ---------- Original Method ----------
        //return name;
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.440 -0400", hash_original_method = "0FA6C5514FC3354D3A5FFA078FF2070D", hash_generated_method = "545E3634ACD7D3D4D0AFFECDD2D97FE0")
    public final int getPriority() {
        int varB988295C268025B49DFB3DF26171DDC3_736933597 = (priority);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1210773613 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1210773613;
        // ---------- Original Method ----------
        //return priority;
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.440 -0400", hash_original_method = "105ECA4B48BD428C2A4BFADC722280E4", hash_generated_method = "1C364077E65F9DE3DE5E41D3883ADD9F")
    public StackTraceElement[] getStackTrace() {
        StackTraceElement ste[] = VMStack.getThreadStackTrace(this);
StackTraceElement[] var4BE632EBE6A3388F93FE2D88ACD3A469_609231410 =         ste != null ? ste : EmptyArray.STACK_TRACE_ELEMENT;
        var4BE632EBE6A3388F93FE2D88ACD3A469_609231410.addTaint(taint);
        return var4BE632EBE6A3388F93FE2D88ACD3A469_609231410;
        // ---------- Original Method ----------
        //StackTraceElement ste[] = VMStack.getThreadStackTrace(this);
        //return ste != null ? ste : EmptyArray.STACK_TRACE_ELEMENT;
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.440 -0400", hash_original_method = "07EB6E55BA9633DD05ED126331098808", hash_generated_method = "BDF971EEA2E91FCC2A9A56E6E056B93B")
    public State getState() {
        VMThread vmt = this.vmThread;
        VMThread thread = vmThread;
        if(thread != null)        
        {
            int state = thread.getStatus();
            if(state != -1)            
            {
State var2D991B4F3C5F46C730CE990DC46EDE7F_333625134 =                 VMThread.STATE_MAP[state];
                var2D991B4F3C5F46C730CE990DC46EDE7F_333625134.addTaint(taint);
                return var2D991B4F3C5F46C730CE990DC46EDE7F_333625134;
            } //End block
        } //End block
State varFFFA24361953E87A22A606CCE4DC911E_664890071 =         hasBeenStarted ? Thread.State.TERMINATED : Thread.State.NEW;
        varFFFA24361953E87A22A606CCE4DC911E_664890071.addTaint(taint);
        return varFFFA24361953E87A22A606CCE4DC911E_664890071;
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

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.441 -0400", hash_original_method = "00D5D6D0C2A305848EB6704B96DA1F7A", hash_generated_method = "095782652AA4ED5DB921C092F6E1D3DB")
    public final ThreadGroup getThreadGroup() {
        if(getState() == Thread.State.TERMINATED)        
        {
ThreadGroup var540C13E9E156B687226421B24F2DF178_117279971 =             null;
            var540C13E9E156B687226421B24F2DF178_117279971.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_117279971;
        } //End block
        else
        {
ThreadGroup varD15A27BD67EB0D670CD5C298FF20B74F_1761347020 =             group;
            varD15A27BD67EB0D670CD5C298FF20B74F_1761347020.addTaint(taint);
            return varD15A27BD67EB0D670CD5C298FF20B74F_1761347020;
        } //End block
        // ---------- Original Method ----------
        //if (getState() == Thread.State.TERMINATED) {
            //return null;
        //} else {
            //return group;
        //}
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.441 -0400", hash_original_method = "5CF1F81DC91E6D2E78C73116F661ED4D", hash_generated_method = "E22150AF637D9A96EB0B989E38041F4E")
    public UncaughtExceptionHandler getUncaughtExceptionHandler() {
        if(uncaughtHandler != null)        
        {
UncaughtExceptionHandler var3EAD0AF1B7D4B4A20305483BB4DE9A66_1343101682 =         uncaughtHandler;
        var3EAD0AF1B7D4B4A20305483BB4DE9A66_1343101682.addTaint(taint);
        return var3EAD0AF1B7D4B4A20305483BB4DE9A66_1343101682;
        }
        else
        {
UncaughtExceptionHandler varD15A27BD67EB0D670CD5C298FF20B74F_959739144 =         group;
        varD15A27BD67EB0D670CD5C298FF20B74F_959739144.addTaint(taint);
        return varD15A27BD67EB0D670CD5C298FF20B74F_959739144;
        }
        // ---------- Original Method ----------
        //if (uncaughtHandler != null)
            //return uncaughtHandler;
        //else
            //return group;
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.442 -0400", hash_original_method = "17DDF3808A6EBB129363B48719FB5512", hash_generated_method = "60E0257AEA965A5EAB759BF80F11520F")
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

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.443 -0400", hash_original_method = "FDF1C6D176BF98E9EEA025E5AC84BE96", hash_generated_method = "7F31F9A9FB46DB369642929976A9020A")
    public final boolean isAlive() {
        boolean varBF620006D854D991F5BE4CB9FA6C4736_1692806606 = ((vmThread != null));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_223250610 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_223250610;
        // ---------- Original Method ----------
        //return (vmThread != null);
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.443 -0400", hash_original_method = "C545A28661A0C27F268C3C9CA79B188B", hash_generated_method = "086C5C289CB79CB6815C8A40D3D877BC")
    public final boolean isDaemon() {
        boolean var1F15FCF5421EECD6CA1B61337C319495_1539992657 = (daemon);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1663227378 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1663227378;
        // ---------- Original Method ----------
        //return daemon;
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.444 -0400", hash_original_method = "8001B196EB7A1BAE7873C2E86818FA5F", hash_generated_method = "27898F8EF3EB508CADF878D3B085770B")
    public boolean isInterrupted() {
        VMThread vmt = this.vmThread;
        if(vmt != null)        
        {
            boolean var8D3E00D03D9130B23E4006313C659A91_602132065 = (vmt.isInterrupted());
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1463244812 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1463244812;
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_729376866 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_528125420 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_528125420;
        // ---------- Original Method ----------
        //VMThread vmt = this.vmThread;
        //if (vmt != null) {
            //return vmt.isInterrupted();
        //}
        //return false;
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.445 -0400", hash_original_method = "39C10B080916DB467DF3B4EA48EC57E3", hash_generated_method = "393F9723BFAC127B0D58C4D6DC5BA712")
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

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.445 -0400", hash_original_method = "4A31F3D41623AEE48E003D8DCAD5BFFA", hash_generated_method = "958F3AFBD3507B4CFCF8A301F16ACE56")
    public final void join(long millis) throws InterruptedException {
        addTaint(millis);
        join(millis, 0);
        // ---------- Original Method ----------
        //join(millis, 0);
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.447 -0400", hash_original_method = "7E549C860CA937D59E3BB1D99D89340F", hash_generated_method = "A03D0FF66197435697EB8C95B4C76A87")
    public final void join(long millis, int nanos) throws InterruptedException {
        addTaint(nanos);
        addTaint(millis);
        if(millis < 0 || nanos < 0 || nanos >= NANOS_PER_MILLI)        
        {
            IllegalArgumentException var5783EF97022AA508B74A1E3EA38534AF_1505160880 = new IllegalArgumentException();
            var5783EF97022AA508B74A1E3EA38534AF_1505160880.addTaint(taint);
            throw var5783EF97022AA508B74A1E3EA38534AF_1505160880;
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

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.467 -0400", hash_original_method = "A6ED0DA6D495D98AD3E3BF5221571689", hash_generated_method = "E91EE640339DAD2D6505F75A7899B3CA")
    @Deprecated
    public final void resume() {
        UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_276643360 = new UnsupportedOperationException();
        var81FA7E299EEE7F062EBFBEEF08B0464D_276643360.addTaint(taint);
        throw var81FA7E299EEE7F062EBFBEEF08B0464D_276643360;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.467 -0400", hash_original_method = "74F6289977938D08C5FBC2624A0DC216", hash_generated_method = "03477583C250A36BA8909E553E5BD078")
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
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.467 -0400", hash_original_method = "93EFC46ED375C1C54A6285C5204CF25C", hash_generated_method = "3571A2A1E3CF85993D3F0CF0F870AA51")
    public void setContextClassLoader(ClassLoader cl) {
        contextClassLoader = cl;
        // ---------- Original Method ----------
        //contextClassLoader = cl;
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.467 -0400", hash_original_method = "9670EAA0D97E9800D90F260AB00393C1", hash_generated_method = "161F2329592DA27C0ADC5A22FCC0B1C3")
    public final void setDaemon(boolean isDaemon) {
        if(hasBeenStarted)        
        {
            IllegalThreadStateException varA31FBD69B89BA6449A6CAE96E199797D_1741796533 = new IllegalThreadStateException("Thread already started.");
            varA31FBD69B89BA6449A6CAE96E199797D_1741796533.addTaint(taint);
            throw varA31FBD69B89BA6449A6CAE96E199797D_1741796533;
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

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.468 -0400", hash_original_method = "C18D87700F0558E88B776CB695EE515A", hash_generated_method = "1F4763FA66A84E8702113961AD92D106")
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

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.468 -0400", hash_original_method = "134AC2DB3FFDAEE2D6D132954D878FFF", hash_generated_method = "A9B42C9D408152FD5A796DD53A3A73F4")
    public final void popInterruptAction$(Runnable interruptAction) {
        addTaint(interruptAction.getTaint());
        synchronized
(interruptActions)        {
            Runnable removed = interruptActions.remove(interruptActions.size() - 1);
            if(interruptAction != removed)            
            {
                IllegalArgumentException varFEBB606D192EB5964085A7D78E6E6F26_354888879 = new IllegalArgumentException(
                        "Expected " + interruptAction + " but was " + removed);
                varFEBB606D192EB5964085A7D78E6E6F26_354888879.addTaint(taint);
                throw varFEBB606D192EB5964085A7D78E6E6F26_354888879;
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

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.468 -0400", hash_original_method = "52D88413A8A1215EC9D935022AA7508F", hash_generated_method = "8DDE8177A280F9E6E6A33FA80E257ED8")
    public final void setName(String threadName) {
        if(threadName == null)        
        {
            NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_779737901 = new NullPointerException();
            var7338BC9F48D81FE0BBD6183F4014DCC4_779737901.addTaint(taint);
            throw var7338BC9F48D81FE0BBD6183F4014DCC4_779737901;
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

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.468 -0400", hash_original_method = "A91023FCF06B8647A6CEF3B99492A3A2", hash_generated_method = "988445EF96F495EEFCE0FDBCD5D36984")
    public final void setPriority(int priority) {
        if(priority < Thread.MIN_PRIORITY || priority > Thread.MAX_PRIORITY)        
        {
            IllegalArgumentException varEECC002C8BC5156BE3BE7CDCADFB2390_50989834 = new IllegalArgumentException("Priority out of range");
            varEECC002C8BC5156BE3BE7CDCADFB2390_50989834.addTaint(taint);
            throw varEECC002C8BC5156BE3BE7CDCADFB2390_50989834;
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
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.468 -0400", hash_original_method = "D58D250923779D2B2016D80FC2081BA1", hash_generated_method = "32052A607317B2CF4FD95D37AFA858D8")
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
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.469 -0400", hash_original_method = "389CF6E0D3A08F228CF4E4A156CC86D9", hash_generated_method = "B473EA570E866CA4793A2AB1597CA5BF")
    public synchronized void start() {
        if(hasBeenStarted)        
        {
            IllegalThreadStateException varA31FBD69B89BA6449A6CAE96E199797D_768236349 = new IllegalThreadStateException("Thread already started.");
            varA31FBD69B89BA6449A6CAE96E199797D_768236349.addTaint(taint);
            throw varA31FBD69B89BA6449A6CAE96E199797D_768236349;
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

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.469 -0400", hash_original_method = "345C33A5CF7530BB38CAED519DB524FA", hash_generated_method = "4CF021D91E790FABEAD72EF8B01ED19B")
    @Deprecated
    public final void stop() {
        stop(new ThreadDeath());
        // ---------- Original Method ----------
        //stop(new ThreadDeath());
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.469 -0400", hash_original_method = "B034829378D149E76566D897B904AD02", hash_generated_method = "3787C9926B87320EFFCA64F7D4B53EE7")
    @Deprecated
    public final synchronized void stop(Throwable throwable) {
        addTaint(throwable.getTaint());
        UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_1365441533 = new UnsupportedOperationException();
        var81FA7E299EEE7F062EBFBEEF08B0464D_1365441533.addTaint(taint);
        throw var81FA7E299EEE7F062EBFBEEF08B0464D_1365441533;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.469 -0400", hash_original_method = "BFD882A151848FA6FDA9CF11B3EB5020", hash_generated_method = "DD12782C4AF491C721E6300F989FD2BE")
    @Deprecated
    public final void suspend() {
        UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_1138674903 = new UnsupportedOperationException();
        var81FA7E299EEE7F062EBFBEEF08B0464D_1138674903.addTaint(taint);
        throw var81FA7E299EEE7F062EBFBEEF08B0464D_1138674903;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.469 -0400", hash_original_method = "E21D755A7854968438B35D363D61DC14", hash_generated_method = "94E74C0DE799133EF3AC87577F4D3DDD")
    @Override
    public String toString() {
String varBD9870DFC52F401CAC874F07B86030A0_797569064 =         "Thread[" + name + "," + priority + "," + group.getName() + "]";
        varBD9870DFC52F401CAC874F07B86030A0_797569064.addTaint(taint);
        return varBD9870DFC52F401CAC874F07B86030A0_797569064;
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
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.470 -0400", hash_original_method = "A23472E398F1697320641EE9BCE07378", hash_generated_method = "43F89B373C1350806380D74769796ED0")
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
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.470 -0400", hash_original_method = "25C50086F373F8B2A1357A67BAD56EA4", hash_generated_method = "96C9CE2832B60783EA27DEBA819E6D65")
    public void parkFor(long nanos) {
        addTaint(nanos);
        VMThread vmt = vmThread;
        if(vmt == null)        
        {
            AssertionError varA81442E36297E737EB908877E58260E8_1522491913 = new AssertionError();
            varA81442E36297E737EB908877E58260E8_1522491913.addTaint(taint);
            throw varA81442E36297E737EB908877E58260E8_1522491913;
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
                AssertionError varDD3C9D6B0CD003A7EA6BF1335F8817D2_1682602702 = new AssertionError(
                            "shouldn't happen: attempt to repark");
                varDD3C9D6B0CD003A7EA6BF1335F8817D2_1682602702.addTaint(taint);
                throw varDD3C9D6B0CD003A7EA6BF1335F8817D2_1682602702;
            } //End block
}
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.470 -0400", hash_original_method = "98F10CBBB26C44644E065EAD29E052AC", hash_generated_method = "B897E4C3D88E5808D585928ACDB1B4BE")
    public void parkUntil(long time) {
        addTaint(time);
        VMThread vmt = vmThread;
        if(vmt == null)        
        {
            AssertionError varA81442E36297E737EB908877E58260E8_1183747793 = new AssertionError();
            varA81442E36297E737EB908877E58260E8_1183747793.addTaint(taint);
            throw varA81442E36297E737EB908877E58260E8_1183747793;
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
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.471 -0400", hash_original_method = "13ABD2C1475A75B421FFE7ADB6CF97D6", hash_generated_method = "13ABD2C1475A75B421FFE7ADB6CF97D6")
        public ParkState ()
        {
            //Synthesized constructor
        }


        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.471 -0400", hash_original_field = "E764ADEE54F384BBC4FD06FD8EF08C01", hash_generated_field = "5F7B3D5520F70EA2E650375F945D4166")

        private static final int UNPARKED = 1;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.471 -0400", hash_original_field = "04755C457D6EF4EAD76F049ABB047AA1", hash_generated_field = "7BF82648F2EB786712FF07EA5F35294C")

        private static final int PREEMPTIVELY_UNPARKED = 2;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.471 -0400", hash_original_field = "C7A56BEAC50908F3708BC4AC3CF7519C", hash_generated_field = "4906CF74EDC592846414C69420DD3136")

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
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.471 -0400", hash_original_field = "90F159E16A269B6F875D096F21ED865D", hash_generated_field = "E32D593DEDB2FDC7FE0DFB7474352DBA")

    private static final int NANOS_PER_MILLI = 1000000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.471 -0400", hash_original_field = "A75E0F742509618A299AC37B99AF7D9B", hash_generated_field = "706621D0D1857AEE97C3233E8B1CD39C")

    public static final int MAX_PRIORITY = 10;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.471 -0400", hash_original_field = "1264FCC1E4F8DDF0EE23E91F2EC7D41B", hash_generated_field = "4B0AE7C1DD2BB6CEB517D1F2268AEEFF")

    public static final int MIN_PRIORITY = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.471 -0400", hash_original_field = "1B497667C5350B8C5FE271A0E46B380B", hash_generated_field = "C493C9DD27E116A919077E0BD37657C0")

    public static final int NORM_PRIORITY = 5;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.471 -0400", hash_original_field = "B1F8A23315AB697B67E425C4B5F81545", hash_generated_field = "6A0B7CDB09C9D5381ED29C2BE609D34C")

    private static int count = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.471 -0400", hash_original_field = "CF5362A11D29DA9A03A7D3AF3A8F9BBA", hash_generated_field = "5C82310D1632632F57D1ECC47F5F0326")

    private static UncaughtExceptionHandler defaultUncaughtHandler;
}

