package java.util.concurrent;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.util.concurrent.locks.*;

public class FutureTask<V> implements RunnableFuture<V> {
    private Sync sync;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.672 -0400", hash_original_method = "EBD25CFA864782219EF130D05DE406FC", hash_generated_method = "1D11295510F5CBE552EF8AE04092F8F6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public FutureTask(Callable<V> callable) {
        dsTaint.addTaint(callable.dsTaint);
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        sync = new Sync(callable);
        // ---------- Original Method ----------
        //if (callable == null)
            //throw new NullPointerException();
        //sync = new Sync(callable);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.673 -0400", hash_original_method = "343C63FBFE3927352CC6BAC59E679D87", hash_generated_method = "83416B5B329B6CE27A74EAC65E12B935")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public FutureTask(Runnable runnable, V result) {
        dsTaint.addTaint(result.dsTaint);
        dsTaint.addTaint(runnable.dsTaint);
        sync = new Sync(Executors.callable(runnable, result));
        // ---------- Original Method ----------
        //sync = new Sync(Executors.callable(runnable, result));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.673 -0400", hash_original_method = "87256A2F3BC620B5A65A2DEACA482F4A", hash_generated_method = "9EB3B2D2931C0081F06442317788573B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isCancelled() {
        boolean varDDF49245D95EDA4C2B1E13C2033FD842_1015908381 = (sync.innerIsCancelled());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return sync.innerIsCancelled();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.673 -0400", hash_original_method = "2C3AC011A196BCCAC0E9F76136242F15", hash_generated_method = "F2229A4FA346FDC6238FEB72721BC76D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isDone() {
        boolean var965CDAC5D67CF710B30B4F663C7F54E8_240918929 = (sync.innerIsDone());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return sync.innerIsDone();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.673 -0400", hash_original_method = "88A87863EC7E1056D8FE46146EF894BC", hash_generated_method = "2D1784F258E28882BE880D6879654455")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean cancel(boolean mayInterruptIfRunning) {
        dsTaint.addTaint(mayInterruptIfRunning);
        boolean var773625586E0267E8A3EBBAA24319A7D5_1247459350 = (sync.innerCancel(mayInterruptIfRunning));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return sync.innerCancel(mayInterruptIfRunning);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.674 -0400", hash_original_method = "162C3BFD86443C5C054F309FCD025483", hash_generated_method = "3C6BB2D3DA49AEC13695A0808377B46D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public V get() throws InterruptedException, ExecutionException {
        V varA37DF55902CA2A9336EEECD4675516E6_1621588791 = (sync.innerGet());
        return (V)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return sync.innerGet();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.674 -0400", hash_original_method = "90F54A92EEE05A0240D215CA50ECEC0E", hash_generated_method = "8F90595CCE87DE0958275113BFC23226")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public V get(long timeout, TimeUnit unit) throws InterruptedException, ExecutionException, TimeoutException {
        dsTaint.addTaint(unit.dsTaint);
        dsTaint.addTaint(timeout);
        V varFB22D29AE11F287785E3B1D5ABE0D0BF_835203112 = (sync.innerGet(unit.toNanos(timeout)));
        return (V)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return sync.innerGet(unit.toNanos(timeout));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.674 -0400", hash_original_method = "17876694EB227DDF47ED60F50DDB1AB8", hash_generated_method = "11FDBB8776367F84FB5CD85A1E1E97A9")
    @DSModeled(DSC.SAFE)
    protected void done() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.674 -0400", hash_original_method = "A074A8CE9CED8FEBE8C93AF5A1F30EB2", hash_generated_method = "4C38BC12F93272ABE80B0A3E85BB3133")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected void set(V v) {
        dsTaint.addTaint(v.dsTaint);
        sync.innerSet(v);
        // ---------- Original Method ----------
        //sync.innerSet(v);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.674 -0400", hash_original_method = "FDCD59BD475B14EFA0816CB7C0405257", hash_generated_method = "4BD28096153A4CFFCEF5822215EE7E4F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected void setException(Throwable t) {
        dsTaint.addTaint(t.dsTaint);
        sync.innerSetException(t);
        // ---------- Original Method ----------
        //sync.innerSetException(t);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.675 -0400", hash_original_method = "C774B2E8DA9F32069C4712123B43B6CD", hash_generated_method = "41358DA92AFAAC7C338B8FDD86F6983F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void run() {
        sync.innerRun();
        // ---------- Original Method ----------
        //sync.innerRun();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.675 -0400", hash_original_method = "016A9258BFECCECB9307E0C389EB3A3D", hash_generated_method = "65A7FB532291DD7ADFB3DBFFD9140173")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected boolean runAndReset() {
        boolean varAE2B8B7DE670A1AC39F7189A42A39D82_1065316597 = (sync.innerRunAndReset());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return sync.innerRunAndReset();
    }

    
    private final class Sync extends AbstractQueuedSynchronizer {
        private Callable<V> callable;
        private V result;
        private Throwable exception;
        private volatile Thread runner;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.675 -0400", hash_original_method = "D4E27E5AB3ABB7CBBB62FE148674AC0F", hash_generated_method = "BF9A50AC299CF2066F574B5EE4D633E1")
        @DSModeled(DSC.SAFE)
         Sync(Callable<V> callable) {
            dsTaint.addTaint(callable.dsTaint);
            // ---------- Original Method ----------
            //this.callable = callable;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.675 -0400", hash_original_method = "87EA2642D244DCFE21163D8924915415", hash_generated_method = "316AB18521C93277D77488EF9BA0E3B5")
        @DSModeled(DSC.SAFE)
        private boolean ranOrCancelled(int state) {
            dsTaint.addTaint(state);
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return (state & (RAN | CANCELLED)) != 0;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.676 -0400", hash_original_method = "CB8395C0A8B6CFC4974D10648908BD61", hash_generated_method = "551BB49F5A9D8857307632151B2DCA02")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        protected int tryAcquireShared(int ignore) {
            dsTaint.addTaint(ignore);
            {
                boolean var8BFC5F575698513A7EE323356BA90101_1160872795 = (innerIsDone());
            } //End flattened ternary
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return innerIsDone() ? 1 : -1;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.676 -0400", hash_original_method = "BADEFBD4164CAA2A58BD789F486A58F8", hash_generated_method = "7E016DEEB7B4077078D319244A7AF002")
        @DSModeled(DSC.SAFE)
        protected boolean tryReleaseShared(int ignore) {
            dsTaint.addTaint(ignore);
            runner = null;
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //runner = null;
            //return true;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.676 -0400", hash_original_method = "D8E0DD690F3527605076B5F197BA585A", hash_generated_method = "8998BB6918D44F74CFAEC0F8787CE4CD")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         boolean innerIsCancelled() {
            boolean var8BEF59445BD052803CE0794E87BAA6DD_1395579588 = (getState() == CANCELLED);
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return getState() == CANCELLED;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.676 -0400", hash_original_method = "3CE62A51F6A5DB16A8E43D03725714DF", hash_generated_method = "0FA55A28230932538E21331CD3A85F86")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         boolean innerIsDone() {
            boolean var8999482CA2B0B8CB4140FFAD837B9ECA_929688483 = (ranOrCancelled(getState()) && runner == null);
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return ranOrCancelled(getState()) && runner == null;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.676 -0400", hash_original_method = "E3CC861BC123329FE0CD5116647662CC", hash_generated_method = "3F1551A4AE06816A5C18217CC1D4A2BE")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         V innerGet() throws InterruptedException, ExecutionException {
            acquireSharedInterruptibly(0);
            {
                boolean var243AC7C964630701EBA35884971CFA3E_1834748026 = (getState() == CANCELLED);
                if (DroidSafeAndroidRuntime.control) throw new CancellationException();
            } //End collapsed parenthetic
            if (DroidSafeAndroidRuntime.control) throw new ExecutionException(exception);
            return (V)dsTaint.getTaint();
            // ---------- Original Method ----------
            //acquireSharedInterruptibly(0);
            //if (getState() == CANCELLED)
                //throw new CancellationException();
            //if (exception != null)
                //throw new ExecutionException(exception);
            //return result;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.676 -0400", hash_original_method = "C6C2CADBDD008A3436D4C69E1505E94B", hash_generated_method = "9A820ECAA690211CF480E91E538063D3")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         V innerGet(long nanosTimeout) throws InterruptedException, ExecutionException, TimeoutException {
            dsTaint.addTaint(nanosTimeout);
            {
                boolean var879BFE9597045A774039A7B438000BFA_1873661163 = (!tryAcquireSharedNanos(0, nanosTimeout));
                if (DroidSafeAndroidRuntime.control) throw new TimeoutException();
            } //End collapsed parenthetic
            {
                boolean var243AC7C964630701EBA35884971CFA3E_1051413845 = (getState() == CANCELLED);
                if (DroidSafeAndroidRuntime.control) throw new CancellationException();
            } //End collapsed parenthetic
            if (DroidSafeAndroidRuntime.control) throw new ExecutionException(exception);
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.677 -0400", hash_original_method = "02A830CC89A3607D091CAAFD46553563", hash_generated_method = "77ABE2785031BEA0E721A61ED58DD5DE")
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
                    boolean var02D1A0A0014E5AAB86ABA220F02F24C2_434927823 = (compareAndSetState(s, RAN));
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.677 -0400", hash_original_method = "05A852D9D717B3F2A7ED4890D7DD8417", hash_generated_method = "4D729B2A1A78A7199952B411447A39DD")
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
                    boolean var02D1A0A0014E5AAB86ABA220F02F24C2_651356329 = (compareAndSetState(s, RAN));
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.677 -0400", hash_original_method = "8B39040A94FB4A11910F39A32682A441", hash_generated_method = "DBEAC1382E26FF056EF58BF6F87EC0B4")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         boolean innerCancel(boolean mayInterruptIfRunning) {
            dsTaint.addTaint(mayInterruptIfRunning);
            {
                int s;
                s = getState();
                {
                    boolean var654D8D629DE56FE5E8B24F2A611B22E8_25780004 = (ranOrCancelled(s));
                } //End collapsed parenthetic
                {
                    boolean varF924582CA0B0E32FB2E38FF23994889A_2037979451 = (compareAndSetState(s, CANCELLED));
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.678 -0400", hash_original_method = "98D56FA1D01F6A8481F25F546B1688C1", hash_generated_method = "98BEDC494B9D497DC45D9743B9B14438")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         void innerRun() {
            {
                boolean varBE74B7AD2AE668C01DD4E1031446E56A_1825708668 = (!compareAndSetState(READY, RUNNING));
            } //End collapsed parenthetic
            runner = Thread.currentThread();
            {
                boolean varF5ABBEC647038120E0FB1CB92F8BC93A_2134381308 = (getState() == RUNNING);
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.678 -0400", hash_original_method = "8E960784829E06CF5804B32B20F49AB2", hash_generated_method = "6DA37C6B311C531BE9D2F5B17A14AAF6")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         boolean innerRunAndReset() {
            {
                boolean varBE74B7AD2AE668C01DD4E1031446E56A_240189700 = (!compareAndSetState(READY, RUNNING));
            } //End collapsed parenthetic
            try 
            {
                runner = Thread.currentThread();
                {
                    boolean var83983DFCC8BA2829DC391A1772D9E100_756400575 = (getState() == RUNNING);
                    callable.call();
                } //End collapsed parenthetic
                runner = null;
                boolean varC5BE5D0497CC7CF959738250D8E5A8F5_1006271945 = (compareAndSetState(RUNNING, READY));
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

        
        private static final long serialVersionUID = -7828117401763700385L;
        private static final int READY     = 0;
        private static final int RUNNING   = 1;
        private static final int RAN       = 2;
        private static final int CANCELLED = 4;
    }


    
}

