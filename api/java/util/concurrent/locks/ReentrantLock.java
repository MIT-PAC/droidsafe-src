package java.util.concurrent.locks;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.*;

public class ReentrantLock implements Lock, java.io.Serializable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.937 -0400", hash_original_field = "63AD9D34F3503826E5F649AE6B7AC92C", hash_generated_field = "A4B34EF3CE38520839B34A2F06599243")

    private Sync sync;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.937 -0400", hash_original_method = "CAF4BD8277F97E8E8A833F3DA738B0B2", hash_generated_method = "D575B8316542FC333CB3BC5C812414AD")
    public  ReentrantLock() {
        sync = new NonfairSync();
        // ---------- Original Method ----------
        //sync = new NonfairSync();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.937 -0400", hash_original_method = "D5E979A18BF9FB96236498521D2048B7", hash_generated_method = "A41781E53E248156CFB216376FFDC140")
    public  ReentrantLock(boolean fair) {
        sync = fair ? new FairSync() : new NonfairSync();
        // ---------- Original Method ----------
        //sync = fair ? new FairSync() : new NonfairSync();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.937 -0400", hash_original_method = "97675D396F33E00D31856AF34DD1ED6B", hash_generated_method = "F69D427B4A2E72BA43563F8DEC741F82")
    public void lock() {
        sync.lock();
        // ---------- Original Method ----------
        //sync.lock();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.938 -0400", hash_original_method = "5966BE77DAE264B5F21646B0E7A08FC1", hash_generated_method = "CFF689BB53A067D7B9EB5F12CA3F00CC")
    public void lockInterruptibly() throws InterruptedException {
        sync.acquireInterruptibly(1);
        // ---------- Original Method ----------
        //sync.acquireInterruptibly(1);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.938 -0400", hash_original_method = "9B7882D242270D7813AEE17389132741", hash_generated_method = "8A53927C4D3AFD3BEC42BA0686BF8CBB")
    public boolean tryLock() {
        boolean var140F1A0621DD0BDEC215647F86BCA4E3_41565368 = (sync.nonfairTryAcquire(1));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1439355928 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1439355928;
        // ---------- Original Method ----------
        //return sync.nonfairTryAcquire(1);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.938 -0400", hash_original_method = "6EF7D2E282F143C52CC20B0DBAA61A21", hash_generated_method = "A2339DACCE4819EB9D8DE999D13B80E4")
    public boolean tryLock(long timeout, TimeUnit unit) throws InterruptedException {
        addTaint(unit.getTaint());
        addTaint(timeout);
        boolean var88EC251ECA0C3BEFD0353CA05AF51286_1082351056 = (sync.tryAcquireNanos(1, unit.toNanos(timeout)));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1147718649 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1147718649;
        // ---------- Original Method ----------
        //return sync.tryAcquireNanos(1, unit.toNanos(timeout));
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.938 -0400", hash_original_method = "7AD42B9E2BC6DD4A4DE0EB9EBA3A2515", hash_generated_method = "87142E80D82254348B0CA43367BBC9B7")
    public void unlock() {
        sync.release(1);
        // ---------- Original Method ----------
        //sync.release(1);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.938 -0400", hash_original_method = "6BB095C6835043568D960ACB9C15058D", hash_generated_method = "F5D569EBECBD4EC9A5F5FF6E605AA1FF")
    public Condition newCondition() {
Condition var95736666DAD2F48CD56FC0B47EEE8141_2145947043 =         sync.newCondition();
        var95736666DAD2F48CD56FC0B47EEE8141_2145947043.addTaint(taint);
        return var95736666DAD2F48CD56FC0B47EEE8141_2145947043;
        // ---------- Original Method ----------
        //return sync.newCondition();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.939 -0400", hash_original_method = "7FC57D6521874F49E1ACFD5770F280CF", hash_generated_method = "49C1080CD2F34E54D065E7F7411C1A36")
    public int getHoldCount() {
        int var033BBA9FBC78AAE10A48F197A19D4736_1793241613 = (sync.getHoldCount());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_804028590 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_804028590;
        // ---------- Original Method ----------
        //return sync.getHoldCount();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.939 -0400", hash_original_method = "53A74F7432D74C33316852C3E739832B", hash_generated_method = "A6DA77649687890E86B9A9C2430AB7B1")
    public boolean isHeldByCurrentThread() {
        boolean var67B4017CD59F5DDCE7498E8483F9CFB0_522369742 = (sync.isHeldExclusively());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1721438178 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1721438178;
        // ---------- Original Method ----------
        //return sync.isHeldExclusively();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.939 -0400", hash_original_method = "B8A2470400F707CBBF058BF4DA6F8D15", hash_generated_method = "14699BE99FCFE398FCA550A5B901F191")
    public boolean isLocked() {
        boolean var45109197DB21CBB6F15ECEF830DA6904_506141976 = (sync.isLocked());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_390297270 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_390297270;
        // ---------- Original Method ----------
        //return sync.isLocked();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.939 -0400", hash_original_method = "6835E283E5F9E7FBD3FF7844476992AD", hash_generated_method = "9297B18BBE881144F35AECFB6E8C0AD9")
    public final boolean isFair() {
        boolean var025994C1DF49233538C6DF8BADB9C6C8_1907908729 = (sync instanceof FairSync);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_480847302 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_480847302;
        // ---------- Original Method ----------
        //return sync instanceof FairSync;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.939 -0400", hash_original_method = "DB009A0944F572B5167ED6D51E109787", hash_generated_method = "69CEB7CFAC383EE5794F9CF958258F1A")
    protected Thread getOwner() {
Thread var86C22E9219AA4C3398E9F9B969B294CC_1034654486 =         sync.getOwner();
        var86C22E9219AA4C3398E9F9B969B294CC_1034654486.addTaint(taint);
        return var86C22E9219AA4C3398E9F9B969B294CC_1034654486;
        // ---------- Original Method ----------
        //return sync.getOwner();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.939 -0400", hash_original_method = "33B7DCC82A105082FC4D268ED56F9DE5", hash_generated_method = "EA209BEB32D05342F18DB6159AAC6B78")
    public final boolean hasQueuedThreads() {
        boolean var2967874652C8008E25540A916154E044_1679702226 = (sync.hasQueuedThreads());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1239337803 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1239337803;
        // ---------- Original Method ----------
        //return sync.hasQueuedThreads();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.940 -0400", hash_original_method = "7B179E46CDF5B520CCEEF15512EC2C63", hash_generated_method = "AD87E127411AEC2E8E48C6B56D285843")
    public final boolean hasQueuedThread(Thread thread) {
        addTaint(thread.getTaint());
        boolean var9BB5C27E049EB33FD7FBCB6CC83C36FE_176092107 = (sync.isQueued(thread));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2029396265 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2029396265;
        // ---------- Original Method ----------
        //return sync.isQueued(thread);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.940 -0400", hash_original_method = "DFFF2C05339152644F00EC2FFC57EFB9", hash_generated_method = "7241A32EA3F7C796A8C5C0D60C06DBC6")
    public final int getQueueLength() {
        int var5D329306F1180332B8FF4C47065D325F_661085973 = (sync.getQueueLength());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_36556707 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_36556707;
        // ---------- Original Method ----------
        //return sync.getQueueLength();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.940 -0400", hash_original_method = "4BC73C35668DA24636BE58FB68209032", hash_generated_method = "4CDABCC201885C88604C881180FC84E6")
    protected Collection<Thread> getQueuedThreads() {
Collection<Thread> var0FD62A6A977BE381AD6B1EE70126B5BB_2068745653 =         sync.getQueuedThreads();
        var0FD62A6A977BE381AD6B1EE70126B5BB_2068745653.addTaint(taint);
        return var0FD62A6A977BE381AD6B1EE70126B5BB_2068745653;
        // ---------- Original Method ----------
        //return sync.getQueuedThreads();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.940 -0400", hash_original_method = "BF91F0F13FB6E88A38744502E21F1F2D", hash_generated_method = "71AF9424BB70C09FD0C6D8E95E903A6B")
    public boolean hasWaiters(Condition condition) {
        addTaint(condition.getTaint());
    if(condition == null)        
        {
        NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_1052751016 = new NullPointerException();
        var7338BC9F48D81FE0BBD6183F4014DCC4_1052751016.addTaint(taint);
        throw var7338BC9F48D81FE0BBD6183F4014DCC4_1052751016;
        }
    if(!(condition instanceof AbstractQueuedSynchronizer.ConditionObject))        
        {
        IllegalArgumentException varB8792231CD1EFCF3C5A33149431219B9_957649938 = new IllegalArgumentException("not owner");
        varB8792231CD1EFCF3C5A33149431219B9_957649938.addTaint(taint);
        throw varB8792231CD1EFCF3C5A33149431219B9_957649938;
        }
        boolean var23C1F5BEB670AD3A3B37230CF45D76AD_830765391 = (sync.hasWaiters((AbstractQueuedSynchronizer.ConditionObject)condition));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1862554680 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1862554680;
        // ---------- Original Method ----------
        //if (condition == null)
            //throw new NullPointerException();
        //if (!(condition instanceof AbstractQueuedSynchronizer.ConditionObject))
            //throw new IllegalArgumentException("not owner");
        //return sync.hasWaiters((AbstractQueuedSynchronizer.ConditionObject)condition);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.941 -0400", hash_original_method = "D4277B3B6ED39F705D915D3806A5548A", hash_generated_method = "2E633C6396020ABE3FD9EB6C09A29488")
    public int getWaitQueueLength(Condition condition) {
        addTaint(condition.getTaint());
    if(condition == null)        
        {
        NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_1157902526 = new NullPointerException();
        var7338BC9F48D81FE0BBD6183F4014DCC4_1157902526.addTaint(taint);
        throw var7338BC9F48D81FE0BBD6183F4014DCC4_1157902526;
        }
    if(!(condition instanceof AbstractQueuedSynchronizer.ConditionObject))        
        {
        IllegalArgumentException varB8792231CD1EFCF3C5A33149431219B9_239894834 = new IllegalArgumentException("not owner");
        varB8792231CD1EFCF3C5A33149431219B9_239894834.addTaint(taint);
        throw varB8792231CD1EFCF3C5A33149431219B9_239894834;
        }
        int varD6C0E0468A7445023DCDBF050BDCAFA0_1058076128 = (sync.getWaitQueueLength((AbstractQueuedSynchronizer.ConditionObject)condition));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1436563548 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1436563548;
        // ---------- Original Method ----------
        //if (condition == null)
            //throw new NullPointerException();
        //if (!(condition instanceof AbstractQueuedSynchronizer.ConditionObject))
            //throw new IllegalArgumentException("not owner");
        //return sync.getWaitQueueLength((AbstractQueuedSynchronizer.ConditionObject)condition);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.941 -0400", hash_original_method = "29738EA386BFBB41E36C961DB4B1CBE5", hash_generated_method = "E4EE0FD1451F9F468063EE10A4F456CB")
    protected Collection<Thread> getWaitingThreads(Condition condition) {
        addTaint(condition.getTaint());
    if(condition == null)        
        {
        NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_1526187790 = new NullPointerException();
        var7338BC9F48D81FE0BBD6183F4014DCC4_1526187790.addTaint(taint);
        throw var7338BC9F48D81FE0BBD6183F4014DCC4_1526187790;
        }
    if(!(condition instanceof AbstractQueuedSynchronizer.ConditionObject))        
        {
        IllegalArgumentException varB8792231CD1EFCF3C5A33149431219B9_1318396385 = new IllegalArgumentException("not owner");
        varB8792231CD1EFCF3C5A33149431219B9_1318396385.addTaint(taint);
        throw varB8792231CD1EFCF3C5A33149431219B9_1318396385;
        }
Collection<Thread> var2F6B35A4A5F0D194270D94D1FD44EBD7_1701860147 =         sync.getWaitingThreads((AbstractQueuedSynchronizer.ConditionObject)condition);
        var2F6B35A4A5F0D194270D94D1FD44EBD7_1701860147.addTaint(taint);
        return var2F6B35A4A5F0D194270D94D1FD44EBD7_1701860147;
        // ---------- Original Method ----------
        //if (condition == null)
            //throw new NullPointerException();
        //if (!(condition instanceof AbstractQueuedSynchronizer.ConditionObject))
            //throw new IllegalArgumentException("not owner");
        //return sync.getWaitingThreads((AbstractQueuedSynchronizer.ConditionObject)condition);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.941 -0400", hash_original_method = "E0C199518E39715763AFB28F76F97305", hash_generated_method = "74AA1892173EA0A3F8E3E9CF7BA5DC97")
    public String toString() {
        Thread o = sync.getOwner();
String var712A538455E0066CABFC7E39FF5F51C3_1308303269 =         super.toString() + ((o == null) ?
                                   "[Unlocked]" :
                                   "[Locked by thread " + o.getName() + "]");
        var712A538455E0066CABFC7E39FF5F51C3_1308303269.addTaint(taint);
        return var712A538455E0066CABFC7E39FF5F51C3_1308303269;
        // ---------- Original Method ----------
        //Thread o = sync.getOwner();
        //return super.toString() + ((o == null) ?
                                   //"[Unlocked]" :
                                   //"[Locked by thread " + o.getName() + "]");
    }

    
    abstract static class Sync extends AbstractQueuedSynchronizer {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.941 -0400", hash_original_method = "88F1B6F2E189B36E0DD98AFBD02FE2C7", hash_generated_method = "88F1B6F2E189B36E0DD98AFBD02FE2C7")
        public Sync ()
        {
            //Synthesized constructor
        }


        abstract void lock();

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.942 -0400", hash_original_method = "D19DB0AA686FDE0FA905238F42C3F88E", hash_generated_method = "6EB5699601CCEAC7441C90F2D653135C")
        final boolean nonfairTryAcquire(int acquires) {
            addTaint(acquires);
            final Thread current = Thread.currentThread();
            int c = getState();
    if(c == 0)            
            {
    if(compareAndSetState(0, acquires))                
                {
                    setExclusiveOwnerThread(current);
                    boolean varB326B5062B2F0E69046810717534CB09_305823535 = (true);
                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2141777037 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_2141777037;
                } //End block
            } //End block
            else
    if(current == getExclusiveOwnerThread())            
            {
                int nextc = c + acquires;
    if(nextc < 0)                
                {
                Error var095BEDC30C458CE8F7BCE7A524D79305_1703189710 = new Error("Maximum lock count exceeded");
                var095BEDC30C458CE8F7BCE7A524D79305_1703189710.addTaint(taint);
                throw var095BEDC30C458CE8F7BCE7A524D79305_1703189710;
                }
                setState(nextc);
                boolean varB326B5062B2F0E69046810717534CB09_155025022 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1851155380 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1851155380;
            } //End block
            boolean var68934A3E9455FA72420237EB05902327_739164560 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1747728746 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1747728746;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.943 -0400", hash_original_method = "F58D783FAFD21E630011410A68B89B8B", hash_generated_method = "A675D819C976270BC1204C6923D24D09")
        protected final boolean tryRelease(int releases) {
            addTaint(releases);
            int c = getState() - releases;
    if(Thread.currentThread() != getExclusiveOwnerThread())            
            {
            IllegalMonitorStateException var9D4F198B973DC32951341758A9D245B5_1148488067 = new IllegalMonitorStateException();
            var9D4F198B973DC32951341758A9D245B5_1148488067.addTaint(taint);
            throw var9D4F198B973DC32951341758A9D245B5_1148488067;
            }
            boolean free = false;
    if(c == 0)            
            {
                free = true;
                setExclusiveOwnerThread(null);
            } //End block
            setState(c);
            boolean varAA2D6E4F578EB0CFABA23BEEF76C2194_22719434 = (free);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1838720021 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1838720021;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.944 -0400", hash_original_method = "A843CC28FFAE9A089B89A0058BA2B9D5", hash_generated_method = "A95D6B22521F228DC12FE04F21B4684E")
        protected final boolean isHeldExclusively() {
            boolean var209567A654B1FCE1B2039A97387DA4E2_1372021002 = (getExclusiveOwnerThread() == Thread.currentThread());
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_966912789 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_966912789;
            // ---------- Original Method ----------
            //return getExclusiveOwnerThread() == Thread.currentThread();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.944 -0400", hash_original_method = "093F0D0E6A279CA43864791B6FD65040", hash_generated_method = "5BDF702DF148AB9081ED206BE27B6F56")
        final ConditionObject newCondition() {
ConditionObject var01D80487DA347E7B28ACEC08E954FD99_1215239581 =             new ConditionObject();
            var01D80487DA347E7B28ACEC08E954FD99_1215239581.addTaint(taint);
            return var01D80487DA347E7B28ACEC08E954FD99_1215239581;
            // ---------- Original Method ----------
            //return new ConditionObject();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.944 -0400", hash_original_method = "24CA7AAFB844A1400E08D949A036E749", hash_generated_method = "517536100EA831E81E099A5EE0F74BC4")
        final Thread getOwner() {
Thread var9A18AC0B80ECEE9576AADF73FC28AEC2_741187584 =             getState() == 0 ? null : getExclusiveOwnerThread();
            var9A18AC0B80ECEE9576AADF73FC28AEC2_741187584.addTaint(taint);
            return var9A18AC0B80ECEE9576AADF73FC28AEC2_741187584;
            // ---------- Original Method ----------
            //return getState() == 0 ? null : getExclusiveOwnerThread();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.945 -0400", hash_original_method = "9566A514E32EED07D696F4866CA45F30", hash_generated_method = "93083C1EFE1934EFF1AB94D12F77378A")
        final int getHoldCount() {
            int varE76C236C61E378D6714ED86325FF558D_1817600078 = (isHeldExclusively() ? getState() : 0);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1095988610 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1095988610;
            // ---------- Original Method ----------
            //return isHeldExclusively() ? getState() : 0;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.945 -0400", hash_original_method = "89AB065792F4703E484ABCB3E61E822C", hash_generated_method = "09B96CE123FD58ADA491BCD650256485")
        final boolean isLocked() {
            boolean var2A32036BD18B2706112116E63B6B14FE_312060090 = (getState() != 0);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1031158916 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1031158916;
            // ---------- Original Method ----------
            //return getState() != 0;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.945 -0400", hash_original_method = "05D5902ED2395493955B66F039D49364", hash_generated_method = "75645607B1168731113488FBAFB4AB43")
        private void readObject(java.io.ObjectInputStream s) throws java.io.IOException, ClassNotFoundException {
            addTaint(s.getTaint());
            s.defaultReadObject();
            setState(0);
            // ---------- Original Method ----------
            //s.defaultReadObject();
            //setState(0);
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.945 -0400", hash_original_field = "664BADC4FCE0F56881AF4EC0C44FC7CE", hash_generated_field = "11262B0B520D47FEDD0C78D205387B55")

        private static final long serialVersionUID = -5179523762034025860L;
    }


    
    static final class NonfairSync extends Sync {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.946 -0400", hash_original_method = "92700F1FF079627760B83F1F338B8E6E", hash_generated_method = "92700F1FF079627760B83F1F338B8E6E")
        public NonfairSync ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.946 -0400", hash_original_method = "250EC96D0AD0D747189CAF2CF367FDFE", hash_generated_method = "C1ADB03F5AA8922EA3C09621A8FCA1D5")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.946 -0400", hash_original_method = "4FB92A369E0871387D4F8186DCD16A26", hash_generated_method = "EB403E524E4A5329251661CC080BD905")
        protected final boolean tryAcquire(int acquires) {
            addTaint(acquires);
            boolean varF3133CF2A6709F1FDC477885EF5D5576_1930937080 = (nonfairTryAcquire(acquires));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1654115704 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1654115704;
            // ---------- Original Method ----------
            //return nonfairTryAcquire(acquires);
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.947 -0400", hash_original_field = "BD27C19ACD1B65DD9363F71DE1851218", hash_generated_field = "58C60847CF2F2D2F1CEF07DFE5BA201D")

        private static final long serialVersionUID = 7316153563782823691L;
    }


    
    static final class FairSync extends Sync {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.947 -0400", hash_original_method = "76BFFA90730B34917875BAE48AE8B396", hash_generated_method = "76BFFA90730B34917875BAE48AE8B396")
        public FairSync ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.947 -0400", hash_original_method = "E6AC2D5893CA21F5681F81CF00C94AEB", hash_generated_method = "EA04A5A8DEC9D6FD4587640A48DF018E")
        final void lock() {
            acquire(1);
            // ---------- Original Method ----------
            //acquire(1);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.948 -0400", hash_original_method = "81B34FC5A1F152836CFB423B4391D12C", hash_generated_method = "0B861340A7F84D6B098A62920CD9AB71")
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
                    boolean varB326B5062B2F0E69046810717534CB09_1540313701 = (true);
                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1308827868 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_1308827868;
                } //End block
            } //End block
            else
    if(current == getExclusiveOwnerThread())            
            {
                int nextc = c + acquires;
    if(nextc < 0)                
                {
                Error var095BEDC30C458CE8F7BCE7A524D79305_1267298289 = new Error("Maximum lock count exceeded");
                var095BEDC30C458CE8F7BCE7A524D79305_1267298289.addTaint(taint);
                throw var095BEDC30C458CE8F7BCE7A524D79305_1267298289;
                }
                setState(nextc);
                boolean varB326B5062B2F0E69046810717534CB09_698720956 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_538476088 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_538476088;
            } //End block
            boolean var68934A3E9455FA72420237EB05902327_184519251 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1355065427 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1355065427;
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

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.949 -0400", hash_original_field = "D17C09047856F96A00E27AA866549B69", hash_generated_field = "CB1921210AFFA16906C257D2951975DC")

        private static final long serialVersionUID = -3000897897090466540L;
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.949 -0400", hash_original_field = "16EBB3E5C40DD288F8E94BD3EE8B7D56", hash_generated_field = "190C3E77BD396A2688499FE9C5D2BE14")

    private static final long serialVersionUID = 7373984872572414699L;
}

