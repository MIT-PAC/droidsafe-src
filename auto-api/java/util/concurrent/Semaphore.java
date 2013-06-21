package java.util.concurrent;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.util.*;
import java.util.concurrent.locks.*;
import java.util.concurrent.atomic.*;

public class Semaphore implements java.io.Serializable {
    private Sync sync;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.827 -0400", hash_original_method = "1D09FBBC41D290488B50FAB01D9EE120", hash_generated_method = "17C12F3F0F782EFDF08C1A92A5435F9A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Semaphore(int permits) {
        dsTaint.addTaint(permits);
        sync = new NonfairSync(permits);
        // ---------- Original Method ----------
        //sync = new NonfairSync(permits);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.827 -0400", hash_original_method = "EDA1419EB058A316E989F6F201EF4313", hash_generated_method = "0469B08E4523F5969419A3A9A2D28A8F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Semaphore(int permits, boolean fair) {
        dsTaint.addTaint(permits);
        dsTaint.addTaint(fair);
        sync = fair ? new FairSync(permits) : new NonfairSync(permits);
        // ---------- Original Method ----------
        //sync = fair ? new FairSync(permits) : new NonfairSync(permits);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.827 -0400", hash_original_method = "36195816327B5FFC3BDF4AB88B23D805", hash_generated_method = "3DBDFDABAA7FC274F5D5F4A20CA8CA86")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void acquire() throws InterruptedException {
        sync.acquireSharedInterruptibly(1);
        // ---------- Original Method ----------
        //sync.acquireSharedInterruptibly(1);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.827 -0400", hash_original_method = "EECA708F1A8CDD46B9FED024EA3B107E", hash_generated_method = "65DDEE07CA9D1A9C8DF2A7F368E92FF2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void acquireUninterruptibly() {
        sync.acquireShared(1);
        // ---------- Original Method ----------
        //sync.acquireShared(1);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.827 -0400", hash_original_method = "81DB55A43E3FEF36A7D7A44C596F2527", hash_generated_method = "04CEBD85B786F22D39697EF5687630E1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean tryAcquire() {
        boolean var1A869DF11DFE4771E0F19E1A8F688755_176909855 = (sync.nonfairTryAcquireShared(1) >= 0);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return sync.nonfairTryAcquireShared(1) >= 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.827 -0400", hash_original_method = "ABEC3704F68F4BA58C5E653A10F8C77A", hash_generated_method = "E93B21BBD5216D64FEF06532B7A03F10")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean tryAcquire(long timeout, TimeUnit unit) throws InterruptedException {
        dsTaint.addTaint(unit.dsTaint);
        dsTaint.addTaint(timeout);
        boolean varD12778331A5B05E1E52D9468F6FF0E07_2058854681 = (sync.tryAcquireSharedNanos(1, unit.toNanos(timeout)));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return sync.tryAcquireSharedNanos(1, unit.toNanos(timeout));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.828 -0400", hash_original_method = "A31CF20052BB7332FF63483E272EE6FB", hash_generated_method = "3FED394AF8AC081B7B78D6F30457AAA9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void release() {
        sync.releaseShared(1);
        // ---------- Original Method ----------
        //sync.releaseShared(1);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.828 -0400", hash_original_method = "7B985EDB9B3C3368A9FFE0EA00FDC854", hash_generated_method = "3A598F530256AC7126724E1274266098")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void acquire(int permits) throws InterruptedException {
        dsTaint.addTaint(permits);
        if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException();
        sync.acquireSharedInterruptibly(permits);
        // ---------- Original Method ----------
        //if (permits < 0) throw new IllegalArgumentException();
        //sync.acquireSharedInterruptibly(permits);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.828 -0400", hash_original_method = "AED087DD2B1BE9707E61AD056A232C9F", hash_generated_method = "4C009752FE889F3F5B881BE560586263")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void acquireUninterruptibly(int permits) {
        dsTaint.addTaint(permits);
        if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException();
        sync.acquireShared(permits);
        // ---------- Original Method ----------
        //if (permits < 0) throw new IllegalArgumentException();
        //sync.acquireShared(permits);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.828 -0400", hash_original_method = "9FDABFB6FA908071648B312E27A5D44A", hash_generated_method = "97F60483EB7710F30F86DCF7B1B4C7D3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean tryAcquire(int permits) {
        dsTaint.addTaint(permits);
        if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException();
        boolean varFAE9003C69B035E758181BB99F298216_149626736 = (sync.nonfairTryAcquireShared(permits) >= 0);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (permits < 0) throw new IllegalArgumentException();
        //return sync.nonfairTryAcquireShared(permits) >= 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.828 -0400", hash_original_method = "80ECB8EBF7BA66409D7CA6C7FAEA0198", hash_generated_method = "A928EBA4B2700F50F1ECC7E89658B578")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean tryAcquire(int permits, long timeout, TimeUnit unit) throws InterruptedException {
        dsTaint.addTaint(unit.dsTaint);
        dsTaint.addTaint(permits);
        dsTaint.addTaint(timeout);
        if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException();
        boolean var291B054738129328132ED0F986893830_1629560649 = (sync.tryAcquireSharedNanos(permits, unit.toNanos(timeout)));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (permits < 0) throw new IllegalArgumentException();
        //return sync.tryAcquireSharedNanos(permits, unit.toNanos(timeout));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.828 -0400", hash_original_method = "86FDC777B5FFBB0166AB6B40E9CBCA0F", hash_generated_method = "BF3FB17361CE8031E9F095EB15E00EF3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void release(int permits) {
        dsTaint.addTaint(permits);
        if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException();
        sync.releaseShared(permits);
        // ---------- Original Method ----------
        //if (permits < 0) throw new IllegalArgumentException();
        //sync.releaseShared(permits);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.829 -0400", hash_original_method = "A0D0E9E456108DB04A370C1A3BAF302D", hash_generated_method = "8F80C28ECB4B1E8D79B1B8B3DE72172F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int availablePermits() {
        int var95D1737DCBC549BFF9F6868C1B7F656B_371320692 = (sync.getPermits());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return sync.getPermits();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.829 -0400", hash_original_method = "262F2C65B1D17DEC110169282F777115", hash_generated_method = "0535EE03D3E2429043B7DBFB87DC6FC4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int drainPermits() {
        int var8FDC00DE9DAA66FA61202193D997AE79_994395947 = (sync.drainPermits());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return sync.drainPermits();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.829 -0400", hash_original_method = "98D8F44FFB6E2B81C61D6FB2F4F416AF", hash_generated_method = "9B11557DB7A215EADD7E47E7762C131E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected void reducePermits(int reduction) {
        dsTaint.addTaint(reduction);
        if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException();
        sync.reducePermits(reduction);
        // ---------- Original Method ----------
        //if (reduction < 0) throw new IllegalArgumentException();
        //sync.reducePermits(reduction);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.829 -0400", hash_original_method = "6835E283E5F9E7FBD3FF7844476992AD", hash_generated_method = "611D39B2E827FC1FDBAB6615146271D8")
    @DSModeled(DSC.SAFE)
    public boolean isFair() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return sync instanceof FairSync;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.829 -0400", hash_original_method = "33B7DCC82A105082FC4D268ED56F9DE5", hash_generated_method = "90C80BFF882A21EC1850B7CA647233F4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final boolean hasQueuedThreads() {
        boolean var4C0A0AB508905DA8D619627A5EEFD574_756271594 = (sync.hasQueuedThreads());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return sync.hasQueuedThreads();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.829 -0400", hash_original_method = "DFFF2C05339152644F00EC2FFC57EFB9", hash_generated_method = "72C849AE11414FAF9E07C959DF37A959")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final int getQueueLength() {
        int var2545CC142A0CD1008911850681315651_27726158 = (sync.getQueueLength());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return sync.getQueueLength();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.829 -0400", hash_original_method = "4BC73C35668DA24636BE58FB68209032", hash_generated_method = "BBCA5B157975A608F2FA380A5362EF28")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected Collection<Thread> getQueuedThreads() {
        Collection<Thread> var31D858562CBAED119D353541F01C16B4_1871543797 = (sync.getQueuedThreads());
        return (Collection<Thread>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return sync.getQueuedThreads();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.830 -0400", hash_original_method = "28E11779691509B84604A2532741810B", hash_generated_method = "9B2020079416FB9F4B17B05AF506D658")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String toString() {
        String var6C972019625AF62B7C131E8645B72AC2_1303071267 = (super.toString() + "[Permits = " + sync.getPermits() + "]");
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return super.toString() + "[Permits = " + sync.getPermits() + "]";
    }

    
    abstract static class Sync extends AbstractQueuedSynchronizer {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.830 -0400", hash_original_method = "40565DEBA5724270F81AA15CDC452278", hash_generated_method = "07F051495E37639DF08DE893F5BE9639")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         Sync(int permits) {
            dsTaint.addTaint(permits);
            setState(permits);
            // ---------- Original Method ----------
            //setState(permits);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.830 -0400", hash_original_method = "932F869D56214E546755CFC45FDC49E6", hash_generated_method = "8BD645118DA546E2627DCE91CBA5A2CC")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        final int getPermits() {
            int var376B5C2087169E76FB6628D31DCC9663_1101396273 = (getState());
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return getState();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.830 -0400", hash_original_method = "38128BDDEF18CD48BAE30B545E1D6E2D", hash_generated_method = "95C9F8922339B0E1B010D3360AB6FC7C")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        final int nonfairTryAcquireShared(int acquires) {
            dsTaint.addTaint(acquires);
            {
                int available;
                available = getState();
                int remaining;
                remaining = available - acquires;
                {
                    boolean var5D6AC5DCD986512A248800EB87AD1FF5_140825231 = (remaining < 0 ||
                    compareAndSetState(available, remaining));
                } //End collapsed parenthetic
            } //End block
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //for (;;) {
                //int available = getState();
                //int remaining = available - acquires;
                //if (remaining < 0 ||
                    //compareAndSetState(available, remaining))
                    //return remaining;
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.830 -0400", hash_original_method = "E4485505685AAE5BA8902CEC7119047D", hash_generated_method = "16DFB0DC71C697C69ADC75C40140EC22")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        protected final boolean tryReleaseShared(int releases) {
            dsTaint.addTaint(releases);
            {
                int current;
                current = getState();
                int next;
                next = current + releases;
                if (DroidSafeAndroidRuntime.control) throw new Error("Maximum permit count exceeded");
                {
                    boolean var65C830D7C0FA9CE6017EA2EABEEC91DA_1399020198 = (compareAndSetState(current, next));
                } //End collapsed parenthetic
            } //End block
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //for (;;) {
                //int current = getState();
                //int next = current + releases;
                //if (next < current) 
                    //throw new Error("Maximum permit count exceeded");
                //if (compareAndSetState(current, next))
                    //return true;
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.831 -0400", hash_original_method = "EF09815047CF337EE6F8F6B76E860F15", hash_generated_method = "536E45893A669A370F6D0B52CC1860C1")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        final void reducePermits(int reductions) {
            dsTaint.addTaint(reductions);
            {
                int current;
                current = getState();
                int next;
                next = current - reductions;
                if (DroidSafeAndroidRuntime.control) throw new Error("Permit count underflow");
                {
                    boolean var65C830D7C0FA9CE6017EA2EABEEC91DA_601325220 = (compareAndSetState(current, next));
                } //End collapsed parenthetic
            } //End block
            // ---------- Original Method ----------
            //for (;;) {
                //int current = getState();
                //int next = current - reductions;
                //if (next > current) 
                    //throw new Error("Permit count underflow");
                //if (compareAndSetState(current, next))
                    //return;
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.831 -0400", hash_original_method = "B47D637533AD6479C19BA02673B291F3", hash_generated_method = "478F8BBAB87AC3A40BDC6B4D3A684CC2")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        final int drainPermits() {
            {
                int current;
                current = getState();
                {
                    boolean var65CEFE613645BE51CB825F0504FCD77C_219989672 = (current == 0 || compareAndSetState(current, 0));
                } //End collapsed parenthetic
            } //End block
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //for (;;) {
                //int current = getState();
                //if (current == 0 || compareAndSetState(current, 0))
                    //return current;
            //}
        }

        
        private static final long serialVersionUID = 1192457210091910933L;
    }


    
    static final class NonfairSync extends Sync {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.831 -0400", hash_original_method = "AB02276AF05DB48D17C9E59129A0533C", hash_generated_method = "42EF62E6D19A5B64DE96AD66508F63C1")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         NonfairSync(int permits) {
            super(permits);
            dsTaint.addTaint(permits);
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.831 -0400", hash_original_method = "2824818F1E688287ED8D5382B9F9370B", hash_generated_method = "9D4C8647150F2E9D4E151A428F5BF7CB")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        protected int tryAcquireShared(int acquires) {
            dsTaint.addTaint(acquires);
            int var1CC5CB853AD33680443F732E6C080712_400699991 = (nonfairTryAcquireShared(acquires));
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return nonfairTryAcquireShared(acquires);
        }

        
        private static final long serialVersionUID = -2694183684443567898L;
    }


    
    static final class FairSync extends Sync {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.831 -0400", hash_original_method = "1546A983167A4F32841E77BDDAC1FABE", hash_generated_method = "FB346BF07E4A388F7764540EF2320747")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         FairSync(int permits) {
            super(permits);
            dsTaint.addTaint(permits);
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.832 -0400", hash_original_method = "33A8BA33CEB07226CB7C962FD4989C27", hash_generated_method = "218EEF81B341E18A5E6D92E3EEC1EE13")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        protected int tryAcquireShared(int acquires) {
            dsTaint.addTaint(acquires);
            {
                {
                    boolean varE9533D34087E45E4AB2319427A8AD4CE_587232910 = (hasQueuedPredecessors());
                } //End collapsed parenthetic
                int available;
                available = getState();
                int remaining;
                remaining = available - acquires;
                {
                    boolean var5D6AC5DCD986512A248800EB87AD1FF5_1385189215 = (remaining < 0 ||
                    compareAndSetState(available, remaining));
                } //End collapsed parenthetic
            } //End block
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //for (;;) {
                //if (hasQueuedPredecessors())
                    //return -1;
                //int available = getState();
                //int remaining = available - acquires;
                //if (remaining < 0 ||
                    //compareAndSetState(available, remaining))
                    //return remaining;
            //}
        }

        
        private static final long serialVersionUID = 2014338818796000944L;
    }


    
    private static final long serialVersionUID = -3222578661600680210L;
}

