package java.util.concurrent;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import java.util.concurrent.locks.*;

public class FutureTask<V> implements RunnableFuture<V> {
    private final Sync sync;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.976 -0400", hash_original_method = "EBD25CFA864782219EF130D05DE406FC", hash_generated_method = "FE7ED1936261672214616B5E0DED382E")
    @DSModeled(DSC.SAFE)
    public FutureTask(Callable<V> callable) {
        dsTaint.addTaint(callable.dsTaint);
        throw new NullPointerException();
        sync = new Sync(callable);
        // ---------- Original Method ----------
        //if (callable == null)
            //throw new NullPointerException();
        //sync = new Sync(callable);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.976 -0400", hash_original_method = "343C63FBFE3927352CC6BAC59E679D87", hash_generated_method = "2CCB9268D56C5048A23CC4B55B195BDF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public FutureTask(Runnable runnable, V result) {
        dsTaint.addTaint(result.dsTaint);
        dsTaint.addTaint(runnable.dsTaint);
        sync = new Sync(Executors.callable(runnable, result));
        // ---------- Original Method ----------
        //sync = new Sync(Executors.callable(runnable, result));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.976 -0400", hash_original_method = "87256A2F3BC620B5A65A2DEACA482F4A", hash_generated_method = "C2DF4C008D1DE6B860EBFF2726A59E5E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isCancelled() {
        boolean varDDF49245D95EDA4C2B1E13C2033FD842_1404837615 = (sync.innerIsCancelled());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return sync.innerIsCancelled();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.977 -0400", hash_original_method = "2C3AC011A196BCCAC0E9F76136242F15", hash_generated_method = "368FD518244B3FE178E90C843676DBC5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isDone() {
        boolean var965CDAC5D67CF710B30B4F663C7F54E8_460976444 = (sync.innerIsDone());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return sync.innerIsDone();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.977 -0400", hash_original_method = "88A87863EC7E1056D8FE46146EF894BC", hash_generated_method = "C8CD69D12AAD6E9C2D38274962E56466")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean cancel(boolean mayInterruptIfRunning) {
        dsTaint.addTaint(mayInterruptIfRunning);
        boolean var773625586E0267E8A3EBBAA24319A7D5_1890492519 = (sync.innerCancel(mayInterruptIfRunning));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return sync.innerCancel(mayInterruptIfRunning);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.977 -0400", hash_original_method = "162C3BFD86443C5C054F309FCD025483", hash_generated_method = "3A07675450A570DD9CF70A39077F9801")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public V get() throws InterruptedException, ExecutionException {
        V varA37DF55902CA2A9336EEECD4675516E6_691315880 = (sync.innerGet());
        return (V)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return sync.innerGet();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.977 -0400", hash_original_method = "90F54A92EEE05A0240D215CA50ECEC0E", hash_generated_method = "59C2A97C94713AD8FC29766D3D5AFAB4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public V get(long timeout, TimeUnit unit) throws InterruptedException, ExecutionException, TimeoutException {
        dsTaint.addTaint(unit.dsTaint);
        dsTaint.addTaint(timeout);
        V varFB22D29AE11F287785E3B1D5ABE0D0BF_1888186868 = (sync.innerGet(unit.toNanos(timeout)));
        return (V)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return sync.innerGet(unit.toNanos(timeout));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.977 -0400", hash_original_method = "17876694EB227DDF47ED60F50DDB1AB8", hash_generated_method = "C94091D02744CCCC52E849681F4DC90A")
    @DSModeled(DSC.SAFE)
    protected void done() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.977 -0400", hash_original_method = "A074A8CE9CED8FEBE8C93AF5A1F30EB2", hash_generated_method = "4AB6D33C5B5E0F3AAA23DAD4B2C2353E")
    @DSModeled(DSC.SAFE)
    protected void set(V v) {
        dsTaint.addTaint(v.dsTaint);
        sync.innerSet(v);
        // ---------- Original Method ----------
        //sync.innerSet(v);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.977 -0400", hash_original_method = "FDCD59BD475B14EFA0816CB7C0405257", hash_generated_method = "F831A11D671E3A7AB29A81D423D6BFFA")
    @DSModeled(DSC.SAFE)
    protected void setException(Throwable t) {
        dsTaint.addTaint(t.dsTaint);
        sync.innerSetException(t);
        // ---------- Original Method ----------
        //sync.innerSetException(t);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.977 -0400", hash_original_method = "C774B2E8DA9F32069C4712123B43B6CD", hash_generated_method = "CBF83DBDB3543F2501A1E7995AA3ED4F")
    @DSModeled(DSC.SAFE)
    public void run() {
        sync.innerRun();
        // ---------- Original Method ----------
        //sync.innerRun();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.977 -0400", hash_original_method = "016A9258BFECCECB9307E0C389EB3A3D", hash_generated_method = "0FE204AE7EE08CB11FF1CAAAF9D5951A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected boolean runAndReset() {
        boolean varAE2B8B7DE670A1AC39F7189A42A39D82_324266341 = (sync.innerRunAndReset());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return sync.innerRunAndReset();
    }

    
    private final class Sync extends AbstractQueuedSynchronizer {
        private static final long serialVersionUID = -7828117401763700385L;
        private static final int READY     = 0;
        private static final int RUNNING   = 1;
        private static final int RAN       = 2;
        private static final int CANCELLED = 4;
        private final Callable<V> callable;
        private V result;
        private Throwable exception;
        private volatile Thread runner;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.977 -0400", hash_original_method = "D4E27E5AB3ABB7CBBB62FE148674AC0F", hash_generated_method = "D33E86B5CE5EF254E391312705405D24")
        @DSModeled(DSC.SAFE)
         Sync(Callable<V> callable) {
            dsTaint.addTaint(callable.dsTaint);
            // ---------- Original Method ----------
            //this.callable = callable;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.977 -0400", hash_original_method = "87EA2642D244DCFE21163D8924915415", hash_generated_method = "30212D4C56553DF31A7CC3EFF42BC762")
        @DSModeled(DSC.SAFE)
        private boolean ranOrCancelled(int state) {
            dsTaint.addTaint(state);
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return (state & (RAN | CANCELLED)) != 0;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.977 -0400", hash_original_method = "CB8395C0A8B6CFC4974D10648908BD61", hash_generated_method = "20E3B279FECE8B97128A53242C0F00FB")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        protected int tryAcquireShared(int ignore) {
            dsTaint.addTaint(ignore);
            {
                boolean var8BFC5F575698513A7EE323356BA90101_1824379819 = (innerIsDone());
            } //End flattened ternary
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return innerIsDone() ? 1 : -1;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.977 -0400", hash_original_method = "BADEFBD4164CAA2A58BD789F486A58F8", hash_generated_method = "09D995DEAE901778191B6C99C3A5EAAC")
        @DSModeled(DSC.SAFE)
        protected boolean tryReleaseShared(int ignore) {
            dsTaint.addTaint(ignore);
            runner = null;
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //runner = null;
            //return true;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.977 -0400", hash_original_method = "D8E0DD690F3527605076B5F197BA585A", hash_generated_method = "9FF02582E70FF3414CEFC786B86EB6F1")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         boolean innerIsCancelled() {
            boolean var8BEF59445BD052803CE0794E87BAA6DD_840266624 = (getState() == CANCELLED);
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return getState() == CANCELLED;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.977 -0400", hash_original_method = "3CE62A51F6A5DB16A8E43D03725714DF", hash_generated_method = "F0E58CD2D425A5D4ADE4CA6EBB1B2A11")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         boolean innerIsDone() {
            boolean var8999482CA2B0B8CB4140FFAD837B9ECA_993714475 = (ranOrCancelled(getState()) && runner == null);
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return ranOrCancelled(getState()) && runner == null;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.977 -0400", hash_original_method = "E3CC861BC123329FE0CD5116647662CC", hash_generated_method = "3F7197A30F1CD7462AE491210166A22D")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         V innerGet() throws InterruptedException, ExecutionException {
            acquireSharedInterruptibly(0);
            {
                boolean var243AC7C964630701EBA35884971CFA3E_342409577 = (getState() == CANCELLED);
                throw new CancellationException();
            } //End collapsed parenthetic
            throw new ExecutionException(exception);
            return (V)dsTaint.getTaint();
            // ---------- Original Method ----------
            //acquireSharedInterruptibly(0);
            //if (getState() == CANCELLED)
                //throw new CancellationException();
            //if (exception != null)
                //throw new ExecutionException(exception);
            //return result;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.977 -0400", hash_original_method = "C6C2CADBDD008A3436D4C69E1505E94B", hash_generated_method = "D8B0F87A25F7149FADAAAB24CCE7F917")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         V innerGet(long nanosTimeout) throws InterruptedException, ExecutionException, TimeoutException {
            dsTaint.addTaint(nanosTimeout);
            {
                boolean var879BFE9597045A774039A7B438000BFA_423600115 = (!tryAcquireSharedNanos(0, nanosTimeout));
                throw new TimeoutException();
            } //End collapsed parenthetic
            {
                boolean var243AC7C964630701EBA35884971CFA3E_2040515691 = (getState() == CANCELLED);
                throw new CancellationException();
            } //End collapsed parenthetic
            throw new ExecutionException(exception);
            return (V)dsTaint.getTaint();
            // ---------- Original Method ----------
            //if (!tryAcquireSharedNanos(0, nanosTimeout))
                //throw new TimeoutException();
            //if (getState() == CANCELLED)
                //throw new CancellationException();
            //if (exception != null)
                //throw new ExecutionException(exception);
            //return result;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.978 -0400", hash_original_method = "02A830CC89A3607D091CAAFD46553563", hash_generated_method = "C9DCF981E2647F4284641A6FA10E9682")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         void innerSet(V v) {
            dsTaint.addTaint(v.dsTaint);
            {
                int s;
                s = getState();
                {
                    releaseShared(0);
                } //End block
                {
                    boolean var02D1A0A0014E5AAB86ABA220F02F24C2_2138868007 = (compareAndSetState(s, RAN));
                    {
                        releaseShared(0);
                        done();
                    } //End block
                } //End collapsed parenthetic
            } //End block
            // ---------- Original Method ----------
            //for (;;) {
                //int s = getState();
                //if (s == RAN)
                    //return;
                //if (s == CANCELLED) {
                    //releaseShared(0);
                    //return;
                //}
                //if (compareAndSetState(s, RAN)) {
                    //result = v;
                    //releaseShared(0);
                    //done();
                    //return;
                //}
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.978 -0400", hash_original_method = "05A852D9D717B3F2A7ED4890D7DD8417", hash_generated_method = "33F33917A895E34A1BA48085B460F502")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         void innerSetException(Throwable t) {
            dsTaint.addTaint(t.dsTaint);
            {
                int s;
                s = getState();
                {
                    releaseShared(0);
                } //End block
                {
                    boolean var02D1A0A0014E5AAB86ABA220F02F24C2_813061237 = (compareAndSetState(s, RAN));
                    {
                        releaseShared(0);
                        done();
                    } //End block
                } //End collapsed parenthetic
            } //End block
            // ---------- Original Method ----------
            //for (;;) {
                //int s = getState();
                //if (s == RAN)
                    //return;
                //if (s == CANCELLED) {
                    //releaseShared(0);
                    //return;
                //}
                //if (compareAndSetState(s, RAN)) {
                    //exception = t;
                    //releaseShared(0);
                    //done();
                    //return;
                //}
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.978 -0400", hash_original_method = "8B39040A94FB4A11910F39A32682A441", hash_generated_method = "87EB91ABE5A01B38E4D7FA4C40867C54")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         boolean innerCancel(boolean mayInterruptIfRunning) {
            dsTaint.addTaint(mayInterruptIfRunning);
            {
                int s;
                s = getState();
                {
                    boolean var654D8D629DE56FE5E8B24F2A611B22E8_1702681702 = (ranOrCancelled(s));
                } //End collapsed parenthetic
                {
                    boolean varF924582CA0B0E32FB2E38FF23994889A_906997780 = (compareAndSetState(s, CANCELLED));
                } //End collapsed parenthetic
            } //End block
            {
                Thread r;
                r = runner;
                r.interrupt();
            } //End block
            releaseShared(0);
            done();
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //for (;;) {
                //int s = getState();
                //if (ranOrCancelled(s))
                    //return false;
                //if (compareAndSetState(s, CANCELLED))
                    //break;
            //}
            //if (mayInterruptIfRunning) {
                //Thread r = runner;
                //if (r != null)
                    //r.interrupt();
            //}
            //releaseShared(0);
            //done();
            //return true;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.978 -0400", hash_original_method = "98D56FA1D01F6A8481F25F546B1688C1", hash_generated_method = "4DC10EB9745B574E8E94E7B5EBA6D647")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         void innerRun() {
            {
                boolean varBE74B7AD2AE668C01DD4E1031446E56A_1155748810 = (!compareAndSetState(READY, RUNNING));
            } //End collapsed parenthetic
            runner = Thread.currentThread();
            {
                boolean varF5ABBEC647038120E0FB1CB92F8BC93A_9999473 = (getState() == RUNNING);
                {
                    V result;
                    try 
                    {
                        result = callable.call();
                    } //End block
                    catch (Throwable ex)
                    {
                        setException(ex);
                    } //End block
                    set(result);
                } //End block
                {
                    releaseShared(0);
                } //End block
            } //End collapsed parenthetic
            // ---------- Original Method ----------
            //if (!compareAndSetState(READY, RUNNING))
                //return;
            //runner = Thread.currentThread();
            //if (getState() == RUNNING) { 
                //V result;
                //try {
                    //result = callable.call();
                //} catch (Throwable ex) {
                    //setException(ex);
                    //return;
                //}
                //set(result);
            //} else {
                //releaseShared(0); 
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.978 -0400", hash_original_method = "8E960784829E06CF5804B32B20F49AB2", hash_generated_method = "E64BB094E0BF1D6467847E20249FFBB0")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         boolean innerRunAndReset() {
            {
                boolean varBE74B7AD2AE668C01DD4E1031446E56A_144547701 = (!compareAndSetState(READY, RUNNING));
            } //End collapsed parenthetic
            try 
            {
                runner = Thread.currentThread();
                {
                    boolean var83983DFCC8BA2829DC391A1772D9E100_96075430 = (getState() == RUNNING);
                    callable.call();
                } //End collapsed parenthetic
                runner = null;
                boolean varC5BE5D0497CC7CF959738250D8E5A8F5_1579439340 = (compareAndSetState(RUNNING, READY));
            } //End block
            catch (Throwable ex)
            {
                setException(ex);
            } //End block
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //if (!compareAndSetState(READY, RUNNING))
                //return false;
            //try {
                //runner = Thread.currentThread();
                //if (getState() == RUNNING)
                    //callable.call(); 
                //runner = null;
                //return compareAndSetState(RUNNING, READY);
            //} catch (Throwable ex) {
                //setException(ex);
                //return false;
            //}
        }

        
    }


    
}


