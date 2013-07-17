package java.util.concurrent.locks;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.*;

public class ReentrantLock implements Lock, java.io.Serializable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.494 -0400", hash_original_field = "63AD9D34F3503826E5F649AE6B7AC92C", hash_generated_field = "A4B34EF3CE38520839B34A2F06599243")

    private Sync sync;
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.494 -0400", hash_original_method = "CAF4BD8277F97E8E8A833F3DA738B0B2", hash_generated_method = "D575B8316542FC333CB3BC5C812414AD")
    public  ReentrantLock() {
        sync = new NonfairSync();
        // ---------- Original Method ----------
        //sync = new NonfairSync();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.495 -0400", hash_original_method = "D5E979A18BF9FB96236498521D2048B7", hash_generated_method = "A41781E53E248156CFB216376FFDC140")
    public  ReentrantLock(boolean fair) {
        sync = fair ? new FairSync() : new NonfairSync();
        // ---------- Original Method ----------
        //sync = fair ? new FairSync() : new NonfairSync();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.495 -0400", hash_original_method = "97675D396F33E00D31856AF34DD1ED6B", hash_generated_method = "F69D427B4A2E72BA43563F8DEC741F82")
    public void lock() {
        sync.lock();
        // ---------- Original Method ----------
        //sync.lock();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.495 -0400", hash_original_method = "5966BE77DAE264B5F21646B0E7A08FC1", hash_generated_method = "CFF689BB53A067D7B9EB5F12CA3F00CC")
    public void lockInterruptibly() throws InterruptedException {
        sync.acquireInterruptibly(1);
        // ---------- Original Method ----------
        //sync.acquireInterruptibly(1);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.496 -0400", hash_original_method = "9B7882D242270D7813AEE17389132741", hash_generated_method = "408C3F1DECD6B972A47C03FFA03A7526")
    public boolean tryLock() {
        boolean var140F1A0621DD0BDEC215647F86BCA4E3_1712658790 = (sync.nonfairTryAcquire(1));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_298845476 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_298845476;
        // ---------- Original Method ----------
        //return sync.nonfairTryAcquire(1);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.496 -0400", hash_original_method = "6EF7D2E282F143C52CC20B0DBAA61A21", hash_generated_method = "2362722F1899738716C1B43243295CE6")
    public boolean tryLock(long timeout, TimeUnit unit) throws InterruptedException {
        addTaint(unit.getTaint());
        addTaint(timeout);
        boolean var88EC251ECA0C3BEFD0353CA05AF51286_36053645 = (sync.tryAcquireNanos(1, unit.toNanos(timeout)));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1194303695 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1194303695;
        // ---------- Original Method ----------
        //return sync.tryAcquireNanos(1, unit.toNanos(timeout));
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.496 -0400", hash_original_method = "7AD42B9E2BC6DD4A4DE0EB9EBA3A2515", hash_generated_method = "87142E80D82254348B0CA43367BBC9B7")
    public void unlock() {
        sync.release(1);
        // ---------- Original Method ----------
        //sync.release(1);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.497 -0400", hash_original_method = "6BB095C6835043568D960ACB9C15058D", hash_generated_method = "8E1BB79D970AE9F36BADE0F8AE60D4E3")
    public Condition newCondition() {
Condition var95736666DAD2F48CD56FC0B47EEE8141_1027448259 =         sync.newCondition();
        var95736666DAD2F48CD56FC0B47EEE8141_1027448259.addTaint(taint);
        return var95736666DAD2F48CD56FC0B47EEE8141_1027448259;
        // ---------- Original Method ----------
        //return sync.newCondition();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.497 -0400", hash_original_method = "7FC57D6521874F49E1ACFD5770F280CF", hash_generated_method = "00402F5750B5BC3CF69E1879E2BA72F0")
    public int getHoldCount() {
        int var033BBA9FBC78AAE10A48F197A19D4736_220749118 = (sync.getHoldCount());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_476066390 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_476066390;
        // ---------- Original Method ----------
        //return sync.getHoldCount();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.498 -0400", hash_original_method = "53A74F7432D74C33316852C3E739832B", hash_generated_method = "5BF324205004A329147E46A476F9B3D2")
    public boolean isHeldByCurrentThread() {
        boolean var67B4017CD59F5DDCE7498E8483F9CFB0_1204324965 = (sync.isHeldExclusively());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1179850370 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1179850370;
        // ---------- Original Method ----------
        //return sync.isHeldExclusively();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.498 -0400", hash_original_method = "B8A2470400F707CBBF058BF4DA6F8D15", hash_generated_method = "E1730C346DB956E671D533C152D413CA")
    public boolean isLocked() {
        boolean var45109197DB21CBB6F15ECEF830DA6904_929099120 = (sync.isLocked());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1562770271 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1562770271;
        // ---------- Original Method ----------
        //return sync.isLocked();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.498 -0400", hash_original_method = "6835E283E5F9E7FBD3FF7844476992AD", hash_generated_method = "02AFDFCC5E8C45819BAFA90C815B6126")
    public final boolean isFair() {
        boolean var025994C1DF49233538C6DF8BADB9C6C8_1901860062 = (sync instanceof FairSync);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1447188224 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1447188224;
        // ---------- Original Method ----------
        //return sync instanceof FairSync;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.499 -0400", hash_original_method = "DB009A0944F572B5167ED6D51E109787", hash_generated_method = "553EF203AFF19159919889F04394A63B")
    protected Thread getOwner() {
Thread var86C22E9219AA4C3398E9F9B969B294CC_1534923674 =         sync.getOwner();
        var86C22E9219AA4C3398E9F9B969B294CC_1534923674.addTaint(taint);
        return var86C22E9219AA4C3398E9F9B969B294CC_1534923674;
        // ---------- Original Method ----------
        //return sync.getOwner();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.499 -0400", hash_original_method = "33B7DCC82A105082FC4D268ED56F9DE5", hash_generated_method = "550848A6F8C4C685B5237BA26DE46D57")
    public final boolean hasQueuedThreads() {
        boolean var2967874652C8008E25540A916154E044_1957785675 = (sync.hasQueuedThreads());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_987791603 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_987791603;
        // ---------- Original Method ----------
        //return sync.hasQueuedThreads();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.500 -0400", hash_original_method = "7B179E46CDF5B520CCEEF15512EC2C63", hash_generated_method = "D6ECAB740F8FFAC79F9E04C2700A3F4E")
    public final boolean hasQueuedThread(Thread thread) {
        addTaint(thread.getTaint());
        boolean var9BB5C27E049EB33FD7FBCB6CC83C36FE_247140517 = (sync.isQueued(thread));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1295264993 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1295264993;
        // ---------- Original Method ----------
        //return sync.isQueued(thread);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.501 -0400", hash_original_method = "DFFF2C05339152644F00EC2FFC57EFB9", hash_generated_method = "F36130BA6C4713150C9327C863FF8776")
    public final int getQueueLength() {
        int var5D329306F1180332B8FF4C47065D325F_1264667210 = (sync.getQueueLength());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_445710814 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_445710814;
        // ---------- Original Method ----------
        //return sync.getQueueLength();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.501 -0400", hash_original_method = "4BC73C35668DA24636BE58FB68209032", hash_generated_method = "7AFD7E4EDA9E295D7B65E5B7153AEA00")
    protected Collection<Thread> getQueuedThreads() {
Collection<Thread> var0FD62A6A977BE381AD6B1EE70126B5BB_324232057 =         sync.getQueuedThreads();
        var0FD62A6A977BE381AD6B1EE70126B5BB_324232057.addTaint(taint);
        return var0FD62A6A977BE381AD6B1EE70126B5BB_324232057;
        // ---------- Original Method ----------
        //return sync.getQueuedThreads();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.502 -0400", hash_original_method = "BF91F0F13FB6E88A38744502E21F1F2D", hash_generated_method = "B7412CBAD1D0DB95AD36F87790353F9F")
    public boolean hasWaiters(Condition condition) {
        addTaint(condition.getTaint());
        if(condition == null)        
        {
        NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_961515835 = new NullPointerException();
        var7338BC9F48D81FE0BBD6183F4014DCC4_961515835.addTaint(taint);
        throw var7338BC9F48D81FE0BBD6183F4014DCC4_961515835;
        }
        if(!(condition instanceof AbstractQueuedSynchronizer.ConditionObject))        
        {
        IllegalArgumentException varB8792231CD1EFCF3C5A33149431219B9_1627786892 = new IllegalArgumentException("not owner");
        varB8792231CD1EFCF3C5A33149431219B9_1627786892.addTaint(taint);
        throw varB8792231CD1EFCF3C5A33149431219B9_1627786892;
        }
        boolean var23C1F5BEB670AD3A3B37230CF45D76AD_1143161257 = (sync.hasWaiters((AbstractQueuedSynchronizer.ConditionObject)condition));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1509782301 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1509782301;
        // ---------- Original Method ----------
        //if (condition == null)
            //throw new NullPointerException();
        //if (!(condition instanceof AbstractQueuedSynchronizer.ConditionObject))
            //throw new IllegalArgumentException("not owner");
        //return sync.hasWaiters((AbstractQueuedSynchronizer.ConditionObject)condition);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.503 -0400", hash_original_method = "D4277B3B6ED39F705D915D3806A5548A", hash_generated_method = "3314C9DB524360FB1937608CF1E34206")
    public int getWaitQueueLength(Condition condition) {
        addTaint(condition.getTaint());
        if(condition == null)        
        {
        NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_530391919 = new NullPointerException();
        var7338BC9F48D81FE0BBD6183F4014DCC4_530391919.addTaint(taint);
        throw var7338BC9F48D81FE0BBD6183F4014DCC4_530391919;
        }
        if(!(condition instanceof AbstractQueuedSynchronizer.ConditionObject))        
        {
        IllegalArgumentException varB8792231CD1EFCF3C5A33149431219B9_1285585989 = new IllegalArgumentException("not owner");
        varB8792231CD1EFCF3C5A33149431219B9_1285585989.addTaint(taint);
        throw varB8792231CD1EFCF3C5A33149431219B9_1285585989;
        }
        int varD6C0E0468A7445023DCDBF050BDCAFA0_1211174736 = (sync.getWaitQueueLength((AbstractQueuedSynchronizer.ConditionObject)condition));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1954751177 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1954751177;
        // ---------- Original Method ----------
        //if (condition == null)
            //throw new NullPointerException();
        //if (!(condition instanceof AbstractQueuedSynchronizer.ConditionObject))
            //throw new IllegalArgumentException("not owner");
        //return sync.getWaitQueueLength((AbstractQueuedSynchronizer.ConditionObject)condition);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.503 -0400", hash_original_method = "29738EA386BFBB41E36C961DB4B1CBE5", hash_generated_method = "F3F13911D3F9F9FE6AD88B071FC43DFE")
    protected Collection<Thread> getWaitingThreads(Condition condition) {
        addTaint(condition.getTaint());
        if(condition == null)        
        {
        NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_862442662 = new NullPointerException();
        var7338BC9F48D81FE0BBD6183F4014DCC4_862442662.addTaint(taint);
        throw var7338BC9F48D81FE0BBD6183F4014DCC4_862442662;
        }
        if(!(condition instanceof AbstractQueuedSynchronizer.ConditionObject))        
        {
        IllegalArgumentException varB8792231CD1EFCF3C5A33149431219B9_1341816308 = new IllegalArgumentException("not owner");
        varB8792231CD1EFCF3C5A33149431219B9_1341816308.addTaint(taint);
        throw varB8792231CD1EFCF3C5A33149431219B9_1341816308;
        }
Collection<Thread> var2F6B35A4A5F0D194270D94D1FD44EBD7_1979497202 =         sync.getWaitingThreads((AbstractQueuedSynchronizer.ConditionObject)condition);
        var2F6B35A4A5F0D194270D94D1FD44EBD7_1979497202.addTaint(taint);
        return var2F6B35A4A5F0D194270D94D1FD44EBD7_1979497202;
        // ---------- Original Method ----------
        //if (condition == null)
            //throw new NullPointerException();
        //if (!(condition instanceof AbstractQueuedSynchronizer.ConditionObject))
            //throw new IllegalArgumentException("not owner");
        //return sync.getWaitingThreads((AbstractQueuedSynchronizer.ConditionObject)condition);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.503 -0400", hash_original_method = "E0C199518E39715763AFB28F76F97305", hash_generated_method = "52674563424046BC140C7475BE9EC4D4")
    public String toString() {
        Thread o = sync.getOwner();
String var712A538455E0066CABFC7E39FF5F51C3_421383218 =         super.toString() + ((o == null) ?
                                   "[Unlocked]" :
                                   "[Locked by thread " + o.getName() + "]");
        var712A538455E0066CABFC7E39FF5F51C3_421383218.addTaint(taint);
        return var712A538455E0066CABFC7E39FF5F51C3_421383218;
        // ---------- Original Method ----------
        //Thread o = sync.getOwner();
        //return super.toString() + ((o == null) ?
                                   //"[Unlocked]" :
                                   //"[Locked by thread " + o.getName() + "]");
    }

    
    abstract static class Sync extends AbstractQueuedSynchronizer {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.504 -0400", hash_original_method = "88F1B6F2E189B36E0DD98AFBD02FE2C7", hash_generated_method = "88F1B6F2E189B36E0DD98AFBD02FE2C7")
        public Sync ()
        {
            //Synthesized constructor
        }


        @DSModeled(DSC.SAFE)
        abstract void lock();

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.504 -0400", hash_original_method = "D19DB0AA686FDE0FA905238F42C3F88E", hash_generated_method = "375B0B7A801E6D4A6AD51D0894EA278F")
        final boolean nonfairTryAcquire(int acquires) {
            addTaint(acquires);
            final Thread current = Thread.currentThread();
            int c = getState();
            if(c == 0)            
            {
                if(compareAndSetState(0, acquires))                
                {
                    setExclusiveOwnerThread(current);
                    boolean varB326B5062B2F0E69046810717534CB09_992797178 = (true);
                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1738600078 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_1738600078;
                } //End block
            } //End block
            else
            if(current == getExclusiveOwnerThread())            
            {
                int nextc = c + acquires;
                if(nextc < 0)                
                {
                Error var095BEDC30C458CE8F7BCE7A524D79305_851263473 = new Error("Maximum lock count exceeded");
                var095BEDC30C458CE8F7BCE7A524D79305_851263473.addTaint(taint);
                throw var095BEDC30C458CE8F7BCE7A524D79305_851263473;
                }
                setState(nextc);
                boolean varB326B5062B2F0E69046810717534CB09_563343514 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2022558098 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_2022558098;
            } //End block
            boolean var68934A3E9455FA72420237EB05902327_1480583723 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2024487561 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_2024487561;
            // ---------- Original Method ----------
            //final Thread current = Thread.currentThread();
            //int c = getState();
            //if (c == 0) {
                //if (compareAndSetState(0, acquires)) {
                    //setExclusiveOwnerThread(current);
                    //return true;
                //}
            //}
            //else if (current == getExclusiveOwnerThread()) {
                //int nextc = c + acquires;
                //if (nextc < 0) 
                    //throw new Error("Maximum lock count exceeded");
                //setState(nextc);
                //return true;
            //}
            //return false;
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.505 -0400", hash_original_method = "F58D783FAFD21E630011410A68B89B8B", hash_generated_method = "423F6A1DC9D2AD97AB741539343918F1")
        protected final boolean tryRelease(int releases) {
            addTaint(releases);
            int c = getState() - releases;
            if(Thread.currentThread() != getExclusiveOwnerThread())            
            {
            IllegalMonitorStateException var9D4F198B973DC32951341758A9D245B5_2098916579 = new IllegalMonitorStateException();
            var9D4F198B973DC32951341758A9D245B5_2098916579.addTaint(taint);
            throw var9D4F198B973DC32951341758A9D245B5_2098916579;
            }
            boolean free = false;
            if(c == 0)            
            {
                free = true;
                setExclusiveOwnerThread(null);
            } //End block
            setState(c);
            boolean varAA2D6E4F578EB0CFABA23BEEF76C2194_1615081835 = (free);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_590400142 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_590400142;
            // ---------- Original Method ----------
            //int c = getState() - releases;
            //if (Thread.currentThread() != getExclusiveOwnerThread())
                //throw new IllegalMonitorStateException();
            //boolean free = false;
            //if (c == 0) {
                //free = true;
                //setExclusiveOwnerThread(null);
            //}
            //setState(c);
            //return free;
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.505 -0400", hash_original_method = "A843CC28FFAE9A089B89A0058BA2B9D5", hash_generated_method = "7884661526AF7642D03EC36A22E906B3")
        protected final boolean isHeldExclusively() {
            boolean var209567A654B1FCE1B2039A97387DA4E2_134832839 = (getExclusiveOwnerThread() == Thread.currentThread());
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_568848035 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_568848035;
            // ---------- Original Method ----------
            //return getExclusiveOwnerThread() == Thread.currentThread();
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.505 -0400", hash_original_method = "093F0D0E6A279CA43864791B6FD65040", hash_generated_method = "0074F290EE92FEDDF1B9B3F619A69D75")
        final ConditionObject newCondition() {
ConditionObject var01D80487DA347E7B28ACEC08E954FD99_334554304 =             new ConditionObject();
            var01D80487DA347E7B28ACEC08E954FD99_334554304.addTaint(taint);
            return var01D80487DA347E7B28ACEC08E954FD99_334554304;
            // ---------- Original Method ----------
            //return new ConditionObject();
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.505 -0400", hash_original_method = "24CA7AAFB844A1400E08D949A036E749", hash_generated_method = "A87DAE6123817E8F7FB74718D5C20CF9")
        final Thread getOwner() {
Thread var9A18AC0B80ECEE9576AADF73FC28AEC2_1190475811 =             getState() == 0 ? null : getExclusiveOwnerThread();
            var9A18AC0B80ECEE9576AADF73FC28AEC2_1190475811.addTaint(taint);
            return var9A18AC0B80ECEE9576AADF73FC28AEC2_1190475811;
            // ---------- Original Method ----------
            //return getState() == 0 ? null : getExclusiveOwnerThread();
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.505 -0400", hash_original_method = "9566A514E32EED07D696F4866CA45F30", hash_generated_method = "24628B77870DDF99200FF69064D7B6D2")
        final int getHoldCount() {
            int varE76C236C61E378D6714ED86325FF558D_786155198 = (isHeldExclusively() ? getState() : 0);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1959332708 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1959332708;
            // ---------- Original Method ----------
            //return isHeldExclusively() ? getState() : 0;
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.505 -0400", hash_original_method = "89AB065792F4703E484ABCB3E61E822C", hash_generated_method = "E74CDB1BDEA57A3D9047EB25247EF24C")
        final boolean isLocked() {
            boolean var2A32036BD18B2706112116E63B6B14FE_154019340 = (getState() != 0);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1032752491 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1032752491;
            // ---------- Original Method ----------
            //return getState() != 0;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.505 -0400", hash_original_method = "05D5902ED2395493955B66F039D49364", hash_generated_method = "75645607B1168731113488FBAFB4AB43")
        private void readObject(java.io.ObjectInputStream s) throws java.io.IOException, ClassNotFoundException {
            addTaint(s.getTaint());
            s.defaultReadObject();
            setState(0);
            // ---------- Original Method ----------
            //s.defaultReadObject();
            //setState(0);
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.505 -0400", hash_original_field = "664BADC4FCE0F56881AF4EC0C44FC7CE", hash_generated_field = "11262B0B520D47FEDD0C78D205387B55")

        private static final long serialVersionUID = -5179523762034025860L;
    }


    
    static final class NonfairSync extends Sync {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.506 -0400", hash_original_method = "92700F1FF079627760B83F1F338B8E6E", hash_generated_method = "92700F1FF079627760B83F1F338B8E6E")
        public NonfairSync ()
        {
            //Synthesized constructor
        }


        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.506 -0400", hash_original_method = "250EC96D0AD0D747189CAF2CF367FDFE", hash_generated_method = "C1ADB03F5AA8922EA3C09621A8FCA1D5")
        final void lock() {
            if(compareAndSetState(0, 1))            
            setExclusiveOwnerThread(Thread.currentThread());
            else
            acquire(1);
            // ---------- Original Method ----------
            //if (compareAndSetState(0, 1))
                //setExclusiveOwnerThread(Thread.currentThread());
            //else
                //acquire(1);
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.506 -0400", hash_original_method = "4FB92A369E0871387D4F8186DCD16A26", hash_generated_method = "EAAEE3F6D3E15B3F342297D6091AF593")
        protected final boolean tryAcquire(int acquires) {
            addTaint(acquires);
            boolean varF3133CF2A6709F1FDC477885EF5D5576_1002843426 = (nonfairTryAcquire(acquires));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_540490281 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_540490281;
            // ---------- Original Method ----------
            //return nonfairTryAcquire(acquires);
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.506 -0400", hash_original_field = "BD27C19ACD1B65DD9363F71DE1851218", hash_generated_field = "58C60847CF2F2D2F1CEF07DFE5BA201D")

        private static final long serialVersionUID = 7316153563782823691L;
    }


    
    static final class FairSync extends Sync {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.506 -0400", hash_original_method = "76BFFA90730B34917875BAE48AE8B396", hash_generated_method = "76BFFA90730B34917875BAE48AE8B396")
        public FairSync ()
        {
            //Synthesized constructor
        }


        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.506 -0400", hash_original_method = "E6AC2D5893CA21F5681F81CF00C94AEB", hash_generated_method = "EA04A5A8DEC9D6FD4587640A48DF018E")
        final void lock() {
            acquire(1);
            // ---------- Original Method ----------
            //acquire(1);
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.507 -0400", hash_original_method = "81B34FC5A1F152836CFB423B4391D12C", hash_generated_method = "6472EEF09EF681F9E58DE3D6F180834E")
        protected final boolean tryAcquire(int acquires) {
            addTaint(acquires);
            final Thread current = Thread.currentThread();
            int c = getState();
            if(c == 0)            
            {
                if(!hasQueuedPredecessors() &&
                    compareAndSetState(0, acquires))                
                {
                    setExclusiveOwnerThread(current);
                    boolean varB326B5062B2F0E69046810717534CB09_13433556 = (true);
                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1934768776 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_1934768776;
                } //End block
            } //End block
            else
            if(current == getExclusiveOwnerThread())            
            {
                int nextc = c + acquires;
                if(nextc < 0)                
                {
                Error var095BEDC30C458CE8F7BCE7A524D79305_209567041 = new Error("Maximum lock count exceeded");
                var095BEDC30C458CE8F7BCE7A524D79305_209567041.addTaint(taint);
                throw var095BEDC30C458CE8F7BCE7A524D79305_209567041;
                }
                setState(nextc);
                boolean varB326B5062B2F0E69046810717534CB09_572672614 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_850860765 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_850860765;
            } //End block
            boolean var68934A3E9455FA72420237EB05902327_270717872 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_107133520 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_107133520;
            // ---------- Original Method ----------
            //final Thread current = Thread.currentThread();
            //int c = getState();
            //if (c == 0) {
                //if (!hasQueuedPredecessors() &&
                    //compareAndSetState(0, acquires)) {
                    //setExclusiveOwnerThread(current);
                    //return true;
                //}
            //}
            //else if (current == getExclusiveOwnerThread()) {
                //int nextc = c + acquires;
                //if (nextc < 0)
                    //throw new Error("Maximum lock count exceeded");
                //setState(nextc);
                //return true;
            //}
            //return false;
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.507 -0400", hash_original_field = "D17C09047856F96A00E27AA866549B69", hash_generated_field = "CB1921210AFFA16906C257D2951975DC")

        private static final long serialVersionUID = -3000897897090466540L;
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.507 -0400", hash_original_field = "16EBB3E5C40DD288F8E94BD3EE8B7D56", hash_generated_field = "190C3E77BD396A2688499FE9C5D2BE14")

    private static final long serialVersionUID = 7373984872572414699L;
}

