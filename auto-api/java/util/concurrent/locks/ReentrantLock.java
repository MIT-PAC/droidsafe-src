package java.util.concurrent.locks;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.*;

public class ReentrantLock implements Lock, java.io.Serializable {
    private static final long serialVersionUID = 7373984872572414699L;
    private final Sync sync;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.023 -0400", hash_original_method = "CAF4BD8277F97E8E8A833F3DA738B0B2", hash_generated_method = "280DDDBD309D11E0E60A27E69059E896")
    @DSModeled(DSC.SAFE)
    public ReentrantLock() {
        sync = new NonfairSync();
        // ---------- Original Method ----------
        //sync = new NonfairSync();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.023 -0400", hash_original_method = "D5E979A18BF9FB96236498521D2048B7", hash_generated_method = "C8570869499419D8C69AFC13C0AC98DB")
    @DSModeled(DSC.SAFE)
    public ReentrantLock(boolean fair) {
        dsTaint.addTaint(fair);
        sync = fair ? new FairSync() : new NonfairSync();
        // ---------- Original Method ----------
        //sync = fair ? new FairSync() : new NonfairSync();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.023 -0400", hash_original_method = "97675D396F33E00D31856AF34DD1ED6B", hash_generated_method = "2ECAF7CB7FA90D3BF00BE3B835D0DE1F")
    @DSModeled(DSC.SAFE)
    public void lock() {
        sync.lock();
        // ---------- Original Method ----------
        //sync.lock();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.023 -0400", hash_original_method = "5966BE77DAE264B5F21646B0E7A08FC1", hash_generated_method = "514A6A0D88F9F385AE71FC60BB19B78B")
    @DSModeled(DSC.SAFE)
    public void lockInterruptibly() throws InterruptedException {
        sync.acquireInterruptibly(1);
        // ---------- Original Method ----------
        //sync.acquireInterruptibly(1);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.023 -0400", hash_original_method = "9B7882D242270D7813AEE17389132741", hash_generated_method = "E8568B7D5AB579C7A79A5F90DF4C6781")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean tryLock() {
        boolean var01D158C305499B950DC2B450CF0A13DF_491472034 = (sync.nonfairTryAcquire(1));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return sync.nonfairTryAcquire(1);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.023 -0400", hash_original_method = "6EF7D2E282F143C52CC20B0DBAA61A21", hash_generated_method = "5F23DEF0D0ACC4868F15AAE7B094BB8E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean tryLock(long timeout, TimeUnit unit) throws InterruptedException {
        dsTaint.addTaint(unit.dsTaint);
        dsTaint.addTaint(timeout);
        boolean var032A6E2E0DFEA3BC6D0CEF4809A04918_1267890566 = (sync.tryAcquireNanos(1, unit.toNanos(timeout)));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return sync.tryAcquireNanos(1, unit.toNanos(timeout));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.023 -0400", hash_original_method = "7AD42B9E2BC6DD4A4DE0EB9EBA3A2515", hash_generated_method = "CBE14A8287054E66CFC35BAD3F4C1141")
    @DSModeled(DSC.SAFE)
    public void unlock() {
        sync.release(1);
        // ---------- Original Method ----------
        //sync.release(1);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.023 -0400", hash_original_method = "6BB095C6835043568D960ACB9C15058D", hash_generated_method = "DB3E372BC72D4FE34F827EB21742C052")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Condition newCondition() {
        Condition var8D61D56731D45301D15FC2EC732DBFD7_408110952 = (sync.newCondition());
        return (Condition)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return sync.newCondition();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.023 -0400", hash_original_method = "7FC57D6521874F49E1ACFD5770F280CF", hash_generated_method = "EE6B3CC817581AD7ACC94CDA7DB1DB99")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getHoldCount() {
        int var0CF7228364AC2BBEEE65804FC32AE455_175422492 = (sync.getHoldCount());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return sync.getHoldCount();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.023 -0400", hash_original_method = "53A74F7432D74C33316852C3E739832B", hash_generated_method = "C96BA88F073BF24016B0BA31108BEB61")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isHeldByCurrentThread() {
        boolean var12281D4A72DEB9F8816A0A46604F1374_7598366 = (sync.isHeldExclusively());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return sync.isHeldExclusively();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.023 -0400", hash_original_method = "B8A2470400F707CBBF058BF4DA6F8D15", hash_generated_method = "E489AAF949E3D4A1D35B7C1853BB8CDD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isLocked() {
        boolean var720015946EB5BA7A9510B4F7065A84D7_1935102313 = (sync.isLocked());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return sync.isLocked();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.023 -0400", hash_original_method = "6835E283E5F9E7FBD3FF7844476992AD", hash_generated_method = "40F31E047D73F3B698B4BE0FB1C087C3")
    @DSModeled(DSC.SAFE)
    public final boolean isFair() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return sync instanceof FairSync;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.024 -0400", hash_original_method = "DB009A0944F572B5167ED6D51E109787", hash_generated_method = "9E5A5D83C745554F27AAF366A1F625D1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected Thread getOwner() {
        Thread var9841B14668EFDB9EA09AF644B20927F7_526700655 = (sync.getOwner());
        return (Thread)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return sync.getOwner();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.024 -0400", hash_original_method = "33B7DCC82A105082FC4D268ED56F9DE5", hash_generated_method = "CA7352D5F55851BB14EACD09A3A7249F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final boolean hasQueuedThreads() {
        boolean var4C0A0AB508905DA8D619627A5EEFD574_718993254 = (sync.hasQueuedThreads());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return sync.hasQueuedThreads();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.024 -0400", hash_original_method = "7B179E46CDF5B520CCEEF15512EC2C63", hash_generated_method = "91C341BDB75F129F52DACB242FA18CEE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final boolean hasQueuedThread(Thread thread) {
        dsTaint.addTaint(thread.dsTaint);
        boolean var0681201A478D613CAAB4B4D5196C3EF3_663078457 = (sync.isQueued(thread));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return sync.isQueued(thread);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.024 -0400", hash_original_method = "DFFF2C05339152644F00EC2FFC57EFB9", hash_generated_method = "889DE991C39B84806CF3CFC49F41AC55")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final int getQueueLength() {
        int var2545CC142A0CD1008911850681315651_20756171 = (sync.getQueueLength());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return sync.getQueueLength();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.024 -0400", hash_original_method = "4BC73C35668DA24636BE58FB68209032", hash_generated_method = "A6E43AECF0CD9C59795E651FA26C15B0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected Collection<Thread> getQueuedThreads() {
        Collection<Thread> var31D858562CBAED119D353541F01C16B4_348091681 = (sync.getQueuedThreads());
        return (Collection<Thread>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return sync.getQueuedThreads();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.024 -0400", hash_original_method = "BF91F0F13FB6E88A38744502E21F1F2D", hash_generated_method = "E47805DA385B6AACEF1CA9C57C3F0F26")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean hasWaiters(Condition condition) {
        dsTaint.addTaint(condition.dsTaint);
        throw new NullPointerException();
        throw new IllegalArgumentException("not owner");
        boolean varD78146513D32810B85075F5879934833_265438861 = (sync.hasWaiters((AbstractQueuedSynchronizer.ConditionObject)condition));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (condition == null)
            //throw new NullPointerException();
        //if (!(condition instanceof AbstractQueuedSynchronizer.ConditionObject))
            //throw new IllegalArgumentException("not owner");
        //return sync.hasWaiters((AbstractQueuedSynchronizer.ConditionObject)condition);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.024 -0400", hash_original_method = "D4277B3B6ED39F705D915D3806A5548A", hash_generated_method = "F5A1E96AF7A4FECCF340C005ABF59EC7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getWaitQueueLength(Condition condition) {
        dsTaint.addTaint(condition.dsTaint);
        throw new NullPointerException();
        throw new IllegalArgumentException("not owner");
        int var60A2F707F5BC43BB059D2028F4E4733B_714359221 = (sync.getWaitQueueLength((AbstractQueuedSynchronizer.ConditionObject)condition));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //if (condition == null)
            //throw new NullPointerException();
        //if (!(condition instanceof AbstractQueuedSynchronizer.ConditionObject))
            //throw new IllegalArgumentException("not owner");
        //return sync.getWaitQueueLength((AbstractQueuedSynchronizer.ConditionObject)condition);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.024 -0400", hash_original_method = "29738EA386BFBB41E36C961DB4B1CBE5", hash_generated_method = "5484FB1D9DF2EFB68B96232F40DCB8E0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected Collection<Thread> getWaitingThreads(Condition condition) {
        dsTaint.addTaint(condition.dsTaint);
        throw new NullPointerException();
        throw new IllegalArgumentException("not owner");
        Collection<Thread> varACD2ABC34A7FF03371BF6C03D9CBDA6D_371488076 = (sync.getWaitingThreads((AbstractQueuedSynchronizer.ConditionObject)condition));
        return (Collection<Thread>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (condition == null)
            //throw new NullPointerException();
        //if (!(condition instanceof AbstractQueuedSynchronizer.ConditionObject))
            //throw new IllegalArgumentException("not owner");
        //return sync.getWaitingThreads((AbstractQueuedSynchronizer.ConditionObject)condition);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.024 -0400", hash_original_method = "E0C199518E39715763AFB28F76F97305", hash_generated_method = "2CED97A0973BE2A2CB982EA1A07DCD07")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String toString() {
        Thread o;
        o = sync.getOwner();
        String var07CE3B177FABFF5F528A4CB3F97F9E34_497601741 = (super.toString() + ((o == null) ?
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
        private static final long serialVersionUID = -5179523762034025860L;
        
        abstract void lock();

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.024 -0400", hash_original_method = "D19DB0AA686FDE0FA905238F42C3F88E", hash_generated_method = "E871390150A9AA545FCA3B086E3F276D")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        final boolean nonfairTryAcquire(int acquires) {
            dsTaint.addTaint(acquires);
            final Thread current;
            current = Thread.currentThread();
            int c;
            c = getState();
            {
                {
                    boolean varF66BF2DB7461880C09D8FA1630E5A95E_145404548 = (compareAndSetState(0, acquires));
                    {
                        setExclusiveOwnerThread(current);
                    } //End block
                } //End collapsed parenthetic
            } //End block
            {
                boolean varE75766FA74E04E655F03A151D4B25AC7_77299622 = (current == getExclusiveOwnerThread());
                {
                    int nextc;
                    nextc = c + acquires;
                    throw new Error("Maximum lock count exceeded");
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.024 -0400", hash_original_method = "F58D783FAFD21E630011410A68B89B8B", hash_generated_method = "028946C4E637DF3ACCF202A40051B1C2")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        protected final boolean tryRelease(int releases) {
            dsTaint.addTaint(releases);
            int c;
            c = getState() - releases;
            {
                boolean var171DA8AF5FD35C68B337E23A0EB8AC61_1167214425 = (Thread.currentThread() != getExclusiveOwnerThread());
                throw new IllegalMonitorStateException();
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.024 -0400", hash_original_method = "A843CC28FFAE9A089B89A0058BA2B9D5", hash_generated_method = "DB0E090F4A792CC13FE319CA31247A42")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        protected final boolean isHeldExclusively() {
            boolean var3CE6B8DE56D5A33803435E843AACF76A_308287229 = (getExclusiveOwnerThread() == Thread.currentThread());
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return getExclusiveOwnerThread() == Thread.currentThread();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.024 -0400", hash_original_method = "093F0D0E6A279CA43864791B6FD65040", hash_generated_method = "8AA34E3FD2711094A803E6A05A1AF47C")
        @DSModeled(DSC.SAFE)
        final ConditionObject newCondition() {
            return (ConditionObject)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new ConditionObject();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.025 -0400", hash_original_method = "24CA7AAFB844A1400E08D949A036E749", hash_generated_method = "B5972B90C9D8675EAD21574F1A374D23")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        final Thread getOwner() {
            {
                boolean var90571EFDEF06809E303E51CDC673D6CF_969181335 = (getState() == 0);
                Object var5A65EDBF3EB11026AF2CEF6A260AEFA9_684085953 = (getExclusiveOwnerThread());
            } //End flattened ternary
            return (Thread)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return getState() == 0 ? null : getExclusiveOwnerThread();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.025 -0400", hash_original_method = "9566A514E32EED07D696F4866CA45F30", hash_generated_method = "8CA30C5A4EC36763A7CAAFB3B04BDD24")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        final int getHoldCount() {
            {
                boolean var34E827331B4BC7F16DFC99E8B4EE154E_455631451 = (isHeldExclusively());
                Object var2B84CA06A8A0E280C92148E0A83A6657_1385836124 = (getState());
            } //End flattened ternary
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return isHeldExclusively() ? getState() : 0;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.025 -0400", hash_original_method = "89AB065792F4703E484ABCB3E61E822C", hash_generated_method = "40392F6722A0E945904D740C48A20DAF")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        final boolean isLocked() {
            boolean var3842E9A7CB6B96374140FC54D5D4BB54_250956494 = (getState() != 0);
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return getState() != 0;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.025 -0400", hash_original_method = "05D5902ED2395493955B66F039D49364", hash_generated_method = "61540257A782ED09CC435075FFBD8CCC")
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
        private static final long serialVersionUID = 7316153563782823691L;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.025 -0400", hash_original_method = "250EC96D0AD0D747189CAF2CF367FDFE", hash_generated_method = "B31211C7F3464803464CD227EE2F3237")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        final void lock() {
            {
                boolean varF425053993EA879E03DA150C877D7F5C_1426265622 = (compareAndSetState(0, 1));
                setExclusiveOwnerThread(Thread.currentThread());
                acquire(1);
            } //End collapsed parenthetic
            // ---------- Original Method ----------
            //if (compareAndSetState(0, 1))
                //setExclusiveOwnerThread(Thread.currentThread());
            //else
                //acquire(1);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.025 -0400", hash_original_method = "4FB92A369E0871387D4F8186DCD16A26", hash_generated_method = "88E67CCBE646668A20775ED966E6255E")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        protected final boolean tryAcquire(int acquires) {
            dsTaint.addTaint(acquires);
            boolean var0265CA842894C6CCF4077B7A67F336BF_315074242 = (nonfairTryAcquire(acquires));
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return nonfairTryAcquire(acquires);
        }

        
    }


    
    static final class FairSync extends Sync {
        private static final long serialVersionUID = -3000897897090466540L;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.025 -0400", hash_original_method = "E6AC2D5893CA21F5681F81CF00C94AEB", hash_generated_method = "CB76B2B7FC5C57685BEA82A121FACE61")
        @DSModeled(DSC.SAFE)
        final void lock() {
            acquire(1);
            // ---------- Original Method ----------
            //acquire(1);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.025 -0400", hash_original_method = "81B34FC5A1F152836CFB423B4391D12C", hash_generated_method = "B4500C1E1818CD9BB5620584443CDB5C")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        protected final boolean tryAcquire(int acquires) {
            dsTaint.addTaint(acquires);
            final Thread current;
            current = Thread.currentThread();
            int c;
            c = getState();
            {
                {
                    boolean var5AC1E5DC83FB6F44EFD60F65BD367A21_1068929822 = (!hasQueuedPredecessors() &&
                    compareAndSetState(0, acquires));
                    {
                        setExclusiveOwnerThread(current);
                    } //End block
                } //End collapsed parenthetic
            } //End block
            {
                boolean varE75766FA74E04E655F03A151D4B25AC7_2123593278 = (current == getExclusiveOwnerThread());
                {
                    int nextc;
                    nextc = c + acquires;
                    throw new Error("Maximum lock count exceeded");
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


