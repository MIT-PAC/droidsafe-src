package java.util.concurrent;

// Droidsafe Imports
import droidsafe.annotations.*;
import java.util.Collection;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;






public class Semaphore implements java.io.Serializable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:14.805 -0400", hash_original_field = "63AD9D34F3503826E5F649AE6B7AC92C", hash_generated_field = "A4B34EF3CE38520839B34A2F06599243")

    private Sync sync;
    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:14.805 -0400", hash_original_method = "1D09FBBC41D290488B50FAB01D9EE120", hash_generated_method = "13962118142FDEFB392405E8F00D1980")
    public  Semaphore(int permits) {
        sync = new NonfairSync(permits);
        // ---------- Original Method ----------
        //sync = new NonfairSync(permits);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:14.806 -0400", hash_original_method = "EDA1419EB058A316E989F6F201EF4313", hash_generated_method = "13367ADAF65E44BD9192860D4A3B7131")
    public  Semaphore(int permits, boolean fair) {
        sync = fair ? new FairSync(permits) : new NonfairSync(permits);
        // ---------- Original Method ----------
        //sync = fair ? new FairSync(permits) : new NonfairSync(permits);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:14.806 -0400", hash_original_method = "36195816327B5FFC3BDF4AB88B23D805", hash_generated_method = "3DBDFDABAA7FC274F5D5F4A20CA8CA86")
    public void acquire() throws InterruptedException {
        sync.acquireSharedInterruptibly(1);
        // ---------- Original Method ----------
        //sync.acquireSharedInterruptibly(1);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:14.806 -0400", hash_original_method = "EECA708F1A8CDD46B9FED024EA3B107E", hash_generated_method = "65DDEE07CA9D1A9C8DF2A7F368E92FF2")
    public void acquireUninterruptibly() {
        sync.acquireShared(1);
        // ---------- Original Method ----------
        //sync.acquireShared(1);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:14.806 -0400", hash_original_method = "81DB55A43E3FEF36A7D7A44C596F2527", hash_generated_method = "6DB7EA79960556A2A56215AC12751692")
    public boolean tryAcquire() {
        boolean varDB3B551E4ED40518B68430636E27BC5F_1070605302 = (sync.nonfairTryAcquireShared(1) >= 0);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_133765608 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_133765608;
        // ---------- Original Method ----------
        //return sync.nonfairTryAcquireShared(1) >= 0;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:14.807 -0400", hash_original_method = "ABEC3704F68F4BA58C5E653A10F8C77A", hash_generated_method = "7BB3C8087680C30990981800017C7143")
    public boolean tryAcquire(long timeout, TimeUnit unit) throws InterruptedException {
        addTaint(unit.getTaint());
        addTaint(timeout);
        boolean varF9FFBA7272EE05E2720644344A388E0D_1766189843 = (sync.tryAcquireSharedNanos(1, unit.toNanos(timeout)));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1246192214 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1246192214;
        // ---------- Original Method ----------
        //return sync.tryAcquireSharedNanos(1, unit.toNanos(timeout));
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:14.807 -0400", hash_original_method = "A31CF20052BB7332FF63483E272EE6FB", hash_generated_method = "3FED394AF8AC081B7B78D6F30457AAA9")
    public void release() {
        sync.releaseShared(1);
        // ---------- Original Method ----------
        //sync.releaseShared(1);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:14.807 -0400", hash_original_method = "7B985EDB9B3C3368A9FFE0EA00FDC854", hash_generated_method = "417B94B9B5250294954DEE8186DE15D6")
    public void acquire(int permits) throws InterruptedException {
        addTaint(permits);
        if(permits < 0)        
        {
        IllegalArgumentException var5783EF97022AA508B74A1E3EA38534AF_1061858340 = new IllegalArgumentException();
        var5783EF97022AA508B74A1E3EA38534AF_1061858340.addTaint(taint);
        throw var5783EF97022AA508B74A1E3EA38534AF_1061858340;
        }
        sync.acquireSharedInterruptibly(permits);
        // ---------- Original Method ----------
        //if (permits < 0) throw new IllegalArgumentException();
        //sync.acquireSharedInterruptibly(permits);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:14.807 -0400", hash_original_method = "AED087DD2B1BE9707E61AD056A232C9F", hash_generated_method = "D03F4CFD44C7B04F91609C40B1697E22")
    public void acquireUninterruptibly(int permits) {
        addTaint(permits);
        if(permits < 0)        
        {
        IllegalArgumentException var5783EF97022AA508B74A1E3EA38534AF_597297382 = new IllegalArgumentException();
        var5783EF97022AA508B74A1E3EA38534AF_597297382.addTaint(taint);
        throw var5783EF97022AA508B74A1E3EA38534AF_597297382;
        }
        sync.acquireShared(permits);
        // ---------- Original Method ----------
        //if (permits < 0) throw new IllegalArgumentException();
        //sync.acquireShared(permits);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:14.808 -0400", hash_original_method = "9FDABFB6FA908071648B312E27A5D44A", hash_generated_method = "6CB358D912B50190430FCECFD10A982A")
    public boolean tryAcquire(int permits) {
        addTaint(permits);
        if(permits < 0)        
        {
        IllegalArgumentException var5783EF97022AA508B74A1E3EA38534AF_1874828377 = new IllegalArgumentException();
        var5783EF97022AA508B74A1E3EA38534AF_1874828377.addTaint(taint);
        throw var5783EF97022AA508B74A1E3EA38534AF_1874828377;
        }
        boolean varFA3D3DF75BD9DB211ACE5F563AB90B4D_739491483 = (sync.nonfairTryAcquireShared(permits) >= 0);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1459068375 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1459068375;
        // ---------- Original Method ----------
        //if (permits < 0) throw new IllegalArgumentException();
        //return sync.nonfairTryAcquireShared(permits) >= 0;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:14.808 -0400", hash_original_method = "80ECB8EBF7BA66409D7CA6C7FAEA0198", hash_generated_method = "1B1FE8C1EFD67EB9448490EEFB52689E")
    public boolean tryAcquire(int permits, long timeout, TimeUnit unit) throws InterruptedException {
        addTaint(unit.getTaint());
        addTaint(timeout);
        addTaint(permits);
        if(permits < 0)        
        {
        IllegalArgumentException var5783EF97022AA508B74A1E3EA38534AF_1018829384 = new IllegalArgumentException();
        var5783EF97022AA508B74A1E3EA38534AF_1018829384.addTaint(taint);
        throw var5783EF97022AA508B74A1E3EA38534AF_1018829384;
        }
        boolean varC54D85A4A86BE4A350F90778D69AB4A1_118863893 = (sync.tryAcquireSharedNanos(permits, unit.toNanos(timeout)));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1264555719 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1264555719;
        // ---------- Original Method ----------
        //if (permits < 0) throw new IllegalArgumentException();
        //return sync.tryAcquireSharedNanos(permits, unit.toNanos(timeout));
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:14.808 -0400", hash_original_method = "86FDC777B5FFBB0166AB6B40E9CBCA0F", hash_generated_method = "10F4E07D3218B684FC485B2D5FA34515")
    public void release(int permits) {
        addTaint(permits);
        if(permits < 0)        
        {
        IllegalArgumentException var5783EF97022AA508B74A1E3EA38534AF_888659274 = new IllegalArgumentException();
        var5783EF97022AA508B74A1E3EA38534AF_888659274.addTaint(taint);
        throw var5783EF97022AA508B74A1E3EA38534AF_888659274;
        }
        sync.releaseShared(permits);
        // ---------- Original Method ----------
        //if (permits < 0) throw new IllegalArgumentException();
        //sync.releaseShared(permits);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:14.809 -0400", hash_original_method = "A0D0E9E456108DB04A370C1A3BAF302D", hash_generated_method = "53ADB0901BAEEBBA6F43DEA4A22F52A2")
    public int availablePermits() {
        int var8A1DEA8ABE61D61F28E149265FFC27EB_1824931018 = (sync.getPermits());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1806456729 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1806456729;
        // ---------- Original Method ----------
        //return sync.getPermits();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:14.809 -0400", hash_original_method = "262F2C65B1D17DEC110169282F777115", hash_generated_method = "153EBF7D3E05CE0D9432CDFC7ABD8CF6")
    public int drainPermits() {
        int varDBB90EE9A7C72CB0D11B224FC373A197_1388209456 = (sync.drainPermits());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1393161588 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1393161588;
        // ---------- Original Method ----------
        //return sync.drainPermits();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:14.809 -0400", hash_original_method = "98D8F44FFB6E2B81C61D6FB2F4F416AF", hash_generated_method = "4A0B6033EE20E8DD2FC03829FEBA2A7C")
    protected void reducePermits(int reduction) {
        addTaint(reduction);
        if(reduction < 0)        
        {
        IllegalArgumentException var5783EF97022AA508B74A1E3EA38534AF_1756171159 = new IllegalArgumentException();
        var5783EF97022AA508B74A1E3EA38534AF_1756171159.addTaint(taint);
        throw var5783EF97022AA508B74A1E3EA38534AF_1756171159;
        }
        sync.reducePermits(reduction);
        // ---------- Original Method ----------
        //if (reduction < 0) throw new IllegalArgumentException();
        //sync.reducePermits(reduction);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:14.809 -0400", hash_original_method = "6835E283E5F9E7FBD3FF7844476992AD", hash_generated_method = "B62BBFB3997E239468E59B17233FD44E")
    public boolean isFair() {
        boolean var025994C1DF49233538C6DF8BADB9C6C8_1853920781 = (sync instanceof FairSync);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1222752488 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1222752488;
        // ---------- Original Method ----------
        //return sync instanceof FairSync;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:14.810 -0400", hash_original_method = "33B7DCC82A105082FC4D268ED56F9DE5", hash_generated_method = "CBB4A2819BBBAB36170FFA299CCEA007")
    public final boolean hasQueuedThreads() {
        boolean var2967874652C8008E25540A916154E044_1607020548 = (sync.hasQueuedThreads());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1533514598 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1533514598;
        // ---------- Original Method ----------
        //return sync.hasQueuedThreads();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:14.810 -0400", hash_original_method = "DFFF2C05339152644F00EC2FFC57EFB9", hash_generated_method = "5A23921049C50DD6F618E4E1D6EB8827")
    public final int getQueueLength() {
        int var5D329306F1180332B8FF4C47065D325F_1374649794 = (sync.getQueueLength());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1869107927 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1869107927;
        // ---------- Original Method ----------
        //return sync.getQueueLength();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:14.810 -0400", hash_original_method = "4BC73C35668DA24636BE58FB68209032", hash_generated_method = "1D4F9FA80CC946C462567CFD3EEAEF97")
    protected Collection<Thread> getQueuedThreads() {
Collection<Thread> var0FD62A6A977BE381AD6B1EE70126B5BB_384519907 =         sync.getQueuedThreads();
        var0FD62A6A977BE381AD6B1EE70126B5BB_384519907.addTaint(taint);
        return var0FD62A6A977BE381AD6B1EE70126B5BB_384519907;
        // ---------- Original Method ----------
        //return sync.getQueuedThreads();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:14.810 -0400", hash_original_method = "28E11779691509B84604A2532741810B", hash_generated_method = "896FAF3B21DCB994081BD0A7D5E0F005")
    public String toString() {
String varEE78BE575C00AEA578F480ECEE9C4FB4_504317829 =         super.toString() + "[Permits = " + sync.getPermits() + "]";
        varEE78BE575C00AEA578F480ECEE9C4FB4_504317829.addTaint(taint);
        return varEE78BE575C00AEA578F480ECEE9C4FB4_504317829;
        // ---------- Original Method ----------
        //return super.toString() + "[Permits = " + sync.getPermits() + "]";
    }

    
    abstract static class Sync extends AbstractQueuedSynchronizer {
        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:14.811 -0400", hash_original_method = "40565DEBA5724270F81AA15CDC452278", hash_generated_method = "FA6FD9331C57C6F1FEF7362CC8365AAB")
          Sync(int permits) {
            addTaint(permits);
            setState(permits);
            // ---------- Original Method ----------
            //setState(permits);
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:14.811 -0400", hash_original_method = "932F869D56214E546755CFC45FDC49E6", hash_generated_method = "EA437385EDC2A6E9A67E7CE8B4D55E18")
        final int getPermits() {
            int var118C4F58F1303398C344B8AAB7CE6EE1_237125787 = (getState());
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1492775954 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1492775954;
            // ---------- Original Method ----------
            //return getState();
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:14.811 -0400", hash_original_method = "38128BDDEF18CD48BAE30B545E1D6E2D", hash_generated_method = "44372231F0E2D5AC0E5F09EE9F33F52D")
        final int nonfairTryAcquireShared(int acquires) {
            addTaint(acquires);
for(;;)
            {
                int available = getState();
                int remaining = available - acquires;
                if(remaining < 0 ||
                    compareAndSetState(available, remaining))                
                {
                int var2626772C17D90CF46BE4FE981FF30AC8_411243217 = (remaining);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1429217693 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1429217693;
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

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:14.812 -0400", hash_original_method = "E4485505685AAE5BA8902CEC7119047D", hash_generated_method = "04833F69EAE49F938CCB333B94914FF0")
        protected final boolean tryReleaseShared(int releases) {
            addTaint(releases);
for(;;)
            {
                int current = getState();
                int next = current + releases;
                if(next < current)                
                {
                Error varDB3A8D1F86DAF3841B8E6356E86A7A6F_50324244 = new Error("Maximum permit count exceeded");
                varDB3A8D1F86DAF3841B8E6356E86A7A6F_50324244.addTaint(taint);
                throw varDB3A8D1F86DAF3841B8E6356E86A7A6F_50324244;
                }
                if(compareAndSetState(current, next))                
                {
                boolean varB326B5062B2F0E69046810717534CB09_1581352027 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2064825439 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_2064825439;
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

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:14.813 -0400", hash_original_method = "EF09815047CF337EE6F8F6B76E860F15", hash_generated_method = "85F7B203183DF6CDBDC780B58E801140")
        final void reducePermits(int reductions) {
            addTaint(reductions);
for(;;)
            {
                int current = getState();
                int next = current - reductions;
                if(next > current)                
                {
                Error varE32148B8ADC13FC6B86DB00549C1F02F_880159308 = new Error("Permit count underflow");
                varE32148B8ADC13FC6B86DB00549C1F02F_880159308.addTaint(taint);
                throw varE32148B8ADC13FC6B86DB00549C1F02F_880159308;
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

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:14.813 -0400", hash_original_method = "B47D637533AD6479C19BA02673B291F3", hash_generated_method = "BC386FD2B8AB1A67947B6F619F6C5CE4")
        final int drainPermits() {
for(;;)
            {
                int current = getState();
                if(current == 0 || compareAndSetState(current, 0))                
                {
                int var43B5C9175984C071F30B873FDCE0A000_596616813 = (current);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2089435346 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2089435346;
                }
            } //End block
            // ---------- Original Method ----------
            //for (;;) {
                //int current = getState();
                //if (current == 0 || compareAndSetState(current, 0))
                    //return current;
            //}
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:14.813 -0400", hash_original_field = "18298C361C670DF355B76B409AE3DC3E", hash_generated_field = "A656A5C20233C00BCDB91774C38EC514")

        private static final long serialVersionUID = 1192457210091910933L;
    }


    
    static final class NonfairSync extends Sync {
        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:14.814 -0400", hash_original_method = "AB02276AF05DB48D17C9E59129A0533C", hash_generated_method = "778E4A8D581AA87BDE4BC7B442FB1199")
          NonfairSync(int permits) {
            super(permits);
            addTaint(permits);
            // ---------- Original Method ----------
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:14.814 -0400", hash_original_method = "2824818F1E688287ED8D5382B9F9370B", hash_generated_method = "D203DA8F5AE7E8E3F32EA7D954FB2221")
        protected int tryAcquireShared(int acquires) {
            addTaint(acquires);
            int var88AE15AC05ADF47D4173EA3A19BC4346_1769017044 = (nonfairTryAcquireShared(acquires));
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_796457884 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_796457884;
            // ---------- Original Method ----------
            //return nonfairTryAcquireShared(acquires);
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:14.814 -0400", hash_original_field = "23F0C3844291A7F93F8AC72653575080", hash_generated_field = "AF8D9D2DFF309778F150C3E144D5488E")

        private static final long serialVersionUID = -2694183684443567898L;
    }


    
    static final class FairSync extends Sync {
        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:14.814 -0400", hash_original_method = "1546A983167A4F32841E77BDDAC1FABE", hash_generated_method = "CEAD53968F247A2DA87FEB0CB5B04DA9")
          FairSync(int permits) {
            super(permits);
            addTaint(permits);
            // ---------- Original Method ----------
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:14.815 -0400", hash_original_method = "33A8BA33CEB07226CB7C962FD4989C27", hash_generated_method = "65483F80A05953B9CD4974E8A20D26A6")
        protected int tryAcquireShared(int acquires) {
            addTaint(acquires);
for(;;)
            {
                if(hasQueuedPredecessors())                
                {
                int var6BB61E3B7BCE0931DA574D19D1D82C88_119400643 = (-1);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1363814491 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1363814491;
                }
                int available = getState();
                int remaining = available - acquires;
                if(remaining < 0 ||
                    compareAndSetState(available, remaining))                
                {
                int var2626772C17D90CF46BE4FE981FF30AC8_220550019 = (remaining);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1872779316 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1872779316;
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

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:14.815 -0400", hash_original_field = "720AD567BEDC79E1D77C8B979A474E84", hash_generated_field = "7955A4226A8EE675254DC7AB4392270B")

        private static final long serialVersionUID = 2014338818796000944L;
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:14.815 -0400", hash_original_field = "485FF00B97D6568FE4B4890F9F8002C1", hash_generated_field = "B51BFB8167C0871125DF74AE3E8AFF72")

    private static final long serialVersionUID = -3222578661600680210L;
}

