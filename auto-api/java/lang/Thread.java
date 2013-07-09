package java.lang;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import dalvik.system.VMStack;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import libcore.util.EmptyArray;

public class Thread implements Runnable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:51.136 -0400", hash_original_field = "DFCB349389E84D15F92F0101BDA522EF", hash_generated_field = "AD2271ADED5B0642EAD7F6C10D7138A3")

    volatile VMThread vmThread;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:51.136 -0400", hash_original_field = "DB0F6F37EBEB6EA09489124345AF2A45", hash_generated_field = "323908075291FF73A0BF0480EC78D762")

    volatile ThreadGroup group;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:51.136 -0400", hash_original_field = "1F15FCF5421EECD6CA1B61337C319495", hash_generated_field = "1ED59F53ED2B99A4AD9663473B1CC006")

    volatile boolean daemon;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:51.136 -0400", hash_original_field = "B068931CC450442B63F5B3D276EA4297", hash_generated_field = "34558C70E1377442D4C0DBDA56BC6C23")

    volatile String name;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:51.136 -0400", hash_original_field = "B988295C268025B49DFB3DF26171DDC3", hash_generated_field = "FDCCFF27A359BAE03856205C3A73A167")

    volatile int priority;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:51.136 -0400", hash_original_field = "DE15E127B153666F6C6C4FBCAE60419B", hash_generated_field = "31CCA7F61A6273CAFC2F2A0EB46C6C22")

    volatile long stackSize;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:51.136 -0400", hash_original_field = "42AEFBAE01D2DFD981F7DA7D823D689E", hash_generated_field = "3BC51F00CA4514C3C4790A78C316DD07")

    Runnable target;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:51.136 -0400", hash_original_field = "B80BB7740288FDA1F201890375A60C8F", hash_generated_field = "AE2623257C6319B5969DD2321BB374E1")

    private long id;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:51.136 -0400", hash_original_field = "6996C07FA899CEE946C99E7A25F61CC0", hash_generated_field = "BC582D53333FA9EE36376F01B3892F08")

    ThreadLocal.Values localValues;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:51.137 -0400", hash_original_field = "A9F47F486EE26178B4A9BD31D96AF7BF", hash_generated_field = "1DCD99C357BDD63DBAEA19AB3742D070")

    ThreadLocal.Values inheritableValues;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:51.137 -0400", hash_original_field = "39B85D264A49C16734A98A1B294FEB8F", hash_generated_field = "90F6FDD1E7EA8160FB4E33738C8B4E2A")

    private final List<Runnable> interruptActions = new ArrayList<Runnable>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:51.137 -0400", hash_original_field = "8E1DEE07E23DAA726BAAF0EE9C3C8EE1", hash_generated_field = "C41102AB5C0E4C512DB1FC97849C5D3F")

    private ClassLoader contextClassLoader;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:51.137 -0400", hash_original_field = "D620DC3DE4E8991B36D1C529F352B7D6", hash_generated_field = "9E70AF0C0F09E0E8D22000D357561505")

    private UncaughtExceptionHandler uncaughtHandler;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:51.137 -0400", hash_original_field = "B34C39ECBBEB4BBF8B9FDE58CF443A44", hash_generated_field = "F52710C226B829B42671DDE4B1108733")

    boolean hasBeenStarted = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:51.137 -0400", hash_original_field = "A868BAFA6B5FA0E61CE2762A9B315944", hash_generated_field = "1586B270E49D73D94EC53EC7F719398A")

    private int parkState = ParkState.UNPARKED;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:51.137 -0400", hash_original_field = "14EE858A6EC2B082926F68B4AA434051", hash_generated_field = "34932EF005581D2A5FD235907377EED6")

    private Object parkBlocker;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:51.137 -0400", hash_original_method = "A2846A412942D9A4A6734B659C3C08EA", hash_generated_method = "FC648266C8623CAE59D46FDD8401EFDA")
    public  Thread() {
        create(null, null, null, 0);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:51.137 -0400", hash_original_method = "FFE43BBD5535897A2D4ADC63E06A2D0F", hash_generated_method = "2464A64442E80B1B60D1952D0C97ED06")
    public  Thread(Runnable runnable) {
        create(null, runnable, null, 0);
        addTaint(runnable.getTaint());
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:51.137 -0400", hash_original_method = "BDCA95CAB999722EC25DF6B8E927C95F", hash_generated_method = "AFE574EB0C205FBE7AFD927EC4189C3C")
    public  Thread(Runnable runnable, String threadName) {
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        } 
        create(null, runnable, threadName, 0);
        addTaint(runnable.getTaint());
        addTaint(threadName.getTaint());
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:51.138 -0400", hash_original_method = "ACB5E26D2EF52FBACC4A4E78EC843CDD", hash_generated_method = "60E9479F8F930222369338000E44863A")
    public  Thread(String threadName) {
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        } 
        create(null, null, threadName, 0);
        addTaint(threadName.getTaint());
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:51.138 -0400", hash_original_method = "CFE0254168731091471FC08E1B68E532", hash_generated_method = "FB740864155F25137322B2037E472DD6")
    public  Thread(ThreadGroup group, Runnable runnable) {
        create(group, runnable, null, 0);
        addTaint(group.getTaint());
        addTaint(runnable.getTaint());
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:51.138 -0400", hash_original_method = "492306C5FED9EC58991A5E8736E27F15", hash_generated_method = "6FDDE2AC95F95B17827802AEA3781483")
    public  Thread(ThreadGroup group, Runnable runnable, String threadName) {
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        } 
        create(group, runnable, threadName, 0);
        addTaint(group.getTaint());
        addTaint(runnable.getTaint());
        addTaint(threadName.getTaint());
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:51.138 -0400", hash_original_method = "D83475E079BCC4E2E3558A574C3A704E", hash_generated_method = "DAB5BE54DACE9F730A95C8C913536799")
    public  Thread(ThreadGroup group, String threadName) {
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        } 
        create(group, null, threadName, 0);
        addTaint(group.getTaint());
        addTaint(threadName.getTaint());
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:51.139 -0400", hash_original_method = "38DDF80F64A6875AC3B97FC941143FB8", hash_generated_method = "0965F782E3842977756B3207844A6FBD")
    public  Thread(ThreadGroup group, Runnable runnable, String threadName, long stackSize) {
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        } 
        create(group, runnable, threadName, stackSize);
        addTaint(group.getTaint());
        addTaint(runnable.getTaint());
        addTaint(threadName.getTaint());
        addTaint(stackSize);
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:51.139 -0400", hash_original_method = "DA36D17A4C27DE9C11E6923E1A7A26CA", hash_generated_method = "8DFD98E58D0F1CEA1E9E4414BD48FB01")
      Thread(ThreadGroup group, String name, int priority, boolean daemon) {
        {
            id = ++Thread.count;
        } 
        {
            this.name = "Thread-" + id;
        } 
        {
            this.name = name;
        } 
        {
            if (DroidSafeAndroidRuntime.control) throw new InternalError("group not specified");
        } 
        this.group = group;
        this.target = null;
        this.stackSize = 0;
        this.priority = priority;
        this.daemon = daemon;
        this.group.addThread(this);
        
        
            
        
        
            
        
            
        
        
            
        
        
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:51.140 -0400", hash_original_method = "B7E7B76C5A1CA256325AA2280577DF6E", hash_generated_method = "5785DEC908F37874FED380BF6BDAE8E9")
    private void create(ThreadGroup group, Runnable runnable, String threadName, long stackSize) {
        Thread currentThread = Thread.currentThread();
        {
            group = currentThread.getThreadGroup();
        } 
        {
            boolean var1C58EACCC96861E06E4F3C98EDF34DE2_1647774408 = (group.isDestroyed());
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalThreadStateException("Group already destroyed");
            } 
        } 
        this.group = group;
        {
            id = ++Thread.count;
        } 
        {
            this.name = "Thread-" + id;
        } 
        {
            this.name = threadName;
        } 
        this.target = runnable;
        this.stackSize = stackSize;
        this.priority = currentThread.getPriority();
        this.contextClassLoader = currentThread.contextClassLoader;
        {
            inheritableValues = new ThreadLocal.Values(currentThread.inheritableValues);
        } 
        this.group.addThread(this);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    public static int activeCount() {
        return currentThread().getThreadGroup().activeCount();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:51.141 -0400", hash_original_method = "9AC5D8EF15BD7837ACD785C0772615A1", hash_generated_method = "58C0335FEF548999868CED53D4078AEE")
    public final void checkAccess() {
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:51.142 -0400", hash_original_method = "6B880F3A25E0C40C35D8EAA702DA9116", hash_generated_method = "373623D91668E94D5E4BDB565641C502")
    @Deprecated
    public int countStackFrames() {
        int var9E94C75F0A654EE4FD94FC83E274820D_1771488847 = (getStackTrace().length);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_213276312 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_213276312;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    public static Thread currentThread() {
        return VMThread.currentThread();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:51.142 -0400", hash_original_method = "E295DBEBB7624DABB0FA2D3E0377892B", hash_generated_method = "36C3BECAF55A9A5399EDB2847CA487F4")
    @Deprecated
    public void destroy() {
        if (DroidSafeAndroidRuntime.control) throw new NoSuchMethodError("Thread.destroy()");
        
        
    }

    
    @DSModeled(DSC.SAFE)
    public static void dumpStack() {
        new Throwable("stack dump").printStackTrace();
    }

    
    @DSModeled(DSC.SAFE)
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

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:51.143 -0400", hash_original_method = "D65A36EB6AF7077545898D8D2274216D", hash_generated_method = "976DC6D5BAE6E71D4FB2FA40794E3843")
    public ClassLoader getContextClassLoader() {
        ClassLoader varB4EAC82CA7396A68D541C85D26508E83_1395625169 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1395625169 = contextClassLoader;
        varB4EAC82CA7396A68D541C85D26508E83_1395625169.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1395625169;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    public static UncaughtExceptionHandler getDefaultUncaughtExceptionHandler() {
        return defaultUncaughtHandler;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:51.144 -0400", hash_original_method = "AC34FCBA00CFFBED3290FFC752B7D422", hash_generated_method = "49CD63A326FDE475FD557D92E1AA1D41")
    public long getId() {
        long var0F5264038205EDFB1AC05FBB0E8C5E94_809548834 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_809548834;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:51.144 -0400", hash_original_method = "7070E6AABEDCBA653834DDC8CF79A47C", hash_generated_method = "9B084E5F073955F4BC5495FF494C7EAF")
    public final String getName() {
        String varB4EAC82CA7396A68D541C85D26508E83_612480251 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_612480251 = name;
        varB4EAC82CA7396A68D541C85D26508E83_612480251.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_612480251;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:51.144 -0400", hash_original_method = "0FA6C5514FC3354D3A5FFA078FF2070D", hash_generated_method = "487D6BA88E797B6A9DE784F31C165D06")
    public final int getPriority() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_564987025 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_564987025;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:51.144 -0400", hash_original_method = "105ECA4B48BD428C2A4BFADC722280E4", hash_generated_method = "7046467C1028847730628781C89CF459")
    public StackTraceElement[] getStackTrace() {
        StackTraceElement[] varB4EAC82CA7396A68D541C85D26508E83_423092436 = null; 
        StackTraceElement ste[] = VMStack.getThreadStackTrace(this);
        varB4EAC82CA7396A68D541C85D26508E83_423092436 = ste != null ? ste : EmptyArray.STACK_TRACE_ELEMENT;
        varB4EAC82CA7396A68D541C85D26508E83_423092436.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_423092436;
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:51.145 -0400", hash_original_method = "07EB6E55BA9633DD05ED126331098808", hash_generated_method = "46FC9AF42A06C581991A9CAEE2A1923E")
    public State getState() {
        State varB4EAC82CA7396A68D541C85D26508E83_679439757 = null; 
        State varB4EAC82CA7396A68D541C85D26508E83_987003521 = null; 
        VMThread vmt = this.vmThread;
        VMThread thread = vmThread;
        {
            int state = thread.getStatus();
            {
                varB4EAC82CA7396A68D541C85D26508E83_679439757 = VMThread.STATE_MAP[state];
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_987003521 = hasBeenStarted ? Thread.State.TERMINATED : Thread.State.NEW;
        State varA7E53CE21691AB073D9660D615818899_1481530322; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1481530322 = varB4EAC82CA7396A68D541C85D26508E83_679439757;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1481530322 = varB4EAC82CA7396A68D541C85D26508E83_987003521;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1481530322.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1481530322;
        
        
        
        
            
            
                
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:51.145 -0400", hash_original_method = "00D5D6D0C2A305848EB6704B96DA1F7A", hash_generated_method = "8304FA7079BC447E70F8BDE205A6B355")
    public final ThreadGroup getThreadGroup() {
        ThreadGroup varB4EAC82CA7396A68D541C85D26508E83_904838599 = null; 
        ThreadGroup varB4EAC82CA7396A68D541C85D26508E83_57331995 = null; 
        {
            boolean var171B2BD556C2DAB7616FF410FA854B68_73767171 = (getState() == Thread.State.TERMINATED);
            {
                varB4EAC82CA7396A68D541C85D26508E83_904838599 = null;
            } 
            {
                varB4EAC82CA7396A68D541C85D26508E83_57331995 = group;
            } 
        } 
        ThreadGroup varA7E53CE21691AB073D9660D615818899_2144594261; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_2144594261 = varB4EAC82CA7396A68D541C85D26508E83_904838599;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_2144594261 = varB4EAC82CA7396A68D541C85D26508E83_57331995;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_2144594261.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_2144594261;
        
        
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:51.146 -0400", hash_original_method = "5CF1F81DC91E6D2E78C73116F661ED4D", hash_generated_method = "191F5FADBBAC366867BBD1E981EFB8F7")
    public UncaughtExceptionHandler getUncaughtExceptionHandler() {
        UncaughtExceptionHandler varB4EAC82CA7396A68D541C85D26508E83_362558682 = null; 
        UncaughtExceptionHandler varB4EAC82CA7396A68D541C85D26508E83_1434417632 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_362558682 = uncaughtHandler;
        varB4EAC82CA7396A68D541C85D26508E83_1434417632 = group;
        UncaughtExceptionHandler varA7E53CE21691AB073D9660D615818899_568721015; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_568721015 = varB4EAC82CA7396A68D541C85D26508E83_362558682;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_568721015 = varB4EAC82CA7396A68D541C85D26508E83_1434417632;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_568721015.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_568721015;
        
        
            
        
            
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:51.146 -0400", hash_original_method = "17DDF3808A6EBB129363B48719FB5512", hash_generated_method = "85BDC992592956DFFC91E884124C4592")
    public void interrupt() {
        {
            {
                int i = interruptActions.size() - 1;
                {
                    interruptActions.get(i).run();
                } 
            } 
        } 
        VMThread vmt = this.vmThread;
        {
            vmt.interrupt();
        } 
        
        
            
                
            
        
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    public static boolean interrupted() {
        return VMThread.interrupted();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:51.147 -0400", hash_original_method = "FDF1C6D176BF98E9EEA025E5AC84BE96", hash_generated_method = "D9A7D9BAC346B234C151D3D667F34CE6")
    public final boolean isAlive() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_453775190 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_453775190;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:51.147 -0400", hash_original_method = "C545A28661A0C27F268C3C9CA79B188B", hash_generated_method = "7F8034A62BFC27EBA3CA91D14E0177D4")
    public final boolean isDaemon() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1963443926 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1963443926;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:51.147 -0400", hash_original_method = "8001B196EB7A1BAE7873C2E86818FA5F", hash_generated_method = "A6AE6669AD555A90ED5446007CDEB5A9")
    public boolean isInterrupted() {
        VMThread vmt = this.vmThread;
        {
            boolean varB147E6E3B016011716EF89C5EF4EE91E_1565146523 = (vmt.isInterrupted());
        } 
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1604515773 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1604515773;
        
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:51.147 -0400", hash_original_method = "39C10B080916DB467DF3B4EA48EC57E3", hash_generated_method = "38572041887E96C851002B7C5721CAD8")
    public final void join() throws InterruptedException {
        VMThread t = vmThread;
        {
            {
                boolean var873063CBC3B5729E18294AEF568DDA2D_569650595 = (isAlive());
                {
                    t.wait();
                } 
            } 
        } 
        
        
        
            
        
        
            
                
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:51.147 -0400", hash_original_method = "4A31F3D41623AEE48E003D8DCAD5BFFA", hash_generated_method = "A8D83846828712BD73ECC565A31B1C62")
    public final void join(long millis) throws InterruptedException {
        join(millis, 0);
        addTaint(millis);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:51.148 -0400", hash_original_method = "7E549C860CA937D59E3BB1D99D89340F", hash_generated_method = "9B48A77BBC39BFA71AF01F42F79B44B3")
    public final void join(long millis, int nanos) throws InterruptedException {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException();
        } 
        boolean overflow = millis >= (Long.MAX_VALUE - nanos) / NANOS_PER_MILLI;
        boolean forever = (millis | nanos) == 0;
        {
            join();
        } 
        VMThread t = vmThread;
        {
            {
                boolean var0566EB6AFDD7377E42AFAFF497085687_520053712 = (!isAlive());
            } 
            long nanosToWait = millis * NANOS_PER_MILLI + nanos;
            long start = System.nanoTime();
            {
                t.wait(millis, nanos);
                {
                    boolean varCB6183A31E0FF6013B5249081F624AB9_1245861015 = (!isAlive());
                } 
                long nanosElapsed = System.nanoTime() - start;
                long nanosRemaining = nanosToWait - nanosElapsed;
                millis = nanosRemaining / NANOS_PER_MILLI;
                nanos = (int) (nanosRemaining - millis * NANOS_PER_MILLI);
            } 
        } 
        addTaint(millis);
        addTaint(nanos);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:51.148 -0400", hash_original_method = "A6ED0DA6D495D98AD3E3BF5221571689", hash_generated_method = "7127AFE74D1383F789C3C1650F177DCD")
    @Deprecated
    public final void resume() {
        if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:51.149 -0400", hash_original_method = "74F6289977938D08C5FBC2624A0DC216", hash_generated_method = "2BF63E07544CF8CAC1A6A84003858A15")
    public void run() {
        {
            target.run();
        } 
        
        
            
        
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:51.149 -0400", hash_original_method = "93EFC46ED375C1C54A6285C5204CF25C", hash_generated_method = "3571A2A1E3CF85993D3F0CF0F870AA51")
    public void setContextClassLoader(ClassLoader cl) {
        contextClassLoader = cl;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:51.149 -0400", hash_original_method = "9670EAA0D97E9800D90F260AB00393C1", hash_generated_method = "1BD47DC7E674848DD559C3E42E28CCC6")
    public final void setDaemon(boolean isDaemon) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalThreadStateException("Thread already started.");
        } 
        {
            daemon = isDaemon;
        } 
        
        
            
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    public static void setDefaultUncaughtExceptionHandler(UncaughtExceptionHandler handler) {
        Thread.defaultUncaughtHandler = handler;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:51.150 -0400", hash_original_method = "C18D87700F0558E88B776CB695EE515A", hash_generated_method = "CD88915D7DD8315FD40411372C349671")
    public final void pushInterruptAction$(Runnable interruptAction) {
        {
            interruptActions.add(interruptAction);
        } 
        {
            boolean var43B340B57A719D4D7C0CFC3F5006FC45_1721935705 = (interruptAction != null && isInterrupted());
            {
                interruptAction.run();
            } 
        } 
        addTaint(interruptAction.getTaint());
        
        
            
        
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:51.151 -0400", hash_original_method = "134AC2DB3FFDAEE2D6D132954D878FFF", hash_generated_method = "58F8842CA0FCB81383933C555A74F700")
    public final void popInterruptAction$(Runnable interruptAction) {
        {
            Runnable removed = interruptActions.remove(interruptActions.size() - 1);
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException(
                        "Expected " + interruptAction + " but was " + removed);
            } 
        } 
        addTaint(interruptAction.getTaint());
        
        
            
            
                
                        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:51.151 -0400", hash_original_method = "52D88413A8A1215EC9D935022AA7508F", hash_generated_method = "AC6C54005EC7F626223D93673559875D")
    public final void setName(String threadName) {
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        } 
        name = threadName;
        VMThread vmt = this.vmThread;
        {
            vmt.nameChanged(threadName);
        } 
        
        
            
        
        
        
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:51.152 -0400", hash_original_method = "A91023FCF06B8647A6CEF3B99492A3A2", hash_generated_method = "66FA94F05F52E194A60FED60786072A7")
    public final void setPriority(int priority) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Priority out of range");
        } 
        {
            boolean var09022039D3A5CC2E35F1A0263EEA0B28_1807078099 = (priority > group.getMaxPriority());
            {
                priority = group.getMaxPriority();
            } 
        } 
        this.priority = priority;
        VMThread vmt = this.vmThread;
        {
            vmt.setPriority(priority);
        } 
        
        
            
        
        
            
        
        
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:51.152 -0400", hash_original_method = "D58D250923779D2B2016D80FC2081BA1", hash_generated_method = "32052A607317B2CF4FD95D37AFA858D8")
    public void setUncaughtExceptionHandler(UncaughtExceptionHandler handler) {
        uncaughtHandler = handler;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    public static void sleep(long time) throws InterruptedException {
        Thread.sleep(time, 0);
    }

    
    @DSModeled(DSC.SAFE)
    public static void sleep(long millis, int nanos) throws InterruptedException {
        VMThread.sleep(millis, nanos);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:51.153 -0400", hash_original_method = "389CF6E0D3A08F228CF4E4A156CC86D9", hash_generated_method = "A9E55DD47285DE615AB80AE7D304FD86")
    public synchronized void start() {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalThreadStateException("Thread already started.");
        } 
        hasBeenStarted = true;
        VMThread.create(this, stackSize);
        this.run();
        
            
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:51.153 -0400", hash_original_method = "345C33A5CF7530BB38CAED519DB524FA", hash_generated_method = "4CF021D91E790FABEAD72EF8B01ED19B")
    @Deprecated
    public final void stop() {
        stop(new ThreadDeath());
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:51.154 -0400", hash_original_method = "B034829378D149E76566D897B904AD02", hash_generated_method = "F4EC0ADB88C6F9F035AF7F23A73CC321")
    @Deprecated
    public final synchronized void stop(Throwable throwable) {
        if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
        addTaint(throwable.getTaint());
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:51.154 -0400", hash_original_method = "BFD882A151848FA6FDA9CF11B3EB5020", hash_generated_method = "9A7B3ED01C039412AA9411EB2D88C724")
    @Deprecated
    public final void suspend() {
        if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:51.154 -0400", hash_original_method = "E21D755A7854968438B35D363D61DC14", hash_generated_method = "6C57A2A7BCD576B23C824C205EE353AE")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_1360844124 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1360844124 = "Thread[" + name + "," + priority + "," + group.getName() + "]";
        varB4EAC82CA7396A68D541C85D26508E83_1360844124.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1360844124;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    public static void yield() {
        VMThread.yield();
    }

    
    @DSModeled(DSC.SAFE)
    public static boolean holdsLock(Object object) {
        return currentThread().vmThread.holdsLock(object);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:51.155 -0400", hash_original_method = "A23472E398F1697320641EE9BCE07378", hash_generated_method = "7F4425B2AE28A5EAA4CCA0AD15D34C3F")
    public void unpark() {
        VMThread vmt = vmThread;
        {
            parkState = ParkState.PREEMPTIVELY_UNPARKED;
        } 
        {
            
            {
                parkState = ParkState.PREEMPTIVELY_UNPARKED;
            } 
            
            
            {
                parkState = ParkState.UNPARKED;
                vmt.notifyAll();
            } 
            
        } 
        
        
        
            
            
        
        
            
                
                    
                
                
                    
                    
                
                
                    
                    
                    
                
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:51.156 -0400", hash_original_method = "25C50086F373F8B2A1357A67BAD56EA4", hash_generated_method = "48EC7DF189ED9C28449325C0B0628781")
    public void parkFor(long nanos) {
        VMThread vmt = vmThread;
        {
            if (DroidSafeAndroidRuntime.control) throw new AssertionError();
        } 
        {
            
            {
                parkState = ParkState.UNPARKED;
            } 
            
            
            {
                long millis = nanos / NANOS_PER_MILLI;
                nanos %= NANOS_PER_MILLI;
                parkState = ParkState.PARKED;
                try 
                {
                    vmt.wait(millis, (int) nanos);
                } 
                catch (InterruptedException ex)
                {
                    interrupt();
                } 
                finally 
                {
                    {
                        parkState = ParkState.UNPARKED;
                    } 
                } 
            } 
            
            
            {
                if (DroidSafeAndroidRuntime.control) throw new AssertionError(
                            "shouldn't happen: attempt to repark");
            } 
            
        } 
        addTaint(nanos);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:51.158 -0400", hash_original_method = "98F10CBBB26C44644E065EAD29E052AC", hash_generated_method = "FD0FE484F99932B96D5CB4F76E01A129")
    public void parkUntil(long time) {
        VMThread vmt = vmThread;
        {
            if (DroidSafeAndroidRuntime.control) throw new AssertionError();
        } 
        {
            long delayMillis = time - System.currentTimeMillis();
            {
                parkState = ParkState.UNPARKED;
            } 
            {
                parkFor(delayMillis * NANOS_PER_MILLI);
            } 
        } 
        addTaint(time);
        
        
        
            
        
        
            
            
                
            
                
            
        
    }

    
    private static class ParkState {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:51.158 -0400", hash_original_method = "13ABD2C1475A75B421FFE7ADB6CF97D6", hash_generated_method = "13ABD2C1475A75B421FFE7ADB6CF97D6")
        public ParkState ()
        {
            
        }


        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:51.158 -0400", hash_original_field = "E764ADEE54F384BBC4FD06FD8EF08C01", hash_generated_field = "5F7B3D5520F70EA2E650375F945D4166")

        private static final int UNPARKED = 1;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:51.158 -0400", hash_original_field = "04755C457D6EF4EAD76F049ABB047AA1", hash_generated_field = "7BF82648F2EB786712FF07EA5F35294C")

        private static final int PREEMPTIVELY_UNPARKED = 2;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:51.158 -0400", hash_original_field = "C7A56BEAC50908F3708BC4AC3CF7519C", hash_generated_field = "4906CF74EDC592846414C69420DD3136")

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
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:51.159 -0400", hash_original_field = "90F159E16A269B6F875D096F21ED865D", hash_generated_field = "E32D593DEDB2FDC7FE0DFB7474352DBA")

    private static final int NANOS_PER_MILLI = 1000000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:51.159 -0400", hash_original_field = "A75E0F742509618A299AC37B99AF7D9B", hash_generated_field = "706621D0D1857AEE97C3233E8B1CD39C")

    public static final int MAX_PRIORITY = 10;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:51.159 -0400", hash_original_field = "1264FCC1E4F8DDF0EE23E91F2EC7D41B", hash_generated_field = "4B0AE7C1DD2BB6CEB517D1F2268AEEFF")

    public static final int MIN_PRIORITY = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:51.159 -0400", hash_original_field = "1B497667C5350B8C5FE271A0E46B380B", hash_generated_field = "C493C9DD27E116A919077E0BD37657C0")

    public static final int NORM_PRIORITY = 5;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:51.159 -0400", hash_original_field = "B1F8A23315AB697B67E425C4B5F81545", hash_generated_field = "6A0B7CDB09C9D5381ED29C2BE609D34C")

    private static int count = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:51.159 -0400", hash_original_field = "CF5362A11D29DA9A03A7D3AF3A8F9BBA", hash_generated_field = "5C82310D1632632F57D1ECC47F5F0326")

    private static UncaughtExceptionHandler defaultUncaughtHandler;
}

