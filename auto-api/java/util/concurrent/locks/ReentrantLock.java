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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:58.187 -0400", hash_original_field = "63AD9D34F3503826E5F649AE6B7AC92C", hash_generated_field = "A4B34EF3CE38520839B34A2F06599243")

    private Sync sync;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:58.188 -0400", hash_original_method = "CAF4BD8277F97E8E8A833F3DA738B0B2", hash_generated_method = "D575B8316542FC333CB3BC5C812414AD")
    public  ReentrantLock() {
        sync = new NonfairSync();
        // ---------- Original Method ----------
        //sync = new NonfairSync();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:58.188 -0400", hash_original_method = "D5E979A18BF9FB96236498521D2048B7", hash_generated_method = "A41781E53E248156CFB216376FFDC140")
    public  ReentrantLock(boolean fair) {
        sync = fair ? new FairSync() : new NonfairSync();
        // ---------- Original Method ----------
        //sync = fair ? new FairSync() : new NonfairSync();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:58.189 -0400", hash_original_method = "97675D396F33E00D31856AF34DD1ED6B", hash_generated_method = "F69D427B4A2E72BA43563F8DEC741F82")
    public void lock() {
        sync.lock();
        // ---------- Original Method ----------
        //sync.lock();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:58.189 -0400", hash_original_method = "5966BE77DAE264B5F21646B0E7A08FC1", hash_generated_method = "CFF689BB53A067D7B9EB5F12CA3F00CC")
    public void lockInterruptibly() throws InterruptedException {
        sync.acquireInterruptibly(1);
        // ---------- Original Method ----------
        //sync.acquireInterruptibly(1);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:58.189 -0400", hash_original_method = "9B7882D242270D7813AEE17389132741", hash_generated_method = "B0C219A30835AD5E21A72A07C0F14F52")
    public boolean tryLock() {
        boolean var01D158C305499B950DC2B450CF0A13DF_1507757235 = (sync.nonfairTryAcquire(1));
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_912159587 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_912159587;
        // ---------- Original Method ----------
        //return sync.nonfairTryAcquire(1);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:58.190 -0400", hash_original_method = "6EF7D2E282F143C52CC20B0DBAA61A21", hash_generated_method = "E453BFD97CA9AC6BB767F066EC7767CA")
    public boolean tryLock(long timeout, TimeUnit unit) throws InterruptedException {
        boolean var032A6E2E0DFEA3BC6D0CEF4809A04918_1401941390 = (sync.tryAcquireNanos(1, unit.toNanos(timeout)));
        addTaint(timeout);
        addTaint(unit.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_236843729 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_236843729;
        // ---------- Original Method ----------
        //return sync.tryAcquireNanos(1, unit.toNanos(timeout));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:58.205 -0400", hash_original_method = "7AD42B9E2BC6DD4A4DE0EB9EBA3A2515", hash_generated_method = "87142E80D82254348B0CA43367BBC9B7")
    public void unlock() {
        sync.release(1);
        // ---------- Original Method ----------
        //sync.release(1);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:58.206 -0400", hash_original_method = "6BB095C6835043568D960ACB9C15058D", hash_generated_method = "77CCAC26B3520C7096A2A1E00E39B72F")
    public Condition newCondition() {
        Condition varB4EAC82CA7396A68D541C85D26508E83_949217345 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_949217345 = sync.newCondition();
        varB4EAC82CA7396A68D541C85D26508E83_949217345.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_949217345;
        // ---------- Original Method ----------
        //return sync.newCondition();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:58.206 -0400", hash_original_method = "7FC57D6521874F49E1ACFD5770F280CF", hash_generated_method = "EFB2FDEDC61D00F253BE79FC89AB3B31")
    public int getHoldCount() {
        int var0CF7228364AC2BBEEE65804FC32AE455_645076431 = (sync.getHoldCount());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1836765523 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1836765523;
        // ---------- Original Method ----------
        //return sync.getHoldCount();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:58.206 -0400", hash_original_method = "53A74F7432D74C33316852C3E739832B", hash_generated_method = "B4460EA6C3F08986542FE1EFFA6BF753")
    public boolean isHeldByCurrentThread() {
        boolean var12281D4A72DEB9F8816A0A46604F1374_1801071849 = (sync.isHeldExclusively());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_978663465 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_978663465;
        // ---------- Original Method ----------
        //return sync.isHeldExclusively();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:58.206 -0400", hash_original_method = "B8A2470400F707CBBF058BF4DA6F8D15", hash_generated_method = "8DB7A89FAAF6B0ED1DD57569FBA9EC9A")
    public boolean isLocked() {
        boolean var720015946EB5BA7A9510B4F7065A84D7_116890949 = (sync.isLocked());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1508308671 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1508308671;
        // ---------- Original Method ----------
        //return sync.isLocked();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:58.207 -0400", hash_original_method = "6835E283E5F9E7FBD3FF7844476992AD", hash_generated_method = "EFD15E28EDA014625D4DA298AD74233D")
    public final boolean isFair() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_967558496 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_967558496;
        // ---------- Original Method ----------
        //return sync instanceof FairSync;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:58.207 -0400", hash_original_method = "DB009A0944F572B5167ED6D51E109787", hash_generated_method = "9D704E8556853C9DE2BD7E18EE1F8F19")
    protected Thread getOwner() {
        Thread varB4EAC82CA7396A68D541C85D26508E83_402770492 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_402770492 = sync.getOwner();
        varB4EAC82CA7396A68D541C85D26508E83_402770492.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_402770492;
        // ---------- Original Method ----------
        //return sync.getOwner();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:58.207 -0400", hash_original_method = "33B7DCC82A105082FC4D268ED56F9DE5", hash_generated_method = "0CD2FBE0B5E95E357B6212F56E00AE84")
    public final boolean hasQueuedThreads() {
        boolean var4C0A0AB508905DA8D619627A5EEFD574_272040463 = (sync.hasQueuedThreads());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_753788436 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_753788436;
        // ---------- Original Method ----------
        //return sync.hasQueuedThreads();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:58.208 -0400", hash_original_method = "7B179E46CDF5B520CCEEF15512EC2C63", hash_generated_method = "23FA2CD257DAF5CABCEE65D69D57624A")
    public final boolean hasQueuedThread(Thread thread) {
        boolean var0681201A478D613CAAB4B4D5196C3EF3_3906961 = (sync.isQueued(thread));
        addTaint(thread.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1476096672 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1476096672;
        // ---------- Original Method ----------
        //return sync.isQueued(thread);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:58.208 -0400", hash_original_method = "DFFF2C05339152644F00EC2FFC57EFB9", hash_generated_method = "471EE6CAA7A98E686510AA79417F037F")
    public final int getQueueLength() {
        int var2545CC142A0CD1008911850681315651_1835549795 = (sync.getQueueLength());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1472258952 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1472258952;
        // ---------- Original Method ----------
        //return sync.getQueueLength();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:58.208 -0400", hash_original_method = "4BC73C35668DA24636BE58FB68209032", hash_generated_method = "75CB828D4094E93358AB1F8247E8319E")
    protected Collection<Thread> getQueuedThreads() {
        Collection<Thread> varB4EAC82CA7396A68D541C85D26508E83_2003523057 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2003523057 = sync.getQueuedThreads();
        varB4EAC82CA7396A68D541C85D26508E83_2003523057.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2003523057;
        // ---------- Original Method ----------
        //return sync.getQueuedThreads();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:58.209 -0400", hash_original_method = "BF91F0F13FB6E88A38744502E21F1F2D", hash_generated_method = "22A2FA04213A74C4F4E1A11EF47D5F96")
    public boolean hasWaiters(Condition condition) {
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("not owner");
        boolean varD78146513D32810B85075F5879934833_853883548 = (sync.hasWaiters((AbstractQueuedSynchronizer.ConditionObject)condition));
        addTaint(condition.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1620830467 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1620830467;
        // ---------- Original Method ----------
        //if (condition == null)
            //throw new NullPointerException();
        //if (!(condition instanceof AbstractQueuedSynchronizer.ConditionObject))
            //throw new IllegalArgumentException("not owner");
        //return sync.hasWaiters((AbstractQueuedSynchronizer.ConditionObject)condition);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:58.235 -0400", hash_original_method = "D4277B3B6ED39F705D915D3806A5548A", hash_generated_method = "B305645ACECF4856C76A0A0672E65C0C")
    public int getWaitQueueLength(Condition condition) {
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("not owner");
        int var60A2F707F5BC43BB059D2028F4E4733B_38587876 = (sync.getWaitQueueLength((AbstractQueuedSynchronizer.ConditionObject)condition));
        addTaint(condition.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_769492610 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_769492610;
        // ---------- Original Method ----------
        //if (condition == null)
            //throw new NullPointerException();
        //if (!(condition instanceof AbstractQueuedSynchronizer.ConditionObject))
            //throw new IllegalArgumentException("not owner");
        //return sync.getWaitQueueLength((AbstractQueuedSynchronizer.ConditionObject)condition);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:58.236 -0400", hash_original_method = "29738EA386BFBB41E36C961DB4B1CBE5", hash_generated_method = "50C4C9C797BB8A358E8E9594C5CC0D6F")
    protected Collection<Thread> getWaitingThreads(Condition condition) {
        Collection<Thread> varB4EAC82CA7396A68D541C85D26508E83_1183818654 = null; //Variable for return #1
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("not owner");
        varB4EAC82CA7396A68D541C85D26508E83_1183818654 = sync.getWaitingThreads((AbstractQueuedSynchronizer.ConditionObject)condition);
        addTaint(condition.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1183818654.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1183818654;
        // ---------- Original Method ----------
        //if (condition == null)
            //throw new NullPointerException();
        //if (!(condition instanceof AbstractQueuedSynchronizer.ConditionObject))
            //throw new IllegalArgumentException("not owner");
        //return sync.getWaitingThreads((AbstractQueuedSynchronizer.ConditionObject)condition);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:58.237 -0400", hash_original_method = "E0C199518E39715763AFB28F76F97305", hash_generated_method = "351D117349ED0C3B5B8CE3E36E2AB79C")
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_1111674365 = null; //Variable for return #1
        Thread o;
        o = sync.getOwner();
        varB4EAC82CA7396A68D541C85D26508E83_1111674365 = super.toString() + ((o == null) ?
                                   "[Unlocked]" :
                                   "[Locked by thread " + o.getName() + "]");
        varB4EAC82CA7396A68D541C85D26508E83_1111674365.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1111674365;
        // ---------- Original Method ----------
        //Thread o = sync.getOwner();
        //return super.toString() + ((o == null) ?
                                   //"[Unlocked]" :
                                   //"[Locked by thread " + o.getName() + "]");
    }

    
    abstract static class Sync extends AbstractQueuedSynchronizer {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:58.237 -0400", hash_original_method = "88F1B6F2E189B36E0DD98AFBD02FE2C7", hash_generated_method = "88F1B6F2E189B36E0DD98AFBD02FE2C7")
        public Sync ()
        {
            //Synthesized constructor
        }


        abstract void lock();

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:58.238 -0400", hash_original_method = "D19DB0AA686FDE0FA905238F42C3F88E", hash_generated_method = "B83E8E4FEB3160517AB52B3CA48D1276")
        final boolean nonfairTryAcquire(int acquires) {
            Thread current;
            current = Thread.currentThread();
            int c;
            c = getState();
            {
                {
                    boolean varF66BF2DB7461880C09D8FA1630E5A95E_28236839 = (compareAndSetState(0, acquires));
                    {
                        setExclusiveOwnerThread(current);
                    } //End block
                } //End collapsed parenthetic
            } //End block
            {
                boolean varE75766FA74E04E655F03A151D4B25AC7_70908180 = (current == getExclusiveOwnerThread());
                {
                    int nextc;
                    nextc = c + acquires;
                    if (DroidSafeAndroidRuntime.control) throw new Error("Maximum lock count exceeded");
                    setState(nextc);
                } //End block
            } //End collapsed parenthetic
            addTaint(acquires);
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1032925713 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1032925713;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:58.251 -0400", hash_original_method = "F58D783FAFD21E630011410A68B89B8B", hash_generated_method = "7A0AA56EFA081D37F9028465B3A96C61")
        protected final boolean tryRelease(int releases) {
            int c;
            c = getState() - releases;
            {
                boolean var171DA8AF5FD35C68B337E23A0EB8AC61_466665079 = (Thread.currentThread() != getExclusiveOwnerThread());
                if (DroidSafeAndroidRuntime.control) throw new IllegalMonitorStateException();
            } //End collapsed parenthetic
            boolean free;
            free = false;
            {
                free = true;
                setExclusiveOwnerThread(null);
            } //End block
            setState(c);
            addTaint(releases);
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_541224025 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_541224025;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:58.251 -0400", hash_original_method = "A843CC28FFAE9A089B89A0058BA2B9D5", hash_generated_method = "EE306E87A7EC49C801FA93A6FF547AC1")
        protected final boolean isHeldExclusively() {
            boolean var3CE6B8DE56D5A33803435E843AACF76A_2114793160 = (getExclusiveOwnerThread() == Thread.currentThread());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1905945148 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1905945148;
            // ---------- Original Method ----------
            //return getExclusiveOwnerThread() == Thread.currentThread();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:58.251 -0400", hash_original_method = "093F0D0E6A279CA43864791B6FD65040", hash_generated_method = "3512C8A1800F6594BB981185C565EB6F")
        final ConditionObject newCondition() {
            ConditionObject varB4EAC82CA7396A68D541C85D26508E83_1556258093 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1556258093 = new ConditionObject();
            varB4EAC82CA7396A68D541C85D26508E83_1556258093.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1556258093;
            // ---------- Original Method ----------
            //return new ConditionObject();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:58.252 -0400", hash_original_method = "24CA7AAFB844A1400E08D949A036E749", hash_generated_method = "C1CD4514DE5321F4EF3FCBE32B8130DD")
        final Thread getOwner() {
            Thread varB4EAC82CA7396A68D541C85D26508E83_1432760990 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1432760990 = getState() == 0 ? null : getExclusiveOwnerThread();
            varB4EAC82CA7396A68D541C85D26508E83_1432760990.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1432760990;
            // ---------- Original Method ----------
            //return getState() == 0 ? null : getExclusiveOwnerThread();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:58.253 -0400", hash_original_method = "9566A514E32EED07D696F4866CA45F30", hash_generated_method = "9EFCE69054ED79817DD4FD9B0FCA15A1")
        final int getHoldCount() {
            {
                boolean var34E827331B4BC7F16DFC99E8B4EE154E_1261305671 = (isHeldExclusively());
                Object var2B84CA06A8A0E280C92148E0A83A6657_1547041724 = (getState());
            } //End flattened ternary
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1258804644 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1258804644;
            // ---------- Original Method ----------
            //return isHeldExclusively() ? getState() : 0;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:58.253 -0400", hash_original_method = "89AB065792F4703E484ABCB3E61E822C", hash_generated_method = "B4C64EC4A3AC82D73FF27986CEB9C014")
        final boolean isLocked() {
            boolean var3842E9A7CB6B96374140FC54D5D4BB54_1923813977 = (getState() != 0);
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1759723816 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1759723816;
            // ---------- Original Method ----------
            //return getState() != 0;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:58.253 -0400", hash_original_method = "05D5902ED2395493955B66F039D49364", hash_generated_method = "2FAA30C568B27BEB3C23701DD7180F2D")
        private void readObject(java.io.ObjectInputStream s) throws java.io.IOException, ClassNotFoundException {
            s.defaultReadObject();
            setState(0);
            addTaint(s.getTaint());
            // ---------- Original Method ----------
            //s.defaultReadObject();
            //setState(0);
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:58.253 -0400", hash_original_field = "664BADC4FCE0F56881AF4EC0C44FC7CE", hash_generated_field = "BC8A392F0A11CF51E852A043746E76B6")

        private static long serialVersionUID = -5179523762034025860L;
    }


    
    static final class NonfairSync extends Sync {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:58.253 -0400", hash_original_method = "92700F1FF079627760B83F1F338B8E6E", hash_generated_method = "92700F1FF079627760B83F1F338B8E6E")
        public NonfairSync ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:58.254 -0400", hash_original_method = "250EC96D0AD0D747189CAF2CF367FDFE", hash_generated_method = "CBD3A990B4207DEDF13DF1D2F21485E7")
        final void lock() {
            {
                boolean varF425053993EA879E03DA150C877D7F5C_1020594743 = (compareAndSetState(0, 1));
                setExclusiveOwnerThread(Thread.currentThread());
                acquire(1);
            } //End collapsed parenthetic
            // ---------- Original Method ----------
            //if (compareAndSetState(0, 1))
                //setExclusiveOwnerThread(Thread.currentThread());
            //else
                //acquire(1);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:58.255 -0400", hash_original_method = "4FB92A369E0871387D4F8186DCD16A26", hash_generated_method = "51D9C1EF329AD2B214822D04468133AA")
        protected final boolean tryAcquire(int acquires) {
            boolean var0265CA842894C6CCF4077B7A67F336BF_1757519243 = (nonfairTryAcquire(acquires));
            addTaint(acquires);
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_6545747 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_6545747;
            // ---------- Original Method ----------
            //return nonfairTryAcquire(acquires);
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:58.255 -0400", hash_original_field = "BD27C19ACD1B65DD9363F71DE1851218", hash_generated_field = "09914D3AC1C59E878233D232B4CA9327")

        private static long serialVersionUID = 7316153563782823691L;
    }


    
    static final class FairSync extends Sync {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:58.255 -0400", hash_original_method = "76BFFA90730B34917875BAE48AE8B396", hash_generated_method = "76BFFA90730B34917875BAE48AE8B396")
        public FairSync ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:58.255 -0400", hash_original_method = "E6AC2D5893CA21F5681F81CF00C94AEB", hash_generated_method = "EA04A5A8DEC9D6FD4587640A48DF018E")
        final void lock() {
            acquire(1);
            // ---------- Original Method ----------
            //acquire(1);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:58.258 -0400", hash_original_method = "81B34FC5A1F152836CFB423B4391D12C", hash_generated_method = "60C095D7165110FE27C32CDBA3842D66")
        protected final boolean tryAcquire(int acquires) {
            Thread current;
            current = Thread.currentThread();
            int c;
            c = getState();
            {
                {
                    boolean var5AC1E5DC83FB6F44EFD60F65BD367A21_426601134 = (!hasQueuedPredecessors() &&
                    compareAndSetState(0, acquires));
                    {
                        setExclusiveOwnerThread(current);
                    } //End block
                } //End collapsed parenthetic
            } //End block
            {
                boolean varE75766FA74E04E655F03A151D4B25AC7_1693256145 = (current == getExclusiveOwnerThread());
                {
                    int nextc;
                    nextc = c + acquires;
                    if (DroidSafeAndroidRuntime.control) throw new Error("Maximum lock count exceeded");
                    setState(nextc);
                } //End block
            } //End collapsed parenthetic
            addTaint(acquires);
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_995785889 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_995785889;
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

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:58.258 -0400", hash_original_field = "D17C09047856F96A00E27AA866549B69", hash_generated_field = "F8BD080773104CAB4599BDFA39DF4E19")

        private static long serialVersionUID = -3000897897090466540L;
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:58.258 -0400", hash_original_field = "16EBB3E5C40DD288F8E94BD3EE8B7D56", hash_generated_field = "EC4D5760ECB3D2B2249C3504EDE19584")

    private static long serialVersionUID = 7373984872572414699L;
}

