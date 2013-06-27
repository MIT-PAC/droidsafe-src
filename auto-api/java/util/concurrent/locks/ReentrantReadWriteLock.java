package java.util.concurrent.locks;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.util.concurrent.*;
import java.util.concurrent.atomic.*;
import java.util.*;

public class ReentrantReadWriteLock implements ReadWriteLock, java.io.Serializable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:58.434 -0400", hash_original_field = "53A68C354CA707EE3CF4135EF2B687CE", hash_generated_field = "8F79220737B731E52680B143D15FE029")

    private ReentrantReadWriteLock.ReadLock readerLock;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:58.434 -0400", hash_original_field = "D7F1DF52BEB3372136F52E8F5BBC02A3", hash_generated_field = "1E1067A0A17FE39A5B241BAB85413180")

    private ReentrantReadWriteLock.WriteLock writerLock;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:58.434 -0400", hash_original_field = "63AD9D34F3503826E5F649AE6B7AC92C", hash_generated_field = "791C2888A6F5CDC158445182FD1E3538")

    Sync sync;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:58.434 -0400", hash_original_method = "1C7ADE1C43258ED1B8231199DCC94C2F", hash_generated_method = "A2362B6FC27126ECCCC3F80E71268B1E")
    public  ReentrantReadWriteLock() {
        this(false);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:58.435 -0400", hash_original_method = "A6CD875E912D33CADF6A81571C0A078B", hash_generated_method = "40472467CFFF2D78F76EB33BF5AABCCB")
    public  ReentrantReadWriteLock(boolean fair) {
        sync = fair ? new FairSync() : new NonfairSync();
        readerLock = new ReadLock(this);
        writerLock = new WriteLock(this);
        // ---------- Original Method ----------
        //sync = fair ? new FairSync() : new NonfairSync();
        //readerLock = new ReadLock(this);
        //writerLock = new WriteLock(this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:58.439 -0400", hash_original_method = "0C7BC9C54BE00E03201ACF18B2913309", hash_generated_method = "EF3DF23CE839FAE000A99045181833E7")
    public ReentrantReadWriteLock.WriteLock writeLock() {
        ReentrantReadWriteLock.WriteLock varB4EAC82CA7396A68D541C85D26508E83_1466562615 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1466562615 = writerLock;
        varB4EAC82CA7396A68D541C85D26508E83_1466562615.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1466562615;
        // ---------- Original Method ----------
        //return writerLock;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:58.439 -0400", hash_original_method = "22D8B34ECDA1804C5F879E9731CF210D", hash_generated_method = "E8A738573D9BA89D96970CA91C119271")
    public ReentrantReadWriteLock.ReadLock readLock() {
        ReentrantReadWriteLock.ReadLock varB4EAC82CA7396A68D541C85D26508E83_1254328782 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1254328782 = readerLock;
        varB4EAC82CA7396A68D541C85D26508E83_1254328782.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1254328782;
        // ---------- Original Method ----------
        //return readerLock;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:58.443 -0400", hash_original_method = "6835E283E5F9E7FBD3FF7844476992AD", hash_generated_method = "0CAFABBDD92E9E70085F1A1B303125D8")
    public final boolean isFair() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_641591437 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_641591437;
        // ---------- Original Method ----------
        //return sync instanceof FairSync;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:58.444 -0400", hash_original_method = "DB009A0944F572B5167ED6D51E109787", hash_generated_method = "9844D72C40C5642421569C3BFD71BDD9")
    protected Thread getOwner() {
        Thread varB4EAC82CA7396A68D541C85D26508E83_205689194 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_205689194 = sync.getOwner();
        varB4EAC82CA7396A68D541C85D26508E83_205689194.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_205689194;
        // ---------- Original Method ----------
        //return sync.getOwner();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:58.455 -0400", hash_original_method = "BDA3BC7F9F6754233D710BB1E8BDA625", hash_generated_method = "772BC10D70E08CEFD4D3D2577E80B4EA")
    public int getReadLockCount() {
        int var5CF7DD4739FB0661883910CE3127C2D4_1812327421 = (sync.getReadLockCount());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_895866230 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_895866230;
        // ---------- Original Method ----------
        //return sync.getReadLockCount();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:58.456 -0400", hash_original_method = "D1234101A768FDEE737EDDFEC7DD19A3", hash_generated_method = "F810A84CB8636003DDB01D6CB005DCBB")
    public boolean isWriteLocked() {
        boolean varC09930903B4B15334864667BA6922CA7_468583055 = (sync.isWriteLocked());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1647871584 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1647871584;
        // ---------- Original Method ----------
        //return sync.isWriteLocked();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:58.456 -0400", hash_original_method = "B77A8CC69384EA638697FDA5B4AC3CDF", hash_generated_method = "8B219DCCCE1BAECCF2A5BA606C715756")
    public boolean isWriteLockedByCurrentThread() {
        boolean var12281D4A72DEB9F8816A0A46604F1374_861042606 = (sync.isHeldExclusively());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1971684844 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1971684844;
        // ---------- Original Method ----------
        //return sync.isHeldExclusively();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:58.457 -0400", hash_original_method = "F72E2C7B278B975FDBAAB080F7322122", hash_generated_method = "93083B37EDC0D327AE2084A2F034E9CC")
    public int getWriteHoldCount() {
        int var4B7ADBEF86627032166821903A70F5D0_1602262032 = (sync.getWriteHoldCount());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_713678214 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_713678214;
        // ---------- Original Method ----------
        //return sync.getWriteHoldCount();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:58.457 -0400", hash_original_method = "026686F812EC7870B6E447136A7E8B3A", hash_generated_method = "0A55FD7AF0631764C15E5B000A14CBDB")
    public int getReadHoldCount() {
        int var4CA9F99F5577509EFAE445B14D1ED825_333685516 = (sync.getReadHoldCount());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1017280735 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1017280735;
        // ---------- Original Method ----------
        //return sync.getReadHoldCount();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:58.458 -0400", hash_original_method = "2F9252966607830729245C7251D0E4B8", hash_generated_method = "4DE302F8A3C9158AA1DC8408B894A067")
    protected Collection<Thread> getQueuedWriterThreads() {
        Collection<Thread> varB4EAC82CA7396A68D541C85D26508E83_1936518163 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1936518163 = sync.getExclusiveQueuedThreads();
        varB4EAC82CA7396A68D541C85D26508E83_1936518163.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1936518163;
        // ---------- Original Method ----------
        //return sync.getExclusiveQueuedThreads();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:58.465 -0400", hash_original_method = "956CE594FDB46F8FEF252F1FDB068D3D", hash_generated_method = "3C4963534EA24C9CA404950E422DE1AE")
    protected Collection<Thread> getQueuedReaderThreads() {
        Collection<Thread> varB4EAC82CA7396A68D541C85D26508E83_1839173536 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1839173536 = sync.getSharedQueuedThreads();
        varB4EAC82CA7396A68D541C85D26508E83_1839173536.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1839173536;
        // ---------- Original Method ----------
        //return sync.getSharedQueuedThreads();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:58.465 -0400", hash_original_method = "33B7DCC82A105082FC4D268ED56F9DE5", hash_generated_method = "767C08E3B40E0EB7C9B306593E3F8088")
    public final boolean hasQueuedThreads() {
        boolean var4C0A0AB508905DA8D619627A5EEFD574_975635257 = (sync.hasQueuedThreads());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1218429833 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1218429833;
        // ---------- Original Method ----------
        //return sync.hasQueuedThreads();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:58.466 -0400", hash_original_method = "7B179E46CDF5B520CCEEF15512EC2C63", hash_generated_method = "646E2C57FE9DB643965B3172B5EA9DCE")
    public final boolean hasQueuedThread(Thread thread) {
        boolean var0681201A478D613CAAB4B4D5196C3EF3_1229287443 = (sync.isQueued(thread));
        addTaint(thread.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_933381509 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_933381509;
        // ---------- Original Method ----------
        //return sync.isQueued(thread);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:58.466 -0400", hash_original_method = "DFFF2C05339152644F00EC2FFC57EFB9", hash_generated_method = "DE910F0C626FB95F3B1B8394BD30E5C2")
    public final int getQueueLength() {
        int var2545CC142A0CD1008911850681315651_1782517987 = (sync.getQueueLength());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1575870972 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1575870972;
        // ---------- Original Method ----------
        //return sync.getQueueLength();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:58.473 -0400", hash_original_method = "4BC73C35668DA24636BE58FB68209032", hash_generated_method = "064CFFAA107A185179C4A423F6EA0630")
    protected Collection<Thread> getQueuedThreads() {
        Collection<Thread> varB4EAC82CA7396A68D541C85D26508E83_1838870004 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1838870004 = sync.getQueuedThreads();
        varB4EAC82CA7396A68D541C85D26508E83_1838870004.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1838870004;
        // ---------- Original Method ----------
        //return sync.getQueuedThreads();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:58.474 -0400", hash_original_method = "BF91F0F13FB6E88A38744502E21F1F2D", hash_generated_method = "1DFC41D24FE9F2BFDDC6BB46D5225A66")
    public boolean hasWaiters(Condition condition) {
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("not owner");
        boolean varD78146513D32810B85075F5879934833_393375905 = (sync.hasWaiters((AbstractQueuedSynchronizer.ConditionObject)condition));
        addTaint(condition.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2075741184 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2075741184;
        // ---------- Original Method ----------
        //if (condition == null)
            //throw new NullPointerException();
        //if (!(condition instanceof AbstractQueuedSynchronizer.ConditionObject))
            //throw new IllegalArgumentException("not owner");
        //return sync.hasWaiters((AbstractQueuedSynchronizer.ConditionObject)condition);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:58.490 -0400", hash_original_method = "D4277B3B6ED39F705D915D3806A5548A", hash_generated_method = "00FF4CBEE488EF1544DF35E1EFE9C847")
    public int getWaitQueueLength(Condition condition) {
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("not owner");
        int var60A2F707F5BC43BB059D2028F4E4733B_977876938 = (sync.getWaitQueueLength((AbstractQueuedSynchronizer.ConditionObject)condition));
        addTaint(condition.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_63687898 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_63687898;
        // ---------- Original Method ----------
        //if (condition == null)
            //throw new NullPointerException();
        //if (!(condition instanceof AbstractQueuedSynchronizer.ConditionObject))
            //throw new IllegalArgumentException("not owner");
        //return sync.getWaitQueueLength((AbstractQueuedSynchronizer.ConditionObject)condition);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:58.490 -0400", hash_original_method = "29738EA386BFBB41E36C961DB4B1CBE5", hash_generated_method = "28012D394C49B770BE98EC517FF3A960")
    protected Collection<Thread> getWaitingThreads(Condition condition) {
        Collection<Thread> varB4EAC82CA7396A68D541C85D26508E83_831449414 = null; //Variable for return #1
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("not owner");
        varB4EAC82CA7396A68D541C85D26508E83_831449414 = sync.getWaitingThreads((AbstractQueuedSynchronizer.ConditionObject)condition);
        addTaint(condition.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_831449414.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_831449414;
        // ---------- Original Method ----------
        //if (condition == null)
            //throw new NullPointerException();
        //if (!(condition instanceof AbstractQueuedSynchronizer.ConditionObject))
            //throw new IllegalArgumentException("not owner");
        //return sync.getWaitingThreads((AbstractQueuedSynchronizer.ConditionObject)condition);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:58.491 -0400", hash_original_method = "03D5EBF343C873E095999F30626DADA2", hash_generated_method = "F864C3C104A6B7675404584D7CD55102")
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_996950861 = null; //Variable for return #1
        int c;
        c = sync.getCount();
        int w;
        w = Sync.exclusiveCount(c);
        int r;
        r = Sync.sharedCount(c);
        varB4EAC82CA7396A68D541C85D26508E83_996950861 = super.toString() +
            "[Write locks = " + w + ", Read locks = " + r + "]";
        varB4EAC82CA7396A68D541C85D26508E83_996950861.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_996950861;
        // ---------- Original Method ----------
        //int c = sync.getCount();
        //int w = Sync.exclusiveCount(c);
        //int r = Sync.sharedCount(c);
        //return super.toString() +
            //"[Write locks = " + w + ", Read locks = " + r + "]";
    }

    
    abstract static class Sync extends AbstractQueuedSynchronizer {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:58.503 -0400", hash_original_field = "E08C8E97570C1DCB9CD554FD7079B697", hash_generated_field = "8C4B3BD798FE5D7E8EB3D0536576D262")

        private transient ThreadLocalHoldCounter readHolds;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:58.503 -0400", hash_original_field = "DF91768C2D431EA735A71A6CE08F4181", hash_generated_field = "2EE67430D3D959E367F77E7EF6425C16")

        private transient HoldCounter cachedHoldCounter;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:58.504 -0400", hash_original_field = "AAA28B60505EF94BD4CA2E8CC3EC3C64", hash_generated_field = "A011FC8C4363F320801F082EF2C621C1")

        private transient Thread firstReader = null;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:58.504 -0400", hash_original_field = "64FF72C6AF21D3CE02435570D431F32C", hash_generated_field = "D6E4ACE63DE2E9B4DD29D78376D1F793")

        private transient int firstReaderHoldCount;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:58.504 -0400", hash_original_method = "89DA4D8EA92261B26BAB9F4AB5CDD482", hash_generated_method = "F96B116FAEB3CF7E52F47724A0D1064E")
          Sync() {
            readHolds = new ThreadLocalHoldCounter();
            setState(getState());
            // ---------- Original Method ----------
            //readHolds = new ThreadLocalHoldCounter();
            //setState(getState());
        }

        
                static int sharedCount(int c) {
            return c >>> SHARED_SHIFT;
        }

        
                static int exclusiveCount(int c) {
            return c & EXCLUSIVE_MASK;
        }

        
        abstract boolean readerShouldBlock();

        
        abstract boolean writerShouldBlock();

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:58.505 -0400", hash_original_method = "E2589B88E3FBFBAA4E5917277DEFE99E", hash_generated_method = "97F448F7BA5A2A2A1F82F85C0F711650")
        protected final boolean tryRelease(int releases) {
            {
                boolean varBDF0ABD2F20F8D3DCB5C83DB8D0ED9B5_1189096113 = (!isHeldExclusively());
                if (DroidSafeAndroidRuntime.control) throw new IllegalMonitorStateException();
            } //End collapsed parenthetic
            int nextc;
            nextc = getState() - releases;
            boolean free;
            free = exclusiveCount(nextc) == 0;
            setExclusiveOwnerThread(null);
            setState(nextc);
            addTaint(releases);
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_561481099 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_561481099;
            // ---------- Original Method ----------
            //if (!isHeldExclusively())
                //throw new IllegalMonitorStateException();
            //int nextc = getState() - releases;
            //boolean free = exclusiveCount(nextc) == 0;
            //if (free)
                //setExclusiveOwnerThread(null);
            //setState(nextc);
            //return free;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:58.508 -0400", hash_original_method = "887DB434CE6AB550C72A17E01EAED908", hash_generated_method = "9760E5F5FDBB145403201F15AD5D32E0")
        protected final boolean tryAcquire(int acquires) {
            Thread current;
            current = Thread.currentThread();
            int c;
            c = getState();
            int w;
            w = exclusiveCount(c);
            {
                {
                    boolean var90979142887A20EB72C8964C86EB9321_927171112 = (w == 0 || current != getExclusiveOwnerThread());
                } //End collapsed parenthetic
                {
                    boolean var318575A0FEE61BCA2C1999503B3E7456_188080638 = (w + exclusiveCount(acquires) > MAX_COUNT);
                    if (DroidSafeAndroidRuntime.control) throw new Error("Maximum lock count exceeded");
                } //End collapsed parenthetic
                setState(c + acquires);
            } //End block
            {
                boolean var33B66AF91B134BC4CCDF9A857D584490_813607466 = (writerShouldBlock() ||
                !compareAndSetState(c, c + acquires));
            } //End collapsed parenthetic
            setExclusiveOwnerThread(current);
            addTaint(acquires);
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_443054079 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_443054079;
            // ---------- Original Method ----------
            //Thread current = Thread.currentThread();
            //int c = getState();
            //int w = exclusiveCount(c);
            //if (c != 0) {
                //if (w == 0 || current != getExclusiveOwnerThread())
                    //return false;
                //if (w + exclusiveCount(acquires) > MAX_COUNT)
                    //throw new Error("Maximum lock count exceeded");
                //setState(c + acquires);
                //return true;
            //}
            //if (writerShouldBlock() ||
                //!compareAndSetState(c, c + acquires))
                //return false;
            //setExclusiveOwnerThread(current);
            //return true;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:58.509 -0400", hash_original_method = "DCB6BD37D30DD1C1033C1677B2F2BA39", hash_generated_method = "A0A81399CBA32A7F5ABC2B9DD2312050")
        protected final boolean tryReleaseShared(int unused) {
            Thread current;
            current = Thread.currentThread();
            {
                firstReader = null;
            } //End block
            {
                HoldCounter rh;
                rh = cachedHoldCounter;
                {
                    boolean var742A69B23BBDDB423EC138DCBB7B9545_808602264 = (rh == null || rh.tid != current.getId());
                    rh = readHolds.get();
                } //End collapsed parenthetic
                int count;
                count = rh.count;
                {
                    readHolds.remove();
                    if (DroidSafeAndroidRuntime.control) throw unmatchedUnlockException();
                } //End block
            } //End block
            {
                int c;
                c = getState();
                int nextc;
                nextc = c - SHARED_UNIT;
                {
                    boolean var525F59EF5A984E7DE1A679CCEEFC8101_251136379 = (compareAndSetState(c, nextc));
                } //End collapsed parenthetic
            } //End block
            addTaint(unused);
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2142377423 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_2142377423;
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:58.509 -0400", hash_original_method = "4AE7D8D2A940AB168E8F2908DE9ACCF1", hash_generated_method = "335FC32BDDF9A5CB7730FAEC374D2D95")
        private IllegalMonitorStateException unmatchedUnlockException() {
            IllegalMonitorStateException varB4EAC82CA7396A68D541C85D26508E83_1680932139 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1680932139 = new IllegalMonitorStateException(
                "attempt to unlock read lock, not locked by current thread");
            varB4EAC82CA7396A68D541C85D26508E83_1680932139.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1680932139;
            // ---------- Original Method ----------
            //return new IllegalMonitorStateException(
                //"attempt to unlock read lock, not locked by current thread");
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:58.514 -0400", hash_original_method = "AD4C82A786111FF828AFE5FE5C8E5A39", hash_generated_method = "09FBC37BCFA29A528A579D5FD12133D6")
        protected final int tryAcquireShared(int unused) {
            Thread current;
            current = Thread.currentThread();
            int c;
            c = getState();
            {
                boolean varCBCE136FFBA6AA5474A803A63D00FAD1_898152228 = (exclusiveCount(c) != 0 &&
                getExclusiveOwnerThread() != current);
            } //End collapsed parenthetic
            int r;
            r = sharedCount(c);
            {
                boolean varC705F9493B1FAEA076FDA3794FAA0183_313548469 = (!readerShouldBlock() &&
                r < MAX_COUNT &&
                compareAndSetState(c, c + SHARED_UNIT));
                {
                    {
                        firstReader = current;
                        firstReaderHoldCount = 1;
                    } //End block
                    {
                        HoldCounter rh;
                        rh = cachedHoldCounter;
                        {
                            boolean varDB55354BA83BD531EC70083B969F9FA7_115513800 = (rh == null || rh.tid != current.getId());
                            cachedHoldCounter = rh = readHolds.get();
                            readHolds.set(rh);
                        } //End collapsed parenthetic
                    } //End block
                } //End block
            } //End collapsed parenthetic
            int var203CD572536C941A4B1A477F089EE192_669493780 = (fullTryAcquireShared(current));
            addTaint(unused);
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1565282484 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1565282484;
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:58.516 -0400", hash_original_method = "EBE8D8355B366068B4B1E29E3A9EED12", hash_generated_method = "055E4B5681E088699A14109989DA7442")
        final int fullTryAcquireShared(Thread current) {
            HoldCounter rh;
            rh = null;
            {
                int c;
                c = getState();
                {
                    boolean var529468DC4620BDF65F6B6C7D22F44273_548349558 = (exclusiveCount(c) != 0);
                    {
                        {
                            boolean varD3F580BFEF90DED8D0695E9E6E71809D_402708855 = (getExclusiveOwnerThread() != current);
                        } //End collapsed parenthetic
                    } //End block
                    {
                        boolean var860368E133590F744493740787A52E27_665448806 = (readerShouldBlock());
                        {
                            {
                                {
                                    rh = cachedHoldCounter;
                                    {
                                        boolean var84643B1DF9273A723910E3CDDBCE3609_2045338669 = (rh == null || rh.tid != current.getId());
                                        {
                                            rh = readHolds.get();
                                            readHolds.remove();
                                        } //End block
                                    } //End collapsed parenthetic
                                } //End block
                            } //End block
                        } //End block
                    } //End collapsed parenthetic
                } //End collapsed parenthetic
                {
                    boolean var81C9C11D2632075F5A3FC662D0DAC8FC_1955754209 = (sharedCount(c) == MAX_COUNT);
                    if (DroidSafeAndroidRuntime.control) throw new Error("Maximum lock count exceeded");
                } //End collapsed parenthetic
                {
                    boolean varED20116B0BB1734240062BCE3EF53974_664106189 = (compareAndSetState(c, c + SHARED_UNIT));
                    {
                        {
                            boolean varD8F1AA39FE8E689164014F966ADE2AC4_2120387588 = (sharedCount(c) == 0);
                            {
                                firstReader = current;
                                firstReaderHoldCount = 1;
                            } //End block
                            {
                                rh = cachedHoldCounter;
                                {
                                    boolean var50B8EA88D62C62CC9B48E69494903B06_911804562 = (rh == null || rh.tid != current.getId());
                                    rh = readHolds.get();
                                    readHolds.set(rh);
                                } //End collapsed parenthetic
                                cachedHoldCounter = rh;
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                } //End collapsed parenthetic
            } //End block
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_449729352 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_449729352;
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:58.533 -0400", hash_original_method = "0DD6CA3D230AA260224A4A3AE8239ACB", hash_generated_method = "40AEFF1D7DD7BA6CD9DAB443107CAC82")
        final boolean tryWriteLock() {
            Thread current;
            current = Thread.currentThread();
            int c;
            c = getState();
            {
                int w;
                w = exclusiveCount(c);
                {
                    boolean var90979142887A20EB72C8964C86EB9321_870816579 = (w == 0 || current != getExclusiveOwnerThread());
                } //End collapsed parenthetic
                if (DroidSafeAndroidRuntime.control) throw new Error("Maximum lock count exceeded");
            } //End block
            {
                boolean var42EFECE5F4E2BBE5A5608C37A8B687F3_1153166525 = (!compareAndSetState(c, c + 1));
            } //End collapsed parenthetic
            setExclusiveOwnerThread(current);
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_585794389 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_585794389;
            // ---------- Original Method ----------
            //Thread current = Thread.currentThread();
            //int c = getState();
            //if (c != 0) {
                //int w = exclusiveCount(c);
                //if (w == 0 || current != getExclusiveOwnerThread())
                    //return false;
                //if (w == MAX_COUNT)
                    //throw new Error("Maximum lock count exceeded");
            //}
            //if (!compareAndSetState(c, c + 1))
                //return false;
            //setExclusiveOwnerThread(current);
            //return true;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:58.534 -0400", hash_original_method = "F864315749E9B3DD069E258F497DFE4D", hash_generated_method = "4861CA439CF4C41441C59EDB6A64B86F")
        final boolean tryReadLock() {
            Thread current;
            current = Thread.currentThread();
            {
                int c;
                c = getState();
                {
                    boolean varEA7F18DF3FD18041706E4732508BA651_336747959 = (exclusiveCount(c) != 0 &&
                    getExclusiveOwnerThread() != current);
                } //End collapsed parenthetic
                int r;
                r = sharedCount(c);
                if (DroidSafeAndroidRuntime.control) throw new Error("Maximum lock count exceeded");
                {
                    boolean varED20116B0BB1734240062BCE3EF53974_11932367 = (compareAndSetState(c, c + SHARED_UNIT));
                    {
                        {
                            firstReader = current;
                            firstReaderHoldCount = 1;
                        } //End block
                        {
                            HoldCounter rh;
                            rh = cachedHoldCounter;
                            {
                                boolean varD70438DD2BB853F7AACBE7CBC6449999_1798335043 = (rh == null || rh.tid != current.getId());
                                cachedHoldCounter = rh = readHolds.get();
                                readHolds.set(rh);
                            } //End collapsed parenthetic
                        } //End block
                    } //End block
                } //End collapsed parenthetic
            } //End block
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_328391656 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_328391656;
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:58.534 -0400", hash_original_method = "A843CC28FFAE9A089B89A0058BA2B9D5", hash_generated_method = "2A40BACDA9733863B82B3F834030FB63")
        protected final boolean isHeldExclusively() {
            boolean var3CE6B8DE56D5A33803435E843AACF76A_701992039 = (getExclusiveOwnerThread() == Thread.currentThread());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1738849627 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1738849627;
            // ---------- Original Method ----------
            //return getExclusiveOwnerThread() == Thread.currentThread();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:58.545 -0400", hash_original_method = "093F0D0E6A279CA43864791B6FD65040", hash_generated_method = "E1A2A8587F13C951C9C2E48EE7222590")
        final ConditionObject newCondition() {
            ConditionObject varB4EAC82CA7396A68D541C85D26508E83_202347759 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_202347759 = new ConditionObject();
            varB4EAC82CA7396A68D541C85D26508E83_202347759.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_202347759;
            // ---------- Original Method ----------
            //return new ConditionObject();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:58.546 -0400", hash_original_method = "3F3DE8BCF9BFC159EB93FF2ABA8024D7", hash_generated_method = "4639CC38FC51445F65D0E3295E3544F5")
        final Thread getOwner() {
            Thread varB4EAC82CA7396A68D541C85D26508E83_433638715 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_433638715 = ((exclusiveCount(getState()) == 0) ?
                    null :
                    getExclusiveOwnerThread());
            varB4EAC82CA7396A68D541C85D26508E83_433638715.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_433638715;
            // ---------- Original Method ----------
            //return ((exclusiveCount(getState()) == 0) ?
                    //null :
                    //getExclusiveOwnerThread());
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:58.546 -0400", hash_original_method = "0B84E22FFE55E13BE40413778559BE34", hash_generated_method = "C61C3D9BE7F263E92DAEAECBFDC077F9")
        final int getReadLockCount() {
            int var5073DFD1A27AB6C474CC24F8B7EC3CD3_486342929 = (sharedCount(getState()));
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_232190461 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_232190461;
            // ---------- Original Method ----------
            //return sharedCount(getState());
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:58.547 -0400", hash_original_method = "09CA8B61F6450707C75BFC712569D4D4", hash_generated_method = "C0000414BEC40C69C11CD0819888EFDA")
        final boolean isWriteLocked() {
            boolean var01CAC84C2F38392161F4E16039D7DE44_1774833487 = (exclusiveCount(getState()) != 0);
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1067935572 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1067935572;
            // ---------- Original Method ----------
            //return exclusiveCount(getState()) != 0;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:58.547 -0400", hash_original_method = "67C0C583D90F5F49CAE0DBAE2DE27D59", hash_generated_method = "11CDDEF66FB67B6F8973BC5B2A4F13D0")
        final int getWriteHoldCount() {
            {
                boolean var34E827331B4BC7F16DFC99E8B4EE154E_418265276 = (isHeldExclusively());
                Object var0847481376D95B453E4DA8F62DB7ADA1_1651010297 = (exclusiveCount(getState()));
            } //End flattened ternary
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1219594770 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1219594770;
            // ---------- Original Method ----------
            //return isHeldExclusively() ? exclusiveCount(getState()) : 0;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:58.559 -0400", hash_original_method = "1DA1A38561287A101F5C2B623B00252F", hash_generated_method = "0C9E9FD256DBB1509C777AB0F2080FE3")
        final int getReadHoldCount() {
            {
                boolean varCF77250596B8C839BEFAC301F344C853_509176736 = (getReadLockCount() == 0);
            } //End collapsed parenthetic
            Thread current;
            current = Thread.currentThread();
            HoldCounter rh;
            rh = cachedHoldCounter;
            {
                boolean var12BC8C81E89FF6364E7C14D490B5B984_1641904802 = (rh != null && rh.tid == current.getId());
            } //End collapsed parenthetic
            int count;
            count = readHolds.get().count;
            readHolds.remove();
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_574372569 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_574372569;
            // ---------- Original Method ----------
            //if (getReadLockCount() == 0)
                //return 0;
            //Thread current = Thread.currentThread();
            //if (firstReader == current)
                //return firstReaderHoldCount;
            //HoldCounter rh = cachedHoldCounter;
            //if (rh != null && rh.tid == current.getId())
                //return rh.count;
            //int count = readHolds.get().count;
            //if (count == 0) readHolds.remove();
            //return count;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:58.560 -0400", hash_original_method = "4E48396D4489DBF7E8DA7E593070FC82", hash_generated_method = "32B8CD4904A66075F3560379D9DD0971")
        private void readObject(java.io.ObjectInputStream s) throws java.io.IOException, ClassNotFoundException {
            s.defaultReadObject();
            readHolds = new ThreadLocalHoldCounter();
            setState(0);
            addTaint(s.getTaint());
            // ---------- Original Method ----------
            //s.defaultReadObject();
            //readHolds = new ThreadLocalHoldCounter();
            //setState(0);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:58.561 -0400", hash_original_method = "192D38E698A214D58DA93C3298AD6AD3", hash_generated_method = "2B5EDDD3D33EA3DB4247325535271715")
        final int getCount() {
            int var376B5C2087169E76FB6628D31DCC9663_732831159 = (getState());
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_666122182 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_666122182;
            // ---------- Original Method ----------
            //return getState();
        }

        
        static final class HoldCounter {
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:58.561 -0400", hash_original_field = "B1F8A23315AB697B67E425C4B5F81545", hash_generated_field = "B524E41AA0CF6AD39267F32C8C687778")

            int count = 0;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:58.561 -0400", hash_original_field = "A7CAC231571D7123EBB48A8647C318F9", hash_generated_field = "0A37A20E7316460B86A4063014209DB0")

            long tid = Thread.currentThread().getId();
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:58.561 -0400", hash_original_method = "F1D8E352EDEF0AB237A69949FE7423C4", hash_generated_method = "F1D8E352EDEF0AB237A69949FE7423C4")
            public HoldCounter ()
            {
                //Synthesized constructor
            }


        }


        
        static final class ThreadLocalHoldCounter extends ThreadLocal<HoldCounter> {
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:58.561 -0400", hash_original_method = "2811BFD99460ECBD8E7948B925FFB736", hash_generated_method = "2811BFD99460ECBD8E7948B925FFB736")
            public ThreadLocalHoldCounter ()
            {
                //Synthesized constructor
            }


            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:58.562 -0400", hash_original_method = "65FB587992A751B61B2E99AB391905DE", hash_generated_method = "F9261728180C7C96BC9C58FC34607791")
            public HoldCounter initialValue() {
                HoldCounter varB4EAC82CA7396A68D541C85D26508E83_485722166 = null; //Variable for return #1
                varB4EAC82CA7396A68D541C85D26508E83_485722166 = new HoldCounter();
                varB4EAC82CA7396A68D541C85D26508E83_485722166.addTaint(getTaint()); //Add taint from parent
                return varB4EAC82CA7396A68D541C85D26508E83_485722166;
                // ---------- Original Method ----------
                //return new HoldCounter();
            }

            
        }


        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:58.563 -0400", hash_original_field = "F661B57F5D85B8C55CBF8EC6C1332293", hash_generated_field = "BA0B420BE81E5BF79693521ABA242882")

        private static long serialVersionUID = 6317671515068378041L;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:58.563 -0400", hash_original_field = "84B1E483133CB506AF0F344691E6DF0D", hash_generated_field = "5ECB677A41E894B5658B3C4F2E6597E3")

        static int SHARED_SHIFT = 16;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:58.563 -0400", hash_original_field = "24C85CCC5E848FE7AAEF439B797AF477", hash_generated_field = "D9384BE805847F2AF0B98C6F9D323117")

        static int SHARED_UNIT = (1 << SHARED_SHIFT);
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:58.563 -0400", hash_original_field = "2A4F653E74D03DB9FBF055439C642017", hash_generated_field = "9D31CD643AFBFC9F034DE14EC99B4A83")

        static int MAX_COUNT = (1 << SHARED_SHIFT) - 1;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:58.563 -0400", hash_original_field = "36C9424C451B233CA56EB28EF0E91CDB", hash_generated_field = "C5A8821D5AE1C22DAC9D77672450F877")

        static int EXCLUSIVE_MASK = (1 << SHARED_SHIFT) - 1;
    }


    
    static final class NonfairSync extends Sync {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:58.563 -0400", hash_original_method = "92700F1FF079627760B83F1F338B8E6E", hash_generated_method = "92700F1FF079627760B83F1F338B8E6E")
        public NonfairSync ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:58.563 -0400", hash_original_method = "6099B514073B77A554543D2A2B955577", hash_generated_method = "6D23A44A1A89670400076E177E4F302D")
        final boolean writerShouldBlock() {
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1887884718 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1887884718;
            // ---------- Original Method ----------
            //return false;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:58.564 -0400", hash_original_method = "311D59812186188137CBEED2258453A3", hash_generated_method = "83F065CEFCC02A58EA99DC648AF22D5A")
        final boolean readerShouldBlock() {
            boolean var42C6C6A77390D0F65AEC7AEAAD6B4F91_1427740267 = (apparentlyFirstQueuedIsExclusive());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_572179980 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_572179980;
            // ---------- Original Method ----------
            //return apparentlyFirstQueuedIsExclusive();
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:58.564 -0400", hash_original_field = "962FC793F1AA6943131BF3E9C77AA5E7", hash_generated_field = "7DE0AF38F9670C2D3271D8E7778ED398")

        private static long serialVersionUID = -8159625535654395037L;
    }


    
    static final class FairSync extends Sync {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:58.564 -0400", hash_original_method = "76BFFA90730B34917875BAE48AE8B396", hash_generated_method = "76BFFA90730B34917875BAE48AE8B396")
        public FairSync ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:58.564 -0400", hash_original_method = "F04DB8A71B8ACD86834CABDF23C7982B", hash_generated_method = "E25D32FEA367907FCD59912FD83C5C6D")
        final boolean writerShouldBlock() {
            boolean var5D9F3BF4621CB4A60B96236F06AF2405_1099651211 = (hasQueuedPredecessors());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1515505245 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1515505245;
            // ---------- Original Method ----------
            //return hasQueuedPredecessors();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:58.577 -0400", hash_original_method = "5E806298851931D3FCAB2DE2F5A11624", hash_generated_method = "A315EF7BE10EA1D607A9C9F5100F8766")
        final boolean readerShouldBlock() {
            boolean var5D9F3BF4621CB4A60B96236F06AF2405_491996068 = (hasQueuedPredecessors());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_259150458 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_259150458;
            // ---------- Original Method ----------
            //return hasQueuedPredecessors();
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:58.577 -0400", hash_original_field = "789C476CB4886D7F76862344BE9A6172", hash_generated_field = "93CD0C200CCC5616652EC597B40432C5")

        private static long serialVersionUID = -2274990926593161451L;
    }


    
    public static class ReadLock implements Lock, java.io.Serializable {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:58.578 -0400", hash_original_field = "63AD9D34F3503826E5F649AE6B7AC92C", hash_generated_field = "A4B34EF3CE38520839B34A2F06599243")

        private Sync sync;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:58.578 -0400", hash_original_method = "86296C44CAAC51998FCC18AC6C334852", hash_generated_method = "90987B1257AE5908AD98C331E68E3B50")
        protected  ReadLock(ReentrantReadWriteLock lock) {
            sync = lock.sync;
            // ---------- Original Method ----------
            //sync = lock.sync;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:58.578 -0400", hash_original_method = "8D72D73F25D8DE6C9209D04669F96039", hash_generated_method = "F147980700CF869A8D6F7133099FA372")
        public void lock() {
            sync.acquireShared(1);
            // ---------- Original Method ----------
            //sync.acquireShared(1);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:58.579 -0400", hash_original_method = "61D542FCA692219B5199CDDD1A71CCC6", hash_generated_method = "87CEA29C19FE66B6CBD3C0925E99729C")
        public void lockInterruptibly() throws InterruptedException {
            sync.acquireSharedInterruptibly(1);
            // ---------- Original Method ----------
            //sync.acquireSharedInterruptibly(1);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:58.579 -0400", hash_original_method = "6F9DD593410D3A6A5FB658A804C67B03", hash_generated_method = "E344F118B9BF9C0986B66DD2EDFC3422")
        public boolean tryLock() {
            boolean var82642F761C8CC4EFB1E9891565A562E0_26537162 = (sync.tryReadLock());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1805598520 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1805598520;
            // ---------- Original Method ----------
            //return sync.tryReadLock();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:58.580 -0400", hash_original_method = "CABC63B31BFC6EB1808F17E4FED50740", hash_generated_method = "BE57F5CBB0B8EF0191DAEDDE6B432783")
        public boolean tryLock(long timeout, TimeUnit unit) throws InterruptedException {
            boolean varC650725F0ACDDC932C370EDA1774172F_2137487439 = (sync.tryAcquireSharedNanos(1, unit.toNanos(timeout)));
            addTaint(timeout);
            addTaint(unit.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1651872301 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1651872301;
            // ---------- Original Method ----------
            //return sync.tryAcquireSharedNanos(1, unit.toNanos(timeout));
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:58.597 -0400", hash_original_method = "2E2DA507FE1EE35FD0E649F791C4FA62", hash_generated_method = "CE7F47B976DC7C53582533934AC31AFE")
        public void unlock() {
            sync.releaseShared(1);
            // ---------- Original Method ----------
            //sync.releaseShared(1);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:58.597 -0400", hash_original_method = "9996D083DB29CA9E935A73F01FAD8A4F", hash_generated_method = "AA6177806CFC2176E106167AD695F2AC")
        public Condition newCondition() {
            if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
            // ---------- Original Method ----------
            //throw new UnsupportedOperationException();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:58.598 -0400", hash_original_method = "4EA811A9ADBECD9416D19B5EBD75BF53", hash_generated_method = "C28B3FED21CA36E75D961E638298935A")
        public String toString() {
            String varB4EAC82CA7396A68D541C85D26508E83_1557531477 = null; //Variable for return #1
            int r;
            r = sync.getReadLockCount();
            varB4EAC82CA7396A68D541C85D26508E83_1557531477 = super.toString() +
                "[Read locks = " + r + "]";
            varB4EAC82CA7396A68D541C85D26508E83_1557531477.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1557531477;
            // ---------- Original Method ----------
            //int r = sync.getReadLockCount();
            //return super.toString() +
                //"[Read locks = " + r + "]";
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:58.598 -0400", hash_original_field = "379AEE3B0AE7E3AB2A711C689B7C790D", hash_generated_field = "B9F9E7F801E368A82CB3CAA5D917DE84")

        private static long serialVersionUID = -5992448646407690164L;
    }


    
    public static class WriteLock implements Lock, java.io.Serializable {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:58.598 -0400", hash_original_field = "63AD9D34F3503826E5F649AE6B7AC92C", hash_generated_field = "A4B34EF3CE38520839B34A2F06599243")

        private Sync sync;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:58.599 -0400", hash_original_method = "2F59DA9CAF578BD2524C05A37F86DF01", hash_generated_method = "A7C2CC6406BCF200D20C7B5AD2A21C1A")
        protected  WriteLock(ReentrantReadWriteLock lock) {
            sync = lock.sync;
            // ---------- Original Method ----------
            //sync = lock.sync;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:58.599 -0400", hash_original_method = "4197ECA2CFEBBAA5B9BD7C840B7670C7", hash_generated_method = "DDE8BF3B445A2924BC3E70FCADFAA419")
        public void lock() {
            sync.acquire(1);
            // ---------- Original Method ----------
            //sync.acquire(1);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:58.600 -0400", hash_original_method = "5966BE77DAE264B5F21646B0E7A08FC1", hash_generated_method = "CFF689BB53A067D7B9EB5F12CA3F00CC")
        public void lockInterruptibly() throws InterruptedException {
            sync.acquireInterruptibly(1);
            // ---------- Original Method ----------
            //sync.acquireInterruptibly(1);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:58.600 -0400", hash_original_method = "55CC434A7054CDED1693C2BA6E1C81AA", hash_generated_method = "CCFFC8C65107DB9841DF6CFF50528FB8")
        public boolean tryLock( ) {
            boolean var55CFE4E4F15027819D6679D2F0F9E5EB_392965640 = (sync.tryWriteLock());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1041388853 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1041388853;
            // ---------- Original Method ----------
            //return sync.tryWriteLock();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:58.600 -0400", hash_original_method = "6EF7D2E282F143C52CC20B0DBAA61A21", hash_generated_method = "F5E05B4A8CD670B6AA611109357B5CBC")
        public boolean tryLock(long timeout, TimeUnit unit) throws InterruptedException {
            boolean var4E766E765BA3F93DDE7082A08A077E42_475091267 = (sync.tryAcquireNanos(1, unit.toNanos(timeout)));
            addTaint(timeout);
            addTaint(unit.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1633610807 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1633610807;
            // ---------- Original Method ----------
            //return sync.tryAcquireNanos(1, unit.toNanos(timeout));
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:58.600 -0400", hash_original_method = "7AD42B9E2BC6DD4A4DE0EB9EBA3A2515", hash_generated_method = "87142E80D82254348B0CA43367BBC9B7")
        public void unlock() {
            sync.release(1);
            // ---------- Original Method ----------
            //sync.release(1);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:58.610 -0400", hash_original_method = "6BB095C6835043568D960ACB9C15058D", hash_generated_method = "A9E8EF85F5FB25ED6EA173B8833FC524")
        public Condition newCondition() {
            Condition varB4EAC82CA7396A68D541C85D26508E83_2032924394 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_2032924394 = sync.newCondition();
            varB4EAC82CA7396A68D541C85D26508E83_2032924394.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_2032924394;
            // ---------- Original Method ----------
            //return sync.newCondition();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:58.611 -0400", hash_original_method = "E0C199518E39715763AFB28F76F97305", hash_generated_method = "9EAE5C3F320116935FA8351E81E22D24")
        public String toString() {
            String varB4EAC82CA7396A68D541C85D26508E83_1940110371 = null; //Variable for return #1
            Thread o;
            o = sync.getOwner();
            varB4EAC82CA7396A68D541C85D26508E83_1940110371 = super.toString() + ((o == null) ?
                                       "[Unlocked]" :
                                       "[Locked by thread " + o.getName() + "]");
            varB4EAC82CA7396A68D541C85D26508E83_1940110371.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1940110371;
            // ---------- Original Method ----------
            //Thread o = sync.getOwner();
            //return super.toString() + ((o == null) ?
                                       //"[Unlocked]" :
                                       //"[Locked by thread " + o.getName() + "]");
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:58.612 -0400", hash_original_method = "53A74F7432D74C33316852C3E739832B", hash_generated_method = "602793BE459E4D017B715CB5CD105DFF")
        public boolean isHeldByCurrentThread() {
            boolean var8A9E5BF2F58F6E9DAF336A434F65DD91_1166856924 = (sync.isHeldExclusively());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_134984072 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_134984072;
            // ---------- Original Method ----------
            //return sync.isHeldExclusively();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:58.612 -0400", hash_original_method = "17A37C9E70A2D6C131240856FD5B2099", hash_generated_method = "6DF274863339FCF9C40A182EE9E0F0F6")
        public int getHoldCount() {
            int varE800E928AAA5AF8116F9B878EB5C4BA2_217404334 = (sync.getWriteHoldCount());
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1261588057 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1261588057;
            // ---------- Original Method ----------
            //return sync.getWriteHoldCount();
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:58.612 -0400", hash_original_field = "39DE0FFFDCAA0428C698758AE0E7E3D8", hash_generated_field = "0E2208352AC5D0B3EE824CFE90B03CD9")

        private static long serialVersionUID = -4992448646407690164L;
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:58.612 -0400", hash_original_field = "ACC5AACF11B6B32C6C9167A3DD56327E", hash_generated_field = "3BBB9D219F619865FD2910C8343417B9")

    private static long serialVersionUID = -6992448646407690164L;
}

