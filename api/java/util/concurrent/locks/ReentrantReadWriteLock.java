package java.util.concurrent.locks;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.*;
import java.util.*;

public class ReentrantReadWriteLock implements ReadWriteLock, java.io.Serializable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:17.613 -0400", hash_original_field = "53A68C354CA707EE3CF4135EF2B687CE", hash_generated_field = "8F79220737B731E52680B143D15FE029")

    private ReentrantReadWriteLock.ReadLock readerLock;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:17.613 -0400", hash_original_field = "D7F1DF52BEB3372136F52E8F5BBC02A3", hash_generated_field = "1E1067A0A17FE39A5B241BAB85413180")

    private ReentrantReadWriteLock.WriteLock writerLock;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:17.613 -0400", hash_original_field = "63AD9D34F3503826E5F649AE6B7AC92C", hash_generated_field = "791C2888A6F5CDC158445182FD1E3538")

    Sync sync;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:17.613 -0400", hash_original_method = "1C7ADE1C43258ED1B8231199DCC94C2F", hash_generated_method = "A2362B6FC27126ECCCC3F80E71268B1E")
    public  ReentrantReadWriteLock() {
        this(false);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:17.614 -0400", hash_original_method = "A6CD875E912D33CADF6A81571C0A078B", hash_generated_method = "40472467CFFF2D78F76EB33BF5AABCCB")
    public  ReentrantReadWriteLock(boolean fair) {
        sync = fair ? new FairSync() : new NonfairSync();
        readerLock = new ReadLock(this);
        writerLock = new WriteLock(this);
        // ---------- Original Method ----------
        //sync = fair ? new FairSync() : new NonfairSync();
        //readerLock = new ReadLock(this);
        //writerLock = new WriteLock(this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:17.614 -0400", hash_original_method = "0C7BC9C54BE00E03201ACF18B2913309", hash_generated_method = "E2488D3B7CEE1489E46B213462ACDB08")
    public ReentrantReadWriteLock.WriteLock writeLock() {
ReentrantReadWriteLock.WriteLock var2DE2F4E52EACF7C4842927B76B85571D_169347648 =         writerLock;
        var2DE2F4E52EACF7C4842927B76B85571D_169347648.addTaint(taint);
        return var2DE2F4E52EACF7C4842927B76B85571D_169347648;
        // ---------- Original Method ----------
        //return writerLock;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:17.614 -0400", hash_original_method = "22D8B34ECDA1804C5F879E9731CF210D", hash_generated_method = "8CC0A13FE71E6FB0FB9E29EC92B393FE")
    public ReentrantReadWriteLock.ReadLock readLock() {
ReentrantReadWriteLock.ReadLock var5BE94CD16DAA35A039203EEB9FA0E80B_1787539266 =         readerLock;
        var5BE94CD16DAA35A039203EEB9FA0E80B_1787539266.addTaint(taint);
        return var5BE94CD16DAA35A039203EEB9FA0E80B_1787539266;
        // ---------- Original Method ----------
        //return readerLock;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:17.614 -0400", hash_original_method = "6835E283E5F9E7FBD3FF7844476992AD", hash_generated_method = "320DA3A815A2B1669E5AB10C74D17CAB")
    public final boolean isFair() {
        boolean var025994C1DF49233538C6DF8BADB9C6C8_255947730 = (sync instanceof FairSync);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_97999379 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_97999379;
        // ---------- Original Method ----------
        //return sync instanceof FairSync;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:17.614 -0400", hash_original_method = "DB009A0944F572B5167ED6D51E109787", hash_generated_method = "2CC89308131ACC23BD303F2D4060175B")
    protected Thread getOwner() {
Thread var86C22E9219AA4C3398E9F9B969B294CC_851277807 =         sync.getOwner();
        var86C22E9219AA4C3398E9F9B969B294CC_851277807.addTaint(taint);
        return var86C22E9219AA4C3398E9F9B969B294CC_851277807;
        // ---------- Original Method ----------
        //return sync.getOwner();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:17.614 -0400", hash_original_method = "BDA3BC7F9F6754233D710BB1E8BDA625", hash_generated_method = "E34CC0BED0C346DB3C5E9CC44FDCA095")
    public int getReadLockCount() {
        int varA99EE35B51F0F2DF006576AC95F9ADA6_1340669888 = (sync.getReadLockCount());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_493663608 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_493663608;
        // ---------- Original Method ----------
        //return sync.getReadLockCount();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:17.614 -0400", hash_original_method = "D1234101A768FDEE737EDDFEC7DD19A3", hash_generated_method = "88F080247723090635E66431E38D12CE")
    public boolean isWriteLocked() {
        boolean varFC73878F4C438ED33B893BF2A76C07F9_1760238813 = (sync.isWriteLocked());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1868552035 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1868552035;
        // ---------- Original Method ----------
        //return sync.isWriteLocked();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:17.614 -0400", hash_original_method = "B77A8CC69384EA638697FDA5B4AC3CDF", hash_generated_method = "59131B053A56DE3BAA95A49A3F8D422F")
    public boolean isWriteLockedByCurrentThread() {
        boolean var67B4017CD59F5DDCE7498E8483F9CFB0_1648264369 = (sync.isHeldExclusively());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2093097671 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2093097671;
        // ---------- Original Method ----------
        //return sync.isHeldExclusively();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:17.615 -0400", hash_original_method = "F72E2C7B278B975FDBAAB080F7322122", hash_generated_method = "D4A51F2F2DDCDC7C3792F0D3D887580D")
    public int getWriteHoldCount() {
        int var5794AF85D7E920F501BF42909C7CD874_1906583132 = (sync.getWriteHoldCount());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1314805084 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1314805084;
        // ---------- Original Method ----------
        //return sync.getWriteHoldCount();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:17.615 -0400", hash_original_method = "026686F812EC7870B6E447136A7E8B3A", hash_generated_method = "C9AE475D882D873E1FD683F87D2B0F93")
    public int getReadHoldCount() {
        int var06FDCE51CDFD5B28DD05E89AC333B157_1023223192 = (sync.getReadHoldCount());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1460583622 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1460583622;
        // ---------- Original Method ----------
        //return sync.getReadHoldCount();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:17.615 -0400", hash_original_method = "2F9252966607830729245C7251D0E4B8", hash_generated_method = "60335767C76EA58CDCD1B0EB26B73810")
    protected Collection<Thread> getQueuedWriterThreads() {
Collection<Thread> var1559DAC9B49273E234BA87CC54E0EFE0_1877416886 =         sync.getExclusiveQueuedThreads();
        var1559DAC9B49273E234BA87CC54E0EFE0_1877416886.addTaint(taint);
        return var1559DAC9B49273E234BA87CC54E0EFE0_1877416886;
        // ---------- Original Method ----------
        //return sync.getExclusiveQueuedThreads();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:17.615 -0400", hash_original_method = "956CE594FDB46F8FEF252F1FDB068D3D", hash_generated_method = "967EA1F58BEA902ED145229999D7D3B6")
    protected Collection<Thread> getQueuedReaderThreads() {
Collection<Thread> varF06E14FD6FBDA129EEF8BF14240D9D47_2128833292 =         sync.getSharedQueuedThreads();
        varF06E14FD6FBDA129EEF8BF14240D9D47_2128833292.addTaint(taint);
        return varF06E14FD6FBDA129EEF8BF14240D9D47_2128833292;
        // ---------- Original Method ----------
        //return sync.getSharedQueuedThreads();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:17.615 -0400", hash_original_method = "33B7DCC82A105082FC4D268ED56F9DE5", hash_generated_method = "83F5FB1BC5278B5D8EFB9FD11997134D")
    public final boolean hasQueuedThreads() {
        boolean var2967874652C8008E25540A916154E044_1537999966 = (sync.hasQueuedThreads());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1899948370 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1899948370;
        // ---------- Original Method ----------
        //return sync.hasQueuedThreads();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:17.616 -0400", hash_original_method = "7B179E46CDF5B520CCEEF15512EC2C63", hash_generated_method = "0D11D8EBF30DDA6EECCFB722D83FD9F9")
    public final boolean hasQueuedThread(Thread thread) {
        addTaint(thread.getTaint());
        boolean var9BB5C27E049EB33FD7FBCB6CC83C36FE_109588709 = (sync.isQueued(thread));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_844865816 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_844865816;
        // ---------- Original Method ----------
        //return sync.isQueued(thread);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:17.616 -0400", hash_original_method = "DFFF2C05339152644F00EC2FFC57EFB9", hash_generated_method = "5706A7061DDA93CDC5DEF406903E74F6")
    public final int getQueueLength() {
        int var5D329306F1180332B8FF4C47065D325F_2007278061 = (sync.getQueueLength());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1965160456 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1965160456;
        // ---------- Original Method ----------
        //return sync.getQueueLength();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:17.616 -0400", hash_original_method = "4BC73C35668DA24636BE58FB68209032", hash_generated_method = "A8AA2DA175A94E8F3A9EC9F0D15F133C")
    protected Collection<Thread> getQueuedThreads() {
Collection<Thread> var0FD62A6A977BE381AD6B1EE70126B5BB_2074406104 =         sync.getQueuedThreads();
        var0FD62A6A977BE381AD6B1EE70126B5BB_2074406104.addTaint(taint);
        return var0FD62A6A977BE381AD6B1EE70126B5BB_2074406104;
        // ---------- Original Method ----------
        //return sync.getQueuedThreads();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:17.616 -0400", hash_original_method = "BF91F0F13FB6E88A38744502E21F1F2D", hash_generated_method = "1EF9325EBE9161FB67A7D1603A50C036")
    public boolean hasWaiters(Condition condition) {
        addTaint(condition.getTaint());
    if(condition == null)        
        {
        NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_191692006 = new NullPointerException();
        var7338BC9F48D81FE0BBD6183F4014DCC4_191692006.addTaint(taint);
        throw var7338BC9F48D81FE0BBD6183F4014DCC4_191692006;
        }
    if(!(condition instanceof AbstractQueuedSynchronizer.ConditionObject))        
        {
        IllegalArgumentException varB8792231CD1EFCF3C5A33149431219B9_444973656 = new IllegalArgumentException("not owner");
        varB8792231CD1EFCF3C5A33149431219B9_444973656.addTaint(taint);
        throw varB8792231CD1EFCF3C5A33149431219B9_444973656;
        }
        boolean var23C1F5BEB670AD3A3B37230CF45D76AD_2020329262 = (sync.hasWaiters((AbstractQueuedSynchronizer.ConditionObject)condition));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_914595485 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_914595485;
        // ---------- Original Method ----------
        //if (condition == null)
            //throw new NullPointerException();
        //if (!(condition instanceof AbstractQueuedSynchronizer.ConditionObject))
            //throw new IllegalArgumentException("not owner");
        //return sync.hasWaiters((AbstractQueuedSynchronizer.ConditionObject)condition);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:17.617 -0400", hash_original_method = "D4277B3B6ED39F705D915D3806A5548A", hash_generated_method = "90ABB89E286A102821B89388ED5F34C0")
    public int getWaitQueueLength(Condition condition) {
        addTaint(condition.getTaint());
    if(condition == null)        
        {
        NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_372793747 = new NullPointerException();
        var7338BC9F48D81FE0BBD6183F4014DCC4_372793747.addTaint(taint);
        throw var7338BC9F48D81FE0BBD6183F4014DCC4_372793747;
        }
    if(!(condition instanceof AbstractQueuedSynchronizer.ConditionObject))        
        {
        IllegalArgumentException varB8792231CD1EFCF3C5A33149431219B9_1907841987 = new IllegalArgumentException("not owner");
        varB8792231CD1EFCF3C5A33149431219B9_1907841987.addTaint(taint);
        throw varB8792231CD1EFCF3C5A33149431219B9_1907841987;
        }
        int varD6C0E0468A7445023DCDBF050BDCAFA0_1541119479 = (sync.getWaitQueueLength((AbstractQueuedSynchronizer.ConditionObject)condition));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2000921552 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2000921552;
        // ---------- Original Method ----------
        //if (condition == null)
            //throw new NullPointerException();
        //if (!(condition instanceof AbstractQueuedSynchronizer.ConditionObject))
            //throw new IllegalArgumentException("not owner");
        //return sync.getWaitQueueLength((AbstractQueuedSynchronizer.ConditionObject)condition);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:17.617 -0400", hash_original_method = "29738EA386BFBB41E36C961DB4B1CBE5", hash_generated_method = "DD0638E1CD75D76D3B4974769FF7EC3E")
    protected Collection<Thread> getWaitingThreads(Condition condition) {
        addTaint(condition.getTaint());
    if(condition == null)        
        {
        NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_1778398394 = new NullPointerException();
        var7338BC9F48D81FE0BBD6183F4014DCC4_1778398394.addTaint(taint);
        throw var7338BC9F48D81FE0BBD6183F4014DCC4_1778398394;
        }
    if(!(condition instanceof AbstractQueuedSynchronizer.ConditionObject))        
        {
        IllegalArgumentException varB8792231CD1EFCF3C5A33149431219B9_1268324364 = new IllegalArgumentException("not owner");
        varB8792231CD1EFCF3C5A33149431219B9_1268324364.addTaint(taint);
        throw varB8792231CD1EFCF3C5A33149431219B9_1268324364;
        }
Collection<Thread> var2F6B35A4A5F0D194270D94D1FD44EBD7_1437216308 =         sync.getWaitingThreads((AbstractQueuedSynchronizer.ConditionObject)condition);
        var2F6B35A4A5F0D194270D94D1FD44EBD7_1437216308.addTaint(taint);
        return var2F6B35A4A5F0D194270D94D1FD44EBD7_1437216308;
        // ---------- Original Method ----------
        //if (condition == null)
            //throw new NullPointerException();
        //if (!(condition instanceof AbstractQueuedSynchronizer.ConditionObject))
            //throw new IllegalArgumentException("not owner");
        //return sync.getWaitingThreads((AbstractQueuedSynchronizer.ConditionObject)condition);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:17.617 -0400", hash_original_method = "03D5EBF343C873E095999F30626DADA2", hash_generated_method = "A3273FCA1107A56B2BD64D7907112C5A")
    public String toString() {
        int c = sync.getCount();
        int w = Sync.exclusiveCount(c);
        int r = Sync.sharedCount(c);
String varF396C8E82331D702AD553E1BB16E0C78_1310107075 =         super.toString() +
            "[Write locks = " + w + ", Read locks = " + r + "]";
        varF396C8E82331D702AD553E1BB16E0C78_1310107075.addTaint(taint);
        return varF396C8E82331D702AD553E1BB16E0C78_1310107075;
        // ---------- Original Method ----------
        //int c = sync.getCount();
        //int w = Sync.exclusiveCount(c);
        //int r = Sync.sharedCount(c);
        //return super.toString() +
            //"[Write locks = " + w + ", Read locks = " + r + "]";
    }

    
    abstract static class Sync extends AbstractQueuedSynchronizer {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:17.618 -0400", hash_original_field = "E08C8E97570C1DCB9CD554FD7079B697", hash_generated_field = "8C4B3BD798FE5D7E8EB3D0536576D262")

        private transient ThreadLocalHoldCounter readHolds;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:17.618 -0400", hash_original_field = "DF91768C2D431EA735A71A6CE08F4181", hash_generated_field = "2EE67430D3D959E367F77E7EF6425C16")

        private transient HoldCounter cachedHoldCounter;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:17.618 -0400", hash_original_field = "AAA28B60505EF94BD4CA2E8CC3EC3C64", hash_generated_field = "A011FC8C4363F320801F082EF2C621C1")

        private transient Thread firstReader = null;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:17.618 -0400", hash_original_field = "64FF72C6AF21D3CE02435570D431F32C", hash_generated_field = "D6E4ACE63DE2E9B4DD29D78376D1F793")

        private transient int firstReaderHoldCount;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:17.618 -0400", hash_original_method = "89DA4D8EA92261B26BAB9F4AB5CDD482", hash_generated_method = "F96B116FAEB3CF7E52F47724A0D1064E")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:17.619 -0400", hash_original_method = "E2589B88E3FBFBAA4E5917277DEFE99E", hash_generated_method = "D3D2352A4C088A959128C6FA36C9EFC2")
        protected final boolean tryRelease(int releases) {
            addTaint(releases);
    if(!isHeldExclusively())            
            {
            IllegalMonitorStateException var9D4F198B973DC32951341758A9D245B5_977808940 = new IllegalMonitorStateException();
            var9D4F198B973DC32951341758A9D245B5_977808940.addTaint(taint);
            throw var9D4F198B973DC32951341758A9D245B5_977808940;
            }
            int nextc = getState() - releases;
            boolean free = exclusiveCount(nextc) == 0;
    if(free)            
            setExclusiveOwnerThread(null);
            setState(nextc);
            boolean varAA2D6E4F578EB0CFABA23BEEF76C2194_452295614 = (free);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_406098104 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_406098104;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:17.620 -0400", hash_original_method = "887DB434CE6AB550C72A17E01EAED908", hash_generated_method = "9221BB7585EAC43DB42A495AB97AE60C")
        protected final boolean tryAcquire(int acquires) {
            addTaint(acquires);
            Thread current = Thread.currentThread();
            int c = getState();
            int w = exclusiveCount(c);
    if(c != 0)            
            {
    if(w == 0 || current != getExclusiveOwnerThread())                
                {
                boolean var68934A3E9455FA72420237EB05902327_752088851 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1094906246 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1094906246;
                }
    if(w + exclusiveCount(acquires) > MAX_COUNT)                
                {
                Error var095BEDC30C458CE8F7BCE7A524D79305_1111311711 = new Error("Maximum lock count exceeded");
                var095BEDC30C458CE8F7BCE7A524D79305_1111311711.addTaint(taint);
                throw var095BEDC30C458CE8F7BCE7A524D79305_1111311711;
                }
                setState(c + acquires);
                boolean varB326B5062B2F0E69046810717534CB09_1230921322 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_761556026 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_761556026;
            } //End block
    if(writerShouldBlock() ||
                !compareAndSetState(c, c + acquires))            
            {
            boolean var68934A3E9455FA72420237EB05902327_174436931 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1035596502 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1035596502;
            }
            setExclusiveOwnerThread(current);
            boolean varB326B5062B2F0E69046810717534CB09_1307339622 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1653379991 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1653379991;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:17.629 -0400", hash_original_method = "DCB6BD37D30DD1C1033C1677B2F2BA39", hash_generated_method = "8EF23F7FB65DBCDF10953754B5130621")
        protected final boolean tryReleaseShared(int unused) {
            addTaint(unused);
            Thread current = Thread.currentThread();
    if(firstReader == current)            
            {
    if(firstReaderHoldCount == 1)                
                firstReader = null;
                else
                firstReaderHoldCount--;
            } //End block
            else
            {
                HoldCounter rh = cachedHoldCounter;
    if(rh == null || rh.tid != current.getId())                
                rh = readHolds.get();
                int count = rh.count;
    if(count <= 1)                
                {
                    readHolds.remove();
    if(count <= 0)                    
                    {
                    java.lang.IllegalMonitorStateException var5C99527915C9B6AA4FAA8D7F5146C8BA_824086078 = unmatchedUnlockException();
                    var5C99527915C9B6AA4FAA8D7F5146C8BA_824086078.addTaint(taint);
                    throw var5C99527915C9B6AA4FAA8D7F5146C8BA_824086078;
                    }
                } //End block
                --rh.count;
            } //End block
for(;;)
            {
                int c = getState();
                int nextc = c - SHARED_UNIT;
    if(compareAndSetState(c, nextc))                
                {
                boolean varFE567596D7CBF2AAC320D09D88315819_2077320091 = (nextc == 0);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1791963678 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1791963678;
                }
            } //End block
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:17.631 -0400", hash_original_method = "4AE7D8D2A940AB168E8F2908DE9ACCF1", hash_generated_method = "005D1AE2034E3144E64A4AF3C30587F9")
        private IllegalMonitorStateException unmatchedUnlockException() {
IllegalMonitorStateException varAC3EE6A2AAB0A3AB5F9F21BDB3141812_621759118 =             new IllegalMonitorStateException(
                "attempt to unlock read lock, not locked by current thread");
            varAC3EE6A2AAB0A3AB5F9F21BDB3141812_621759118.addTaint(taint);
            return varAC3EE6A2AAB0A3AB5F9F21BDB3141812_621759118;
            // ---------- Original Method ----------
            //return new IllegalMonitorStateException(
                //"attempt to unlock read lock, not locked by current thread");
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:17.633 -0400", hash_original_method = "AD4C82A786111FF828AFE5FE5C8E5A39", hash_generated_method = "39DA81E11B3217211B11DE8FAA080BB0")
        protected final int tryAcquireShared(int unused) {
            addTaint(unused);
            Thread current = Thread.currentThread();
            int c = getState();
    if(exclusiveCount(c) != 0 &&
                getExclusiveOwnerThread() != current)            
            {
            int var6BB61E3B7BCE0931DA574D19D1D82C88_2112184326 = (-1);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1089786252 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1089786252;
            }
            int r = sharedCount(c);
    if(!readerShouldBlock() &&
                r < MAX_COUNT &&
                compareAndSetState(c, c + SHARED_UNIT))            
            {
    if(r == 0)                
                {
                    firstReader = current;
                    firstReaderHoldCount = 1;
                } //End block
                else
    if(firstReader == current)                
                {
                    firstReaderHoldCount++;
                } //End block
                else
                {
                    HoldCounter rh = cachedHoldCounter;
    if(rh == null || rh.tid != current.getId())                    
                    cachedHoldCounter = rh = readHolds.get();
                    else
    if(rh.count == 0)                    
                    readHolds.set(rh);
                    rh.count++;
                } //End block
                int varC4CA4238A0B923820DCC509A6F75849B_827369547 = (1);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1666694712 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1666694712;
            } //End block
            int var3170A6EDE6D40C8EDCD443A2CB27345A_1535877032 = (fullTryAcquireShared(current));
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2094485558 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2094485558;
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:17.634 -0400", hash_original_method = "EBE8D8355B366068B4B1E29E3A9EED12", hash_generated_method = "4E23810B574FCA1764042348274ECC73")
        final int fullTryAcquireShared(Thread current) {
            HoldCounter rh = null;
for(;;)
            {
                int c = getState();
    if(exclusiveCount(c) != 0)                
                {
    if(getExclusiveOwnerThread() != current)                    
                    {
                    int var6BB61E3B7BCE0931DA574D19D1D82C88_600678797 = (-1);
                                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_814054091 = getTaintInt();
                    return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_814054091;
                    }
                } //End block
                else
    if(readerShouldBlock())                
                {
    if(firstReader == current)                    
                    {
                    } //End block
                    else
                    {
    if(rh == null)                        
                        {
                            rh = cachedHoldCounter;
    if(rh == null || rh.tid != current.getId())                            
                            {
                                rh = readHolds.get();
    if(rh.count == 0)                                
                                readHolds.remove();
                            } //End block
                        } //End block
    if(rh.count == 0)                        
                        {
                        int var6BB61E3B7BCE0931DA574D19D1D82C88_1732051474 = (-1);
                                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_295424430 = getTaintInt();
                        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_295424430;
                        }
                    } //End block
                } //End block
    if(sharedCount(c) == MAX_COUNT)                
                {
                Error var095BEDC30C458CE8F7BCE7A524D79305_1567895582 = new Error("Maximum lock count exceeded");
                var095BEDC30C458CE8F7BCE7A524D79305_1567895582.addTaint(taint);
                throw var095BEDC30C458CE8F7BCE7A524D79305_1567895582;
                }
    if(compareAndSetState(c, c + SHARED_UNIT))                
                {
    if(sharedCount(c) == 0)                    
                    {
                        firstReader = current;
                        firstReaderHoldCount = 1;
                    } //End block
                    else
    if(firstReader == current)                    
                    {
                        firstReaderHoldCount++;
                    } //End block
                    else
                    {
    if(rh == null)                        
                        rh = cachedHoldCounter;
    if(rh == null || rh.tid != current.getId())                        
                        rh = readHolds.get();
                        else
    if(rh.count == 0)                        
                        readHolds.set(rh);
                        rh.count++;
                        cachedHoldCounter = rh;
                    } //End block
                    int varC4CA4238A0B923820DCC509A6F75849B_376373164 = (1);
                                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1730151575 = getTaintInt();
                    return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1730151575;
                } //End block
            } //End block
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:17.637 -0400", hash_original_method = "0DD6CA3D230AA260224A4A3AE8239ACB", hash_generated_method = "CAD9B3AFC35FFF5206D9242F435B9504")
        final boolean tryWriteLock() {
            Thread current = Thread.currentThread();
            int c = getState();
    if(c != 0)            
            {
                int w = exclusiveCount(c);
    if(w == 0 || current != getExclusiveOwnerThread())                
                {
                boolean var68934A3E9455FA72420237EB05902327_573592090 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_163582729 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_163582729;
                }
    if(w == MAX_COUNT)                
                {
                Error var095BEDC30C458CE8F7BCE7A524D79305_86803121 = new Error("Maximum lock count exceeded");
                var095BEDC30C458CE8F7BCE7A524D79305_86803121.addTaint(taint);
                throw var095BEDC30C458CE8F7BCE7A524D79305_86803121;
                }
            } //End block
    if(!compareAndSetState(c, c + 1))            
            {
            boolean var68934A3E9455FA72420237EB05902327_1357079617 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_67439887 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_67439887;
            }
            setExclusiveOwnerThread(current);
            boolean varB326B5062B2F0E69046810717534CB09_1298631276 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1907423057 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1907423057;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:17.638 -0400", hash_original_method = "F864315749E9B3DD069E258F497DFE4D", hash_generated_method = "1B9B16841719233C6A24F880601622E4")
        final boolean tryReadLock() {
            Thread current = Thread.currentThread();
for(;;)
            {
                int c = getState();
    if(exclusiveCount(c) != 0 &&
                    getExclusiveOwnerThread() != current)                
                {
                boolean var68934A3E9455FA72420237EB05902327_1256440644 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_949893908 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_949893908;
                }
                int r = sharedCount(c);
    if(r == MAX_COUNT)                
                {
                Error var095BEDC30C458CE8F7BCE7A524D79305_1955760504 = new Error("Maximum lock count exceeded");
                var095BEDC30C458CE8F7BCE7A524D79305_1955760504.addTaint(taint);
                throw var095BEDC30C458CE8F7BCE7A524D79305_1955760504;
                }
    if(compareAndSetState(c, c + SHARED_UNIT))                
                {
    if(r == 0)                    
                    {
                        firstReader = current;
                        firstReaderHoldCount = 1;
                    } //End block
                    else
    if(firstReader == current)                    
                    {
                        firstReaderHoldCount++;
                    } //End block
                    else
                    {
                        HoldCounter rh = cachedHoldCounter;
    if(rh == null || rh.tid != current.getId())                        
                        cachedHoldCounter = rh = readHolds.get();
                        else
    if(rh.count == 0)                        
                        readHolds.set(rh);
                        rh.count++;
                    } //End block
                    boolean varB326B5062B2F0E69046810717534CB09_749489287 = (true);
                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_742364528 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_742364528;
                } //End block
            } //End block
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:17.639 -0400", hash_original_method = "A843CC28FFAE9A089B89A0058BA2B9D5", hash_generated_method = "7E8ADE01FC4E3C14A7C765EE6C6F1707")
        protected final boolean isHeldExclusively() {
            boolean var209567A654B1FCE1B2039A97387DA4E2_376765297 = (getExclusiveOwnerThread() == Thread.currentThread());
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_656428607 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_656428607;
            // ---------- Original Method ----------
            //return getExclusiveOwnerThread() == Thread.currentThread();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:17.639 -0400", hash_original_method = "093F0D0E6A279CA43864791B6FD65040", hash_generated_method = "899C9FCE3A8026A00E29D849A80A6F9F")
        final ConditionObject newCondition() {
ConditionObject var01D80487DA347E7B28ACEC08E954FD99_1529078672 =             new ConditionObject();
            var01D80487DA347E7B28ACEC08E954FD99_1529078672.addTaint(taint);
            return var01D80487DA347E7B28ACEC08E954FD99_1529078672;
            // ---------- Original Method ----------
            //return new ConditionObject();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:17.640 -0400", hash_original_method = "3F3DE8BCF9BFC159EB93FF2ABA8024D7", hash_generated_method = "F8F2E3CFD7D0A6AA70740E843CC1B88C")
        final Thread getOwner() {
Thread var968C91F9D0BAAE3E440CA3AE2A5B5090_1393350936 =             ((exclusiveCount(getState()) == 0) ?
                    null :
                    getExclusiveOwnerThread());
            var968C91F9D0BAAE3E440CA3AE2A5B5090_1393350936.addTaint(taint);
            return var968C91F9D0BAAE3E440CA3AE2A5B5090_1393350936;
            // ---------- Original Method ----------
            //return ((exclusiveCount(getState()) == 0) ?
                    //null :
                    //getExclusiveOwnerThread());
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:17.640 -0400", hash_original_method = "0B84E22FFE55E13BE40413778559BE34", hash_generated_method = "CD15CDD9B8889215C95B8A4D0A1A5015")
        final int getReadLockCount() {
            int var94A567675C98D9D4AE104C3CF1E9605D_988925863 = (sharedCount(getState()));
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1494098642 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1494098642;
            // ---------- Original Method ----------
            //return sharedCount(getState());
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:17.640 -0400", hash_original_method = "09CA8B61F6450707C75BFC712569D4D4", hash_generated_method = "C7EDB52B6A3FE99C41A964F91252512C")
        final boolean isWriteLocked() {
            boolean varC2C08A98E6666569176DD75481C3AB23_1802070976 = (exclusiveCount(getState()) != 0);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_496305464 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_496305464;
            // ---------- Original Method ----------
            //return exclusiveCount(getState()) != 0;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:17.640 -0400", hash_original_method = "67C0C583D90F5F49CAE0DBAE2DE27D59", hash_generated_method = "DF8387822FD43408399AE12FD2D021F8")
        final int getWriteHoldCount() {
            int var4B8DF6BD79FF6E188F9E4BE1FF0CD8BB_856609582 = (isHeldExclusively() ? exclusiveCount(getState()) : 0);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_564094069 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_564094069;
            // ---------- Original Method ----------
            //return isHeldExclusively() ? exclusiveCount(getState()) : 0;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:17.641 -0400", hash_original_method = "1DA1A38561287A101F5C2B623B00252F", hash_generated_method = "133A7F12241DC44F6ED2F1A50E69D904")
        final int getReadHoldCount() {
    if(getReadLockCount() == 0)            
            {
            int varCFCD208495D565EF66E7DFF9F98764DA_1539542386 = (0);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1465247039 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1465247039;
            }
            Thread current = Thread.currentThread();
    if(firstReader == current)            
            {
            int var64FF72C6AF21D3CE02435570D431F32C_1306209236 = (firstReaderHoldCount);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1909332314 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1909332314;
            }
            HoldCounter rh = cachedHoldCounter;
    if(rh != null && rh.tid == current.getId())            
            {
            int var678E84899A3321CD80AD38DD8899307C_1410520425 = (rh.count);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1612737821 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1612737821;
            }
            int count = readHolds.get().count;
    if(count == 0)            
            readHolds.remove();
            int varE2942A04780E223B215EB8B663CF5353_1178248915 = (count);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1604124950 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1604124950;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:17.642 -0400", hash_original_method = "4E48396D4489DBF7E8DA7E593070FC82", hash_generated_method = "10F4B8958932986F227806E7628AC7E0")
        private void readObject(java.io.ObjectInputStream s) throws java.io.IOException, ClassNotFoundException {
            addTaint(s.getTaint());
            s.defaultReadObject();
            readHolds = new ThreadLocalHoldCounter();
            setState(0);
            // ---------- Original Method ----------
            //s.defaultReadObject();
            //readHolds = new ThreadLocalHoldCounter();
            //setState(0);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:17.642 -0400", hash_original_method = "192D38E698A214D58DA93C3298AD6AD3", hash_generated_method = "FF26ACDE81017831E4EB550EC2D1F212")
        final int getCount() {
            int var118C4F58F1303398C344B8AAB7CE6EE1_757224684 = (getState());
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_931314726 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_931314726;
            // ---------- Original Method ----------
            //return getState();
        }

        
        static final class HoldCounter {
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:17.642 -0400", hash_original_field = "B1F8A23315AB697B67E425C4B5F81545", hash_generated_field = "B524E41AA0CF6AD39267F32C8C687778")

            int count = 0;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:17.642 -0400", hash_original_field = "A7CAC231571D7123EBB48A8647C318F9", hash_generated_field = "B08EBA558D35D7351A04ACA0D52B3632")

            final long tid = Thread.currentThread().getId();
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:17.642 -0400", hash_original_method = "F1D8E352EDEF0AB237A69949FE7423C4", hash_generated_method = "F1D8E352EDEF0AB237A69949FE7423C4")
            public HoldCounter ()
            {
                //Synthesized constructor
            }


        }


        
        static final class ThreadLocalHoldCounter extends ThreadLocal<HoldCounter> {
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:17.642 -0400", hash_original_method = "2811BFD99460ECBD8E7948B925FFB736", hash_generated_method = "2811BFD99460ECBD8E7948B925FFB736")
            public ThreadLocalHoldCounter ()
            {
                //Synthesized constructor
            }


            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:17.642 -0400", hash_original_method = "65FB587992A751B61B2E99AB391905DE", hash_generated_method = "FE31CB2E0C9A9AA6BBFB5BD4E094BB7C")
            public HoldCounter initialValue() {
HoldCounter varDEF0919C35A2158C32922614479824E5_1623450393 =                 new HoldCounter();
                varDEF0919C35A2158C32922614479824E5_1623450393.addTaint(taint);
                return varDEF0919C35A2158C32922614479824E5_1623450393;
                // ---------- Original Method ----------
                //return new HoldCounter();
            }

            
        }


        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:17.643 -0400", hash_original_field = "F661B57F5D85B8C55CBF8EC6C1332293", hash_generated_field = "7C931A0AA0CAF43860EA5D05E5F8B303")

        private static final long serialVersionUID = 6317671515068378041L;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:17.643 -0400", hash_original_field = "84B1E483133CB506AF0F344691E6DF0D", hash_generated_field = "1BECA78E8EF9C81EDFA90AF6033A5F51")

        static final int SHARED_SHIFT = 16;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:17.643 -0400", hash_original_field = "24C85CCC5E848FE7AAEF439B797AF477", hash_generated_field = "C8AB687482F52B5D1545D9BC8249F0D6")

        static final int SHARED_UNIT = (1 << SHARED_SHIFT);
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:17.643 -0400", hash_original_field = "2A4F653E74D03DB9FBF055439C642017", hash_generated_field = "921A8713594E39243E9A93B111B6F582")

        static final int MAX_COUNT = (1 << SHARED_SHIFT) - 1;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:17.643 -0400", hash_original_field = "36C9424C451B233CA56EB28EF0E91CDB", hash_generated_field = "060B47E79661495F6885046EB813A43B")

        static final int EXCLUSIVE_MASK = (1 << SHARED_SHIFT) - 1;
    }


    
    static final class NonfairSync extends Sync {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:17.643 -0400", hash_original_method = "92700F1FF079627760B83F1F338B8E6E", hash_generated_method = "92700F1FF079627760B83F1F338B8E6E")
        public NonfairSync ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:17.643 -0400", hash_original_method = "6099B514073B77A554543D2A2B955577", hash_generated_method = "92D95E54EE8A56C531187B4F4D17C6C5")
        final boolean writerShouldBlock() {
            boolean var68934A3E9455FA72420237EB05902327_1046930582 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_187623187 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_187623187;
            // ---------- Original Method ----------
            //return false;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:17.643 -0400", hash_original_method = "311D59812186188137CBEED2258453A3", hash_generated_method = "C03F6801F0326D656CBEEE29FA5214FC")
        final boolean readerShouldBlock() {
            boolean var90B6C9931ABBCC759B6C7B073210266A_1506826758 = (apparentlyFirstQueuedIsExclusive());
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_570329796 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_570329796;
            // ---------- Original Method ----------
            //return apparentlyFirstQueuedIsExclusive();
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:17.644 -0400", hash_original_field = "962FC793F1AA6943131BF3E9C77AA5E7", hash_generated_field = "F3A4EB2F8018DB6E004273D21E41E16C")

        private static final long serialVersionUID = -8159625535654395037L;
    }


    
    static final class FairSync extends Sync {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:17.644 -0400", hash_original_method = "76BFFA90730B34917875BAE48AE8B396", hash_generated_method = "76BFFA90730B34917875BAE48AE8B396")
        public FairSync ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:17.644 -0400", hash_original_method = "F04DB8A71B8ACD86834CABDF23C7982B", hash_generated_method = "08F8D359D28F0EE813549382A7BBAFA3")
        final boolean writerShouldBlock() {
            boolean varE2A30D414A69A5F837F7587CF4C7F29B_700711677 = (hasQueuedPredecessors());
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_186069511 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_186069511;
            // ---------- Original Method ----------
            //return hasQueuedPredecessors();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:17.644 -0400", hash_original_method = "5E806298851931D3FCAB2DE2F5A11624", hash_generated_method = "0094EEB35902B9A2567A420267388C3F")
        final boolean readerShouldBlock() {
            boolean varE2A30D414A69A5F837F7587CF4C7F29B_27510658 = (hasQueuedPredecessors());
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1571341182 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1571341182;
            // ---------- Original Method ----------
            //return hasQueuedPredecessors();
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:17.644 -0400", hash_original_field = "789C476CB4886D7F76862344BE9A6172", hash_generated_field = "076791917E0837F6FCF483EA9968303D")

        private static final long serialVersionUID = -2274990926593161451L;
    }


    
    public static class ReadLock implements Lock, java.io.Serializable {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:17.644 -0400", hash_original_field = "63AD9D34F3503826E5F649AE6B7AC92C", hash_generated_field = "A4B34EF3CE38520839B34A2F06599243")

        private Sync sync;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:17.645 -0400", hash_original_method = "86296C44CAAC51998FCC18AC6C334852", hash_generated_method = "90987B1257AE5908AD98C331E68E3B50")
        protected  ReadLock(ReentrantReadWriteLock lock) {
            sync = lock.sync;
            // ---------- Original Method ----------
            //sync = lock.sync;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:17.645 -0400", hash_original_method = "8D72D73F25D8DE6C9209D04669F96039", hash_generated_method = "F147980700CF869A8D6F7133099FA372")
        public void lock() {
            sync.acquireShared(1);
            // ---------- Original Method ----------
            //sync.acquireShared(1);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:17.645 -0400", hash_original_method = "61D542FCA692219B5199CDDD1A71CCC6", hash_generated_method = "87CEA29C19FE66B6CBD3C0925E99729C")
        public void lockInterruptibly() throws InterruptedException {
            sync.acquireSharedInterruptibly(1);
            // ---------- Original Method ----------
            //sync.acquireSharedInterruptibly(1);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:17.645 -0400", hash_original_method = "6F9DD593410D3A6A5FB658A804C67B03", hash_generated_method = "0369F444849C21A0CAB37ADF9A755924")
        public boolean tryLock() {
            boolean var0434A1EDCAE4F659BA7C5462A120958E_961961258 = (sync.tryReadLock());
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1661367123 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1661367123;
            // ---------- Original Method ----------
            //return sync.tryReadLock();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:17.646 -0400", hash_original_method = "CABC63B31BFC6EB1808F17E4FED50740", hash_generated_method = "968B9EEA127DC14539F69EC7A2F5E3AF")
        public boolean tryLock(long timeout, TimeUnit unit) throws InterruptedException {
            addTaint(unit.getTaint());
            addTaint(timeout);
            boolean varF9FFBA7272EE05E2720644344A388E0D_1106916963 = (sync.tryAcquireSharedNanos(1, unit.toNanos(timeout)));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2127153782 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_2127153782;
            // ---------- Original Method ----------
            //return sync.tryAcquireSharedNanos(1, unit.toNanos(timeout));
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:17.646 -0400", hash_original_method = "2E2DA507FE1EE35FD0E649F791C4FA62", hash_generated_method = "CE7F47B976DC7C53582533934AC31AFE")
        public void unlock() {
            sync.releaseShared(1);
            // ---------- Original Method ----------
            //sync.releaseShared(1);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:17.646 -0400", hash_original_method = "9996D083DB29CA9E935A73F01FAD8A4F", hash_generated_method = "FBF14891F708A4F40F9B231DF6B6B4CB")
        public Condition newCondition() {
            UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_33558225 = new UnsupportedOperationException();
            var81FA7E299EEE7F062EBFBEEF08B0464D_33558225.addTaint(taint);
            throw var81FA7E299EEE7F062EBFBEEF08B0464D_33558225;
            // ---------- Original Method ----------
            //throw new UnsupportedOperationException();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:17.647 -0400", hash_original_method = "4EA811A9ADBECD9416D19B5EBD75BF53", hash_generated_method = "83802C8B2951633BF0C0E32B59BBD33C")
        public String toString() {
            int r = sync.getReadLockCount();
String var5655CEE833115D216B799F25DFB7F2BA_1570649879 =             super.toString() +
                "[Read locks = " + r + "]";
            var5655CEE833115D216B799F25DFB7F2BA_1570649879.addTaint(taint);
            return var5655CEE833115D216B799F25DFB7F2BA_1570649879;
            // ---------- Original Method ----------
            //int r = sync.getReadLockCount();
            //return super.toString() +
                //"[Read locks = " + r + "]";
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:17.647 -0400", hash_original_field = "379AEE3B0AE7E3AB2A711C689B7C790D", hash_generated_field = "86BBAC3B6DE594ADDDD3BFD814E519BB")

        private static final long serialVersionUID = -5992448646407690164L;
    }


    
    public static class WriteLock implements Lock, java.io.Serializable {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:17.647 -0400", hash_original_field = "63AD9D34F3503826E5F649AE6B7AC92C", hash_generated_field = "A4B34EF3CE38520839B34A2F06599243")

        private Sync sync;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:17.647 -0400", hash_original_method = "2F59DA9CAF578BD2524C05A37F86DF01", hash_generated_method = "A7C2CC6406BCF200D20C7B5AD2A21C1A")
        protected  WriteLock(ReentrantReadWriteLock lock) {
            sync = lock.sync;
            // ---------- Original Method ----------
            //sync = lock.sync;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:17.647 -0400", hash_original_method = "4197ECA2CFEBBAA5B9BD7C840B7670C7", hash_generated_method = "DDE8BF3B445A2924BC3E70FCADFAA419")
        public void lock() {
            sync.acquire(1);
            // ---------- Original Method ----------
            //sync.acquire(1);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:17.648 -0400", hash_original_method = "5966BE77DAE264B5F21646B0E7A08FC1", hash_generated_method = "CFF689BB53A067D7B9EB5F12CA3F00CC")
        public void lockInterruptibly() throws InterruptedException {
            sync.acquireInterruptibly(1);
            // ---------- Original Method ----------
            //sync.acquireInterruptibly(1);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:17.648 -0400", hash_original_method = "55CC434A7054CDED1693C2BA6E1C81AA", hash_generated_method = "6643E352184594E28CC3378FD9F908D0")
        public boolean tryLock( ) {
            boolean var0F23247C6FDD39657C0C50CDE4946C50_1355344051 = (sync.tryWriteLock());
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1159989231 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1159989231;
            // ---------- Original Method ----------
            //return sync.tryWriteLock();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:17.648 -0400", hash_original_method = "6EF7D2E282F143C52CC20B0DBAA61A21", hash_generated_method = "E4566DCE7ED2EF16A152F14DC4E5DFCF")
        public boolean tryLock(long timeout, TimeUnit unit) throws InterruptedException {
            addTaint(unit.getTaint());
            addTaint(timeout);
            boolean var88EC251ECA0C3BEFD0353CA05AF51286_1358766927 = (sync.tryAcquireNanos(1, unit.toNanos(timeout)));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1070277053 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1070277053;
            // ---------- Original Method ----------
            //return sync.tryAcquireNanos(1, unit.toNanos(timeout));
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:17.648 -0400", hash_original_method = "7AD42B9E2BC6DD4A4DE0EB9EBA3A2515", hash_generated_method = "87142E80D82254348B0CA43367BBC9B7")
        public void unlock() {
            sync.release(1);
            // ---------- Original Method ----------
            //sync.release(1);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:17.649 -0400", hash_original_method = "6BB095C6835043568D960ACB9C15058D", hash_generated_method = "60C13B2EE5DF999014D6A1EF8A98DA23")
        public Condition newCondition() {
Condition var95736666DAD2F48CD56FC0B47EEE8141_895186566 =             sync.newCondition();
            var95736666DAD2F48CD56FC0B47EEE8141_895186566.addTaint(taint);
            return var95736666DAD2F48CD56FC0B47EEE8141_895186566;
            // ---------- Original Method ----------
            //return sync.newCondition();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:17.649 -0400", hash_original_method = "E0C199518E39715763AFB28F76F97305", hash_generated_method = "185C8ED8BE1742720C0064E01F0F4449")
        public String toString() {
            Thread o = sync.getOwner();
String var712A538455E0066CABFC7E39FF5F51C3_1306218481 =             super.toString() + ((o == null) ?
                                       "[Unlocked]" :
                                       "[Locked by thread " + o.getName() + "]");
            var712A538455E0066CABFC7E39FF5F51C3_1306218481.addTaint(taint);
            return var712A538455E0066CABFC7E39FF5F51C3_1306218481;
            // ---------- Original Method ----------
            //Thread o = sync.getOwner();
            //return super.toString() + ((o == null) ?
                                       //"[Unlocked]" :
                                       //"[Locked by thread " + o.getName() + "]");
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:17.649 -0400", hash_original_method = "53A74F7432D74C33316852C3E739832B", hash_generated_method = "4D2ECDDE7365A07B0633E4CA176D8BB4")
        public boolean isHeldByCurrentThread() {
            boolean var67B4017CD59F5DDCE7498E8483F9CFB0_1819086320 = (sync.isHeldExclusively());
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1978733678 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1978733678;
            // ---------- Original Method ----------
            //return sync.isHeldExclusively();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:17.650 -0400", hash_original_method = "17A37C9E70A2D6C131240856FD5B2099", hash_generated_method = "ADADA844A1619E8E955CE22A88E5D168")
        public int getHoldCount() {
            int var5794AF85D7E920F501BF42909C7CD874_1540171383 = (sync.getWriteHoldCount());
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_565219515 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_565219515;
            // ---------- Original Method ----------
            //return sync.getWriteHoldCount();
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:17.650 -0400", hash_original_field = "39DE0FFFDCAA0428C698758AE0E7E3D8", hash_generated_field = "91D8216ACB8E5ABFDC6C81788A99A4AB")

        private static final long serialVersionUID = -4992448646407690164L;
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:17.650 -0400", hash_original_field = "ACC5AACF11B6B32C6C9167A3DD56327E", hash_generated_field = "97706C97453A3073601BD3C0219ECA94")

    private static final long serialVersionUID = -6992448646407690164L;
}

