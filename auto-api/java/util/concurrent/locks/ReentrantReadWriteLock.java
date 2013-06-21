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
    private ReentrantReadWriteLock.ReadLock readerLock;
    private ReentrantReadWriteLock.WriteLock writerLock;
    Sync sync;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.252 -0400", hash_original_method = "1C7ADE1C43258ED1B8231199DCC94C2F", hash_generated_method = "A2362B6FC27126ECCCC3F80E71268B1E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ReentrantReadWriteLock() {
        this(false);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.253 -0400", hash_original_method = "A6CD875E912D33CADF6A81571C0A078B", hash_generated_method = "9364EA624E4493A6C1E094F86452B986")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.253 -0400", hash_original_method = "0C7BC9C54BE00E03201ACF18B2913309", hash_generated_method = "66625A7B9A4C397B0ADD886EB8D47A1D")
    @DSModeled(DSC.SAFE)
    public ReentrantReadWriteLock.WriteLock writeLock() {
        return (ReentrantReadWriteLock.WriteLock)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return writerLock;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.253 -0400", hash_original_method = "22D8B34ECDA1804C5F879E9731CF210D", hash_generated_method = "54A200C4BEDE297CB84DA13DC96EF690")
    @DSModeled(DSC.SAFE)
    public ReentrantReadWriteLock.ReadLock readLock() {
        return (ReentrantReadWriteLock.ReadLock)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return readerLock;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.253 -0400", hash_original_method = "6835E283E5F9E7FBD3FF7844476992AD", hash_generated_method = "55D62964B9EF84187B0EE15ED60B4146")
    @DSModeled(DSC.SAFE)
    public final boolean isFair() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return sync instanceof FairSync;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.254 -0400", hash_original_method = "DB009A0944F572B5167ED6D51E109787", hash_generated_method = "AE570CAC7A3153D9FC82881B9C513505")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected Thread getOwner() {
        Thread var9841B14668EFDB9EA09AF644B20927F7_740599244 = (sync.getOwner());
        return (Thread)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return sync.getOwner();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.254 -0400", hash_original_method = "BDA3BC7F9F6754233D710BB1E8BDA625", hash_generated_method = "7B541995853D56F94E1EF67E03A4F291")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getReadLockCount() {
        int var5CF7DD4739FB0661883910CE3127C2D4_1879195364 = (sync.getReadLockCount());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return sync.getReadLockCount();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.254 -0400", hash_original_method = "D1234101A768FDEE737EDDFEC7DD19A3", hash_generated_method = "D400226579F9DF9F75BDD6526F26EA19")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isWriteLocked() {
        boolean varC09930903B4B15334864667BA6922CA7_1750911249 = (sync.isWriteLocked());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return sync.isWriteLocked();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.254 -0400", hash_original_method = "B77A8CC69384EA638697FDA5B4AC3CDF", hash_generated_method = "BF3318BFD184D21BB4721A4E31CA6832")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isWriteLockedByCurrentThread() {
        boolean var12281D4A72DEB9F8816A0A46604F1374_1642643590 = (sync.isHeldExclusively());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return sync.isHeldExclusively();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.254 -0400", hash_original_method = "F72E2C7B278B975FDBAAB080F7322122", hash_generated_method = "60E26C73D8AED2265063096ABE7FC8D2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getWriteHoldCount() {
        int var4B7ADBEF86627032166821903A70F5D0_2058141594 = (sync.getWriteHoldCount());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return sync.getWriteHoldCount();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.254 -0400", hash_original_method = "026686F812EC7870B6E447136A7E8B3A", hash_generated_method = "632648A93C06732F4BBB913010F880CC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getReadHoldCount() {
        int var4CA9F99F5577509EFAE445B14D1ED825_638302356 = (sync.getReadHoldCount());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return sync.getReadHoldCount();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.255 -0400", hash_original_method = "2F9252966607830729245C7251D0E4B8", hash_generated_method = "2EF6AE8FDAD440682A13EA2DC28EDA04")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected Collection<Thread> getQueuedWriterThreads() {
        Collection<Thread> var6D00576CDF238DDCD571C7AFEFFD39E4_382497630 = (sync.getExclusiveQueuedThreads());
        return (Collection<Thread>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return sync.getExclusiveQueuedThreads();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.255 -0400", hash_original_method = "956CE594FDB46F8FEF252F1FDB068D3D", hash_generated_method = "6C134BA53097E75312692A201455900D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected Collection<Thread> getQueuedReaderThreads() {
        Collection<Thread> var7A40EC0170EF1F5EF38591B93AA3DAAE_2081362886 = (sync.getSharedQueuedThreads());
        return (Collection<Thread>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return sync.getSharedQueuedThreads();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.255 -0400", hash_original_method = "33B7DCC82A105082FC4D268ED56F9DE5", hash_generated_method = "BFF645ED0A4C317600A339BF23E12A0D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final boolean hasQueuedThreads() {
        boolean var4C0A0AB508905DA8D619627A5EEFD574_563991125 = (sync.hasQueuedThreads());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return sync.hasQueuedThreads();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.255 -0400", hash_original_method = "7B179E46CDF5B520CCEEF15512EC2C63", hash_generated_method = "F609B38226062E4242D9E52B26288197")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final boolean hasQueuedThread(Thread thread) {
        dsTaint.addTaint(thread.dsTaint);
        boolean var0681201A478D613CAAB4B4D5196C3EF3_853300430 = (sync.isQueued(thread));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return sync.isQueued(thread);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.255 -0400", hash_original_method = "DFFF2C05339152644F00EC2FFC57EFB9", hash_generated_method = "9E959A9290C3A5E20E19819B08EC262B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final int getQueueLength() {
        int var2545CC142A0CD1008911850681315651_242879388 = (sync.getQueueLength());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return sync.getQueueLength();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.255 -0400", hash_original_method = "4BC73C35668DA24636BE58FB68209032", hash_generated_method = "5C025EF8B17EF6345271505C69006643")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected Collection<Thread> getQueuedThreads() {
        Collection<Thread> var31D858562CBAED119D353541F01C16B4_1472236916 = (sync.getQueuedThreads());
        return (Collection<Thread>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return sync.getQueuedThreads();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.256 -0400", hash_original_method = "BF91F0F13FB6E88A38744502E21F1F2D", hash_generated_method = "8F19798228BB637B949298697F49DB0E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean hasWaiters(Condition condition) {
        dsTaint.addTaint(condition.dsTaint);
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("not owner");
        boolean varD78146513D32810B85075F5879934833_1644952272 = (sync.hasWaiters((AbstractQueuedSynchronizer.ConditionObject)condition));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (condition == null)
            //throw new NullPointerException();
        //if (!(condition instanceof AbstractQueuedSynchronizer.ConditionObject))
            //throw new IllegalArgumentException("not owner");
        //return sync.hasWaiters((AbstractQueuedSynchronizer.ConditionObject)condition);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.256 -0400", hash_original_method = "D4277B3B6ED39F705D915D3806A5548A", hash_generated_method = "E83E5950FE1187847B5738E518B44575")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getWaitQueueLength(Condition condition) {
        dsTaint.addTaint(condition.dsTaint);
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("not owner");
        int var60A2F707F5BC43BB059D2028F4E4733B_1868342219 = (sync.getWaitQueueLength((AbstractQueuedSynchronizer.ConditionObject)condition));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //if (condition == null)
            //throw new NullPointerException();
        //if (!(condition instanceof AbstractQueuedSynchronizer.ConditionObject))
            //throw new IllegalArgumentException("not owner");
        //return sync.getWaitQueueLength((AbstractQueuedSynchronizer.ConditionObject)condition);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.256 -0400", hash_original_method = "29738EA386BFBB41E36C961DB4B1CBE5", hash_generated_method = "DE5FB982FACBE5845A9BF459E6E12B97")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected Collection<Thread> getWaitingThreads(Condition condition) {
        dsTaint.addTaint(condition.dsTaint);
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("not owner");
        Collection<Thread> varACD2ABC34A7FF03371BF6C03D9CBDA6D_1875757359 = (sync.getWaitingThreads((AbstractQueuedSynchronizer.ConditionObject)condition));
        return (Collection<Thread>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (condition == null)
            //throw new NullPointerException();
        //if (!(condition instanceof AbstractQueuedSynchronizer.ConditionObject))
            //throw new IllegalArgumentException("not owner");
        //return sync.getWaitingThreads((AbstractQueuedSynchronizer.ConditionObject)condition);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.257 -0400", hash_original_method = "03D5EBF343C873E095999F30626DADA2", hash_generated_method = "456CCED79B08177633E68007E006A289")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String toString() {
        int c;
        c = sync.getCount();
        int w;
        w = Sync.exclusiveCount(c);
        int r;
        r = Sync.sharedCount(c);
        String var3A3379FE278A421442D56E003AA6E7F1_853932961 = (super.toString() +
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
        private transient ThreadLocalHoldCounter readHolds;
        private transient HoldCounter cachedHoldCounter;
        private transient Thread firstReader = null;
        private transient int firstReaderHoldCount;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.257 -0400", hash_original_method = "89DA4D8EA92261B26BAB9F4AB5CDD482", hash_generated_method = "F96B116FAEB3CF7E52F47724A0D1064E")
        //DSFIXME:  CODE0002: Requires DSC value to be set
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.259 -0400", hash_original_method = "E2589B88E3FBFBAA4E5917277DEFE99E", hash_generated_method = "C2B212532C2068E6162E83AA9259E451")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        protected final boolean tryRelease(int releases) {
            dsTaint.addTaint(releases);
            {
                boolean varBDF0ABD2F20F8D3DCB5C83DB8D0ED9B5_1183495630 = (!isHeldExclusively());
                if (DroidSafeAndroidRuntime.control) throw new IllegalMonitorStateException();
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.260 -0400", hash_original_method = "887DB434CE6AB550C72A17E01EAED908", hash_generated_method = "049A9AC0EBF265B377567B024BEA3E20")
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
                    boolean var90979142887A20EB72C8964C86EB9321_728936152 = (w == 0 || current != getExclusiveOwnerThread());
                } //End collapsed parenthetic
                {
                    boolean var318575A0FEE61BCA2C1999503B3E7456_1843622198 = (w + exclusiveCount(acquires) > MAX_COUNT);
                    if (DroidSafeAndroidRuntime.control) throw new Error("Maximum lock count exceeded");
                } //End collapsed parenthetic
                setState(c + acquires);
            } //End block
            {
                boolean var33B66AF91B134BC4CCDF9A857D584490_1767202611 = (writerShouldBlock() ||
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.260 -0400", hash_original_method = "DCB6BD37D30DD1C1033C1677B2F2BA39", hash_generated_method = "02E289BAC110B138CEDF96DD5191A95F")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        protected final boolean tryReleaseShared(int unused) {
            dsTaint.addTaint(unused);
            Thread current;
            current = Thread.currentThread();
            {
                firstReader = null;
            } //End block
            {
                HoldCounter rh;
                rh = cachedHoldCounter;
                {
                    boolean var742A69B23BBDDB423EC138DCBB7B9545_1263514486 = (rh == null || rh.tid != current.getId());
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
                    boolean var525F59EF5A984E7DE1A679CCEEFC8101_345186863 = (compareAndSetState(c, nextc));
                } //End collapsed parenthetic
            } //End block
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.260 -0400", hash_original_method = "4AE7D8D2A940AB168E8F2908DE9ACCF1", hash_generated_method = "5B065E6CF80EDA77BC97B2AB22631810")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private IllegalMonitorStateException unmatchedUnlockException() {
            IllegalMonitorStateException var551572ACA2AB8CCCE34C25795FC4FB1B_1340718113 = (new IllegalMonitorStateException(
                "attempt to unlock read lock, not locked by current thread"));
            return (IllegalMonitorStateException)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new IllegalMonitorStateException(
                //"attempt to unlock read lock, not locked by current thread");
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.261 -0400", hash_original_method = "AD4C82A786111FF828AFE5FE5C8E5A39", hash_generated_method = "0C0577C756B5D6CC921F30E30B7EFFE6")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        protected final int tryAcquireShared(int unused) {
            dsTaint.addTaint(unused);
            Thread current;
            current = Thread.currentThread();
            int c;
            c = getState();
            {
                boolean varCBCE136FFBA6AA5474A803A63D00FAD1_2105009915 = (exclusiveCount(c) != 0 &&
                getExclusiveOwnerThread() != current);
            } //End collapsed parenthetic
            int r;
            r = sharedCount(c);
            {
                boolean varC705F9493B1FAEA076FDA3794FAA0183_1732107763 = (!readerShouldBlock() &&
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
                            boolean varDB55354BA83BD531EC70083B969F9FA7_1131136931 = (rh == null || rh.tid != current.getId());
                            cachedHoldCounter = rh = readHolds.get();
                            readHolds.set(rh);
                        } //End collapsed parenthetic
                    } //End block
                } //End block
            } //End collapsed parenthetic
            int var203CD572536C941A4B1A477F089EE192_1159501997 = (fullTryAcquireShared(current));
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.261 -0400", hash_original_method = "EBE8D8355B366068B4B1E29E3A9EED12", hash_generated_method = "B72E717CB3A8917E4F1144776F082AFC")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        final int fullTryAcquireShared(Thread current) {
            dsTaint.addTaint(current.dsTaint);
            HoldCounter rh;
            rh = null;
            {
                int c;
                c = getState();
                {
                    boolean var529468DC4620BDF65F6B6C7D22F44273_2026265762 = (exclusiveCount(c) != 0);
                    {
                        {
                            boolean varD3F580BFEF90DED8D0695E9E6E71809D_720872802 = (getExclusiveOwnerThread() != current);
                        } //End collapsed parenthetic
                    } //End block
                    {
                        boolean var860368E133590F744493740787A52E27_862453486 = (readerShouldBlock());
                        {
                            {
                                {
                                    rh = cachedHoldCounter;
                                    {
                                        boolean var84643B1DF9273A723910E3CDDBCE3609_1943914583 = (rh == null || rh.tid != current.getId());
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
                    boolean var81C9C11D2632075F5A3FC662D0DAC8FC_324825696 = (sharedCount(c) == MAX_COUNT);
                    if (DroidSafeAndroidRuntime.control) throw new Error("Maximum lock count exceeded");
                } //End collapsed parenthetic
                {
                    boolean varED20116B0BB1734240062BCE3EF53974_1505944999 = (compareAndSetState(c, c + SHARED_UNIT));
                    {
                        {
                            boolean varD8F1AA39FE8E689164014F966ADE2AC4_626501769 = (sharedCount(c) == 0);
                            {
                                firstReaderHoldCount = 1;
                            } //End block
                            {
                                rh = cachedHoldCounter;
                                {
                                    boolean var50B8EA88D62C62CC9B48E69494903B06_545970031 = (rh == null || rh.tid != current.getId());
                                    rh = readHolds.get();
                                    readHolds.set(rh);
                                } //End collapsed parenthetic
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.262 -0400", hash_original_method = "0DD6CA3D230AA260224A4A3AE8239ACB", hash_generated_method = "0BC0F59DC37A179A2252DD7CCFE38D64")
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
                    boolean var90979142887A20EB72C8964C86EB9321_950496794 = (w == 0 || current != getExclusiveOwnerThread());
                } //End collapsed parenthetic
                if (DroidSafeAndroidRuntime.control) throw new Error("Maximum lock count exceeded");
            } //End block
            {
                boolean var42EFECE5F4E2BBE5A5608C37A8B687F3_1352346242 = (!compareAndSetState(c, c + 1));
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.262 -0400", hash_original_method = "F864315749E9B3DD069E258F497DFE4D", hash_generated_method = "0BFAE6311706DC73A5C4B7B47D3040DA")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        final boolean tryReadLock() {
            Thread current;
            current = Thread.currentThread();
            {
                int c;
                c = getState();
                {
                    boolean varEA7F18DF3FD18041706E4732508BA651_1653241364 = (exclusiveCount(c) != 0 &&
                    getExclusiveOwnerThread() != current);
                } //End collapsed parenthetic
                int r;
                r = sharedCount(c);
                if (DroidSafeAndroidRuntime.control) throw new Error("Maximum lock count exceeded");
                {
                    boolean varED20116B0BB1734240062BCE3EF53974_1203900898 = (compareAndSetState(c, c + SHARED_UNIT));
                    {
                        {
                            firstReader = current;
                            firstReaderHoldCount = 1;
                        } //End block
                        {
                            HoldCounter rh;
                            rh = cachedHoldCounter;
                            {
                                boolean varD70438DD2BB853F7AACBE7CBC6449999_858731902 = (rh == null || rh.tid != current.getId());
                                cachedHoldCounter = rh = readHolds.get();
                                readHolds.set(rh);
                            } //End collapsed parenthetic
                        } //End block
                    } //End block
                } //End collapsed parenthetic
            } //End block
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.262 -0400", hash_original_method = "A843CC28FFAE9A089B89A0058BA2B9D5", hash_generated_method = "FC8B05B624890C5453DAAA4BE59CE895")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        protected final boolean isHeldExclusively() {
            boolean var3CE6B8DE56D5A33803435E843AACF76A_82137808 = (getExclusiveOwnerThread() == Thread.currentThread());
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return getExclusiveOwnerThread() == Thread.currentThread();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.262 -0400", hash_original_method = "093F0D0E6A279CA43864791B6FD65040", hash_generated_method = "80B57C21BC9B6486B025A2758AADB5E6")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        final ConditionObject newCondition() {
            ConditionObject var1FFAFF67C805BD7123742C98A74C613E_1948584059 = (new ConditionObject());
            return (ConditionObject)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new ConditionObject();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.263 -0400", hash_original_method = "3F3DE8BCF9BFC159EB93FF2ABA8024D7", hash_generated_method = "5103A48CDBE986C28D596B6CD51D6A91")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        final Thread getOwner() {
            Thread var39417DC900ADC99DDD05E344B96A3C7F_49813932 = (((exclusiveCount(getState()) == 0) ?
                    null :
                    getExclusiveOwnerThread())); //DSFIXME:  CODE0008: Nested ternary operator in expression
            return (Thread)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return ((exclusiveCount(getState()) == 0) ?
                    //null :
                    //getExclusiveOwnerThread());
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.263 -0400", hash_original_method = "0B84E22FFE55E13BE40413778559BE34", hash_generated_method = "8DA609D3CFE2E4BECFDC61DC0EC0DC61")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        final int getReadLockCount() {
            int var5073DFD1A27AB6C474CC24F8B7EC3CD3_1653067921 = (sharedCount(getState()));
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return sharedCount(getState());
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.263 -0400", hash_original_method = "09CA8B61F6450707C75BFC712569D4D4", hash_generated_method = "1EE8CD2499C4EC05A23EEABC0BC6ED5E")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        final boolean isWriteLocked() {
            boolean var01CAC84C2F38392161F4E16039D7DE44_1699356743 = (exclusiveCount(getState()) != 0);
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return exclusiveCount(getState()) != 0;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.263 -0400", hash_original_method = "67C0C583D90F5F49CAE0DBAE2DE27D59", hash_generated_method = "BA934014A9592998F3D17036A3C16B7D")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        final int getWriteHoldCount() {
            {
                boolean var34E827331B4BC7F16DFC99E8B4EE154E_986005388 = (isHeldExclusively());
                Object var0847481376D95B453E4DA8F62DB7ADA1_2127826805 = (exclusiveCount(getState()));
            } //End flattened ternary
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return isHeldExclusively() ? exclusiveCount(getState()) : 0;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.264 -0400", hash_original_method = "1DA1A38561287A101F5C2B623B00252F", hash_generated_method = "7CB6BCB9DB3DC4B73BE3F50AD00F5049")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        final int getReadHoldCount() {
            {
                boolean varCF77250596B8C839BEFAC301F344C853_1539406939 = (getReadLockCount() == 0);
            } //End collapsed parenthetic
            Thread current;
            current = Thread.currentThread();
            HoldCounter rh;
            rh = cachedHoldCounter;
            {
                boolean var12BC8C81E89FF6364E7C14D490B5B984_1263527972 = (rh != null && rh.tid == current.getId());
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.264 -0400", hash_original_method = "4E48396D4489DBF7E8DA7E593070FC82", hash_generated_method = "77A9A0860835128C896D3159F7901ACA")
        //DSFIXME:  CODE0002: Requires DSC value to be set
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.264 -0400", hash_original_method = "192D38E698A214D58DA93C3298AD6AD3", hash_generated_method = "834F53B18482DB4AA8EF473C673626F5")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        final int getCount() {
            int var376B5C2087169E76FB6628D31DCC9663_1117984391 = (getState());
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return getState();
        }

        
        static final class HoldCounter {
            int count = 0;
            long tid = Thread.currentThread().getId();
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.264 -0400", hash_original_method = "9BF9B02481F371479E1B1DE6FF430EA4", hash_generated_method = "9BF9B02481F371479E1B1DE6FF430EA4")
                        public HoldCounter ()
            {
            }


        }


        
        static final class ThreadLocalHoldCounter extends ThreadLocal<HoldCounter> {
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.264 -0400", hash_original_method = "207AF83F766FD5422C74D975790FE8E4", hash_generated_method = "207AF83F766FD5422C74D975790FE8E4")
                        public ThreadLocalHoldCounter ()
            {
            }


            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.264 -0400", hash_original_method = "65FB587992A751B61B2E99AB391905DE", hash_generated_method = "19C7A98A263F2CB01DFAA56A35F90F8A")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            public HoldCounter initialValue() {
                HoldCounter var455B68CBA7A0FB3F7FACF86AFE24F916_1318754059 = (new HoldCounter());
                return (HoldCounter)dsTaint.getTaint();
                // ---------- Original Method ----------
                //return new HoldCounter();
            }

            
        }


        
        private static final long serialVersionUID = 6317671515068378041L;
        static final int SHARED_SHIFT   = 16;
        static final int SHARED_UNIT    = (1 << SHARED_SHIFT);
        static final int MAX_COUNT      = (1 << SHARED_SHIFT) - 1;
        static final int EXCLUSIVE_MASK = (1 << SHARED_SHIFT) - 1;
    }


    
    static final class NonfairSync extends Sync {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.264 -0400", hash_original_method = "20DCF4B8D0A76106484C3A6D02F48055", hash_generated_method = "20DCF4B8D0A76106484C3A6D02F48055")
                public NonfairSync ()
        {
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.264 -0400", hash_original_method = "6099B514073B77A554543D2A2B955577", hash_generated_method = "33935F745759A60BB1AE44F68A1DFE4E")
        @DSModeled(DSC.SAFE)
        final boolean writerShouldBlock() {
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return false;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.265 -0400", hash_original_method = "311D59812186188137CBEED2258453A3", hash_generated_method = "26C95F30F7D909554B0E06EBD2B31AAE")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        final boolean readerShouldBlock() {
            boolean var42C6C6A77390D0F65AEC7AEAAD6B4F91_658618257 = (apparentlyFirstQueuedIsExclusive());
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return apparentlyFirstQueuedIsExclusive();
        }

        
        private static final long serialVersionUID = -8159625535654395037L;
    }


    
    static final class FairSync extends Sync {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.265 -0400", hash_original_method = "B5EC066612CC52332AC9D759710B6A7C", hash_generated_method = "B5EC066612CC52332AC9D759710B6A7C")
                public FairSync ()
        {
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.265 -0400", hash_original_method = "F04DB8A71B8ACD86834CABDF23C7982B", hash_generated_method = "ACDB2AEED832B0BB40E8A0425331A34D")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        final boolean writerShouldBlock() {
            boolean var5D9F3BF4621CB4A60B96236F06AF2405_1798314063 = (hasQueuedPredecessors());
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return hasQueuedPredecessors();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.265 -0400", hash_original_method = "5E806298851931D3FCAB2DE2F5A11624", hash_generated_method = "439A5932626384CFF3F55C7AC0681CA9")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        final boolean readerShouldBlock() {
            boolean var5D9F3BF4621CB4A60B96236F06AF2405_796761587 = (hasQueuedPredecessors());
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return hasQueuedPredecessors();
        }

        
        private static final long serialVersionUID = -2274990926593161451L;
    }


    
    public static class ReadLock implements Lock, java.io.Serializable {
        private Sync sync;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.265 -0400", hash_original_method = "86296C44CAAC51998FCC18AC6C334852", hash_generated_method = "CC837218F22245FC12B5B75E311F90DC")
        @DSModeled(DSC.SAFE)
        protected ReadLock(ReentrantReadWriteLock lock) {
            dsTaint.addTaint(lock.dsTaint);
            sync = lock.sync;
            // ---------- Original Method ----------
            //sync = lock.sync;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.265 -0400", hash_original_method = "8D72D73F25D8DE6C9209D04669F96039", hash_generated_method = "F147980700CF869A8D6F7133099FA372")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void lock() {
            sync.acquireShared(1);
            // ---------- Original Method ----------
            //sync.acquireShared(1);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.265 -0400", hash_original_method = "61D542FCA692219B5199CDDD1A71CCC6", hash_generated_method = "87CEA29C19FE66B6CBD3C0925E99729C")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void lockInterruptibly() throws InterruptedException {
            sync.acquireSharedInterruptibly(1);
            // ---------- Original Method ----------
            //sync.acquireSharedInterruptibly(1);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.266 -0400", hash_original_method = "6F9DD593410D3A6A5FB658A804C67B03", hash_generated_method = "E7BDCE6244312061447D3977CF661553")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public boolean tryLock() {
            boolean var82642F761C8CC4EFB1E9891565A562E0_1458909771 = (sync.tryReadLock());
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return sync.tryReadLock();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.266 -0400", hash_original_method = "CABC63B31BFC6EB1808F17E4FED50740", hash_generated_method = "B07A718EC87AFAB04C0479DA356F7180")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public boolean tryLock(long timeout, TimeUnit unit) throws InterruptedException {
            dsTaint.addTaint(unit.dsTaint);
            dsTaint.addTaint(timeout);
            boolean varC650725F0ACDDC932C370EDA1774172F_903758770 = (sync.tryAcquireSharedNanos(1, unit.toNanos(timeout)));
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return sync.tryAcquireSharedNanos(1, unit.toNanos(timeout));
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.266 -0400", hash_original_method = "2E2DA507FE1EE35FD0E649F791C4FA62", hash_generated_method = "CE7F47B976DC7C53582533934AC31AFE")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void unlock() {
            sync.releaseShared(1);
            // ---------- Original Method ----------
            //sync.releaseShared(1);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.266 -0400", hash_original_method = "9996D083DB29CA9E935A73F01FAD8A4F", hash_generated_method = "B9DE188E0B7FA124930DBB7D7D683C13")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public Condition newCondition() {
            if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
            return (Condition)dsTaint.getTaint();
            // ---------- Original Method ----------
            //throw new UnsupportedOperationException();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.266 -0400", hash_original_method = "4EA811A9ADBECD9416D19B5EBD75BF53", hash_generated_method = "4C12B1470E8F828BC62EDE2A3653FF23")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public String toString() {
            int r;
            r = sync.getReadLockCount();
            String var3174A7CB2D886E957C2AE3013EA3BEED_1528829009 = (super.toString() +
                "[Read locks = " + r + "]");
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //int r = sync.getReadLockCount();
            //return super.toString() +
                //"[Read locks = " + r + "]";
        }

        
        private static final long serialVersionUID = -5992448646407690164L;
    }


    
    public static class WriteLock implements Lock, java.io.Serializable {
        private Sync sync;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.266 -0400", hash_original_method = "2F59DA9CAF578BD2524C05A37F86DF01", hash_generated_method = "3D263CA8CF19CD6143EFFF873B6BB049")
        @DSModeled(DSC.SAFE)
        protected WriteLock(ReentrantReadWriteLock lock) {
            dsTaint.addTaint(lock.dsTaint);
            sync = lock.sync;
            // ---------- Original Method ----------
            //sync = lock.sync;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.267 -0400", hash_original_method = "4197ECA2CFEBBAA5B9BD7C840B7670C7", hash_generated_method = "DDE8BF3B445A2924BC3E70FCADFAA419")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void lock() {
            sync.acquire(1);
            // ---------- Original Method ----------
            //sync.acquire(1);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.267 -0400", hash_original_method = "5966BE77DAE264B5F21646B0E7A08FC1", hash_generated_method = "CFF689BB53A067D7B9EB5F12CA3F00CC")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void lockInterruptibly() throws InterruptedException {
            sync.acquireInterruptibly(1);
            // ---------- Original Method ----------
            //sync.acquireInterruptibly(1);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.267 -0400", hash_original_method = "55CC434A7054CDED1693C2BA6E1C81AA", hash_generated_method = "B00CAA70C40ECD150271CA9797C4D3D8")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public boolean tryLock( ) {
            boolean var55CFE4E4F15027819D6679D2F0F9E5EB_414397886 = (sync.tryWriteLock());
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return sync.tryWriteLock();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.267 -0400", hash_original_method = "6EF7D2E282F143C52CC20B0DBAA61A21", hash_generated_method = "2DB9CDEA027FBEE448632BD66953A240")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public boolean tryLock(long timeout, TimeUnit unit) throws InterruptedException {
            dsTaint.addTaint(unit.dsTaint);
            dsTaint.addTaint(timeout);
            boolean var4E766E765BA3F93DDE7082A08A077E42_1798108237 = (sync.tryAcquireNanos(1, unit.toNanos(timeout)));
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return sync.tryAcquireNanos(1, unit.toNanos(timeout));
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.267 -0400", hash_original_method = "7AD42B9E2BC6DD4A4DE0EB9EBA3A2515", hash_generated_method = "87142E80D82254348B0CA43367BBC9B7")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void unlock() {
            sync.release(1);
            // ---------- Original Method ----------
            //sync.release(1);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.267 -0400", hash_original_method = "6BB095C6835043568D960ACB9C15058D", hash_generated_method = "429E7CD56D90DDE1A62A22B412471270")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public Condition newCondition() {
            Condition var83DB6A69F4B6512F87D8CB6516ECC228_547563772 = (sync.newCondition());
            return (Condition)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return sync.newCondition();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.267 -0400", hash_original_method = "E0C199518E39715763AFB28F76F97305", hash_generated_method = "06C4BCDC0A0AF8ACDBEE207B7232E47B")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public String toString() {
            Thread o;
            o = sync.getOwner();
            String var942976EEB7D3D238D484789DF64377A1_623260860 = (super.toString() + ((o == null) ?
                                       "[Unlocked]" :
                                       "[Locked by thread " + o.getName() + "]")); //DSFIXME:  CODE0008: Nested ternary operator in expression
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //Thread o = sync.getOwner();
            //return super.toString() + ((o == null) ?
                                       //"[Unlocked]" :
                                       //"[Locked by thread " + o.getName() + "]");
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.268 -0400", hash_original_method = "53A74F7432D74C33316852C3E739832B", hash_generated_method = "321BFC6099B7CADCA91A258F7ACE37E5")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public boolean isHeldByCurrentThread() {
            boolean var8A9E5BF2F58F6E9DAF336A434F65DD91_1201399978 = (sync.isHeldExclusively());
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return sync.isHeldExclusively();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.268 -0400", hash_original_method = "17A37C9E70A2D6C131240856FD5B2099", hash_generated_method = "106A76681EA03A1A822A8806D576F727")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public int getHoldCount() {
            int varE800E928AAA5AF8116F9B878EB5C4BA2_1866912304 = (sync.getWriteHoldCount());
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return sync.getWriteHoldCount();
        }

        
        private static final long serialVersionUID = -4992448646407690164L;
    }


    
    private static final long serialVersionUID = -6992448646407690164L;
}

