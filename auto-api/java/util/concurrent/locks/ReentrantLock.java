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
    private Sync sync;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.220 -0400", hash_original_method = "CAF4BD8277F97E8E8A833F3DA738B0B2", hash_generated_method = "D575B8316542FC333CB3BC5C812414AD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ReentrantLock() {
        sync = new NonfairSync();
        // ---------- Original Method ----------
        //sync = new NonfairSync();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.221 -0400", hash_original_method = "D5E979A18BF9FB96236498521D2048B7", hash_generated_method = "9A95C377335F907931C2218D7CFF6D36")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ReentrantLock(boolean fair) {
        dsTaint.addTaint(fair);
        sync = fair ? new FairSync() : new NonfairSync();
        // ---------- Original Method ----------
        //sync = fair ? new FairSync() : new NonfairSync();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.221 -0400", hash_original_method = "97675D396F33E00D31856AF34DD1ED6B", hash_generated_method = "F69D427B4A2E72BA43563F8DEC741F82")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void lock() {
        sync.lock();
        // ---------- Original Method ----------
        //sync.lock();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.221 -0400", hash_original_method = "5966BE77DAE264B5F21646B0E7A08FC1", hash_generated_method = "CFF689BB53A067D7B9EB5F12CA3F00CC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void lockInterruptibly() throws InterruptedException {
        sync.acquireInterruptibly(1);
        // ---------- Original Method ----------
        //sync.acquireInterruptibly(1);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.221 -0400", hash_original_method = "9B7882D242270D7813AEE17389132741", hash_generated_method = "D80883CF2368B82BAE1EE28D3D01B21C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean tryLock() {
        boolean var01D158C305499B950DC2B450CF0A13DF_1867941188 = (sync.nonfairTryAcquire(1));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return sync.nonfairTryAcquire(1);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.221 -0400", hash_original_method = "6EF7D2E282F143C52CC20B0DBAA61A21", hash_generated_method = "B4BD5451900411B27DEDC2E5FBCB5A47")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean tryLock(long timeout, TimeUnit unit) throws InterruptedException {
        dsTaint.addTaint(unit.dsTaint);
        dsTaint.addTaint(timeout);
        boolean var032A6E2E0DFEA3BC6D0CEF4809A04918_196484656 = (sync.tryAcquireNanos(1, unit.toNanos(timeout)));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return sync.tryAcquireNanos(1, unit.toNanos(timeout));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.222 -0400", hash_original_method = "7AD42B9E2BC6DD4A4DE0EB9EBA3A2515", hash_generated_method = "87142E80D82254348B0CA43367BBC9B7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void unlock() {
        sync.release(1);
        // ---------- Original Method ----------
        //sync.release(1);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.222 -0400", hash_original_method = "6BB095C6835043568D960ACB9C15058D", hash_generated_method = "F3B050BF99872BDAF19AB65E40F2252F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Condition newCondition() {
        Condition var8D61D56731D45301D15FC2EC732DBFD7_879835941 = (sync.newCondition());
        return (Condition)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return sync.newCondition();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.222 -0400", hash_original_method = "7FC57D6521874F49E1ACFD5770F280CF", hash_generated_method = "104A28932B7E7CA326BBFAFE154C12B6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getHoldCount() {
        int var0CF7228364AC2BBEEE65804FC32AE455_1744265450 = (sync.getHoldCount());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return sync.getHoldCount();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.222 -0400", hash_original_method = "53A74F7432D74C33316852C3E739832B", hash_generated_method = "728A515EF67328D3E7B7323612B4678F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isHeldByCurrentThread() {
        boolean var12281D4A72DEB9F8816A0A46604F1374_893004162 = (sync.isHeldExclusively());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return sync.isHeldExclusively();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.222 -0400", hash_original_method = "B8A2470400F707CBBF058BF4DA6F8D15", hash_generated_method = "96D4C4C8CB27995867F94461BF7A5124")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isLocked() {
        boolean var720015946EB5BA7A9510B4F7065A84D7_1800619878 = (sync.isLocked());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return sync.isLocked();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.222 -0400", hash_original_method = "6835E283E5F9E7FBD3FF7844476992AD", hash_generated_method = "55D62964B9EF84187B0EE15ED60B4146")
    @DSModeled(DSC.SAFE)
    public final boolean isFair() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return sync instanceof FairSync;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.222 -0400", hash_original_method = "DB009A0944F572B5167ED6D51E109787", hash_generated_method = "6301EE16A02F6A58848D18F5AF366E4D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected Thread getOwner() {
        Thread var9841B14668EFDB9EA09AF644B20927F7_208507840 = (sync.getOwner());
        return (Thread)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return sync.getOwner();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.223 -0400", hash_original_method = "33B7DCC82A105082FC4D268ED56F9DE5", hash_generated_method = "A8BA0553778BBCF84455648316F178DB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final boolean hasQueuedThreads() {
        boolean var4C0A0AB508905DA8D619627A5EEFD574_1954772308 = (sync.hasQueuedThreads());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return sync.hasQueuedThreads();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.223 -0400", hash_original_method = "7B179E46CDF5B520CCEEF15512EC2C63", hash_generated_method = "1167C05B87BEF768A17976E384390B27")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final boolean hasQueuedThread(Thread thread) {
        dsTaint.addTaint(thread.dsTaint);
        boolean var0681201A478D613CAAB4B4D5196C3EF3_606996353 = (sync.isQueued(thread));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return sync.isQueued(thread);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.223 -0400", hash_original_method = "DFFF2C05339152644F00EC2FFC57EFB9", hash_generated_method = "A194A01BF0693534A40E7EC44A4313E6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final int getQueueLength() {
        int var2545CC142A0CD1008911850681315651_258408467 = (sync.getQueueLength());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return sync.getQueueLength();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.223 -0400", hash_original_method = "4BC73C35668DA24636BE58FB68209032", hash_generated_method = "31FEDBE5B3437EB0911140405A66BB6B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected Collection<Thread> getQueuedThreads() {
        Collection<Thread> var31D858562CBAED119D353541F01C16B4_1154809704 = (sync.getQueuedThreads());
        return (Collection<Thread>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return sync.getQueuedThreads();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.223 -0400", hash_original_method = "BF91F0F13FB6E88A38744502E21F1F2D", hash_generated_method = "297E4ACE28AAE06858FBFB111506FBD9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean hasWaiters(Condition condition) {
        dsTaint.addTaint(condition.dsTaint);
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("not owner");
        boolean varD78146513D32810B85075F5879934833_246148658 = (sync.hasWaiters((AbstractQueuedSynchronizer.ConditionObject)condition));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (condition == null)
            //throw new NullPointerException();
        //if (!(condition instanceof AbstractQueuedSynchronizer.ConditionObject))
            //throw new IllegalArgumentException("not owner");
        //return sync.hasWaiters((AbstractQueuedSynchronizer.ConditionObject)condition);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.224 -0400", hash_original_method = "D4277B3B6ED39F705D915D3806A5548A", hash_generated_method = "E911279000B6D608CAC1FDE12E08383F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getWaitQueueLength(Condition condition) {
        dsTaint.addTaint(condition.dsTaint);
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("not owner");
        int var60A2F707F5BC43BB059D2028F4E4733B_927858579 = (sync.getWaitQueueLength((AbstractQueuedSynchronizer.ConditionObject)condition));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //if (condition == null)
            //throw new NullPointerException();
        //if (!(condition instanceof AbstractQueuedSynchronizer.ConditionObject))
            //throw new IllegalArgumentException("not owner");
        //return sync.getWaitQueueLength((AbstractQueuedSynchronizer.ConditionObject)condition);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.224 -0400", hash_original_method = "29738EA386BFBB41E36C961DB4B1CBE5", hash_generated_method = "CE5A5FC618B2556325976274FE053BC1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected Collection<Thread> getWaitingThreads(Condition condition) {
        dsTaint.addTaint(condition.dsTaint);
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("not owner");
        Collection<Thread> varACD2ABC34A7FF03371BF6C03D9CBDA6D_2129297427 = (sync.getWaitingThreads((AbstractQueuedSynchronizer.ConditionObject)condition));
        return (Collection<Thread>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (condition == null)
            //throw new NullPointerException();
        //if (!(condition instanceof AbstractQueuedSynchronizer.ConditionObject))
            //throw new IllegalArgumentException("not owner");
        //return sync.getWaitingThreads((AbstractQueuedSynchronizer.ConditionObject)condition);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.225 -0400", hash_original_method = "E0C199518E39715763AFB28F76F97305", hash_generated_method = "588F9C933881510D86F4D5C051C3CCDD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String toString() {
        Thread o;
        o = sync.getOwner();
        String var07CE3B177FABFF5F528A4CB3F97F9E34_372540067 = (super.toString() + ((o == null) ?
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
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.225 -0400", hash_original_method = "CE5216523211DD0EDAA573C9C4B98FBA", hash_generated_method = "CE5216523211DD0EDAA573C9C4B98FBA")
                public Sync ()
        {
        }


        abstract void lock();

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.225 -0400", hash_original_method = "D19DB0AA686FDE0FA905238F42C3F88E", hash_generated_method = "589EE1E03C726C500C7FAA5619651176")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        final boolean nonfairTryAcquire(int acquires) {
            dsTaint.addTaint(acquires);
            Thread current;
            current = Thread.currentThread();
            int c;
            c = getState();
            {
                {
                    boolean varF66BF2DB7461880C09D8FA1630E5A95E_855332618 = (compareAndSetState(0, acquires));
                    {
                        setExclusiveOwnerThread(current);
                    } //End block
                } //End collapsed parenthetic
            } //End block
            {
                boolean varE75766FA74E04E655F03A151D4B25AC7_2096306897 = (current == getExclusiveOwnerThread());
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.226 -0400", hash_original_method = "F58D783FAFD21E630011410A68B89B8B", hash_generated_method = "2A42084BC8B6C08007B205C312412A72")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        protected final boolean tryRelease(int releases) {
            dsTaint.addTaint(releases);
            int c;
            c = getState() - releases;
            {
                boolean var171DA8AF5FD35C68B337E23A0EB8AC61_1974003572 = (Thread.currentThread() != getExclusiveOwnerThread());
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.226 -0400", hash_original_method = "A843CC28FFAE9A089B89A0058BA2B9D5", hash_generated_method = "8D23E8BBD1CC5A6320477E50B99AE07E")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        protected final boolean isHeldExclusively() {
            boolean var3CE6B8DE56D5A33803435E843AACF76A_507223247 = (getExclusiveOwnerThread() == Thread.currentThread());
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return getExclusiveOwnerThread() == Thread.currentThread();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.227 -0400", hash_original_method = "093F0D0E6A279CA43864791B6FD65040", hash_generated_method = "AFD2B6DF9215189AA5EA6E95BB1FFDFC")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        final ConditionObject newCondition() {
            ConditionObject var1FFAFF67C805BD7123742C98A74C613E_1104245312 = (new ConditionObject());
            return (ConditionObject)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new ConditionObject();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.228 -0400", hash_original_method = "24CA7AAFB844A1400E08D949A036E749", hash_generated_method = "9833F000F6D691E0B911ED7240134718")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        final Thread getOwner() {
            {
                boolean var90571EFDEF06809E303E51CDC673D6CF_759942884 = (getState() == 0);
                Object var5A65EDBF3EB11026AF2CEF6A260AEFA9_566114357 = (getExclusiveOwnerThread());
            } //End flattened ternary
            return (Thread)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return getState() == 0 ? null : getExclusiveOwnerThread();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.228 -0400", hash_original_method = "9566A514E32EED07D696F4866CA45F30", hash_generated_method = "88070A51EC7BA7EC9DCCABF1BF7C09B6")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        final int getHoldCount() {
            {
                boolean var34E827331B4BC7F16DFC99E8B4EE154E_280899337 = (isHeldExclusively());
                Object var2B84CA06A8A0E280C92148E0A83A6657_760703998 = (getState());
            } //End flattened ternary
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return isHeldExclusively() ? getState() : 0;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.228 -0400", hash_original_method = "89AB065792F4703E484ABCB3E61E822C", hash_generated_method = "D52BFC9447049336693EDB2690CF0558")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        final boolean isLocked() {
            boolean var3842E9A7CB6B96374140FC54D5D4BB54_2014274724 = (getState() != 0);
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return getState() != 0;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.229 -0400", hash_original_method = "05D5902ED2395493955B66F039D49364", hash_generated_method = "2A8721E23AA59E8C0B4DC6F7665D3817")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private void readObject(java.io.ObjectInputStream s) throws java.io.IOException, ClassNotFoundException {
            dsTaint.addTaint(s.dsTaint);
            s.defaultReadObject();
            setState(0);
            // ---------- Original Method ----------
            //s.defaultReadObject();
            //setState(0);
        }

        
        private static final long serialVersionUID = -5179523762034025860L;
    }


    
    static final class NonfairSync extends Sync {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.229 -0400", hash_original_method = "20DCF4B8D0A76106484C3A6D02F48055", hash_generated_method = "20DCF4B8D0A76106484C3A6D02F48055")
                public NonfairSync ()
        {
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.229 -0400", hash_original_method = "250EC96D0AD0D747189CAF2CF367FDFE", hash_generated_method = "AF8F0F0F38F241AC1EBF76447971586E")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        final void lock() {
            {
                boolean varF425053993EA879E03DA150C877D7F5C_1252241262 = (compareAndSetState(0, 1));
                setExclusiveOwnerThread(Thread.currentThread());
                acquire(1);
            } //End collapsed parenthetic
            // ---------- Original Method ----------
            //if (compareAndSetState(0, 1))
                //setExclusiveOwnerThread(Thread.currentThread());
            //else
                //acquire(1);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.229 -0400", hash_original_method = "4FB92A369E0871387D4F8186DCD16A26", hash_generated_method = "1C8B148B273732A484ED048323A67F32")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        protected final boolean tryAcquire(int acquires) {
            dsTaint.addTaint(acquires);
            boolean var0265CA842894C6CCF4077B7A67F336BF_873002276 = (nonfairTryAcquire(acquires));
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return nonfairTryAcquire(acquires);
        }

        
        private static final long serialVersionUID = 7316153563782823691L;
    }


    
    static final class FairSync extends Sync {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.229 -0400", hash_original_method = "B5EC066612CC52332AC9D759710B6A7C", hash_generated_method = "B5EC066612CC52332AC9D759710B6A7C")
                public FairSync ()
        {
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.229 -0400", hash_original_method = "E6AC2D5893CA21F5681F81CF00C94AEB", hash_generated_method = "EA04A5A8DEC9D6FD4587640A48DF018E")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        final void lock() {
            acquire(1);
            // ---------- Original Method ----------
            //acquire(1);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.229 -0400", hash_original_method = "81B34FC5A1F152836CFB423B4391D12C", hash_generated_method = "B7BB9290A7A25D7899A9409A2DF4795B")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        protected final boolean tryAcquire(int acquires) {
            dsTaint.addTaint(acquires);
            Thread current;
            current = Thread.currentThread();
            int c;
            c = getState();
            {
                {
                    boolean var5AC1E5DC83FB6F44EFD60F65BD367A21_143867313 = (!hasQueuedPredecessors() &&
                    compareAndSetState(0, acquires));
                    {
                        setExclusiveOwnerThread(current);
                    } //End block
                } //End collapsed parenthetic
            } //End block
            {
                boolean varE75766FA74E04E655F03A151D4B25AC7_460742021 = (current == getExclusiveOwnerThread());
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

        
        private static final long serialVersionUID = -3000897897090466540L;
    }


    
    private static final long serialVersionUID = 7373984872572414699L;
}

