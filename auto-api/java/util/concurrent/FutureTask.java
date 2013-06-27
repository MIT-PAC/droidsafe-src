package java.util.concurrent;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.util.concurrent.locks.*;

public class FutureTask<V> implements RunnableFuture<V> {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.539 -0400", hash_original_field = "63AD9D34F3503826E5F649AE6B7AC92C", hash_generated_field = "A4B34EF3CE38520839B34A2F06599243")

    private Sync sync;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.539 -0400", hash_original_method = "EBD25CFA864782219EF130D05DE406FC", hash_generated_method = "F9CCAEE3CE02C6E2CE15760453E88CBD")
    public  FutureTask(Callable<V> callable) {
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        sync = new Sync(callable);
        // ---------- Original Method ----------
        //if (callable == null)
            //throw new NullPointerException();
        //sync = new Sync(callable);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.541 -0400", hash_original_method = "343C63FBFE3927352CC6BAC59E679D87", hash_generated_method = "445A2B29F4B296EBE069C195B0BDE12E")
    public  FutureTask(Runnable runnable, V result) {
        sync = new Sync(Executors.callable(runnable, result));
        // ---------- Original Method ----------
        //sync = new Sync(Executors.callable(runnable, result));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.541 -0400", hash_original_method = "87256A2F3BC620B5A65A2DEACA482F4A", hash_generated_method = "7577D933899B28780C3BCD4A4C1A203D")
    public boolean isCancelled() {
        boolean varDDF49245D95EDA4C2B1E13C2033FD842_1941185929 = (sync.innerIsCancelled());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2052262797 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2052262797;
        // ---------- Original Method ----------
        //return sync.innerIsCancelled();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.555 -0400", hash_original_method = "2C3AC011A196BCCAC0E9F76136242F15", hash_generated_method = "1FA889DF4E0888372E437D13EB6BFC88")
    public boolean isDone() {
        boolean var965CDAC5D67CF710B30B4F663C7F54E8_1721138384 = (sync.innerIsDone());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_97649874 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_97649874;
        // ---------- Original Method ----------
        //return sync.innerIsDone();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.572 -0400", hash_original_method = "88A87863EC7E1056D8FE46146EF894BC", hash_generated_method = "42AA4C97FB2F1836DD3231F9DD69C01A")
    public boolean cancel(boolean mayInterruptIfRunning) {
        boolean var773625586E0267E8A3EBBAA24319A7D5_1595672462 = (sync.innerCancel(mayInterruptIfRunning));
        addTaint(mayInterruptIfRunning);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1630060043 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1630060043;
        // ---------- Original Method ----------
        //return sync.innerCancel(mayInterruptIfRunning);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.573 -0400", hash_original_method = "162C3BFD86443C5C054F309FCD025483", hash_generated_method = "FEBF94143C809CF75A7C0B9763501529")
    public V get() throws InterruptedException, ExecutionException {
        V varB4EAC82CA7396A68D541C85D26508E83_1873918303 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1873918303 = sync.innerGet();
        varB4EAC82CA7396A68D541C85D26508E83_1873918303.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1873918303;
        // ---------- Original Method ----------
        //return sync.innerGet();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.573 -0400", hash_original_method = "90F54A92EEE05A0240D215CA50ECEC0E", hash_generated_method = "04319C922F18EA7CADF596978F8F9C9A")
    public V get(long timeout, TimeUnit unit) throws InterruptedException, ExecutionException, TimeoutException {
        V varB4EAC82CA7396A68D541C85D26508E83_1694793630 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1694793630 = sync.innerGet(unit.toNanos(timeout));
        addTaint(timeout);
        addTaint(unit.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1694793630.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1694793630;
        // ---------- Original Method ----------
        //return sync.innerGet(unit.toNanos(timeout));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.573 -0400", hash_original_method = "17876694EB227DDF47ED60F50DDB1AB8", hash_generated_method = "11FDBB8776367F84FB5CD85A1E1E97A9")
    protected void done() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.573 -0400", hash_original_method = "A074A8CE9CED8FEBE8C93AF5A1F30EB2", hash_generated_method = "6FA0D62B46A1197E9998FE4CCF0DF3C3")
    protected void set(V v) {
        sync.innerSet(v);
        addTaint(v.getTaint());
        // ---------- Original Method ----------
        //sync.innerSet(v);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.574 -0400", hash_original_method = "FDCD59BD475B14EFA0816CB7C0405257", hash_generated_method = "A7C593348CACBBEB81E8B5C9E8A097B1")
    protected void setException(Throwable t) {
        sync.innerSetException(t);
        addTaint(t.getTaint());
        // ---------- Original Method ----------
        //sync.innerSetException(t);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.574 -0400", hash_original_method = "C774B2E8DA9F32069C4712123B43B6CD", hash_generated_method = "41358DA92AFAAC7C338B8FDD86F6983F")
    public void run() {
        sync.innerRun();
        // ---------- Original Method ----------
        //sync.innerRun();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.574 -0400", hash_original_method = "016A9258BFECCECB9307E0C389EB3A3D", hash_generated_method = "F0980C15DA2D204902555155C0418540")
    protected boolean runAndReset() {
        boolean varAE2B8B7DE670A1AC39F7189A42A39D82_1610527111 = (sync.innerRunAndReset());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_931771154 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_931771154;
        // ---------- Original Method ----------
        //return sync.innerRunAndReset();
    }

    
    private final class Sync extends AbstractQueuedSynchronizer {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.574 -0400", hash_original_field = "765D2EC94553B7CF4C971E7DFCF0E851", hash_generated_field = "B86134CFEB8FBFA3192E582367273039")

        private Callable<V> callable;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.574 -0400", hash_original_field = "B4A88417B3D0170D754C647C30B7216A", hash_generated_field = "48DD7F9F3DDF2001AA8AEF95D0F84BB9")

        private V result;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.574 -0400", hash_original_field = "42552B1F133F9F8EB406D4F306EA9FD1", hash_generated_field = "3848780C3E4557B7B025FBB998A1DBF6")

        private Throwable exception;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.574 -0400", hash_original_field = "4BAD0B8DD3074CD43F641C2AC22A3571", hash_generated_field = "93A1C41CF6D42E56BD1E63B8EC2F515C")

        private volatile Thread runner;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.575 -0400", hash_original_method = "D4E27E5AB3ABB7CBBB62FE148674AC0F", hash_generated_method = "571EDA94F9E2C606AE2FD2F082453C98")
          Sync(Callable<V> callable) {
            this.callable = callable;
            // ---------- Original Method ----------
            //this.callable = callable;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.587 -0400", hash_original_method = "87EA2642D244DCFE21163D8924915415", hash_generated_method = "45D7DB5976ED7184A4FD6959F846416E")
        private boolean ranOrCancelled(int state) {
            addTaint(state);
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_303353039 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_303353039;
            // ---------- Original Method ----------
            //return (state & (RAN | CANCELLED)) != 0;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.588 -0400", hash_original_method = "CB8395C0A8B6CFC4974D10648908BD61", hash_generated_method = "AFBA68BC4624EDEEE292C8601B1B94E2")
        protected int tryAcquireShared(int ignore) {
            {
                boolean var8BFC5F575698513A7EE323356BA90101_420228212 = (innerIsDone());
            } //End flattened ternary
            addTaint(ignore);
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2016004655 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2016004655;
            // ---------- Original Method ----------
            //return innerIsDone() ? 1 : -1;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.590 -0400", hash_original_method = "BADEFBD4164CAA2A58BD789F486A58F8", hash_generated_method = "C4E8F99A7C50C80CA9F77704FBE14079")
        protected boolean tryReleaseShared(int ignore) {
            runner = null;
            addTaint(ignore);
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1309132723 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1309132723;
            // ---------- Original Method ----------
            //runner = null;
            //return true;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.591 -0400", hash_original_method = "D8E0DD690F3527605076B5F197BA585A", hash_generated_method = "84129145140E18C2589547E901FF3A37")
         boolean innerIsCancelled() {
            boolean var8BEF59445BD052803CE0794E87BAA6DD_1861599324 = (getState() == CANCELLED);
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1218862094 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1218862094;
            // ---------- Original Method ----------
            //return getState() == CANCELLED;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.591 -0400", hash_original_method = "3CE62A51F6A5DB16A8E43D03725714DF", hash_generated_method = "BC01398E56674F58C98EB5ED2A2DF5F2")
         boolean innerIsDone() {
            boolean var8999482CA2B0B8CB4140FFAD837B9ECA_282880032 = (ranOrCancelled(getState()) && runner == null);
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_433815981 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_433815981;
            // ---------- Original Method ----------
            //return ranOrCancelled(getState()) && runner == null;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.630 -0400", hash_original_method = "E3CC861BC123329FE0CD5116647662CC", hash_generated_method = "6F4F789BD278B4A978FD4A097DC35047")
         V innerGet() throws InterruptedException, ExecutionException {
            V varB4EAC82CA7396A68D541C85D26508E83_1662840962 = null; //Variable for return #1
            acquireSharedInterruptibly(0);
            {
                boolean var243AC7C964630701EBA35884971CFA3E_1567338331 = (getState() == CANCELLED);
                if (DroidSafeAndroidRuntime.control) throw new CancellationException();
            } //End collapsed parenthetic
            if (DroidSafeAndroidRuntime.control) throw new ExecutionException(exception);
            varB4EAC82CA7396A68D541C85D26508E83_1662840962 = result;
            varB4EAC82CA7396A68D541C85D26508E83_1662840962.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1662840962;
            // ---------- Original Method ----------
            //acquireSharedInterruptibly(0);
            //if (getState() == CANCELLED)
                //throw new CancellationException();
            //if (exception != null)
                //throw new ExecutionException(exception);
            //return result;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.631 -0400", hash_original_method = "C6C2CADBDD008A3436D4C69E1505E94B", hash_generated_method = "5CF03D67300456235996764F10831F86")
         V innerGet(long nanosTimeout) throws InterruptedException, ExecutionException, TimeoutException {
            V varB4EAC82CA7396A68D541C85D26508E83_664815936 = null; //Variable for return #1
            {
                boolean var879BFE9597045A774039A7B438000BFA_1440189139 = (!tryAcquireSharedNanos(0, nanosTimeout));
                if (DroidSafeAndroidRuntime.control) throw new TimeoutException();
            } //End collapsed parenthetic
            {
                boolean var243AC7C964630701EBA35884971CFA3E_1181929079 = (getState() == CANCELLED);
                if (DroidSafeAndroidRuntime.control) throw new CancellationException();
            } //End collapsed parenthetic
            if (DroidSafeAndroidRuntime.control) throw new ExecutionException(exception);
            varB4EAC82CA7396A68D541C85D26508E83_664815936 = result;
            addTaint(nanosTimeout);
            varB4EAC82CA7396A68D541C85D26508E83_664815936.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_664815936;
            // ---------- Original Method ----------
            //if (!tryAcquireSharedNanos(0, nanosTimeout))
                //throw new TimeoutException();
            //if (getState() == CANCELLED)
                //throw new CancellationException();
            //if (exception != null)
                //throw new ExecutionException(exception);
            //return result;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.631 -0400", hash_original_method = "02A830CC89A3607D091CAAFD46553563", hash_generated_method = "02B12B4EC375A6DDEF727607CBFF53F5")
         void innerSet(V v) {
            {
                int s;
                s = getState();
                {
                    releaseShared(0);
                } //End block
                {
                    boolean var02D1A0A0014E5AAB86ABA220F02F24C2_30597052 = (compareAndSetState(s, RAN));
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.632 -0400", hash_original_method = "05A852D9D717B3F2A7ED4890D7DD8417", hash_generated_method = "C2E638B728CDF5D9D29F8CF42025DFC7")
         void innerSetException(Throwable t) {
            {
                int s;
                s = getState();
                {
                    releaseShared(0);
                } //End block
                {
                    boolean var02D1A0A0014E5AAB86ABA220F02F24C2_1323372428 = (compareAndSetState(s, RAN));
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.632 -0400", hash_original_method = "8B39040A94FB4A11910F39A32682A441", hash_generated_method = "6B3010A2050A1F1FD6684AE126C1C8B5")
         boolean innerCancel(boolean mayInterruptIfRunning) {
            {
                int s;
                s = getState();
                {
                    boolean var654D8D629DE56FE5E8B24F2A611B22E8_1800838187 = (ranOrCancelled(s));
                } //End collapsed parenthetic
                {
                    boolean varF924582CA0B0E32FB2E38FF23994889A_1068297816 = (compareAndSetState(s, CANCELLED));
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
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1720668716 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1720668716;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.633 -0400", hash_original_method = "98D56FA1D01F6A8481F25F546B1688C1", hash_generated_method = "DD40D258A39C56E60F3CCE9139E3A229")
         void innerRun() {
            {
                boolean varBE74B7AD2AE668C01DD4E1031446E56A_833926595 = (!compareAndSetState(READY, RUNNING));
            } //End collapsed parenthetic
            runner = Thread.currentThread();
            {
                boolean varF5ABBEC647038120E0FB1CB92F8BC93A_1463175384 = (getState() == RUNNING);
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.642 -0400", hash_original_method = "8E960784829E06CF5804B32B20F49AB2", hash_generated_method = "F6951C8F4B00F3E181573589C3A9F6F0")
         boolean innerRunAndReset() {
            {
                boolean varBE74B7AD2AE668C01DD4E1031446E56A_804667240 = (!compareAndSetState(READY, RUNNING));
            } //End collapsed parenthetic
            try 
            {
                runner = Thread.currentThread();
                {
                    boolean var83983DFCC8BA2829DC391A1772D9E100_1557940512 = (getState() == RUNNING);
                    callable.call();
                } //End collapsed parenthetic
                runner = null;
                boolean varC5BE5D0497CC7CF959738250D8E5A8F5_1508170336 = (compareAndSetState(RUNNING, READY));
            } //End block
            catch (Throwable ex)
            {
                setException(ex);
            } //End block
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1597921116 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1597921116;
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

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.643 -0400", hash_original_field = "3BC169E14F9F21C778FF7675E886E329", hash_generated_field = "E54DD01DBD253BB8070166B10FA9CE19")

        private static long serialVersionUID = -7828117401763700385L;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.643 -0400", hash_original_field = "C7C7980D5941588A0F784DFB73417B5E", hash_generated_field = "E810EA9B3A19B18D0D8775390287EE54")

        private static int READY = 0;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.643 -0400", hash_original_field = "09ED90A5D5CB9DD6E407B61EA7B9DA2B", hash_generated_field = "D0CB5651282B6EFF94FE72CC6DE492A0")

        private static int RUNNING = 1;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.643 -0400", hash_original_field = "9BE927E22379F613E02A376142663CB6", hash_generated_field = "F6FD8D37478A75FBBF2322C791D17A47")

        private static int RAN = 2;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.643 -0400", hash_original_field = "3BB93A5F6E438EA604AD3BA36C8B338D", hash_generated_field = "94D2A39AC585B130314A42CF907109A9")

        private static int CANCELLED = 4;
    }


    
}

