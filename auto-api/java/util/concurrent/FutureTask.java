package java.util.concurrent;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.util.concurrent.locks.*;

public class FutureTask<V> implements RunnableFuture<V> {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.672 -0400", hash_original_field = "63AD9D34F3503826E5F649AE6B7AC92C", hash_generated_field = "A4B34EF3CE38520839B34A2F06599243")

    private Sync sync;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.673 -0400", hash_original_method = "EBD25CFA864782219EF130D05DE406FC", hash_generated_method = "F9CCAEE3CE02C6E2CE15760453E88CBD")
    public  FutureTask(Callable<V> callable) {
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        sync = new Sync(callable);
        // ---------- Original Method ----------
        //if (callable == null)
            //throw new NullPointerException();
        //sync = new Sync(callable);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.673 -0400", hash_original_method = "343C63FBFE3927352CC6BAC59E679D87", hash_generated_method = "445A2B29F4B296EBE069C195B0BDE12E")
    public  FutureTask(Runnable runnable, V result) {
        sync = new Sync(Executors.callable(runnable, result));
        // ---------- Original Method ----------
        //sync = new Sync(Executors.callable(runnable, result));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.674 -0400", hash_original_method = "87256A2F3BC620B5A65A2DEACA482F4A", hash_generated_method = "F710B656A5176BA755B1D2075DB899D1")
    public boolean isCancelled() {
        boolean varDDF49245D95EDA4C2B1E13C2033FD842_1304751507 = (sync.innerIsCancelled());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1206504709 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1206504709;
        // ---------- Original Method ----------
        //return sync.innerIsCancelled();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.674 -0400", hash_original_method = "2C3AC011A196BCCAC0E9F76136242F15", hash_generated_method = "6B20E7D987E82A85A8874B55C817CA60")
    public boolean isDone() {
        boolean var965CDAC5D67CF710B30B4F663C7F54E8_1921882821 = (sync.innerIsDone());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_557026287 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_557026287;
        // ---------- Original Method ----------
        //return sync.innerIsDone();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.675 -0400", hash_original_method = "88A87863EC7E1056D8FE46146EF894BC", hash_generated_method = "BDD349DD490F123DA7782A72D6591F9A")
    public boolean cancel(boolean mayInterruptIfRunning) {
        boolean var773625586E0267E8A3EBBAA24319A7D5_1729715331 = (sync.innerCancel(mayInterruptIfRunning));
        addTaint(mayInterruptIfRunning);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_377680114 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_377680114;
        // ---------- Original Method ----------
        //return sync.innerCancel(mayInterruptIfRunning);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.675 -0400", hash_original_method = "162C3BFD86443C5C054F309FCD025483", hash_generated_method = "77229B67851B6D5151FA6A9113B28CA5")
    public V get() throws InterruptedException, ExecutionException {
        V varB4EAC82CA7396A68D541C85D26508E83_531250949 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_531250949 = sync.innerGet();
        varB4EAC82CA7396A68D541C85D26508E83_531250949.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_531250949;
        // ---------- Original Method ----------
        //return sync.innerGet();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.689 -0400", hash_original_method = "90F54A92EEE05A0240D215CA50ECEC0E", hash_generated_method = "F14C33EB99BBA87DDD91E361AFCD59D9")
    public V get(long timeout, TimeUnit unit) throws InterruptedException, ExecutionException, TimeoutException {
        V varB4EAC82CA7396A68D541C85D26508E83_715684846 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_715684846 = sync.innerGet(unit.toNanos(timeout));
        addTaint(timeout);
        addTaint(unit.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_715684846.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_715684846;
        // ---------- Original Method ----------
        //return sync.innerGet(unit.toNanos(timeout));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.689 -0400", hash_original_method = "17876694EB227DDF47ED60F50DDB1AB8", hash_generated_method = "11FDBB8776367F84FB5CD85A1E1E97A9")
    protected void done() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.690 -0400", hash_original_method = "A074A8CE9CED8FEBE8C93AF5A1F30EB2", hash_generated_method = "6FA0D62B46A1197E9998FE4CCF0DF3C3")
    protected void set(V v) {
        sync.innerSet(v);
        addTaint(v.getTaint());
        // ---------- Original Method ----------
        //sync.innerSet(v);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.690 -0400", hash_original_method = "FDCD59BD475B14EFA0816CB7C0405257", hash_generated_method = "A7C593348CACBBEB81E8B5C9E8A097B1")
    protected void setException(Throwable t) {
        sync.innerSetException(t);
        addTaint(t.getTaint());
        // ---------- Original Method ----------
        //sync.innerSetException(t);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.690 -0400", hash_original_method = "C774B2E8DA9F32069C4712123B43B6CD", hash_generated_method = "41358DA92AFAAC7C338B8FDD86F6983F")
    public void run() {
        sync.innerRun();
        // ---------- Original Method ----------
        //sync.innerRun();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.691 -0400", hash_original_method = "016A9258BFECCECB9307E0C389EB3A3D", hash_generated_method = "14218F9036DE28B2DFC8F613525A70A5")
    protected boolean runAndReset() {
        boolean varAE2B8B7DE670A1AC39F7189A42A39D82_1807600232 = (sync.innerRunAndReset());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1158907357 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1158907357;
        // ---------- Original Method ----------
        //return sync.innerRunAndReset();
    }

    
    private final class Sync extends AbstractQueuedSynchronizer {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.691 -0400", hash_original_field = "765D2EC94553B7CF4C971E7DFCF0E851", hash_generated_field = "B86134CFEB8FBFA3192E582367273039")

        private Callable<V> callable;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.691 -0400", hash_original_field = "B4A88417B3D0170D754C647C30B7216A", hash_generated_field = "48DD7F9F3DDF2001AA8AEF95D0F84BB9")

        private V result;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.691 -0400", hash_original_field = "42552B1F133F9F8EB406D4F306EA9FD1", hash_generated_field = "3848780C3E4557B7B025FBB998A1DBF6")

        private Throwable exception;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.691 -0400", hash_original_field = "4BAD0B8DD3074CD43F641C2AC22A3571", hash_generated_field = "93A1C41CF6D42E56BD1E63B8EC2F515C")

        private volatile Thread runner;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.691 -0400", hash_original_method = "D4E27E5AB3ABB7CBBB62FE148674AC0F", hash_generated_method = "571EDA94F9E2C606AE2FD2F082453C98")
          Sync(Callable<V> callable) {
            this.callable = callable;
            // ---------- Original Method ----------
            //this.callable = callable;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.692 -0400", hash_original_method = "87EA2642D244DCFE21163D8924915415", hash_generated_method = "15E2BB7ABF2359AEED87ECA894080FB4")
        private boolean ranOrCancelled(int state) {
            addTaint(state);
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_439334336 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_439334336;
            // ---------- Original Method ----------
            //return (state & (RAN | CANCELLED)) != 0;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.711 -0400", hash_original_method = "CB8395C0A8B6CFC4974D10648908BD61", hash_generated_method = "A894CDC82A3E247DDAEFA1E0318542EF")
        protected int tryAcquireShared(int ignore) {
            {
                boolean var8BFC5F575698513A7EE323356BA90101_950994815 = (innerIsDone());
            } //End flattened ternary
            addTaint(ignore);
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1633689325 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1633689325;
            // ---------- Original Method ----------
            //return innerIsDone() ? 1 : -1;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.712 -0400", hash_original_method = "BADEFBD4164CAA2A58BD789F486A58F8", hash_generated_method = "1AE1B8034EEDBAA25C42F8E4100F3E97")
        protected boolean tryReleaseShared(int ignore) {
            runner = null;
            addTaint(ignore);
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2054357339 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_2054357339;
            // ---------- Original Method ----------
            //runner = null;
            //return true;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.712 -0400", hash_original_method = "D8E0DD690F3527605076B5F197BA585A", hash_generated_method = "B9B93C634EB47B13DFCA9C4F31519F97")
         boolean innerIsCancelled() {
            boolean var8BEF59445BD052803CE0794E87BAA6DD_1053578158 = (getState() == CANCELLED);
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1153845537 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1153845537;
            // ---------- Original Method ----------
            //return getState() == CANCELLED;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.713 -0400", hash_original_method = "3CE62A51F6A5DB16A8E43D03725714DF", hash_generated_method = "503FBF2AD0AFA6EDC0948C71BAE90B3F")
         boolean innerIsDone() {
            boolean var8999482CA2B0B8CB4140FFAD837B9ECA_2040152484 = (ranOrCancelled(getState()) && runner == null);
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_495174734 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_495174734;
            // ---------- Original Method ----------
            //return ranOrCancelled(getState()) && runner == null;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.713 -0400", hash_original_method = "E3CC861BC123329FE0CD5116647662CC", hash_generated_method = "22718A82A5E34D540A5A478D3D1314F4")
         V innerGet() throws InterruptedException, ExecutionException {
            V varB4EAC82CA7396A68D541C85D26508E83_366715785 = null; //Variable for return #1
            acquireSharedInterruptibly(0);
            {
                boolean var243AC7C964630701EBA35884971CFA3E_239159460 = (getState() == CANCELLED);
                if (DroidSafeAndroidRuntime.control) throw new CancellationException();
            } //End collapsed parenthetic
            if (DroidSafeAndroidRuntime.control) throw new ExecutionException(exception);
            varB4EAC82CA7396A68D541C85D26508E83_366715785 = result;
            varB4EAC82CA7396A68D541C85D26508E83_366715785.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_366715785;
            // ---------- Original Method ----------
            //acquireSharedInterruptibly(0);
            //if (getState() == CANCELLED)
                //throw new CancellationException();
            //if (exception != null)
                //throw new ExecutionException(exception);
            //return result;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.730 -0400", hash_original_method = "C6C2CADBDD008A3436D4C69E1505E94B", hash_generated_method = "4B0D1A37127046976F70A975DB7C7490")
         V innerGet(long nanosTimeout) throws InterruptedException, ExecutionException, TimeoutException {
            V varB4EAC82CA7396A68D541C85D26508E83_2123476527 = null; //Variable for return #1
            {
                boolean var879BFE9597045A774039A7B438000BFA_753637810 = (!tryAcquireSharedNanos(0, nanosTimeout));
                if (DroidSafeAndroidRuntime.control) throw new TimeoutException();
            } //End collapsed parenthetic
            {
                boolean var243AC7C964630701EBA35884971CFA3E_931622741 = (getState() == CANCELLED);
                if (DroidSafeAndroidRuntime.control) throw new CancellationException();
            } //End collapsed parenthetic
            if (DroidSafeAndroidRuntime.control) throw new ExecutionException(exception);
            varB4EAC82CA7396A68D541C85D26508E83_2123476527 = result;
            addTaint(nanosTimeout);
            varB4EAC82CA7396A68D541C85D26508E83_2123476527.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_2123476527;
            // ---------- Original Method ----------
            //if (!tryAcquireSharedNanos(0, nanosTimeout))
                //throw new TimeoutException();
            //if (getState() == CANCELLED)
                //throw new CancellationException();
            //if (exception != null)
                //throw new ExecutionException(exception);
            //return result;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.731 -0400", hash_original_method = "02A830CC89A3607D091CAAFD46553563", hash_generated_method = "756F98EDD0ECEABE7436936E047033BE")
         void innerSet(V v) {
            {
                int s;
                s = getState();
                {
                    releaseShared(0);
                } //End block
                {
                    boolean var02D1A0A0014E5AAB86ABA220F02F24C2_158036330 = (compareAndSetState(s, RAN));
                    {
                        result = v;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.732 -0400", hash_original_method = "05A852D9D717B3F2A7ED4890D7DD8417", hash_generated_method = "DD1A75589139DBC34AA69B5E1C6F4E19")
         void innerSetException(Throwable t) {
            {
                int s;
                s = getState();
                {
                    releaseShared(0);
                } //End block
                {
                    boolean var02D1A0A0014E5AAB86ABA220F02F24C2_802287004 = (compareAndSetState(s, RAN));
                    {
                        exception = t;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.732 -0400", hash_original_method = "8B39040A94FB4A11910F39A32682A441", hash_generated_method = "C485EF6D3B86BEA319F56C6E682354B2")
         boolean innerCancel(boolean mayInterruptIfRunning) {
            {
                int s;
                s = getState();
                {
                    boolean var654D8D629DE56FE5E8B24F2A611B22E8_2097352876 = (ranOrCancelled(s));
                } //End collapsed parenthetic
                {
                    boolean varF924582CA0B0E32FB2E38FF23994889A_408151605 = (compareAndSetState(s, CANCELLED));
                } //End collapsed parenthetic
            } //End block
            {
                Thread r;
                r = runner;
                r.interrupt();
            } //End block
            releaseShared(0);
            done();
            addTaint(mayInterruptIfRunning);
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1583220764 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1583220764;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.733 -0400", hash_original_method = "98D56FA1D01F6A8481F25F546B1688C1", hash_generated_method = "DB41CC0C2F79B361F8599DF506A5ABC7")
         void innerRun() {
            {
                boolean varBE74B7AD2AE668C01DD4E1031446E56A_1566150190 = (!compareAndSetState(READY, RUNNING));
            } //End collapsed parenthetic
            runner = Thread.currentThread();
            {
                boolean varF5ABBEC647038120E0FB1CB92F8BC93A_757567971 = (getState() == RUNNING);
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.733 -0400", hash_original_method = "8E960784829E06CF5804B32B20F49AB2", hash_generated_method = "84FEBC4866E08D48BA17D286373B4C5C")
         boolean innerRunAndReset() {
            {
                boolean varBE74B7AD2AE668C01DD4E1031446E56A_997228671 = (!compareAndSetState(READY, RUNNING));
            } //End collapsed parenthetic
            try 
            {
                runner = Thread.currentThread();
                {
                    boolean var83983DFCC8BA2829DC391A1772D9E100_1497329141 = (getState() == RUNNING);
                    callable.call();
                } //End collapsed parenthetic
                runner = null;
                boolean varC5BE5D0497CC7CF959738250D8E5A8F5_503122295 = (compareAndSetState(RUNNING, READY));
            } //End block
            catch (Throwable ex)
            {
                setException(ex);
            } //End block
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_458991833 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_458991833;
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

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.734 -0400", hash_original_field = "3BC169E14F9F21C778FF7675E886E329", hash_generated_field = "E54DD01DBD253BB8070166B10FA9CE19")

        private static long serialVersionUID = -7828117401763700385L;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.734 -0400", hash_original_field = "C7C7980D5941588A0F784DFB73417B5E", hash_generated_field = "E810EA9B3A19B18D0D8775390287EE54")

        private static int READY = 0;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.734 -0400", hash_original_field = "09ED90A5D5CB9DD6E407B61EA7B9DA2B", hash_generated_field = "D0CB5651282B6EFF94FE72CC6DE492A0")

        private static int RUNNING = 1;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.734 -0400", hash_original_field = "9BE927E22379F613E02A376142663CB6", hash_generated_field = "F6FD8D37478A75FBBF2322C791D17A47")

        private static int RAN = 2;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.734 -0400", hash_original_field = "3BB93A5F6E438EA604AD3BA36C8B338D", hash_generated_field = "94D2A39AC585B130314A42CF907109A9")

        private static int CANCELLED = 4;
    }


    
}

