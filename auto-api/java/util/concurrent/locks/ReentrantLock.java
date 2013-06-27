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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:58.217 -0400", hash_original_field = "63AD9D34F3503826E5F649AE6B7AC92C", hash_generated_field = "A4B34EF3CE38520839B34A2F06599243")

    private Sync sync;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:58.218 -0400", hash_original_method = "CAF4BD8277F97E8E8A833F3DA738B0B2", hash_generated_method = "D575B8316542FC333CB3BC5C812414AD")
    public  ReentrantLock() {
        sync = new NonfairSync();
        // ---------- Original Method ----------
        //sync = new NonfairSync();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:58.218 -0400", hash_original_method = "D5E979A18BF9FB96236498521D2048B7", hash_generated_method = "A41781E53E248156CFB216376FFDC140")
    public  ReentrantLock(boolean fair) {
        sync = fair ? new FairSync() : new NonfairSync();
        // ---------- Original Method ----------
        //sync = fair ? new FairSync() : new NonfairSync();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:58.219 -0400", hash_original_method = "97675D396F33E00D31856AF34DD1ED6B", hash_generated_method = "F69D427B4A2E72BA43563F8DEC741F82")
    public void lock() {
        sync.lock();
        // ---------- Original Method ----------
        //sync.lock();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:58.219 -0400", hash_original_method = "5966BE77DAE264B5F21646B0E7A08FC1", hash_generated_method = "CFF689BB53A067D7B9EB5F12CA3F00CC")
    public void lockInterruptibly() throws InterruptedException {
        sync.acquireInterruptibly(1);
        // ---------- Original Method ----------
        //sync.acquireInterruptibly(1);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:58.219 -0400", hash_original_method = "9B7882D242270D7813AEE17389132741", hash_generated_method = "D7E1F24967A1451F214EA7239531A447")
    public boolean tryLock() {
        boolean var01D158C305499B950DC2B450CF0A13DF_708861574 = (sync.nonfairTryAcquire(1));
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1932804374 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1932804374;
        // ---------- Original Method ----------
        //return sync.nonfairTryAcquire(1);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:58.220 -0400", hash_original_method = "6EF7D2E282F143C52CC20B0DBAA61A21", hash_generated_method = "8EC356CD68265B02DBE9340CD5C510ED")
    public boolean tryLock(long timeout, TimeUnit unit) throws InterruptedException {
        boolean var032A6E2E0DFEA3BC6D0CEF4809A04918_1359239020 = (sync.tryAcquireNanos(1, unit.toNanos(timeout)));
        addTaint(timeout);
        addTaint(unit.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1847576888 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1847576888;
        // ---------- Original Method ----------
        //return sync.tryAcquireNanos(1, unit.toNanos(timeout));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:58.220 -0400", hash_original_method = "7AD42B9E2BC6DD4A4DE0EB9EBA3A2515", hash_generated_method = "87142E80D82254348B0CA43367BBC9B7")
    public void unlock() {
        sync.release(1);
        // ---------- Original Method ----------
        //sync.release(1);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:58.221 -0400", hash_original_method = "6BB095C6835043568D960ACB9C15058D", hash_generated_method = "2458BE81C00F3BCA5C80196F624AD873")
    public Condition newCondition() {
        Condition varB4EAC82CA7396A68D541C85D26508E83_1576310577 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1576310577 = sync.newCondition();
        varB4EAC82CA7396A68D541C85D26508E83_1576310577.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1576310577;
        // ---------- Original Method ----------
        //return sync.newCondition();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:58.221 -0400", hash_original_method = "7FC57D6521874F49E1ACFD5770F280CF", hash_generated_method = "17E4BA6E86888DEE42618D0CFEAD0686")
    public int getHoldCount() {
        int var0CF7228364AC2BBEEE65804FC32AE455_95633136 = (sync.getHoldCount());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_895228280 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_895228280;
        // ---------- Original Method ----------
        //return sync.getHoldCount();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:58.234 -0400", hash_original_method = "53A74F7432D74C33316852C3E739832B", hash_generated_method = "557202F7D3F731F629E30328C00CC6C2")
    public boolean isHeldByCurrentThread() {
        boolean var12281D4A72DEB9F8816A0A46604F1374_1723492835 = (sync.isHeldExclusively());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_967803127 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_967803127;
        // ---------- Original Method ----------
        //return sync.isHeldExclusively();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:58.234 -0400", hash_original_method = "B8A2470400F707CBBF058BF4DA6F8D15", hash_generated_method = "C034E4A0E8013407B57B509EAC8B59BF")
    public boolean isLocked() {
        boolean var720015946EB5BA7A9510B4F7065A84D7_1344690966 = (sync.isLocked());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1608798101 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1608798101;
        // ---------- Original Method ----------
        //return sync.isLocked();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:58.234 -0400", hash_original_method = "6835E283E5F9E7FBD3FF7844476992AD", hash_generated_method = "608BAA1F666AF5D13DC5D9A2777C6F85")
    public final boolean isFair() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1299395845 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1299395845;
        // ---------- Original Method ----------
        //return sync instanceof FairSync;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:58.235 -0400", hash_original_method = "DB009A0944F572B5167ED6D51E109787", hash_generated_method = "6A0D7BDEFCC488116E04D01215F5E307")
    protected Thread getOwner() {
        Thread varB4EAC82CA7396A68D541C85D26508E83_971443816 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_971443816 = sync.getOwner();
        varB4EAC82CA7396A68D541C85D26508E83_971443816.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_971443816;
        // ---------- Original Method ----------
        //return sync.getOwner();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:58.235 -0400", hash_original_method = "33B7DCC82A105082FC4D268ED56F9DE5", hash_generated_method = "CFD96E1E00A40AB40BDDFFEF48E54B8E")
    public final boolean hasQueuedThreads() {
        boolean var4C0A0AB508905DA8D619627A5EEFD574_1275905128 = (sync.hasQueuedThreads());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1433446473 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1433446473;
        // ---------- Original Method ----------
        //return sync.hasQueuedThreads();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:58.235 -0400", hash_original_method = "7B179E46CDF5B520CCEEF15512EC2C63", hash_generated_method = "1198BA904AB5894453A49268A66B430E")
    public final boolean hasQueuedThread(Thread thread) {
        boolean var0681201A478D613CAAB4B4D5196C3EF3_1034674917 = (sync.isQueued(thread));
        addTaint(thread.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1120634329 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1120634329;
        // ---------- Original Method ----------
        //return sync.isQueued(thread);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:58.249 -0400", hash_original_method = "DFFF2C05339152644F00EC2FFC57EFB9", hash_generated_method = "9A0589CBBBF6F4848B61E68A0B67C583")
    public final int getQueueLength() {
        int var2545CC142A0CD1008911850681315651_5047424 = (sync.getQueueLength());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1408876658 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1408876658;
        // ---------- Original Method ----------
        //return sync.getQueueLength();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:58.250 -0400", hash_original_method = "4BC73C35668DA24636BE58FB68209032", hash_generated_method = "52F1C4F49F2FFFA2D8682264C6E44A2A")
    protected Collection<Thread> getQueuedThreads() {
        Collection<Thread> varB4EAC82CA7396A68D541C85D26508E83_178527748 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_178527748 = sync.getQueuedThreads();
        varB4EAC82CA7396A68D541C85D26508E83_178527748.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_178527748;
        // ---------- Original Method ----------
        //return sync.getQueuedThreads();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:58.251 -0400", hash_original_method = "BF91F0F13FB6E88A38744502E21F1F2D", hash_generated_method = "1FA69657E2CF07C6C4DE24D889317F86")
    public boolean hasWaiters(Condition condition) {
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("not owner");
        boolean varD78146513D32810B85075F5879934833_1128022631 = (sync.hasWaiters((AbstractQueuedSynchronizer.ConditionObject)condition));
        addTaint(condition.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2100916200 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2100916200;
        // ---------- Original Method ----------
        //if (condition == null)
            //throw new NullPointerException();
        //if (!(condition instanceof AbstractQueuedSynchronizer.ConditionObject))
            //throw new IllegalArgumentException("not owner");
        //return sync.hasWaiters((AbstractQueuedSynchronizer.ConditionObject)condition);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:58.252 -0400", hash_original_method = "D4277B3B6ED39F705D915D3806A5548A", hash_generated_method = "0873DD0E883B92D8FBAA19DBF11F7BC7")
    public int getWaitQueueLength(Condition condition) {
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("not owner");
        int var60A2F707F5BC43BB059D2028F4E4733B_1573141037 = (sync.getWaitQueueLength((AbstractQueuedSynchronizer.ConditionObject)condition));
        addTaint(condition.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_677777702 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_677777702;
        // ---------- Original Method ----------
        //if (condition == null)
            //throw new NullPointerException();
        //if (!(condition instanceof AbstractQueuedSynchronizer.ConditionObject))
            //throw new IllegalArgumentException("not owner");
        //return sync.getWaitQueueLength((AbstractQueuedSynchronizer.ConditionObject)condition);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:58.346 -0400", hash_original_method = "29738EA386BFBB41E36C961DB4B1CBE5", hash_generated_method = "7EFEC58F8CD239247511F7A144E1F925")
    protected Collection<Thread> getWaitingThreads(Condition condition) {
        Collection<Thread> varB4EAC82CA7396A68D541C85D26508E83_707791323 = null; //Variable for return #1
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("not owner");
        varB4EAC82CA7396A68D541C85D26508E83_707791323 = sync.getWaitingThreads((AbstractQueuedSynchronizer.ConditionObject)condition);
        addTaint(condition.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_707791323.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_707791323;
        // ---------- Original Method ----------
        //if (condition == null)
            //throw new NullPointerException();
        //if (!(condition instanceof AbstractQueuedSynchronizer.ConditionObject))
            //throw new IllegalArgumentException("not owner");
        //return sync.getWaitingThreads((AbstractQueuedSynchronizer.ConditionObject)condition);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:58.350 -0400", hash_original_method = "E0C199518E39715763AFB28F76F97305", hash_generated_method = "5BC8847C9C5367310C2E860D4CB52027")
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_20823102 = null; //Variable for return #1
        Thread o;
        o = sync.getOwner();
        varB4EAC82CA7396A68D541C85D26508E83_20823102 = super.toString() + ((o == null) ?
                                   "[Unlocked]" :
                                   "[Locked by thread " + o.getName() + "]");
        varB4EAC82CA7396A68D541C85D26508E83_20823102.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_20823102;
        // ---------- Original Method ----------
        //Thread o = sync.getOwner();
        //return super.toString() + ((o == null) ?
                                   //"[Unlocked]" :
                                   //"[Locked by thread " + o.getName() + "]");
    }

    
    abstract static class Sync extends AbstractQueuedSynchronizer {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:58.350 -0400", hash_original_method = "88F1B6F2E189B36E0DD98AFBD02FE2C7", hash_generated_method = "88F1B6F2E189B36E0DD98AFBD02FE2C7")
        public Sync ()
        {
            //Synthesized constructor
        }


        abstract void lock();

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:58.352 -0400", hash_original_method = "D19DB0AA686FDE0FA905238F42C3F88E", hash_generated_method = "DE1CDC5505671DDA18C04AD44CA63708")
        final boolean nonfairTryAcquire(int acquires) {
            Thread current;
            current = Thread.currentThread();
            int c;
            c = getState();
            {
                {
                    boolean varF66BF2DB7461880C09D8FA1630E5A95E_1721849293 = (compareAndSetState(0, acquires));
                    {
                        setExclusiveOwnerThread(current);
                    } //End block
                } //End collapsed parenthetic
            } //End block
            {
                boolean varE75766FA74E04E655F03A151D4B25AC7_2030442585 = (current == getExclusiveOwnerThread());
                {
                    int nextc;
                    nextc = c + acquires;
                    if (DroidSafeAndroidRuntime.control) throw new Error("Maximum lock count exceeded");
                    setState(nextc);
                } //End block
            } //End collapsed parenthetic
            addTaint(acquires);
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1448900883 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1448900883;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:58.353 -0400", hash_original_method = "F58D783FAFD21E630011410A68B89B8B", hash_generated_method = "C614C8C595B1A7EE355D14F83BEDA686")
        protected final boolean tryRelease(int releases) {
            int c;
            c = getState() - releases;
            {
                boolean var171DA8AF5FD35C68B337E23A0EB8AC61_744943498 = (Thread.currentThread() != getExclusiveOwnerThread());
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
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1410161989 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1410161989;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:58.353 -0400", hash_original_method = "A843CC28FFAE9A089B89A0058BA2B9D5", hash_generated_method = "5B4393524EF75967F410B1C14F9D8E1F")
        protected final boolean isHeldExclusively() {
            boolean var3CE6B8DE56D5A33803435E843AACF76A_1865904854 = (getExclusiveOwnerThread() == Thread.currentThread());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1592938974 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1592938974;
            // ---------- Original Method ----------
            //return getExclusiveOwnerThread() == Thread.currentThread();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:58.355 -0400", hash_original_method = "093F0D0E6A279CA43864791B6FD65040", hash_generated_method = "39CEA33ACFCC6E112018C96291708430")
        final ConditionObject newCondition() {
            ConditionObject varB4EAC82CA7396A68D541C85D26508E83_162038237 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_162038237 = new ConditionObject();
            varB4EAC82CA7396A68D541C85D26508E83_162038237.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_162038237;
            // ---------- Original Method ----------
            //return new ConditionObject();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:58.365 -0400", hash_original_method = "24CA7AAFB844A1400E08D949A036E749", hash_generated_method = "B998BDAF827497DBAF2B4BE022024F38")
        final Thread getOwner() {
            Thread varB4EAC82CA7396A68D541C85D26508E83_1837145749 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1837145749 = getState() == 0 ? null : getExclusiveOwnerThread();
            varB4EAC82CA7396A68D541C85D26508E83_1837145749.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1837145749;
            // ---------- Original Method ----------
            //return getState() == 0 ? null : getExclusiveOwnerThread();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:58.366 -0400", hash_original_method = "9566A514E32EED07D696F4866CA45F30", hash_generated_method = "796FB3480B80A2F51B4C0BD578088490")
        final int getHoldCount() {
            {
                boolean var34E827331B4BC7F16DFC99E8B4EE154E_1709065833 = (isHeldExclusively());
                Object var2B84CA06A8A0E280C92148E0A83A6657_2101830794 = (getState());
            } //End flattened ternary
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_87019061 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_87019061;
            // ---------- Original Method ----------
            //return isHeldExclusively() ? getState() : 0;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:58.368 -0400", hash_original_method = "89AB065792F4703E484ABCB3E61E822C", hash_generated_method = "E6A134AC90D31452E32F6D213DDC4A66")
        final boolean isLocked() {
            boolean var3842E9A7CB6B96374140FC54D5D4BB54_366726639 = (getState() != 0);
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1676495568 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1676495568;
            // ---------- Original Method ----------
            //return getState() != 0;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:58.369 -0400", hash_original_method = "05D5902ED2395493955B66F039D49364", hash_generated_method = "2FAA30C568B27BEB3C23701DD7180F2D")
        private void readObject(java.io.ObjectInputStream s) throws java.io.IOException, ClassNotFoundException {
            s.defaultReadObject();
            setState(0);
            addTaint(s.getTaint());
            // ---------- Original Method ----------
            //s.defaultReadObject();
            //setState(0);
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:58.369 -0400", hash_original_field = "664BADC4FCE0F56881AF4EC0C44FC7CE", hash_generated_field = "BC8A392F0A11CF51E852A043746E76B6")

        private static long serialVersionUID = -5179523762034025860L;
    }


    
    static final class NonfairSync extends Sync {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:58.369 -0400", hash_original_method = "92700F1FF079627760B83F1F338B8E6E", hash_generated_method = "92700F1FF079627760B83F1F338B8E6E")
        public NonfairSync ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:58.369 -0400", hash_original_method = "250EC96D0AD0D747189CAF2CF367FDFE", hash_generated_method = "33A339B4EC3F31EF64E379CA35D80F59")
        final void lock() {
            {
                boolean varF425053993EA879E03DA150C877D7F5C_774449925 = (compareAndSetState(0, 1));
                setExclusiveOwnerThread(Thread.currentThread());
                acquire(1);
            } //End collapsed parenthetic
            // ---------- Original Method ----------
            //if (compareAndSetState(0, 1))
                //setExclusiveOwnerThread(Thread.currentThread());
            //else
                //acquire(1);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:58.370 -0400", hash_original_method = "4FB92A369E0871387D4F8186DCD16A26", hash_generated_method = "E83EB483A19D192FA0AD002E5E2FFD34")
        protected final boolean tryAcquire(int acquires) {
            boolean var0265CA842894C6CCF4077B7A67F336BF_1990554418 = (nonfairTryAcquire(acquires));
            addTaint(acquires);
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_421622502 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_421622502;
            // ---------- Original Method ----------
            //return nonfairTryAcquire(acquires);
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:58.370 -0400", hash_original_field = "BD27C19ACD1B65DD9363F71DE1851218", hash_generated_field = "09914D3AC1C59E878233D232B4CA9327")

        private static long serialVersionUID = 7316153563782823691L;
    }


    
    static final class FairSync extends Sync {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:58.370 -0400", hash_original_method = "76BFFA90730B34917875BAE48AE8B396", hash_generated_method = "76BFFA90730B34917875BAE48AE8B396")
        public FairSync ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:58.370 -0400", hash_original_method = "E6AC2D5893CA21F5681F81CF00C94AEB", hash_generated_method = "EA04A5A8DEC9D6FD4587640A48DF018E")
        final void lock() {
            acquire(1);
            // ---------- Original Method ----------
            //acquire(1);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:58.391 -0400", hash_original_method = "81B34FC5A1F152836CFB423B4391D12C", hash_generated_method = "0A9D418EAD291BEFC03D7CB88B122815")
        protected final boolean tryAcquire(int acquires) {
            Thread current;
            current = Thread.currentThread();
            int c;
            c = getState();
            {
                {
                    boolean var5AC1E5DC83FB6F44EFD60F65BD367A21_1528976900 = (!hasQueuedPredecessors() &&
                    compareAndSetState(0, acquires));
                    {
                        setExclusiveOwnerThread(current);
                    } //End block
                } //End collapsed parenthetic
            } //End block
            {
                boolean varE75766FA74E04E655F03A151D4B25AC7_1833628598 = (current == getExclusiveOwnerThread());
                {
                    int nextc;
                    nextc = c + acquires;
                    if (DroidSafeAndroidRuntime.control) throw new Error("Maximum lock count exceeded");
                    setState(nextc);
                } //End block
            } //End collapsed parenthetic
            addTaint(acquires);
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_493997867 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_493997867;
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

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:58.391 -0400", hash_original_field = "D17C09047856F96A00E27AA866549B69", hash_generated_field = "F8BD080773104CAB4599BDFA39DF4E19")

        private static long serialVersionUID = -3000897897090466540L;
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:58.391 -0400", hash_original_field = "16EBB3E5C40DD288F8E94BD3EE8B7D56", hash_generated_field = "EC4D5760ECB3D2B2249C3504EDE19584")

    private static long serialVersionUID = 7373984872572414699L;
}

