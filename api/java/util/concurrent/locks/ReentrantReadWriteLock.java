package java.util.concurrent.locks;

// Droidsafe Imports
import droidsafe.annotations.*;
import java.util.Collection;
import java.util.concurrent.TimeUnit;






public class ReentrantReadWriteLock implements ReadWriteLock, java.io.Serializable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.575 -0400", hash_original_field = "53A68C354CA707EE3CF4135EF2B687CE", hash_generated_field = "8F79220737B731E52680B143D15FE029")

    private ReentrantReadWriteLock.ReadLock readerLock;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.575 -0400", hash_original_field = "D7F1DF52BEB3372136F52E8F5BBC02A3", hash_generated_field = "1E1067A0A17FE39A5B241BAB85413180")

    private ReentrantReadWriteLock.WriteLock writerLock;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.575 -0400", hash_original_field = "63AD9D34F3503826E5F649AE6B7AC92C", hash_generated_field = "791C2888A6F5CDC158445182FD1E3538")

    Sync sync;
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.575 -0400", hash_original_method = "1C7ADE1C43258ED1B8231199DCC94C2F", hash_generated_method = "A2362B6FC27126ECCCC3F80E71268B1E")
    public  ReentrantReadWriteLock() {
        this(false);
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.576 -0400", hash_original_method = "A6CD875E912D33CADF6A81571C0A078B", hash_generated_method = "40472467CFFF2D78F76EB33BF5AABCCB")
    public  ReentrantReadWriteLock(boolean fair) {
        sync = fair ? new FairSync() : new NonfairSync();
        readerLock = new ReadLock(this);
        writerLock = new WriteLock(this);
        // ---------- Original Method ----------
        //sync = fair ? new FairSync() : new NonfairSync();
        //readerLock = new ReadLock(this);
        //writerLock = new WriteLock(this);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.576 -0400", hash_original_method = "0C7BC9C54BE00E03201ACF18B2913309", hash_generated_method = "85A131785DE6046ABF874D33B4899F5C")
    public ReentrantReadWriteLock.WriteLock writeLock() {
ReentrantReadWriteLock.WriteLock var2DE2F4E52EACF7C4842927B76B85571D_1949871750 =         writerLock;
        var2DE2F4E52EACF7C4842927B76B85571D_1949871750.addTaint(taint);
        return var2DE2F4E52EACF7C4842927B76B85571D_1949871750;
        // ---------- Original Method ----------
        //return writerLock;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.576 -0400", hash_original_method = "22D8B34ECDA1804C5F879E9731CF210D", hash_generated_method = "545AC55ED53DEAAD2D89D68866501208")
    public ReentrantReadWriteLock.ReadLock readLock() {
ReentrantReadWriteLock.ReadLock var5BE94CD16DAA35A039203EEB9FA0E80B_899720154 =         readerLock;
        var5BE94CD16DAA35A039203EEB9FA0E80B_899720154.addTaint(taint);
        return var5BE94CD16DAA35A039203EEB9FA0E80B_899720154;
        // ---------- Original Method ----------
        //return readerLock;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.577 -0400", hash_original_method = "6835E283E5F9E7FBD3FF7844476992AD", hash_generated_method = "5E480BE01B459619166A400CF34AC751")
    public final boolean isFair() {
        boolean var025994C1DF49233538C6DF8BADB9C6C8_1581930018 = (sync instanceof FairSync);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1802986972 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1802986972;
        // ---------- Original Method ----------
        //return sync instanceof FairSync;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.577 -0400", hash_original_method = "DB009A0944F572B5167ED6D51E109787", hash_generated_method = "C122FDCA48361DD73FDD473CEF3C5DFE")
    protected Thread getOwner() {
Thread var86C22E9219AA4C3398E9F9B969B294CC_812149855 =         sync.getOwner();
        var86C22E9219AA4C3398E9F9B969B294CC_812149855.addTaint(taint);
        return var86C22E9219AA4C3398E9F9B969B294CC_812149855;
        // ---------- Original Method ----------
        //return sync.getOwner();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.577 -0400", hash_original_method = "BDA3BC7F9F6754233D710BB1E8BDA625", hash_generated_method = "3CCA2B3B85D0515D7E683F2BF0A952A0")
    public int getReadLockCount() {
        int varA99EE35B51F0F2DF006576AC95F9ADA6_1021316852 = (sync.getReadLockCount());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1317335218 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1317335218;
        // ---------- Original Method ----------
        //return sync.getReadLockCount();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.577 -0400", hash_original_method = "D1234101A768FDEE737EDDFEC7DD19A3", hash_generated_method = "FF0E3985C0862555EBBA06A9073E56A2")
    public boolean isWriteLocked() {
        boolean varFC73878F4C438ED33B893BF2A76C07F9_491116093 = (sync.isWriteLocked());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1947838834 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1947838834;
        // ---------- Original Method ----------
        //return sync.isWriteLocked();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.578 -0400", hash_original_method = "B77A8CC69384EA638697FDA5B4AC3CDF", hash_generated_method = "28E31955392170A4541311485392343F")
    public boolean isWriteLockedByCurrentThread() {
        boolean var67B4017CD59F5DDCE7498E8483F9CFB0_1929656698 = (sync.isHeldExclusively());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_161441177 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_161441177;
        // ---------- Original Method ----------
        //return sync.isHeldExclusively();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.578 -0400", hash_original_method = "F72E2C7B278B975FDBAAB080F7322122", hash_generated_method = "A9E10219F22A731D59068C3A6D8D4BBC")
    public int getWriteHoldCount() {
        int var5794AF85D7E920F501BF42909C7CD874_62268550 = (sync.getWriteHoldCount());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_145488455 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_145488455;
        // ---------- Original Method ----------
        //return sync.getWriteHoldCount();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.578 -0400", hash_original_method = "026686F812EC7870B6E447136A7E8B3A", hash_generated_method = "02543A5F7749CCC2D3F91BDF8AF1C953")
    public int getReadHoldCount() {
        int var06FDCE51CDFD5B28DD05E89AC333B157_1035255285 = (sync.getReadHoldCount());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_434892445 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_434892445;
        // ---------- Original Method ----------
        //return sync.getReadHoldCount();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.578 -0400", hash_original_method = "2F9252966607830729245C7251D0E4B8", hash_generated_method = "A618DA61597F308EFAD35453A87A4761")
    protected Collection<Thread> getQueuedWriterThreads() {
Collection<Thread> var1559DAC9B49273E234BA87CC54E0EFE0_2121417204 =         sync.getExclusiveQueuedThreads();
        var1559DAC9B49273E234BA87CC54E0EFE0_2121417204.addTaint(taint);
        return var1559DAC9B49273E234BA87CC54E0EFE0_2121417204;
        // ---------- Original Method ----------
        //return sync.getExclusiveQueuedThreads();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.579 -0400", hash_original_method = "956CE594FDB46F8FEF252F1FDB068D3D", hash_generated_method = "04A70B731EF6F46D6EABE21F92F0C1C6")
    protected Collection<Thread> getQueuedReaderThreads() {
Collection<Thread> varF06E14FD6FBDA129EEF8BF14240D9D47_1690792696 =         sync.getSharedQueuedThreads();
        varF06E14FD6FBDA129EEF8BF14240D9D47_1690792696.addTaint(taint);
        return varF06E14FD6FBDA129EEF8BF14240D9D47_1690792696;
        // ---------- Original Method ----------
        //return sync.getSharedQueuedThreads();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.579 -0400", hash_original_method = "33B7DCC82A105082FC4D268ED56F9DE5", hash_generated_method = "FC6FF1E370E875F21075C72E4CC401F5")
    public final boolean hasQueuedThreads() {
        boolean var2967874652C8008E25540A916154E044_1705897592 = (sync.hasQueuedThreads());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2140610556 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2140610556;
        // ---------- Original Method ----------
        //return sync.hasQueuedThreads();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.579 -0400", hash_original_method = "7B179E46CDF5B520CCEEF15512EC2C63", hash_generated_method = "0942ABB063C6253089ED1D642DFEEFCA")
    public final boolean hasQueuedThread(Thread thread) {
        addTaint(thread.getTaint());
        boolean var9BB5C27E049EB33FD7FBCB6CC83C36FE_296801662 = (sync.isQueued(thread));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1432636814 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1432636814;
        // ---------- Original Method ----------
        //return sync.isQueued(thread);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.580 -0400", hash_original_method = "DFFF2C05339152644F00EC2FFC57EFB9", hash_generated_method = "7734762FAE174E4DF912D081CA681B42")
    public final int getQueueLength() {
        int var5D329306F1180332B8FF4C47065D325F_1195255039 = (sync.getQueueLength());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1893314077 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1893314077;
        // ---------- Original Method ----------
        //return sync.getQueueLength();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.580 -0400", hash_original_method = "4BC73C35668DA24636BE58FB68209032", hash_generated_method = "B37DD0631DCD30546CEEF2D35014D59D")
    protected Collection<Thread> getQueuedThreads() {
Collection<Thread> var0FD62A6A977BE381AD6B1EE70126B5BB_1165330076 =         sync.getQueuedThreads();
        var0FD62A6A977BE381AD6B1EE70126B5BB_1165330076.addTaint(taint);
        return var0FD62A6A977BE381AD6B1EE70126B5BB_1165330076;
        // ---------- Original Method ----------
        //return sync.getQueuedThreads();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.580 -0400", hash_original_method = "BF91F0F13FB6E88A38744502E21F1F2D", hash_generated_method = "3EBC138C142270E6C8354306B89B3B0A")
    public boolean hasWaiters(Condition condition) {
        addTaint(condition.getTaint());
        if(condition == null)        
        {
        NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_1207996543 = new NullPointerException();
        var7338BC9F48D81FE0BBD6183F4014DCC4_1207996543.addTaint(taint);
        throw var7338BC9F48D81FE0BBD6183F4014DCC4_1207996543;
        }
        if(!(condition instanceof AbstractQueuedSynchronizer.ConditionObject))        
        {
        IllegalArgumentException varB8792231CD1EFCF3C5A33149431219B9_2031179315 = new IllegalArgumentException("not owner");
        varB8792231CD1EFCF3C5A33149431219B9_2031179315.addTaint(taint);
        throw varB8792231CD1EFCF3C5A33149431219B9_2031179315;
        }
        boolean var23C1F5BEB670AD3A3B37230CF45D76AD_248624651 = (sync.hasWaiters((AbstractQueuedSynchronizer.ConditionObject)condition));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_34987551 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_34987551;
        // ---------- Original Method ----------
        //if (condition == null)
            //throw new NullPointerException();
        //if (!(condition instanceof AbstractQueuedSynchronizer.ConditionObject))
            //throw new IllegalArgumentException("not owner");
        //return sync.hasWaiters((AbstractQueuedSynchronizer.ConditionObject)condition);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.581 -0400", hash_original_method = "D4277B3B6ED39F705D915D3806A5548A", hash_generated_method = "EEB87B8071469C4F80C7619708B1EB6A")
    public int getWaitQueueLength(Condition condition) {
        addTaint(condition.getTaint());
        if(condition == null)        
        {
        NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_1240124627 = new NullPointerException();
        var7338BC9F48D81FE0BBD6183F4014DCC4_1240124627.addTaint(taint);
        throw var7338BC9F48D81FE0BBD6183F4014DCC4_1240124627;
        }
        if(!(condition instanceof AbstractQueuedSynchronizer.ConditionObject))        
        {
        IllegalArgumentException varB8792231CD1EFCF3C5A33149431219B9_1069603411 = new IllegalArgumentException("not owner");
        varB8792231CD1EFCF3C5A33149431219B9_1069603411.addTaint(taint);
        throw varB8792231CD1EFCF3C5A33149431219B9_1069603411;
        }
        int varD6C0E0468A7445023DCDBF050BDCAFA0_1428231433 = (sync.getWaitQueueLength((AbstractQueuedSynchronizer.ConditionObject)condition));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1883294628 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1883294628;
        // ---------- Original Method ----------
        //if (condition == null)
            //throw new NullPointerException();
        //if (!(condition instanceof AbstractQueuedSynchronizer.ConditionObject))
            //throw new IllegalArgumentException("not owner");
        //return sync.getWaitQueueLength((AbstractQueuedSynchronizer.ConditionObject)condition);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.581 -0400", hash_original_method = "29738EA386BFBB41E36C961DB4B1CBE5", hash_generated_method = "D03FEDAB46338B4C91E5856D255FADB5")
    protected Collection<Thread> getWaitingThreads(Condition condition) {
        addTaint(condition.getTaint());
        if(condition == null)        
        {
        NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_1860418440 = new NullPointerException();
        var7338BC9F48D81FE0BBD6183F4014DCC4_1860418440.addTaint(taint);
        throw var7338BC9F48D81FE0BBD6183F4014DCC4_1860418440;
        }
        if(!(condition instanceof AbstractQueuedSynchronizer.ConditionObject))        
        {
        IllegalArgumentException varB8792231CD1EFCF3C5A33149431219B9_681073703 = new IllegalArgumentException("not owner");
        varB8792231CD1EFCF3C5A33149431219B9_681073703.addTaint(taint);
        throw varB8792231CD1EFCF3C5A33149431219B9_681073703;
        }
Collection<Thread> var2F6B35A4A5F0D194270D94D1FD44EBD7_482138288 =         sync.getWaitingThreads((AbstractQueuedSynchronizer.ConditionObject)condition);
        var2F6B35A4A5F0D194270D94D1FD44EBD7_482138288.addTaint(taint);
        return var2F6B35A4A5F0D194270D94D1FD44EBD7_482138288;
        // ---------- Original Method ----------
        //if (condition == null)
            //throw new NullPointerException();
        //if (!(condition instanceof AbstractQueuedSynchronizer.ConditionObject))
            //throw new IllegalArgumentException("not owner");
        //return sync.getWaitingThreads((AbstractQueuedSynchronizer.ConditionObject)condition);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.581 -0400", hash_original_method = "03D5EBF343C873E095999F30626DADA2", hash_generated_method = "2F7ADA326B040A6013CAD508A2BCC9AC")
    public String toString() {
        int c = sync.getCount();
        int w = Sync.exclusiveCount(c);
        int r = Sync.sharedCount(c);
String varF396C8E82331D702AD553E1BB16E0C78_25318664 =         super.toString() +
            "[Write locks = " + w + ", Read locks = " + r + "]";
        varF396C8E82331D702AD553E1BB16E0C78_25318664.addTaint(taint);
        return varF396C8E82331D702AD553E1BB16E0C78_25318664;
        // ---------- Original Method ----------
        //int c = sync.getCount();
        //int w = Sync.exclusiveCount(c);
        //int r = Sync.sharedCount(c);
        //return super.toString() +
            //"[Write locks = " + w + ", Read locks = " + r + "]";
    }

    
    abstract static class Sync extends AbstractQueuedSynchronizer {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.582 -0400", hash_original_field = "E08C8E97570C1DCB9CD554FD7079B697", hash_generated_field = "8C4B3BD798FE5D7E8EB3D0536576D262")

        private transient ThreadLocalHoldCounter readHolds;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.582 -0400", hash_original_field = "DF91768C2D431EA735A71A6CE08F4181", hash_generated_field = "2EE67430D3D959E367F77E7EF6425C16")

        private transient HoldCounter cachedHoldCounter;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.582 -0400", hash_original_field = "AAA28B60505EF94BD4CA2E8CC3EC3C64", hash_generated_field = "A011FC8C4363F320801F082EF2C621C1")

        private transient Thread firstReader = null;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.582 -0400", hash_original_field = "64FF72C6AF21D3CE02435570D431F32C", hash_generated_field = "D6E4ACE63DE2E9B4DD29D78376D1F793")

        private transient int firstReaderHoldCount;
        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.582 -0400", hash_original_method = "89DA4D8EA92261B26BAB9F4AB5CDD482", hash_generated_method = "F96B116FAEB3CF7E52F47724A0D1064E")
          Sync() {
            readHolds = new ThreadLocalHoldCounter();
            setState(getState());
            // ---------- Original Method ----------
            //readHolds = new ThreadLocalHoldCounter();
            //setState(getState());
        }

        
        @DSModeled(DSC.SAFE)
        static int sharedCount(int c) {
            return c >>> SHARED_SHIFT;
        }

        
        @DSModeled(DSC.SAFE)
        static int exclusiveCount(int c) {
            return c & EXCLUSIVE_MASK;
        }

        
        @DSModeled(DSC.SAFE)
        abstract boolean readerShouldBlock();

        
        @DSModeled(DSC.SAFE)
        abstract boolean writerShouldBlock();

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.583 -0400", hash_original_method = "E2589B88E3FBFBAA4E5917277DEFE99E", hash_generated_method = "BB738F9409731DEC735BA4D29946A4FB")
        protected final boolean tryRelease(int releases) {
            addTaint(releases);
            if(!isHeldExclusively())            
            {
            IllegalMonitorStateException var9D4F198B973DC32951341758A9D245B5_693736720 = new IllegalMonitorStateException();
            var9D4F198B973DC32951341758A9D245B5_693736720.addTaint(taint);
            throw var9D4F198B973DC32951341758A9D245B5_693736720;
            }
            int nextc = getState() - releases;
            boolean free = exclusiveCount(nextc) == 0;
            if(free)            
            setExclusiveOwnerThread(null);
            setState(nextc);
            boolean varAA2D6E4F578EB0CFABA23BEEF76C2194_2096973486 = (free);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1684469785 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1684469785;
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

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.584 -0400", hash_original_method = "887DB434CE6AB550C72A17E01EAED908", hash_generated_method = "7A217064D5A3D188BB7215E55C8D3E6D")
        protected final boolean tryAcquire(int acquires) {
            addTaint(acquires);
            Thread current = Thread.currentThread();
            int c = getState();
            int w = exclusiveCount(c);
            if(c != 0)            
            {
                if(w == 0 || current != getExclusiveOwnerThread())                
                {
                boolean var68934A3E9455FA72420237EB05902327_1463324821 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1336269341 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1336269341;
                }
                if(w + exclusiveCount(acquires) > MAX_COUNT)                
                {
                Error var095BEDC30C458CE8F7BCE7A524D79305_523479917 = new Error("Maximum lock count exceeded");
                var095BEDC30C458CE8F7BCE7A524D79305_523479917.addTaint(taint);
                throw var095BEDC30C458CE8F7BCE7A524D79305_523479917;
                }
                setState(c + acquires);
                boolean varB326B5062B2F0E69046810717534CB09_642286711 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2093045652 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_2093045652;
            } //End block
            if(writerShouldBlock() ||
                !compareAndSetState(c, c + acquires))            
            {
            boolean var68934A3E9455FA72420237EB05902327_1086026708 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_876589400 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_876589400;
            }
            setExclusiveOwnerThread(current);
            boolean varB326B5062B2F0E69046810717534CB09_1789203302 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1296023025 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1296023025;
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

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.591 -0400", hash_original_method = "DCB6BD37D30DD1C1033C1677B2F2BA39", hash_generated_method = "22D7B73EE2A3A94815728F580243914E")
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
                    java.lang.IllegalMonitorStateException var5C99527915C9B6AA4FAA8D7F5146C8BA_1379828821 = unmatchedUnlockException();
                    var5C99527915C9B6AA4FAA8D7F5146C8BA_1379828821.addTaint(taint);
                    throw var5C99527915C9B6AA4FAA8D7F5146C8BA_1379828821;
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
                boolean varFE567596D7CBF2AAC320D09D88315819_1858111033 = (nextc == 0);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2097107776 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_2097107776;
                }
            } //End block
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
                @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.593 -0400", hash_original_method = "4AE7D8D2A940AB168E8F2908DE9ACCF1", hash_generated_method = "341402616B162A7F02BE8AF7DBA3DDFB")
        private IllegalMonitorStateException unmatchedUnlockException() {
IllegalMonitorStateException varAC3EE6A2AAB0A3AB5F9F21BDB3141812_1037364743 =             new IllegalMonitorStateException(
                "attempt to unlock read lock, not locked by current thread");
            varAC3EE6A2AAB0A3AB5F9F21BDB3141812_1037364743.addTaint(taint);
            return varAC3EE6A2AAB0A3AB5F9F21BDB3141812_1037364743;
            // ---------- Original Method ----------
            //return new IllegalMonitorStateException(
                //"attempt to unlock read lock, not locked by current thread");
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.594 -0400", hash_original_method = "AD4C82A786111FF828AFE5FE5C8E5A39", hash_generated_method = "9E8338352D118D81F250B5D7224D40FD")
        protected final int tryAcquireShared(int unused) {
            addTaint(unused);
            Thread current = Thread.currentThread();
            int c = getState();
            if(exclusiveCount(c) != 0 &&
                getExclusiveOwnerThread() != current)            
            {
            int var6BB61E3B7BCE0931DA574D19D1D82C88_297044300 = (-1);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_63245119 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_63245119;
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
                int varC4CA4238A0B923820DCC509A6F75849B_1788462563 = (1);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1786470184 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1786470184;
            } //End block
            int var3170A6EDE6D40C8EDCD443A2CB27345A_621787605 = (fullTryAcquireShared(current));
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1702752935 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1702752935;
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.596 -0400", hash_original_method = "EBE8D8355B366068B4B1E29E3A9EED12", hash_generated_method = "CCF30451179E1BE5613B572A4A5CCBF4")
        final int fullTryAcquireShared(Thread current) {
            HoldCounter rh = null;
for(;;)
            {
                int c = getState();
                if(exclusiveCount(c) != 0)                
                {
                    if(getExclusiveOwnerThread() != current)                    
                    {
                    int var6BB61E3B7BCE0931DA574D19D1D82C88_274586606 = (-1);
                                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1140888021 = getTaintInt();
                    return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1140888021;
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
                        int var6BB61E3B7BCE0931DA574D19D1D82C88_1473201409 = (-1);
                                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1332887291 = getTaintInt();
                        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1332887291;
                        }
                    } //End block
                } //End block
                if(sharedCount(c) == MAX_COUNT)                
                {
                Error var095BEDC30C458CE8F7BCE7A524D79305_977094425 = new Error("Maximum lock count exceeded");
                var095BEDC30C458CE8F7BCE7A524D79305_977094425.addTaint(taint);
                throw var095BEDC30C458CE8F7BCE7A524D79305_977094425;
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
                    int varC4CA4238A0B923820DCC509A6F75849B_1796353028 = (1);
                                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1950431413 = getTaintInt();
                    return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1950431413;
                } //End block
            } //End block
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.597 -0400", hash_original_method = "0DD6CA3D230AA260224A4A3AE8239ACB", hash_generated_method = "53627142652DE43A70E7167D508ACEAF")
        final boolean tryWriteLock() {
            Thread current = Thread.currentThread();
            int c = getState();
            if(c != 0)            
            {
                int w = exclusiveCount(c);
                if(w == 0 || current != getExclusiveOwnerThread())                
                {
                boolean var68934A3E9455FA72420237EB05902327_430700474 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1821417553 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1821417553;
                }
                if(w == MAX_COUNT)                
                {
                Error var095BEDC30C458CE8F7BCE7A524D79305_980571736 = new Error("Maximum lock count exceeded");
                var095BEDC30C458CE8F7BCE7A524D79305_980571736.addTaint(taint);
                throw var095BEDC30C458CE8F7BCE7A524D79305_980571736;
                }
            } //End block
            if(!compareAndSetState(c, c + 1))            
            {
            boolean var68934A3E9455FA72420237EB05902327_620995417 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1558864443 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1558864443;
            }
            setExclusiveOwnerThread(current);
            boolean varB326B5062B2F0E69046810717534CB09_930067802 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1485329202 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1485329202;
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

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.598 -0400", hash_original_method = "F864315749E9B3DD069E258F497DFE4D", hash_generated_method = "C9AF3D6F0577843E163AC7F2ECA3AC2D")
        final boolean tryReadLock() {
            Thread current = Thread.currentThread();
for(;;)
            {
                int c = getState();
                if(exclusiveCount(c) != 0 &&
                    getExclusiveOwnerThread() != current)                
                {
                boolean var68934A3E9455FA72420237EB05902327_1798593523 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1488763364 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1488763364;
                }
                int r = sharedCount(c);
                if(r == MAX_COUNT)                
                {
                Error var095BEDC30C458CE8F7BCE7A524D79305_2084661534 = new Error("Maximum lock count exceeded");
                var095BEDC30C458CE8F7BCE7A524D79305_2084661534.addTaint(taint);
                throw var095BEDC30C458CE8F7BCE7A524D79305_2084661534;
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
                    boolean varB326B5062B2F0E69046810717534CB09_1951080725 = (true);
                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1170752179 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_1170752179;
                } //End block
            } //End block
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.599 -0400", hash_original_method = "A843CC28FFAE9A089B89A0058BA2B9D5", hash_generated_method = "952FF5A459E23C6FD01444E430B0C890")
        protected final boolean isHeldExclusively() {
            boolean var209567A654B1FCE1B2039A97387DA4E2_847557980 = (getExclusiveOwnerThread() == Thread.currentThread());
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1026754432 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1026754432;
            // ---------- Original Method ----------
            //return getExclusiveOwnerThread() == Thread.currentThread();
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.600 -0400", hash_original_method = "093F0D0E6A279CA43864791B6FD65040", hash_generated_method = "4AF8BD475E38B893AA1902A659C3C68A")
        final ConditionObject newCondition() {
ConditionObject var01D80487DA347E7B28ACEC08E954FD99_1010782214 =             new ConditionObject();
            var01D80487DA347E7B28ACEC08E954FD99_1010782214.addTaint(taint);
            return var01D80487DA347E7B28ACEC08E954FD99_1010782214;
            // ---------- Original Method ----------
            //return new ConditionObject();
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.600 -0400", hash_original_method = "3F3DE8BCF9BFC159EB93FF2ABA8024D7", hash_generated_method = "07F8EC065F73B42D4F71317B3D08B5CD")
        final Thread getOwner() {
Thread var968C91F9D0BAAE3E440CA3AE2A5B5090_25571564 =             ((exclusiveCount(getState()) == 0) ?
                    null :
                    getExclusiveOwnerThread());
            var968C91F9D0BAAE3E440CA3AE2A5B5090_25571564.addTaint(taint);
            return var968C91F9D0BAAE3E440CA3AE2A5B5090_25571564;
            // ---------- Original Method ----------
            //return ((exclusiveCount(getState()) == 0) ?
                    //null :
                    //getExclusiveOwnerThread());
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.601 -0400", hash_original_method = "0B84E22FFE55E13BE40413778559BE34", hash_generated_method = "3E8F82010339EBBDE21FC18F5E794BAC")
        final int getReadLockCount() {
            int var94A567675C98D9D4AE104C3CF1E9605D_438639995 = (sharedCount(getState()));
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1230343744 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1230343744;
            // ---------- Original Method ----------
            //return sharedCount(getState());
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.601 -0400", hash_original_method = "09CA8B61F6450707C75BFC712569D4D4", hash_generated_method = "8124A0F46A8E7803907C25257E6E0E7C")
        final boolean isWriteLocked() {
            boolean varC2C08A98E6666569176DD75481C3AB23_227289323 = (exclusiveCount(getState()) != 0);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_934126790 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_934126790;
            // ---------- Original Method ----------
            //return exclusiveCount(getState()) != 0;
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.602 -0400", hash_original_method = "67C0C583D90F5F49CAE0DBAE2DE27D59", hash_generated_method = "F4B8BDC74E64DC843BB990BC94A7AEA0")
        final int getWriteHoldCount() {
            int var4B8DF6BD79FF6E188F9E4BE1FF0CD8BB_1767537573 = (isHeldExclusively() ? exclusiveCount(getState()) : 0);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2136292478 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2136292478;
            // ---------- Original Method ----------
            //return isHeldExclusively() ? exclusiveCount(getState()) : 0;
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.602 -0400", hash_original_method = "1DA1A38561287A101F5C2B623B00252F", hash_generated_method = "3FDF042CAD7AF5B6913158A934778F7F")
        final int getReadHoldCount() {
            if(getReadLockCount() == 0)            
            {
            int varCFCD208495D565EF66E7DFF9F98764DA_886319585 = (0);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1595304574 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1595304574;
            }
            Thread current = Thread.currentThread();
            if(firstReader == current)            
            {
            int var64FF72C6AF21D3CE02435570D431F32C_1752910015 = (firstReaderHoldCount);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1780087689 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1780087689;
            }
            HoldCounter rh = cachedHoldCounter;
            if(rh != null && rh.tid == current.getId())            
            {
            int var678E84899A3321CD80AD38DD8899307C_1046759781 = (rh.count);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1738813386 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1738813386;
            }
            int count = readHolds.get().count;
            if(count == 0)            
            readHolds.remove();
            int varE2942A04780E223B215EB8B663CF5353_956829916 = (count);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_904961052 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_904961052;
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

        
                @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.603 -0400", hash_original_method = "4E48396D4489DBF7E8DA7E593070FC82", hash_generated_method = "10F4B8958932986F227806E7628AC7E0")
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

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.603 -0400", hash_original_method = "192D38E698A214D58DA93C3298AD6AD3", hash_generated_method = "3F2CB229278EE3DA3B06F14992D33A03")
        final int getCount() {
            int var118C4F58F1303398C344B8AAB7CE6EE1_1407680472 = (getState());
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1927866140 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1927866140;
            // ---------- Original Method ----------
            //return getState();
        }

        
        static final class HoldCounter {
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.603 -0400", hash_original_field = "B1F8A23315AB697B67E425C4B5F81545", hash_generated_field = "B524E41AA0CF6AD39267F32C8C687778")

            int count = 0;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.603 -0400", hash_original_field = "A7CAC231571D7123EBB48A8647C318F9", hash_generated_field = "B08EBA558D35D7351A04ACA0D52B3632")

            final long tid = Thread.currentThread().getId();
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.604 -0400", hash_original_method = "F1D8E352EDEF0AB237A69949FE7423C4", hash_generated_method = "F1D8E352EDEF0AB237A69949FE7423C4")
            public HoldCounter ()
            {
                //Synthesized constructor
            }


        }


        
        static final class ThreadLocalHoldCounter extends ThreadLocal<HoldCounter> {
            
            @DSModeled(DSC.BAN)
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.604 -0400", hash_original_method = "2811BFD99460ECBD8E7948B925FFB736", hash_generated_method = "2811BFD99460ECBD8E7948B925FFB736")
            public ThreadLocalHoldCounter ()
            {
                //Synthesized constructor
            }


                        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.604 -0400", hash_original_method = "65FB587992A751B61B2E99AB391905DE", hash_generated_method = "F6448A10121AE01474A5501CA03FB409")
            public HoldCounter initialValue() {
HoldCounter varDEF0919C35A2158C32922614479824E5_372717066 =                 new HoldCounter();
                varDEF0919C35A2158C32922614479824E5_372717066.addTaint(taint);
                return varDEF0919C35A2158C32922614479824E5_372717066;
                // ---------- Original Method ----------
                //return new HoldCounter();
            }

            
        }


        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.604 -0400", hash_original_field = "F661B57F5D85B8C55CBF8EC6C1332293", hash_generated_field = "7C931A0AA0CAF43860EA5D05E5F8B303")

        private static final long serialVersionUID = 6317671515068378041L;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.604 -0400", hash_original_field = "84B1E483133CB506AF0F344691E6DF0D", hash_generated_field = "1BECA78E8EF9C81EDFA90AF6033A5F51")

        static final int SHARED_SHIFT = 16;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.604 -0400", hash_original_field = "24C85CCC5E848FE7AAEF439B797AF477", hash_generated_field = "C8AB687482F52B5D1545D9BC8249F0D6")

        static final int SHARED_UNIT = (1 << SHARED_SHIFT);
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.604 -0400", hash_original_field = "2A4F653E74D03DB9FBF055439C642017", hash_generated_field = "921A8713594E39243E9A93B111B6F582")

        static final int MAX_COUNT = (1 << SHARED_SHIFT) - 1;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.605 -0400", hash_original_field = "36C9424C451B233CA56EB28EF0E91CDB", hash_generated_field = "060B47E79661495F6885046EB813A43B")

        static final int EXCLUSIVE_MASK = (1 << SHARED_SHIFT) - 1;
    }


    
    static final class NonfairSync extends Sync {
        
        @DSModeled(DSC.BAN)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.605 -0400", hash_original_method = "92700F1FF079627760B83F1F338B8E6E", hash_generated_method = "92700F1FF079627760B83F1F338B8E6E")
        public NonfairSync ()
        {
            //Synthesized constructor
        }


        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.605 -0400", hash_original_method = "6099B514073B77A554543D2A2B955577", hash_generated_method = "412F47CEAF670C1E191C55D8783784EC")
        final boolean writerShouldBlock() {
            boolean var68934A3E9455FA72420237EB05902327_528831831 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_651480682 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_651480682;
            // ---------- Original Method ----------
            //return false;
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.605 -0400", hash_original_method = "311D59812186188137CBEED2258453A3", hash_generated_method = "3F5619EC10DC7174D11AD01066CF87D4")
        final boolean readerShouldBlock() {
            boolean var90B6C9931ABBCC759B6C7B073210266A_559524493 = (apparentlyFirstQueuedIsExclusive());
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1021452964 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1021452964;
            // ---------- Original Method ----------
            //return apparentlyFirstQueuedIsExclusive();
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.605 -0400", hash_original_field = "962FC793F1AA6943131BF3E9C77AA5E7", hash_generated_field = "F3A4EB2F8018DB6E004273D21E41E16C")

        private static final long serialVersionUID = -8159625535654395037L;
    }


    
    static final class FairSync extends Sync {
        
        @DSModeled(DSC.BAN)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.606 -0400", hash_original_method = "76BFFA90730B34917875BAE48AE8B396", hash_generated_method = "76BFFA90730B34917875BAE48AE8B396")
        public FairSync ()
        {
            //Synthesized constructor
        }


        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.606 -0400", hash_original_method = "F04DB8A71B8ACD86834CABDF23C7982B", hash_generated_method = "3524F80AC51EE71531F9FF8042F987ED")
        final boolean writerShouldBlock() {
            boolean varE2A30D414A69A5F837F7587CF4C7F29B_798578826 = (hasQueuedPredecessors());
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1709507916 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1709507916;
            // ---------- Original Method ----------
            //return hasQueuedPredecessors();
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.606 -0400", hash_original_method = "5E806298851931D3FCAB2DE2F5A11624", hash_generated_method = "8D9D7328B96355F5A0136616C3CD53AF")
        final boolean readerShouldBlock() {
            boolean varE2A30D414A69A5F837F7587CF4C7F29B_1327535181 = (hasQueuedPredecessors());
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_146185047 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_146185047;
            // ---------- Original Method ----------
            //return hasQueuedPredecessors();
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.606 -0400", hash_original_field = "789C476CB4886D7F76862344BE9A6172", hash_generated_field = "076791917E0837F6FCF483EA9968303D")

        private static final long serialVersionUID = -2274990926593161451L;
    }


    
    public static class ReadLock implements Lock, java.io.Serializable {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.606 -0400", hash_original_field = "63AD9D34F3503826E5F649AE6B7AC92C", hash_generated_field = "A4B34EF3CE38520839B34A2F06599243")

        private Sync sync;
        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.606 -0400", hash_original_method = "86296C44CAAC51998FCC18AC6C334852", hash_generated_method = "90987B1257AE5908AD98C331E68E3B50")
        protected  ReadLock(ReentrantReadWriteLock lock) {
            sync = lock.sync;
            // ---------- Original Method ----------
            //sync = lock.sync;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.606 -0400", hash_original_method = "8D72D73F25D8DE6C9209D04669F96039", hash_generated_method = "F147980700CF869A8D6F7133099FA372")
        public void lock() {
            sync.acquireShared(1);
            // ---------- Original Method ----------
            //sync.acquireShared(1);
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.607 -0400", hash_original_method = "61D542FCA692219B5199CDDD1A71CCC6", hash_generated_method = "87CEA29C19FE66B6CBD3C0925E99729C")
        public void lockInterruptibly() throws InterruptedException {
            sync.acquireSharedInterruptibly(1);
            // ---------- Original Method ----------
            //sync.acquireSharedInterruptibly(1);
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.607 -0400", hash_original_method = "6F9DD593410D3A6A5FB658A804C67B03", hash_generated_method = "2C33D2B86C655BFD6984B4CDAACCBA2C")
        public boolean tryLock() {
            boolean var0434A1EDCAE4F659BA7C5462A120958E_1488800115 = (sync.tryReadLock());
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2143895101 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_2143895101;
            // ---------- Original Method ----------
            //return sync.tryReadLock();
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.607 -0400", hash_original_method = "CABC63B31BFC6EB1808F17E4FED50740", hash_generated_method = "C9EBD0946C28420CD785D93ED105191D")
        public boolean tryLock(long timeout, TimeUnit unit) throws InterruptedException {
            addTaint(unit.getTaint());
            addTaint(timeout);
            boolean varF9FFBA7272EE05E2720644344A388E0D_872086516 = (sync.tryAcquireSharedNanos(1, unit.toNanos(timeout)));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2135349219 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_2135349219;
            // ---------- Original Method ----------
            //return sync.tryAcquireSharedNanos(1, unit.toNanos(timeout));
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.607 -0400", hash_original_method = "2E2DA507FE1EE35FD0E649F791C4FA62", hash_generated_method = "CE7F47B976DC7C53582533934AC31AFE")
        public void unlock() {
            sync.releaseShared(1);
            // ---------- Original Method ----------
            //sync.releaseShared(1);
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.607 -0400", hash_original_method = "9996D083DB29CA9E935A73F01FAD8A4F", hash_generated_method = "BA903166757068A21CC77D2CE3A54EE6")
        public Condition newCondition() {
            UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_1615870588 = new UnsupportedOperationException();
            var81FA7E299EEE7F062EBFBEEF08B0464D_1615870588.addTaint(taint);
            throw var81FA7E299EEE7F062EBFBEEF08B0464D_1615870588;
            // ---------- Original Method ----------
            //throw new UnsupportedOperationException();
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.607 -0400", hash_original_method = "4EA811A9ADBECD9416D19B5EBD75BF53", hash_generated_method = "D8FDDF51414D08800578C216CBE0FAB1")
        public String toString() {
            int r = sync.getReadLockCount();
String var5655CEE833115D216B799F25DFB7F2BA_521975163 =             super.toString() +
                "[Read locks = " + r + "]";
            var5655CEE833115D216B799F25DFB7F2BA_521975163.addTaint(taint);
            return var5655CEE833115D216B799F25DFB7F2BA_521975163;
            // ---------- Original Method ----------
            //int r = sync.getReadLockCount();
            //return super.toString() +
                //"[Read locks = " + r + "]";
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.607 -0400", hash_original_field = "379AEE3B0AE7E3AB2A711C689B7C790D", hash_generated_field = "86BBAC3B6DE594ADDDD3BFD814E519BB")

        private static final long serialVersionUID = -5992448646407690164L;
    }


    
    public static class WriteLock implements Lock, java.io.Serializable {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.607 -0400", hash_original_field = "63AD9D34F3503826E5F649AE6B7AC92C", hash_generated_field = "A4B34EF3CE38520839B34A2F06599243")

        private Sync sync;
        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.607 -0400", hash_original_method = "2F59DA9CAF578BD2524C05A37F86DF01", hash_generated_method = "A7C2CC6406BCF200D20C7B5AD2A21C1A")
        protected  WriteLock(ReentrantReadWriteLock lock) {
            sync = lock.sync;
            // ---------- Original Method ----------
            //sync = lock.sync;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.607 -0400", hash_original_method = "4197ECA2CFEBBAA5B9BD7C840B7670C7", hash_generated_method = "DDE8BF3B445A2924BC3E70FCADFAA419")
        public void lock() {
            sync.acquire(1);
            // ---------- Original Method ----------
            //sync.acquire(1);
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.607 -0400", hash_original_method = "5966BE77DAE264B5F21646B0E7A08FC1", hash_generated_method = "CFF689BB53A067D7B9EB5F12CA3F00CC")
        public void lockInterruptibly() throws InterruptedException {
            sync.acquireInterruptibly(1);
            // ---------- Original Method ----------
            //sync.acquireInterruptibly(1);
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.608 -0400", hash_original_method = "55CC434A7054CDED1693C2BA6E1C81AA", hash_generated_method = "654DD2F63582CB0AC6C8BC19C6242C7E")
        public boolean tryLock( ) {
            boolean var0F23247C6FDD39657C0C50CDE4946C50_250284940 = (sync.tryWriteLock());
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1174815159 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1174815159;
            // ---------- Original Method ----------
            //return sync.tryWriteLock();
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.608 -0400", hash_original_method = "6EF7D2E282F143C52CC20B0DBAA61A21", hash_generated_method = "EBAF98EB6E34EDC1DB3169803A8967F0")
        public boolean tryLock(long timeout, TimeUnit unit) throws InterruptedException {
            addTaint(unit.getTaint());
            addTaint(timeout);
            boolean var88EC251ECA0C3BEFD0353CA05AF51286_544067733 = (sync.tryAcquireNanos(1, unit.toNanos(timeout)));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_701419660 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_701419660;
            // ---------- Original Method ----------
            //return sync.tryAcquireNanos(1, unit.toNanos(timeout));
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.608 -0400", hash_original_method = "7AD42B9E2BC6DD4A4DE0EB9EBA3A2515", hash_generated_method = "87142E80D82254348B0CA43367BBC9B7")
        public void unlock() {
            sync.release(1);
            // ---------- Original Method ----------
            //sync.release(1);
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.608 -0400", hash_original_method = "6BB095C6835043568D960ACB9C15058D", hash_generated_method = "48C218C6A714703F4CC58573F0FCF5F7")
        public Condition newCondition() {
Condition var95736666DAD2F48CD56FC0B47EEE8141_3783203 =             sync.newCondition();
            var95736666DAD2F48CD56FC0B47EEE8141_3783203.addTaint(taint);
            return var95736666DAD2F48CD56FC0B47EEE8141_3783203;
            // ---------- Original Method ----------
            //return sync.newCondition();
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.608 -0400", hash_original_method = "E0C199518E39715763AFB28F76F97305", hash_generated_method = "2700B39ED728A696EF8332984C43EF5B")
        public String toString() {
            Thread o = sync.getOwner();
String var712A538455E0066CABFC7E39FF5F51C3_1921705685 =             super.toString() + ((o == null) ?
                                       "[Unlocked]" :
                                       "[Locked by thread " + o.getName() + "]");
            var712A538455E0066CABFC7E39FF5F51C3_1921705685.addTaint(taint);
            return var712A538455E0066CABFC7E39FF5F51C3_1921705685;
            // ---------- Original Method ----------
            //Thread o = sync.getOwner();
            //return super.toString() + ((o == null) ?
                                       //"[Unlocked]" :
                                       //"[Locked by thread " + o.getName() + "]");
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.608 -0400", hash_original_method = "53A74F7432D74C33316852C3E739832B", hash_generated_method = "AE9BC168DCA881041E20F6387FB9B50D")
        public boolean isHeldByCurrentThread() {
            boolean var67B4017CD59F5DDCE7498E8483F9CFB0_1191337104 = (sync.isHeldExclusively());
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_309967689 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_309967689;
            // ---------- Original Method ----------
            //return sync.isHeldExclusively();
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.608 -0400", hash_original_method = "17A37C9E70A2D6C131240856FD5B2099", hash_generated_method = "61D3579E2DFCB1A89AFFFAB996B9537A")
        public int getHoldCount() {
            int var5794AF85D7E920F501BF42909C7CD874_43151650 = (sync.getWriteHoldCount());
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_290534180 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_290534180;
            // ---------- Original Method ----------
            //return sync.getWriteHoldCount();
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.609 -0400", hash_original_field = "39DE0FFFDCAA0428C698758AE0E7E3D8", hash_generated_field = "91D8216ACB8E5ABFDC6C81788A99A4AB")

        private static final long serialVersionUID = -4992448646407690164L;
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.609 -0400", hash_original_field = "ACC5AACF11B6B32C6C9167A3DD56327E", hash_generated_field = "97706C97453A3073601BD3C0219ECA94")

    private static final long serialVersionUID = -6992448646407690164L;
}

