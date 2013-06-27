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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.235 -0400", hash_original_field = "63AD9D34F3503826E5F649AE6B7AC92C", hash_generated_field = "A4B34EF3CE38520839B34A2F06599243")

    private Sync sync;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.236 -0400", hash_original_method = "1D09FBBC41D290488B50FAB01D9EE120", hash_generated_method = "13962118142FDEFB392405E8F00D1980")
    public  Semaphore(int permits) {
        sync = new NonfairSync(permits);
        // ---------- Original Method ----------
        //sync = new NonfairSync(permits);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.236 -0400", hash_original_method = "EDA1419EB058A316E989F6F201EF4313", hash_generated_method = "13367ADAF65E44BD9192860D4A3B7131")
    public  Semaphore(int permits, boolean fair) {
        sync = fair ? new FairSync(permits) : new NonfairSync(permits);
        // ---------- Original Method ----------
        //sync = fair ? new FairSync(permits) : new NonfairSync(permits);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.236 -0400", hash_original_method = "36195816327B5FFC3BDF4AB88B23D805", hash_generated_method = "3DBDFDABAA7FC274F5D5F4A20CA8CA86")
    public void acquire() throws InterruptedException {
        sync.acquireSharedInterruptibly(1);
        // ---------- Original Method ----------
        //sync.acquireSharedInterruptibly(1);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.236 -0400", hash_original_method = "EECA708F1A8CDD46B9FED024EA3B107E", hash_generated_method = "65DDEE07CA9D1A9C8DF2A7F368E92FF2")
    public void acquireUninterruptibly() {
        sync.acquireShared(1);
        // ---------- Original Method ----------
        //sync.acquireShared(1);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.237 -0400", hash_original_method = "81DB55A43E3FEF36A7D7A44C596F2527", hash_generated_method = "592A6167F156D24561DB0827748B5A4F")
    public boolean tryAcquire() {
        boolean var1A869DF11DFE4771E0F19E1A8F688755_424483126 = (sync.nonfairTryAcquireShared(1) >= 0);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2003080610 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2003080610;
        // ---------- Original Method ----------
        //return sync.nonfairTryAcquireShared(1) >= 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.237 -0400", hash_original_method = "ABEC3704F68F4BA58C5E653A10F8C77A", hash_generated_method = "273102426AF28D8A94AB891A857A530C")
    public boolean tryAcquire(long timeout, TimeUnit unit) throws InterruptedException {
        boolean varD12778331A5B05E1E52D9468F6FF0E07_2028300827 = (sync.tryAcquireSharedNanos(1, unit.toNanos(timeout)));
        addTaint(timeout);
        addTaint(unit.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1792432437 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1792432437;
        // ---------- Original Method ----------
        //return sync.tryAcquireSharedNanos(1, unit.toNanos(timeout));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.237 -0400", hash_original_method = "A31CF20052BB7332FF63483E272EE6FB", hash_generated_method = "3FED394AF8AC081B7B78D6F30457AAA9")
    public void release() {
        sync.releaseShared(1);
        // ---------- Original Method ----------
        //sync.releaseShared(1);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.237 -0400", hash_original_method = "7B985EDB9B3C3368A9FFE0EA00FDC854", hash_generated_method = "8B627A3DC6E14B6167C7CF404FBEFD28")
    public void acquire(int permits) throws InterruptedException {
        if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException();
        sync.acquireSharedInterruptibly(permits);
        addTaint(permits);
        // ---------- Original Method ----------
        //if (permits < 0) throw new IllegalArgumentException();
        //sync.acquireSharedInterruptibly(permits);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.251 -0400", hash_original_method = "AED087DD2B1BE9707E61AD056A232C9F", hash_generated_method = "5886AD288C70497B528D5DD558F470AF")
    public void acquireUninterruptibly(int permits) {
        if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException();
        sync.acquireShared(permits);
        addTaint(permits);
        // ---------- Original Method ----------
        //if (permits < 0) throw new IllegalArgumentException();
        //sync.acquireShared(permits);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.252 -0400", hash_original_method = "9FDABFB6FA908071648B312E27A5D44A", hash_generated_method = "B3D3811B0E0E1E40A8AB378A0C8AECB1")
    public boolean tryAcquire(int permits) {
        if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException();
        boolean varFAE9003C69B035E758181BB99F298216_1301430282 = (sync.nonfairTryAcquireShared(permits) >= 0);
        addTaint(permits);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1672694563 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1672694563;
        // ---------- Original Method ----------
        //if (permits < 0) throw new IllegalArgumentException();
        //return sync.nonfairTryAcquireShared(permits) >= 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.252 -0400", hash_original_method = "80ECB8EBF7BA66409D7CA6C7FAEA0198", hash_generated_method = "833950FFD7991901EDB0657A92BEA514")
    public boolean tryAcquire(int permits, long timeout, TimeUnit unit) throws InterruptedException {
        if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException();
        boolean var291B054738129328132ED0F986893830_1036291668 = (sync.tryAcquireSharedNanos(permits, unit.toNanos(timeout)));
        addTaint(permits);
        addTaint(timeout);
        addTaint(unit.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1406452201 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1406452201;
        // ---------- Original Method ----------
        //if (permits < 0) throw new IllegalArgumentException();
        //return sync.tryAcquireSharedNanos(permits, unit.toNanos(timeout));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.252 -0400", hash_original_method = "86FDC777B5FFBB0166AB6B40E9CBCA0F", hash_generated_method = "BE389345A2A429C91E1E8EA9324E6765")
    public void release(int permits) {
        if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException();
        sync.releaseShared(permits);
        addTaint(permits);
        // ---------- Original Method ----------
        //if (permits < 0) throw new IllegalArgumentException();
        //sync.releaseShared(permits);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.253 -0400", hash_original_method = "A0D0E9E456108DB04A370C1A3BAF302D", hash_generated_method = "38A21531F194F981A281B6F1159057B8")
    public int availablePermits() {
        int var95D1737DCBC549BFF9F6868C1B7F656B_1913002540 = (sync.getPermits());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1784412460 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1784412460;
        // ---------- Original Method ----------
        //return sync.getPermits();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.253 -0400", hash_original_method = "262F2C65B1D17DEC110169282F777115", hash_generated_method = "852430F621C47B8F161223AA16A1D1B5")
    public int drainPermits() {
        int var8FDC00DE9DAA66FA61202193D997AE79_1901866087 = (sync.drainPermits());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_218786682 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_218786682;
        // ---------- Original Method ----------
        //return sync.drainPermits();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.253 -0400", hash_original_method = "98D8F44FFB6E2B81C61D6FB2F4F416AF", hash_generated_method = "07A8D5053CC501D68E512632DAF36E6D")
    protected void reducePermits(int reduction) {
        if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException();
        sync.reducePermits(reduction);
        addTaint(reduction);
        // ---------- Original Method ----------
        //if (reduction < 0) throw new IllegalArgumentException();
        //sync.reducePermits(reduction);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.253 -0400", hash_original_method = "6835E283E5F9E7FBD3FF7844476992AD", hash_generated_method = "1897289F74C0780978426B7DADF626C5")
    public boolean isFair() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1123031344 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1123031344;
        // ---------- Original Method ----------
        //return sync instanceof FairSync;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.254 -0400", hash_original_method = "33B7DCC82A105082FC4D268ED56F9DE5", hash_generated_method = "2B009BF1A003372CF6EB325B1007C8D4")
    public final boolean hasQueuedThreads() {
        boolean var4C0A0AB508905DA8D619627A5EEFD574_629838801 = (sync.hasQueuedThreads());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1921088627 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1921088627;
        // ---------- Original Method ----------
        //return sync.hasQueuedThreads();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.254 -0400", hash_original_method = "DFFF2C05339152644F00EC2FFC57EFB9", hash_generated_method = "2B911FE82E4CFC96C4218D997FA0F993")
    public final int getQueueLength() {
        int var2545CC142A0CD1008911850681315651_1299558352 = (sync.getQueueLength());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_869874911 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_869874911;
        // ---------- Original Method ----------
        //return sync.getQueueLength();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.254 -0400", hash_original_method = "4BC73C35668DA24636BE58FB68209032", hash_generated_method = "E2AD385809E8F5C437D820012883D474")
    protected Collection<Thread> getQueuedThreads() {
        Collection<Thread> varB4EAC82CA7396A68D541C85D26508E83_1153821751 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1153821751 = sync.getQueuedThreads();
        varB4EAC82CA7396A68D541C85D26508E83_1153821751.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1153821751;
        // ---------- Original Method ----------
        //return sync.getQueuedThreads();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.255 -0400", hash_original_method = "28E11779691509B84604A2532741810B", hash_generated_method = "14E81814562357022142DB28C47BC2EB")
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_44965488 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_44965488 = super.toString() + "[Permits = " + sync.getPermits() + "]";
        varB4EAC82CA7396A68D541C85D26508E83_44965488.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_44965488;
        // ---------- Original Method ----------
        //return super.toString() + "[Permits = " + sync.getPermits() + "]";
    }

    
    abstract static class Sync extends AbstractQueuedSynchronizer {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.255 -0400", hash_original_method = "40565DEBA5724270F81AA15CDC452278", hash_generated_method = "3A446343D631B2073840BE797E830F7D")
          Sync(int permits) {
            setState(permits);
            addTaint(permits);
            // ---------- Original Method ----------
            //setState(permits);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.255 -0400", hash_original_method = "932F869D56214E546755CFC45FDC49E6", hash_generated_method = "FC79E4B29FAE4EB37D56D4F5347B8E4E")
        final int getPermits() {
            int var376B5C2087169E76FB6628D31DCC9663_1374939663 = (getState());
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_39077085 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_39077085;
            // ---------- Original Method ----------
            //return getState();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.255 -0400", hash_original_method = "38128BDDEF18CD48BAE30B545E1D6E2D", hash_generated_method = "AB11BE3171EAEE1D248ED06FFCD32F59")
        final int nonfairTryAcquireShared(int acquires) {
            {
                int available;
                available = getState();
                int remaining;
                remaining = available - acquires;
                {
                    boolean var5D6AC5DCD986512A248800EB87AD1FF5_1525952965 = (remaining < 0 ||
                    compareAndSetState(available, remaining));
                } //End collapsed parenthetic
            } //End block
            addTaint(acquires);
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_722027500 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_722027500;
            // ---------- Original Method ----------
            //for (;;) {
                //int available = getState();
                //int remaining = available - acquires;
                //if (remaining < 0 ||
                    //compareAndSetState(available, remaining))
                    //return remaining;
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.256 -0400", hash_original_method = "E4485505685AAE5BA8902CEC7119047D", hash_generated_method = "4BC8D769D64C6F70CD11510D06DBA98F")
        protected final boolean tryReleaseShared(int releases) {
            {
                int current;
                current = getState();
                int next;
                next = current + releases;
                if (DroidSafeAndroidRuntime.control) throw new Error("Maximum permit count exceeded");
                {
                    boolean var65C830D7C0FA9CE6017EA2EABEEC91DA_1553092106 = (compareAndSetState(current, next));
                } //End collapsed parenthetic
            } //End block
            addTaint(releases);
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1692775753 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1692775753;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.256 -0400", hash_original_method = "EF09815047CF337EE6F8F6B76E860F15", hash_generated_method = "5266AE295E9D95441B04A29B61A1B820")
        final void reducePermits(int reductions) {
            {
                int current;
                current = getState();
                int next;
                next = current - reductions;
                if (DroidSafeAndroidRuntime.control) throw new Error("Permit count underflow");
                {
                    boolean var65C830D7C0FA9CE6017EA2EABEEC91DA_842737898 = (compareAndSetState(current, next));
                } //End collapsed parenthetic
            } //End block
            addTaint(reductions);
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.256 -0400", hash_original_method = "B47D637533AD6479C19BA02673B291F3", hash_generated_method = "4EA32A697D43E87C9A853EAA65262906")
        final int drainPermits() {
            {
                int current;
                current = getState();
                {
                    boolean var65CEFE613645BE51CB825F0504FCD77C_18930417 = (current == 0 || compareAndSetState(current, 0));
                } //End collapsed parenthetic
            } //End block
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1592707254 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1592707254;
            // ---------- Original Method ----------
            //for (;;) {
                //int current = getState();
                //if (current == 0 || compareAndSetState(current, 0))
                    //return current;
            //}
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.257 -0400", hash_original_field = "18298C361C670DF355B76B409AE3DC3E", hash_generated_field = "A2A43E248B2CBCF2799363D172D1DE93")

        private static long serialVersionUID = 1192457210091910933L;
    }


    
    static final class NonfairSync extends Sync {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.257 -0400", hash_original_method = "AB02276AF05DB48D17C9E59129A0533C", hash_generated_method = "778E4A8D581AA87BDE4BC7B442FB1199")
          NonfairSync(int permits) {
            super(permits);
            addTaint(permits);
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.257 -0400", hash_original_method = "2824818F1E688287ED8D5382B9F9370B", hash_generated_method = "561EBCBF581D7C019C899B5E7B3BBB3F")
        protected int tryAcquireShared(int acquires) {
            int var1CC5CB853AD33680443F732E6C080712_1761925186 = (nonfairTryAcquireShared(acquires));
            addTaint(acquires);
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_605276725 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_605276725;
            // ---------- Original Method ----------
            //return nonfairTryAcquireShared(acquires);
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.257 -0400", hash_original_field = "23F0C3844291A7F93F8AC72653575080", hash_generated_field = "4F7E0C31EF2A49C4C5FAB7F9756A5F6E")

        private static long serialVersionUID = -2694183684443567898L;
    }


    
    static final class FairSync extends Sync {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.273 -0400", hash_original_method = "1546A983167A4F32841E77BDDAC1FABE", hash_generated_method = "CEAD53968F247A2DA87FEB0CB5B04DA9")
          FairSync(int permits) {
            super(permits);
            addTaint(permits);
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.273 -0400", hash_original_method = "33A8BA33CEB07226CB7C962FD4989C27", hash_generated_method = "FA9835048EC2E41D906C2B95A8EE50C0")
        protected int tryAcquireShared(int acquires) {
            {
                {
                    boolean varE9533D34087E45E4AB2319427A8AD4CE_2059220769 = (hasQueuedPredecessors());
                } //End collapsed parenthetic
                int available;
                available = getState();
                int remaining;
                remaining = available - acquires;
                {
                    boolean var5D6AC5DCD986512A248800EB87AD1FF5_2137089723 = (remaining < 0 ||
                    compareAndSetState(available, remaining));
                } //End collapsed parenthetic
            } //End block
            addTaint(acquires);
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1786749373 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1786749373;
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

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.273 -0400", hash_original_field = "720AD567BEDC79E1D77C8B979A474E84", hash_generated_field = "6AB2CCE9B47E948E66150356BCA7AF31")

        private static long serialVersionUID = 2014338818796000944L;
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.273 -0400", hash_original_field = "485FF00B97D6568FE4B4890F9F8002C1", hash_generated_field = "5A2B24CAC2B64144EAFA6DE830C0C8BB")

    private static long serialVersionUID = -3222578661600680210L;
}

