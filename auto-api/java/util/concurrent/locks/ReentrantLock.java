package java.util.concurrent.locks;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.*;

public class ReentrantLock implements Lock, java.io.Serializable {
    private static long serialVersionUID = 7373984872572414699L;
    private Sync sync;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:13:29.615 -0400", hash_original_method = "CAF4BD8277F97E8E8A833F3DA738B0B2", hash_generated_method = "280DDDBD309D11E0E60A27E69059E896")
    @DSModeled(DSC.SAFE)
    public ReentrantLock() {
        sync = new NonfairSync();
        // ---------- Original Method ----------
        //sync = new NonfairSync();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:13:29.628 -0400", hash_original_method = "D5E979A18BF9FB96236498521D2048B7", hash_generated_method = "C8570869499419D8C69AFC13C0AC98DB")
    @DSModeled(DSC.SAFE)
    public ReentrantLock(boolean fair) {
        dsTaint.addTaint(fair);
        sync = fair ? new FairSync() : new NonfairSync();
        // ---------- Original Method ----------
        //sync = fair ? new FairSync() : new NonfairSync();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:13:29.692 -0400", hash_original_method = "97675D396F33E00D31856AF34DD1ED6B", hash_generated_method = "2ECAF7CB7FA90D3BF00BE3B835D0DE1F")
    @DSModeled(DSC.SAFE)
    public void lock() {
        sync.lock();
        // ---------- Original Method ----------
        //sync.lock();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:13:29.697 -0400", hash_original_method = "5966BE77DAE264B5F21646B0E7A08FC1", hash_generated_method = "514A6A0D88F9F385AE71FC60BB19B78B")
    @DSModeled(DSC.SAFE)
    public void lockInterruptibly() throws InterruptedException {
        sync.acquireInterruptibly(1);
        // ---------- Original Method ----------
        //sync.acquireInterruptibly(1);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:13:29.705 -0400", hash_original_method = "9B7882D242270D7813AEE17389132741", hash_generated_method = "CAD77C40582F98E87F53BE32C35D9598")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean tryLock() {
        boolean var01D158C305499B950DC2B450CF0A13DF_623300695 = (sync.nonfairTryAcquire(1));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return sync.nonfairTryAcquire(1);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:13:29.738 -0400", hash_original_method = "6EF7D2E282F143C52CC20B0DBAA61A21", hash_generated_method = "95539EAFB42E9C7F31E9DC544869DEC5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean tryLock(long timeout, TimeUnit unit) throws InterruptedException {
        dsTaint.addTaint(unit.dsTaint);
        dsTaint.addTaint(timeout);
        boolean var032A6E2E0DFEA3BC6D0CEF4809A04918_47627259 = (sync.tryAcquireNanos(1, unit.toNanos(timeout)));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return sync.tryAcquireNanos(1, unit.toNanos(timeout));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:13:29.749 -0400", hash_original_method = "7AD42B9E2BC6DD4A4DE0EB9EBA3A2515", hash_generated_method = "CBE14A8287054E66CFC35BAD3F4C1141")
    @DSModeled(DSC.SAFE)
    public void unlock() {
        sync.release(1);
        // ---------- Original Method ----------
        //sync.release(1);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:13:29.757 -0400", hash_original_method = "6BB095C6835043568D960ACB9C15058D", hash_generated_method = "4FE3174B905178F7A6913F4AE5D74965")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Condition newCondition() {
        Condition var8D61D56731D45301D15FC2EC732DBFD7_512752415 = (sync.newCondition());
        return (Condition)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return sync.newCondition();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:13:29.767 -0400", hash_original_method = "7FC57D6521874F49E1ACFD5770F280CF", hash_generated_method = "CC7E1E3C8ED9605A3C33B4CE1FC14CBC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getHoldCount() {
        int var0CF7228364AC2BBEEE65804FC32AE455_1130596324 = (sync.getHoldCount());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return sync.getHoldCount();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:13:29.776 -0400", hash_original_method = "53A74F7432D74C33316852C3E739832B", hash_generated_method = "B48C694DD8CB8971610495CCAA7DB8BD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isHeldByCurrentThread() {
        boolean var12281D4A72DEB9F8816A0A46604F1374_360233321 = (sync.isHeldExclusively());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return sync.isHeldExclusively();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:13:29.790 -0400", hash_original_method = "B8A2470400F707CBBF058BF4DA6F8D15", hash_generated_method = "8636E274D3D6CA567D6D46A4E03C59B8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isLocked() {
        boolean var720015946EB5BA7A9510B4F7065A84D7_146519192 = (sync.isLocked());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return sync.isLocked();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:13:29.802 -0400", hash_original_method = "6835E283E5F9E7FBD3FF7844476992AD", hash_generated_method = "40F31E047D73F3B698B4BE0FB1C087C3")
    @DSModeled(DSC.SAFE)
    public final boolean isFair() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return sync instanceof FairSync;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:13:29.805 -0400", hash_original_method = "DB009A0944F572B5167ED6D51E109787", hash_generated_method = "F442BB8CB664AD7904C00E9EBA1E1819")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected Thread getOwner() {
        Thread var9841B14668EFDB9EA09AF644B20927F7_1843097803 = (sync.getOwner());
        return (Thread)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return sync.getOwner();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:13:29.817 -0400", hash_original_method = "33B7DCC82A105082FC4D268ED56F9DE5", hash_generated_method = "1F1617A49F57BCB1BC1A605618236AAD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final boolean hasQueuedThreads() {
        boolean var4C0A0AB508905DA8D619627A5EEFD574_953222192 = (sync.hasQueuedThreads());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return sync.hasQueuedThreads();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:13:29.829 -0400", hash_original_method = "7B179E46CDF5B520CCEEF15512EC2C63", hash_generated_method = "1A485911013E78E6F8C49C217DAAA11B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final boolean hasQueuedThread(Thread thread) {
        dsTaint.addTaint(thread.dsTaint);
        boolean var0681201A478D613CAAB4B4D5196C3EF3_468441810 = (sync.isQueued(thread));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return sync.isQueued(thread);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:13:29.837 -0400", hash_original_method = "DFFF2C05339152644F00EC2FFC57EFB9", hash_generated_method = "598DDD3CF1BAF9908BE380D75EC15622")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final int getQueueLength() {
        int var2545CC142A0CD1008911850681315651_470875118 = (sync.getQueueLength());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return sync.getQueueLength();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:13:29.845 -0400", hash_original_method = "4BC73C35668DA24636BE58FB68209032", hash_generated_method = "78F1C68DCA4DAB6242EDB4095156BD59")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected Collection<Thread> getQueuedThreads() {
        Collection<Thread> var31D858562CBAED119D353541F01C16B4_1192927234 = (sync.getQueuedThreads());
        return (Collection<Thread>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return sync.getQueuedThreads();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:13:29.864 -0400", hash_original_method = "BF91F0F13FB6E88A38744502E21F1F2D", hash_generated_method = "644853ACB06CFDD21B7E4913E683B43F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean hasWaiters(Condition condition) {
        dsTaint.addTaint(condition.dsTaint);
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("not owner");
        boolean varD78146513D32810B85075F5879934833_188208194 = (sync.hasWaiters((AbstractQueuedSynchronizer.ConditionObject)condition));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (condition == null)
            //throw new NullPointerException();
        //if (!(condition instanceof AbstractQueuedSynchronizer.ConditionObject))
            //throw new IllegalArgumentException("not owner");
        //return sync.hasWaiters((AbstractQueuedSynchronizer.ConditionObject)condition);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:13:29.878 -0400", hash_original_method = "D4277B3B6ED39F705D915D3806A5548A", hash_generated_method = "E8191F9BD7EC80AD5C0DAEC13FC90E14")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getWaitQueueLength(Condition condition) {
        dsTaint.addTaint(condition.dsTaint);
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("not owner");
        int var60A2F707F5BC43BB059D2028F4E4733B_1654529754 = (sync.getWaitQueueLength((AbstractQueuedSynchronizer.ConditionObject)condition));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //if (condition == null)
            //throw new NullPointerException();
        //if (!(condition instanceof AbstractQueuedSynchronizer.ConditionObject))
            //throw new IllegalArgumentException("not owner");
        //return sync.getWaitQueueLength((AbstractQueuedSynchronizer.ConditionObject)condition);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:13:29.894 -0400", hash_original_method = "29738EA386BFBB41E36C961DB4B1CBE5", hash_generated_method = "E6C802EE0D72D70263E3CAF191FD2522")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected Collection<Thread> getWaitingThreads(Condition condition) {
        dsTaint.addTaint(condition.dsTaint);
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("not owner");
        Collection<Thread> varACD2ABC34A7FF03371BF6C03D9CBDA6D_987663166 = (sync.getWaitingThreads((AbstractQueuedSynchronizer.ConditionObject)condition));
        return (Collection<Thread>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (condition == null)
            //throw new NullPointerException();
        //if (!(condition instanceof AbstractQueuedSynchronizer.ConditionObject))
            //throw new IllegalArgumentException("not owner");
        //return sync.getWaitingThreads((AbstractQueuedSynchronizer.ConditionObject)condition);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:13:29.911 -0400", hash_original_method = "E0C199518E39715763AFB28F76F97305", hash_generated_method = "9FDBA0EAB4976321EA437DA87BC19BE9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String toString() {
        Thread o;
        o = sync.getOwner();
        String var07CE3B177FABFF5F528A4CB3F97F9E34_2140855948 = (super.toString() + ((o == null) ?
                                   "[Unlocked]" :
                                   "[Locked by thread " + o.getName() + "]")); //DSFIXME:  CODE0008: Nested ternary operator in expression
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //Thread o = sync.getOwner();
        //return super.toString() + ((o == null) ?
                                   //"[Unlocked]" :
                                   //"[Locked by thread " + o.getName() + "]");
    }

    
    abstract static class Sync extends AbstractQueuedSynchronizer {
        private static long serialVersionUID = -5179523762034025860L;
        
        abstract void lock();

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:13:29.949 -0400", hash_original_method = "D19DB0AA686FDE0FA905238F42C3F88E", hash_generated_method = "F58B595ED4D615C4E89F89906987A292")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        final boolean nonfairTryAcquire(int acquires) {
            dsTaint.addTaint(acquires);
            Thread current;
            current = Thread.currentThread();
            int c;
            c = getState();
            {
                {
                    boolean varF66BF2DB7461880C09D8FA1630E5A95E_1523758080 = (compareAndSetState(0, acquires));
                    {
                        setExclusiveOwnerThread(current);
                    } //End block
                } //End collapsed parenthetic
            } //End block
            {
                boolean varE75766FA74E04E655F03A151D4B25AC7_1794852162 = (current == getExclusiveOwnerThread());
                {
                    int nextc;
                    nextc = c + acquires;
                    if (DroidSafeAndroidRuntime.control) throw new Error("Maximum lock count exceeded");
                    setState(nextc);
                } //End block
            } //End collapsed parenthetic
            return dsTaint.getTaintBoolean();
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:13:29.975 -0400", hash_original_method = "F58D783FAFD21E630011410A68B89B8B", hash_generated_method = "A926FA0E652DA5855B3B6661E97EEB7A")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        protected final boolean tryRelease(int releases) {
            dsTaint.addTaint(releases);
            int c;
            c = getState() - releases;
            {
                boolean var171DA8AF5FD35C68B337E23A0EB8AC61_1582511284 = (Thread.currentThread() != getExclusiveOwnerThread());
                if (DroidSafeAndroidRuntime.control) throw new IllegalMonitorStateException();
            } //End collapsed parenthetic
            boolean free;
            free = false;
            {
                free = true;
                setExclusiveOwnerThread(null);
            } //End block
            setState(c);
            return dsTaint.getTaintBoolean();
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:13:29.990 -0400", hash_original_method = "A843CC28FFAE9A089B89A0058BA2B9D5", hash_generated_method = "D3F1D431A1D0BB6D3C9A3F12DD88329B")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        protected final boolean isHeldExclusively() {
            boolean var3CE6B8DE56D5A33803435E843AACF76A_68018482 = (getExclusiveOwnerThread() == Thread.currentThread());
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return getExclusiveOwnerThread() == Thread.currentThread();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:13:29.997 -0400", hash_original_method = "093F0D0E6A279CA43864791B6FD65040", hash_generated_method = "8AA34E3FD2711094A803E6A05A1AF47C")
        @DSModeled(DSC.SAFE)
        final ConditionObject newCondition() {
            return (ConditionObject)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new ConditionObject();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:13:30.015 -0400", hash_original_method = "24CA7AAFB844A1400E08D949A036E749", hash_generated_method = "B805C756E6F07C6AF8B901A79F38DFA8")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        final Thread getOwner() {
            {
                boolean var90571EFDEF06809E303E51CDC673D6CF_699989329 = (getState() == 0);
                Object var5A65EDBF3EB11026AF2CEF6A260AEFA9_998135659 = (getExclusiveOwnerThread());
            } //End flattened ternary
            return (Thread)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return getState() == 0 ? null : getExclusiveOwnerThread();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:13:30.031 -0400", hash_original_method = "9566A514E32EED07D696F4866CA45F30", hash_generated_method = "4FFB50AD5CE7A5F1E1B2C517B115C589")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        final int getHoldCount() {
            {
                boolean var34E827331B4BC7F16DFC99E8B4EE154E_1238823245 = (isHeldExclusively());
                Object var2B84CA06A8A0E280C92148E0A83A6657_75039473 = (getState());
            } //End flattened ternary
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return isHeldExclusively() ? getState() : 0;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:13:30.042 -0400", hash_original_method = "89AB065792F4703E484ABCB3E61E822C", hash_generated_method = "8E87EDF1848069141A997AFD91DEF6B1")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        final boolean isLocked() {
            boolean var3842E9A7CB6B96374140FC54D5D4BB54_1236049522 = (getState() != 0);
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return getState() != 0;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:13:30.053 -0400", hash_original_method = "05D5902ED2395493955B66F039D49364", hash_generated_method = "61540257A782ED09CC435075FFBD8CCC")
        @DSModeled(DSC.SAFE)
        private void readObject(java.io.ObjectInputStream s) throws java.io.IOException, ClassNotFoundException {
            dsTaint.addTaint(s.dsTaint);
            s.defaultReadObject();
            setState(0);
            // ---------- Original Method ----------
            //s.defaultReadObject();
            //setState(0);
        }

        
    }


    
    static final class NonfairSync extends Sync {
        private static long serialVersionUID = 7316153563782823691L;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:13:30.066 -0400", hash_original_method = "250EC96D0AD0D747189CAF2CF367FDFE", hash_generated_method = "7DF3CE07EB52F4E83BC135CE80F54237")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        final void lock() {
            {
                boolean varF425053993EA879E03DA150C877D7F5C_51505273 = (compareAndSetState(0, 1));
                setExclusiveOwnerThread(Thread.currentThread());
                acquire(1);
            } //End collapsed parenthetic
            // ---------- Original Method ----------
            //if (compareAndSetState(0, 1))
                //setExclusiveOwnerThread(Thread.currentThread());
            //else
                //acquire(1);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:13:30.078 -0400", hash_original_method = "4FB92A369E0871387D4F8186DCD16A26", hash_generated_method = "F644E210356B1E20B21ECED2FFAA74FF")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        protected final boolean tryAcquire(int acquires) {
            dsTaint.addTaint(acquires);
            boolean var0265CA842894C6CCF4077B7A67F336BF_464375987 = (nonfairTryAcquire(acquires));
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return nonfairTryAcquire(acquires);
        }

        
    }


    
    static final class FairSync extends Sync {
        private static long serialVersionUID = -3000897897090466540L;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:13:30.089 -0400", hash_original_method = "E6AC2D5893CA21F5681F81CF00C94AEB", hash_generated_method = "CB76B2B7FC5C57685BEA82A121FACE61")
        @DSModeled(DSC.SAFE)
        final void lock() {
            acquire(1);
            // ---------- Original Method ----------
            //acquire(1);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:13:30.103 -0400", hash_original_method = "81B34FC5A1F152836CFB423B4391D12C", hash_generated_method = "17D25C84E323BDC3810A2AF8289654DB")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        protected final boolean tryAcquire(int acquires) {
            dsTaint.addTaint(acquires);
            Thread current;
            current = Thread.currentThread();
            int c;
            c = getState();
            {
                {
                    boolean var5AC1E5DC83FB6F44EFD60F65BD367A21_844678910 = (!hasQueuedPredecessors() &&
                    compareAndSetState(0, acquires));
                    {
                        setExclusiveOwnerThread(current);
                    } //End block
                } //End collapsed parenthetic
            } //End block
            {
                boolean varE75766FA74E04E655F03A151D4B25AC7_1041605365 = (current == getExclusiveOwnerThread());
                {
                    int nextc;
                    nextc = c + acquires;
                    if (DroidSafeAndroidRuntime.control) throw new Error("Maximum lock count exceeded");
                    setState(nextc);
                } //End block
            } //End collapsed parenthetic
            return dsTaint.getTaintBoolean();
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

        
    }


    
}


