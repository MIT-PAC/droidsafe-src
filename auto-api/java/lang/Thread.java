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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.567 -0400", hash_original_field = "DFCB349389E84D15F92F0101BDA522EF", hash_generated_field = "AD2271ADED5B0642EAD7F6C10D7138A3")

    volatile VMThread vmThread;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.567 -0400", hash_original_field = "DB0F6F37EBEB6EA09489124345AF2A45", hash_generated_field = "323908075291FF73A0BF0480EC78D762")

    volatile ThreadGroup group;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.567 -0400", hash_original_field = "1F15FCF5421EECD6CA1B61337C319495", hash_generated_field = "1ED59F53ED2B99A4AD9663473B1CC006")

    volatile boolean daemon;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.567 -0400", hash_original_field = "B068931CC450442B63F5B3D276EA4297", hash_generated_field = "34558C70E1377442D4C0DBDA56BC6C23")

    volatile String name;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.567 -0400", hash_original_field = "B988295C268025B49DFB3DF26171DDC3", hash_generated_field = "FDCCFF27A359BAE03856205C3A73A167")

    volatile int priority;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.567 -0400", hash_original_field = "DE15E127B153666F6C6C4FBCAE60419B", hash_generated_field = "31CCA7F61A6273CAFC2F2A0EB46C6C22")

    volatile long stackSize;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.567 -0400", hash_original_field = "42AEFBAE01D2DFD981F7DA7D823D689E", hash_generated_field = "3BC51F00CA4514C3C4790A78C316DD07")

    Runnable target;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.567 -0400", hash_original_field = "B80BB7740288FDA1F201890375A60C8F", hash_generated_field = "AE2623257C6319B5969DD2321BB374E1")

    private long id;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.567 -0400", hash_original_field = "6996C07FA899CEE946C99E7A25F61CC0", hash_generated_field = "BC582D53333FA9EE36376F01B3892F08")

    ThreadLocal.Values localValues;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.567 -0400", hash_original_field = "A9F47F486EE26178B4A9BD31D96AF7BF", hash_generated_field = "1DCD99C357BDD63DBAEA19AB3742D070")

    ThreadLocal.Values inheritableValues;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.567 -0400", hash_original_field = "39B85D264A49C16734A98A1B294FEB8F", hash_generated_field = "271AA7D4BE93A298543E329DAEB8D17F")

    private List<Runnable> interruptActions = new ArrayList<Runnable>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.567 -0400", hash_original_field = "8E1DEE07E23DAA726BAAF0EE9C3C8EE1", hash_generated_field = "C41102AB5C0E4C512DB1FC97849C5D3F")

    private ClassLoader contextClassLoader;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.567 -0400", hash_original_field = "D620DC3DE4E8991B36D1C529F352B7D6", hash_generated_field = "9E70AF0C0F09E0E8D22000D357561505")

    private UncaughtExceptionHandler uncaughtHandler;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.567 -0400", hash_original_field = "B34C39ECBBEB4BBF8B9FDE58CF443A44", hash_generated_field = "F52710C226B829B42671DDE4B1108733")

    boolean hasBeenStarted = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.567 -0400", hash_original_field = "A868BAFA6B5FA0E61CE2762A9B315944", hash_generated_field = "1586B270E49D73D94EC53EC7F719398A")

    private int parkState = ParkState.UNPARKED;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.567 -0400", hash_original_field = "14EE858A6EC2B082926F68B4AA434051", hash_generated_field = "34932EF005581D2A5FD235907377EED6")

    private Object parkBlocker;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.567 -0400", hash_original_method = "A2846A412942D9A4A6734B659C3C08EA", hash_generated_method = "FC648266C8623CAE59D46FDD8401EFDA")
    public  Thread() {
        create(null, null, null, 0);
        // ---------- Original Method ----------
        //create(null, null, null, 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.568 -0400", hash_original_method = "FFE43BBD5535897A2D4ADC63E06A2D0F", hash_generated_method = "2464A64442E80B1B60D1952D0C97ED06")
    public  Thread(Runnable runnable) {
        create(null, runnable, null, 0);
        addTaint(runnable.getTaint());
        // ---------- Original Method ----------
        //create(null, runnable, null, 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.568 -0400", hash_original_method = "BDCA95CAB999722EC25DF6B8E927C95F", hash_generated_method = "AFE574EB0C205FBE7AFD927EC4189C3C")
    public  Thread(Runnable runnable, String threadName) {
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        } //End block
        create(null, runnable, threadName, 0);
        addTaint(runnable.getTaint());
        addTaint(threadName.getTaint());
        // ---------- Original Method ----------
        //if (threadName == null) {
            //throw new NullPointerException();
        //}
        //create(null, runnable, threadName, 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.568 -0400", hash_original_method = "ACB5E26D2EF52FBACC4A4E78EC843CDD", hash_generated_method = "60E9479F8F930222369338000E44863A")
    public  Thread(String threadName) {
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        } //End block
        create(null, null, threadName, 0);
        addTaint(threadName.getTaint());
        // ---------- Original Method ----------
        //if (threadName == null) {
            //throw new NullPointerException();
        //}
        //create(null, null, threadName, 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.582 -0400", hash_original_method = "CFE0254168731091471FC08E1B68E532", hash_generated_method = "FB740864155F25137322B2037E472DD6")
    public  Thread(ThreadGroup group, Runnable runnable) {
        create(group, runnable, null, 0);
        addTaint(group.getTaint());
        addTaint(runnable.getTaint());
        // ---------- Original Method ----------
        //create(group, runnable, null, 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.583 -0400", hash_original_method = "492306C5FED9EC58991A5E8736E27F15", hash_generated_method = "6FDDE2AC95F95B17827802AEA3781483")
    public  Thread(ThreadGroup group, Runnable runnable, String threadName) {
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        } //End block
        create(group, runnable, threadName, 0);
        addTaint(group.getTaint());
        addTaint(runnable.getTaint());
        addTaint(threadName.getTaint());
        // ---------- Original Method ----------
        //if (threadName == null) {
            //throw new NullPointerException();
        //}
        //create(group, runnable, threadName, 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.583 -0400", hash_original_method = "D83475E079BCC4E2E3558A574C3A704E", hash_generated_method = "DAB5BE54DACE9F730A95C8C913536799")
    public  Thread(ThreadGroup group, String threadName) {
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        } //End block
        create(group, null, threadName, 0);
        addTaint(group.getTaint());
        addTaint(threadName.getTaint());
        // ---------- Original Method ----------
        //if (threadName == null) {
            //throw new NullPointerException();
        //}
        //create(group, null, threadName, 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.584 -0400", hash_original_method = "38DDF80F64A6875AC3B97FC941143FB8", hash_generated_method = "0965F782E3842977756B3207844A6FBD")
    public  Thread(ThreadGroup group, Runnable runnable, String threadName, long stackSize) {
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        } //End block
        create(group, runnable, threadName, stackSize);
        addTaint(group.getTaint());
        addTaint(runnable.getTaint());
        addTaint(threadName.getTaint());
        addTaint(stackSize);
        // ---------- Original Method ----------
        //if (threadName == null) {
            //throw new NullPointerException();
        //}
        //create(group, runnable, threadName, stackSize);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.592 -0400", hash_original_method = "DA36D17A4C27DE9C11E6923E1A7A26CA", hash_generated_method = "8DFD98E58D0F1CEA1E9E4414BD48FB01")
      Thread(ThreadGroup group, String name, int priority, boolean daemon) {
        {
            id = ++Thread.count;
        } //End block
        {
            this.name = "Thread-" + id;
        } //End block
        {
            this.name = name;
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new InternalError("group not specified");
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.593 -0400", hash_original_method = "B7E7B76C5A1CA256325AA2280577DF6E", hash_generated_method = "5AD38C81A362B10F85E21EB19D9B0740")
    private void create(ThreadGroup group, Runnable runnable, String threadName, long stackSize) {
        Thread currentThread;
        currentThread = Thread.currentThread();
        {
            group = currentThread.getThreadGroup();
        } //End block
        {
            boolean var1C58EACCC96861E06E4F3C98EDF34DE2_892021440 = (group.isDestroyed());
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalThreadStateException("Group already destroyed");
            } //End block
        } //End collapsed parenthetic
        this.group = group;
        {
            id = ++Thread.count;
        } //End block
        {
            this.name = "Thread-" + id;
        } //End block
        {
            this.name = threadName;
        } //End block
        this.target = runnable;
        this.stackSize = stackSize;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.604 -0400", hash_original_method = "9AC5D8EF15BD7837ACD785C0772615A1", hash_generated_method = "58C0335FEF548999868CED53D4078AEE")
    public final void checkAccess() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.604 -0400", hash_original_method = "6B880F3A25E0C40C35D8EAA702DA9116", hash_generated_method = "3C13224890B8334E6B3BCF4B1A5D66A3")
    @Deprecated
    public int countStackFrames() {
        int var9E94C75F0A654EE4FD94FC83E274820D_1147430545 = (getStackTrace().length);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1275985939 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1275985939;
        // ---------- Original Method ----------
        //return getStackTrace().length;
    }

    
        public static Thread currentThread() {
        return VMThread.currentThread();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.605 -0400", hash_original_method = "E295DBEBB7624DABB0FA2D3E0377892B", hash_generated_method = "36C3BECAF55A9A5399EDB2847CA487F4")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.605 -0400", hash_original_method = "D65A36EB6AF7077545898D8D2274216D", hash_generated_method = "4A7397D2778E11BD9C6C7E919B1804DC")
    public ClassLoader getContextClassLoader() {
        ClassLoader varB4EAC82CA7396A68D541C85D26508E83_271394086 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_271394086 = contextClassLoader;
        varB4EAC82CA7396A68D541C85D26508E83_271394086.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_271394086;
        // ---------- Original Method ----------
        //return contextClassLoader;
    }

    
        public static UncaughtExceptionHandler getDefaultUncaughtExceptionHandler() {
        return defaultUncaughtHandler;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.606 -0400", hash_original_method = "AC34FCBA00CFFBED3290FFC752B7D422", hash_generated_method = "0FFC904DD7CB4ABC5C3FDDC820435476")
    public long getId() {
        long var0F5264038205EDFB1AC05FBB0E8C5E94_2032068172 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_2032068172;
        // ---------- Original Method ----------
        //return id;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.606 -0400", hash_original_method = "7070E6AABEDCBA653834DDC8CF79A47C", hash_generated_method = "66E52FB122450F275DA66C8E7F08BF0F")
    public final String getName() {
        String varB4EAC82CA7396A68D541C85D26508E83_1166069948 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1166069948 = name;
        varB4EAC82CA7396A68D541C85D26508E83_1166069948.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1166069948;
        // ---------- Original Method ----------
        //return name;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.606 -0400", hash_original_method = "0FA6C5514FC3354D3A5FFA078FF2070D", hash_generated_method = "A472EB08AED7D1028F86D56910441124")
    public final int getPriority() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1409917411 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1409917411;
        // ---------- Original Method ----------
        //return priority;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.607 -0400", hash_original_method = "105ECA4B48BD428C2A4BFADC722280E4", hash_generated_method = "CADAD05B9DB6B28406872AB257E02DB7")
    public StackTraceElement[] getStackTrace() {
        StackTraceElement[] varB4EAC82CA7396A68D541C85D26508E83_1210220758 = null; //Variable for return #1
        StackTraceElement ste[];
        ste = VMStack.getThreadStackTrace(this);
        varB4EAC82CA7396A68D541C85D26508E83_1210220758 = ste != null ? ste : EmptyArray.STACK_TRACE_ELEMENT;
        varB4EAC82CA7396A68D541C85D26508E83_1210220758.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1210220758;
        // ---------- Original Method ----------
        //StackTraceElement ste[] = VMStack.getThreadStackTrace(this);
        //return ste != null ? ste : EmptyArray.STACK_TRACE_ELEMENT;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.611 -0400", hash_original_method = "07EB6E55BA9633DD05ED126331098808", hash_generated_method = "D8400BC6A5A56D9A912B8688F5C022B3")
    public State getState() {
        State varB4EAC82CA7396A68D541C85D26508E83_62120645 = null; //Variable for return #1
        State varB4EAC82CA7396A68D541C85D26508E83_584846602 = null; //Variable for return #2
        VMThread vmt;
        vmt = this.vmThread;
        VMThread thread;
        thread = vmThread;
        {
            int state;
            state = thread.getStatus();
            {
                varB4EAC82CA7396A68D541C85D26508E83_62120645 = VMThread.STATE_MAP[state];
            } //End block
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_584846602 = hasBeenStarted ? Thread.State.TERMINATED : Thread.State.NEW;
        State varA7E53CE21691AB073D9660D615818899_732470321; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_732470321 = varB4EAC82CA7396A68D541C85D26508E83_62120645;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_732470321 = varB4EAC82CA7396A68D541C85D26508E83_584846602;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_732470321.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_732470321;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.612 -0400", hash_original_method = "00D5D6D0C2A305848EB6704B96DA1F7A", hash_generated_method = "A4542E2CE82C1B12FC5F6725A3F676AF")
    public final ThreadGroup getThreadGroup() {
        ThreadGroup varB4EAC82CA7396A68D541C85D26508E83_1334252419 = null; //Variable for return #1
        ThreadGroup varB4EAC82CA7396A68D541C85D26508E83_1353478267 = null; //Variable for return #2
        {
            boolean var171B2BD556C2DAB7616FF410FA854B68_1138529288 = (getState() == Thread.State.TERMINATED);
            {
                varB4EAC82CA7396A68D541C85D26508E83_1334252419 = null;
            } //End block
            {
                varB4EAC82CA7396A68D541C85D26508E83_1353478267 = group;
            } //End block
        } //End collapsed parenthetic
        ThreadGroup varA7E53CE21691AB073D9660D615818899_57636413; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_57636413 = varB4EAC82CA7396A68D541C85D26508E83_1334252419;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_57636413 = varB4EAC82CA7396A68D541C85D26508E83_1353478267;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_57636413.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_57636413;
        // ---------- Original Method ----------
        //if (getState() == Thread.State.TERMINATED) {
            //return null;
        //} else {
            //return group;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.612 -0400", hash_original_method = "5CF1F81DC91E6D2E78C73116F661ED4D", hash_generated_method = "F141B52042673F9FF19D16D440CFB970")
    public UncaughtExceptionHandler getUncaughtExceptionHandler() {
        UncaughtExceptionHandler varB4EAC82CA7396A68D541C85D26508E83_2042052810 = null; //Variable for return #1
        UncaughtExceptionHandler varB4EAC82CA7396A68D541C85D26508E83_31067258 = null; //Variable for return #2
        varB4EAC82CA7396A68D541C85D26508E83_2042052810 = uncaughtHandler;
        varB4EAC82CA7396A68D541C85D26508E83_31067258 = group;
        UncaughtExceptionHandler varA7E53CE21691AB073D9660D615818899_1423653868; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1423653868 = varB4EAC82CA7396A68D541C85D26508E83_2042052810;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1423653868 = varB4EAC82CA7396A68D541C85D26508E83_31067258;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1423653868.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1423653868;
        // ---------- Original Method ----------
        //if (uncaughtHandler != null)
            //return uncaughtHandler;
        //else
            //return group;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.619 -0400", hash_original_method = "17DDF3808A6EBB129363B48719FB5512", hash_generated_method = "A6E18F908BBF5EA081EC8BF7D33A91C1")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.633 -0400", hash_original_method = "FDF1C6D176BF98E9EEA025E5AC84BE96", hash_generated_method = "7FFD3BD46D1F94CC6FFA549E6761B01E")
    public final boolean isAlive() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_66976994 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_66976994;
        // ---------- Original Method ----------
        //return (vmThread != null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.634 -0400", hash_original_method = "C545A28661A0C27F268C3C9CA79B188B", hash_generated_method = "13AC1B0AC8DE7ED40266ACD60B1F73A4")
    public final boolean isDaemon() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_645228049 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_645228049;
        // ---------- Original Method ----------
        //return daemon;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.634 -0400", hash_original_method = "8001B196EB7A1BAE7873C2E86818FA5F", hash_generated_method = "C96022FDB5A27DE25797A021AB8F71A2")
    public boolean isInterrupted() {
        VMThread vmt;
        vmt = this.vmThread;
        {
            boolean varB147E6E3B016011716EF89C5EF4EE91E_1664958820 = (vmt.isInterrupted());
        } //End block
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_91345243 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_91345243;
        // ---------- Original Method ----------
        //VMThread vmt = this.vmThread;
        //if (vmt != null) {
            //return vmt.isInterrupted();
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.634 -0400", hash_original_method = "39C10B080916DB467DF3B4EA48EC57E3", hash_generated_method = "2AF5C80EB8237A930A385039C4121C3E")
    public final void join() throws InterruptedException {
        VMThread t;
        t = vmThread;
        {
            {
                boolean var873063CBC3B5729E18294AEF568DDA2D_1307724790 = (isAlive());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.634 -0400", hash_original_method = "4A31F3D41623AEE48E003D8DCAD5BFFA", hash_generated_method = "A8D83846828712BD73ECC565A31B1C62")
    public final void join(long millis) throws InterruptedException {
        join(millis, 0);
        addTaint(millis);
        // ---------- Original Method ----------
        //join(millis, 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.635 -0400", hash_original_method = "7E549C860CA937D59E3BB1D99D89340F", hash_generated_method = "4F0787BBB8A3B5DB82A28E3114269448")
    public final void join(long millis, int nanos) throws InterruptedException {
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
                boolean var0566EB6AFDD7377E42AFAFF497085687_1311277834 = (!isAlive());
            } //End collapsed parenthetic
            long nanosToWait;
            nanosToWait = millis * NANOS_PER_MILLI + nanos;
            long start;
            start = System.nanoTime();
            {
                t.wait(millis, nanos);
                {
                    boolean varCB6183A31E0FF6013B5249081F624AB9_1719667285 = (!isAlive());
                } //End collapsed parenthetic
                long nanosElapsed;
                nanosElapsed = System.nanoTime() - start;
                long nanosRemaining;
                nanosRemaining = nanosToWait - nanosElapsed;
                millis = nanosRemaining / NANOS_PER_MILLI;
                nanos = (int) (nanosRemaining - millis * NANOS_PER_MILLI);
            } //End block
        } //End block
        addTaint(millis);
        addTaint(nanos);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.635 -0400", hash_original_method = "A6ED0DA6D495D98AD3E3BF5221571689", hash_generated_method = "7127AFE74D1383F789C3C1650F177DCD")
    @Deprecated
    public final void resume() {
        if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.636 -0400", hash_original_method = "74F6289977938D08C5FBC2624A0DC216", hash_generated_method = "2BF63E07544CF8CAC1A6A84003858A15")
    public void run() {
        {
            target.run();
        } //End block
        // ---------- Original Method ----------
        //if (target != null) {
            //target.run();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.636 -0400", hash_original_method = "93EFC46ED375C1C54A6285C5204CF25C", hash_generated_method = "3571A2A1E3CF85993D3F0CF0F870AA51")
    public void setContextClassLoader(ClassLoader cl) {
        contextClassLoader = cl;
        // ---------- Original Method ----------
        //contextClassLoader = cl;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.637 -0400", hash_original_method = "9670EAA0D97E9800D90F260AB00393C1", hash_generated_method = "1BD47DC7E674848DD559C3E42E28CCC6")
    public final void setDaemon(boolean isDaemon) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalThreadStateException("Thread already started.");
        } //End block
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

    
        public static void setDefaultUncaughtExceptionHandler(UncaughtExceptionHandler handler) {
        Thread.defaultUncaughtHandler = handler;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.637 -0400", hash_original_method = "C18D87700F0558E88B776CB695EE515A", hash_generated_method = "5E202095E83ABFF5A23B00F90D52C644")
    public final void pushInterruptAction$(Runnable interruptAction) {
        {
            interruptActions.add(interruptAction);
        } //End block
        {
            boolean var43B340B57A719D4D7C0CFC3F5006FC45_136778501 = (interruptAction != null && isInterrupted());
            {
                interruptAction.run();
            } //End block
        } //End collapsed parenthetic
        addTaint(interruptAction.getTaint());
        // ---------- Original Method ----------
        //synchronized (interruptActions) {
            //interruptActions.add(interruptAction);
        //}
        //if (interruptAction != null && isInterrupted()) {
            //interruptAction.run();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.653 -0400", hash_original_method = "134AC2DB3FFDAEE2D6D132954D878FFF", hash_generated_method = "53A8DD6BCC7953F65DDEEDCE24F8B6C7")
    public final void popInterruptAction$(Runnable interruptAction) {
        {
            Runnable removed;
            removed = interruptActions.remove(interruptActions.size() - 1);
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException(
                        "Expected " + interruptAction + " but was " + removed);
            } //End block
        } //End block
        addTaint(interruptAction.getTaint());
        // ---------- Original Method ----------
        //synchronized (interruptActions) {
            //Runnable removed = interruptActions.remove(interruptActions.size() - 1);
            //if (interruptAction != removed) {
                //throw new IllegalArgumentException(
                        //"Expected " + interruptAction + " but was " + removed);
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.655 -0400", hash_original_method = "52D88413A8A1215EC9D935022AA7508F", hash_generated_method = "7BCFF61457EDE0DAC326CAB67B3874C9")
    public final void setName(String threadName) {
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        } //End block
        name = threadName;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.656 -0400", hash_original_method = "A91023FCF06B8647A6CEF3B99492A3A2", hash_generated_method = "84A94BB16048E9EBE7F43C2A1300E11E")
    public final void setPriority(int priority) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Priority out of range");
        } //End block
        {
            boolean var09022039D3A5CC2E35F1A0263EEA0B28_1711955064 = (priority > group.getMaxPriority());
            {
                priority = group.getMaxPriority();
            } //End block
        } //End collapsed parenthetic
        this.priority = priority;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.664 -0400", hash_original_method = "D58D250923779D2B2016D80FC2081BA1", hash_generated_method = "32052A607317B2CF4FD95D37AFA858D8")
    public void setUncaughtExceptionHandler(UncaughtExceptionHandler handler) {
        uncaughtHandler = handler;
        // ---------- Original Method ----------
        //uncaughtHandler = handler;
    }

    
        public static void sleep(long time) throws InterruptedException {
        Thread.sleep(time, 0);
    }

    
        public static void sleep(long millis, int nanos) throws InterruptedException {
        VMThread.sleep(millis, nanos);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.664 -0400", hash_original_method = "389CF6E0D3A08F228CF4E4A156CC86D9", hash_generated_method = "A9E55DD47285DE615AB80AE7D304FD86")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.665 -0400", hash_original_method = "345C33A5CF7530BB38CAED519DB524FA", hash_generated_method = "4CF021D91E790FABEAD72EF8B01ED19B")
    @Deprecated
    public final void stop() {
        stop(new ThreadDeath());
        // ---------- Original Method ----------
        //stop(new ThreadDeath());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.665 -0400", hash_original_method = "B034829378D149E76566D897B904AD02", hash_generated_method = "F4EC0ADB88C6F9F035AF7F23A73CC321")
    @Deprecated
    public final synchronized void stop(Throwable throwable) {
        if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
        addTaint(throwable.getTaint());
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.665 -0400", hash_original_method = "BFD882A151848FA6FDA9CF11B3EB5020", hash_generated_method = "9A7B3ED01C039412AA9411EB2D88C724")
    @Deprecated
    public final void suspend() {
        if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.673 -0400", hash_original_method = "E21D755A7854968438B35D363D61DC14", hash_generated_method = "53DB58F0DA6C8249D14BCDE19DB5EE19")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_802817190 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_802817190 = "Thread[" + name + "," + priority + "," + group.getName() + "]";
        varB4EAC82CA7396A68D541C85D26508E83_802817190.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_802817190;
        // ---------- Original Method ----------
        //return "Thread[" + name + "," + priority + "," + group.getName() + "]";
    }

    
        public static void yield() {
        VMThread.yield();
    }

    
        public static boolean holdsLock(Object object) {
        return currentThread().vmThread.holdsLock(object);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.674 -0400", hash_original_method = "A23472E398F1697320641EE9BCE07378", hash_generated_method = "155D260F9601300AEE8BB6DE80919762")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.676 -0400", hash_original_method = "25C50086F373F8B2A1357A67BAD56EA4", hash_generated_method = "BEBA018E186F1236E964473C6764335E")
    public void parkFor(long nanos) {
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
        addTaint(nanos);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.676 -0400", hash_original_method = "98F10CBBB26C44644E065EAD29E052AC", hash_generated_method = "F3E0ECE32285763A0A5DD1B871700AAC")
    public void parkUntil(long time) {
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
        addTaint(time);
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
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.676 -0400", hash_original_method = "13ABD2C1475A75B421FFE7ADB6CF97D6", hash_generated_method = "13ABD2C1475A75B421FFE7ADB6CF97D6")
        public ParkState ()
        {
            //Synthesized constructor
        }


        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.676 -0400", hash_original_field = "E764ADEE54F384BBC4FD06FD8EF08C01", hash_generated_field = "7BA6C4756DCFC3C4F20226537125E9FC")

        private static int UNPARKED = 1;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.676 -0400", hash_original_field = "04755C457D6EF4EAD76F049ABB047AA1", hash_generated_field = "D771756AE285ABF91C2AE6F527E53B27")

        private static int PREEMPTIVELY_UNPARKED = 2;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.676 -0400", hash_original_field = "C7A56BEAC50908F3708BC4AC3CF7519C", hash_generated_field = "4459D64E8DA5BE7E69D1947ABD1D11A2")

        private static int PARKED = 3;
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
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.676 -0400", hash_original_field = "90F159E16A269B6F875D096F21ED865D", hash_generated_field = "01FF75DD42CEEFF83B007A550DB754A1")

    private static int NANOS_PER_MILLI = 1000000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.676 -0400", hash_original_field = "A75E0F742509618A299AC37B99AF7D9B", hash_generated_field = "706621D0D1857AEE97C3233E8B1CD39C")

    public static final int MAX_PRIORITY = 10;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.677 -0400", hash_original_field = "1264FCC1E4F8DDF0EE23E91F2EC7D41B", hash_generated_field = "4B0AE7C1DD2BB6CEB517D1F2268AEEFF")

    public static final int MIN_PRIORITY = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.677 -0400", hash_original_field = "1B497667C5350B8C5FE271A0E46B380B", hash_generated_field = "C493C9DD27E116A919077E0BD37657C0")

    public static final int NORM_PRIORITY = 5;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.677 -0400", hash_original_field = "B1F8A23315AB697B67E425C4B5F81545", hash_generated_field = "6A0B7CDB09C9D5381ED29C2BE609D34C")

    private static int count = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.677 -0400", hash_original_field = "CF5362A11D29DA9A03A7D3AF3A8F9BBA", hash_generated_field = "5C82310D1632632F57D1ECC47F5F0326")

    private static UncaughtExceptionHandler defaultUncaughtHandler;
}

