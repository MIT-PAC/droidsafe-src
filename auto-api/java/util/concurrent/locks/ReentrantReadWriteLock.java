package java.util.concurrent.locks;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.util.concurrent.*;
import java.util.concurrent.atomic.*;
import java.util.*;

public class ReentrantReadWriteLock implements ReadWriteLock, java.io.Serializable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.889 -0400", hash_original_field = "53A68C354CA707EE3CF4135EF2B687CE", hash_generated_field = "8F79220737B731E52680B143D15FE029")

    private ReentrantReadWriteLock.ReadLock readerLock;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.889 -0400", hash_original_field = "D7F1DF52BEB3372136F52E8F5BBC02A3", hash_generated_field = "1E1067A0A17FE39A5B241BAB85413180")

    private ReentrantReadWriteLock.WriteLock writerLock;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.889 -0400", hash_original_field = "63AD9D34F3503826E5F649AE6B7AC92C", hash_generated_field = "791C2888A6F5CDC158445182FD1E3538")

    Sync sync;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.890 -0400", hash_original_method = "1C7ADE1C43258ED1B8231199DCC94C2F", hash_generated_method = "A2362B6FC27126ECCCC3F80E71268B1E")
    public  ReentrantReadWriteLock() {
        this(false);
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.890 -0400", hash_original_method = "A6CD875E912D33CADF6A81571C0A078B", hash_generated_method = "40472467CFFF2D78F76EB33BF5AABCCB")
    public  ReentrantReadWriteLock(boolean fair) {
        sync = fair ? new FairSync() : new NonfairSync();
        readerLock = new ReadLock(this);
        writerLock = new WriteLock(this);
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.890 -0400", hash_original_method = "0C7BC9C54BE00E03201ACF18B2913309", hash_generated_method = "02F0DE52E028FE70DE7167A2A559095A")
    public ReentrantReadWriteLock.WriteLock writeLock() {
        ReentrantReadWriteLock.WriteLock varB4EAC82CA7396A68D541C85D26508E83_2104056646 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_2104056646 = writerLock;
        varB4EAC82CA7396A68D541C85D26508E83_2104056646.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_2104056646;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.891 -0400", hash_original_method = "22D8B34ECDA1804C5F879E9731CF210D", hash_generated_method = "F8F94105818A859093206C95A404AA14")
    public ReentrantReadWriteLock.ReadLock readLock() {
        ReentrantReadWriteLock.ReadLock varB4EAC82CA7396A68D541C85D26508E83_164154840 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_164154840 = readerLock;
        varB4EAC82CA7396A68D541C85D26508E83_164154840.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_164154840;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.891 -0400", hash_original_method = "6835E283E5F9E7FBD3FF7844476992AD", hash_generated_method = "96B1D9232D3C34109B2F1E04EB5BF210")
    public final boolean isFair() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_525186820 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_525186820;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.892 -0400", hash_original_method = "DB009A0944F572B5167ED6D51E109787", hash_generated_method = "DD22B389DAD5C28EA714F40295A702EE")
    protected Thread getOwner() {
        Thread varB4EAC82CA7396A68D541C85D26508E83_1398104901 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1398104901 = sync.getOwner();
        varB4EAC82CA7396A68D541C85D26508E83_1398104901.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1398104901;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.892 -0400", hash_original_method = "BDA3BC7F9F6754233D710BB1E8BDA625", hash_generated_method = "80AC3B5029ADFDF37394BD285CB5F546")
    public int getReadLockCount() {
        int var5CF7DD4739FB0661883910CE3127C2D4_426195794 = (sync.getReadLockCount());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1581728947 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1581728947;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.892 -0400", hash_original_method = "D1234101A768FDEE737EDDFEC7DD19A3", hash_generated_method = "F41F21D16D175F1B6F856A6E73839B6C")
    public boolean isWriteLocked() {
        boolean varC09930903B4B15334864667BA6922CA7_104343493 = (sync.isWriteLocked());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1970202296 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1970202296;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.893 -0400", hash_original_method = "B77A8CC69384EA638697FDA5B4AC3CDF", hash_generated_method = "990FFDD1CD2ED4EB84B8EAEC7DEF194C")
    public boolean isWriteLockedByCurrentThread() {
        boolean var12281D4A72DEB9F8816A0A46604F1374_1865032738 = (sync.isHeldExclusively());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1259787129 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1259787129;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.893 -0400", hash_original_method = "F72E2C7B278B975FDBAAB080F7322122", hash_generated_method = "033C1BC929C394C00D0867DBF1A42A63")
    public int getWriteHoldCount() {
        int var4B7ADBEF86627032166821903A70F5D0_478209174 = (sync.getWriteHoldCount());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_889158947 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_889158947;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.893 -0400", hash_original_method = "026686F812EC7870B6E447136A7E8B3A", hash_generated_method = "E0EE31FF9B67896DE399BCC4CAF969D8")
    public int getReadHoldCount() {
        int var4CA9F99F5577509EFAE445B14D1ED825_264426307 = (sync.getReadHoldCount());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1878527881 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1878527881;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.894 -0400", hash_original_method = "2F9252966607830729245C7251D0E4B8", hash_generated_method = "F98CBBD87B63D7E7EDC241AD5B8F9591")
    protected Collection<Thread> getQueuedWriterThreads() {
        Collection<Thread> varB4EAC82CA7396A68D541C85D26508E83_1575893068 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1575893068 = sync.getExclusiveQueuedThreads();
        varB4EAC82CA7396A68D541C85D26508E83_1575893068.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1575893068;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.894 -0400", hash_original_method = "956CE594FDB46F8FEF252F1FDB068D3D", hash_generated_method = "4720E7ED081E728CCEB51A042EAD4196")
    protected Collection<Thread> getQueuedReaderThreads() {
        Collection<Thread> varB4EAC82CA7396A68D541C85D26508E83_2100815144 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_2100815144 = sync.getSharedQueuedThreads();
        varB4EAC82CA7396A68D541C85D26508E83_2100815144.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_2100815144;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.895 -0400", hash_original_method = "33B7DCC82A105082FC4D268ED56F9DE5", hash_generated_method = "1529499F81719D969BB65DD059C32F0E")
    public final boolean hasQueuedThreads() {
        boolean var4C0A0AB508905DA8D619627A5EEFD574_644313673 = (sync.hasQueuedThreads());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2043514597 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2043514597;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.895 -0400", hash_original_method = "7B179E46CDF5B520CCEEF15512EC2C63", hash_generated_method = "CEC105447175614D0D1F952686773202")
    public final boolean hasQueuedThread(Thread thread) {
        boolean var0681201A478D613CAAB4B4D5196C3EF3_922538667 = (sync.isQueued(thread));
        addTaint(thread.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_568956482 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_568956482;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.895 -0400", hash_original_method = "DFFF2C05339152644F00EC2FFC57EFB9", hash_generated_method = "D947DB5BAAEE4B9A2814F7087D1B1C45")
    public final int getQueueLength() {
        int var2545CC142A0CD1008911850681315651_76783963 = (sync.getQueueLength());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_22855580 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_22855580;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.895 -0400", hash_original_method = "4BC73C35668DA24636BE58FB68209032", hash_generated_method = "5DC66C6D17B77C9EE60ED93796C5E466")
    protected Collection<Thread> getQueuedThreads() {
        Collection<Thread> varB4EAC82CA7396A68D541C85D26508E83_1570873321 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1570873321 = sync.getQueuedThreads();
        varB4EAC82CA7396A68D541C85D26508E83_1570873321.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1570873321;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.896 -0400", hash_original_method = "BF91F0F13FB6E88A38744502E21F1F2D", hash_generated_method = "CBACC89A2C6717A921B6EE35FE1426EA")
    public boolean hasWaiters(Condition condition) {
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("not owner");
        boolean varD78146513D32810B85075F5879934833_1282369622 = (sync.hasWaiters((AbstractQueuedSynchronizer.ConditionObject)condition));
        addTaint(condition.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_523454465 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_523454465;
        
        
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.896 -0400", hash_original_method = "D4277B3B6ED39F705D915D3806A5548A", hash_generated_method = "F00E5063CE3575D2D0E6C94676489516")
    public int getWaitQueueLength(Condition condition) {
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("not owner");
        int var60A2F707F5BC43BB059D2028F4E4733B_1679868062 = (sync.getWaitQueueLength((AbstractQueuedSynchronizer.ConditionObject)condition));
        addTaint(condition.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1905763788 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1905763788;
        
        
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.896 -0400", hash_original_method = "29738EA386BFBB41E36C961DB4B1CBE5", hash_generated_method = "5190882875F79B0E81ABE150778FBD5B")
    protected Collection<Thread> getWaitingThreads(Condition condition) {
        Collection<Thread> varB4EAC82CA7396A68D541C85D26508E83_823153492 = null; 
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("not owner");
        varB4EAC82CA7396A68D541C85D26508E83_823153492 = sync.getWaitingThreads((AbstractQueuedSynchronizer.ConditionObject)condition);
        addTaint(condition.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_823153492.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_823153492;
        
        
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.897 -0400", hash_original_method = "03D5EBF343C873E095999F30626DADA2", hash_generated_method = "043CD1F78B43C067AC1311DDABAC4A1F")
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_195445621 = null; 
        int c = sync.getCount();
        int w = Sync.exclusiveCount(c);
        int r = Sync.sharedCount(c);
        varB4EAC82CA7396A68D541C85D26508E83_195445621 = super.toString() +
            "[Write locks = " + w + ", Read locks = " + r + "]";
        varB4EAC82CA7396A68D541C85D26508E83_195445621.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_195445621;
        
        
        
        
        
            
    }

    
    abstract static class Sync extends AbstractQueuedSynchronizer {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.897 -0400", hash_original_field = "E08C8E97570C1DCB9CD554FD7079B697", hash_generated_field = "8C4B3BD798FE5D7E8EB3D0536576D262")

        private transient ThreadLocalHoldCounter readHolds;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.897 -0400", hash_original_field = "DF91768C2D431EA735A71A6CE08F4181", hash_generated_field = "2EE67430D3D959E367F77E7EF6425C16")

        private transient HoldCounter cachedHoldCounter;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.897 -0400", hash_original_field = "AAA28B60505EF94BD4CA2E8CC3EC3C64", hash_generated_field = "A011FC8C4363F320801F082EF2C621C1")

        private transient Thread firstReader = null;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.897 -0400", hash_original_field = "64FF72C6AF21D3CE02435570D431F32C", hash_generated_field = "D6E4ACE63DE2E9B4DD29D78376D1F793")

        private transient int firstReaderHoldCount;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.897 -0400", hash_original_method = "89DA4D8EA92261B26BAB9F4AB5CDD482", hash_generated_method = "F96B116FAEB3CF7E52F47724A0D1064E")
          Sync() {
            readHolds = new ThreadLocalHoldCounter();
            setState(getState());
            
            
            
        }

        
        @DSModeled(DSC.SAFE)
        static int sharedCount(int c) {
            return c >>> SHARED_SHIFT;
        }

        
        @DSModeled(DSC.SAFE)
        static int exclusiveCount(int c) {
            return c & EXCLUSIVE_MASK;
        }

        
        abstract boolean readerShouldBlock();

        
        abstract boolean writerShouldBlock();

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.898 -0400", hash_original_method = "E2589B88E3FBFBAA4E5917277DEFE99E", hash_generated_method = "F7E1AF1FECA225061776AB653FA633C4")
        protected final boolean tryRelease(int releases) {
            {
                boolean varBDF0ABD2F20F8D3DCB5C83DB8D0ED9B5_506249592 = (!isHeldExclusively());
                if (DroidSafeAndroidRuntime.control) throw new IllegalMonitorStateException();
            } 
            int nextc = getState() - releases;
            boolean free = exclusiveCount(nextc) == 0;
            setExclusiveOwnerThread(null);
            setState(nextc);
            addTaint(releases);
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_270079993 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_270079993;
            
            
                
            
            
            
                
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.899 -0400", hash_original_method = "887DB434CE6AB550C72A17E01EAED908", hash_generated_method = "DFABC6D135C432449B8100B79A730889")
        protected final boolean tryAcquire(int acquires) {
            Thread current = Thread.currentThread();
            int c = getState();
            int w = exclusiveCount(c);
            {
                {
                    boolean var90979142887A20EB72C8964C86EB9321_723926211 = (w == 0 || current != getExclusiveOwnerThread());
                } 
                {
                    boolean var318575A0FEE61BCA2C1999503B3E7456_809182493 = (w + exclusiveCount(acquires) > MAX_COUNT);
                    if (DroidSafeAndroidRuntime.control) throw new Error("Maximum lock count exceeded");
                } 
                setState(c + acquires);
            } 
            {
                boolean var33B66AF91B134BC4CCDF9A857D584490_655289459 = (writerShouldBlock() ||
                !compareAndSetState(c, c + acquires));
            } 
            setExclusiveOwnerThread(current);
            addTaint(acquires);
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1076376642 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1076376642;
            
            
            
            
            
                
                    
                
                    
                
                
            
            
                
                
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.899 -0400", hash_original_method = "DCB6BD37D30DD1C1033C1677B2F2BA39", hash_generated_method = "905EA4F41AB5A9193D779C492D73F0CE")
        protected final boolean tryReleaseShared(int unused) {
            Thread current = Thread.currentThread();
            {
                firstReader = null;
            } 
            {
                HoldCounter rh = cachedHoldCounter;
                {
                    boolean var742A69B23BBDDB423EC138DCBB7B9545_1855534482 = (rh == null || rh.tid != current.getId());
                    rh = readHolds.get();
                } 
                int count = rh.count;
                {
                    readHolds.remove();
                    if (DroidSafeAndroidRuntime.control) throw unmatchedUnlockException();
                } 
            } 
            {
                int c = getState();
                int nextc = c - SHARED_UNIT;
                {
                    boolean var525F59EF5A984E7DE1A679CCEEFC8101_1116148746 = (compareAndSetState(c, nextc));
                } 
            } 
            addTaint(unused);
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1079383637 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1079383637;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.900 -0400", hash_original_method = "4AE7D8D2A940AB168E8F2908DE9ACCF1", hash_generated_method = "BAD2845E8D978EED7C5F4CC35A379E72")
        private IllegalMonitorStateException unmatchedUnlockException() {
            IllegalMonitorStateException varB4EAC82CA7396A68D541C85D26508E83_1699514260 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_1699514260 = new IllegalMonitorStateException(
                "attempt to unlock read lock, not locked by current thread");
            varB4EAC82CA7396A68D541C85D26508E83_1699514260.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1699514260;
            
            
                
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.900 -0400", hash_original_method = "AD4C82A786111FF828AFE5FE5C8E5A39", hash_generated_method = "FACFEB81372186EE3C17FAC91283AD35")
        protected final int tryAcquireShared(int unused) {
            Thread current = Thread.currentThread();
            int c = getState();
            {
                boolean varCBCE136FFBA6AA5474A803A63D00FAD1_1987496627 = (exclusiveCount(c) != 0 &&
                getExclusiveOwnerThread() != current);
            } 
            int r = sharedCount(c);
            {
                boolean varC705F9493B1FAEA076FDA3794FAA0183_1972523906 = (!readerShouldBlock() &&
                r < MAX_COUNT &&
                compareAndSetState(c, c + SHARED_UNIT));
                {
                    {
                        firstReader = current;
                        firstReaderHoldCount = 1;
                    } 
                    {
                        HoldCounter rh = cachedHoldCounter;
                        {
                            boolean varDB55354BA83BD531EC70083B969F9FA7_881096441 = (rh == null || rh.tid != current.getId());
                            cachedHoldCounter = rh = readHolds.get();
                            readHolds.set(rh);
                        } 
                    } 
                } 
            } 
            int var203CD572536C941A4B1A477F089EE192_1137287148 = (fullTryAcquireShared(current));
            addTaint(unused);
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_716635623 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_716635623;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.901 -0400", hash_original_method = "EBE8D8355B366068B4B1E29E3A9EED12", hash_generated_method = "6C8155A1A7D92AA880FC7BB062EA67BB")
        final int fullTryAcquireShared(Thread current) {
            HoldCounter rh = null;
            {
                int c = getState();
                {
                    boolean var529468DC4620BDF65F6B6C7D22F44273_574579985 = (exclusiveCount(c) != 0);
                    {
                        {
                            boolean varD3F580BFEF90DED8D0695E9E6E71809D_1951827905 = (getExclusiveOwnerThread() != current);
                        } 
                    } 
                    {
                        boolean var860368E133590F744493740787A52E27_173592117 = (readerShouldBlock());
                        {
                            {
                                {
                                    rh = cachedHoldCounter;
                                    {
                                        boolean var84643B1DF9273A723910E3CDDBCE3609_1775129863 = (rh == null || rh.tid != current.getId());
                                        {
                                            rh = readHolds.get();
                                            readHolds.remove();
                                        } 
                                    } 
                                } 
                            } 
                        } 
                    } 
                } 
                {
                    boolean var81C9C11D2632075F5A3FC662D0DAC8FC_90211954 = (sharedCount(c) == MAX_COUNT);
                    if (DroidSafeAndroidRuntime.control) throw new Error("Maximum lock count exceeded");
                } 
                {
                    boolean varED20116B0BB1734240062BCE3EF53974_754880157 = (compareAndSetState(c, c + SHARED_UNIT));
                    {
                        {
                            boolean varD8F1AA39FE8E689164014F966ADE2AC4_20178418 = (sharedCount(c) == 0);
                            {
                                firstReader = current;
                                firstReaderHoldCount = 1;
                            } 
                            {
                                rh = cachedHoldCounter;
                                {
                                    boolean var50B8EA88D62C62CC9B48E69494903B06_1456178365 = (rh == null || rh.tid != current.getId());
                                    rh = readHolds.get();
                                    readHolds.set(rh);
                                } 
                                cachedHoldCounter = rh;
                            } 
                        } 
                    } 
                } 
            } 
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1653396126 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1653396126;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.902 -0400", hash_original_method = "0DD6CA3D230AA260224A4A3AE8239ACB", hash_generated_method = "88FD0DC8B6265339817AC3DCED63A7E1")
        final boolean tryWriteLock() {
            Thread current = Thread.currentThread();
            int c = getState();
            {
                int w = exclusiveCount(c);
                {
                    boolean var90979142887A20EB72C8964C86EB9321_1727781594 = (w == 0 || current != getExclusiveOwnerThread());
                } 
                if (DroidSafeAndroidRuntime.control) throw new Error("Maximum lock count exceeded");
            } 
            {
                boolean var42EFECE5F4E2BBE5A5608C37A8B687F3_1332367954 = (!compareAndSetState(c, c + 1));
            } 
            setExclusiveOwnerThread(current);
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1638163916 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1638163916;
            
            
            
            
                
                
                    
                
                    
            
            
                
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.902 -0400", hash_original_method = "F864315749E9B3DD069E258F497DFE4D", hash_generated_method = "CC18D55A1AAE082F85493F6334D70A88")
        final boolean tryReadLock() {
            Thread current = Thread.currentThread();
            {
                int c = getState();
                {
                    boolean varEA7F18DF3FD18041706E4732508BA651_468002244 = (exclusiveCount(c) != 0 &&
                    getExclusiveOwnerThread() != current);
                } 
                int r = sharedCount(c);
                if (DroidSafeAndroidRuntime.control) throw new Error("Maximum lock count exceeded");
                {
                    boolean varED20116B0BB1734240062BCE3EF53974_726823565 = (compareAndSetState(c, c + SHARED_UNIT));
                    {
                        {
                            firstReader = current;
                            firstReaderHoldCount = 1;
                        } 
                        {
                            HoldCounter rh = cachedHoldCounter;
                            {
                                boolean varD70438DD2BB853F7AACBE7CBC6449999_308347420 = (rh == null || rh.tid != current.getId());
                                cachedHoldCounter = rh = readHolds.get();
                                readHolds.set(rh);
                            } 
                        } 
                    } 
                } 
            } 
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2121298172 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_2121298172;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.903 -0400", hash_original_method = "A843CC28FFAE9A089B89A0058BA2B9D5", hash_generated_method = "9AEC8162AD16FB8EEC639022C63EB98B")
        protected final boolean isHeldExclusively() {
            boolean var3CE6B8DE56D5A33803435E843AACF76A_1842819625 = (getExclusiveOwnerThread() == Thread.currentThread());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2143319314 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_2143319314;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.904 -0400", hash_original_method = "093F0D0E6A279CA43864791B6FD65040", hash_generated_method = "A02108D276CE90C5381912DB252AB6F1")
        final ConditionObject newCondition() {
            ConditionObject varB4EAC82CA7396A68D541C85D26508E83_437747717 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_437747717 = new ConditionObject();
            varB4EAC82CA7396A68D541C85D26508E83_437747717.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_437747717;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.905 -0400", hash_original_method = "3F3DE8BCF9BFC159EB93FF2ABA8024D7", hash_generated_method = "34D310B93F552000EF67B9A6A5036583")
        final Thread getOwner() {
            Thread varB4EAC82CA7396A68D541C85D26508E83_993968735 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_993968735 = ((exclusiveCount(getState()) == 0) ?
                    null :
                    getExclusiveOwnerThread());
            varB4EAC82CA7396A68D541C85D26508E83_993968735.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_993968735;
            
            
                    
                    
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.905 -0400", hash_original_method = "0B84E22FFE55E13BE40413778559BE34", hash_generated_method = "D588BAB1BE118ED84053C5B709197198")
        final int getReadLockCount() {
            int var5073DFD1A27AB6C474CC24F8B7EC3CD3_169377317 = (sharedCount(getState()));
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2050361991 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2050361991;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.906 -0400", hash_original_method = "09CA8B61F6450707C75BFC712569D4D4", hash_generated_method = "8E4DCBF4A4CC9F792F8C84E3D7B2E675")
        final boolean isWriteLocked() {
            boolean var01CAC84C2F38392161F4E16039D7DE44_1211481157 = (exclusiveCount(getState()) != 0);
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1818489978 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1818489978;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.906 -0400", hash_original_method = "67C0C583D90F5F49CAE0DBAE2DE27D59", hash_generated_method = "94A850C068380510EDEDB586913E26F0")
        final int getWriteHoldCount() {
            {
                boolean var34E827331B4BC7F16DFC99E8B4EE154E_555884148 = (isHeldExclusively());
                Object var0847481376D95B453E4DA8F62DB7ADA1_1897575864 = (exclusiveCount(getState()));
            } 
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1865702247 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1865702247;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.907 -0400", hash_original_method = "1DA1A38561287A101F5C2B623B00252F", hash_generated_method = "436C67287CDE52CF465BA737048A23AB")
        final int getReadHoldCount() {
            {
                boolean varCF77250596B8C839BEFAC301F344C853_754074966 = (getReadLockCount() == 0);
            } 
            Thread current = Thread.currentThread();
            HoldCounter rh = cachedHoldCounter;
            {
                boolean var12BC8C81E89FF6364E7C14D490B5B984_1556015295 = (rh != null && rh.tid == current.getId());
            } 
            int count = readHolds.get().count;
            readHolds.remove();
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_447751123 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_447751123;
            
            
                
            
            
                
            
            
                
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.907 -0400", hash_original_method = "4E48396D4489DBF7E8DA7E593070FC82", hash_generated_method = "32B8CD4904A66075F3560379D9DD0971")
        private void readObject(java.io.ObjectInputStream s) throws java.io.IOException, ClassNotFoundException {
            s.defaultReadObject();
            readHolds = new ThreadLocalHoldCounter();
            setState(0);
            addTaint(s.getTaint());
            
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.908 -0400", hash_original_method = "192D38E698A214D58DA93C3298AD6AD3", hash_generated_method = "1D76F311E7A10EC40725F288B597A073")
        final int getCount() {
            int var376B5C2087169E76FB6628D31DCC9663_834313824 = (getState());
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_809304763 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_809304763;
            
            
        }

        
        static final class HoldCounter {
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.908 -0400", hash_original_field = "B1F8A23315AB697B67E425C4B5F81545", hash_generated_field = "B524E41AA0CF6AD39267F32C8C687778")

            int count = 0;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.908 -0400", hash_original_field = "A7CAC231571D7123EBB48A8647C318F9", hash_generated_field = "B08EBA558D35D7351A04ACA0D52B3632")

            final long tid = Thread.currentThread().getId();
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.908 -0400", hash_original_method = "F1D8E352EDEF0AB237A69949FE7423C4", hash_generated_method = "F1D8E352EDEF0AB237A69949FE7423C4")
            public HoldCounter ()
            {
                
            }


        }


        
        static final class ThreadLocalHoldCounter extends ThreadLocal<HoldCounter> {
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.908 -0400", hash_original_method = "2811BFD99460ECBD8E7948B925FFB736", hash_generated_method = "2811BFD99460ECBD8E7948B925FFB736")
            public ThreadLocalHoldCounter ()
            {
                
            }


            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.908 -0400", hash_original_method = "65FB587992A751B61B2E99AB391905DE", hash_generated_method = "01F792024FBC2F93A85AE31E7F31DDE3")
            public HoldCounter initialValue() {
                HoldCounter varB4EAC82CA7396A68D541C85D26508E83_379640942 = null; 
                varB4EAC82CA7396A68D541C85D26508E83_379640942 = new HoldCounter();
                varB4EAC82CA7396A68D541C85D26508E83_379640942.addTaint(getTaint()); 
                return varB4EAC82CA7396A68D541C85D26508E83_379640942;
                
                
            }

            
        }


        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.908 -0400", hash_original_field = "F661B57F5D85B8C55CBF8EC6C1332293", hash_generated_field = "7C931A0AA0CAF43860EA5D05E5F8B303")

        private static final long serialVersionUID = 6317671515068378041L;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.909 -0400", hash_original_field = "84B1E483133CB506AF0F344691E6DF0D", hash_generated_field = "1BECA78E8EF9C81EDFA90AF6033A5F51")

        static final int SHARED_SHIFT = 16;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.909 -0400", hash_original_field = "24C85CCC5E848FE7AAEF439B797AF477", hash_generated_field = "C8AB687482F52B5D1545D9BC8249F0D6")

        static final int SHARED_UNIT = (1 << SHARED_SHIFT);
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.909 -0400", hash_original_field = "2A4F653E74D03DB9FBF055439C642017", hash_generated_field = "921A8713594E39243E9A93B111B6F582")

        static final int MAX_COUNT = (1 << SHARED_SHIFT) - 1;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.909 -0400", hash_original_field = "36C9424C451B233CA56EB28EF0E91CDB", hash_generated_field = "060B47E79661495F6885046EB813A43B")

        static final int EXCLUSIVE_MASK = (1 << SHARED_SHIFT) - 1;
    }


    
    static final class NonfairSync extends Sync {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.909 -0400", hash_original_method = "92700F1FF079627760B83F1F338B8E6E", hash_generated_method = "92700F1FF079627760B83F1F338B8E6E")
        public NonfairSync ()
        {
            
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.909 -0400", hash_original_method = "6099B514073B77A554543D2A2B955577", hash_generated_method = "3E2FBD73C605DD84477EBF4BC00FC3E4")
        final boolean writerShouldBlock() {
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_565596818 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_565596818;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.909 -0400", hash_original_method = "311D59812186188137CBEED2258453A3", hash_generated_method = "005FE5D6C771AFE13AE687330FA47758")
        final boolean readerShouldBlock() {
            boolean var42C6C6A77390D0F65AEC7AEAAD6B4F91_529909789 = (apparentlyFirstQueuedIsExclusive());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_176629331 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_176629331;
            
            
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.909 -0400", hash_original_field = "962FC793F1AA6943131BF3E9C77AA5E7", hash_generated_field = "F3A4EB2F8018DB6E004273D21E41E16C")

        private static final long serialVersionUID = -8159625535654395037L;
    }


    
    static final class FairSync extends Sync {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.909 -0400", hash_original_method = "76BFFA90730B34917875BAE48AE8B396", hash_generated_method = "76BFFA90730B34917875BAE48AE8B396")
        public FairSync ()
        {
            
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.910 -0400", hash_original_method = "F04DB8A71B8ACD86834CABDF23C7982B", hash_generated_method = "8BA1887C83C8B49A8189032F39F312D0")
        final boolean writerShouldBlock() {
            boolean var5D9F3BF4621CB4A60B96236F06AF2405_1018758611 = (hasQueuedPredecessors());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_235305711 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_235305711;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.910 -0400", hash_original_method = "5E806298851931D3FCAB2DE2F5A11624", hash_generated_method = "3220FF54DBF7D47F58AA223A65794612")
        final boolean readerShouldBlock() {
            boolean var5D9F3BF4621CB4A60B96236F06AF2405_1895652621 = (hasQueuedPredecessors());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1959059979 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1959059979;
            
            
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.910 -0400", hash_original_field = "789C476CB4886D7F76862344BE9A6172", hash_generated_field = "076791917E0837F6FCF483EA9968303D")

        private static final long serialVersionUID = -2274990926593161451L;
    }


    
    public static class ReadLock implements Lock, java.io.Serializable {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.910 -0400", hash_original_field = "63AD9D34F3503826E5F649AE6B7AC92C", hash_generated_field = "A4B34EF3CE38520839B34A2F06599243")

        private Sync sync;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.910 -0400", hash_original_method = "86296C44CAAC51998FCC18AC6C334852", hash_generated_method = "90987B1257AE5908AD98C331E68E3B50")
        protected  ReadLock(ReentrantReadWriteLock lock) {
            sync = lock.sync;
            
            
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.911 -0400", hash_original_method = "8D72D73F25D8DE6C9209D04669F96039", hash_generated_method = "F147980700CF869A8D6F7133099FA372")
        public void lock() {
            sync.acquireShared(1);
            
            
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.911 -0400", hash_original_method = "61D542FCA692219B5199CDDD1A71CCC6", hash_generated_method = "87CEA29C19FE66B6CBD3C0925E99729C")
        public void lockInterruptibly() throws InterruptedException {
            sync.acquireSharedInterruptibly(1);
            
            
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.911 -0400", hash_original_method = "6F9DD593410D3A6A5FB658A804C67B03", hash_generated_method = "44F333F28A76623D315ACEE0B5176228")
        public boolean tryLock() {
            boolean var82642F761C8CC4EFB1E9891565A562E0_1460524610 = (sync.tryReadLock());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1931539667 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1931539667;
            
            
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.911 -0400", hash_original_method = "CABC63B31BFC6EB1808F17E4FED50740", hash_generated_method = "58EF80D699BD461388CE8F42DA6A82E9")
        public boolean tryLock(long timeout, TimeUnit unit) throws InterruptedException {
            boolean varC650725F0ACDDC932C370EDA1774172F_1179307705 = (sync.tryAcquireSharedNanos(1, unit.toNanos(timeout)));
            addTaint(timeout);
            addTaint(unit.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_894105286 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_894105286;
            
            
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.912 -0400", hash_original_method = "2E2DA507FE1EE35FD0E649F791C4FA62", hash_generated_method = "CE7F47B976DC7C53582533934AC31AFE")
        public void unlock() {
            sync.releaseShared(1);
            
            
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.912 -0400", hash_original_method = "9996D083DB29CA9E935A73F01FAD8A4F", hash_generated_method = "AA6177806CFC2176E106167AD695F2AC")
        public Condition newCondition() {
        	throw new UnsupportedOperationException();
            
            
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.913 -0400", hash_original_method = "4EA811A9ADBECD9416D19B5EBD75BF53", hash_generated_method = "4057578D00BADBA337466D741FF16977")
        public String toString() {
            String varB4EAC82CA7396A68D541C85D26508E83_2074920168 = null; 
            int r = sync.getReadLockCount();
            varB4EAC82CA7396A68D541C85D26508E83_2074920168 = super.toString() +
                "[Read locks = " + r + "]";
            varB4EAC82CA7396A68D541C85D26508E83_2074920168.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_2074920168;
            
            
            
                
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.913 -0400", hash_original_field = "379AEE3B0AE7E3AB2A711C689B7C790D", hash_generated_field = "86BBAC3B6DE594ADDDD3BFD814E519BB")

        private static final long serialVersionUID = -5992448646407690164L;
    }


    
    public static class WriteLock implements Lock, java.io.Serializable {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.913 -0400", hash_original_field = "63AD9D34F3503826E5F649AE6B7AC92C", hash_generated_field = "A4B34EF3CE38520839B34A2F06599243")

        private Sync sync;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.913 -0400", hash_original_method = "2F59DA9CAF578BD2524C05A37F86DF01", hash_generated_method = "A7C2CC6406BCF200D20C7B5AD2A21C1A")
        protected  WriteLock(ReentrantReadWriteLock lock) {
            sync = lock.sync;
            
            
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.913 -0400", hash_original_method = "4197ECA2CFEBBAA5B9BD7C840B7670C7", hash_generated_method = "DDE8BF3B445A2924BC3E70FCADFAA419")
        public void lock() {
            sync.acquire(1);
            
            
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.914 -0400", hash_original_method = "5966BE77DAE264B5F21646B0E7A08FC1", hash_generated_method = "CFF689BB53A067D7B9EB5F12CA3F00CC")
        public void lockInterruptibly() throws InterruptedException {
            sync.acquireInterruptibly(1);
            
            
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.914 -0400", hash_original_method = "55CC434A7054CDED1693C2BA6E1C81AA", hash_generated_method = "ED1593926054BFBB9C7DC074297BB3CA")
        public boolean tryLock( ) {
            boolean var55CFE4E4F15027819D6679D2F0F9E5EB_984744023 = (sync.tryWriteLock());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_533279639 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_533279639;
            
            
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.914 -0400", hash_original_method = "6EF7D2E282F143C52CC20B0DBAA61A21", hash_generated_method = "AAC9227DB0ACEC4AA7C0A25534538B1D")
        public boolean tryLock(long timeout, TimeUnit unit) throws InterruptedException {
            boolean var4E766E765BA3F93DDE7082A08A077E42_292888309 = (sync.tryAcquireNanos(1, unit.toNanos(timeout)));
            addTaint(timeout);
            addTaint(unit.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_28801339 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_28801339;
            
            
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.915 -0400", hash_original_method = "7AD42B9E2BC6DD4A4DE0EB9EBA3A2515", hash_generated_method = "87142E80D82254348B0CA43367BBC9B7")
        public void unlock() {
            sync.release(1);
            
            
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.915 -0400", hash_original_method = "6BB095C6835043568D960ACB9C15058D", hash_generated_method = "758CE82BBE867E5AD1DBA08A4D6D8DBD")
        public Condition newCondition() {
            Condition varB4EAC82CA7396A68D541C85D26508E83_341202708 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_341202708 = sync.newCondition();
            varB4EAC82CA7396A68D541C85D26508E83_341202708.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_341202708;
            
            
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.916 -0400", hash_original_method = "E0C199518E39715763AFB28F76F97305", hash_generated_method = "11B2F9A03E0014E2E295E38B891D6D35")
        public String toString() {
            String varB4EAC82CA7396A68D541C85D26508E83_1480566140 = null; 
            Thread o = sync.getOwner();
            varB4EAC82CA7396A68D541C85D26508E83_1480566140 = super.toString() + ((o == null) ?
                                       "[Unlocked]" :
                                       "[Locked by thread " + o.getName() + "]");
            varB4EAC82CA7396A68D541C85D26508E83_1480566140.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1480566140;
            
            
            
                                       
                                       
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.916 -0400", hash_original_method = "53A74F7432D74C33316852C3E739832B", hash_generated_method = "6937A0A4897F0274226B7BA4E7128290")
        public boolean isHeldByCurrentThread() {
            boolean var8A9E5BF2F58F6E9DAF336A434F65DD91_613493350 = (sync.isHeldExclusively());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1653087667 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1653087667;
            
            
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.917 -0400", hash_original_method = "17A37C9E70A2D6C131240856FD5B2099", hash_generated_method = "BC18300DABBA37B0A2B8D574349BC9D2")
        public int getHoldCount() {
            int varE800E928AAA5AF8116F9B878EB5C4BA2_1299672044 = (sync.getWriteHoldCount());
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1352566918 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1352566918;
            
            
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.917 -0400", hash_original_field = "39DE0FFFDCAA0428C698758AE0E7E3D8", hash_generated_field = "91D8216ACB8E5ABFDC6C81788A99A4AB")

        private static final long serialVersionUID = -4992448646407690164L;
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.917 -0400", hash_original_field = "ACC5AACF11B6B32C6C9167A3DD56327E", hash_generated_field = "97706C97453A3073601BD3C0219ECA94")

    private static final long serialVersionUID = -6992448646407690164L;
}

