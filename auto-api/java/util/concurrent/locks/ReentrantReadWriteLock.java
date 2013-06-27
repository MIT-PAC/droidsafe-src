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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:58.311 -0400", hash_original_field = "53A68C354CA707EE3CF4135EF2B687CE", hash_generated_field = "8F79220737B731E52680B143D15FE029")

    private ReentrantReadWriteLock.ReadLock readerLock;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:58.311 -0400", hash_original_field = "D7F1DF52BEB3372136F52E8F5BBC02A3", hash_generated_field = "1E1067A0A17FE39A5B241BAB85413180")

    private ReentrantReadWriteLock.WriteLock writerLock;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:58.311 -0400", hash_original_field = "63AD9D34F3503826E5F649AE6B7AC92C", hash_generated_field = "791C2888A6F5CDC158445182FD1E3538")

    Sync sync;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:58.311 -0400", hash_original_method = "1C7ADE1C43258ED1B8231199DCC94C2F", hash_generated_method = "A2362B6FC27126ECCCC3F80E71268B1E")
    public  ReentrantReadWriteLock() {
        this(false);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:58.323 -0400", hash_original_method = "A6CD875E912D33CADF6A81571C0A078B", hash_generated_method = "40472467CFFF2D78F76EB33BF5AABCCB")
    public  ReentrantReadWriteLock(boolean fair) {
        sync = fair ? new FairSync() : new NonfairSync();
        readerLock = new ReadLock(this);
        writerLock = new WriteLock(this);
        // ---------- Original Method ----------
        //sync = fair ? new FairSync() : new NonfairSync();
        //readerLock = new ReadLock(this);
        //writerLock = new WriteLock(this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:58.325 -0400", hash_original_method = "0C7BC9C54BE00E03201ACF18B2913309", hash_generated_method = "00ED3A928E44B29F95DED88F6B86C22F")
    public ReentrantReadWriteLock.WriteLock writeLock() {
        ReentrantReadWriteLock.WriteLock varB4EAC82CA7396A68D541C85D26508E83_1369632200 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1369632200 = writerLock;
        varB4EAC82CA7396A68D541C85D26508E83_1369632200.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1369632200;
        // ---------- Original Method ----------
        //return writerLock;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:58.332 -0400", hash_original_method = "22D8B34ECDA1804C5F879E9731CF210D", hash_generated_method = "CEC8A76C83EB669EB4FD4E7427AF2F2C")
    public ReentrantReadWriteLock.ReadLock readLock() {
        ReentrantReadWriteLock.ReadLock varB4EAC82CA7396A68D541C85D26508E83_854359445 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_854359445 = readerLock;
        varB4EAC82CA7396A68D541C85D26508E83_854359445.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_854359445;
        // ---------- Original Method ----------
        //return readerLock;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:58.332 -0400", hash_original_method = "6835E283E5F9E7FBD3FF7844476992AD", hash_generated_method = "FFC868DFEA44D0346D36AAEE3BC584B9")
    public final boolean isFair() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1443644491 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1443644491;
        // ---------- Original Method ----------
        //return sync instanceof FairSync;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:58.333 -0400", hash_original_method = "DB009A0944F572B5167ED6D51E109787", hash_generated_method = "EFA8307D04726AB860D573A2FB3C1EB6")
    protected Thread getOwner() {
        Thread varB4EAC82CA7396A68D541C85D26508E83_838076051 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_838076051 = sync.getOwner();
        varB4EAC82CA7396A68D541C85D26508E83_838076051.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_838076051;
        // ---------- Original Method ----------
        //return sync.getOwner();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:58.333 -0400", hash_original_method = "BDA3BC7F9F6754233D710BB1E8BDA625", hash_generated_method = "9E00670B9EF20EC2FD761678982C14A5")
    public int getReadLockCount() {
        int var5CF7DD4739FB0661883910CE3127C2D4_848057322 = (sync.getReadLockCount());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1445874010 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1445874010;
        // ---------- Original Method ----------
        //return sync.getReadLockCount();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:58.334 -0400", hash_original_method = "D1234101A768FDEE737EDDFEC7DD19A3", hash_generated_method = "53259689CB1441EFF09707F8A516BE00")
    public boolean isWriteLocked() {
        boolean varC09930903B4B15334864667BA6922CA7_968284713 = (sync.isWriteLocked());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_27885151 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_27885151;
        // ---------- Original Method ----------
        //return sync.isWriteLocked();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:58.334 -0400", hash_original_method = "B77A8CC69384EA638697FDA5B4AC3CDF", hash_generated_method = "2944606CE3CC0CF292B11367D7061C19")
    public boolean isWriteLockedByCurrentThread() {
        boolean var12281D4A72DEB9F8816A0A46604F1374_1941419382 = (sync.isHeldExclusively());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1230306321 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1230306321;
        // ---------- Original Method ----------
        //return sync.isHeldExclusively();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:58.334 -0400", hash_original_method = "F72E2C7B278B975FDBAAB080F7322122", hash_generated_method = "796CFDE736BC25734EBA718B1A336F19")
    public int getWriteHoldCount() {
        int var4B7ADBEF86627032166821903A70F5D0_135472233 = (sync.getWriteHoldCount());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2115362798 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2115362798;
        // ---------- Original Method ----------
        //return sync.getWriteHoldCount();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:58.334 -0400", hash_original_method = "026686F812EC7870B6E447136A7E8B3A", hash_generated_method = "DD5CB0A1E1960F5CE5CB5AFDF37F9F0A")
    public int getReadHoldCount() {
        int var4CA9F99F5577509EFAE445B14D1ED825_405334050 = (sync.getReadHoldCount());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1772250134 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1772250134;
        // ---------- Original Method ----------
        //return sync.getReadHoldCount();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:58.346 -0400", hash_original_method = "2F9252966607830729245C7251D0E4B8", hash_generated_method = "055E024B0BD25407A11562541A2E91C2")
    protected Collection<Thread> getQueuedWriterThreads() {
        Collection<Thread> varB4EAC82CA7396A68D541C85D26508E83_1544293606 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1544293606 = sync.getExclusiveQueuedThreads();
        varB4EAC82CA7396A68D541C85D26508E83_1544293606.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1544293606;
        // ---------- Original Method ----------
        //return sync.getExclusiveQueuedThreads();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:58.347 -0400", hash_original_method = "956CE594FDB46F8FEF252F1FDB068D3D", hash_generated_method = "1FF0E579BBB7871274802803E8FE4FD2")
    protected Collection<Thread> getQueuedReaderThreads() {
        Collection<Thread> varB4EAC82CA7396A68D541C85D26508E83_1049870128 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1049870128 = sync.getSharedQueuedThreads();
        varB4EAC82CA7396A68D541C85D26508E83_1049870128.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1049870128;
        // ---------- Original Method ----------
        //return sync.getSharedQueuedThreads();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:58.347 -0400", hash_original_method = "33B7DCC82A105082FC4D268ED56F9DE5", hash_generated_method = "D1378528425EA7B567E6DABC4EE91C1A")
    public final boolean hasQueuedThreads() {
        boolean var4C0A0AB508905DA8D619627A5EEFD574_471075112 = (sync.hasQueuedThreads());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2079661892 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2079661892;
        // ---------- Original Method ----------
        //return sync.hasQueuedThreads();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:58.361 -0400", hash_original_method = "7B179E46CDF5B520CCEEF15512EC2C63", hash_generated_method = "437D684472A4EF04E10A63DA904C4866")
    public final boolean hasQueuedThread(Thread thread) {
        boolean var0681201A478D613CAAB4B4D5196C3EF3_625007104 = (sync.isQueued(thread));
        addTaint(thread.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_827223674 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_827223674;
        // ---------- Original Method ----------
        //return sync.isQueued(thread);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:58.361 -0400", hash_original_method = "DFFF2C05339152644F00EC2FFC57EFB9", hash_generated_method = "69EBF5417FC9674DC48A555FD9FA4F79")
    public final int getQueueLength() {
        int var2545CC142A0CD1008911850681315651_907296699 = (sync.getQueueLength());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1358382085 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1358382085;
        // ---------- Original Method ----------
        //return sync.getQueueLength();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:58.362 -0400", hash_original_method = "4BC73C35668DA24636BE58FB68209032", hash_generated_method = "5390F0B0C046B1B8702A6C8E04896011")
    protected Collection<Thread> getQueuedThreads() {
        Collection<Thread> varB4EAC82CA7396A68D541C85D26508E83_1555648037 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1555648037 = sync.getQueuedThreads();
        varB4EAC82CA7396A68D541C85D26508E83_1555648037.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1555648037;
        // ---------- Original Method ----------
        //return sync.getQueuedThreads();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:58.363 -0400", hash_original_method = "BF91F0F13FB6E88A38744502E21F1F2D", hash_generated_method = "01C202CD7A3E6F28A83EA19E5C677593")
    public boolean hasWaiters(Condition condition) {
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("not owner");
        boolean varD78146513D32810B85075F5879934833_744032704 = (sync.hasWaiters((AbstractQueuedSynchronizer.ConditionObject)condition));
        addTaint(condition.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_542249376 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_542249376;
        // ---------- Original Method ----------
        //if (condition == null)
            //throw new NullPointerException();
        //if (!(condition instanceof AbstractQueuedSynchronizer.ConditionObject))
            //throw new IllegalArgumentException("not owner");
        //return sync.hasWaiters((AbstractQueuedSynchronizer.ConditionObject)condition);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:58.363 -0400", hash_original_method = "D4277B3B6ED39F705D915D3806A5548A", hash_generated_method = "26E078CBF9789FCE6D2BF6D5C1A7FDA4")
    public int getWaitQueueLength(Condition condition) {
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("not owner");
        int var60A2F707F5BC43BB059D2028F4E4733B_862701913 = (sync.getWaitQueueLength((AbstractQueuedSynchronizer.ConditionObject)condition));
        addTaint(condition.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1457717818 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1457717818;
        // ---------- Original Method ----------
        //if (condition == null)
            //throw new NullPointerException();
        //if (!(condition instanceof AbstractQueuedSynchronizer.ConditionObject))
            //throw new IllegalArgumentException("not owner");
        //return sync.getWaitQueueLength((AbstractQueuedSynchronizer.ConditionObject)condition);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:58.364 -0400", hash_original_method = "29738EA386BFBB41E36C961DB4B1CBE5", hash_generated_method = "2EAFFEB0B2EA2D5551FB3C602B82A287")
    protected Collection<Thread> getWaitingThreads(Condition condition) {
        Collection<Thread> varB4EAC82CA7396A68D541C85D26508E83_802465809 = null; //Variable for return #1
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("not owner");
        varB4EAC82CA7396A68D541C85D26508E83_802465809 = sync.getWaitingThreads((AbstractQueuedSynchronizer.ConditionObject)condition);
        addTaint(condition.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_802465809.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_802465809;
        // ---------- Original Method ----------
        //if (condition == null)
            //throw new NullPointerException();
        //if (!(condition instanceof AbstractQueuedSynchronizer.ConditionObject))
            //throw new IllegalArgumentException("not owner");
        //return sync.getWaitingThreads((AbstractQueuedSynchronizer.ConditionObject)condition);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:58.480 -0400", hash_original_method = "03D5EBF343C873E095999F30626DADA2", hash_generated_method = "FEB63B82451FEF1C82D1B0E959DE4488")
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_596470573 = null; //Variable for return #1
        int c;
        c = sync.getCount();
        int w;
        w = Sync.exclusiveCount(c);
        int r;
        r = Sync.sharedCount(c);
        varB4EAC82CA7396A68D541C85D26508E83_596470573 = super.toString() +
            "[Write locks = " + w + ", Read locks = " + r + "]";
        varB4EAC82CA7396A68D541C85D26508E83_596470573.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_596470573;
        // ---------- Original Method ----------
        //int c = sync.getCount();
        //int w = Sync.exclusiveCount(c);
        //int r = Sync.sharedCount(c);
        //return super.toString() +
            //"[Write locks = " + w + ", Read locks = " + r + "]";
    }

    
    abstract static class Sync extends AbstractQueuedSynchronizer {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:58.488 -0400", hash_original_field = "E08C8E97570C1DCB9CD554FD7079B697", hash_generated_field = "8C4B3BD798FE5D7E8EB3D0536576D262")

        private transient ThreadLocalHoldCounter readHolds;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:58.488 -0400", hash_original_field = "DF91768C2D431EA735A71A6CE08F4181", hash_generated_field = "2EE67430D3D959E367F77E7EF6425C16")

        private transient HoldCounter cachedHoldCounter;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:58.488 -0400", hash_original_field = "AAA28B60505EF94BD4CA2E8CC3EC3C64", hash_generated_field = "A011FC8C4363F320801F082EF2C621C1")

        private transient Thread firstReader = null;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:58.488 -0400", hash_original_field = "64FF72C6AF21D3CE02435570D431F32C", hash_generated_field = "D6E4ACE63DE2E9B4DD29D78376D1F793")

        private transient int firstReaderHoldCount;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:58.491 -0400", hash_original_method = "89DA4D8EA92261B26BAB9F4AB5CDD482", hash_generated_method = "F96B116FAEB3CF7E52F47724A0D1064E")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:58.502 -0400", hash_original_method = "E2589B88E3FBFBAA4E5917277DEFE99E", hash_generated_method = "E80AE9B3163DB48802D96DE02FC961C2")
        protected final boolean tryRelease(int releases) {
            {
                boolean varBDF0ABD2F20F8D3DCB5C83DB8D0ED9B5_466800463 = (!isHeldExclusively());
                if (DroidSafeAndroidRuntime.control) throw new IllegalMonitorStateException();
            } //End collapsed parenthetic
            int nextc;
            nextc = getState() - releases;
            boolean free;
            free = exclusiveCount(nextc) == 0;
            setExclusiveOwnerThread(null);
            setState(nextc);
            addTaint(releases);
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_585367329 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_585367329;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:58.512 -0400", hash_original_method = "887DB434CE6AB550C72A17E01EAED908", hash_generated_method = "333713AFFEF30AF626867DC2661E679C")
        protected final boolean tryAcquire(int acquires) {
            Thread current;
            current = Thread.currentThread();
            int c;
            c = getState();
            int w;
            w = exclusiveCount(c);
            {
                {
                    boolean var90979142887A20EB72C8964C86EB9321_1405907179 = (w == 0 || current != getExclusiveOwnerThread());
                } //End collapsed parenthetic
                {
                    boolean var318575A0FEE61BCA2C1999503B3E7456_1132118091 = (w + exclusiveCount(acquires) > MAX_COUNT);
                    if (DroidSafeAndroidRuntime.control) throw new Error("Maximum lock count exceeded");
                } //End collapsed parenthetic
                setState(c + acquires);
            } //End block
            {
                boolean var33B66AF91B134BC4CCDF9A857D584490_680126299 = (writerShouldBlock() ||
                !compareAndSetState(c, c + acquires));
            } //End collapsed parenthetic
            setExclusiveOwnerThread(current);
            addTaint(acquires);
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_603278498 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_603278498;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:58.525 -0400", hash_original_method = "DCB6BD37D30DD1C1033C1677B2F2BA39", hash_generated_method = "A2D9750313D74B266C1B6DD7C4726CA1")
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
                    boolean var742A69B23BBDDB423EC138DCBB7B9545_156385688 = (rh == null || rh.tid != current.getId());
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
                    boolean var525F59EF5A984E7DE1A679CCEEFC8101_1820889497 = (compareAndSetState(c, nextc));
                } //End collapsed parenthetic
            } //End block
            addTaint(unused);
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_400191880 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_400191880;
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:58.526 -0400", hash_original_method = "4AE7D8D2A940AB168E8F2908DE9ACCF1", hash_generated_method = "12F39A41CFFC57A0ED8263F8CCC9C1E7")
        private IllegalMonitorStateException unmatchedUnlockException() {
            IllegalMonitorStateException varB4EAC82CA7396A68D541C85D26508E83_240314060 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_240314060 = new IllegalMonitorStateException(
                "attempt to unlock read lock, not locked by current thread");
            varB4EAC82CA7396A68D541C85D26508E83_240314060.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_240314060;
            // ---------- Original Method ----------
            //return new IllegalMonitorStateException(
                //"attempt to unlock read lock, not locked by current thread");
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:58.528 -0400", hash_original_method = "AD4C82A786111FF828AFE5FE5C8E5A39", hash_generated_method = "9A02A0067458B5C50FFE6DBA0B4285CB")
        protected final int tryAcquireShared(int unused) {
            Thread current;
            current = Thread.currentThread();
            int c;
            c = getState();
            {
                boolean varCBCE136FFBA6AA5474A803A63D00FAD1_757545684 = (exclusiveCount(c) != 0 &&
                getExclusiveOwnerThread() != current);
            } //End collapsed parenthetic
            int r;
            r = sharedCount(c);
            {
                boolean varC705F9493B1FAEA076FDA3794FAA0183_1025180726 = (!readerShouldBlock() &&
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
                            boolean varDB55354BA83BD531EC70083B969F9FA7_401334487 = (rh == null || rh.tid != current.getId());
                            cachedHoldCounter = rh = readHolds.get();
                            readHolds.set(rh);
                        } //End collapsed parenthetic
                    } //End block
                } //End block
            } //End collapsed parenthetic
            int var203CD572536C941A4B1A477F089EE192_1296717685 = (fullTryAcquireShared(current));
            addTaint(unused);
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_207218529 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_207218529;
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:58.552 -0400", hash_original_method = "EBE8D8355B366068B4B1E29E3A9EED12", hash_generated_method = "C5AE1CCBBF036E971F98BA02B8D5F737")
        final int fullTryAcquireShared(Thread current) {
            HoldCounter rh;
            rh = null;
            {
                int c;
                c = getState();
                {
                    boolean var529468DC4620BDF65F6B6C7D22F44273_901397303 = (exclusiveCount(c) != 0);
                    {
                        {
                            boolean varD3F580BFEF90DED8D0695E9E6E71809D_346546711 = (getExclusiveOwnerThread() != current);
                        } //End collapsed parenthetic
                    } //End block
                    {
                        boolean var860368E133590F744493740787A52E27_2128819888 = (readerShouldBlock());
                        {
                            {
                                {
                                    rh = cachedHoldCounter;
                                    {
                                        boolean var84643B1DF9273A723910E3CDDBCE3609_1332836485 = (rh == null || rh.tid != current.getId());
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
                    boolean var81C9C11D2632075F5A3FC662D0DAC8FC_1781168837 = (sharedCount(c) == MAX_COUNT);
                    if (DroidSafeAndroidRuntime.control) throw new Error("Maximum lock count exceeded");
                } //End collapsed parenthetic
                {
                    boolean varED20116B0BB1734240062BCE3EF53974_1181122813 = (compareAndSetState(c, c + SHARED_UNIT));
                    {
                        {
                            boolean varD8F1AA39FE8E689164014F966ADE2AC4_646610436 = (sharedCount(c) == 0);
                            {
                                firstReader = current;
                                firstReaderHoldCount = 1;
                            } //End block
                            {
                                rh = cachedHoldCounter;
                                {
                                    boolean var50B8EA88D62C62CC9B48E69494903B06_1799219498 = (rh == null || rh.tid != current.getId());
                                    rh = readHolds.get();
                                    readHolds.set(rh);
                                } //End collapsed parenthetic
                                cachedHoldCounter = rh;
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                } //End collapsed parenthetic
            } //End block
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_576611383 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_576611383;
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:58.569 -0400", hash_original_method = "0DD6CA3D230AA260224A4A3AE8239ACB", hash_generated_method = "48458EC23B570AAFB847E57513911BD8")
        final boolean tryWriteLock() {
            Thread current;
            current = Thread.currentThread();
            int c;
            c = getState();
            {
                int w;
                w = exclusiveCount(c);
                {
                    boolean var90979142887A20EB72C8964C86EB9321_1114929740 = (w == 0 || current != getExclusiveOwnerThread());
                } //End collapsed parenthetic
                if (DroidSafeAndroidRuntime.control) throw new Error("Maximum lock count exceeded");
            } //End block
            {
                boolean var42EFECE5F4E2BBE5A5608C37A8B687F3_258334227 = (!compareAndSetState(c, c + 1));
            } //End collapsed parenthetic
            setExclusiveOwnerThread(current);
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_678473268 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_678473268;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:58.572 -0400", hash_original_method = "F864315749E9B3DD069E258F497DFE4D", hash_generated_method = "D4010B2D68D8B250F44C9418C7495DAD")
        final boolean tryReadLock() {
            Thread current;
            current = Thread.currentThread();
            {
                int c;
                c = getState();
                {
                    boolean varEA7F18DF3FD18041706E4732508BA651_1017041482 = (exclusiveCount(c) != 0 &&
                    getExclusiveOwnerThread() != current);
                } //End collapsed parenthetic
                int r;
                r = sharedCount(c);
                if (DroidSafeAndroidRuntime.control) throw new Error("Maximum lock count exceeded");
                {
                    boolean varED20116B0BB1734240062BCE3EF53974_1089660684 = (compareAndSetState(c, c + SHARED_UNIT));
                    {
                        {
                            firstReader = current;
                            firstReaderHoldCount = 1;
                        } //End block
                        {
                            HoldCounter rh;
                            rh = cachedHoldCounter;
                            {
                                boolean varD70438DD2BB853F7AACBE7CBC6449999_979209913 = (rh == null || rh.tid != current.getId());
                                cachedHoldCounter = rh = readHolds.get();
                                readHolds.set(rh);
                            } //End collapsed parenthetic
                        } //End block
                    } //End block
                } //End collapsed parenthetic
            } //End block
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_425529930 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_425529930;
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:58.591 -0400", hash_original_method = "A843CC28FFAE9A089B89A0058BA2B9D5", hash_generated_method = "31FE984CD5EFE74E43014613ADB76AC8")
        protected final boolean isHeldExclusively() {
            boolean var3CE6B8DE56D5A33803435E843AACF76A_1869524722 = (getExclusiveOwnerThread() == Thread.currentThread());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_265473887 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_265473887;
            // ---------- Original Method ----------
            //return getExclusiveOwnerThread() == Thread.currentThread();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:58.591 -0400", hash_original_method = "093F0D0E6A279CA43864791B6FD65040", hash_generated_method = "024E998D601AAF6F78B3E2028B332077")
        final ConditionObject newCondition() {
            ConditionObject varB4EAC82CA7396A68D541C85D26508E83_935157664 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_935157664 = new ConditionObject();
            varB4EAC82CA7396A68D541C85D26508E83_935157664.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_935157664;
            // ---------- Original Method ----------
            //return new ConditionObject();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:58.591 -0400", hash_original_method = "3F3DE8BCF9BFC159EB93FF2ABA8024D7", hash_generated_method = "D8139D19AE87A01600BCC15326E5719B")
        final Thread getOwner() {
            Thread varB4EAC82CA7396A68D541C85D26508E83_1653001650 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1653001650 = ((exclusiveCount(getState()) == 0) ?
                    null :
                    getExclusiveOwnerThread());
            varB4EAC82CA7396A68D541C85D26508E83_1653001650.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1653001650;
            // ---------- Original Method ----------
            //return ((exclusiveCount(getState()) == 0) ?
                    //null :
                    //getExclusiveOwnerThread());
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:58.592 -0400", hash_original_method = "0B84E22FFE55E13BE40413778559BE34", hash_generated_method = "31A674E4F970F57D71A3C30A99180C35")
        final int getReadLockCount() {
            int var5073DFD1A27AB6C474CC24F8B7EC3CD3_165792749 = (sharedCount(getState()));
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_354162866 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_354162866;
            // ---------- Original Method ----------
            //return sharedCount(getState());
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:58.592 -0400", hash_original_method = "09CA8B61F6450707C75BFC712569D4D4", hash_generated_method = "E698A0D2469743544E5CC6EF891AF806")
        final boolean isWriteLocked() {
            boolean var01CAC84C2F38392161F4E16039D7DE44_1347339254 = (exclusiveCount(getState()) != 0);
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_515924527 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_515924527;
            // ---------- Original Method ----------
            //return exclusiveCount(getState()) != 0;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:58.593 -0400", hash_original_method = "67C0C583D90F5F49CAE0DBAE2DE27D59", hash_generated_method = "42BFDC123B2484C93D13CEAE7C726801")
        final int getWriteHoldCount() {
            {
                boolean var34E827331B4BC7F16DFC99E8B4EE154E_2067308851 = (isHeldExclusively());
                Object var0847481376D95B453E4DA8F62DB7ADA1_1645650720 = (exclusiveCount(getState()));
            } //End flattened ternary
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1293543715 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1293543715;
            // ---------- Original Method ----------
            //return isHeldExclusively() ? exclusiveCount(getState()) : 0;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:58.597 -0400", hash_original_method = "1DA1A38561287A101F5C2B623B00252F", hash_generated_method = "E2935814F3CE4B985DDC1BD5D4AFD19C")
        final int getReadHoldCount() {
            {
                boolean varCF77250596B8C839BEFAC301F344C853_1660476658 = (getReadLockCount() == 0);
            } //End collapsed parenthetic
            Thread current;
            current = Thread.currentThread();
            HoldCounter rh;
            rh = cachedHoldCounter;
            {
                boolean var12BC8C81E89FF6364E7C14D490B5B984_1776413035 = (rh != null && rh.tid == current.getId());
            } //End collapsed parenthetic
            int count;
            count = readHolds.get().count;
            readHolds.remove();
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1517689160 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1517689160;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:58.598 -0400", hash_original_method = "4E48396D4489DBF7E8DA7E593070FC82", hash_generated_method = "32B8CD4904A66075F3560379D9DD0971")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:58.598 -0400", hash_original_method = "192D38E698A214D58DA93C3298AD6AD3", hash_generated_method = "5575E65ABB8AE290912E63F5F34E7E34")
        final int getCount() {
            int var376B5C2087169E76FB6628D31DCC9663_885483449 = (getState());
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_681361336 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_681361336;
            // ---------- Original Method ----------
            //return getState();
        }

        
        static final class HoldCounter {
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:58.598 -0400", hash_original_field = "B1F8A23315AB697B67E425C4B5F81545", hash_generated_field = "B524E41AA0CF6AD39267F32C8C687778")

            int count = 0;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:58.598 -0400", hash_original_field = "A7CAC231571D7123EBB48A8647C318F9", hash_generated_field = "0A37A20E7316460B86A4063014209DB0")

            long tid = Thread.currentThread().getId();
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:58.598 -0400", hash_original_method = "F1D8E352EDEF0AB237A69949FE7423C4", hash_generated_method = "F1D8E352EDEF0AB237A69949FE7423C4")
            public HoldCounter ()
            {
                //Synthesized constructor
            }


        }


        
        static final class ThreadLocalHoldCounter extends ThreadLocal<HoldCounter> {
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:58.598 -0400", hash_original_method = "2811BFD99460ECBD8E7948B925FFB736", hash_generated_method = "2811BFD99460ECBD8E7948B925FFB736")
            public ThreadLocalHoldCounter ()
            {
                //Synthesized constructor
            }


            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:58.599 -0400", hash_original_method = "65FB587992A751B61B2E99AB391905DE", hash_generated_method = "C1F19F35F074E531104B6A6DB029EC54")
            public HoldCounter initialValue() {
                HoldCounter varB4EAC82CA7396A68D541C85D26508E83_1916042162 = null; //Variable for return #1
                varB4EAC82CA7396A68D541C85D26508E83_1916042162 = new HoldCounter();
                varB4EAC82CA7396A68D541C85D26508E83_1916042162.addTaint(getTaint()); //Add taint from parent
                return varB4EAC82CA7396A68D541C85D26508E83_1916042162;
                // ---------- Original Method ----------
                //return new HoldCounter();
            }

            
        }


        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:58.617 -0400", hash_original_field = "F661B57F5D85B8C55CBF8EC6C1332293", hash_generated_field = "BA0B420BE81E5BF79693521ABA242882")

        private static long serialVersionUID = 6317671515068378041L;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:58.618 -0400", hash_original_field = "84B1E483133CB506AF0F344691E6DF0D", hash_generated_field = "5ECB677A41E894B5658B3C4F2E6597E3")

        static int SHARED_SHIFT = 16;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:58.618 -0400", hash_original_field = "24C85CCC5E848FE7AAEF439B797AF477", hash_generated_field = "D9384BE805847F2AF0B98C6F9D323117")

        static int SHARED_UNIT = (1 << SHARED_SHIFT);
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:58.618 -0400", hash_original_field = "2A4F653E74D03DB9FBF055439C642017", hash_generated_field = "9D31CD643AFBFC9F034DE14EC99B4A83")

        static int MAX_COUNT = (1 << SHARED_SHIFT) - 1;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:58.618 -0400", hash_original_field = "36C9424C451B233CA56EB28EF0E91CDB", hash_generated_field = "C5A8821D5AE1C22DAC9D77672450F877")

        static int EXCLUSIVE_MASK = (1 << SHARED_SHIFT) - 1;
    }


    
    static final class NonfairSync extends Sync {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:58.618 -0400", hash_original_method = "92700F1FF079627760B83F1F338B8E6E", hash_generated_method = "92700F1FF079627760B83F1F338B8E6E")
        public NonfairSync ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:58.618 -0400", hash_original_method = "6099B514073B77A554543D2A2B955577", hash_generated_method = "891C09E01CB51665EB384F9EECC1D6B9")
        final boolean writerShouldBlock() {
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1541474514 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1541474514;
            // ---------- Original Method ----------
            //return false;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:58.619 -0400", hash_original_method = "311D59812186188137CBEED2258453A3", hash_generated_method = "4965AFF12263515F087FEE5E2F5E2180")
        final boolean readerShouldBlock() {
            boolean var42C6C6A77390D0F65AEC7AEAAD6B4F91_1724826280 = (apparentlyFirstQueuedIsExclusive());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1314870986 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1314870986;
            // ---------- Original Method ----------
            //return apparentlyFirstQueuedIsExclusive();
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:58.619 -0400", hash_original_field = "962FC793F1AA6943131BF3E9C77AA5E7", hash_generated_field = "7DE0AF38F9670C2D3271D8E7778ED398")

        private static long serialVersionUID = -8159625535654395037L;
    }


    
    static final class FairSync extends Sync {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:58.619 -0400", hash_original_method = "76BFFA90730B34917875BAE48AE8B396", hash_generated_method = "76BFFA90730B34917875BAE48AE8B396")
        public FairSync ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:58.619 -0400", hash_original_method = "F04DB8A71B8ACD86834CABDF23C7982B", hash_generated_method = "DFAAB7FAF645D935BD90BAC0BAD0FA77")
        final boolean writerShouldBlock() {
            boolean var5D9F3BF4621CB4A60B96236F06AF2405_1865587415 = (hasQueuedPredecessors());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1833379918 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1833379918;
            // ---------- Original Method ----------
            //return hasQueuedPredecessors();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:58.619 -0400", hash_original_method = "5E806298851931D3FCAB2DE2F5A11624", hash_generated_method = "B18364F09B8081673B3D557A6BEDE248")
        final boolean readerShouldBlock() {
            boolean var5D9F3BF4621CB4A60B96236F06AF2405_1367589352 = (hasQueuedPredecessors());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1948670022 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1948670022;
            // ---------- Original Method ----------
            //return hasQueuedPredecessors();
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:58.619 -0400", hash_original_field = "789C476CB4886D7F76862344BE9A6172", hash_generated_field = "93CD0C200CCC5616652EC597B40432C5")

        private static long serialVersionUID = -2274990926593161451L;
    }


    
    public static class ReadLock implements Lock, java.io.Serializable {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:58.619 -0400", hash_original_field = "63AD9D34F3503826E5F649AE6B7AC92C", hash_generated_field = "A4B34EF3CE38520839B34A2F06599243")

        private Sync sync;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:58.620 -0400", hash_original_method = "86296C44CAAC51998FCC18AC6C334852", hash_generated_method = "90987B1257AE5908AD98C331E68E3B50")
        protected  ReadLock(ReentrantReadWriteLock lock) {
            sync = lock.sync;
            // ---------- Original Method ----------
            //sync = lock.sync;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:58.620 -0400", hash_original_method = "8D72D73F25D8DE6C9209D04669F96039", hash_generated_method = "F147980700CF869A8D6F7133099FA372")
        public void lock() {
            sync.acquireShared(1);
            // ---------- Original Method ----------
            //sync.acquireShared(1);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:58.621 -0400", hash_original_method = "61D542FCA692219B5199CDDD1A71CCC6", hash_generated_method = "87CEA29C19FE66B6CBD3C0925E99729C")
        public void lockInterruptibly() throws InterruptedException {
            sync.acquireSharedInterruptibly(1);
            // ---------- Original Method ----------
            //sync.acquireSharedInterruptibly(1);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:58.621 -0400", hash_original_method = "6F9DD593410D3A6A5FB658A804C67B03", hash_generated_method = "8AF6D224566C6A66479E32650A0C50C7")
        public boolean tryLock() {
            boolean var82642F761C8CC4EFB1E9891565A562E0_1045404216 = (sync.tryReadLock());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_415959019 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_415959019;
            // ---------- Original Method ----------
            //return sync.tryReadLock();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:58.622 -0400", hash_original_method = "CABC63B31BFC6EB1808F17E4FED50740", hash_generated_method = "54D0A8AA3D7C7B253384D97B2138AA71")
        public boolean tryLock(long timeout, TimeUnit unit) throws InterruptedException {
            boolean varC650725F0ACDDC932C370EDA1774172F_652483278 = (sync.tryAcquireSharedNanos(1, unit.toNanos(timeout)));
            addTaint(timeout);
            addTaint(unit.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2122508484 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_2122508484;
            // ---------- Original Method ----------
            //return sync.tryAcquireSharedNanos(1, unit.toNanos(timeout));
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:58.637 -0400", hash_original_method = "2E2DA507FE1EE35FD0E649F791C4FA62", hash_generated_method = "CE7F47B976DC7C53582533934AC31AFE")
        public void unlock() {
            sync.releaseShared(1);
            // ---------- Original Method ----------
            //sync.releaseShared(1);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:58.638 -0400", hash_original_method = "9996D083DB29CA9E935A73F01FAD8A4F", hash_generated_method = "AA6177806CFC2176E106167AD695F2AC")
        public Condition newCondition() {
            if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
            // ---------- Original Method ----------
            //throw new UnsupportedOperationException();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:58.639 -0400", hash_original_method = "4EA811A9ADBECD9416D19B5EBD75BF53", hash_generated_method = "F8BF6CA1B31DB0FF35965CED02A5835F")
        public String toString() {
            String varB4EAC82CA7396A68D541C85D26508E83_1254393504 = null; //Variable for return #1
            int r;
            r = sync.getReadLockCount();
            varB4EAC82CA7396A68D541C85D26508E83_1254393504 = super.toString() +
                "[Read locks = " + r + "]";
            varB4EAC82CA7396A68D541C85D26508E83_1254393504.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1254393504;
            // ---------- Original Method ----------
            //int r = sync.getReadLockCount();
            //return super.toString() +
                //"[Read locks = " + r + "]";
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:58.639 -0400", hash_original_field = "379AEE3B0AE7E3AB2A711C689B7C790D", hash_generated_field = "B9F9E7F801E368A82CB3CAA5D917DE84")

        private static long serialVersionUID = -5992448646407690164L;
    }


    
    public static class WriteLock implements Lock, java.io.Serializable {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:58.640 -0400", hash_original_field = "63AD9D34F3503826E5F649AE6B7AC92C", hash_generated_field = "A4B34EF3CE38520839B34A2F06599243")

        private Sync sync;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:58.640 -0400", hash_original_method = "2F59DA9CAF578BD2524C05A37F86DF01", hash_generated_method = "A7C2CC6406BCF200D20C7B5AD2A21C1A")
        protected  WriteLock(ReentrantReadWriteLock lock) {
            sync = lock.sync;
            // ---------- Original Method ----------
            //sync = lock.sync;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:58.641 -0400", hash_original_method = "4197ECA2CFEBBAA5B9BD7C840B7670C7", hash_generated_method = "DDE8BF3B445A2924BC3E70FCADFAA419")
        public void lock() {
            sync.acquire(1);
            // ---------- Original Method ----------
            //sync.acquire(1);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:58.641 -0400", hash_original_method = "5966BE77DAE264B5F21646B0E7A08FC1", hash_generated_method = "CFF689BB53A067D7B9EB5F12CA3F00CC")
        public void lockInterruptibly() throws InterruptedException {
            sync.acquireInterruptibly(1);
            // ---------- Original Method ----------
            //sync.acquireInterruptibly(1);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:58.641 -0400", hash_original_method = "55CC434A7054CDED1693C2BA6E1C81AA", hash_generated_method = "ED1E5EFB20F4B6283A756C55A2AE6572")
        public boolean tryLock( ) {
            boolean var55CFE4E4F15027819D6679D2F0F9E5EB_1562412521 = (sync.tryWriteLock());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2032999162 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_2032999162;
            // ---------- Original Method ----------
            //return sync.tryWriteLock();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:58.663 -0400", hash_original_method = "6EF7D2E282F143C52CC20B0DBAA61A21", hash_generated_method = "441F2D057C7208A4A0D66B911CED6169")
        public boolean tryLock(long timeout, TimeUnit unit) throws InterruptedException {
            boolean var4E766E765BA3F93DDE7082A08A077E42_274009711 = (sync.tryAcquireNanos(1, unit.toNanos(timeout)));
            addTaint(timeout);
            addTaint(unit.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_66129460 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_66129460;
            // ---------- Original Method ----------
            //return sync.tryAcquireNanos(1, unit.toNanos(timeout));
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:58.663 -0400", hash_original_method = "7AD42B9E2BC6DD4A4DE0EB9EBA3A2515", hash_generated_method = "87142E80D82254348B0CA43367BBC9B7")
        public void unlock() {
            sync.release(1);
            // ---------- Original Method ----------
            //sync.release(1);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:58.664 -0400", hash_original_method = "6BB095C6835043568D960ACB9C15058D", hash_generated_method = "DA540489124FB8F1596F1CCC9EF9AAF3")
        public Condition newCondition() {
            Condition varB4EAC82CA7396A68D541C85D26508E83_661890986 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_661890986 = sync.newCondition();
            varB4EAC82CA7396A68D541C85D26508E83_661890986.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_661890986;
            // ---------- Original Method ----------
            //return sync.newCondition();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:58.670 -0400", hash_original_method = "E0C199518E39715763AFB28F76F97305", hash_generated_method = "448D37ADC76102FDBC6BBCFAE8CA3A46")
        public String toString() {
            String varB4EAC82CA7396A68D541C85D26508E83_1232750322 = null; //Variable for return #1
            Thread o;
            o = sync.getOwner();
            varB4EAC82CA7396A68D541C85D26508E83_1232750322 = super.toString() + ((o == null) ?
                                       "[Unlocked]" :
                                       "[Locked by thread " + o.getName() + "]");
            varB4EAC82CA7396A68D541C85D26508E83_1232750322.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1232750322;
            // ---------- Original Method ----------
            //Thread o = sync.getOwner();
            //return super.toString() + ((o == null) ?
                                       //"[Unlocked]" :
                                       //"[Locked by thread " + o.getName() + "]");
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:58.670 -0400", hash_original_method = "53A74F7432D74C33316852C3E739832B", hash_generated_method = "E0BA08346EDADC621638EF165D548A8B")
        public boolean isHeldByCurrentThread() {
            boolean var8A9E5BF2F58F6E9DAF336A434F65DD91_1167471890 = (sync.isHeldExclusively());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2028267548 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_2028267548;
            // ---------- Original Method ----------
            //return sync.isHeldExclusively();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:58.682 -0400", hash_original_method = "17A37C9E70A2D6C131240856FD5B2099", hash_generated_method = "30518BFDE6C9DBA9A87629021D6D0011")
        public int getHoldCount() {
            int varE800E928AAA5AF8116F9B878EB5C4BA2_1207562831 = (sync.getWriteHoldCount());
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1530279374 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1530279374;
            // ---------- Original Method ----------
            //return sync.getWriteHoldCount();
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:58.682 -0400", hash_original_field = "39DE0FFFDCAA0428C698758AE0E7E3D8", hash_generated_field = "0E2208352AC5D0B3EE824CFE90B03CD9")

        private static long serialVersionUID = -4992448646407690164L;
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:58.682 -0400", hash_original_field = "ACC5AACF11B6B32C6C9167A3DD56327E", hash_generated_field = "3BBB9D219F619865FD2910C8343417B9")

    private static long serialVersionUID = -6992448646407690164L;
}

