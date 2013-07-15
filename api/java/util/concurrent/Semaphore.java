package java.util.concurrent;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.util.*;
import java.util.concurrent.locks.*;
import java.util.concurrent.atomic.*;

public class Semaphore implements java.io.Serializable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:16.819 -0400", hash_original_field = "63AD9D34F3503826E5F649AE6B7AC92C", hash_generated_field = "A4B34EF3CE38520839B34A2F06599243")

    private Sync sync;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:16.819 -0400", hash_original_method = "1D09FBBC41D290488B50FAB01D9EE120", hash_generated_method = "13962118142FDEFB392405E8F00D1980")
    public  Semaphore(int permits) {
        sync = new NonfairSync(permits);
        // ---------- Original Method ----------
        //sync = new NonfairSync(permits);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:16.820 -0400", hash_original_method = "EDA1419EB058A316E989F6F201EF4313", hash_generated_method = "13367ADAF65E44BD9192860D4A3B7131")
    public  Semaphore(int permits, boolean fair) {
        sync = fair ? new FairSync(permits) : new NonfairSync(permits);
        // ---------- Original Method ----------
        //sync = fair ? new FairSync(permits) : new NonfairSync(permits);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:16.820 -0400", hash_original_method = "36195816327B5FFC3BDF4AB88B23D805", hash_generated_method = "3DBDFDABAA7FC274F5D5F4A20CA8CA86")
    public void acquire() throws InterruptedException {
        sync.acquireSharedInterruptibly(1);
        // ---------- Original Method ----------
        //sync.acquireSharedInterruptibly(1);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:16.821 -0400", hash_original_method = "EECA708F1A8CDD46B9FED024EA3B107E", hash_generated_method = "65DDEE07CA9D1A9C8DF2A7F368E92FF2")
    public void acquireUninterruptibly() {
        sync.acquireShared(1);
        // ---------- Original Method ----------
        //sync.acquireShared(1);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:16.821 -0400", hash_original_method = "81DB55A43E3FEF36A7D7A44C596F2527", hash_generated_method = "58C24A7F8C9344B9EA594CADA1531DEE")
    public boolean tryAcquire() {
        boolean varDB3B551E4ED40518B68430636E27BC5F_678493255 = (sync.nonfairTryAcquireShared(1) >= 0);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1688057733 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1688057733;
        // ---------- Original Method ----------
        //return sync.nonfairTryAcquireShared(1) >= 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:16.822 -0400", hash_original_method = "ABEC3704F68F4BA58C5E653A10F8C77A", hash_generated_method = "7FF647ACED2F5D5EB81D417C510B9F4D")
    public boolean tryAcquire(long timeout, TimeUnit unit) throws InterruptedException {
        addTaint(unit.getTaint());
        addTaint(timeout);
        boolean varF9FFBA7272EE05E2720644344A388E0D_1063630202 = (sync.tryAcquireSharedNanos(1, unit.toNanos(timeout)));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1203579573 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1203579573;
        // ---------- Original Method ----------
        //return sync.tryAcquireSharedNanos(1, unit.toNanos(timeout));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:16.822 -0400", hash_original_method = "A31CF20052BB7332FF63483E272EE6FB", hash_generated_method = "3FED394AF8AC081B7B78D6F30457AAA9")
    public void release() {
        sync.releaseShared(1);
        // ---------- Original Method ----------
        //sync.releaseShared(1);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:16.822 -0400", hash_original_method = "7B985EDB9B3C3368A9FFE0EA00FDC854", hash_generated_method = "6F052424D628374B95BC896A3A314B91")
    public void acquire(int permits) throws InterruptedException {
        addTaint(permits);
    if(permits < 0)        
        {
        IllegalArgumentException var5783EF97022AA508B74A1E3EA38534AF_724914838 = new IllegalArgumentException();
        var5783EF97022AA508B74A1E3EA38534AF_724914838.addTaint(taint);
        throw var5783EF97022AA508B74A1E3EA38534AF_724914838;
        }
        sync.acquireSharedInterruptibly(permits);
        // ---------- Original Method ----------
        //if (permits < 0) throw new IllegalArgumentException();
        //sync.acquireSharedInterruptibly(permits);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:16.823 -0400", hash_original_method = "AED087DD2B1BE9707E61AD056A232C9F", hash_generated_method = "4FBF730E07A950030C5002CCB022D4DA")
    public void acquireUninterruptibly(int permits) {
        addTaint(permits);
    if(permits < 0)        
        {
        IllegalArgumentException var5783EF97022AA508B74A1E3EA38534AF_2043810755 = new IllegalArgumentException();
        var5783EF97022AA508B74A1E3EA38534AF_2043810755.addTaint(taint);
        throw var5783EF97022AA508B74A1E3EA38534AF_2043810755;
        }
        sync.acquireShared(permits);
        // ---------- Original Method ----------
        //if (permits < 0) throw new IllegalArgumentException();
        //sync.acquireShared(permits);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:16.823 -0400", hash_original_method = "9FDABFB6FA908071648B312E27A5D44A", hash_generated_method = "66511921B0F8D26A26770191AF38E8BB")
    public boolean tryAcquire(int permits) {
        addTaint(permits);
    if(permits < 0)        
        {
        IllegalArgumentException var5783EF97022AA508B74A1E3EA38534AF_186391574 = new IllegalArgumentException();
        var5783EF97022AA508B74A1E3EA38534AF_186391574.addTaint(taint);
        throw var5783EF97022AA508B74A1E3EA38534AF_186391574;
        }
        boolean varFA3D3DF75BD9DB211ACE5F563AB90B4D_751755737 = (sync.nonfairTryAcquireShared(permits) >= 0);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1395627633 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1395627633;
        // ---------- Original Method ----------
        //if (permits < 0) throw new IllegalArgumentException();
        //return sync.nonfairTryAcquireShared(permits) >= 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:16.824 -0400", hash_original_method = "80ECB8EBF7BA66409D7CA6C7FAEA0198", hash_generated_method = "6ECD66645925E85CDB40496BCA04C62E")
    public boolean tryAcquire(int permits, long timeout, TimeUnit unit) throws InterruptedException {
        addTaint(unit.getTaint());
        addTaint(timeout);
        addTaint(permits);
    if(permits < 0)        
        {
        IllegalArgumentException var5783EF97022AA508B74A1E3EA38534AF_2056030864 = new IllegalArgumentException();
        var5783EF97022AA508B74A1E3EA38534AF_2056030864.addTaint(taint);
        throw var5783EF97022AA508B74A1E3EA38534AF_2056030864;
        }
        boolean varC54D85A4A86BE4A350F90778D69AB4A1_877810249 = (sync.tryAcquireSharedNanos(permits, unit.toNanos(timeout)));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_639589787 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_639589787;
        // ---------- Original Method ----------
        //if (permits < 0) throw new IllegalArgumentException();
        //return sync.tryAcquireSharedNanos(permits, unit.toNanos(timeout));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:16.825 -0400", hash_original_method = "86FDC777B5FFBB0166AB6B40E9CBCA0F", hash_generated_method = "F47CA838544B00F8F7B25061282FA290")
    public void release(int permits) {
        addTaint(permits);
    if(permits < 0)        
        {
        IllegalArgumentException var5783EF97022AA508B74A1E3EA38534AF_216468733 = new IllegalArgumentException();
        var5783EF97022AA508B74A1E3EA38534AF_216468733.addTaint(taint);
        throw var5783EF97022AA508B74A1E3EA38534AF_216468733;
        }
        sync.releaseShared(permits);
        // ---------- Original Method ----------
        //if (permits < 0) throw new IllegalArgumentException();
        //sync.releaseShared(permits);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:16.826 -0400", hash_original_method = "A0D0E9E456108DB04A370C1A3BAF302D", hash_generated_method = "36988C14C7E9373874F30EF357126F5F")
    public int availablePermits() {
        int var8A1DEA8ABE61D61F28E149265FFC27EB_1609911131 = (sync.getPermits());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_439059930 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_439059930;
        // ---------- Original Method ----------
        //return sync.getPermits();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:16.827 -0400", hash_original_method = "262F2C65B1D17DEC110169282F777115", hash_generated_method = "9CBE0AA0100C1124357D24AB65250B82")
    public int drainPermits() {
        int varDBB90EE9A7C72CB0D11B224FC373A197_395920503 = (sync.drainPermits());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1721849148 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1721849148;
        // ---------- Original Method ----------
        //return sync.drainPermits();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:16.828 -0400", hash_original_method = "98D8F44FFB6E2B81C61D6FB2F4F416AF", hash_generated_method = "B290EBFA10623903F12BCD07D7C2532C")
    protected void reducePermits(int reduction) {
        addTaint(reduction);
    if(reduction < 0)        
        {
        IllegalArgumentException var5783EF97022AA508B74A1E3EA38534AF_1142740310 = new IllegalArgumentException();
        var5783EF97022AA508B74A1E3EA38534AF_1142740310.addTaint(taint);
        throw var5783EF97022AA508B74A1E3EA38534AF_1142740310;
        }
        sync.reducePermits(reduction);
        // ---------- Original Method ----------
        //if (reduction < 0) throw new IllegalArgumentException();
        //sync.reducePermits(reduction);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:16.828 -0400", hash_original_method = "6835E283E5F9E7FBD3FF7844476992AD", hash_generated_method = "D2B040116DB6924B50D3F573FAD2AD1A")
    public boolean isFair() {
        boolean var025994C1DF49233538C6DF8BADB9C6C8_1272966308 = (sync instanceof FairSync);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1688979795 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1688979795;
        // ---------- Original Method ----------
        //return sync instanceof FairSync;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:16.828 -0400", hash_original_method = "33B7DCC82A105082FC4D268ED56F9DE5", hash_generated_method = "6AB2F722E70A8E37AE0C86108353A176")
    public final boolean hasQueuedThreads() {
        boolean var2967874652C8008E25540A916154E044_877573860 = (sync.hasQueuedThreads());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2144816441 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2144816441;
        // ---------- Original Method ----------
        //return sync.hasQueuedThreads();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:16.828 -0400", hash_original_method = "DFFF2C05339152644F00EC2FFC57EFB9", hash_generated_method = "C3984133069517B619F8E70C45623DA2")
    public final int getQueueLength() {
        int var5D329306F1180332B8FF4C47065D325F_1034580146 = (sync.getQueueLength());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_316984477 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_316984477;
        // ---------- Original Method ----------
        //return sync.getQueueLength();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:16.829 -0400", hash_original_method = "4BC73C35668DA24636BE58FB68209032", hash_generated_method = "AE12A121C65EB0DA43935D50C5239E58")
    protected Collection<Thread> getQueuedThreads() {
Collection<Thread> var0FD62A6A977BE381AD6B1EE70126B5BB_2050596092 =         sync.getQueuedThreads();
        var0FD62A6A977BE381AD6B1EE70126B5BB_2050596092.addTaint(taint);
        return var0FD62A6A977BE381AD6B1EE70126B5BB_2050596092;
        // ---------- Original Method ----------
        //return sync.getQueuedThreads();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:16.829 -0400", hash_original_method = "28E11779691509B84604A2532741810B", hash_generated_method = "34AA00659F2C32F4E94293BCD553CFF6")
    public String toString() {
String varEE78BE575C00AEA578F480ECEE9C4FB4_1895785245 =         super.toString() + "[Permits = " + sync.getPermits() + "]";
        varEE78BE575C00AEA578F480ECEE9C4FB4_1895785245.addTaint(taint);
        return varEE78BE575C00AEA578F480ECEE9C4FB4_1895785245;
        // ---------- Original Method ----------
        //return super.toString() + "[Permits = " + sync.getPermits() + "]";
    }

    
    abstract static class Sync extends AbstractQueuedSynchronizer {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:16.829 -0400", hash_original_method = "40565DEBA5724270F81AA15CDC452278", hash_generated_method = "FA6FD9331C57C6F1FEF7362CC8365AAB")
          Sync(int permits) {
            addTaint(permits);
            setState(permits);
            // ---------- Original Method ----------
            //setState(permits);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:16.829 -0400", hash_original_method = "932F869D56214E546755CFC45FDC49E6", hash_generated_method = "7817EDD2D3AA8496F0D52D67DC37A975")
        final int getPermits() {
            int var118C4F58F1303398C344B8AAB7CE6EE1_1155251397 = (getState());
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1165272218 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1165272218;
            // ---------- Original Method ----------
            //return getState();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:16.830 -0400", hash_original_method = "38128BDDEF18CD48BAE30B545E1D6E2D", hash_generated_method = "E661F56F2904AA490E62D08D4CF668E5")
        final int nonfairTryAcquireShared(int acquires) {
            addTaint(acquires);
for(;;)
            {
                int available = getState();
                int remaining = available - acquires;
    if(remaining < 0 ||
                    compareAndSetState(available, remaining))                
                {
                int var2626772C17D90CF46BE4FE981FF30AC8_974821192 = (remaining);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_717695035 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_717695035;
                }
            } //End block
            // ---------- Original Method ----------
            //for (;;) {
                //int available = getState();
                //int remaining = available - acquires;
                //if (remaining < 0 ||
                    //compareAndSetState(available, remaining))
                    //return remaining;
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:16.830 -0400", hash_original_method = "E4485505685AAE5BA8902CEC7119047D", hash_generated_method = "16FA815E1139AEED5C645721DF5E8077")
        protected final boolean tryReleaseShared(int releases) {
            addTaint(releases);
for(;;)
            {
                int current = getState();
                int next = current + releases;
    if(next < current)                
                {
                Error varDB3A8D1F86DAF3841B8E6356E86A7A6F_1901240745 = new Error("Maximum permit count exceeded");
                varDB3A8D1F86DAF3841B8E6356E86A7A6F_1901240745.addTaint(taint);
                throw varDB3A8D1F86DAF3841B8E6356E86A7A6F_1901240745;
                }
    if(compareAndSetState(current, next))                
                {
                boolean varB326B5062B2F0E69046810717534CB09_1574453805 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1165346493 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1165346493;
                }
            } //End block
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:16.831 -0400", hash_original_method = "EF09815047CF337EE6F8F6B76E860F15", hash_generated_method = "4E41F30135B2FBF446A073552043A35E")
        final void reducePermits(int reductions) {
            addTaint(reductions);
for(;;)
            {
                int current = getState();
                int next = current - reductions;
    if(next > current)                
                {
                Error varE32148B8ADC13FC6B86DB00549C1F02F_790172757 = new Error("Permit count underflow");
                varE32148B8ADC13FC6B86DB00549C1F02F_790172757.addTaint(taint);
                throw varE32148B8ADC13FC6B86DB00549C1F02F_790172757;
                }
    if(compareAndSetState(current, next))                
                return;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:16.831 -0400", hash_original_method = "B47D637533AD6479C19BA02673B291F3", hash_generated_method = "5CF345056D39CD3FF674B9EC8C0B15D7")
        final int drainPermits() {
for(;;)
            {
                int current = getState();
    if(current == 0 || compareAndSetState(current, 0))                
                {
                int var43B5C9175984C071F30B873FDCE0A000_222579458 = (current);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_825648771 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_825648771;
                }
            } //End block
            // ---------- Original Method ----------
            //for (;;) {
                //int current = getState();
                //if (current == 0 || compareAndSetState(current, 0))
                    //return current;
            //}
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:16.831 -0400", hash_original_field = "18298C361C670DF355B76B409AE3DC3E", hash_generated_field = "A656A5C20233C00BCDB91774C38EC514")

        private static final long serialVersionUID = 1192457210091910933L;
    }


    
    static final class NonfairSync extends Sync {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:16.831 -0400", hash_original_method = "AB02276AF05DB48D17C9E59129A0533C", hash_generated_method = "778E4A8D581AA87BDE4BC7B442FB1199")
          NonfairSync(int permits) {
            super(permits);
            addTaint(permits);
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:16.832 -0400", hash_original_method = "2824818F1E688287ED8D5382B9F9370B", hash_generated_method = "D1BA26E29EFD934C3B8073837F3DA3AA")
        protected int tryAcquireShared(int acquires) {
            addTaint(acquires);
            int var88AE15AC05ADF47D4173EA3A19BC4346_1577037830 = (nonfairTryAcquireShared(acquires));
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1709838055 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1709838055;
            // ---------- Original Method ----------
            //return nonfairTryAcquireShared(acquires);
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:16.832 -0400", hash_original_field = "23F0C3844291A7F93F8AC72653575080", hash_generated_field = "AF8D9D2DFF309778F150C3E144D5488E")

        private static final long serialVersionUID = -2694183684443567898L;
    }


    
    static final class FairSync extends Sync {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:16.833 -0400", hash_original_method = "1546A983167A4F32841E77BDDAC1FABE", hash_generated_method = "CEAD53968F247A2DA87FEB0CB5B04DA9")
          FairSync(int permits) {
            super(permits);
            addTaint(permits);
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:16.833 -0400", hash_original_method = "33A8BA33CEB07226CB7C962FD4989C27", hash_generated_method = "CDE25D66429324C2F7CB58ED5FB749B1")
        protected int tryAcquireShared(int acquires) {
            addTaint(acquires);
for(;;)
            {
    if(hasQueuedPredecessors())                
                {
                int var6BB61E3B7BCE0931DA574D19D1D82C88_2008221032 = (-1);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1768472283 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1768472283;
                }
                int available = getState();
                int remaining = available - acquires;
    if(remaining < 0 ||
                    compareAndSetState(available, remaining))                
                {
                int var2626772C17D90CF46BE4FE981FF30AC8_1819693511 = (remaining);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_657760584 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_657760584;
                }
            } //End block
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

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:16.833 -0400", hash_original_field = "720AD567BEDC79E1D77C8B979A474E84", hash_generated_field = "7955A4226A8EE675254DC7AB4392270B")

        private static final long serialVersionUID = 2014338818796000944L;
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:16.834 -0400", hash_original_field = "485FF00B97D6568FE4B4890F9F8002C1", hash_generated_field = "B51BFB8167C0871125DF74AE3E8AFF72")

    private static final long serialVersionUID = -3222578661600680210L;
}

