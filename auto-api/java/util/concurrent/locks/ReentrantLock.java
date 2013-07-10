package java.util.concurrent.locks;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.*;

public class ReentrantLock implements Lock, java.io.Serializable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.813 -0400", hash_original_field = "63AD9D34F3503826E5F649AE6B7AC92C", hash_generated_field = "A4B34EF3CE38520839B34A2F06599243")

    private Sync sync;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.813 -0400", hash_original_method = "CAF4BD8277F97E8E8A833F3DA738B0B2", hash_generated_method = "D575B8316542FC333CB3BC5C812414AD")
    public  ReentrantLock() {
        sync = new NonfairSync();
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.813 -0400", hash_original_method = "D5E979A18BF9FB96236498521D2048B7", hash_generated_method = "A41781E53E248156CFB216376FFDC140")
    public  ReentrantLock(boolean fair) {
        sync = fair ? new FairSync() : new NonfairSync();
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.813 -0400", hash_original_method = "97675D396F33E00D31856AF34DD1ED6B", hash_generated_method = "F69D427B4A2E72BA43563F8DEC741F82")
    public void lock() {
        sync.lock();
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.814 -0400", hash_original_method = "5966BE77DAE264B5F21646B0E7A08FC1", hash_generated_method = "CFF689BB53A067D7B9EB5F12CA3F00CC")
    public void lockInterruptibly() throws InterruptedException {
        sync.acquireInterruptibly(1);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.814 -0400", hash_original_method = "9B7882D242270D7813AEE17389132741", hash_generated_method = "D89DC91D64A6916B6806D7ED26128257")
    public boolean tryLock() {
        boolean var01D158C305499B950DC2B450CF0A13DF_926675368 = (sync.nonfairTryAcquire(1));
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_884433525 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_884433525;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.814 -0400", hash_original_method = "6EF7D2E282F143C52CC20B0DBAA61A21", hash_generated_method = "F36805BF4CC822E35F69F95B32B62EB4")
    public boolean tryLock(long timeout, TimeUnit unit) throws InterruptedException {
        boolean var032A6E2E0DFEA3BC6D0CEF4809A04918_262029586 = (sync.tryAcquireNanos(1, unit.toNanos(timeout)));
        addTaint(timeout);
        addTaint(unit.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_424289937 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_424289937;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.814 -0400", hash_original_method = "7AD42B9E2BC6DD4A4DE0EB9EBA3A2515", hash_generated_method = "87142E80D82254348B0CA43367BBC9B7")
    public void unlock() {
        sync.release(1);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.815 -0400", hash_original_method = "6BB095C6835043568D960ACB9C15058D", hash_generated_method = "D587BBD276D49562276D5FC6C9D2BF1C")
    public Condition newCondition() {
        Condition varB4EAC82CA7396A68D541C85D26508E83_151124110 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_151124110 = sync.newCondition();
        varB4EAC82CA7396A68D541C85D26508E83_151124110.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_151124110;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.815 -0400", hash_original_method = "7FC57D6521874F49E1ACFD5770F280CF", hash_generated_method = "853D1F5BCD5587405297AD202808DC63")
    public int getHoldCount() {
        int var0CF7228364AC2BBEEE65804FC32AE455_1868954354 = (sync.getHoldCount());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_191966670 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_191966670;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.816 -0400", hash_original_method = "53A74F7432D74C33316852C3E739832B", hash_generated_method = "ED6240EB039F4A116F65B9F72540B6BF")
    public boolean isHeldByCurrentThread() {
        boolean var12281D4A72DEB9F8816A0A46604F1374_2040814848 = (sync.isHeldExclusively());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_968320130 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_968320130;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.816 -0400", hash_original_method = "B8A2470400F707CBBF058BF4DA6F8D15", hash_generated_method = "5FE839EA8CAC49310EB37E32FC3BEF19")
    public boolean isLocked() {
        boolean var720015946EB5BA7A9510B4F7065A84D7_799982169 = (sync.isLocked());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_29013427 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_29013427;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.816 -0400", hash_original_method = "6835E283E5F9E7FBD3FF7844476992AD", hash_generated_method = "8C34DC1935155490C1A77C0F4F8406C2")
    public final boolean isFair() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1048325465 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1048325465;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.817 -0400", hash_original_method = "DB009A0944F572B5167ED6D51E109787", hash_generated_method = "2B9D9015540273B912C55D3F2C1BD12B")
    protected Thread getOwner() {
        Thread varB4EAC82CA7396A68D541C85D26508E83_330417454 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_330417454 = sync.getOwner();
        varB4EAC82CA7396A68D541C85D26508E83_330417454.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_330417454;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.817 -0400", hash_original_method = "33B7DCC82A105082FC4D268ED56F9DE5", hash_generated_method = "F78A6C9112D19199011807D4ACAD406D")
    public final boolean hasQueuedThreads() {
        boolean var4C0A0AB508905DA8D619627A5EEFD574_340605993 = (sync.hasQueuedThreads());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_822932805 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_822932805;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.818 -0400", hash_original_method = "7B179E46CDF5B520CCEEF15512EC2C63", hash_generated_method = "92313ABEA505CD7C55E9C4C2DB743BB1")
    public final boolean hasQueuedThread(Thread thread) {
        boolean var0681201A478D613CAAB4B4D5196C3EF3_397434909 = (sync.isQueued(thread));
        addTaint(thread.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1492227304 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1492227304;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.818 -0400", hash_original_method = "DFFF2C05339152644F00EC2FFC57EFB9", hash_generated_method = "ADC9BE9F058F230D8E52E6BE86A3187D")
    public final int getQueueLength() {
        int var2545CC142A0CD1008911850681315651_2130428984 = (sync.getQueueLength());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_326780616 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_326780616;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.818 -0400", hash_original_method = "4BC73C35668DA24636BE58FB68209032", hash_generated_method = "EA8F889195693F7170A9EE6A7F05EF99")
    protected Collection<Thread> getQueuedThreads() {
        Collection<Thread> varB4EAC82CA7396A68D541C85D26508E83_399545546 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_399545546 = sync.getQueuedThreads();
        varB4EAC82CA7396A68D541C85D26508E83_399545546.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_399545546;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.819 -0400", hash_original_method = "BF91F0F13FB6E88A38744502E21F1F2D", hash_generated_method = "CA665A8E0D9376946D7F9EED16BCF08F")
    public boolean hasWaiters(Condition condition) {
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("not owner");
        boolean varD78146513D32810B85075F5879934833_417336173 = (sync.hasWaiters((AbstractQueuedSynchronizer.ConditionObject)condition));
        addTaint(condition.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1831211519 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1831211519;
        
        
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.819 -0400", hash_original_method = "D4277B3B6ED39F705D915D3806A5548A", hash_generated_method = "866CAC55E2436E0BC6A653F0C9F8A506")
    public int getWaitQueueLength(Condition condition) {
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("not owner");
        int var60A2F707F5BC43BB059D2028F4E4733B_116724052 = (sync.getWaitQueueLength((AbstractQueuedSynchronizer.ConditionObject)condition));
        addTaint(condition.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1513510456 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1513510456;
        
        
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.820 -0400", hash_original_method = "29738EA386BFBB41E36C961DB4B1CBE5", hash_generated_method = "1CC302573053B297DF820C66CFFA20DD")
    protected Collection<Thread> getWaitingThreads(Condition condition) {
        Collection<Thread> varB4EAC82CA7396A68D541C85D26508E83_1728024968 = null; 
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("not owner");
        varB4EAC82CA7396A68D541C85D26508E83_1728024968 = sync.getWaitingThreads((AbstractQueuedSynchronizer.ConditionObject)condition);
        addTaint(condition.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1728024968.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1728024968;
        
        
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.820 -0400", hash_original_method = "E0C199518E39715763AFB28F76F97305", hash_generated_method = "FE53457777E3194E262F176B7192B008")
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_1786191207 = null; 
        Thread o = sync.getOwner();
        varB4EAC82CA7396A68D541C85D26508E83_1786191207 = super.toString() + ((o == null) ?
                                   "[Unlocked]" :
                                   "[Locked by thread " + o.getName() + "]");
        varB4EAC82CA7396A68D541C85D26508E83_1786191207.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1786191207;
        
        
        
                                   
                                   
    }

    
    abstract static class Sync extends AbstractQueuedSynchronizer {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.820 -0400", hash_original_method = "88F1B6F2E189B36E0DD98AFBD02FE2C7", hash_generated_method = "88F1B6F2E189B36E0DD98AFBD02FE2C7")
        public Sync ()
        {
            
        }


        abstract void lock();

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.821 -0400", hash_original_method = "D19DB0AA686FDE0FA905238F42C3F88E", hash_generated_method = "DD082534A7738B0F9497E3C7FBFF5143")
        final boolean nonfairTryAcquire(int acquires) {
            final Thread current = Thread.currentThread();
            int c = getState();
            {
                {
                    boolean varF66BF2DB7461880C09D8FA1630E5A95E_446404711 = (compareAndSetState(0, acquires));
                    {
                        setExclusiveOwnerThread(current);
                    } 
                } 
            } 
            {
                boolean varE75766FA74E04E655F03A151D4B25AC7_678837623 = (current == getExclusiveOwnerThread());
                {
                    int nextc = c + acquires;
                    if (DroidSafeAndroidRuntime.control) throw new Error("Maximum lock count exceeded");
                    setState(nextc);
                } 
            } 
            addTaint(acquires);
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_281968193 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_281968193;
            
            
            
            
                
                    
                    
                
            
            
                
                
                    
                
                
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.822 -0400", hash_original_method = "F58D783FAFD21E630011410A68B89B8B", hash_generated_method = "0DD09A1E74CC9A537304168A0D5574DF")
        protected final boolean tryRelease(int releases) {
            int c = getState() - releases;
            {
                boolean var171DA8AF5FD35C68B337E23A0EB8AC61_1678726441 = (Thread.currentThread() != getExclusiveOwnerThread());
                if (DroidSafeAndroidRuntime.control) throw new IllegalMonitorStateException();
            } 
            boolean free = false;
            {
                free = true;
                setExclusiveOwnerThread(null);
            } 
            setState(c);
            addTaint(releases);
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1874382072 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1874382072;
            
            
            
                
            
            
                
                
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.822 -0400", hash_original_method = "A843CC28FFAE9A089B89A0058BA2B9D5", hash_generated_method = "98D00A2DB103C5CA8BA2B887B8789ADD")
        protected final boolean isHeldExclusively() {
            boolean var3CE6B8DE56D5A33803435E843AACF76A_1010197995 = (getExclusiveOwnerThread() == Thread.currentThread());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_935160267 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_935160267;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.823 -0400", hash_original_method = "093F0D0E6A279CA43864791B6FD65040", hash_generated_method = "02336F46C11FB46AFD4BF2FC50F2CAD0")
        final ConditionObject newCondition() {
            ConditionObject varB4EAC82CA7396A68D541C85D26508E83_736364992 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_736364992 = new ConditionObject();
            varB4EAC82CA7396A68D541C85D26508E83_736364992.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_736364992;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.823 -0400", hash_original_method = "24CA7AAFB844A1400E08D949A036E749", hash_generated_method = "26CB3022C1140D86A81885EBCEDCC87E")
        final Thread getOwner() {
            Thread varB4EAC82CA7396A68D541C85D26508E83_2059131104 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_2059131104 = getState() == 0 ? null : getExclusiveOwnerThread();
            varB4EAC82CA7396A68D541C85D26508E83_2059131104.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_2059131104;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.824 -0400", hash_original_method = "9566A514E32EED07D696F4866CA45F30", hash_generated_method = "79E03C2E717EFB5C87AFDD21F6B79B8E")
        final int getHoldCount() {
            {
                boolean var34E827331B4BC7F16DFC99E8B4EE154E_339451616 = (isHeldExclusively());
                Object var2B84CA06A8A0E280C92148E0A83A6657_2063900182 = (getState());
            } 
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1689662040 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1689662040;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.825 -0400", hash_original_method = "89AB065792F4703E484ABCB3E61E822C", hash_generated_method = "235F65D80853D774FB58357AB155C272")
        final boolean isLocked() {
            boolean var3842E9A7CB6B96374140FC54D5D4BB54_1276255607 = (getState() != 0);
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2140799824 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_2140799824;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.825 -0400", hash_original_method = "05D5902ED2395493955B66F039D49364", hash_generated_method = "2FAA30C568B27BEB3C23701DD7180F2D")
        private void readObject(java.io.ObjectInputStream s) throws java.io.IOException, ClassNotFoundException {
            s.defaultReadObject();
            setState(0);
            addTaint(s.getTaint());
            
            
            
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.826 -0400", hash_original_field = "664BADC4FCE0F56881AF4EC0C44FC7CE", hash_generated_field = "11262B0B520D47FEDD0C78D205387B55")

        private static final long serialVersionUID = -5179523762034025860L;
    }


    
    static final class NonfairSync extends Sync {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.826 -0400", hash_original_method = "92700F1FF079627760B83F1F338B8E6E", hash_generated_method = "92700F1FF079627760B83F1F338B8E6E")
        public NonfairSync ()
        {
            
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.827 -0400", hash_original_method = "250EC96D0AD0D747189CAF2CF367FDFE", hash_generated_method = "66FE0D3ACE67F89DAACFF1AF183F51FB")
        final void lock() {
            {
                boolean varF425053993EA879E03DA150C877D7F5C_337382409 = (compareAndSetState(0, 1));
                setExclusiveOwnerThread(Thread.currentThread());
                acquire(1);
            } 
            
            
                
            
                
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.828 -0400", hash_original_method = "4FB92A369E0871387D4F8186DCD16A26", hash_generated_method = "16A48E98F8E6D58EAE7267514345F147")
        protected final boolean tryAcquire(int acquires) {
            boolean var0265CA842894C6CCF4077B7A67F336BF_924674597 = (nonfairTryAcquire(acquires));
            addTaint(acquires);
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1662953098 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1662953098;
            
            
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.828 -0400", hash_original_field = "BD27C19ACD1B65DD9363F71DE1851218", hash_generated_field = "58C60847CF2F2D2F1CEF07DFE5BA201D")

        private static final long serialVersionUID = 7316153563782823691L;
    }


    
    static final class FairSync extends Sync {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.828 -0400", hash_original_method = "76BFFA90730B34917875BAE48AE8B396", hash_generated_method = "76BFFA90730B34917875BAE48AE8B396")
        public FairSync ()
        {
            
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.829 -0400", hash_original_method = "E6AC2D5893CA21F5681F81CF00C94AEB", hash_generated_method = "EA04A5A8DEC9D6FD4587640A48DF018E")
        final void lock() {
            acquire(1);
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.831 -0400", hash_original_method = "81B34FC5A1F152836CFB423B4391D12C", hash_generated_method = "70784B9D86A9B01277B229478CB685E5")
        protected final boolean tryAcquire(int acquires) {
            final Thread current = Thread.currentThread();
            int c = getState();
            {
                {
                    boolean var5AC1E5DC83FB6F44EFD60F65BD367A21_1328298691 = (!hasQueuedPredecessors() &&
                    compareAndSetState(0, acquires));
                    {
                        setExclusiveOwnerThread(current);
                    } 
                } 
            } 
            {
                boolean varE75766FA74E04E655F03A151D4B25AC7_1047461656 = (current == getExclusiveOwnerThread());
                {
                    int nextc = c + acquires;
                    if (DroidSafeAndroidRuntime.control) throw new Error("Maximum lock count exceeded");
                    setState(nextc);
                } 
            } 
            addTaint(acquires);
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_624314898 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_624314898;
            
            
            
            
                
                    
                    
                    
                
            
            
                
                
                    
                
                
            
            
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.831 -0400", hash_original_field = "D17C09047856F96A00E27AA866549B69", hash_generated_field = "CB1921210AFFA16906C257D2951975DC")

        private static final long serialVersionUID = -3000897897090466540L;
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.831 -0400", hash_original_field = "16EBB3E5C40DD288F8E94BD3EE8B7D56", hash_generated_field = "190C3E77BD396A2688499FE9C5D2BE14")

    private static final long serialVersionUID = 7373984872572414699L;
}

