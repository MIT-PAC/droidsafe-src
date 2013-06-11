package java.util.concurrent.locks;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import java.util.concurrent.*;
import java.util.concurrent.atomic.*;
import java.util.*;

public class ReentrantReadWriteLock implements ReadWriteLock, java.io.Serializable {
    private static final long serialVersionUID = -6992448646407690164L;
    private final ReentrantReadWriteLock.ReadLock readerLock;
    private final ReentrantReadWriteLock.WriteLock writerLock;
    final Sync sync;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.043 -0400", hash_original_method = "1C7ADE1C43258ED1B8231199DCC94C2F", hash_generated_method = "FCF99E9C3D12EB828255A760303019CE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ReentrantReadWriteLock() {
        this(false);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.043 -0400", hash_original_method = "A6CD875E912D33CADF6A81571C0A078B", hash_generated_method = "746A46DEB98B0D64972823AF27C3CFB4")
    @DSModeled(DSC.SAFE)
    public ReentrantReadWriteLock(boolean fair) {
        dsTaint.addTaint(fair);
        sync = fair ? new FairSync() : new NonfairSync();
        readerLock = new ReadLock(this);
        writerLock = new WriteLock(this);
        // ---------- Original Method ----------
        //sync = fair ? new FairSync() : new NonfairSync();
        //readerLock = new ReadLock(this);
        //writerLock = new WriteLock(this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.043 -0400", hash_original_method = "0C7BC9C54BE00E03201ACF18B2913309", hash_generated_method = "5FA21E7358C7EBDE841DC5E17B17DA5F")
    @DSModeled(DSC.SAFE)
    public ReentrantReadWriteLock.WriteLock writeLock() {
        return (ReentrantReadWriteLock.WriteLock)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return writerLock;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.043 -0400", hash_original_method = "22D8B34ECDA1804C5F879E9731CF210D", hash_generated_method = "ED2E0306C689BB0ADA3FBAFE09B9954D")
    @DSModeled(DSC.SAFE)
    public ReentrantReadWriteLock.ReadLock readLock() {
        return (ReentrantReadWriteLock.ReadLock)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return readerLock;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.043 -0400", hash_original_method = "6835E283E5F9E7FBD3FF7844476992AD", hash_generated_method = "40F31E047D73F3B698B4BE0FB1C087C3")
    @DSModeled(DSC.SAFE)
    public final boolean isFair() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return sync instanceof FairSync;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.043 -0400", hash_original_method = "DB009A0944F572B5167ED6D51E109787", hash_generated_method = "C762093C78E09C0100A8A0F748BCD3E8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected Thread getOwner() {
        Thread var9841B14668EFDB9EA09AF644B20927F7_353243286 = (sync.getOwner());
        return (Thread)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return sync.getOwner();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.043 -0400", hash_original_method = "BDA3BC7F9F6754233D710BB1E8BDA625", hash_generated_method = "72ACFA390BE5442BB05863015AD16BAD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getReadLockCount() {
        int var5CF7DD4739FB0661883910CE3127C2D4_1918981446 = (sync.getReadLockCount());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return sync.getReadLockCount();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.043 -0400", hash_original_method = "D1234101A768FDEE737EDDFEC7DD19A3", hash_generated_method = "9FEB26D00774ACAA3564A5A666AF0D72")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isWriteLocked() {
        boolean varC09930903B4B15334864667BA6922CA7_867565804 = (sync.isWriteLocked());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return sync.isWriteLocked();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.044 -0400", hash_original_method = "B77A8CC69384EA638697FDA5B4AC3CDF", hash_generated_method = "53028B4E87DEC9F180DC67CB334100CB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isWriteLockedByCurrentThread() {
        boolean var12281D4A72DEB9F8816A0A46604F1374_1784671355 = (sync.isHeldExclusively());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return sync.isHeldExclusively();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.044 -0400", hash_original_method = "F72E2C7B278B975FDBAAB080F7322122", hash_generated_method = "67B4D8CC3C0FF05C1B5F6D9EB285A53B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getWriteHoldCount() {
        int var4B7ADBEF86627032166821903A70F5D0_1453521505 = (sync.getWriteHoldCount());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return sync.getWriteHoldCount();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.044 -0400", hash_original_method = "026686F812EC7870B6E447136A7E8B3A", hash_generated_method = "1F273E343DEB936AA4219F3F55B83A5E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getReadHoldCount() {
        int var4CA9F99F5577509EFAE445B14D1ED825_1701244587 = (sync.getReadHoldCount());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return sync.getReadHoldCount();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.044 -0400", hash_original_method = "2F9252966607830729245C7251D0E4B8", hash_generated_method = "E281E6EFD5828C0E0766F205309A5407")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected Collection<Thread> getQueuedWriterThreads() {
        Collection<Thread> var6D00576CDF238DDCD571C7AFEFFD39E4_2001907313 = (sync.getExclusiveQueuedThreads());
        return (Collection<Thread>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return sync.getExclusiveQueuedThreads();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.044 -0400", hash_original_method = "956CE594FDB46F8FEF252F1FDB068D3D", hash_generated_method = "DF879AFE59D90A3D956ACF884F9FFB15")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected Collection<Thread> getQueuedReaderThreads() {
        Collection<Thread> var7A40EC0170EF1F5EF38591B93AA3DAAE_1754377406 = (sync.getSharedQueuedThreads());
        return (Collection<Thread>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return sync.getSharedQueuedThreads();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.044 -0400", hash_original_method = "33B7DCC82A105082FC4D268ED56F9DE5", hash_generated_method = "78785B2EFC6D97DCB91339999CE58883")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final boolean hasQueuedThreads() {
        boolean var4C0A0AB508905DA8D619627A5EEFD574_331452394 = (sync.hasQueuedThreads());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return sync.hasQueuedThreads();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.044 -0400", hash_original_method = "7B179E46CDF5B520CCEEF15512EC2C63", hash_generated_method = "6E343773A54941E72175BC1002305509")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final boolean hasQueuedThread(Thread thread) {
        dsTaint.addTaint(thread.dsTaint);
        boolean var0681201A478D613CAAB4B4D5196C3EF3_1676978719 = (sync.isQueued(thread));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return sync.isQueued(thread);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.044 -0400", hash_original_method = "DFFF2C05339152644F00EC2FFC57EFB9", hash_generated_method = "AA4825DCEE7944DDA39A752FC4408483")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final int getQueueLength() {
        int var2545CC142A0CD1008911850681315651_1195054759 = (sync.getQueueLength());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return sync.getQueueLength();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.044 -0400", hash_original_method = "4BC73C35668DA24636BE58FB68209032", hash_generated_method = "0E66A1FB5CC1ABA1D59AA368E5B788B5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected Collection<Thread> getQueuedThreads() {
        Collection<Thread> var31D858562CBAED119D353541F01C16B4_2136258584 = (sync.getQueuedThreads());
        return (Collection<Thread>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return sync.getQueuedThreads();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.044 -0400", hash_original_method = "BF91F0F13FB6E88A38744502E21F1F2D", hash_generated_method = "39722715B1256511D5778BEA4992AA48")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean hasWaiters(Condition condition) {
        dsTaint.addTaint(condition.dsTaint);
        throw new NullPointerException();
        throw new IllegalArgumentException("not owner");
        boolean varD78146513D32810B85075F5879934833_675746498 = (sync.hasWaiters((AbstractQueuedSynchronizer.ConditionObject)condition));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (condition == null)
            //throw new NullPointerException();
        //if (!(condition instanceof AbstractQueuedSynchronizer.ConditionObject))
            //throw new IllegalArgumentException("not owner");
        //return sync.hasWaiters((AbstractQueuedSynchronizer.ConditionObject)condition);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.044 -0400", hash_original_method = "D4277B3B6ED39F705D915D3806A5548A", hash_generated_method = "32F40635B5EFF3605BB39BF1492BBFE0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getWaitQueueLength(Condition condition) {
        dsTaint.addTaint(condition.dsTaint);
        throw new NullPointerException();
        throw new IllegalArgumentException("not owner");
        int var60A2F707F5BC43BB059D2028F4E4733B_179808926 = (sync.getWaitQueueLength((AbstractQueuedSynchronizer.ConditionObject)condition));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //if (condition == null)
            //throw new NullPointerException();
        //if (!(condition instanceof AbstractQueuedSynchronizer.ConditionObject))
            //throw new IllegalArgumentException("not owner");
        //return sync.getWaitQueueLength((AbstractQueuedSynchronizer.ConditionObject)condition);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.044 -0400", hash_original_method = "29738EA386BFBB41E36C961DB4B1CBE5", hash_generated_method = "F82E7C4D75F9B72181F6B38FF992BAA9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected Collection<Thread> getWaitingThreads(Condition condition) {
        dsTaint.addTaint(condition.dsTaint);
        throw new NullPointerException();
        throw new IllegalArgumentException("not owner");
        Collection<Thread> varACD2ABC34A7FF03371BF6C03D9CBDA6D_368777775 = (sync.getWaitingThreads((AbstractQueuedSynchronizer.ConditionObject)condition));
        return (Collection<Thread>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (condition == null)
            //throw new NullPointerException();
        //if (!(condition instanceof AbstractQueuedSynchronizer.ConditionObject))
            //throw new IllegalArgumentException("not owner");
        //return sync.getWaitingThreads((AbstractQueuedSynchronizer.ConditionObject)condition);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.044 -0400", hash_original_method = "03D5EBF343C873E095999F30626DADA2", hash_generated_method = "0EEAF5C398647D0136AB0DBE0F8B8678")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String toString() {
        int c;
        c = sync.getCount();
        int w;
        w = Sync.exclusiveCount(c);
        int r;
        r = Sync.sharedCount(c);
        String var3A3379FE278A421442D56E003AA6E7F1_381915171 = (super.toString() +
            "[Write locks = " + w + ", Read locks = " + r + "]");
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //int c = sync.getCount();
        //int w = Sync.exclusiveCount(c);
        //int r = Sync.sharedCount(c);
        //return super.toString() +
            //"[Write locks = " + w + ", Read locks = " + r + "]";
    }

    
    abstract static class Sync extends AbstractQueuedSynchronizer {
        private static final long serialVersionUID = 6317671515068378041L;
        static final int SHARED_SHIFT   = 16;
        static final int SHARED_UNIT    = (1 << SHARED_SHIFT);
        static final int MAX_COUNT      = (1 << SHARED_SHIFT) - 1;
        static final int EXCLUSIVE_MASK = (1 << SHARED_SHIFT) - 1;
        private transient ThreadLocalHoldCounter readHolds;
        private transient HoldCounter cachedHoldCounter;
        private transient Thread firstReader = null;
        private transient int firstReaderHoldCount;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.044 -0400", hash_original_method = "89DA4D8EA92261B26BAB9F4AB5CDD482", hash_generated_method = "1E55E01BDCD0955E7E6A4CC6C1ED1540")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         Sync() {
            readHolds = new ThreadLocalHoldCounter();
            setState(getState());
            // ---------- Original Method ----------
            //readHolds = new ThreadLocalHoldCounter();
            //setState(getState());
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.044 -0400", hash_original_method = "DDE7ADD45E524E72C4E1EDD9156B853C", hash_generated_method = "1440F90E58EAA76F027CC9D33EF31FD7")
        static int sharedCount(int c) {
            return c >>> SHARED_SHIFT;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.044 -0400", hash_original_method = "B9F2E25335CFA4041C18F9D081EBA76A", hash_generated_method = "1DBB44439BE4E94543DE542D67E42F8C")
        static int exclusiveCount(int c) {
            return c & EXCLUSIVE_MASK;
        }

        
        abstract boolean readerShouldBlock();

        
        abstract boolean writerShouldBlock();

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.045 -0400", hash_original_method = "E2589B88E3FBFBAA4E5917277DEFE99E", hash_generated_method = "4ED9202E7A46E272564D4D9024A85C8B")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        protected final boolean tryRelease(int releases) {
            dsTaint.addTaint(releases);
            {
                boolean varBDF0ABD2F20F8D3DCB5C83DB8D0ED9B5_283673338 = (!isHeldExclusively());
                throw new IllegalMonitorStateException();
            } //End collapsed parenthetic
            int nextc;
            nextc = getState() - releases;
            boolean free;
            free = exclusiveCount(nextc) == 0;
            setExclusiveOwnerThread(null);
            setState(nextc);
            return dsTaint.getTaintBoolean();
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.045 -0400", hash_original_method = "887DB434CE6AB550C72A17E01EAED908", hash_generated_method = "8858AD462D3E4F1AC8AA095E3F9EFBC1")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        protected final boolean tryAcquire(int acquires) {
            dsTaint.addTaint(acquires);
            Thread current;
            current = Thread.currentThread();
            int c;
            c = getState();
            int w;
            w = exclusiveCount(c);
            {
                {
                    boolean var90979142887A20EB72C8964C86EB9321_275159594 = (w == 0 || current != getExclusiveOwnerThread());
                } //End collapsed parenthetic
                {
                    boolean var318575A0FEE61BCA2C1999503B3E7456_1048411291 = (w + exclusiveCount(acquires) > MAX_COUNT);
                    throw new Error("Maximum lock count exceeded");
                } //End collapsed parenthetic
                setState(c + acquires);
            } //End block
            {
                boolean var33B66AF91B134BC4CCDF9A857D584490_796813859 = (writerShouldBlock() ||
                !compareAndSetState(c, c + acquires));
            } //End collapsed parenthetic
            setExclusiveOwnerThread(current);
            return dsTaint.getTaintBoolean();
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.045 -0400", hash_original_method = "DCB6BD37D30DD1C1033C1677B2F2BA39", hash_generated_method = "0D905611613539EDFDDF78252FE40EF8")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        protected final boolean tryReleaseShared(int unused) {
            dsTaint.addTaint(unused);
            Thread current;
            current = Thread.currentThread();
            {
                firstReader = null;
                firstReaderHoldCount--;
            } //End block
            {
                HoldCounter rh;
                rh = cachedHoldCounter;
                {
                    boolean var742A69B23BBDDB423EC138DCBB7B9545_698117102 = (rh == null || rh.tid != current.getId());
                    rh = readHolds.get();
                } //End collapsed parenthetic
                int count;
                count = rh.count;
                {
                    readHolds.remove();
                    throw unmatchedUnlockException();
                } //End block
                --rh.count;
            } //End block
            {
                int c;
                c = getState();
                int nextc;
                nextc = c - SHARED_UNIT;
                {
                    boolean var525F59EF5A984E7DE1A679CCEEFC8101_1441201314 = (compareAndSetState(c, nextc));
                } //End collapsed parenthetic
            } //End block
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.045 -0400", hash_original_method = "4AE7D8D2A940AB168E8F2908DE9ACCF1", hash_generated_method = "E513F6C1A9635D954FF34849FD25AD6F")
        @DSModeled(DSC.SAFE)
        private IllegalMonitorStateException unmatchedUnlockException() {
            return (IllegalMonitorStateException)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new IllegalMonitorStateException(
                //"attempt to unlock read lock, not locked by current thread");
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.045 -0400", hash_original_method = "AD4C82A786111FF828AFE5FE5C8E5A39", hash_generated_method = "094CC5DCB5DFB8CA924AB7E9A07D8869")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        protected final int tryAcquireShared(int unused) {
            dsTaint.addTaint(unused);
            Thread current;
            current = Thread.currentThread();
            int c;
            c = getState();
            {
                boolean varCBCE136FFBA6AA5474A803A63D00FAD1_1186320035 = (exclusiveCount(c) != 0 &&
                getExclusiveOwnerThread() != current);
            } //End collapsed parenthetic
            int r;
            r = sharedCount(c);
            {
                boolean varC705F9493B1FAEA076FDA3794FAA0183_927416940 = (!readerShouldBlock() &&
                r < MAX_COUNT &&
                compareAndSetState(c, c + SHARED_UNIT));
                {
                    {
                        firstReader = current;
                        firstReaderHoldCount = 1;
                    } //End block
                    {
                        firstReaderHoldCount++;
                    } //End block
                    {
                        HoldCounter rh;
                        rh = cachedHoldCounter;
                        {
                            boolean varDB55354BA83BD531EC70083B969F9FA7_307577267 = (rh == null || rh.tid != current.getId());
                            cachedHoldCounter = rh = readHolds.get();
                            readHolds.set(rh);
                        } //End collapsed parenthetic
                        rh.count++;
                    } //End block
                } //End block
            } //End collapsed parenthetic
            int var203CD572536C941A4B1A477F089EE192_211333090 = (fullTryAcquireShared(current));
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.046 -0400", hash_original_method = "EBE8D8355B366068B4B1E29E3A9EED12", hash_generated_method = "6DBBD061F70B065CDBB0BE59255C9223")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        final int fullTryAcquireShared(Thread current) {
            dsTaint.addTaint(current.dsTaint);
            HoldCounter rh;
            rh = null;
            {
                int c;
                c = getState();
                {
                    boolean var529468DC4620BDF65F6B6C7D22F44273_1627865813 = (exclusiveCount(c) != 0);
                    {
                        {
                            boolean varD3F580BFEF90DED8D0695E9E6E71809D_1684051083 = (getExclusiveOwnerThread() != current);
                        } //End collapsed parenthetic
                    } //End block
                    {
                        boolean var860368E133590F744493740787A52E27_1711831806 = (readerShouldBlock());
                        {
                            {
                                {
                                    rh = cachedHoldCounter;
                                    {
                                        boolean var84643B1DF9273A723910E3CDDBCE3609_35018585 = (rh == null || rh.tid != current.getId());
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
                    boolean var81C9C11D2632075F5A3FC662D0DAC8FC_253027918 = (sharedCount(c) == MAX_COUNT);
                    throw new Error("Maximum lock count exceeded");
                } //End collapsed parenthetic
                {
                    boolean varED20116B0BB1734240062BCE3EF53974_580793090 = (compareAndSetState(c, c + SHARED_UNIT));
                    {
                        {
                            boolean varD8F1AA39FE8E689164014F966ADE2AC4_827158290 = (sharedCount(c) == 0);
                            {
                                firstReaderHoldCount = 1;
                            } //End block
                            {
                                firstReaderHoldCount++;
                            } //End block
                            {
                                rh = cachedHoldCounter;
                                {
                                    boolean var50B8EA88D62C62CC9B48E69494903B06_214235155 = (rh == null || rh.tid != current.getId());
                                    rh = readHolds.get();
                                    readHolds.set(rh);
                                } //End collapsed parenthetic
                                rh.count++;
                                cachedHoldCounter = rh;
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                } //End collapsed parenthetic
            } //End block
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.046 -0400", hash_original_method = "0DD6CA3D230AA260224A4A3AE8239ACB", hash_generated_method = "E587FF801341E67907C1635E77464757")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        final boolean tryWriteLock() {
            Thread current;
            current = Thread.currentThread();
            int c;
            c = getState();
            {
                int w;
                w = exclusiveCount(c);
                {
                    boolean var90979142887A20EB72C8964C86EB9321_1259275790 = (w == 0 || current != getExclusiveOwnerThread());
                } //End collapsed parenthetic
                throw new Error("Maximum lock count exceeded");
            } //End block
            {
                boolean var42EFECE5F4E2BBE5A5608C37A8B687F3_1305513662 = (!compareAndSetState(c, c + 1));
            } //End collapsed parenthetic
            setExclusiveOwnerThread(current);
            return dsTaint.getTaintBoolean();
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.046 -0400", hash_original_method = "F864315749E9B3DD069E258F497DFE4D", hash_generated_method = "F1A87F488D5B211B3A704BF0046D327C")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        final boolean tryReadLock() {
            Thread current;
            current = Thread.currentThread();
            {
                int c;
                c = getState();
                {
                    boolean varEA7F18DF3FD18041706E4732508BA651_278030008 = (exclusiveCount(c) != 0 &&
                    getExclusiveOwnerThread() != current);
                } //End collapsed parenthetic
                int r;
                r = sharedCount(c);
                throw new Error("Maximum lock count exceeded");
                {
                    boolean varED20116B0BB1734240062BCE3EF53974_1168992729 = (compareAndSetState(c, c + SHARED_UNIT));
                    {
                        {
                            firstReader = current;
                            firstReaderHoldCount = 1;
                        } //End block
                        {
                            firstReaderHoldCount++;
                        } //End block
                        {
                            HoldCounter rh;
                            rh = cachedHoldCounter;
                            {
                                boolean varD70438DD2BB853F7AACBE7CBC6449999_1387388958 = (rh == null || rh.tid != current.getId());
                                cachedHoldCounter = rh = readHolds.get();
                                readHolds.set(rh);
                            } //End collapsed parenthetic
                            rh.count++;
                        } //End block
                    } //End block
                } //End collapsed parenthetic
            } //End block
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.046 -0400", hash_original_method = "A843CC28FFAE9A089B89A0058BA2B9D5", hash_generated_method = "CC25F8AEF7EC65FF56ECAF1279C20182")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        protected final boolean isHeldExclusively() {
            boolean var3CE6B8DE56D5A33803435E843AACF76A_1596353959 = (getExclusiveOwnerThread() == Thread.currentThread());
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return getExclusiveOwnerThread() == Thread.currentThread();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.046 -0400", hash_original_method = "093F0D0E6A279CA43864791B6FD65040", hash_generated_method = "8AA34E3FD2711094A803E6A05A1AF47C")
        @DSModeled(DSC.SAFE)
        final ConditionObject newCondition() {
            return (ConditionObject)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new ConditionObject();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.046 -0400", hash_original_method = "3F3DE8BCF9BFC159EB93FF2ABA8024D7", hash_generated_method = "9EFF67F1ECCB2124FABAA3FBF956E2E1")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        final Thread getOwner() {
            Thread var39417DC900ADC99DDD05E344B96A3C7F_1469429229 = (((exclusiveCount(getState()) == 0) ?
                    null :
                    getExclusiveOwnerThread())); //DSFIXME:  CODE0008: Nested ternary operator in expression
            return (Thread)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return ((exclusiveCount(getState()) == 0) ?
                    //null :
                    //getExclusiveOwnerThread());
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.046 -0400", hash_original_method = "0B84E22FFE55E13BE40413778559BE34", hash_generated_method = "20473FF9B5A11C8396D5F9522B7FAD8E")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        final int getReadLockCount() {
            int var5073DFD1A27AB6C474CC24F8B7EC3CD3_1809328128 = (sharedCount(getState()));
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return sharedCount(getState());
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.046 -0400", hash_original_method = "09CA8B61F6450707C75BFC712569D4D4", hash_generated_method = "09A7C73BF2B8DD72857B5653E45E1E6F")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        final boolean isWriteLocked() {
            boolean var01CAC84C2F38392161F4E16039D7DE44_1777973799 = (exclusiveCount(getState()) != 0);
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return exclusiveCount(getState()) != 0;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.046 -0400", hash_original_method = "67C0C583D90F5F49CAE0DBAE2DE27D59", hash_generated_method = "8A51CB7B01DBF72689FEE7905A6A633F")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        final int getWriteHoldCount() {
            {
                boolean var34E827331B4BC7F16DFC99E8B4EE154E_171750793 = (isHeldExclusively());
                Object var0847481376D95B453E4DA8F62DB7ADA1_24689586 = (exclusiveCount(getState()));
            } //End flattened ternary
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return isHeldExclusively() ? exclusiveCount(getState()) : 0;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.047 -0400", hash_original_method = "1DA1A38561287A101F5C2B623B00252F", hash_generated_method = "FD9049EDC10321519BD673D21F09172E")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        final int getReadHoldCount() {
            {
                boolean varCF77250596B8C839BEFAC301F344C853_1213231660 = (getReadLockCount() == 0);
            } //End collapsed parenthetic
            Thread current;
            current = Thread.currentThread();
            HoldCounter rh;
            rh = cachedHoldCounter;
            {
                boolean var12BC8C81E89FF6364E7C14D490B5B984_1643563062 = (rh != null && rh.tid == current.getId());
            } //End collapsed parenthetic
            int count;
            count = readHolds.get().count;
            readHolds.remove();
            return dsTaint.getTaintInt();
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.047 -0400", hash_original_method = "4E48396D4489DBF7E8DA7E593070FC82", hash_generated_method = "CF3A0FB9B34466F6769E1B7D9FE904E2")
        @DSModeled(DSC.SAFE)
        private void readObject(java.io.ObjectInputStream s) throws java.io.IOException, ClassNotFoundException {
            dsTaint.addTaint(s.dsTaint);
            s.defaultReadObject();
            readHolds = new ThreadLocalHoldCounter();
            setState(0);
            // ---------- Original Method ----------
            //s.defaultReadObject();
            //readHolds = new ThreadLocalHoldCounter();
            //setState(0);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.047 -0400", hash_original_method = "192D38E698A214D58DA93C3298AD6AD3", hash_generated_method = "4BB65338D2115C513EE2E6258623933E")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        final int getCount() {
            int var376B5C2087169E76FB6628D31DCC9663_982368134 = (getState());
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return getState();
        }

        
        static final class HoldCounter {
            int count = 0;
            final long tid = Thread.currentThread().getId();
            
        }


        
        static final class ThreadLocalHoldCounter extends ThreadLocal<HoldCounter> {
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.047 -0400", hash_original_method = "65FB587992A751B61B2E99AB391905DE", hash_generated_method = "AD2D6EEA0A78CEDE00AC10F8071BCBBE")
            @DSModeled(DSC.SAFE)
            public HoldCounter initialValue() {
                return (HoldCounter)dsTaint.getTaint();
                // ---------- Original Method ----------
                //return new HoldCounter();
            }

            
        }


        
    }


    
    static final class NonfairSync extends Sync {
        private static final long serialVersionUID = -8159625535654395037L;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.047 -0400", hash_original_method = "6099B514073B77A554543D2A2B955577", hash_generated_method = "D48CC989606562B86E5E5BA6706C921D")
        @DSModeled(DSC.SAFE)
        final boolean writerShouldBlock() {
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return false;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.047 -0400", hash_original_method = "311D59812186188137CBEED2258453A3", hash_generated_method = "3D917792FD7200BE8E53C9680A03770A")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        final boolean readerShouldBlock() {
            boolean var42C6C6A77390D0F65AEC7AEAAD6B4F91_2037559359 = (apparentlyFirstQueuedIsExclusive());
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return apparentlyFirstQueuedIsExclusive();
        }

        
    }


    
    static final class FairSync extends Sync {
        private static final long serialVersionUID = -2274990926593161451L;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.047 -0400", hash_original_method = "F04DB8A71B8ACD86834CABDF23C7982B", hash_generated_method = "A5E63A4EB806034C3CFCAC5C68262303")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        final boolean writerShouldBlock() {
            boolean var5D9F3BF4621CB4A60B96236F06AF2405_2055505067 = (hasQueuedPredecessors());
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return hasQueuedPredecessors();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.047 -0400", hash_original_method = "5E806298851931D3FCAB2DE2F5A11624", hash_generated_method = "7A2BD9FC9EC6F5F46FD06EA0FB172A7B")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        final boolean readerShouldBlock() {
            boolean var5D9F3BF4621CB4A60B96236F06AF2405_2135434026 = (hasQueuedPredecessors());
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return hasQueuedPredecessors();
        }

        
    }


    
    public static class ReadLock implements Lock, java.io.Serializable {
        private static final long serialVersionUID = -5992448646407690164L;
        private final Sync sync;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.047 -0400", hash_original_method = "86296C44CAAC51998FCC18AC6C334852", hash_generated_method = "78D63F152F2420D1BB6F916339CC78A7")
        @DSModeled(DSC.SAFE)
        protected ReadLock(ReentrantReadWriteLock lock) {
            dsTaint.addTaint(lock.dsTaint);
            sync = lock.sync;
            // ---------- Original Method ----------
            //sync = lock.sync;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.047 -0400", hash_original_method = "8D72D73F25D8DE6C9209D04669F96039", hash_generated_method = "D05DF84F3A0D83716C3189D04FC96E3E")
        @DSModeled(DSC.SAFE)
        public void lock() {
            sync.acquireShared(1);
            // ---------- Original Method ----------
            //sync.acquireShared(1);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.047 -0400", hash_original_method = "61D542FCA692219B5199CDDD1A71CCC6", hash_generated_method = "9D6B9236A0BDB78E37CC527AD260B3A9")
        @DSModeled(DSC.SAFE)
        public void lockInterruptibly() throws InterruptedException {
            sync.acquireSharedInterruptibly(1);
            // ---------- Original Method ----------
            //sync.acquireSharedInterruptibly(1);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.047 -0400", hash_original_method = "6F9DD593410D3A6A5FB658A804C67B03", hash_generated_method = "09389B692A334FE9DDF6A6FC9EA33778")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public boolean tryLock() {
            boolean var82642F761C8CC4EFB1E9891565A562E0_1086193255 = (sync.tryReadLock());
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return sync.tryReadLock();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.047 -0400", hash_original_method = "CABC63B31BFC6EB1808F17E4FED50740", hash_generated_method = "B029D52DE66F82E8192F58AF91D0FFAE")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public boolean tryLock(long timeout, TimeUnit unit) throws InterruptedException {
            dsTaint.addTaint(unit.dsTaint);
            dsTaint.addTaint(timeout);
            boolean varC650725F0ACDDC932C370EDA1774172F_387385121 = (sync.tryAcquireSharedNanos(1, unit.toNanos(timeout)));
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return sync.tryAcquireSharedNanos(1, unit.toNanos(timeout));
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.047 -0400", hash_original_method = "2E2DA507FE1EE35FD0E649F791C4FA62", hash_generated_method = "4FE3E8B0A8BA8F1ED8AE0DC08CE3BDE6")
        @DSModeled(DSC.SAFE)
        public void unlock() {
            sync.releaseShared(1);
            // ---------- Original Method ----------
            //sync.releaseShared(1);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.047 -0400", hash_original_method = "9996D083DB29CA9E935A73F01FAD8A4F", hash_generated_method = "073D9BB80960E0D164EE49C0B4211133")
        @DSModeled(DSC.SAFE)
        public Condition newCondition() {
            throw new UnsupportedOperationException();
            return (Condition)dsTaint.getTaint();
            // ---------- Original Method ----------
            //throw new UnsupportedOperationException();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.047 -0400", hash_original_method = "4EA811A9ADBECD9416D19B5EBD75BF53", hash_generated_method = "F320FF966875E77E760EAB4FC0D8F526")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public String toString() {
            int r;
            r = sync.getReadLockCount();
            String var3174A7CB2D886E957C2AE3013EA3BEED_555161633 = (super.toString() +
                "[Read locks = " + r + "]");
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //int r = sync.getReadLockCount();
            //return super.toString() +
                //"[Read locks = " + r + "]";
        }

        
    }


    
    public static class WriteLock implements Lock, java.io.Serializable {
        private static final long serialVersionUID = -4992448646407690164L;
        private final Sync sync;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.048 -0400", hash_original_method = "2F59DA9CAF578BD2524C05A37F86DF01", hash_generated_method = "42BACBE55D2E9DB8698D263BDD83E966")
        @DSModeled(DSC.SAFE)
        protected WriteLock(ReentrantReadWriteLock lock) {
            dsTaint.addTaint(lock.dsTaint);
            sync = lock.sync;
            // ---------- Original Method ----------
            //sync = lock.sync;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.048 -0400", hash_original_method = "4197ECA2CFEBBAA5B9BD7C840B7670C7", hash_generated_method = "82FADCDBA3A1567C544F6F22F64F1DF0")
        @DSModeled(DSC.SAFE)
        public void lock() {
            sync.acquire(1);
            // ---------- Original Method ----------
            //sync.acquire(1);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.048 -0400", hash_original_method = "5966BE77DAE264B5F21646B0E7A08FC1", hash_generated_method = "514A6A0D88F9F385AE71FC60BB19B78B")
        @DSModeled(DSC.SAFE)
        public void lockInterruptibly() throws InterruptedException {
            sync.acquireInterruptibly(1);
            // ---------- Original Method ----------
            //sync.acquireInterruptibly(1);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.048 -0400", hash_original_method = "55CC434A7054CDED1693C2BA6E1C81AA", hash_generated_method = "400B2F37406C86B401193CF87B01BBE4")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public boolean tryLock( ) {
            boolean var55CFE4E4F15027819D6679D2F0F9E5EB_2021771213 = (sync.tryWriteLock());
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return sync.tryWriteLock();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.048 -0400", hash_original_method = "6EF7D2E282F143C52CC20B0DBAA61A21", hash_generated_method = "D193FA64485C52942D9C47126DD62AB8")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public boolean tryLock(long timeout, TimeUnit unit) throws InterruptedException {
            dsTaint.addTaint(unit.dsTaint);
            dsTaint.addTaint(timeout);
            boolean var4E766E765BA3F93DDE7082A08A077E42_145511565 = (sync.tryAcquireNanos(1, unit.toNanos(timeout)));
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return sync.tryAcquireNanos(1, unit.toNanos(timeout));
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.048 -0400", hash_original_method = "7AD42B9E2BC6DD4A4DE0EB9EBA3A2515", hash_generated_method = "CBE14A8287054E66CFC35BAD3F4C1141")
        @DSModeled(DSC.SAFE)
        public void unlock() {
            sync.release(1);
            // ---------- Original Method ----------
            //sync.release(1);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.048 -0400", hash_original_method = "6BB095C6835043568D960ACB9C15058D", hash_generated_method = "98CC2E8D05394A3BAED68C7CEE0ECEB2")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public Condition newCondition() {
            Condition var83DB6A69F4B6512F87D8CB6516ECC228_870537899 = (sync.newCondition());
            return (Condition)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return sync.newCondition();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.048 -0400", hash_original_method = "E0C199518E39715763AFB28F76F97305", hash_generated_method = "A32536EC15B5004AC21E6C2AAD4E25CA")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public String toString() {
            Thread o;
            o = sync.getOwner();
            String var942976EEB7D3D238D484789DF64377A1_36748882 = (super.toString() + ((o == null) ?
                                       "[Unlocked]" :
                                       "[Locked by thread " + o.getName() + "]")); //DSFIXME:  CODE0008: Nested ternary operator in expression
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //Thread o = sync.getOwner();
            //return super.toString() + ((o == null) ?
                                       //"[Unlocked]" :
                                       //"[Locked by thread " + o.getName() + "]");
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.048 -0400", hash_original_method = "53A74F7432D74C33316852C3E739832B", hash_generated_method = "52AA8008A3D847B27A5EB954DAF52A74")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public boolean isHeldByCurrentThread() {
            boolean var8A9E5BF2F58F6E9DAF336A434F65DD91_1229203919 = (sync.isHeldExclusively());
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return sync.isHeldExclusively();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.048 -0400", hash_original_method = "17A37C9E70A2D6C131240856FD5B2099", hash_generated_method = "826E8B973D2B922A8F7DBF57F01F573E")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public int getHoldCount() {
            int varE800E928AAA5AF8116F9B878EB5C4BA2_927627885 = (sync.getWriteHoldCount());
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return sync.getWriteHoldCount();
        }

        
    }


    
}


